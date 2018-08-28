package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.voip.ui.e.a;

class e$a$1 implements Runnable {
    final /* synthetic */ Bitmap oQB;
    final /* synthetic */ a oSi;

    e$a$1(a aVar, Bitmap bitmap) {
        this.oSi = aVar;
        this.oQB = bitmap;
    }

    public final void run() {
        if (this.oSi.oSe.oQs != null) {
            this.oSi.oSe.oQs.setBackgroundDrawable(new BitmapDrawable(this.oQB));
        }
        this.oSi.oSe.oRK = null;
    }
}
