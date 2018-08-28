package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallCountryCodeSelectUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallCountryCodeSelectUI kvl;

    IPCallCountryCodeSelectUI$4(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI) {
        this.kvl = iPCallCountryCodeSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kvl.YC();
        Intent intent = new Intent();
        intent.putExtra("country_name", IPCallCountryCodeSelectUI.d(this.kvl));
        intent.putExtra("couttry_code", IPCallCountryCodeSelectUI.e(this.kvl));
        this.kvl.setResult(100, intent);
        this.kvl.finish();
        return true;
    }
}
