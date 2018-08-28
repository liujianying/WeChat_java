package com.tencent.mm.plugin.subapp.ui.openapi;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class AppPreference$2 implements OnItemLongClickListener {
    final /* synthetic */ AppPreference osM;

    AppPreference$2(AppPreference appPreference) {
        this.osM = appPreference;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppPreference appPreference = this.osM;
        if (appPreference.osF != null) {
            appPreference.osF.iw(!appPreference.osF.osC);
        }
        return true;
    }
}
