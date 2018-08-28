package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AppPreference$1 implements OnItemClickListener {
    final /* synthetic */ AppPreference osM;

    AppPreference$1(AppPreference appPreference) {
        this.osM = appPreference;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (AppPreference.a(this.osM).qY(i)) {
            AppPreference.a(this.osM).iw(false);
        } else if (AppPreference.a(this.osM).osC) {
            if (AppPreference.b(this.osM) != null) {
                AppPreference.b(this.osM).onItemClick(adapterView, view, i, j);
            }
        } else if (AppPreference.c(this.osM) != null) {
            AppPreference.c(this.osM).onItemClick(adapterView, view, i, j);
        }
    }
}
