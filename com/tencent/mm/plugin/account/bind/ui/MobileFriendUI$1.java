package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class MobileFriendUI$1 implements OnClickListener {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$1(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.eIS.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        this.eIS.finish();
    }
}
