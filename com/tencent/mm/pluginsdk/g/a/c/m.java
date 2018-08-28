package com.tencent.mm.pluginsdk.g.a.c;

public final class m {
    public final String aBC;
    public final long cfA;
    public final String filePath;
    final String groupId;
    public final int httpStatusCode;
    public final String qBy;
    public final Exception qDk;
    public final int status;
    private final String url;

    private m(String str, String str2, String str3, String str4, long j, String str5, int i, Exception exception, int i2) {
        this.groupId = str;
        this.qBy = str2;
        this.url = str3;
        this.filePath = str4;
        this.cfA = j;
        this.aBC = str5;
        this.status = i;
        this.qDk = exception;
        this.httpStatusCode = i2;
    }

    public m(String str, String str2, String str3, String str4, long j, String str5, Exception exception) {
        this(str, str2, str3, str4, j, str5, 3, exception, -1);
    }

    public m(l lVar, long j) {
        this(lVar.aca(), lVar.qBy, lVar.url, lVar.getFilePath(), j, null, 2, null, -1);
    }

    public m(e eVar, long j, String str) {
        this(eVar.aca(), eVar.cco(), eVar.getURL(), eVar.getFilePath(), j, str, 2, null, -1);
    }

    public m(e eVar, Exception exception, int i, int i2) {
        this(eVar.aca(), eVar.cco(), eVar.getURL(), eVar.getFilePath(), -1, null, i2, exception, i);
    }

    public m(e eVar, Exception exception, int i) {
        this(eVar, exception, -1, i);
    }

    public final String toString() {
        return "NetworkResponse{urlKey='" + this.qBy + '\'' + ", url='" + this.url + '\'' + ", filePath='" + this.filePath + '\'' + ", contentLength=" + this.cfA + ", contentType='" + this.aBC + '\'' + ", status=" + this.status + ", e=" + this.qDk + '}';
    }
}
