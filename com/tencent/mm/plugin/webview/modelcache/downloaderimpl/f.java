package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

public final class f {
    public final String aBC;
    public final String appId;
    public final long cfA;
    public final String cfx;
    public final String cfy;
    public final int cfz;
    public final Exception exception;
    public final String filePath;
    public final String url;
    public final String version;

    public f(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, long j, Exception exception) {
        this.url = str;
        this.filePath = str2;
        this.version = str3;
        this.appId = str4;
        this.cfx = str5;
        this.cfy = str6;
        this.cfz = i;
        this.aBC = str7;
        this.cfA = j;
        this.exception = exception;
    }

    public final String toString() {
        return "WebViewCacheResponseWrapper{url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", version='" + this.version + '\'' + ", appId='" + this.appId + '\'' + ", domain='" + this.cfx + '\'' + ", packageId='" + this.cfy + '\'' + ", cacheType=" + this.cfz + ", contentType='" + this.aBC + '\'' + ", contentLength=" + this.cfA + ", exception=" + this.exception + '}';
    }
}
