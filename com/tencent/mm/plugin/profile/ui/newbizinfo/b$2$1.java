package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.mm.R;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.2;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class b$2$1 implements c {
    final /* synthetic */ 2 lYv;

    b$2$1(2 2) {
        this.lYv = 2;
    }

    public final void a(l lVar) {
        lVar.eR(1, R.l.contact_info_biz_more);
        if (a.gd(this.lYv.lYu.guS.field_type)) {
            lVar.eR(2, R.l.contact_info_send_card_biz);
            lVar.eR(3, R.l.contact_info_biz_setting);
            lVar.eR(4, R.l.contact_info_biz_remove);
        }
    }
}
