package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class LaunchAAUI$6 implements OnClickListener {
    final /* synthetic */ LaunchAAUI eDS;
    final /* synthetic */ List eDT;

    LaunchAAUI$6(LaunchAAUI launchAAUI, List list) {
        this.eDS = launchAAUI;
        this.eDT = list;
    }

    public final void onClick(View view) {
        this.eDS.Wq();
        this.eDS.YC();
        LaunchAAUI.a(this.eDS, this.eDT);
    }
}
