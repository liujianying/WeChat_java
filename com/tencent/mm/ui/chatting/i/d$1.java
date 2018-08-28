package com.tencent.mm.ui.chatting.i;

import android.view.View;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.ui.chatting.i.a.b;

class d$1 extends a {
    final /* synthetic */ a$a tYU;
    final /* synthetic */ d tYV;

    d$1(d dVar, a$a a_a) {
        this.tYV = dVar;
        this.tYU = a_a;
    }

    public final void onClickImp(View view) {
        d dVar = this.tYV;
        a$a a_a = this.tYU;
        if (dVar.tYP != null && dVar.tYP.get() != null) {
            ((b) dVar.tYP.get()).a(view, a_a);
        }
    }
}
