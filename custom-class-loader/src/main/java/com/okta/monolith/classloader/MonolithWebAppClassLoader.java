package com.okta.monolith.classloader;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.loader.ParallelWebappClassLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class MonolithWebAppClassLoader extends ParallelWebappClassLoader {
    public MonolithWebAppClassLoader() {
        init_();
    }

    public MonolithWebAppClassLoader(ClassLoader parent) {
        super(parent);

        init_();
    }

    @Override
    public void setResources(WebResourceRoot resources) {
        super.setResources(new MonolithResourcesRoot(resources));
    }

    private void init_() {
        String userHome = System.getProperty("user.home");
        try {
            addURL(new URL(String.format("file:///%s/projects/tomcat-monolith-loader-test/webapp/target/classes", userHome)));
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }
}
