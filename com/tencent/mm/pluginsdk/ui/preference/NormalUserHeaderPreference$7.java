package com.tencent.mm.pluginsdk.ui.preference;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bq;

class NormalUserHeaderPreference$7 implements Runnable {
    final /* synthetic */ bq lUL;
    final /* synthetic */ NormalUserHeaderPreference qPp;

    NormalUserHeaderPreference$7(NormalUserHeaderPreference normalUserHeaderPreference, bq bqVar) {
        this.qPp = normalUserHeaderPreference;
        this.lUL = bqVar;
    }

    public final void run() {
        if (NormalUserHeaderPreference.b(this.qPp) != null && this.lUL != null && NormalUserHeaderPreference.b(this.qPp).field_username.equals(this.lUL.field_encryptUsername)) {
            NormalUserHeaderPreference.b(this.qPp).dv(this.lUL.field_conRemark);
            if (NormalUserHeaderPreference.j(this.qPp)) {
                NormalUserHeaderPreference.f(this.qPp);
            } else {
                x.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.k(this.qPp) + "contact = " + NormalUserHeaderPreference.b(this.qPp).field_username);
            }
        }
    }
}
