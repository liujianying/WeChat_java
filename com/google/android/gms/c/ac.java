package com.google.android.gms.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ac {
    private static final Method aXQ = qg();
    private static final Method aXR = qh();
    private static final Method aXS = qi();
    private static final Method aXT = qj();
    private static final Method aXU = qk();

    private static int a(WorkSource workSource) {
        if (aXS != null) {
            try {
                return ((Integer) aXS.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return 0;
    }

    private static String a(WorkSource workSource, int i) {
        if (aXU != null) {
            try {
                return (String) aXU.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return null;
    }

    public static boolean at(Context context) {
        return context.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }

    public static List<String> b(WorkSource workSource) {
        int i = 0;
        int a = workSource == null ? 0 : a(workSource);
        if (a == 0) {
            return Collections.EMPTY_LIST;
        }
        List<String> arrayList = new ArrayList();
        while (i < a) {
            String a2 = a(workSource, i);
            if (!ab.bt(a2)) {
                arrayList.add(a2);
            }
            i++;
        }
        return arrayList;
    }

    private static WorkSource d(int i, String str) {
        WorkSource workSource = new WorkSource();
        if (aXR != null) {
            if (str == null) {
                str = "";
            }
            try {
                aXR.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        } else if (aXQ != null) {
            try {
                aXQ.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return workSource;
    }

    public static WorkSource m(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            return applicationInfo != null ? d(applicationInfo.uid, str) : null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    private static Method qg() {
        Method method = null;
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return method;
        }
    }

    private static Method qh() {
        Method method = null;
        if (!z.dx(18)) {
            return method;
        }
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
        } catch (Exception e) {
            return method;
        }
    }

    private static Method qi() {
        Method method = null;
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
            return method;
        }
    }

    private static Method qj() {
        Method method = null;
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return method;
        }
    }

    private static Method qk() {
        Method method = null;
        if (!z.dx(18)) {
            return method;
        }
        try {
            return WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return method;
        }
    }
}
