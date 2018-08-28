package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class c$19 implements c {
    final /* synthetic */ c lVT;

    c$19(c cVar) {
        this.lVT = cVar;
    }

    public final void a(l lVar) {
        if (this.lVT.lUs != null && this.lVT.lUs.LY()) {
            lVar.eR(1, R.l.contact_info_send_card_biz);
            lVar.eR(3, R.l.biz_report_text);
            lVar.eR(4, R.l.contact_info_biz_remove);
            lVar.eR(5, R.l.contact_info_add_shortcut);
        } else if (this.lVT.lUs == null || !this.lVT.lUs.LZ()) {
            lVar.eR(1, R.l.contact_info_send_card_biz);
            lVar.eR(2, R.l.contact_info_biz_clear_msg);
            if (!s.hW(this.lVT.guS.field_username)) {
                lVar.eR(3, R.l.biz_report_text);
                lVar.eR(4, R.l.contact_info_biz_remove);
            }
            lVar.eR(5, R.l.contact_info_add_shortcut);
        } else {
            lVar.eR(5, R.l.contact_info_add_shortcut);
        }
    }
}
