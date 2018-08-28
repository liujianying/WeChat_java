package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.websearch.api.a.a;

class n$2 implements OnClickListener {
    final /* synthetic */ n oBM;

    n$2(n nVar) {
        this.oBM = nVar;
    }

    public final void onClick(View view) {
        a.kB(21);
        n.c(this.oBM, !n.q(this.oBM));
        n.b(this.oBM).bHS().setMute(n.q(this.oBM));
        if (n.q(this.oBM)) {
            n.f(this.oBM).Bo();
        } else {
            n.f(this.oBM).bTu();
        }
        n.f(this.oBM).bTw();
    }
}
