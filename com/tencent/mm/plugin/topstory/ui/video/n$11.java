package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.protocal.c.bti;

class n$11 implements OnClickListener {
    final /* synthetic */ n oBM;

    n$11(n nVar) {
        this.oBM = nVar;
    }

    public final void onClick(View view) {
        this.oBM.bIl();
        this.oBM.bIt();
        n.f(this.oBM).bTw();
        n.b(this.oBM).bHU().oAl = 2;
        o bHS = n.b(this.oBM).bHS();
        a b = n.b(this.oBM);
        bti e = n.e(this.oBM);
        String g = n.g(this.oBM);
        int d = n.d(this.oBM);
        b.bHU().b(b.bHT());
        b.bHU().bIe();
        b.bHU().a(e, d, g);
        bHS.oCd.setKeepScreenOn(true);
        bHS.oCd.bIk();
        bHS.oCd.Ov(g);
        bHS.oCf = e;
        bHS.oCg = true;
        bHS.oCh = false;
        this.oBM.bIm();
        if (n.b(this.oBM).bHQ().jMc) {
            a.kB(17);
        } else {
            a.kB(12);
        }
    }
}
