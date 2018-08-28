package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.e.b.c.a;
import com.tencent.mm.e.b.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;

class a$2 implements a {
    short[] eqH;
    final /* synthetic */ a iOG;

    a$2(a aVar) {
        this.iOG = aVar;
    }

    public final void s(byte[] bArr, int i) {
        int i2 = 0;
        x.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", new Object[]{Integer.valueOf(i)});
        if (this.eqH == null || this.eqH.length < i / 2) {
            this.eqH = new short[(i / 2)];
        }
        while (i2 < i / 2) {
            this.eqH[i2] = (short) ((bArr[i2 * 2] & WebView.NORMAL_MODE_ALPHA) | (bArr[(i2 * 2) + 1] << 8));
            i2++;
        }
        a.a(this.iOG, this.eqH, i / 2);
        if (a.g(this.iOG) != null) {
            a.g(this.iOG).d(this.eqH, i / 2);
            if (a.d(this.iOG) != null) {
                i2 = a.d(this.iOG).a(new g.a(bArr, i));
            } else {
                i2 = -1;
            }
            if (-1 == i2 && a.e(this.iOG) != null) {
                a.e(this.iOG).onError(3);
                this.iOG.aKa();
                x.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
                return;
            }
            return;
        }
        if (a.e(this.iOG) != null) {
            a.e(this.iOG).onError(1);
            this.iOG.aKa();
        }
        x.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
    }

    public final void aN(int i, int i2) {
        x.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + i + " detailState = " + i2);
        this.iOG.aKa();
        if (a.e(this.iOG) != null) {
            a.e(this.iOG).onError(2);
        }
    }
}
