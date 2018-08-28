package com.tencent.mm.plugin.mmsight.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.w.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;

class SightCaptureUI$21 implements MMSightRecordButton$b {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$21(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void bfg() {
        x.i("MicroMsg.SightCaptureUI", "onPressDown, currentStatus: %s", new Object[]{Integer.valueOf(SightCaptureUI.e(this.lqr))});
        if (SightCaptureUI.e(this.lqr) != 0 && SightCaptureUI.h(this.lqr) != null && SightCaptureUI.h(this.lqr).lfu) {
            int[] iArr = new int[2];
            SightCaptureUI.i(this.lqr).getLocationOnScreen(iArr);
            e h = SightCaptureUI.h(this.lqr);
            int i = iArr[1];
            if (h.lfr <= 0) {
                int i2 = ak.gu(ad.getContext()).y;
                x.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[]{Integer.valueOf(i), r2});
                if (i2 / 2 < i) {
                    try {
                        if (h.ddt != null) {
                            h.lfr = ((int) (((double) h.ddt.getParameters().getMaxZoom()) / ((((double) i) / 3.0d) / 10.0d))) + 1;
                            x.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[]{Integer.valueOf(h.lfr), Integer.valueOf(r2)});
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", new Object[]{e.getMessage()});
                    }
                }
            }
            if (SightCaptureUI.j(this.lqr) == 0) {
                SightCaptureUI.a(this.lqr, SightCaptureUI.k(this.lqr));
            }
        }
    }

    public final void bfh() {
        if (SightCaptureUI.e(this.lqr) != 0 && SightCaptureUI.h(this.lqr) != null && SightCaptureUI.h(this.lqr).lfu) {
            SightCaptureUI.l(this.lqr);
            x.i("MicroMsg.TestCaptureUiEvent", "onLongPress %s", new Object[]{bi.cjd().toString()});
            SightCaptureUI.m(this.lqr);
        }
    }

    public final void bfi() {
        String str = "MicroMsg.TestCaptureUiEvent";
        String str2 = "onLongPressFinish %s, recorder: %s, recordTime: %s";
        Object[] objArr = new Object[3];
        objArr[0] = bi.cjd().toString();
        objArr[1] = SightCaptureUI.n(this.lqr);
        objArr[2] = Long.valueOf(SightCaptureUI.n(this.lqr) != null ? SightCaptureUI.n(this.lqr).bel() : 0);
        x.i(str, str2, objArr);
        if (SightCaptureUI.j(this.lqr) == 0) {
            if (SightCaptureUI.n(this.lqr) == null || SightCaptureUI.n(this.lqr).bel() > 1000 || SightCaptureUI.n(this.lqr).ben() != c.lhC) {
                SightCaptureUI.p(this.lqr);
                return;
            }
            x.i("MicroMsg.SightCaptureUI", "video record too short, cancel and convert to takepicture");
            SightCaptureUI.n(this.lqr).cancel();
            if (SightCaptureUI.j(this.lqr) == 0) {
                SightCaptureUI.o(this.lqr);
            }
        } else if (SightCaptureUI.j(this.lqr) != 1) {
        } else {
            if ((SightCaptureUI.n(this.lqr) == null || SightCaptureUI.n(this.lqr).bel() > 1000) && SightCaptureUI.n(this.lqr) != null) {
                SightCaptureUI.p(this.lqr);
                return;
            }
            x.i("MicroMsg.SightCaptureUI", "video record too short");
            Toast.makeText(this.lqr, f.mmsight_capture_video_too_short, 1).show();
            SightCaptureUI.q(this.lqr);
        }
    }
}
