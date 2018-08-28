package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EditSignatureUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ EditSignatureUI mPP;

    EditSignatureUI$2(EditSignatureUI editSignatureUI) {
        this.mPP = editSignatureUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mPP.YC();
        this.mPP.finish();
        return true;
    }
}
