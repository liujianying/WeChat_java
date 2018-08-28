package com.tencent.mm.plugin.sight.decode.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.mm.plugin.sight.decode.a.b.k;

class b$k$1 implements Runnable {
    final /* synthetic */ View eHJ;
    final /* synthetic */ Bitmap ndf;
    final /* synthetic */ k ndg;

    b$k$1(k kVar, View view, Bitmap bitmap) {
        this.ndg = kVar;
        this.eHJ = view;
        this.ndf = bitmap;
    }

    public final void run() {
        this.eHJ.setBackgroundDrawable(new BitmapDrawable(this.ndf));
    }
}
