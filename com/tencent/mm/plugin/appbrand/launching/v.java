package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

public class v implements a {
    public final int bRZ = (v.class.hashCode() & 65535);

    public void onReady() {
    }

    public void akI() {
    }

    public final void akJ() {
        if (d.fR(17)) {
            onReady();
        }
    }

    public final void b(int i, int i2, Intent intent) {
        if (this.bRZ == i) {
            if (i2 == -1) {
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs download ok");
                e.lE(0);
                onReady();
            } else if (i2 == 2) {
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs cancel loading, download in background");
                akI();
            } else {
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(VERSION.SDK_INT)});
                h.mEJ.a(366, 8, 1, false);
                akJ();
            }
        }
    }
}
