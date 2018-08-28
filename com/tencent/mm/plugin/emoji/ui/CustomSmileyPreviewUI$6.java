package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CustomSmileyPreviewUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ CustomSmileyPreviewUI ikY;

    CustomSmileyPreviewUI$6(CustomSmileyPreviewUI customSmileyPreviewUI) {
        this.ikY = customSmileyPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ikY.finish();
        return true;
    }
}
