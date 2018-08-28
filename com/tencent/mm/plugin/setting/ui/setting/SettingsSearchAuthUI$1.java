package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import com.tencent.mm.plugin.fts.ui.widget.a.a;
import com.tencent.mm.sdk.platformtools.x;

class SettingsSearchAuthUI$1 implements a {
    final /* synthetic */ SettingsSearchAuthUI mTJ;

    SettingsSearchAuthUI$1(SettingsSearchAuthUI settingsSearchAuthUI) {
        this.mTJ = settingsSearchAuthUI;
    }

    public final void onClickBackBtn(View view) {
        x.i("MicroMsg.SettingsSearchAuthUI", "click search back");
        this.mTJ.finish();
    }
}
