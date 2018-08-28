package com.tencent.mm.by;

import com.tencent.mm.vending.g.c.a;
import com.tencent.mm.vending.j.d;

public final class g {
    public static final <_Var> f<_Var> c(a<_Var> aVar) {
        return new f().b(aVar);
    }

    public static final f<Void> cDZ() {
        return new f().z(new Object[0]);
    }

    public static final <Var1> f<Var1> cC(Var1 var1) {
        return new f().z(new Object[]{var1});
    }

    public static final <Var1, Var2, Var3> f<d<Var1, Var2, Var3>> b(Var1 var1, Var2 var2, Var3 var3) {
        return new f().z(new Object[]{var1, var2, var3});
    }
}
