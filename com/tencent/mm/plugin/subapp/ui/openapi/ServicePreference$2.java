package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class ServicePreference$2 implements OnItemLongClickListener {
    final /* synthetic */ ServicePreference otb;

    ServicePreference$2(ServicePreference servicePreference) {
        this.otb = servicePreference;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ServicePreference servicePreference = this.otb;
        if (servicePreference.ota != null) {
            servicePreference.ota.iw(!servicePreference.ota.osC);
        }
        return true;
    }
}
