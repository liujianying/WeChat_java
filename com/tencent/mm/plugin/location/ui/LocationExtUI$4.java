package com.tencent.mm.plugin.location.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LocationExtUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ LocationExtUI kEB;

    LocationExtUI$4(LocationExtUI locationExtUI) {
        this.kEB = locationExtUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kEB.finish();
        return true;
    }
}
