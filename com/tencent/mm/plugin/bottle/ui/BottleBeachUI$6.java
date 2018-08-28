package com.tencent.mm.plugin.bottle.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class BottleBeachUI$6 implements OnClickListener {
    final /* synthetic */ BottleBeachUI hkL;

    BottleBeachUI$6(BottleBeachUI bottleBeachUI) {
        this.hkL = bottleBeachUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.hkL.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
