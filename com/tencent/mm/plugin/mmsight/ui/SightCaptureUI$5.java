package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.e.b;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$5 implements b {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$5(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void a(byte[] bArr, int i, int i2, int i3, int i4) {
        if (bArr == null || i < 0 || i2 < 0 || i3 < 0) {
            x.e("MicroMsg.SightCaptureUI", "onPictureYuvTaken, data is null!!");
            SightCaptureUI.y(this.lqr);
            return;
        }
        int i5;
        x.i("MicroMsg.SightCaptureUI", "data frameWidth %s frameHeight %s rotate %s deviceDegree %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        SightCaptureUI.z(this.lqr);
        SightCaptureUI.A(this.lqr);
        SightCaptureUI.b(this.lqr, i);
        SightCaptureUI.c(this.lqr, i2);
        SightCaptureUI.d(this.lqr, i3);
        SightCaptureUI.e(this.lqr, i4);
        if (SightCaptureUI.B(this.lqr) != null) {
            j.lin.F(SightCaptureUI.B(this.lqr));
            SightCaptureUI.a(this.lqr, null);
        }
        SightCaptureUI.a(this.lqr, j.lin.i(Integer.valueOf(bArr.length)));
        System.arraycopy(bArr, 0, SightCaptureUI.B(this.lqr), 0, bArr.length);
        SightCaptureUI.a(this.lqr, e.b(new 1(this), "SightCaptureUI_saveCaptureBitmap"));
        SightCaptureUI.D(this.lqr).start();
        k.c(true, d.Hq("TIME_RECODER_2_PLAY"));
        if (SightCaptureUI.E(this.lqr)) {
            if (Math.abs(i3 - i4) == 0) {
                i5 = 180;
            } else {
                i5 = 0;
            }
            bArr = d.c(bArr, i, i2, i5 % 360);
            SightCaptureUI.c(this.lqr).a(bArr, true, 0);
        } else {
            if (i4 == 180) {
                i5 = i3 + i4;
            } else {
                i5 = i3;
            }
            if (i5 > 360) {
                i5 -= 360;
            }
            SightCaptureUI.c(this.lqr).a(bArr, false, i5);
        }
        SightCaptureUI.b(this.lqr, bArr);
        SightCaptureUI.f(this.lqr, i5);
        SightCaptureUI.g(this.lqr, 3);
        SightCaptureUI.G(this.lqr).post(new Runnable() {
            public final void run() {
                SightCaptureUI.F(SightCaptureUI$5.this.lqr);
            }
        });
        if (SightCaptureUI.a(this.lqr).scene == 1 || SightCaptureUI.a(this.lqr).scene == 2) {
            h.mEJ.h(13819, new Object[]{Integer.valueOf(1), Integer.valueOf(SightCaptureUI.a(this.lqr).scene), SightCaptureUI.a(this.lqr).leu, Long.valueOf(bi.VE())});
        }
    }
}
