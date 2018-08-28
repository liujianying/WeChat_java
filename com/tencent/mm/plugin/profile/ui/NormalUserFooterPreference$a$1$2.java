package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class NormalUserFooterPreference$a$1$2 implements c {
    final /* synthetic */ 1 lXz;

    NormalUserFooterPreference$a$1$2(1 1) {
        this.lXz = 1;
    }

    public final void a(l lVar) {
        CharSequence string;
        if (ab.XR(NormalUserFooterPreference.a(this.lXz.lXy.lXw).field_username)) {
            lVar.ak(1, R.l.contact_set_des_only, R.k.bottomsheet_icon_remarks);
        } else {
            lVar.ak(1, R.l.contact_info_mod_remark_labelinfo, R.k.bottomsheet_icon_remarks);
        }
        if (NormalUserFooterPreference.a(this.lXz.lXy.lXw).BC()) {
            string = NormalUserFooterPreference.b(this.lXz.lXy.lXw).getResources().getString(R.l.contact_info_unset_favour_start_biz);
        } else {
            string = NormalUserFooterPreference.b(this.lXz.lXy.lXw).getResources().getString(R.l.contact_info_favour_start_biz);
        }
        lVar.a(2, string, R.k.bottomsheet_icon_star);
        if (!ab.XR(NormalUserFooterPreference.a(this.lXz.lXy.lXw).field_username)) {
            lVar.ak(3, R.l.contact_info_op_sns_permission, R.k.bottomsheet_icon_moment);
        }
        lVar.ak(4, R.l.contact_info_send_card_normal, R.k.bottomsheet_icon_transmit);
        lVar.ak(9, R.l.biz_report_text, R.k.bottomsheet_icon_complain);
        if (NormalUserFooterPreference.a(this.lXz.lXy.lXw).BA()) {
            string = NormalUserFooterPreference.b(this.lXz.lXy.lXw).getString(R.l.contact_info_moveout_blacklist);
        } else {
            string = NormalUserFooterPreference.b(this.lXz.lXy.lXw).getString(R.l.contact_info_movein_blacklist);
        }
        lVar.a(5, string, R.k.bottomsheet_icon_blacklist);
        if (!NormalUserFooterPreference.c(this.lXz.lXy.lXw)) {
            lVar.ak(6, R.l.bind_mcontact_del_btn_text, R.k.bottomsheet_icon_del);
        }
        lVar.ak(7, R.l.contact_info_add_shortcut, R.k.bottomsheet_icon_desktop);
    }
}
