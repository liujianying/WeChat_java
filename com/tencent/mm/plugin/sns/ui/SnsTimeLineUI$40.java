package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsTimeLineUI$40 implements OnMenuItemClickListener {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$40(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.odw.YC();
        this.odw.finish();
        return false;
    }
}
