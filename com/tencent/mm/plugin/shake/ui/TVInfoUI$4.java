package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class TVInfoUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ TVInfoUI nbD;

    TVInfoUI$4(TVInfoUI tVInfoUI) {
        this.nbD = tVInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nbD.finish();
        return true;
    }
}
