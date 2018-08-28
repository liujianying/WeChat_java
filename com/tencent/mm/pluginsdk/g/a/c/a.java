package com.tencent.mm.pluginsdk.g.a.c;

public abstract class a {
    public final String bKg;
    private volatile int ecw;
    private final long eiD;
    private final String filePath;
    public final int networkType;
    public final int priority;
    public final int qBI;
    public final String qBy;
    public final String qCR;
    private final String qCS;
    private final String qCT;
    protected volatile int status = 0;
    public final String url;

    public static abstract class a<T extends a> {
        public String bKg;
        public long eiD;
        public int networkType;
        public int priority;
        public int qBI;
        public String qBy;
        public final String url;

        public a(String str) {
            this.url = str;
        }
    }

    public a(String str, String str2, String str3, int i, int i2, String str4, long j, String str5, String str6, String str7, int i3) {
        this.url = str;
        this.qBy = str2;
        this.qCR = str3;
        this.networkType = i;
        this.qBI = i2;
        this.ecw = this.qBI;
        this.filePath = str4;
        this.eiD = j;
        this.qCS = str6;
        this.qCT = str7;
        this.bKg = str5;
        this.priority = i3;
    }

    public s cct() {
        s sVar = new s();
        sVar.field_url = this.url;
        sVar.field_urlKey = this.qBy;
        sVar.field_fileVersion = this.qCR;
        sVar.field_networkType = this.networkType;
        sVar.field_maxRetryTimes = this.qBI;
        sVar.field_retryTimes = this.ecw;
        sVar.field_filePath = this.filePath;
        sVar.field_status = this.status;
        sVar.field_expireTime = this.eiD;
        sVar.field_groupId1 = this.qCS;
        sVar.field_groupId2 = this.qCT;
        sVar.field_md5 = this.bKg;
        sVar.field_priority = this.priority;
        return sVar;
    }

    public int Th(String str) {
        return 0;
    }

    public String toString() {
        return "BaseResDownloadRequest | urlKey='" + this.qBy + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.eiD + ", fileVersion=" + this.qCR + ", maxRetryTimes=" + this.qBI + ", md5='" + this.bKg + '\'' + ", groupId1='" + this.qCS + '\'' + ", groupId2='" + this.qCT + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.ecw + ", status=" + this.status + ", priority=" + this.priority;
    }
}
