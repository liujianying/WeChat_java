package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.f;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class i extends a {
    private static long ghF = 0;

    i() {
    }

    protected final boolean a(Context context, LaunchParcel launchParcel) {
        String str = launchParcel.appId;
        int i = launchParcel.fmv;
        if (bi.oW(str)) {
            str = f.aee().rL(launchParcel.username);
        }
        if (!bi.oW(str) && i == 0 && e.vD(str)) {
            AppBrandInitConfig rN = f.aee().rN(str);
            if (rN != null && rN.fig == i) {
                rN.fqz = false;
                launchParcel.a(rN);
                k.a(context, rN, launchParcel.ghm);
                return true;
            }
        }
        if (Math.abs(System.currentTimeMillis() - ghF) < 200) {
            x.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
            return false;
        }
        ghF = bi.VF();
        x.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", new Object[]{str, Integer.valueOf(i)});
        String str2 = "Token@" + i.class.hashCode() + "#" + System.nanoTime();
        new e(context, str2).a(launchParcel);
        x.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", new Object[]{launchParcel.username, str, launchParcel.ghm});
        Intent intent = new Intent(context, AppBrandLaunchProxyUI.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("extra_from_mm", true);
        intent.putExtra("extra_entry_token", str2);
        context.startActivity(intent);
        return true;
    }
}
