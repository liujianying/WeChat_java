package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class IPCallCountryCodeSelectUI$5 implements OnItemClickListener {
    final /* synthetic */ IPCallCountryCodeSelectUI kvl;

    IPCallCountryCodeSelectUI$5(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI) {
        this.kvl = iPCallCountryCodeSelectUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent();
        if (i >= IPCallCountryCodeSelectUI.b(this.kvl).getHeaderViewsCount()) {
            a aVar = (a) IPCallCountryCodeSelectUI.c(this.kvl).getItem(i - IPCallCountryCodeSelectUI.b(this.kvl).getHeaderViewsCount());
            intent.putExtra("country_name", aVar.dYy);
            intent.putExtra("couttry_code", aVar.countryCode);
            this.kvl.setResult(100, intent);
        }
        this.kvl.finish();
    }
}
