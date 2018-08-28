package com.tencent.mm.plugin.card.d;

import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

class m$2 implements Runnable {
    final /* synthetic */ int fdh;
    final /* synthetic */ ImageView hIK;
    final /* synthetic */ int hIL;

    m$2(ImageView imageView, int i, int i2) {
        this.hIK = imageView;
        this.hIL = i;
        this.fdh = i2;
    }

    public final void run() {
        this.hIK.setImageResource(this.hIL);
        this.hIK.setColorFilter(this.fdh, Mode.SRC_IN);
    }
}
