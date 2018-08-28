package com.tencent.tinker.loader.hotplug.interceptor;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServiceBinderInterceptor extends Interceptor<IBinder> {
    private static Class<?> vuo;
    private static Field vup;
    private static Method vuq;
    private final String bqB;
    private final Context vum;
    private final BinderInvocationHandler vun;

    public interface BinderInvocationHandler {
        Object invoke(Object obj, Method method, Object[] objArr);
    }

    private static class FakeClientBinderHandler implements InvocationHandler {
        private final BinderInvocationHandler vun;
        private final IBinder vus;

        FakeClientBinderHandler(IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.vus = iBinder;
            this.vun = binderInvocationHandler;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (!"queryLocalInterface".equals(method.getName())) {
                return method.invoke(this.vus, objArr);
            }
            String interfaceDescriptor = this.vus.getInterfaceDescriptor();
            if (interfaceDescriptor.equals("android.app.IActivityManager")) {
                interfaceDescriptor = "android.app.ActivityManagerNative";
            } else {
                interfaceDescriptor = interfaceDescriptor + "$Stub";
            }
            IInterface iInterface = (IInterface) ShareReflectUtil.c(Class.forName(interfaceDescriptor), "asInterface", IBinder.class).invoke(null, new Object[]{this.vus});
            return ServiceBinderInterceptor.a(ServiceBinderInterceptor.U(iInterface.getClass()), new FakeInterfaceHandler(iInterface, (IBinder) obj, this.vun));
        }
    }

    private static class FakeInterfaceHandler implements InvocationHandler {
        private final BinderInvocationHandler vun;
        private final IBinder vus;
        private final IInterface vut;

        FakeInterfaceHandler(IInterface iInterface, IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.vut = iInterface;
            this.vus = iBinder;
            this.vun = binderInvocationHandler;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if ("asBinder".equals(method.getName())) {
                return this.vus;
            }
            return this.vun.invoke(this.vut, method, objArr);
        }
    }

    protected final /* synthetic */ void cH(Object obj) {
        IBinder iBinder = (IBinder) obj;
        ((Map) vup.get(null)).put(this.bqB, iBinder);
        Field b;
        IInterface iInterface;
        if ("activity".equals(this.bqB)) {
            Object obj2;
            try {
                obj2 = ShareReflectUtil.d(Class.forName("android.app.ActivityManagerNative"), "gDefault").get(null);
            } catch (Throwable th) {
                obj2 = ShareReflectUtil.d(Class.forName("android.app.ActivityManager"), "IActivityManagerSingleton").get(null);
            }
            b = ShareReflectUtil.b(obj2, "mInstance");
            iInterface = (IInterface) b.get(obj2);
            if (iInterface != null && !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                b.set(obj2, iInterface);
            }
        } else if ("package".equals(this.bqB)) {
            Context context = this.vum;
            b = ShareReflectUtil.d(Class.forName("android.app.ActivityThread"), "sPackageManager");
            iInterface = (IInterface) b.get(null);
            if (!(iInterface == null || ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass()))) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                b.set(null, iInterface);
            }
            b = ShareReflectUtil.d(Class.forName("android.app.ApplicationPackageManager"), "mPM");
            PackageManager packageManager = context.getPackageManager();
            iInterface = (IInterface) b.get(packageManager);
            if (iInterface != null && !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
                if (iInterface == null || !ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    throw new IllegalStateException("fakeBinder does not return fakeInterface, binder: " + iBinder + ", itf: " + iInterface);
                }
                b.set(packageManager, iInterface);
            }
        }
    }

    protected final /* synthetic */ Object cHb() {
        return (IBinder) vuq.invoke(null, new Object[]{this.bqB});
    }

    protected final /* synthetic */ Object cI(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder != null) {
            return ITinkerHotplugProxy.class.isAssignableFrom(iBinder.getClass()) ? iBinder : (IBinder) a(U(iBinder.getClass()), new FakeClientBinderHandler(iBinder, this.vun));
        } else {
            throw new IllegalStateException("target is null.");
        }
    }

    static {
        vuo = null;
        vup = null;
        vuq = null;
        synchronized (ServiceBinderInterceptor.class) {
            if (vuo == null) {
                try {
                    Class cls = Class.forName("android.os.ServiceManager");
                    vuo = cls;
                    vup = ShareReflectUtil.d(cls, "sCache");
                    vuq = ShareReflectUtil.c(vuo, "getService", String.class);
                } catch (Throwable th) {
                }
            }
        }
    }

    public ServiceBinderInterceptor(Context context, String str, BinderInvocationHandler binderInvocationHandler) {
        Context context2 = context;
        while (context2 != null && (context2 instanceof ContextWrapper)) {
            context2 = ((ContextWrapper) context2).getBaseContext();
        }
        this.vum = context2;
        this.bqB = str;
        this.vun = binderInvocationHandler;
    }

    private static <T> T a(Class<?>[] clsArr, InvocationHandler invocationHandler) {
        Throwable th;
        Object obj;
        Object obj2 = new Class[(clsArr.length + 1)];
        System.arraycopy(clsArr, 0, obj2, 0, clsArr.length);
        obj2[clsArr.length] = ITinkerHotplugProxy.class;
        try {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), obj2, invocationHandler);
        } catch (Throwable th2) {
            RuntimeException runtimeException = new RuntimeException("cl: " + obj, th);
        }
    }

    private static Class<?>[] U(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Set hashSet = new HashSet(10);
        Class cls2;
        while (!Object.class.equals(cls2)) {
            hashSet.addAll(Arrays.asList(cls2.getInterfaces()));
            cls2 = cls2.getSuperclass();
        }
        return (Class[]) hashSet.toArray(new Class[hashSet.size()]);
    }
}
