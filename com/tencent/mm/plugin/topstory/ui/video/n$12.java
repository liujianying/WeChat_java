package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b;

class n$12 implements OnClickListener {
    final /* synthetic */ n oBM;

    n$12(n nVar) {
        this.oBM = nVar;
    }

    public final void onClick(View view) {
        if (!n.b(this.oBM).bHQ().jMc && n.c(this.oBM) != null && n.c(this.oBM).bIE() != n.b(this.oBM).bHP()) {
            n.b(this.oBM).bHU().oAl = 2;
            n.b(this.oBM).ye(n.d(this.oBM));
            n.b(this.oBM).bHU().b(n.e(this.oBM));
            ((b) g.n(b.class)).getReporter().a(n.b(this.oBM).bHT(), n.e(this.oBM), n.d(this.oBM), 2, "");
        }
    }
}
