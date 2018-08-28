package com.tencent.mm.vending.g;

import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.e;
import com.tencent.mm.vending.j.f;
import java.util.Stack;

public final class g {
    private static final a uRB = new a();

    public static final c<Void> cBK() {
        return new e().w(new Object[0]);
    }

    public static final <Var1> c<Var1> cx(Var1 var1) {
        return new e().w(var1);
    }

    public static final <Var1, Var2> c<c<Var1, Var2>> v(Var1 var1, Var2 var2) {
        return new e().w(var1, var2);
    }

    public static final <Var1, Var2, Var3> c<d<Var1, Var2, Var3>> a(Var1 var1, Var2 var2, Var3 var3) {
        return new e().w(var1, var2, var3);
    }

    public static final <Var1, Var2, Var3, Var4> c<e<Var1, Var2, Var3, Var4>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4) {
        return new e().w(var1, var2, var3, var4);
    }

    public static final <Var1, Var2, Var3, Var4, Var5> c<f<Var1, Var2, Var3, Var4, Var5>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4, Var5 var5) {
        return new e().w(var1, var2, var3, var4, var5);
    }

    public static <$1> b<$1> cy($1 $1) {
        b bVar = new b();
        return a.cz($1);
    }

    public static <$1, $2> c<$1, $2> w($1 $1, $2 $2) {
        c cVar = new c();
        return a.x($1, $2);
    }

    public static final b cBF() {
        f cBJ = f.cBJ();
        Stack stack = (Stack) cBJ.uRA.get();
        c cVar = stack == null ? null : stack.size() == 0 ? null : (c) ((Stack) cBJ.uRA.get()).peek();
        return cVar != null ? cVar.cBF() : uRB;
    }

    public static final b cBL() {
        b cBF = cBF();
        if (cBF != null) {
            cBF.cBE();
        } else {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        }
        return cBF;
    }

    public static final void a(b bVar, Object... objArr) {
        if (bVar == null) {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        } else if (objArr.length > 0) {
            bVar.v(objArr);
        } else {
            bVar.resume();
        }
    }

    public static final void a(b bVar) {
        if (bVar == null) {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        } else {
            bVar.ct(null);
        }
    }

    public static final <_Var> void a(d<_Var> dVar) {
        final b cBL = cBL();
        dVar.a(new d.b<_Var>() {
            public final void aF(_Var _var) {
                g.a(cBL, _var);
            }
        }).a(new d.a() {
            public final void bd(Object obj) {
                cBL.ct(obj);
            }
        });
    }
}
