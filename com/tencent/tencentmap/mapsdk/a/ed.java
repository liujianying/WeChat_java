package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ed {
    public static boolean a = true;
    private static final Lock b = new ReentrantLock();
    private static du c = null;

    public static du a() {
        if (c != null) {
            return c;
        }
        try {
            if (em.a() != null) {
                c = a(em.a(), em.b(), em.g(), em.e());
            }
        } catch (Exception e) {
        }
        return c;
    }

    public static du a(Context context, String str, String str2, String str3) {
        fx.b("AccessSchedulerManager", "creatAccessScheduler...context:" + context + ",appId:" + str + ",channelId:" + str2 + ",uuid:" + str3);
        if (context == null || fz.a(str)) {
            throw new eh("AccessScheduler init illegal Argument[appId=" + str + ",context=" + context + "]");
        }
        b.lock();
        try {
            if (c == null) {
                if (fz.a(str3) || str3.toLowerCase().contains("test")) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("Access_Preferences", 0);
                    if (sharedPreferences != null) {
                        str3 = sharedPreferences.getString("test_uuid", "");
                        if (fz.a(str3)) {
                            str3 = fz.a(context) + "_" + fz.b(context);
                            sharedPreferences.edit().putString("test_uuid", str3).commit();
                        }
                    }
                }
                if (fz.a(str2)) {
                    str2 = "test_channelId";
                }
                try {
                    em.a(context, str, str2, str3);
                    fw.a(context);
                    c = new ea(str, str2, str3);
                    new Thread((Runnable) c, "HalleyScheduler").start();
                } catch (Exception e) {
                }
            }
            b.unlock();
            return c;
        } catch (Throwable th) {
            b.unlock();
        }
    }
}
