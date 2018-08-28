package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;

class LaunchAAUI$7 implements OnClickListener {
    final /* synthetic */ LaunchAAUI eDS;

    LaunchAAUI$7(LaunchAAUI launchAAUI) {
        this.eDS = launchAAUI;
    }

    public final void onClick(View view) {
        LaunchAAUI.i(this.eDS);
    }
}
