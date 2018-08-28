package com.tencent.mm.app;

import com.tencent.mm.app.a.a.a;

class a$a$a$a extends Throwable {
    final /* synthetic */ a bxV;

    /* synthetic */ a$a$a$a(a aVar, a$a$a$a a_a_a_a, byte b) {
        this(aVar, a_a_a_a);
    }

    private a$a$a$a(a aVar, a$a$a$a a_a_a_a) {
        this.bxV = aVar;
        super(aVar.name, a_a_a_a);
    }

    public final Throwable fillInStackTrace() {
        setStackTrace(this.bxV.bxU);
        return this;
    }
}
