package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.bind.ui.d.a;

class d$a$1 implements OnClickListener {
    final /* synthetic */ d eIK;
    final /* synthetic */ a eIL;

    d$a$1(a aVar, d dVar) {
        this.eIL = aVar;
        this.eIK = dVar;
    }

    public final void onClick(View view) {
        if (d.f(this.eIL.eIE) != null) {
            d.f(this.eIL.eIE).c(this.eIL.eIy, this.eIL.account, this.eIL.status);
        }
    }
}
