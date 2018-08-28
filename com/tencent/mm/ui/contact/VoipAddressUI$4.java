package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class VoipAddressUI$4 implements OnClickListener {
    final /* synthetic */ VoipAddressUI umm;

    VoipAddressUI$4(VoipAddressUI voipAddressUI) {
        this.umm = voipAddressUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.umm.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
