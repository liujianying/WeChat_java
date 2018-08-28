package com.tencent.mm.plugin.sight.decode.ui;

import android.view.animation.AnimationUtils;
import com.tencent.mm.plugin.ak.a.a;
import com.tencent.mm.plugin.sight.decode.ui.c.1;

class c$1$2 implements Runnable {
    final /* synthetic */ 1 ndS;

    c$1$2(1 1) {
        this.ndS = 1;
    }

    public final void run() {
        c.d(this.ndS.ndR).setVisibility(0);
        c.d(this.ndS.ndR).startAnimation(AnimationUtils.loadAnimation(this.ndS.ndR.getContext(), a.fast_faded_in));
    }
}
