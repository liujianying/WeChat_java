package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class TVInfoUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ TVInfoUI nbD;

    TVInfoUI$3(TVInfoUI tVInfoUI) {
        this.nbD = tVInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        TVInfoUI.a(this.nbD);
        return true;
    }
}
