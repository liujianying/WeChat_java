package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.n;

class b$1 implements OnClickListener {
    final /* synthetic */ n mpx;
    final /* synthetic */ b mpy;

    b$1(b bVar, n nVar) {
        this.mpy = bVar;
        this.mpx = nVar;
    }

    public final void onClick(View view) {
        if (b.a(this.mpy) != null) {
            b.a(this.mpy).a(this.mpx);
        }
    }
}
