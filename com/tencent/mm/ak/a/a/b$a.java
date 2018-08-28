package com.tencent.mm.ak.a.a;

import android.content.Context;
import com.tencent.mm.ak.a.b.c;
import com.tencent.mm.ak.a.b.d;
import com.tencent.mm.ak.a.b.g;
import com.tencent.mm.ak.a.b.i;
import com.tencent.mm.ak.a.c.a;
import com.tencent.mm.ak.a.c.b;
import com.tencent.mm.ak.a.c.e;
import com.tencent.mm.ak.a.c.f;
import com.tencent.mm.ak.a.c.h;
import com.tencent.mm.ak.a.c.j;
import com.tencent.mm.ak.a.c.k;
import com.tencent.mm.ak.a.c.m;
import com.tencent.mm.ak.a.c.n;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class b$a {
    Context context;
    int dXi = b.dXg;
    int dXj = 5;
    c dXk = null;
    public m dXl = null;
    a dXm = null;
    public b dXn = null;
    f dXo = null;
    j dXp = null;
    e dXr = null;
    h dXs = null;
    Executor dXt;
    n dXu = null;
    k dXv = null;

    public b$a(Context context) {
        this.context = context.getApplicationContext();
    }

    public final b Ps() {
        if (this.dXk == null) {
            this.dXk = new c.a().Pt();
        }
        if (this.dXl == null) {
            this.dXl = new com.tencent.mm.ak.a.b.f();
        }
        if (this.dXm == null) {
            this.dXm = new com.tencent.mm.ak.a.b.a();
        }
        if (this.dXn == null) {
            this.dXn = new com.tencent.mm.ak.a.b.b();
        }
        if (this.dXo == null) {
            this.dXo = new d();
        }
        if (this.dXp == null) {
            this.dXp = new i();
        }
        if (this.dXs == null) {
            this.dXs = a.bf(this.dXi, this.dXj);
        }
        if (this.dXt == null) {
            this.dXt = Executors.newSingleThreadExecutor();
        }
        if (this.dXv == null) {
            this.dXv = new com.tencent.mm.ak.a.b.e();
        }
        if (this.dXr == null) {
            this.dXr = new c();
        }
        if (this.dXu == null) {
            this.dXu = new g();
        }
        return new b(this);
    }
}
