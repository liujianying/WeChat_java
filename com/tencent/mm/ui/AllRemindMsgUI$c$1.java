package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.AllRemindMsgUI.c;
import com.tencent.mm.ui.AllRemindMsgUI.d;

class AllRemindMsgUI$c$1 implements OnClickListener {
    final /* synthetic */ AllRemindMsgUI tgj;
    final /* synthetic */ c tgk;

    AllRemindMsgUI$c$1(c cVar, AllRemindMsgUI allRemindMsgUI) {
        this.tgk = cVar;
        this.tgj = allRemindMsgUI;
    }

    public final void onClick(View view) {
        d dVar = (d) view.getTag();
        x.i("MicroMsg.emoji.AllRemindMsgUI", "[onClick] :%s", new Object[]{dVar});
        c.a(this.tgk.tgf, dVar.username, dVar.bJC);
    }
}
