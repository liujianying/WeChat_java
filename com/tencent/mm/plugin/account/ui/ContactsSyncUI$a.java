package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.model.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

final class ContactsSyncUI$a implements a {
    final /* synthetic */ ContactsSyncUI ePH;
    private boolean ePI;
    private x.a ePJ = new 1(this);

    public ContactsSyncUI$a(ContactsSyncUI contactsSyncUI, boolean z) {
        this.ePH = contactsSyncUI;
        this.ePI = z;
    }

    public final int cm(Context context) {
        g.Eg();
        if (!com.tencent.mm.kernel.a.Dw() || com.tencent.mm.kernel.a.Dr()) {
            return 4;
        }
        if (this.ePI) {
            String str = (String) g.Ei().DT().get(6, "");
            if (bi.oW(str)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ProcessorAddAccount", "not bind mobile phone");
                return 2;
            } else if (!l.XB()) {
                return N(context, str);
            } else {
                h.a(context, j.contact_sync_add_account_alert, j.app_tip, j.app_ok, j.app_cancel, new 2(this, context, str), new 3(this, context));
                return 5;
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ProcessorAddAccount", "no need to bind mobile");
        x.a(this.ePH, this.ePJ);
        return 0;
    }

    final int N(Context context, String str) {
        if (context == null) {
            return 1;
        }
        int a = x.a(context, str, this.ePJ);
        if (a == 2) {
            Toast.makeText(context, this.ePH.getString(j.contact_sync_add_account_failed), 1).show();
            return 1;
        } else if (a != 3) {
            return 0;
        } else {
            Toast.makeText(context, this.ePH.getString(j.contact_sync_add_account_already_exist), 1).show();
            return 1;
        }
    }
}
