package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.sl.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.s;

class s$2 implements e {
    final /* synthetic */ bd dAs;
    final /* synthetic */ String qiU;
    final /* synthetic */ s ucn;
    final /* synthetic */ az uct;
    final /* synthetic */ boolean ucu;

    s$2(s sVar, bd bdVar, az azVar, boolean z, String str) {
        this.ucn = sVar;
        this.dAs = bdVar;
        this.uct = azVar;
        this.ucu = z;
        this.qiU = str;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(1176, this);
        x.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(true)});
        if (this.dAs != this.uct.ugy.getTag(R.h.new_dyeing_template_ban_toggle_text)) {
            x.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[]{Long.valueOf(this.dAs.field_msgId)});
        } else if (i != 0 || i2 != 0) {
            int i3;
            this.uct.ufU.setVisibility(this.ucu ? 8 : 0);
            s.makeText(s.b(this.ucn).tTq.getContext(), R.l.notify_message_settings_operation_failed, 0).show();
            sl slVar = new sl();
            slVar.cdl.bGy = this.qiU;
            a aVar = slVar.cdl;
            if (this.ucu) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            aVar.action = i3;
            slVar.cdl.cdn = 1;
            com.tencent.mm.sdk.b.a.sFg.m(slVar);
            if (s.b(this.ucn) != null) {
                s.b(this.ucn).avj();
            }
        }
    }
}
