package com.tencent.mm.modelcontrol;

import com.tencent.mm.sdk.platformtools.bi;

public final class e {
    protected String dQE;
    protected int dQF;
    protected int dQG;
    protected int dQH;
    protected int dQI;
    protected boolean dQJ;
    protected f[] dQK;

    protected final void a(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        this.dQE = str;
        this.dQF = bi.getInt(str2, 0);
        this.dQF = this.dQF == 0 ? 64000 : this.dQF * 1000;
        this.dQG = bi.getInt(str3, 10);
        this.dQH = bi.getInt(str4, 2);
        this.dQI = bi.getInt(str5, 1);
        if (bi.getInt(str6, 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        this.dQJ = z;
    }

    protected final boolean NY() {
        if (bi.oW(this.dQE)) {
            return true;
        }
        return b.lz(this.dQE);
    }

    protected final VideoTransPara NZ() {
        VideoTransPara videoTransPara = null;
        if (this.dQK != null) {
            for (f fVar : this.dQK) {
                if (fVar != null && fVar.dQL <= 0 && fVar.dQM >= 0) {
                    videoTransPara = new VideoTransPara();
                    videoTransPara.width = fVar.dQN;
                    videoTransPara.height = fVar.dQO;
                    videoTransPara.fps = fVar.dQP;
                    videoTransPara.videoBitrate = fVar.dQQ;
                    videoTransPara.dQG = this.dQG;
                    videoTransPara.dQF = this.dQF;
                    videoTransPara.dQH = this.dQH;
                    videoTransPara.dQI = this.dQI;
                }
            }
        }
        return videoTransPara;
    }

    public final String toString() {
        return "[ busyTime " + this.dQE + " audioBitrate " + this.dQF + " iFrame " + this.dQG + " profileIndex " + this.dQH + " presetIndex " + this.dQI + " isStepBr " + this.dQJ + " ]";
    }
}
