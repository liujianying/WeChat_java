package com.tencent.mm.view.e;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class a$7 implements a {
    final /* synthetic */ a uWa;

    a$7(a aVar) {
        this.uWa = aVar;
    }

    public final void a(String str, l lVar) {
        Object obj = lVar.obj;
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (!a.d(this.uWa).cCL() && intValue >= 3) {
            a.d(this.uWa).cCM();
            a.g(this.uWa);
            this.uWa.cCw();
        } else if (a.h(this.uWa) != null && a.c(this.uWa) != null) {
            a.h(this.uWa).as(a.c(this.uWa).getCurrentItem(), false);
        }
    }
}
