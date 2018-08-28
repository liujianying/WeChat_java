package com.tencent.mm.plugin.sight.encode.ui;

import android.view.animation.TranslateAnimation;

class MainSightForwardContainerView$3 implements Runnable {
    final /* synthetic */ MainSightForwardContainerView nfL;

    public MainSightForwardContainerView$3(MainSightForwardContainerView mainSightForwardContainerView) {
        this.nfL = mainSightForwardContainerView;
    }

    public final void run() {
        MainSightSelectContactView a = MainSightForwardContainerView.a(this.nfL);
        a.nfB = false;
        a.CU.clearAnimation();
        a.CU.clearFocus();
        a.CU.setAdapter(a.ngi);
        a.C(false, true);
        a.setVisibility(0);
        if (a.ngh == null) {
            a.ngh = new TranslateAnimation(0.0f, 0.0f, (float) a.ngf, 0.0f);
            a.ngh.setDuration(300);
        }
        a.CU.startAnimation(a.ngh);
    }
}
