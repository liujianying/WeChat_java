package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LocationExtUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ LocationExtUI kEB;

    LocationExtUI$3(LocationExtUI locationExtUI) {
        this.kEB = locationExtUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("key_remark_result", LocationExtUI.b(this.kEB));
        intent.putExtra("key_tags_result", LocationExtUI.a(this.kEB));
        this.kEB.setResult(-1, intent);
        this.kEB.finish();
        return true;
    }
}
