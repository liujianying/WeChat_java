package com.tencent.mm.ui.chatting.b;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class ab$2 implements Runnable {
    final /* synthetic */ bd dAB;
    final /* synthetic */ ab tRg;
    final /* synthetic */ View val$view;

    ab$2(ab abVar, bd bdVar, View view) {
        this.tRg = abVar;
        this.dAB = bdVar;
        this.val$view = view;
    }

    public final void run() {
        x.i("MicroMsg.NewXmlSysMsgComponent", "[handleClickInvokeMessageSysText] is over time to delete invokeMsg:%s", new Object[]{Long.valueOf(this.dAB.field_msgId)});
        t.a(this.tRg.bAG.tTq.getMMResources().getString(R.l.chatting_revoke_msg_tips), "", this.dAB, "");
        au.HU();
        c.FT().a(this.dAB.field_msgId, this.dAB);
        ah.A(new 1(this));
    }
}
