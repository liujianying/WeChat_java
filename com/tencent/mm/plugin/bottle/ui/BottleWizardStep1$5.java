package com.tencent.mm.plugin.bottle.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class BottleWizardStep1$5 implements OnClickListener {
    final /* synthetic */ BottleWizardStep1 hlz;

    BottleWizardStep1$5(BottleWizardStep1 bottleWizardStep1) {
        this.hlz = bottleWizardStep1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.hlz.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
