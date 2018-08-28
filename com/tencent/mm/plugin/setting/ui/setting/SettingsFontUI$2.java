package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class SettingsFontUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsFontUI mSk;

    SettingsFontUI$2(SettingsFontUI settingsFontUI) {
        this.mSk = settingsFontUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.mEJ.h(11609, new Object[]{Integer.valueOf(SettingsFontUI.a(this.mSk)), Integer.valueOf(SettingsFontUI.b(this.mSk)), Integer.valueOf(0)});
        x.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[]{Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.a(this.mSk)), Integer.valueOf(SettingsFontUI.b(this.mSk))});
        this.mSk.finish();
        SettingsFontUI.a(this.mSk, this.mSk.mSg);
        return true;
    }
}
