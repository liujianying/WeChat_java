package com.tencent.mm.ui.bizchat;

import com.tencent.mm.R;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a.5;
import com.tencent.mm.ui.g;

class BizChatConversationUI$a$5$1 implements c {
    final /* synthetic */ 5 tED;

    BizChatConversationUI$a$5$1(5 5) {
        this.tED = 5;
    }

    public final void a(l lVar) {
        if (a.l(this.tED.tEC) == 1) {
            lVar.ak(2, R.l.enterprise_wework_open_menu, R.k.actionbar_goto_wework_icon);
            g.n(this.tED.tEC.getContext(), a.a(this.tED.tEC), 6);
        }
        lVar.ak(1, R.l.bizchat_new_chat, R.k.actionbar_create_biz_chat_icon);
        lVar.a(4, this.tED.tEC.getResources().getString(R.l.bizchat_fav), an.ao(this.tED.tEC.getContext(), R.k.actionbar_facefriend_icon));
        lVar.a(3, this.tED.tEC.getResources().getString(R.l.actionbar_title_setting), an.ao(this.tED.tEC.getContext(), R.k.actionbar_setting_icon));
    }
}
