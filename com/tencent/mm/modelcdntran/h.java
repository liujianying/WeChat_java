package com.tencent.mm.modelcdntran;

public final class h extends i {
    public int csS;
    public String dPP;
    public String[] dPQ;
    public String[] dPR;
    public int dPS;
    public int dPT;
    public int dPU;
    public int fileType;
    public String host;
    public boolean isColdSnsData;
    public String referer;
    public String signalQuality;
    public String snsCipherKey;
    public String snsScene;
    public String url;

    public h() {
        this.snsCipherKey = "";
        this.csS = -1;
        this.dPU = -1;
        this.fileType = 0;
        this.dQf = true;
    }

    public final String toString() {
        return String.format("mediaId:%s, url:%s, host:%s, referer:%s, savepath:%s, iplist:%s, slaveIplist:%siplistSource:%d, dcSource:%d, isColdSnsData:%b, signalQuality:%s, snsScene:%s", new Object[]{this.field_mediaId, this.url, this.host, this.referer, this.dPP, g(this.dPQ), g(this.dPR), Integer.valueOf(this.dPS), Integer.valueOf(this.dPT), Boolean.valueOf(this.isColdSnsData), this.signalQuality, this.snsScene});
    }

    private static String g(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String str = "";
        for (String str2 : strArr) {
            str = str + str2 + ",";
        }
        return str;
    }
}
