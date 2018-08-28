package com.tencent.mm.plugin.fts;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.fts.a.d.c.a;
import com.tencent.mm.plugin.fts.c.3;

class c$3$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ String dFT;
    final /* synthetic */ 3 joX;

    c$3$1(3 3, String str, Bitmap bitmap) {
        this.joX = 3;
        this.dFT = str;
        this.abc = bitmap;
    }

    public final void run() {
        if (this.dFT.equals(this.joX.joW.getTag())) {
            a.a(this.joX.val$context.getResources(), this.abc, this.joX.joW);
        }
    }
}
