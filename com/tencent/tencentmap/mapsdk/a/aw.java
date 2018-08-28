package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.atomic.AtomicInteger;

public class aw {
    private AtomicInteger a;
    private AtomicInteger b;

    public bb a(au auVar, ah ahVar) {
        if (ahVar.a(2)) {
            return c(auVar, ahVar);
        }
        bb b = b(auVar, ahVar);
        if (b == null) {
            return a((mk) auVar, ahVar);
        }
        return b;
    }

    public bb b(au auVar, ah ahVar) {
        if (ahVar.a(1)) {
            bb a = auVar.a(0, ahVar.b());
            if (a != null) {
                return a;
            }
            ax.a(auVar.j + " do not have active service in getHashSelect hash invoke");
        }
        return null;
    }

    public bb a(mk mkVar, ah ahVar) {
        if (mkVar.a(0)) {
            bb a = mkVar.a(0, this.a.incrementAndGet());
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    public bb c(au auVar, ah ahVar) {
        if (ahVar.a(2)) {
            if (auVar.a(ahVar.c())) {
                bb a;
                if (ahVar.b() == -1) {
                    a = auVar.a(ahVar.c(), this.b.incrementAndGet());
                    if (a != null) {
                        return a;
                    }
                    ax.a(ahVar.a() + " get gridActiveServices " + ahVar.c() + " is null");
                } else {
                    a = auVar.a(ahVar.c(), ahVar.b());
                    if (a != null) {
                        return a;
                    }
                    ax.a(auVar.j + " do not have active service in getGridSelect hash invoke");
                }
            } else if (auVar.d()) {
                throw new bl("gridValue is " + ahVar.c() + ", but no gridService can use");
            }
        }
        return null;
    }
}
