package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class aj implements InvocationHandler {
    private final Map<String, Method> fhw = new ConcurrentHashMap();
    private final a fhx;

    public static l k(g gVar) {
        try {
            InvocationHandler ajVar = new aj(ao.m(gVar));
            return (l) Proxy.newProxyInstance(l.class.getClassLoader(), new Class[]{l.class}, ajVar);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "createInstance e=%s", new Object[]{e});
            return new com.tencent.mm.plugin.appbrand.appstorage.g();
        }
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.getReturnType().equals(Boolean.TYPE)) {
            return Boolean.TRUE;
        }
        if (Modifier.isStatic(method.getModifiers())) {
            return null;
        }
        o qP;
        Method a;
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
            qP = this.fhx.qP((String) objArr[0]);
            if (qP == null) {
                return method.getReturnType().equals(j.class) ? j.fkM : null;
            } else {
                a = a(method);
                if (a != null) {
                    return a.invoke(qP, objArr);
                }
            }
        } else if (method.getReturnType().equals(Void.TYPE)) {
            Collection<o> aci = this.fhx.aci();
            if (aci != null) {
                a = a(method);
                if (a != null) {
                    for (o qP2 : aci) {
                        a.invoke(qP2, objArr);
                    }
                }
            }
            return null;
        }
        return null;
    }

    private Method a(Method method) {
        Method method2 = (Method) this.fhw.get(method.getName());
        if (method2 == null) {
            method2 = o.class.getMethod(method.getName(), method.getParameterTypes());
            if (method2 != null) {
                this.fhw.put(method.getName(), method2);
            }
        }
        return method2;
    }

    private aj(n nVar) {
        this.fhx = new a(nVar, (byte) 0);
    }
}
