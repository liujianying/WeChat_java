package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.c.u;

class o$4 implements OnClickListener {
    final /* synthetic */ o pxX;

    o$4(o oVar) {
        this.pxX = oVar;
    }

    public final void onClick(View view) {
        if (this.pxX.pxH == 0) {
            o.a(this.pxX);
        } else if (this.pxX.pxH == 1) {
            u.d(this.pxX.mpb == null ? 0 : this.pxX.mpb.bVY, this.pxX.mpb == null ? "" : this.pxX.mpb.bOd, 19, "");
            o.b(this.pxX);
        }
        if (this.pxX.pxH == 1) {
            o.bQB();
            if (o.c(this.pxX)) {
                o.d(this.pxX);
            }
        }
    }
}
