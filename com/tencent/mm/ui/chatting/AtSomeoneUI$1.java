package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AtSomeoneUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AtSomeoneUI tHd;

    AtSomeoneUI$1(AtSomeoneUI atSomeoneUI) {
        this.tHd = atSomeoneUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tHd.setResult(0);
        this.tHd.finish();
        return true;
    }
}
