package com.tencent.mm.plugin.normsg.b;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mm.plugin.normsg.b.b.a;
import com.tencent.mm.plugin.normsg.b.b.b;
import com.tencent.mm.plugin.normsg.b.b.e;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

final class b$c extends e {
    final /* synthetic */ b lGB;
    private InvocationHandler lGJ = new 1(this);

    b$c(b bVar, IInterface iInterface) {
        this.lGB = bVar;
        super(bVar, iInterface);
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (b.bP().equals(method.getName()) && objArr != null && objArr.length >= 2) {
            Object obj2 = objArr[1];
            try {
                if (h.findClass(b.ath()).isAssignableFrom(obj2.getClass())) {
                    WeakReference weakReference = (WeakReference) h.g(obj2, b.ew());
                    Object obj3 = weakReference.get();
                    if (obj3 == null) {
                        x.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
                    } else {
                        Object g = VERSION.SDK_INT < 16 ? obj3 : h.g(h.b(obj3, b.bjO(), null, new Object[0]), "mHandler");
                        Callback callback = (Callback) h.g(g, b.access$700());
                        if (!(callback instanceof b)) {
                            h.a(g, b.access$700(), new b(this.lGB, obj3, callback));
                        }
                        synchronized (b.a(this.lGB)) {
                            IBinder iBinder = (IBinder) b.a(this.lGB).get(obj3);
                            if (iBinder == null) {
                                iBinder = new a(this.lGB, weakReference.get(), ((IInterface) obj2).asBinder());
                                b.a(this.lGB).put(obj3, iBinder);
                            }
                            objArr[1] = (IInterface) h.a(b.ath() + "$Stub", "asInterface", h.b(new Class[]{IBinder.class}), new Object[]{iBinder});
                        }
                    }
                } else {
                    throw new IllegalStateException("mismatched conn class: " + obj2.getClass() + ", give up intercepting.");
                }
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.AED", th, "unexpected exception.", new Object[0]);
                b.a(this.lGB, th);
                objArr[1] = obj2;
            }
        }
        return super.invoke(obj, method, objArr);
    }

    public final IBinder asBinder() {
        return (IBinder) Proxy.newProxyInstance(b.bjP(), new Class[]{IBinder.class}, this.lGJ);
    }
}
