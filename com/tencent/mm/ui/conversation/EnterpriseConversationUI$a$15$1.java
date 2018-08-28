package com.tencent.mm.ui.conversation;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.15;
import com.tencent.mm.ui.g;

class EnterpriseConversationUI$a$15$1 implements c {
    final /* synthetic */ 15 uqC;

    EnterpriseConversationUI$a$15$1(15 15) {
        this.uqC = 15;
    }

    public final void a(l lVar) {
        if (a.e(this.uqC.uqA) == 1) {
            lVar.ak(2, R.l.enterprise_wework_open_menu, R.k.actionbar_goto_wework_icon);
            g.n(this.uqC.uqA.getContext(), a.c(this.uqC.uqA), 5);
        }
        lVar.ak(3, R.l.contact_info_send_card_biz, R.k.ofm_send_icon);
        lVar.ak(4, R.l.enterprise_disable, R.k.actionbar_goto_disabled_biz_icon);
        lVar.ak(5, R.l.actionbar_title_setting, R.k.actionbar_setting_icon);
    }
}
