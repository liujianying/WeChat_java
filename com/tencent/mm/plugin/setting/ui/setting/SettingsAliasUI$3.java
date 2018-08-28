package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.h;

class SettingsAliasUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsAliasUI mRV;

    SettingsAliasUI$3(SettingsAliasUI settingsAliasUI) {
        this.mRV = settingsAliasUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SettingsAliasUI.a(this.mRV, SettingsAliasUI.c(this.mRV).getText().toString().trim());
        if (q.GF().equalsIgnoreCase(SettingsAliasUI.d(this.mRV))) {
            this.mRV.YC();
            this.mRV.finish();
        } else {
            h.a(this.mRV.mController.tml, this.mRV.getString(i.modify_username_confirm, new Object[]{SettingsAliasUI.d(this.mRV)}), this.mRV.getString(i.confirm_username), new 1(this), null);
        }
        return true;
    }
}
