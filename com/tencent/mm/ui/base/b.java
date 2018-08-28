package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class b {

    public interface a {
        void kh(boolean z);
    }

    private static class b implements InvocationHandler {
        WeakReference<a> tsj;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            boolean z = false;
            if (this.tsj == null) {
                x.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
            } else {
                a aVar = (a) this.tsj.get();
                if (aVar == null) {
                    x.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
                } else {
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        z = ((Boolean) objArr[0]).booleanValue();
                    }
                    aVar.kh(z);
                }
            }
            return null;
        }
    }

    public static int ZX(String str) {
        Class ZY = ZY(str);
        if (ZY != null) {
            return M(ZY);
        }
        return 0;
    }

    public static int M(Class<?> cls) {
        Class cls2;
        do {
            a aVar = (a) cls2.getAnnotation(a.class);
            if (aVar != null) {
                return aVar.value();
            }
            cls2 = cls2.getSuperclass();
        } while (cls2 != null);
        return 0;
    }

    private static Class<?> ZY(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ActivityUtil", e, "", new Object[0]);
            x.e("MicroMsg.ActivityUtil", "Class %s not found in dex", str);
            return null;
        }
    }

    public static boolean N(Class<?> cls) {
        return (M(cls) & 1) == 0;
    }

    public static void Y(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityFromTranslucent Fail: %s", th.getMessage());
        }
    }

    @TargetApi(16)
    public static void a(Activity activity, a aVar) {
        if (d.fS(16)) {
            x.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", Integer.valueOf(VERSION.SDK_INT));
            return;
        }
        try {
            Object newProxyInstance;
            Class[] declaredClasses = Activity.class.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            Class cls = null;
            while (i < length) {
                Class cls2 = declaredClasses[i];
                if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls2 = cls;
                }
                i++;
                cls = cls2;
            }
            if (aVar != null) {
                InvocationHandler bVar = new b();
                bVar.tsj = new WeakReference(aVar);
                newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, bVar);
            } else {
                newProxyInstance = null;
            }
            Method declaredMethod;
            if (d.fS(21)) {
                declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, new Object[]{newProxyInstance});
                return;
            }
            declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[]{newProxyInstance, null});
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityToTranslucent Fail: %s", th.getMessage());
        }
    }

    public static void gD(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.w.a.a.pop_in, com.tencent.mm.w.a.a.anim_not_change);
        }
    }

    public static void gE(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.w.a.a.pop_in, com.tencent.mm.w.a.a.pop_out);
        }
    }

    public static void E(Context context, Intent intent) {
        if (intent != null && context != null && (context instanceof Activity) && intent.getBooleanExtra("animation_pop_in", false)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.w.a.a.pop_in, com.tencent.mm.w.a.a.anim_not_change);
        }
    }

    public static void gF(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.w.a.a.anim_not_change, com.tencent.mm.w.a.a.pop_out);
        }
    }

    public static void gG(Context context) {
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(com.tencent.mm.w.a.a.anim_not_change, com.tencent.mm.w.a.a.anim_not_change);
        }
    }
}
