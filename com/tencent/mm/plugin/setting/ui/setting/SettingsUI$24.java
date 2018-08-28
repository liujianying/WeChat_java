package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n$c;

class SettingsUI$24 implements n$c {
    final /* synthetic */ SettingsUI mUx;

    SettingsUI$24(SettingsUI settingsUI) {
        this.mUx = settingsUI;
    }

    public final void a(l lVar) {
        if (lVar.crF()) {
            lVar.ak(1, i.logout_menu_logout, h.menu_logout_single);
            lVar.ak(2, i.logout_menu_exit, h.menu_close_wechat);
        }
    }
}
