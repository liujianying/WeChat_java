package com.tencent.mm.ui;

import android.database.DataSetObserver;
import com.tencent.mm.R;

class ServiceNotifySettingsUI$3 extends DataSetObserver {
    final /* synthetic */ ServiceNotifySettingsUI tqb;

    ServiceNotifySettingsUI$3(ServiceNotifySettingsUI serviceNotifySettingsUI) {
        this.tqb = serviceNotifySettingsUI;
    }

    public final void onChanged() {
        this.tqb.findViewById(R.h.listTitleTv).setVisibility(ServiceNotifySettingsUI.a(this.tqb).isEmpty() ? 4 : 0);
    }
}
