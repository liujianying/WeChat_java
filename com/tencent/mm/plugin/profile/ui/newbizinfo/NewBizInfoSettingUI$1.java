package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NewBizInfoSettingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ NewBizInfoSettingUI lZc;

    NewBizInfoSettingUI$1(NewBizInfoSettingUI newBizInfoSettingUI) {
        this.lZc = newBizInfoSettingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lZc.finish();
        return true;
    }
}
