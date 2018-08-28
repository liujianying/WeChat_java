package com.tencent.mm.plugin.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SelectMemberUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SelectMemberUI hPv;

    SelectMemberUI$4(SelectMemberUI selectMemberUI) {
        this.hPv = selectMemberUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hPv.setResult(0);
        this.hPv.finish();
        return true;
    }
}
