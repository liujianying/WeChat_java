package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.j.a;

class MailAddrListUI$1 extends a {
    final /* synthetic */ MailAddrListUI mgK;

    MailAddrListUI$1(MailAddrListUI mailAddrListUI) {
        this.mgK = mailAddrListUI;
    }

    public final void onComplete() {
        if (MailAddrListUI.a(this.mgK) != null) {
            MailAddrListUI.a(this.mgK).dismiss();
        }
        MailAddrListUI.a(this.mgK, MailAddrListUI.b(this.mgK).JS(null));
        if (MailAddrListUI.c(this.mgK).size() == 0) {
            MailAddrListUI.d(this.mgK).setText(R.l.settings_recommend_no_mail_contact);
            MailAddrListUI.d(this.mgK).setVisibility(0);
        }
        String[] stringArrayExtra = this.mgK.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
        for (String JT : stringArrayExtra == null ? new String[]{""} : stringArrayExtra) {
            i JT2 = j.JT(JT);
            if (JT2 != null) {
                int i;
                for (i iVar : MailAddrListUI.c(this.mgK)) {
                    if (iVar.kCs.equalsIgnoreCase(JT2.kCs)) {
                        MailAddrListUI.e(this.mgK).c(iVar);
                        i = 1;
                        break;
                    }
                }
                i = 0;
                if (i == 0) {
                    MailAddrListUI.e(this.mgK).c(JT2);
                }
            }
        }
        this.mgK.setMMTitle(this.mgK.getString(R.l.plugin_qqmail_addrlist_title) + (MailAddrListUI.e(this.mgK).boX() > 0 ? "(" + MailAddrListUI.e(this.mgK).boX() + ")" : ""));
        MailAddrListUI.e(this.mgK).notifyDataSetChanged();
    }
}
