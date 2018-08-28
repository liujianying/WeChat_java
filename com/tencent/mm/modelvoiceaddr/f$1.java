package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.e.b.c.a;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements a {
    short[] eqH;
    final /* synthetic */ f eqI;

    f$1(f fVar) {
        this.eqI = fVar;
    }

    public final void s(byte[] bArr, int i) {
        int i2 = 0;
        x.d("MicroMsg.SceneVoiceInputAddr", "OnRecPcmDataReady len: %s time: %s", new Object[]{Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())});
        if (this.eqH == null || this.eqH.length < i / 2) {
            this.eqH = new short[(i / 2)];
        }
        while (i2 < i / 2) {
            this.eqH[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            i2++;
        }
        f.a(this.eqI, this.eqH, i / 2);
        if (f.d(this.eqI) != null) {
            f.d(this.eqI).d(this.eqH, i / 2);
            return;
        }
        this.eqI.bs(9, -1);
        x.e("MicroMsg.SceneVoiceInputAddr", "mVoiceSilentDetectAPI is null");
    }

    public final void aN(int i, int i2) {
        x.e("MicroMsg.SceneVoiceInputAddr", "onRecError state = %s detailState = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.eqI.bs(10, -1);
    }
}
