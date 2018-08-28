package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ServicePreference$1 implements OnItemClickListener {
    final /* synthetic */ ServicePreference otb;

    ServicePreference$1(ServicePreference servicePreference) {
        this.otb = servicePreference;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ServicePreference.a(this.otb).qY(i)) {
            ServicePreference.a(this.otb).iw(false);
        } else if (ServicePreference.a(this.otb).osC) {
            if (ServicePreference.b(this.otb) != null) {
                ServicePreference.b(this.otb).onItemClick(adapterView, view, i, j);
            }
        } else if (ServicePreference.c(this.otb) != null) {
            ServicePreference.c(this.otb).onItemClick(adapterView, view, i, j);
        }
    }
}
