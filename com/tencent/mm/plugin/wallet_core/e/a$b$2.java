package com.tencent.mm.plugin.wallet_core.e;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.wallet_core.e.a.b;

class a$b$2 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ ImageView ixr;
    final /* synthetic */ b pBh;

    a$b$2(b bVar, ImageView imageView, Bitmap bitmap) {
        this.pBh = bVar;
        this.ixr = imageView;
        this.abc = bitmap;
    }

    public final void run() {
        this.ixr.setImageBitmap(this.abc);
    }
}
