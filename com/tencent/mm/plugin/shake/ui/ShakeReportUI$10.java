package com.tencent.mm.plugin.shake.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.an.b;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.d.a.h;
import java.util.ArrayList;
import java.util.Collection;

class ShakeReportUI$10 implements AnimationListener {
    final /* synthetic */ ShakeReportUI nbh;

    ShakeReportUI$10(ShakeReportUI shakeReportUI) {
        this.nbh = shakeReportUI;
    }

    public final void onAnimationStart(Animation animation) {
        ShakeReportUI.c(this.nbh, false);
        ShakeReportUI.e(this.nbh, true);
        ShakeReportUI.f(this.nbh, false);
        ShakeReportUI.g(this.nbh, true);
        ShakeReportUI.z(this.nbh);
    }

    public final void onAnimationEnd(Animation animation) {
        ShakeReportUI.f(this.nbh, true);
        ShakeReportUI.g(this.nbh, false);
        if (!ShakeReportUI.A(this.nbh)) {
            ShakeReportUI.a(this.nbh, true);
            ShakeReportUI.d(this.nbh, true);
            ShakeReportUI.B(this.nbh);
            if (ShakeReportUI.C(this.nbh).mWO == 3) {
                b.PW();
            } else if (ShakeReportUI.C(this.nbh).mWO == 5) {
                l.b bVar = ShakeReportUI.C(this.nbh).mWP;
                if (bVar != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    Collection arrayList = new ArrayList();
                    arrayList.addAll(ShakeReportUI.bvz());
                    hVar.mYI = arrayList;
                }
            }
            ShakeReportUI.C(this.nbh).mWP.start();
        }
        ShakeReportUI.e(this.nbh, false);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
