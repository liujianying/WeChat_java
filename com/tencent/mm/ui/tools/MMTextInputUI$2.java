package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MMTextInputUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ MMTextInputUI uAI;

    MMTextInputUI$2(MMTextInputUI mMTextInputUI) {
        this.uAI = mMTextInputUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        MMTextInputUI.a(this.uAI);
        return false;
    }
}
