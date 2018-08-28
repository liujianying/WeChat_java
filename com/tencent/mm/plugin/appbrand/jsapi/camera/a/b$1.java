package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;

class b$1 implements Runnable {
    final /* synthetic */ byte[] fOR;
    final /* synthetic */ int fOS;
    final /* synthetic */ int fOT;
    final /* synthetic */ int fOU;
    final /* synthetic */ Rect fOV;
    final /* synthetic */ b fOW;

    b$1(b bVar, byte[] bArr, int i, int i2, int i3, Rect rect) {
        this.fOW = bVar;
        this.fOR = bArr;
        this.fOS = i;
        this.fOT = i2;
        this.fOU = i3;
        this.fOV = rect;
    }

    public final void run() {
        if (this.fOW.fOO.compareAndSet(false, true)) {
            byte[] bArr = this.fOR;
            if (270 == this.fOS || 90 == this.fOS) {
                byte[] bArr2 = new byte[this.fOR.length];
                QbarNative.a(bArr2, this.fOR, this.fOT, this.fOU);
                bArr = new byte[this.fOR.length];
                QbarNative.a(bArr, bArr2, this.fOU, this.fOT);
                QbarNative.nativeRelease();
            }
            this.fOW.b(bArr, this.fOT, this.fOU, this.fOS);
            this.fOW.fOO.set(false);
            return;
        }
        x.d("MicroMsg.appbrand.ScanDecoder", "decode isDecoding");
    }
}
