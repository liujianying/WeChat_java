package com.tencent.mm.plugin.mmsight.model;

public final class p {
    public static int lgO = 480;
    public static int lgP = 640;
    public int bYE;
    public int enM;
    public int fps;
    public int iSp;
    public int iSq;
    public int lgQ;
    public int lgR;
    public int lgS;
    public int lgT;
    public int lgU;
    public String lgV;
    public String lgW;
    public String lgX;
    public String lgY;
    public String lgZ;
    public int lha;
    public int lhb;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fps=").append(this.fps).append(10);
        stringBuilder.append("width=").append(this.iSp).append(10);
        stringBuilder.append("height=").append(this.iSq).append(10);
        stringBuilder.append("bitrate=").append(this.lgQ).append(10);
        stringBuilder.append("rotate=").append(this.bYE).append(10);
        stringBuilder.append("yuvWidth=").append(this.lgS).append(10);
        stringBuilder.append("yuvHeight=").append(this.lgR).append(10);
        stringBuilder.append("x264Speed=").append(this.lgT).append(10);
        stringBuilder.append("x264Quality=").append(this.lgU).append(10);
        stringBuilder.append("yuvFile=").append(this.lgV).append(10);
        stringBuilder.append("pcmFile=").append(this.lgW).append(10);
        stringBuilder.append("thuFile=").append(this.lgX).append(10);
        stringBuilder.append("x264File=").append(this.lgY).append(10);
        stringBuilder.append("mp4File=").append(this.lgZ).append(10);
        stringBuilder.append("videoFrameCnt=").append(this.lha).append(10);
        stringBuilder.append("videoLength=").append(this.enM).append(10);
        stringBuilder.append("cameraCount=").append(this.lhb).append(10);
        return stringBuilder.toString();
    }

    public static p bec() {
        p pVar = new p();
        pVar.fps = 30;
        pVar.bYE = 0;
        pVar.lgR = lgP;
        pVar.lgS = lgO;
        pVar.iSq = lgP;
        pVar.iSp = lgO;
        pVar.lgQ = 327680;
        pVar.lgT = 4;
        pVar.lgU = 1;
        pVar.lgV = "/sdcard/2.yuv";
        pVar.lgZ = "/sdcard/2.mp4";
        pVar.lgW = "/sdcard/2.pcm";
        pVar.lgY = "/sdcard/2.x264";
        pVar.lha = 0;
        pVar.enM = 0;
        pVar.lhb = 0;
        return pVar;
    }
}
