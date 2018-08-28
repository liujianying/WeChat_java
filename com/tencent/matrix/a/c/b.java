package com.tencent.matrix.a.c;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public final class b {
    private final String bqB;
    private final String bqC;
    private final b bqD;
    private IBinder bqE;

    private static final class a implements InvocationHandler {
        private final IBinder bqF;
        private final Object bqG;

        a(IBinder iBinder, Object obj) {
            this.bqF = iBinder;
            this.bqG = obj;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if (!"queryLocalInterface".equals(method.getName()) || this.bqG == null) {
                return method.invoke(this.bqF, objArr);
            }
            return this.bqG;
        }
    }

    public interface b {
        void b(Method method, Object[] objArr);
    }

    private static class c implements InvocationHandler {
        final Object bqH;
        final b bqI;

        c(Object obj, b bVar) {
            this.bqH = obj;
            this.bqI = bVar;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if (this.bqI != null) {
                this.bqI.b(method, objArr);
            }
            return method.invoke(this.bqH, objArr);
        }
    }

    public b(String str, String str2, b bVar) {
        this.bqB = str;
        this.bqC = str2;
        this.bqD = bVar;
    }

    public final boolean doHook() {
        com.tencent.matrix.d.b.i("Matrix.SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", this.bqB, this.bqC);
        try {
            Class cls = Class.forName("android.os.ServiceManager");
            this.bqE = (IBinder) cls.getDeclaredMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{this.bqB});
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null) {
                com.tencent.matrix.d.b.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
                return false;
            }
            IBinder iBinder = (IBinder) Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class}, new a(this.bqE, tr()));
            Field declaredField = cls.getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.bqB, iBinder);
            return true;
        } catch (Throwable th) {
            com.tencent.matrix.d.b.e("Matrix.SystemServiceBinderHooker", "doHook exp : " + th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }

    public final boolean doUnHook() {
        if (this.bqE == null) {
            com.tencent.matrix.d.b.i("Matrix.SystemServiceBinderHooker", "doUnHook sOriginPowerManagerService null", new Object[0]);
            return false;
        }
        try {
            Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.bqB, this.bqE);
            return true;
        } catch (Throwable th) {
            com.tencent.matrix.d.b.e("Matrix.SystemServiceBinderHooker", "doUnHook exp : " + th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }

    private Object tr() {
        try {
            Class cls = Class.forName(this.bqC);
            Class cls2 = Class.forName(String.format("%s$Stub", new Object[]{this.bqC}));
            Object invoke = cls2.getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{this.bqE});
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader == null) {
                com.tencent.matrix.d.b.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
                return Boolean.valueOf(false);
            }
            return Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class, IInterface.class, cls}, new c(invoke, this.bqD));
        } catch (Throwable th) {
            com.tencent.matrix.d.b.w("Matrix.SystemServiceBinderHooker", "createPowerManagerServiceProxy exp:%s", th.getLocalizedMessage());
            return null;
        }
    }
}
