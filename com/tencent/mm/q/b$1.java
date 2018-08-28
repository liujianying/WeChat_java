package com.tencent.mm.q;

import com.tencent.mm.q.b.c;
import com.tencent.mm.q.b.d;
import com.tencent.mm.q.b.f;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;

class b$1 implements b {
    final /* synthetic */ b dhZ;

    b$1(b bVar) {
        this.dhZ = bVar;
    }

    public final void a(int i, m mVar, Object obj) {
        if (b.BU()) {
            String str = (obj == null || !(obj instanceof String)) ? null : (String) obj;
            switch (i) {
                case 2:
                    if (str != null) {
                        this.dhZ.dhW.a(65636, new f(this.dhZ, str));
                        return;
                    }
                    return;
                case 5:
                    if (str == null) {
                        this.dhZ.dhW.a(65636, new c(this.dhZ));
                        return;
                    } else {
                        this.dhZ.dhW.a(65636, new d(this.dhZ, str));
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
