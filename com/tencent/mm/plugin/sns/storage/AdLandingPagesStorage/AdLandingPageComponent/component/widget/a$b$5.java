package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.b;

class a$b$5 implements Runnable {
    final /* synthetic */ b nGF;

    a$b$5(b bVar) {
        this.nGF = bVar;
    }

    public final void run() {
        if (a.q(this.nGF.nGD) != null) {
            View bvP = a.q(this.nGF.nGD).bvP();
            if (bvP != null) {
                if (!(a.C(this.nGF.nGD) != null || a.q(this.nGF.nGD).bvQ() == -1 || a.k(this.nGF.nGD).get() == null)) {
                    a.a(this.nGF.nGD, AnimationUtils.loadAnimation(((View) a.k(this.nGF.nGD).get()).getContext(), a.q(this.nGF.nGD).bvQ()));
                }
                if (a.C(this.nGF.nGD) != null) {
                    bvP.startAnimation(a.C(this.nGF.nGD));
                }
                bvP.setVisibility(0);
            }
        }
    }
}
