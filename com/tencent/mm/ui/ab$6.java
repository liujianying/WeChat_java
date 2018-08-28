package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class ab$6 implements Runnable {
    final /* synthetic */ View tiT;
    final /* synthetic */ ab toE;

    ab$6(ab abVar, View view) {
        this.toE = abVar;
        this.tiT = view;
    }

    public final void run() {
        this.tiT.setVisibility(8);
        this.tiT.startAnimation(AnimationUtils.loadAnimation(this.toE.getContext(), R.a.fast_faded_out));
    }
}
