package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.compatible.util.b;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;

public final class p implements com.tencent.mm.compatible.b.f.a {
    public static int bFx = 100;
    public k bAY = null;
    public b epT;
    public String fileName = "";
    private int hjR = 0;
    public long iZe = 0;
    public a oFA = null;
    public b oFx;
    public String oFy;
    public boolean oFz = false;
    public boolean orw = false;
    public int orz = 0;

    public interface a {
        void bIY();
    }

    public final void ew(int i) {
        x.d("MicroMsg.VoicePrintRecoder", " Recorder onBluetoothHeadsetStateChange :" + i);
        if (!this.orw) {
            this.orw = true;
            au.HV().b(this);
            this.bAY = new k();
            this.oFx = new b(this);
            this.oFx.start();
            this.oFz = false;
            this.orz = 1;
        }
    }

    public final boolean wk() {
        long j = 0;
        au.HV().yC();
        this.oFz = false;
        x.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
        synchronized (this) {
            x.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
            if (this.bAY != null) {
                this.bAY.we();
            }
        }
        if (this.orz != 2) {
            this.fileName = null;
            this.oFz = false;
            x.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        } else {
            if (this.iZe > 0) {
                j = bi.bI(this.iZe);
            }
            this.hjR = (int) j;
            if (this.hjR < TbsLog.TBSLOG_CODE_SDK_BASE) {
                x.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.hjR);
                this.fileName = "";
                this.oFz = false;
            } else {
                this.oFz = true;
                x.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
            }
            this.fileName = "";
        }
        this.orz = -1;
        x.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.oFz);
        if (this.epT != null) {
            this.epT.zY();
        }
        return this.oFz;
    }
}
