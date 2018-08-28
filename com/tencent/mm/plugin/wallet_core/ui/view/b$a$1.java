package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.wallet_core.ui.view.b.a;

class b$a$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ a pzs;

    b$a$1(a aVar, Bitmap bitmap) {
        this.pzs = aVar;
        this.abc = bitmap;
    }

    public final void run() {
        this.pzs.pcH.setImageBitmap(this.abc);
        this.pzs.pzn.invalidate();
    }
}
