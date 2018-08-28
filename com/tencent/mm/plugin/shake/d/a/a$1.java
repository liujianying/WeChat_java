package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qafpapi.QAFPNative;

class a$1 implements a {
    final /* synthetic */ a mYA;

    a$1(a aVar) {
        this.mYA = aVar;
    }

    public final void s(byte[] bArr, int i) {
        int QAFPProcessTV;
        g.a aVar = new g.a();
        synchronized (this.mYA.hue) {
            if (this.mYA.mYo == ay.CTRL_INDEX) {
                x.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
                QAFPProcessTV = QAFPNative.QAFPProcessTV(bArr, i);
            } else {
                QAFPProcessTV = QAFPNative.QAFPProcess(bArr, i);
            }
        }
        long VF = bi.VF() - this.mYA.mYx;
        x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[]{Integer.valueOf(this.mYA.mYu), Integer.valueOf(i), Integer.valueOf(QAFPProcessTV), Long.valueOf(VF), Long.valueOf(aVar.Ad())});
        if (VF > ((long) ((this.mYA.mYy * 3000) + 4000))) {
            Object obj = new byte[10240];
            g.a aVar2 = new g.a();
            if (this.mYA.mYo == ay.CTRL_INDEX) {
                x.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrintTV(obj);
            } else {
                QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrint(obj);
            }
            x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[]{Integer.valueOf(this.mYA.mYu), Integer.valueOf(QAFPProcessTV), Long.valueOf(aVar2.Ad())});
            if (QAFPProcessTV >= 10240 || QAFPProcessTV <= 0) {
                x.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[]{Integer.valueOf(this.mYA.mYu), Integer.valueOf(QAFPProcessTV)});
                this.mYA.reset();
                return;
            }
            synchronized (this.mYA.mYk) {
                System.arraycopy(obj, 0, this.mYA.mYk, 0, QAFPProcessTV);
                this.mYA.mYl = QAFPProcessTV;
                this.mYA.mYt = this.mYA.mYy >= 3;
                this.mYA.mYm = (int) (VF / 1000);
            }
            this.mYA.OI();
            a aVar3 = this.mYA;
            aVar3.mYy++;
        }
        if (this.mYA.mYt) {
            x.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[]{Integer.valueOf(this.mYA.mYu), Long.valueOf(VF)});
            this.mYA.reset();
        }
    }

    public final void aN(int i, int i2) {
    }
}
