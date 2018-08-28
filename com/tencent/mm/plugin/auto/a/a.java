package com.tencent.mm.plugin.auto.a;

import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    c gRf = new 1(this);

    static boolean aqG() {
        boolean z;
        try {
            ad.getContext().getPackageManager().getPackageInfo("com.google.android.projection.gearhead", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        x.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }
}
