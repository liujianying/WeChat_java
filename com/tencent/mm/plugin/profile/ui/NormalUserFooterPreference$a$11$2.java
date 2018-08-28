package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.11;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class NormalUserFooterPreference$a$11$2 implements c {
    final /* synthetic */ 11 lXF;

    NormalUserFooterPreference$a$11$2(11 11) {
        this.lXF = 11;
    }

    public final void a(l lVar) {
        if (!this.lXF.lXD) {
            if (ab.XR(NormalUserFooterPreference.a(this.lXF.lXy.lXw).field_username)) {
                lVar.ak(1, R.l.contact_set_des_only, R.k.bottomsheet_icon_remarks);
            } else {
                lVar.ak(1, R.l.contact_info_mod_remark_labelinfo, R.k.bottomsheet_icon_remarks);
            }
        }
        if (!this.lXF.lXE) {
            if (NormalUserFooterPreference.a(this.lXF.lXy.lXw).BA()) {
                lVar.ak(8, R.l.contact_info_moveout_blacklist, R.k.bottomsheet_icon_blacklist);
            } else if (!s.hd(NormalUserFooterPreference.a(this.lXF.lXy.lXw).field_username)) {
                lVar.ak(5, R.l.contact_info_movein_blacklist, R.k.bottomsheet_icon_blacklist);
            }
        }
    }
}
