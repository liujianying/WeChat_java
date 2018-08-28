package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class SnsUserUI$5 implements OnClickListener {
    final /* synthetic */ SnsUserUI ohd;

    SnsUserUI$5(SnsUserUI snsUserUI) {
        this.ohd = snsUserUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.ohd.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
