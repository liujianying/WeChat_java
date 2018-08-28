package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.au;
import com.tencent.mm.y.m;

class r$1 implements OnClickListener {
    final /* synthetic */ String dMs;
    final /* synthetic */ m hrc;

    r$1(m mVar, String str) {
        this.hrc = mVar;
        this.dMs = str;
    }

    public final void onClick(View view) {
        au auVar = (au) view.getTag();
        x.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", new Object[]{this.hrc.dzD});
        qu quVar = new qu();
        quVar.cbq.userName = this.hrc.dzD;
        quVar.cbq.cbs = this.hrc.dzE;
        quVar.cbq.cbt = this.hrc.dzG;
        quVar.cbq.cbu = this.hrc.dzF;
        quVar.cbq.cbx = true;
        quVar.cbq.scene = 1076;
        quVar.cbq.bGG = this.dMs + ":" + auVar.bXQ.field_msgSvrId + ":" + auVar.pSA;
        a.sFg.m(quVar);
    }
}
