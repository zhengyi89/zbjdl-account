package com.zbjdl.account.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.zbjdl.common.httpclient.HttpClientUtil;
import com.zbjdl.common.httpclient.MethodType;
import com.zbjdl.common.json.JsonMapper;


public class HttpUtil {
	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	public static int connectTimeOut = 30000;
	public static int readDataTimeOut = 30000;
	
	/**
	 * 执行HTTP GET方法，返回字符串
	 *
	 * @param connectTimeOut
	 * @param readDataTimeOut
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public static String executeGet(String url, Map<String, String> params)
			throws IOException {

		StringBuffer urlBuffer = new StringBuffer(url);

		boolean flag = url.contains("?");
		if (params != null) {
			for (String key : params.keySet()) {
				String value = params.get(key);
				if (StringUtils.isEmpty(value))
					continue;
				if (flag) {
					urlBuffer.append("&");
				} else {
					urlBuffer.append("?");
					flag = true;
				}
				urlBuffer.append(key).append("=").append(URLEncoder.encode(params.get(key), "UTF-8"));
			}
		}

		HttpClient httpClient = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(connectTimeOut)
				.setConnectionRequestTimeout(readDataTimeOut).build();
		HttpGet httpGet = new HttpGet(urlBuffer.toString());

		httpGet.setConfig(config);
		httpGet.addHeader(new BasicHeader("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"));
		httpGet.getRequestLine();

		long start = System.currentTimeMillis();
		HttpResponse response = null;
		String result = "";
		response = httpClient.execute(httpGet);
		int statusCode = response.getStatusLine().getStatusCode();
		logger.debug("visit url :{}, request status : {}", urlBuffer.toString(), statusCode);

		HttpEntity respEntity = response.getEntity();
		if (respEntity != null) {
			respEntity = new BufferedHttpEntity(respEntity);

			InputStream in = respEntity.getContent();
			result = IOUtils.toString(in);
			in.close();
		}
		long cost = System.currentTimeMillis() - start;
		logger.info("Cost:{},URL={}", cost, urlBuffer.toString());

		return result;
	}
	
	/**
	 * 将消息发送到微信
	 */
	public static <T> T sendToWx(String url, Class<T> clazz, Object... params) throws HttpException, IOException {
		url = String.format(url, params);
		logger.info("调用微信接口:{}", url);
		HttpClientUtil util = new HttpClientUtil();
		String response = util.doRequest(MethodType.GET, url, "UTF-8");
		logger.info("微信接口返回信息:{}", response);
		JsonMapper mapper = new JsonMapper();
		return mapper.fromJson(response, clazz);
	}
	
	
	/**
	 * 发送 json 请求
	 * 
	 * @param url
	 * @param obj
	 * @return
	 */
	public static String postJson(String url, Object obj) {
		return postJson(url, new Gson().toJson(obj));
	}

	/**
	 * 发送 json 请求
	 * 
	 * @param url
	 * @param str
	 * @return
	 */
	@SuppressWarnings({ "deprecation", "resource", "finally" })
	public static String postJson(String url, String str) {
		logger.info("URL={},req={}", url, str);
		long start = System.currentTimeMillis();
		DefaultHttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectTimeOut);
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, connectTimeOut);

		HttpPost post = new HttpPost(url);
		StringBuffer ret = new StringBuffer();
		try {
			StringEntity sentity = new StringEntity(str, "UTF-8");
			sentity.setContentEncoding("UTF-8");
			sentity.setContentType("application/json");
			post.setEntity(sentity);

			HttpResponse res = client.execute(post);

			int statusCode = res.getStatusLine().getStatusCode();
			logger.debug("visit url :{}, request status : {}", url.toString(), statusCode);

			HttpEntity entity = res.getEntity();
			String returnCharSet = EntityUtils.getContentCharSet(entity);
			if (StringUtils.isBlank(returnCharSet)) {
				returnCharSet = "UTF-8";
			}
			InputStreamReader read = new InputStreamReader(entity.getContent(), returnCharSet);
			BufferedReader bufr = new BufferedReader(read);// 缓冲
			String line = null;
			while ((line = bufr.readLine()) != null) {
				ret.append(line);
			}
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
			long end = System.currentTimeMillis();
			logger.info("Cost:{},URL={},results={}", end - start, url, e.getMessage());
			throw new RuntimeException(e);
		} finally {
			long end = System.currentTimeMillis();
			logger.info("Cost:{},URL={},req={},results={}", end - start, url, str, ret.toString());
			return ret.toString();
		}
	}
}
