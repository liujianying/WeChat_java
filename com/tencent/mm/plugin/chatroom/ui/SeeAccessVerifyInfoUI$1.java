package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SeeAccessVerifyInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SeeAccessVerifyInfoUI hOz;

    SeeAccessVerifyInfoUI$1(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI) {
        this.hOz = seeAccessVerifyInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hOz.finish();
        return true;
    }
}
