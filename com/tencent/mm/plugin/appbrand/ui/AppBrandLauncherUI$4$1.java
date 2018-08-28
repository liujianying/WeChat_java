package com.tencent.mm.plugin.appbrand.ui;

import android.app.ActivityOptions;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.4;

class AppBrandLauncherUI$4$1 implements Runnable {
    final /* synthetic */ 4 guI;

    AppBrandLauncherUI$4$1(4 4) {
        this.guI = 4;
    }

    public final void run() {
        Bundle toBundle;
        if (VERSION.SDK_INT >= 21) {
            toBundle = ActivityOptions.makeSceneTransitionAnimation(this.guI.guG, new Pair[0]).toBundle();
        } else {
            toBundle = null;
        }
        this.guI.guG.startActivityForResult(((a) g.l(a.class)).cp(this.guI.guG), 1, toBundle);
    }
}
