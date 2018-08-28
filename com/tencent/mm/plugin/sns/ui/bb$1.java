package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;

class bb$1 implements Runnable {
    final /* synthetic */ bb ogl;

    bb$1(bb bbVar) {
        this.ogl = bbVar;
    }

    public final void run() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        bb.a(this.ogl).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        af.byd();
        s.dA(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
