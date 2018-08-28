package com.tencent.mm.plugin.address.ui;

import android.view.View;
import com.tencent.mm.bp.a;

class MMScrollView$1 implements Runnable {
    final /* synthetic */ MMScrollView eZs;
    final /* synthetic */ View val$view;

    MMScrollView$1(MMScrollView mMScrollView, View view) {
        this.eZs = mMScrollView;
        this.val$view = view;
    }

    public final void run() {
        this.eZs.scrollTo(0, this.val$view.getTop() - a.fromDPToPix(this.eZs.getContext(), 10));
    }
}
