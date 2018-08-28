package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ModRemarkNameUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ModRemarkNameUI ukX;

    ModRemarkNameUI$2(ModRemarkNameUI modRemarkNameUI) {
        this.ukX = modRemarkNameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (ModRemarkNameUI.b(this.ukX)) {
            case 0:
                ModRemarkNameUI.c(this.ukX);
                break;
            case 3:
                ModRemarkNameUI.d(this.ukX);
                break;
            case 4:
                ModRemarkNameUI.e(this.ukX);
                break;
        }
        return true;
    }
}
