package com.okta.monolith.classloader;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.TrackedWebResource;
import org.apache.catalina.WebResource;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.WebResourceSet;
import org.apache.catalina.webresources.FileResource;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class MonolithResourcesRoot implements WebResourceRoot {
    WebResourceRoot resources;

    public MonolithResourcesRoot(WebResourceRoot resources) {
        this.resources = resources;
    }

    @Override
    public WebResource getResource(String path) {
        return resources.getResource(path);
    }

    @Override
    public WebResource[] getResources(String path) {
        return resources.getResources(path);
    }

    @Override
    public WebResource getClassLoaderResource(String path) {
        String userHome = System.getProperty("user.home");

        String base = String.format("%s/projects/tomcat-monolith-loader-test/webapp/target/classes", userHome);

        File file = new File(base + path);

        if (file.exists()) {
            return new FileResource(this, path, file, true, null);
        }

        System.out.println("Alex.Rojkov: MonolithResourcesRoot.getClassLoaderResource " + path);

        return resources.getClassLoaderResource(path);
    }

    @Override
    public WebResource[] getClassLoaderResources(String path) {
        return resources.getClassLoaderResources(path);
    }

    @Override
    public String[] list(String path) {
        return resources.list(path);
    }

    @Override
    public Set<String> listWebAppPaths(String path) {
        return resources.listWebAppPaths(path);
    }

    @Override
    public WebResource[] listResources(String path) {
        return resources.listResources(path);
    }

    @Override
    public boolean mkdir(String path) {
        return resources.mkdir(path);
    }

    @Override
    public boolean write(String path, InputStream is, boolean overwrite) {
        return resources.write(path, is, overwrite);
    }

    @Override
    public void createWebResourceSet(ResourceSetType type, String webAppMount, URL url, String internalPath) {
        resources.createWebResourceSet(type, webAppMount, url, internalPath);
    }

    @Override
    public void createWebResourceSet(ResourceSetType type, String webAppMount, String base, String archivePath, String internalPath) {
        resources.createWebResourceSet(type, webAppMount, base, archivePath, internalPath);
    }

    @Override
    public void addPreResources(WebResourceSet webResourceSet) {
        resources.addPreResources(webResourceSet);
    }

    @Override
    public WebResourceSet[] getPreResources() {
        return resources.getPreResources();
    }

    @Override
    public void addJarResources(WebResourceSet webResourceSet) {
        resources.addJarResources(webResourceSet);
    }

    @Override
    public WebResourceSet[] getJarResources() {
        return resources.getJarResources();
    }

    @Override
    public void addPostResources(WebResourceSet webResourceSet) {
        resources.addPostResources(webResourceSet);
    }

    @Override
    public WebResourceSet[] getPostResources() {
        return resources.getPostResources();
    }

    @Override
    public Context getContext() {
        return resources.getContext();
    }

    @Override
    public void setContext(Context context) {
        resources.setContext(context);
    }

    @Override
    public void setAllowLinking(boolean allowLinking) {
        resources.setAllowLinking(allowLinking);
    }

    @Override
    public boolean getAllowLinking() {
        return resources.getAllowLinking();
    }

    @Override
    public void setCachingAllowed(boolean cachingAllowed) {
        resources.setCachingAllowed(cachingAllowed);
    }

    @Override
    public boolean isCachingAllowed() {
        return resources.isCachingAllowed();
    }

    @Override
    public void setCacheTtl(long ttl) {
        resources.setCacheTtl(ttl);
    }

    @Override
    public long getCacheTtl() {
        return resources.getCacheTtl();
    }

    @Override
    public void setCacheMaxSize(long cacheMaxSize) {
        resources.setCacheMaxSize(cacheMaxSize);
    }

    @Override
    public long getCacheMaxSize() {
        return resources.getCacheMaxSize();
    }

    @Override
    public void setCacheObjectMaxSize(int cacheObjectMaxSize) {
        resources.setCacheObjectMaxSize(cacheObjectMaxSize);
    }

    @Override
    public int getCacheObjectMaxSize() {
        return resources.getCacheObjectMaxSize();
    }

    @Override
    public void setTrackLockedFiles(boolean trackLockedFiles) {
        resources.setTrackLockedFiles(trackLockedFiles);
    }

    @Override
    public boolean getTrackLockedFiles() {
        return resources.getTrackLockedFiles();
    }

    @Override
    public void backgroundProcess() {
        resources.backgroundProcess();
    }

    @Override
    public void registerTrackedResource(TrackedWebResource trackedResource) {
        resources.registerTrackedResource(trackedResource);
    }

    @Override
    public void deregisterTrackedResource(TrackedWebResource trackedResource) {
        resources.deregisterTrackedResource(trackedResource);
    }

    @Override
    public List<URL> getBaseUrls() {
        return resources.getBaseUrls();
    }

    @Override
    public void gc() {
        resources.gc();
    }

    @Override
    public void addLifecycleListener(LifecycleListener listener) {
        resources.addLifecycleListener(listener);
    }

    @Override
    public LifecycleListener[] findLifecycleListeners() {
        return resources.findLifecycleListeners();
    }

    @Override
    public void removeLifecycleListener(LifecycleListener listener) {
        resources.removeLifecycleListener(listener);
    }

    @Override
    public void init() throws LifecycleException {
        resources.init();
    }

    @Override
    public void start() throws LifecycleException {
        resources.start();
    }

    @Override
    public void stop() throws LifecycleException {
        resources.stop();
    }

    @Override
    public void destroy() throws LifecycleException {
        resources.destroy();
    }

    @Override
    public LifecycleState getState() {
        return resources.getState();
    }

    @Override
    public String getStateName() {
        return resources.getStateName();
    }
}
