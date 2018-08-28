package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.chg;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements OnClickListener {
    final /* synthetic */ f gAq;
    final /* synthetic */ chg gAs;

    f$3(f fVar, chg chg) {
        this.gAq = fVar;
        this.gAs = chg;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke WxApp click listener, invoke wxapp");
        AppBrandLaunchProxyUI.a(this.gAq.ftd, this.gAs.username, this.gAs.path, 0, this.gAs.rkb, new AppBrandStatObject(), null);
    }
}
