package com.zbjdl.account.util;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * freeMaker 工具类
 * 
 * @author tangyujing
 *
 */
public class FreeMarkerUtil {
	/**
	 * 通过文件名加载模版
	 * 
	 * @param ftlName
	 *            模板名字
	 * @param ftlPath
	 *            模板路径
	 */
	private static Template getTemplate(String ftlName, String ftlPath) throws Exception {
		try {
			Configuration cfg = new Configuration(); // 通过Freemaker的Configuration读取相应的ftl
			// cfg.setEncoding(Locale.CHINA, "UTF-8");
			cfg.setDefaultEncoding("UTF-8");
			cfg.setDirectoryForTemplateLoading(new File(ftlPath)); // 设定去哪里读取相应的ftl模板文件
			Template temp = cfg.getTemplate(ftlName);// 在模板文件目录中找到名称为name的文件
			temp.setEncoding("UTF-8");
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 输出到输出到文件
	 * 
	 * @param ftlName
	 *            ftl文件名
	 * @param root
	 *            传入的map
	 * @param outFile
	 *            输出后的文件全部路径
	 * @param filePath
	 *            输出前的文件上部路径
	 */
	public static void printFile(String ftlName, String ftlPath, Map<String, Object> root, String outFile) {
		try {
			File file = new File(outFile);
			if (!file.getParentFile().exists()) { // 判断有没有父路径，就是判断文件整个路径是否存在
				file.getParentFile().mkdirs(); // 不存在就全部创建
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			Template template = getTemplate(ftlName, ftlPath);
			template.process(root, out); // 模版输出
			out.flush();
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 获取html中的内容显示在ckeditor中

	public static String getHtmlContent(String url) throws MalformedURLException, IOException {
		String strMain = "";
		if (url != null && !"".equals(url)) {
			URLConnection uc = new URL(url).openConnection();
			uc.setConnectTimeout(10000);
			uc.setDoOutput(true);
			InputStream in = new BufferedInputStream(uc.getInputStream());
			Reader rd = new InputStreamReader(in, "gbk");
			int c = 0;
			StringBuffer buffer = new StringBuffer();
			while ((c = rd.read()) != -1) {
				buffer.append((char) c);
			}
			in.close();
			String strHtml = buffer.toString();
			if(strHtml.indexOf("<body>")>0){
				strMain = strHtml.substring(strHtml.indexOf("<body>") + 6, strHtml.indexOf("</body>"));
			}else{
				strMain = strHtml;
			}

		}
		return strMain;
	}

	public static void saveHtml(String content, File txt) throws IOException {
		String start = "<!DOCTYPE HTML>\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n<meta name=\"viewport\" content=\"width=device-width,minimum-scale=1.0,maximum-scale=1.0\"/>\n</head>\n<body>\n";
		String str = content;
		String end = "\n</body></html>";
		String strContent = start + str + end;
		//File txt = new File(url);
		if (!txt.getParentFile().exists()) {
			txt.getParentFile().mkdirs();
		}
		OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(txt), "UTF-8");
		BufferedWriter writer = new BufferedWriter(write);
		writer.write(strContent);
		writer.close();
	}
	public static void mkDir(File file) {
		if (file.getParentFile().exists()) {
			file.mkdir();
		} else {
			mkDir(file.getParentFile());
			file.mkdir();
		}
	}
	
}
