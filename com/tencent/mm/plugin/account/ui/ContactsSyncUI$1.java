package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ContactsSyncUI$1 implements Runnable {
    final /* synthetic */ String ePG;
    final /* synthetic */ ContactsSyncUI ePH;

    ContactsSyncUI$1(ContactsSyncUI contactsSyncUI, String str) {
        this.ePH = contactsSyncUI;
        this.ePG = str;
    }

    public final void run() {
        x.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts [%b], oldPermission[%s], stack[%s]", new Object[]{Boolean.valueOf(a.a(this.ePH, this.ePG.equals("android.permission.READ_CONTACTS") ? "android.permission.WRITE_CONTACTS" : "android.permission.READ_CONTACTS", 48, null, null)), this.ePG, bi.cjd()});
        if (a.a(this.ePH, this.ePG.equals("android.permission.READ_CONTACTS") ? "android.permission.WRITE_CONTACTS" : "android.permission.READ_CONTACTS", 48, null, null)) {
            this.ePH.initView();
        }
    }

    public final String toString() {
        return super.toString() + "|checkContacts";
    }
}
