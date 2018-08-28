package com.tencent.mm.plugin.traceroute.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NetworkDiagnoseReportUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ NetworkDiagnoseReportUI oDY;

    NetworkDiagnoseReportUI$1(NetworkDiagnoseReportUI networkDiagnoseReportUI) {
        this.oDY = networkDiagnoseReportUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oDY.finish();
        return false;
    }
}
