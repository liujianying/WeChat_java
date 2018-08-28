package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class SnsUploadUI$8 implements OnClickListener {
    final /* synthetic */ SnsUploadUI ogU;

    SnsUploadUI$8(SnsUploadUI snsUploadUI) {
        this.ogU = snsUploadUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.ogU.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        dialogInterface.dismiss();
    }
}
