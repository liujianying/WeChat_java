package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.ContactsSyncUI.a;
import com.tencent.mm.sdk.platformtools.ad;

class ContactsSyncUI$a$2 implements OnClickListener {
    final /* synthetic */ a ePK;
    final /* synthetic */ String ePL;
    final /* synthetic */ Context val$context;

    ContactsSyncUI$a$2(a aVar, Context context, String str) {
        this.ePK = aVar;
        this.val$context = context;
        this.ePL = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.Ei().DT().set(12322, Boolean.valueOf(true));
        this.ePK.ePH.getSharedPreferences(ad.chY(), 0).edit().putBoolean("upload_contacts_already_displayed", true).commit();
        this.ePK.N(this.val$context, this.ePL);
        if (this.val$context instanceof Activity) {
            ((Activity) this.val$context).finish();
        }
    }
}
