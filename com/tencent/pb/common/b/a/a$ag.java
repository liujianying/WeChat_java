package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.o;

public final class a$ag extends e {
    public String groupId;
    public int oLB;
    public long oLC;
    public at vcK;
    public as vdp;
    public av[] vdt;
    public av[] vea;
    public o[] veb;
    public aw[] vec;
    public int ved;
    public int[] vee;

    public a$ag() {
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.veb = o.cEu();
        this.vdp = null;
        this.ved = 0;
        this.vee = g.bfQ;
        this.vea = av.cEA();
        this.vec = aw.cEB();
        this.vcK = null;
        this.vdt = av.cEA();
        this.bfP = -1;
    }

    public final void a(b bVar) {
        int i = 0;
        if (!this.groupId.equals("")) {
            bVar.g(1, this.groupId);
        }
        if (this.oLB != 0) {
            bVar.aE(2, this.oLB);
        }
        if (this.oLC != 0) {
            bVar.j(3, this.oLC);
        }
        if (this.veb != null && this.veb.length > 0) {
            for (e eVar : this.veb) {
                if (eVar != null) {
                    bVar.a(4, eVar);
                }
            }
        }
        if (this.vdp != null) {
            bVar.a(5, this.vdp);
        }
        if (this.ved != 0) {
            bVar.aE(6, this.ved);
        }
        if (this.vee != null && this.vee.length > 0) {
            for (int aE : this.vee) {
                bVar.aE(7, aE);
            }
        }
        if (this.vea != null && this.vea.length > 0) {
            for (e eVar2 : this.vea) {
                if (eVar2 != null) {
                    bVar.a(200, eVar2);
                }
            }
        }
        if (this.vec != null && this.vec.length > 0) {
            for (e eVar22 : this.vec) {
                if (eVar22 != null) {
                    bVar.a(201, eVar22);
                }
            }
        }
        if (this.vcK != null) {
            bVar.a(202, this.vcK);
        }
        if (this.vdt != null && this.vdt.length > 0) {
            while (i < this.vdt.length) {
                e eVar3 = this.vdt[i];
                if (eVar3 != null) {
                    bVar.a(com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX, eVar3);
                }
                i++;
            }
        }
        super.a(bVar);
    }

    protected final int sl() {
        int i;
        int i2;
        e eVar;
        int i3 = 0;
        int sl = super.sl();
        if (!this.groupId.equals("")) {
            sl += b.h(1, this.groupId);
        }
        if (this.oLB != 0) {
            sl += b.aG(2, this.oLB);
        }
        if (this.oLC != 0) {
            sl += b.l(3, this.oLC);
        }
        if (this.veb != null && this.veb.length > 0) {
            i = 0;
            while (true) {
                i2 = sl;
                if (i >= this.veb.length) {
                    break;
                }
                eVar = this.veb[i];
                if (eVar != null) {
                    i2 += b.b(4, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vdp != null) {
            sl += b.b(5, this.vdp);
        }
        if (this.ved != 0) {
            sl += b.aG(6, this.ved);
        }
        if (this.vee != null && this.vee.length > 0) {
            i2 = 0;
            for (int ea : this.vee) {
                i2 += b.ea(ea);
            }
            sl = (sl + i2) + (this.vee.length * 1);
        }
        if (this.vea != null && this.vea.length > 0) {
            i = 0;
            while (true) {
                i2 = sl;
                if (i >= this.vea.length) {
                    break;
                }
                eVar = this.vea[i];
                if (eVar != null) {
                    i2 += b.b(200, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vec != null && this.vec.length > 0) {
            i = 0;
            while (true) {
                i2 = sl;
                if (i >= this.vec.length) {
                    break;
                }
                eVar = this.vec[i];
                if (eVar != null) {
                    i2 += b.b(201, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vcK != null) {
            sl += b.b(202, this.vcK);
        }
        if (this.vdt != null && this.vdt.length > 0) {
            while (i3 < this.vdt.length) {
                e eVar2 = this.vdt[i3];
                if (eVar2 != null) {
                    sl += b.b((int) com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX, eVar2);
                }
                i3++;
            }
        }
        return sl;
    }
}
