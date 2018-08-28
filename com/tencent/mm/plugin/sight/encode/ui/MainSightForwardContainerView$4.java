package com.tencent.mm.plugin.sight.encode.ui;

import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class MainSightForwardContainerView$4 implements Runnable {
    final /* synthetic */ MainSightForwardContainerView nfL;

    MainSightForwardContainerView$4(MainSightForwardContainerView mainSightForwardContainerView) {
        this.nfL = mainSightForwardContainerView;
    }

    public final void run() {
        if (!MainSightForwardContainerView.b(this.nfL) || (MainSightForwardContainerView.a(this.nfL) != null && MainSightForwardContainerView.a(this.nfL).ngg.bwr())) {
            MainSightForwardContainerView.c(this.nfL);
            return;
        }
        MainSightForwardContainerView.d(this.nfL).setVisibility(0);
        if (MainSightForwardContainerView.a(this.nfL) != null && !MainSightForwardContainerView.a(this.nfL).bwx() && MainSightForwardContainerView.e(this.nfL).getVisibility() != 0) {
            MainSightForwardContainerView.e(this.nfL).setVisibility(0);
            MainSightForwardContainerView.e(this.nfL).startAnimation(AnimationUtils.loadAnimation(MainSightForwardContainerView.f(this.nfL), R.a.fast_faded_in));
        }
    }
}
