package com.tencent.mm.ui.applet;

import android.widget.Toast;
import com.tencent.mm.bv.d.b;
import com.tencent.mm.ui.applet.d.a;

class d$a$1 implements b {
    final /* synthetic */ a tse;

    d$a$1(a aVar) {
        this.tse = aVar;
    }

    public final void cox() {
        this.tse.gC(this.tse.context);
        Toast.makeText(this.tse.context, "trace file has saved ", 0).show();
    }
}
