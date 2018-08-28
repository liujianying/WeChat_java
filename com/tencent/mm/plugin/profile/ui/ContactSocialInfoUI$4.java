package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.aa.a;

class ContactSocialInfoUI$4 implements OnClickListener {
    final /* synthetic */ ContactSocialInfoUI lVD;

    ContactSocialInfoUI$4(ContactSocialInfoUI contactSocialInfoUI) {
        this.lVD = contactSocialInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ContactSocialInfoUI.d(this.lVD);
        au.HU();
        c.DT().a(a.sRZ, Integer.valueOf(1));
    }
}
