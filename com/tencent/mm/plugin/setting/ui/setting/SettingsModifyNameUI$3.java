package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.k.b;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c;

class SettingsModifyNameUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsModifyNameUI mSW;

    SettingsModifyNameUI$3(SettingsModifyNameUI settingsModifyNameUI) {
        this.mSW = settingsModifyNameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String obj = SettingsModifyNameUI.c(this.mSW).getText().toString();
        String AD = b.AD();
        if (bi.oW(AD) || !obj.matches(".*[" + AD + "].*")) {
            c.d(SettingsModifyNameUI.c(this.mSW)).fj(1, 32).a(this.mSW);
            return true;
        }
        h.b(this.mSW.mController.tml, this.mSW.getString(i.invalid_input_character_toast, new Object[]{AD}), this.mSW.getString(i.app_tip), true);
        return false;
    }
}
