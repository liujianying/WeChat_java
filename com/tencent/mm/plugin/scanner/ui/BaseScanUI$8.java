package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher.1;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher.2;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$8 extends c<oo> {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$8(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
        this.sFo = oo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oo ooVar = (oo) bVar;
        if (BaseScanUI.f(this.mHS) != null && BaseScanUI.f(this.mHS).iOl && BaseScanUI.b(this.mHS)) {
            if (ooVar.bZv.bZw) {
                String focusMode = BaseScanUI.f(this.mHS).getFocusMode();
                if (!bi.oW(focusMode) && focusMode.equals("continuous-video")) {
                    BaseScanUI.D(this.mHS);
                    if (BaseScanUI.E(this.mHS) >= 2) {
                        BaseScanUI.F(this.mHS);
                    }
                }
                if (!(BaseScanUI.g(this.mHS) == null || BaseScanUI.g(this.mHS).isShown())) {
                    ScannerFlashSwitcher g = BaseScanUI.g(this.mHS);
                    x.i("MicroMsg.ScannerFlashSwitcher", "show, isFirstShow: %s", new Object[]{Boolean.valueOf(g.mLL)});
                    if (g.mLL) {
                        g.mLJ.setAlpha(0.0f);
                        g.mLK.setAlpha(0.0f);
                        g.setVisibility(0);
                        g.mLK.animate().alpha(1.0f).setListener(null).setDuration(500);
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.addUpdateListener(new 1(g));
                        ofFloat.setRepeatCount(3);
                        ofFloat.setRepeatMode(2);
                        ofFloat.setDuration(500);
                        ofFloat.addListener(new 2(g));
                        ofFloat.start();
                        g.mLL = false;
                    } else {
                        g.setVisibility(0);
                        g.mLK.animate().alpha(1.0f).setDuration(500).setListener(null).start();
                        g.mLJ.animate().alpha(1.0f).setDuration(500).setListener(null).start();
                    }
                    g.setEnabled(true);
                    l.mFT.vz(1);
                    if (BaseScanUI.h(this.mHS) != null) {
                        BaseScanUI.h(this.mHS).hy(false);
                    }
                }
            } else {
                BaseScanUI.F(this.mHS);
                if (!(BaseScanUI.g(this.mHS) == null || BaseScanUI.f(this.mHS).lfJ)) {
                    BaseScanUI.g(this.mHS).hide();
                    if (BaseScanUI.h(this.mHS) != null) {
                        BaseScanUI.h(this.mHS).hy(true);
                    }
                }
            }
        }
        return false;
    }
}
