package com.tencent.mm.ab;

import com.tencent.mm.ab.a.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

class a$b<_Resp extends bhp> extends l {
    a dIA;
    private k dIB = new k() {
        public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
            b bVar = a$b.this.dIz;
            Object[] objArr = new Object[1];
            objArr[0] = a.a(i2, i3, str, (bhp) a$b.this.dIy.dIE.dIL, a$b.this, a$b.this.dIA);
            g.a(bVar, objArr);
            a$b.this.doG.a(i2, i3, str, a$b.this.dIx);
            x.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[]{Integer.valueOf(a$b.this.dIx.hashCode()), Integer.valueOf(a$b.this.getType()), Long.valueOf(bi.VF() - a$b.this.mStartTime), Integer.valueOf(i2), Integer.valueOf(i3), str});
        }
    };
    final l dIx = this;
    b dIy;
    b dIz;
    e doG = null;
    final long mStartTime = bi.VF();

    public a$b(a aVar) {
        this.dIA = aVar;
    }

    protected final int Cc() {
        return 1;
    }

    public final int getType() {
        return this.dIy.dIF;
    }

    public final int a(e eVar, e eVar2) {
        this.doG = eVar2;
        int a = a(eVar, this.dIy, this.dIB);
        x.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[]{Integer.valueOf(this.dIx.hashCode()), Integer.valueOf(this.dIy.dIF), Integer.valueOf(a), Long.valueOf(bi.VF() - this.mStartTime)});
        if (a < 0) {
            g.a(this.dIz, new Object[]{a.a(3, -1, "", (bhp) this.dIy.dIE.dIL, this, this.dIA)});
        }
        return a;
    }
}
