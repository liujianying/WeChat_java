package com.tencent.mm.plugin.wallet_core.e;

import android.widget.ImageView;
import com.tencent.mm.plugin.wallet_core.model.e;

class a$6 implements Runnable {
    final /* synthetic */ ImageView ixr;
    final /* synthetic */ a pAV;
    final /* synthetic */ e pAY;

    a$6(a aVar, ImageView imageView, e eVar) {
        this.pAV = aVar;
        this.ixr = imageView;
        this.pAY = eVar;
    }

    public final void run() {
        this.ixr.setImageResource(this.pAY.pmq);
    }
}
