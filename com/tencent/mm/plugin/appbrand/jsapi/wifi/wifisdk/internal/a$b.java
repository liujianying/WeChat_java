package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class a$b implements InvocationHandler {
    final /* synthetic */ a gdN;

    a$b(a aVar) {
        this.gdN = aVar;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        new StringBuilder("Method:").append(method).append(" getName:").append(method.getName()).append(" ,Args:").append(objArr);
        return null;
    }
}
