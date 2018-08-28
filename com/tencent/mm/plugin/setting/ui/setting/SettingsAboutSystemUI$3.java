package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;

class SettingsAboutSystemUI$3 implements OnClickListener {
    final /* synthetic */ SettingsAboutSystemUI mRk;

    SettingsAboutSystemUI$3(SettingsAboutSystemUI settingsAboutSystemUI) {
        this.mRk = settingsAboutSystemUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.bf(!a.zX());
        g.Ek().releaseAll();
        ah.A(new 1(this));
    }
}
