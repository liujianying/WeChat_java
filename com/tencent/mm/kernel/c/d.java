package com.tencent.mm.kernel.c;

import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    private static final d dsZ = new d();
    public ConcurrentHashMap<Class<? extends a>, c> dsX = new ConcurrentHashMap();
    public a dsY = null;

    public interface a {
        void a(a aVar);

        void a(c cVar);

        void b(c cVar);
    }

    public final <T extends a> T l(Class<T> cls) {
        int i;
        a EV;
        c cVar = (c) this.dsX.get(cls);
        if (cls.isInterface() || !Modifier.isAbstract(cls.getModifiers())) {
            i = 0;
        } else {
            x.w("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
            i = 1;
        }
        if (cVar != null) {
            EV = cVar.EV();
        } else {
            x.e("MicroMsg.ServiceHub", "Service(%s) not found!!! ", cls);
            if (i != 0) {
                x.e("MicroMsg.ServiceHub", "This error must cause by using implementation class to call service! Use interface instead! Understand?");
            }
            T EV2 = null;
        }
        if (this.dsY != null) {
            this.dsY.a(EV2);
        }
        return EV2;
    }
}
