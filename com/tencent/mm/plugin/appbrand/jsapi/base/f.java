package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class f {
    int fFd;
    c fKJ;

    f(c cVar, int i) {
        this.fKJ = cVar;
        this.fFd = i;
    }

    public final void tp(String str) {
        this.fKJ.E(this.fFd, str);
    }
}
