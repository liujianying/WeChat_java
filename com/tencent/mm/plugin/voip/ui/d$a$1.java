package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.voip.ui.d.a;

class d$a$1 implements Runnable {
    final /* synthetic */ Bitmap oQB;
    final /* synthetic */ a oQC;

    d$a$1(a aVar, Bitmap bitmap) {
        this.oQC = aVar;
        this.oQB = bitmap;
    }

    public final void run() {
        if (this.oQC.oQA.oQs != null) {
            this.oQC.oQA.oQs.setBackgroundDrawable(new BitmapDrawable(this.oQB));
            this.oQC.oQA.oQs.getBackground().setAlpha(128);
        }
        this.oQC.oQA.oQy = null;
    }
}
