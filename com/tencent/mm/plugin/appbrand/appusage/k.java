package com.tencent.mm.plugin.appbrand.appusage;

public final class k {
    public final String appId;
    public final String appName;
    public final int bGM;
    public final String bGy;
    public final String dfX;
    public final long dlj;
    public final int fig;
    public final String fmb;
    public final long fmc;
    public final boolean fmd;

    public k(String str, String str2, String str3, String str4, String str5, int i, int i2, long j, boolean z, long j2) {
        this.dfX = str;
        this.bGy = str2;
        this.appId = str3;
        this.appName = str4;
        this.fmb = str5;
        this.bGM = i;
        this.fig = i2;
        this.fmc = j;
        this.fmd = z;
        this.dlj = j2;
    }

    public final boolean aaq() {
        return this.bGM == 4;
    }
}
