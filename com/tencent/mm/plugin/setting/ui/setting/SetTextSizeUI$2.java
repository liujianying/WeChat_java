package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bp.a;

class SetTextSizeUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SetTextSizeUI mQI;

    SetTextSizeUI$2(SetTextSizeUI setTextSizeUI) {
        this.mQI = setTextSizeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a.g(this.mQI, SetTextSizeUI.a(this.mQI));
        this.mQI.finish();
        return true;
    }
}
