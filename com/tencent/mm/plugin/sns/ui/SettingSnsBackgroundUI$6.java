package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class SettingSnsBackgroundUI$6 implements OnClickListener {
    final /* synthetic */ SettingSnsBackgroundUI nRb;

    SettingSnsBackgroundUI$6(SettingSnsBackgroundUI settingSnsBackgroundUI) {
        this.nRb = settingSnsBackgroundUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.nRb.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
