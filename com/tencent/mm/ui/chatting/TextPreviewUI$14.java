package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class TextPreviewUI$14 implements OnMenuItemClickListener {
    final /* synthetic */ TextPreviewUI tNo;

    TextPreviewUI$14(TextPreviewUI textPreviewUI) {
        this.tNo = textPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tNo.finish();
        return true;
    }
}
