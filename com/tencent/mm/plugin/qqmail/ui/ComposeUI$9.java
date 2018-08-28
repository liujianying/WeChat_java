package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ComposeUI$9 implements OnClickListener {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$9(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mfs.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
