package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.wallet_core.ui.view.b.a;

class b$a$2 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ a pzs;

    b$a$2(a aVar, Bitmap bitmap) {
        this.pzs = aVar;
        this.abc = bitmap;
    }

    public final void run() {
        this.pzs.pcG.setImageBitmap(this.abc);
    }
}
