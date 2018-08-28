package com.tencent.mm.plugin.traceroute.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NetworkDiagnoseIntroUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ NetworkDiagnoseIntroUI oDQ;

    NetworkDiagnoseIntroUI$3(NetworkDiagnoseIntroUI networkDiagnoseIntroUI) {
        this.oDQ = networkDiagnoseIntroUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oDQ.finish();
        return true;
    }
}
