package com.tencent.mm.plugin.wallet_core.e;

import android.widget.ImageView;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.wallet_core.e.a.b;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.bi;

class a$5 implements Runnable {
    final /* synthetic */ ImageView ixr;
    final /* synthetic */ a pAV;
    final /* synthetic */ b pAW;
    final /* synthetic */ e pAY;

    a$5(a aVar, e eVar, ImageView imageView, b bVar) {
        this.pAV = aVar;
        this.pAY = eVar;
        this.ixr = imageView;
        this.pAW = bVar;
    }

    public final void run() {
        if (!bi.oW(this.pAY.pmo)) {
            this.ixr.setImageBitmap(y.a(new c(this.pAY.pmo)));
            y.a(this.pAW);
        } else if (this.pAY.pms > 0) {
            this.ixr.setImageResource(this.pAY.pms);
        }
    }
}
