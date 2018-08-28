package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CropImageNewUI$19 implements OnMenuItemClickListener {
    final /* synthetic */ CropImageNewUI uwf;

    CropImageNewUI$19(CropImageNewUI cropImageNewUI) {
        this.uwf = cropImageNewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.uwf.finish();
        return true;
    }
}
