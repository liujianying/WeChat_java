package com.tencent.mm.plugin.appbrand.r;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Queue;

public final class d implements ActivityLifecycleCallbacks {
    public Application app;
    private int gBA = 0;
    public boolean gBB = false;
    public final Queue<a> gBz = new LinkedList();

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.gBA++;
        if (this.gBA == 1) {
            x.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
            for (a cL : this.gBz) {
                cL.cL(activity);
            }
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.gBA--;
        if (this.gBA == 0) {
            x.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
            for (a aoy : this.gBz) {
                aoy.aoy();
            }
            if (this.gBB && this.app != null) {
                Application application = this.app;
                x.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
                application.unregisterActivityLifecycleCallbacks(this);
                this.gBz.clear();
                this.app = null;
                this.gBB = false;
                this.gBB = false;
                this.app = null;
            }
        }
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
