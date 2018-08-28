package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.ao.c;
import com.tencent.mm.plugin.appbrand.appcache.ao.d;
import com.tencent.mm.plugin.appbrand.appcache.ao.e;
import com.tencent.xweb.m;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

interface ao$b<T> {

    public static class a {
        static final Map<Class, ao$b> fhW;

        static {
            Map hashMap = new HashMap();
            fhW = hashMap;
            hashMap.put(InputStream.class, new c((byte) 0));
            fhW.put(m.class, new e((byte) 0));
            fhW.put(String.class, new d((byte) 0));
            fhW.put(byte[].class, new com.tencent.mm.plugin.appbrand.appcache.ao.a((byte) 0));
        }
    }

    T c(String str, InputStream inputStream);
}
