package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;

public final class d extends b implements h {
    private Intent Hq;
    int fDQ = 0;

    protected final boolean b(AppBrandInitConfig appBrandInitConfig) {
        Class cls;
        try {
            cls = Class.forName(bi.oV(this.Hq.getStringExtra("extra_launch_source_context")));
        } catch (Exception e) {
            cls = null;
        }
        if (cls == null || !AppBrandUI.class.isAssignableFrom(cls)) {
            return super.b(appBrandInitConfig);
        }
        return false;
    }

    public d(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        setBaseContext(appBrandLaunchProxyUI);
    }

    public final void w(Intent intent) {
        this.Hq = intent;
        LaunchParcel launchParcel = (LaunchParcel) intent.getParcelableExtra("extra_launch_parcel");
        if (launchParcel == null) {
            finish();
        } else {
            a(launchParcel);
        }
    }

    public final void onResume() {
        int i = this.fDQ + 1;
        this.fDQ = i;
        if (i > 1) {
            akZ();
        }
    }

    public final void onPause() {
        akZ();
    }

    protected final String akW() {
        return this.Hq.getStringExtra("extra_launch_source_context");
    }

    protected final void e(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        super.e(appBrandInitConfig, appBrandStatObject);
        1 1 = new 1(this);
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            ah.A(1);
        } else {
            this.gho.offer(1);
        }
    }

    protected final void akX() {
    }

    private void akZ() {
        if (!isFinishing() && !akY()) {
            super.akX();
        }
    }
}
