package com.tencent.mm.modelcdntran;

public final class j extends i {
    public String bSS;
    public int bSU;
    public String bSZ = "";
    public long bYu = 0;
    public String bxC = "";
    public int concurrentCount = 1;
    public String[] dPQ;
    public long dQj;
    public String dQk;
    public int dQl;
    public int dQm;
    public String dQn;
    public int dQo;
    public int dQp = 0;
    public long dQq = 0;
    public int dQr = 0;
    public long dQs = 0;
    public a dQt;
    public String filename;
    public String host;
    public boolean isColdSnsData = false;
    public String referer;
    public String signalQuality = "";
    public String snsScene = "";
    public String url;

    public final boolean NJ() {
        return this.dQh == 3;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("isPlayMode: ").append(this.dQm);
        stringBuffer.append(" videoFormat: ").append(this.field_requestVideoFormat);
        stringBuffer.append(" initialDownloadLength : ").append(this.initialDownloadLength);
        stringBuffer.append(" initialDownloadOffset : ").append(this.initialDownloadOffset);
        stringBuffer.append(" videoXmlTotalLen : ").append(this.dQl);
        stringBuffer.append(" videoTaskType : ").append(this.dQh);
        stringBuffer.append(" filename : ").append(this.filename);
        if (NG()) {
            stringBuffer.append(" url : ").append(this.url);
            stringBuffer.append(" host : ").append(this.host);
            stringBuffer.append(" referer : ").append(this.referer);
            stringBuffer.append(" ip size : ").append(this.dPQ != null ? this.dPQ.length : 0);
            stringBuffer.append(" isColdSnsData : ").append(this.isColdSnsData);
            stringBuffer.append(" signalQuality : ").append(this.signalQuality);
            stringBuffer.append(" snsScene : ").append(this.snsScene);
            stringBuffer.append(" snsId : ").append(this.bSZ);
        } else {
            stringBuffer.append(" field_mediaId : ").append(this.field_mediaId);
        }
        stringBuffer.append(" fileid : ").append(this.field_fileId);
        stringBuffer.append(" fileaeskey: ").append(this.field_aesKey);
        stringBuffer.append(" field_preloadRatio:").append(this.field_preloadRatio);
        stringBuffer.append(" newmd5: ").append(this.bxC);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
