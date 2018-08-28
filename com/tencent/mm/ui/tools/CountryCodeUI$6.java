package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CountryCodeUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ CountryCodeUI uvR;

    CountryCodeUI$6(CountryCodeUI countryCodeUI) {
        this.uvR = countryCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.uvR.YC();
        Intent intent = new Intent();
        intent.putExtra("country_name", CountryCodeUI.d(this.uvR));
        intent.putExtra("couttry_code", CountryCodeUI.e(this.uvR));
        intent.putExtra("iso_code", CountryCodeUI.f(this.uvR));
        this.uvR.setResult(100, intent);
        this.uvR.finish();
        return true;
    }
}
