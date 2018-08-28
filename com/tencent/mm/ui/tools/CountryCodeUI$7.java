package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.al.b.a;

class CountryCodeUI$7 implements OnItemClickListener {
    final /* synthetic */ CountryCodeUI uvR;

    CountryCodeUI$7(CountryCodeUI countryCodeUI) {
        this.uvR = countryCodeUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent();
        if (i >= CountryCodeUI.b(this.uvR).getHeaderViewsCount()) {
            a aVar = (a) CountryCodeUI.c(this.uvR).getItem(i - CountryCodeUI.b(this.uvR).getHeaderViewsCount());
            intent.putExtra("country_name", aVar.dYy);
            intent.putExtra("couttry_code", aVar.dYx);
            intent.putExtra("iso_code", aVar.dYw);
            this.uvR.setResult(100, intent);
        }
        this.uvR.finish();
    }
}
