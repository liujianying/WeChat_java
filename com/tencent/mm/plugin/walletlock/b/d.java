package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements b {
    private static d pIm = null;

    public final boolean L(Activity activity) {
        ComponentName componentName = ((RunningTaskInfo) ((ActivityManager) ad.getContext().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
        String className = componentName != null ? componentName.getClassName() : "";
        x.d("MicroMsg.WalletGuardFilter", "coveredPage: " + className);
        if (className == null || className.equals(activity.getClass().getName()) || !className.contains(ad.chX()) || (!className.contains("plugin.mall") && !className.contains("plugin.card") && !className.contains("plugin.wallet") && !className.contains("plugin.wallet_index") && !className.contains("plugin.webview") && !className.contains("plugin.offline") && !className.contains("plugin.recharge"))) {
            return true;
        }
        return false;
    }

    public static d bRW() {
        if (pIm == null) {
            pIm = new d();
        }
        return pIm;
    }

    private d() {
    }
}
