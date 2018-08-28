package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.ContactsSyncUI.a;
import com.tencent.mm.sdk.platformtools.ad;

class ContactsSyncUI$a$3 implements OnClickListener {
    final /* synthetic */ a ePK;
    final /* synthetic */ Context val$context;

    ContactsSyncUI$a$3(a aVar, Context context) {
        this.ePK = aVar;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.Ei().DT().set(12322, Boolean.valueOf(false));
        this.ePK.ePH.getSharedPreferences(ad.chY(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
        if (this.val$context instanceof Activity) {
            ((Activity) this.val$context).finish();
        }
    }
}
