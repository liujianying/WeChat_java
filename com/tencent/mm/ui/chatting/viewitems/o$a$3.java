package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.protocal.c.buq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.o.d;

class o$a$3 implements a {
    final /* synthetic */ d ubF;
    final /* synthetic */ o.a ubG;

    o$a$3(o.a aVar, d dVar) {
        this.ubG = aVar;
        this.ubF = dVar;
    }

    public final void a(String str, buq buq) {
        x.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", new Object[]{str, buq.content});
        if (this.ubF.ubK == null) {
            x.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
            return;
        }
        String str2 = (String) this.ubF.ubK.getTag();
        if (bi.oW(str2)) {
            x.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
        } else if (str2.equals(str)) {
            this.ubF.ubK.setVisibility(0);
            this.ubF.ubK.setText(buq.content);
            this.ubF.ubK.setTextColor(bi.bc(buq.slj, this.ubF.ubK.getCurrentTextColor()));
        }
    }
}
