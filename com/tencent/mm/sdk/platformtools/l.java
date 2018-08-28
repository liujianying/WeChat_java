package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public final class l {
    private static BroadcastReceiver jhC = null;
    private static int sFI = 0;
    private static int sFJ = -1;
    private static b sFK = new a();

    public interface b {
        boolean fw(Context context);
    }

    private static class a implements b {
        Field sFL = null;

        a() {
            if (VERSION.SDK_INT >= 21) {
                try {
                    if (this.sFL == null) {
                        Field declaredField = RunningAppProcessInfo.class.getDeclaredField("processState");
                        declaredField.setAccessible(true);
                        this.sFL = declaredField;
                    }
                } catch (Throwable th) {
                    x.printErrStackTrace("MicroMsg.GreenManUtil", th, "", new Object[0]);
                }
            }
        }

        public final boolean fw(Context context) {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.startsWith("com.tencent.mm")) {
                    int i;
                    if (VERSION.SDK_INT >= 21 && this.sFL != null) {
                        try {
                            x.i("MicroMsg.GreenManUtil", "isAppForeground processState %s", Integer.valueOf(this.sFL.getInt(runningAppProcessInfo)));
                            if (this.sFL.getInt(runningAppProcessInfo) <= 2) {
                                return true;
                            }
                            i = 0;
                            if (i != 0 && runningAppProcessInfo.importance == 100) {
                                return true;
                            }
                        } catch (Throwable th) {
                            x.printErrStackTrace("MicroMsg.GreenManUtil", th, "", new Object[0]);
                        }
                    }
                    i = 1;
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean fs(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Throwable e) {
            x.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", bi.i(e));
            return false;
        }
    }

    public static synchronized boolean ft(Context context) {
        boolean z = false;
        synchronized (l.class) {
            if (jhC == null) {
                jhC = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        if (intent != null) {
                            try {
                                l.sFJ = intent.getIntExtra("status", -1);
                                l.sFI = intent.getIntExtra("plugged", 0);
                            } catch (Throwable th) {
                            }
                            x.i("MicroMsg.GreenManUtil", "isCharging BroadcastReceiver thread:%d status:%d plugged:%d", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(l.sFJ), Integer.valueOf(l.sFI));
                        }
                    }
                };
                try {
                    Intent registerReceiver = context.registerReceiver(jhC, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    sFJ = registerReceiver.getIntExtra("status", -1);
                    sFI = registerReceiver.getIntExtra("plugged", 0);
                } catch (Throwable th) {
                }
            }
            if (sFJ == 2 || sFI == 1 || sFI == 2 || (VERSION.SDK_INT >= 17 && sFI == 4)) {
                z = true;
            }
        }
        return z;
    }

    public static boolean dE(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith("com.tencent.mm")) {
                return true;
            }
        }
        return false;
    }

    public static int a(RunningAppProcessInfo runningAppProcessInfo) {
        if (!(sFK instanceof a)) {
            return -1;
        }
        Field field = ((a) sFK).sFL;
        if (VERSION.SDK_INT >= 21 && field != null) {
            try {
                return field.getInt(runningAppProcessInfo);
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.GreenManUtil", th, "", new Object[0]);
            }
        }
        return -1;
    }

    public static void fu(Context context) {
        List<RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(10);
        if (runningServices != null) {
            for (RunningServiceInfo runningServiceInfo : runningServices) {
                x.i("MicroMsg.GreenManUtil", "dumpRunningServices %s %s", runningServiceInfo.service, Boolean.valueOf(runningServiceInfo.foreground), Long.valueOf(runningServiceInfo.activeSince));
            }
        }
    }

    public static boolean fv(Context context) {
        return sFK.fw(context);
    }

    public static String bQ(Context context) {
        if (!dE(context)) {
            return "";
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (VERSION.SDK_INT < 23) {
                return ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            }
            List appTasks = activityManager.getAppTasks();
            if (appTasks == null || appTasks.size() <= 0) {
                return "";
            }
            Iterator it = appTasks.iterator();
            if (it.hasNext()) {
                ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                if (componentName == null) {
                    return null;
                }
                return componentName.getClassName();
            }
            return "";
        } catch (Throwable e) {
            x.e("MicroMsg.GreenManUtil", "getTopActivityName Exception:%s stack:%s", e.getMessage(), bi.i(e));
        }
    }
}
