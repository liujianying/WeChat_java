package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    public int dfb = 1;
    public VideoTransPara lem;
    public int lfa = -1;
    public int lgI = -1;
    public boolean lgJ = false;
    public boolean lgK = false;
    public boolean lgL = true;
    public boolean lgM = false;
    b lgN;
    public boolean lgw = false;
    public int videoBitrate;

    public static o a(int i, VideoTransPara videoTransPara) {
        o oVar;
        switch (i) {
            case 1:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
                oVar = new o(2, videoTransPara);
                oVar.lgK = false;
                break;
            case 2:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
                oVar = new o(2, videoTransPara);
                oVar.lgK = false;
                oVar = oVar.bdZ().bdY();
                break;
            case 3:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
                oVar = new o(1, videoTransPara);
                oVar.lgK = false;
                break;
            case 4:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
                oVar = new o(1, videoTransPara);
                oVar.lgK = false;
                oVar = oVar.bdZ().bdY();
                break;
            case 5:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
                oVar = new o(2, videoTransPara);
                oVar.lgK = true;
                oVar.lgJ = false;
                oVar = oVar.bdY();
                break;
            case 6:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
                oVar = new o(1, videoTransPara);
                oVar.lgK = true;
                oVar = oVar.bdY();
                break;
            case 7:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
                oVar = new o(2, videoTransPara);
                oVar.lgK = true;
                oVar = oVar.bea();
                oVar.lgJ = false;
                break;
            case 8:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
                oVar = new o(2, videoTransPara);
                oVar.lgK = true;
                oVar = oVar.bea();
                oVar.lgJ = true;
                break;
            case 9:
                oVar = new o(1, videoTransPara);
                oVar.lgK = true;
                oVar = oVar.bea();
                oVar.lgJ = false;
                break;
            case 10:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
                oVar = new o(1, videoTransPara);
                oVar.lgK = true;
                oVar = oVar.bea();
                oVar.lgJ = true;
                break;
            case 11:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
                oVar = new o(2, videoTransPara);
                oVar.lgK = true;
                oVar = oVar.bea();
                oVar.lgJ = false;
                oVar = oVar.bdZ();
                break;
            default:
                return null;
        }
        if (oVar == null) {
            return oVar;
        }
        oVar.lgI = i;
        return oVar;
    }

    private o(int i, VideoTransPara videoTransPara) {
        this.lem = videoTransPara;
        this.dfb = i;
        this.videoBitrate = videoTransPara.videoBitrate;
        this.lfa = videoTransPara.width;
    }

    public final o bdY() {
        this.lfa = 720;
        return this;
    }

    public final o bdZ() {
        this.videoBitrate = this.lem.videoBitrate * 2;
        this.lgM = true;
        return this;
    }

    public final o bea() {
        this.lfa = this.lem.width * 2;
        return this;
    }

    public final boolean beb() {
        return this.lem.width < this.lfa;
    }

    public final String toString() {
        return String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[]{Integer.valueOf(this.dfb), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.lgw), Boolean.valueOf(this.lgJ), Boolean.valueOf(this.lgK), Integer.valueOf(this.lfa), this.lem});
    }
}
