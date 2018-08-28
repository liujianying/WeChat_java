package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class SettingsAboutSystemUI$7 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI mRk;

    SettingsAboutSystemUI$7(SettingsAboutSystemUI settingsAboutSystemUI) {
        this.mRk = settingsAboutSystemUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user cancel go set system nfc switch");
    }
}
