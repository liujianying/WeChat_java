package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.e.b.c;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qafpapi.QAFPNative;

public final class a implements e {
    c bDp;
    private com.tencent.mm.e.b.c.a bEs = new 1(this);
    Object hue = new Object();
    byte[] mYk = new byte[10240];
    int mYl = 0;
    int mYm = 0;
    long mYn = 0;
    int mYo = 0;
    boolean mYp = false;
    e mYq = null;
    private a mYr = null;
    boolean mYs = false;
    boolean mYt = false;
    int mYu = 0;
    int mYv;
    private boolean mYw = false;
    long mYx;
    int mYy;
    private boolean mYz = false;

    public final boolean bvc() {
        boolean z = false;
        synchronized (this.hue) {
            if (this.mYw) {
                x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit already inited");
            } else {
                int QAFPInit = QAFPNative.QAFPInit();
                x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPInit ret:%d", new Object[]{Integer.valueOf(QAFPInit)});
                if (QAFPInit >= 0) {
                    this.mYw = true;
                }
                if (QAFPInit >= 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean bvd() {
        boolean z = false;
        synchronized (this.hue) {
            if (this.mYw) {
                x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease ret:%d", new Object[]{Integer.valueOf(QAFPNative.QAFPRelease())});
                if (QAFPNative.QAFPRelease() >= 0) {
                    z = true;
                }
            } else {
                x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPRelease never inited");
            }
        }
        return z;
    }

    public final boolean we() {
        x.d("MicroMsg.MusicFingerPrintRecorder", "stopRecord now clientid:%d", new Object[]{Integer.valueOf(this.mYu)});
        au.DF().b(367, this);
        au.DF().b(408, this);
        synchronized (this.mYk) {
            this.mYl = 0;
        }
        if (this.bDp != null) {
            this.bDp.we();
            this.bDp = null;
        }
        return true;
    }

    public final boolean a(int i, a aVar) {
        we();
        synchronized (this.hue) {
            this.mYv = QAFPNative.QAFPGetVersion();
        }
        bvc();
        this.mYo = i;
        this.mYr = aVar;
        this.mYt = false;
        this.mYs = false;
        this.mYp = false;
        this.mYz = false;
        au.DF().a(367, this);
        au.DF().a(408, this);
        this.mYu = (int) bi.VF();
        x.d("MicroMsg.MusicFingerPrintRecorder", "startRecord now clientid:%d", new Object[]{Integer.valueOf(this.mYu)});
        this.bDp = new c(8000, 1, 4);
        this.bDp.bDQ = -19;
        this.bDp.bEb = this.bEs;
        if (this.bDp.wn()) {
            synchronized (this.hue) {
                x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPReset ret:%d", new Object[]{Integer.valueOf(QAFPNative.QAFPReset())});
                if (QAFPNative.QAFPReset() < 0) {
                    x.e("MicroMsg.MusicFingerPrintRecorder", "init failed QAFPReset:%d clientid:%d", new Object[]{Integer.valueOf(r3), Integer.valueOf(this.mYu)});
                    reset();
                    return false;
                }
                this.mYn = bi.VF();
                this.mYx = bi.VF();
                this.mYy = 0;
                return true;
            }
        }
        x.e("MicroMsg.MusicFingerPrintRecorder", "start record failed");
        reset();
        return false;
    }

    final void reset() {
        x.d("MicroMsg.MusicFingerPrintRecorder", "reset recorder clientid:%d", new Object[]{Integer.valueOf(this.mYu)});
        if (this.bDp != null) {
            this.bDp.we();
            this.bDp = null;
        }
        hD(false);
    }

    private void hD(boolean z) {
        x.d("MicroMsg.MusicFingerPrintRecorder", "tryCallBack, directFail = %s", new Object[]{Boolean.valueOf(false)});
        ah.A(new 2(this, z));
    }

    private synchronized void a(bhp bhp, long j, boolean z) {
        if (this.mYz) {
            x.w("MicroMsg.MusicFingerPrintRecorder", "hy: already call backed to UI");
        } else {
            this.mYr.b(bhp, j, z);
            this.mYz = true;
        }
    }

    final void OI() {
        au.Em().H(new 3(this));
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 367 || lVar.getType() == 408) {
            x.d("MicroMsg.MusicFingerPrintRecorder", "onSceneEnd errType = %s, errCode = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            this.mYs = false;
            if (((e) lVar).bve()) {
                x.d("MicroMsg.MusicFingerPrintRecorder", "NetSceneShakeMedia isRecogSuccess stop now ! clientid:%d", new Object[]{Integer.valueOf(this.mYu)});
                we();
                this.mYq = (e) lVar;
                this.mYp = true;
                hD(false);
            } else if (this.mYl == 0 && this.mYt) {
                x.d("MicroMsg.MusicFingerPrintRecorder", "recog failed . clientid:%d", new Object[]{Integer.valueOf(this.mYu)});
                this.mYq = null;
                this.mYp = true;
                if (i == 0 && i2 == 0) {
                    hD(false);
                } else {
                    hD(true);
                }
                au.DF().b(367, this);
                au.DF().b(408, this);
            } else {
                x.d("MicroMsg.MusicFingerPrintRecorder", "NetScene try again clientId:%d", new Object[]{Integer.valueOf(this.mYu)});
                OI();
            }
        }
    }
}
