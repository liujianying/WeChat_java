package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;
import java.util.Queue;

abstract class b extends MutableContextWrapper {
    final Queue<Runnable> gho = new LinkedList();
    private ah ghp;

    protected abstract String akW();

    public b() {
        super(ad.getContext());
    }

    public final void setBaseContext(Context context) {
        super.setBaseContext(context);
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            while (!this.gho.isEmpty()) {
                ((Runnable) this.gho.poll()).run();
            }
        }
    }

    private void s(Runnable runnable) {
        if (getBaseContext() instanceof AppBrandLaunchProxyUI) {
            runnable.run();
        } else {
            this.gho.offer(runnable);
        }
    }

    protected void akX() {
        s(new 1(this));
    }

    protected final void finish() {
        e(null, null);
    }

    protected void e(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig != null) {
            k.a(getBaseContext(), appBrandInitConfig, appBrandStatObject);
        }
        akX();
        if (this.ghp != null) {
            this.ghp.H(new 4(this));
        }
    }

    protected final boolean isFinishing() {
        return (getBaseContext() instanceof AppBrandLaunchProxyUI) && ((AppBrandLaunchProxyUI) getBaseContext()).isFinishing();
    }

    protected final boolean akY() {
        return (getBaseContext() instanceof AppBrandLaunchProxyUI) && ((AppBrandLaunchProxyUI) getBaseContext()).isDestroyed();
    }

    protected boolean b(AppBrandInitConfig appBrandInitConfig) {
        boolean z;
        if (appBrandInitConfig.fqs || e.vD(appBrandInitConfig.appId) || appBrandInitConfig.aaq()) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    protected final void a(LaunchParcel launchParcel) {
        ah ahVar = new ah("AppBrandLaunchProxyUI-PrepareThread");
        this.ghp = ahVar;
        ahVar.H(new 3(this, launchParcel));
    }
}
