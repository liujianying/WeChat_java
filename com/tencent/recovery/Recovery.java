package com.tencent.recovery;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.recovery.handler.RecoveryMessageHandler;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.util.Util;

public class Recovery {
    private static Application application;
    private static Context context;
    private static RecoveryMessageHandler vgZ;
    private static long vha;
    private static String vhb;
    private static boolean vhc = false;
    private static boolean vhd = false;
    private static int vhe = 0;
    private static ActivityLifecycleCallbacks vhf = new ActivityLifecycleCallbacks() {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (!Recovery.vhd && !Recovery.vgZ.hasMessages(3)) {
                Recovery.vgZ.removeCallbacksAndMessages(null);
                String hm = Util.hm(Recovery.context);
                Editor edit = Recovery.context.getSharedPreferences(Recovery.vhb, 0).edit();
                edit.putInt("KeyComponentOnCreateForeground", 1);
                edit.putInt("KeyComponentOnCreateExceptionType", 4096);
                edit.apply();
                Recovery.vgZ.sendEmptyMessageDelayed(3, (long) OptionFactory.dA(hm, 1).dkb);
                RecoveryLog.i("Recovery", "%s markActivityOnCreated %s", hm, Long.valueOf(System.currentTimeMillis() - Recovery.vha));
            }
        }

        public final void onActivityStarted(Activity activity) {
            Recovery.cEU();
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
            Recovery.cEV();
            if (Recovery.vhe == 0) {
                RecoveryLog.i("Recovery", "%s onActivityStopped: activityForegroundCount is 0", Util.hm(Recovery.context));
                Recovery.Hj(16);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    };

    static /* synthetic */ int cEU() {
        int i = vhe;
        vhe = i + 1;
        return i;
    }

    static /* synthetic */ int cEV() {
        int i = vhe;
        vhe = i - 1;
        return i;
    }

    public static void cEO() {
        if (!vhd && !vhc) {
            vhc = true;
            String hm = Util.hm(context);
            int bG = RecoveryLogic.bG(context, hm);
            RecoveryLog.i("Recovery", "%s markApplicationOnCreateNormal %d", hm, Long.valueOf(System.currentTimeMillis() - vha));
            Editor edit = context.getSharedPreferences(vhb, 0).edit();
            edit.remove("KeyAppOnCreateExceptionType");
            edit.putInt("KeyAppOnCreateNormalType", 256);
            if (RecoveryLogic.bG(context, hm) == 16) {
                edit.putInt("KeyComponentOnCreateForeground", bG);
                edit.putInt("KeyComponentOnCreateExceptionType", 4096);
                vgZ.sendEmptyMessageDelayed(2, (long) OptionFactory.dA(hm, bG).dkb);
            }
            edit.apply();
        }
    }

    private static void destroy() {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(vhf);
        }
    }

    public static void cEP() {
        if (context != null && !vhd) {
            cER();
            RecoveryLog.i("Recovery", "%s Recovery.crash %d", Util.hm(context), Long.valueOf(System.currentTimeMillis() - vha));
            Editor edit = context.getSharedPreferences(vhb, 0).edit();
            if (vhc) {
                edit.putInt("KeyComponentOnCreateExceptionType", 65536);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 65536);
            }
            edit.apply();
            destroy();
        }
    }

    public static void cEQ() {
        if (context != null && !vhd) {
            cER();
            RecoveryLog.i("Recovery", "%s Recovery.anr %d", Util.hm(context), Long.valueOf(System.currentTimeMillis() - vha));
            Editor edit = context.getSharedPreferences(vhb, 0).edit();
            if (vhc) {
                edit.putInt("KeyComponentOnCreateExceptionType", 1048576);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 1048576);
            }
            edit.apply();
            destroy();
        }
    }

    public static void Hj(int i) {
        if (context != null && !vhd) {
            cER();
            String hm = Util.hm(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(vhb, 0);
            RecoveryLog.i("Recovery", "%s Recovery.normal %s %d", hm, Integer.toHexString(i), Long.valueOf(System.currentTimeMillis() - vha));
            vgZ.removeCallbacksAndMessages(null);
            Editor edit = sharedPreferences.edit();
            edit.remove("KeyComponentOnCreateExceptionType");
            edit.putInt("KeyComponentOnCreateNormalType", i);
            edit.apply();
            destroy();
        }
    }

    public static Context getContext() {
        return context;
    }

    private static void cER() {
        if (context != null && !vhd) {
            RecoveryLog.i("Recovery", "%s markFinalStatus", Util.hm(context));
            vhd = true;
        }
    }
}
