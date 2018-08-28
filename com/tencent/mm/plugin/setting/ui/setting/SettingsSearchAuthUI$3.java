package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class SettingsSearchAuthUI$3 implements OnClickListener {
    final /* synthetic */ SettingsSearchAuthUI mTJ;

    SettingsSearchAuthUI$3(SettingsSearchAuthUI settingsSearchAuthUI) {
        this.mTJ = settingsSearchAuthUI;
    }

    public final void onClick(View view) {
        CharSequence text = SettingsSearchAuthUI.d(this.mTJ).getFtsEditText().getEditText().getText();
        if (!bi.K(text)) {
            SettingsSearchAuthUI.a(this.mTJ, text.toString().trim());
        }
    }
}
