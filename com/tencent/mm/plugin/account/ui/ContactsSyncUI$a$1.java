package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.mm.platformtools.x$a;
import com.tencent.mm.plugin.account.ui.ContactsSyncUI.a;

class ContactsSyncUI$a$1 implements x$a {
    final /* synthetic */ a ePK;

    ContactsSyncUI$a$1(a aVar) {
        this.ePK = aVar;
    }

    public final void l(Bundle bundle) {
        ContactsSyncUI contactsSyncUI = this.ePK.ePH;
        contactsSyncUI.ePF = bundle;
        contactsSyncUI.finish();
    }
}
