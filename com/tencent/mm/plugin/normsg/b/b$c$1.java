package com.tencent.mm.plugin.normsg.b;

import com.tencent.mm.plugin.normsg.b.b.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class b$c$1 implements InvocationHandler {
    final /* synthetic */ c lGK;

    b$c$1(c cVar) {
        this.lGK = cVar;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object b;
        synchronized (this.lGK.lGB) {
            if (b.bjQ().equals(method.getName())) {
                b = b.b(this.lGK.lGB);
            } else {
                try {
                    b = method.invoke(this.lGK.lGM.asBinder(), objArr);
                } catch (InvocationTargetException e) {
                    Throwable targetException = e.getTargetException();
                    Class[] exceptionTypes = method.getExceptionTypes();
                    if (exceptionTypes != null && exceptionTypes.length > 0) {
                        for (Class isAssignableFrom : method.getExceptionTypes()) {
                            if (isAssignableFrom.isAssignableFrom(targetException.getClass())) {
                                throw targetException;
                            }
                        }
                    }
                    b.a(this.lGK.lGB, targetException);
                    b = b.b(method);
                } catch (Throwable th) {
                    b.a(this.lGK.lGB, th);
                    b = b.b(method);
                }
            }
        }
        return b;
    }
}
