package com.tencent.mm.modelvoice;

import com.tencent.mm.ab.i;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.e.b.a;
import com.tencent.mm.e.b.c;
import com.tencent.mm.e.c.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k implements a {
    private static int epz = 100;
    private int bDa = 0;
    public c bDp;
    c.a bEb = new 1(this);
    private d epA;
    private String mFileName = null;
    public int mStatus = 0;

    static /* synthetic */ void a(k kVar, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > kVar.bDa) {
                kVar.bDa = s;
            }
        }
    }

    public final boolean dc(String str) {
        if (bi.oW(this.mFileName)) {
            this.mStatus = 1;
            this.bDa = 0;
            this.bDp = new c(16000, 1, 0);
            this.bDp.bDQ = -19;
            if (q.deW.ddI > 0) {
                this.bDp.t(q.deW.ddI, true);
            } else {
                this.bDp.t(5, false);
            }
            this.bDp.aM(false);
            this.bDp.bEb = this.bEb;
            this.epA = new d();
            if (!this.epA.df(str)) {
                x.e("MicroMsg.SpeexRecorder", "init speex writer failed");
                clean();
                this.mStatus = -1;
                return false;
            } else if (this.bDp.wn()) {
                this.mFileName = str;
                return true;
            } else {
                x.e("MicroMsg.SpeexRecorder", "start record failed");
                clean();
                this.mStatus = -1;
                return false;
            }
        }
        x.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
        return false;
    }

    public final void a(i.a aVar) {
    }

    public final boolean we() {
        this.mFileName = null;
        this.mStatus = 0;
        clean();
        return true;
    }

    public final int getStatus() {
        return this.mStatus;
    }

    private void clean() {
        if (this.bDp != null) {
            this.bDp.we();
            this.bDp = null;
        }
        if (this.epA != null) {
            this.epA.wA();
            this.epA = null;
        }
    }

    public final int getMaxAmplitude() {
        int i = this.bDa;
        this.bDa = 0;
        if (i > epz) {
            epz = i;
        }
        return (i * 100) / epz;
    }

    public final int wf() {
        return this.bDp.bEg;
    }
}
