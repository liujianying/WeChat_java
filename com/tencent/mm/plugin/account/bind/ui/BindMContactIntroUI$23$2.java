package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.23;
import com.tencent.mm.ui.base.n.d;

class BindMContactIntroUI$23$2 implements d {
    final /* synthetic */ 23 eGi;

    BindMContactIntroUI$23$2(23 23) {
        this.eGi = 23;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                BindMContactIntroUI.d(this.eGi.eGe);
                return;
            case 1:
                Intent intent = new Intent();
                intent.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                com.tencent.mm.bg.d.b(this.eGi.eGe, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                return;
            default:
                return;
        }
    }
}
