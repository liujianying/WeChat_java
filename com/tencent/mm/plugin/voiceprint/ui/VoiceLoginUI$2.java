package com.tencent.mm.plugin.voiceprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class VoiceLoginUI$2 implements OnClickListener {
    final /* synthetic */ VoiceLoginUI oGl;

    VoiceLoginUI$2(VoiceLoginUI voiceLoginUI) {
        this.oGl = voiceLoginUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.oGl.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
