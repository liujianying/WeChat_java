package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.viewitems.s.18;

class s$18$1 implements c {
    final /* synthetic */ 18 ucF;

    s$18$1(18 18) {
        this.ucF = 18;
    }

    public final void a(l lVar) {
        if (this.ucF.ucD) {
            lVar.a(1, s.b(this.ucF.ucn).tTq.getMMResources().getColor(R.e.green_text_color), s.b(this.ucF.ucn).tTq.getMMResources().getString(R.l.notify_message_settings_receive_app_brand_msg));
        } else {
            lVar.a(0, s.b(this.ucF.ucn).tTq.getMMResources().getColor(R.e.red_text_color), s.b(this.ucF.ucn).tTq.getMMResources().getString(R.l.notify_message_settings_ban_receive_app_brand_msg));
        }
    }
}
