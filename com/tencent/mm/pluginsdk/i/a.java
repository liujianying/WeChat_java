package com.tencent.mm.pluginsdk.i;

@Deprecated
public final class a {
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

    public static a ccN() {
        a aVar = new a();
        aVar.fps = 30;
        aVar.bYE = 0;
        aVar.lgR = 640;
        aVar.lgS = 480;
        aVar.iSq = 640;
        aVar.iSp = 480;
        aVar.lgQ = 1440000;
        aVar.lgT = 1;
        aVar.lgU = 4;
        aVar.lgV = "/sdcard/1.yuv";
        aVar.lgZ = "/sdcard/1.mp4";
        aVar.lgW = "/sdcard/1.pcm";
        aVar.lgY = "/sdcard/1.x264";
        aVar.lha = 0;
        aVar.enM = 0;
        aVar.lhb = 0;
        return aVar;
    }

    public static a ccO() {
        a aVar = new a();
        aVar.fps = 30;
        aVar.bYE = 0;
        aVar.lgR = lgP;
        aVar.lgS = lgO;
        aVar.iSq = lgP;
        aVar.iSp = lgO;
        aVar.lgQ = 327680;
        aVar.lgT = 4;
        aVar.lgU = 1;
        aVar.lgV = "/sdcard/2.yuv";
        aVar.lgZ = "/sdcard/2.mp4";
        aVar.lgW = "/sdcard/2.pcm";
        aVar.lgY = "/sdcard/2.x264";
        aVar.lha = 0;
        aVar.enM = 0;
        aVar.lhb = 0;
        return aVar;
    }
}
