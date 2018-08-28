package com.tencent.mm.ui.chatting.f;

import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a tXT;

    a$1(a aVar) {
        this.tXT = aVar;
    }

    public final void run() {
        this.tXT.bXQ.setType(10002);
        t.a(ad.getContext().getString(R.l.chatting_revoke_msg_tips), "", this.tXT.bXQ, "");
        au.HU();
        c.FT().a(this.tXT.bXQ.field_msgId, this.tXT.bXQ);
        x.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", new Object[]{Long.valueOf(this.tXT.bXQ.field_msgId)});
    }
}
