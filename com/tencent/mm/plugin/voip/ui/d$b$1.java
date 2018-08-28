package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.voip.ui.d.b;

class d$b$1 implements Runnable {
    final /* synthetic */ Bitmap oQB;
    final /* synthetic */ b oQD;

    d$b$1(b bVar, Bitmap bitmap) {
        this.oQD = bVar;
        this.oQB = bitmap;
    }

    public final void run() {
        if (this.oQD.oQA.oQt != null) {
            this.oQD.oQA.oQt.setBackgroundDrawable(new BitmapDrawable(this.oQB));
            this.oQD.oQA.oQt.getBackground().setAlpha(230);
            this.oQD.oQA.oQt.getBackground().setFilterBitmap(true);
        }
        d.b(this.oQD.oQA);
    }
}
