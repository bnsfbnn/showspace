package com.ntq.showspace;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Application {

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9999);
        tomcat.getConnector();
        tomcat.setHostname("localhost");

        String docBase = System.getProperty("java.io.tmpdir");
        Context context = tomcat.addWebapp("", docBase);
    
        File additionWebInfClasses = new File("target/classes");
        if (additionWebInfClasses.exists()) {
            WebResourceRoot resources = new StandardRoot(context);
            resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                    additionWebInfClasses.getAbsolutePath(), "/"));
            context.setResources(resources);
        } else {
            System.err.println("❌ Lỗi: Không tìm thấy thư mục target/classes. Hãy chạy 'mvn compile' trước.");
            return;
        }

        tomcat.start();

        System.out.println("------------------------------------------------");
        System.out.println("🚀 Ứng dụng đã khởi chạy thành công!");
        System.out.println("🏠 Home: http://localhost:9999/");
        System.out.println("------------------------------------------------");

        tomcat.getServer().await();
    }

}
