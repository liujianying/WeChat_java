package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShakeSayHiListUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeSayHiListUI nbq;

    ShakeSayHiListUI$9(ShakeSayHiListUI shakeSayHiListUI) {
        this.nbq = shakeSayHiListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nbq.YC();
        this.nbq.finish();
        return true;
    }
}
