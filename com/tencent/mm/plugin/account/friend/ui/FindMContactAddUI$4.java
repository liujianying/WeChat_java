package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class FindMContactAddUI$4 implements OnClickListener {
    final /* synthetic */ FindMContactAddUI eLW;

    FindMContactAddUI$4(FindMContactAddUI findMContactAddUI) {
        this.eLW = findMContactAddUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.eLW.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        FindMContactAddUI.q(this.eLW);
        this.eLW.finish();
    }
}
