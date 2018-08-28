package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class j {
    static int ghG = 112;
    private static Object ghH;
    private static Handler ghI;

    public static void cF(Context context) {
        try {
            Handler bm = bm(cG(context));
            Field declaredField = bm.getClass().getDeclaredField("NEW_INTENT");
            declaredField.setAccessible(true);
            ghG = ((Integer) declaredField.get(bm)).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", e, "hack constants in ActivityThread$H", new Object[0]);
        }
    }

    private static Handler bm(Object obj) {
        if (ghI != null) {
            return ghI;
        }
        Field declaredField = obj.getClass().getDeclaredField("mH");
        declaredField.setAccessible(true);
        Handler handler = (Handler) declaredField.get(obj);
        ghI = handler;
        return handler;
    }

    private static Object cG(Context context) {
        if (ghH != null) {
            return ghH;
        }
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null) {
            ghH = invoke;
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        invoke = field.get(context);
        Field declaredField = invoke.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        invoke = declaredField.get(invoke);
        ghH = invoke;
        return invoke;
    }

    static boolean le(int i) {
        Handler bm;
        try {
            bm = bm(cG(ad.getContext()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", e, "hasPendingMessageInQueue, hack mH", new Object[0]);
            bm = null;
        }
        if (bm == null) {
            return false;
        }
        return bm.hasMessages(i);
    }
}
