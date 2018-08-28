package com.tencent.mm.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class h$14 implements Runnable {
    final /* synthetic */ h tiG;
    final /* synthetic */ View tiT;

    h$14(h hVar, View view) {
        this.tiG = hVar;
        this.tiT = view;
    }

    public final void run() {
        this.tiT.setVisibility(8);
        this.tiT.startAnimation(AnimationUtils.loadAnimation(this.tiG.getContext(), R.a.fast_faded_out));
    }
}
