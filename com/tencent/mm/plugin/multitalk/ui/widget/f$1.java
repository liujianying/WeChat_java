package com.tencent.mm.plugin.multitalk.ui.widget;

import com.tencent.mm.R;

class f$1 implements Runnable {
    final /* synthetic */ f lwj;

    f$1(f fVar) {
        this.lwj = fVar;
    }

    public final void run() {
        f.a(this.lwj).setText(R.l.multitalk_end_wording);
    }
}
