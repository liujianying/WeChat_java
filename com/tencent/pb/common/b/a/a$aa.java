package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.as;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.o;
import java.util.Arrays;

public final class a$aa extends e {
    public String groupId;
    public int oLB;
    public long oLC;
    public at vcK;
    public int vcU;
    public int vdi;
    public as vdp;
    public av[] vdt;
    public av[] vea;
    public o[] veb;
    public aw[] vec;
    public int ved;
    public int[] vee;
    public o[] vef;
    public int veg;
    public int veh;
    public o[] vei;
    public int vej;
    public int vek;
    public int vel;
    public byte[] vem;

    public a$aa() {
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.veb = o.cEu();
        this.vea = av.cEA();
        this.vdp = null;
        this.ved = 0;
        this.vee = g.bfQ;
        this.vcU = 0;
        this.vec = aw.cEB();
        this.vcK = null;
        this.vdi = 0;
        this.vef = o.cEu();
        this.vei = o.cEu();
        this.vej = 0;
        this.vek = 0;
        this.vel = 0;
        this.vem = g.bfW;
        this.veg = 0;
        this.veh = 0;
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
        if (this.vea != null && this.vea.length > 0) {
            for (e eVar2 : this.vea) {
                if (eVar2 != null) {
                    bVar.a(5, eVar2);
                }
            }
        }
        if (this.vdp != null) {
            bVar.a(6, this.vdp);
        }
        if (this.ved != 0) {
            bVar.aE(7, this.ved);
        }
        if (this.vee != null && this.vee.length > 0) {
            for (int aE : this.vee) {
                bVar.aE(8, aE);
            }
        }
        if (this.vcU != 0) {
            bVar.aE(9, this.vcU);
        }
        if (this.vec != null && this.vec.length > 0) {
            for (e eVar22 : this.vec) {
                if (eVar22 != null) {
                    bVar.a(10, eVar22);
                }
            }
        }
        if (this.vcK != null) {
            bVar.a(11, this.vcK);
        }
        if (this.vdi != 0) {
            bVar.aF(12, this.vdi);
        }
        if (this.vef != null && this.vef.length > 0) {
            for (e eVar222 : this.vef) {
                if (eVar222 != null) {
                    bVar.a(13, eVar222);
                }
            }
        }
        if (this.vei != null && this.vei.length > 0) {
            for (e eVar2222 : this.vei) {
                if (eVar2222 != null) {
                    bVar.a(14, eVar2222);
                }
            }
        }
        if (this.vej != 0) {
            bVar.aE(15, this.vej);
        }
        if (this.vek != 0) {
            bVar.aE(16, this.vek);
        }
        if (this.vel != 0) {
            bVar.aE(17, this.vel);
        }
        if (!Arrays.equals(this.vem, g.bfW)) {
            bVar.b(18, this.vem);
        }
        if (this.veg != 0) {
            bVar.aF(100, this.veg);
        }
        if (this.veh != 0) {
            bVar.aF(101, this.veh);
        }
        if (this.vdt != null && this.vdt.length > 0) {
            while (i < this.vdt.length) {
                e eVar3 = this.vdt[i];
                if (eVar3 != null) {
                    bVar.a(102, eVar3);
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
        if (this.vea != null && this.vea.length > 0) {
            i = 0;
            while (true) {
                i2 = sl;
                if (i >= this.vea.length) {
                    break;
                }
                eVar = this.vea[i];
                if (eVar != null) {
                    i2 += b.b(5, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vdp != null) {
            sl += b.b(6, this.vdp);
        }
        if (this.ved != 0) {
            sl += b.aG(7, this.ved);
        }
        if (this.vee != null && this.vee.length > 0) {
            i2 = 0;
            for (int ea : this.vee) {
                i2 += b.ea(ea);
            }
            sl = (sl + i2) + (this.vee.length * 1);
        }
        if (this.vcU != 0) {
            sl += b.aG(9, this.vcU);
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
                    i2 += b.b(10, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vcK != null) {
            sl += b.b(11, this.vcK);
        }
        if (this.vdi != 0) {
            sl += b.aH(12, this.vdi);
        }
        if (this.vef != null && this.vef.length > 0) {
            i = 0;
            while (true) {
                i2 = sl;
                if (i >= this.vef.length) {
                    break;
                }
                eVar = this.vef[i];
                if (eVar != null) {
                    i2 += b.b(13, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vei != null && this.vei.length > 0) {
            i = 0;
            while (true) {
                i2 = sl;
                if (i >= this.vei.length) {
                    break;
                }
                eVar = this.vei[i];
                if (eVar != null) {
                    i2 += b.b(14, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vej != 0) {
            sl += b.aG(15, this.vej);
        }
        if (this.vek != 0) {
            sl += b.aG(16, this.vek);
        }
        if (this.vel != 0) {
            sl += b.aG(17, this.vel);
        }
        if (!Arrays.equals(this.vem, g.bfW)) {
            sl += b.c(18, this.vem);
        }
        if (this.veg != 0) {
            sl += b.aH(100, this.veg);
        }
        if (this.veh != 0) {
            sl += b.aH(101, this.veh);
        }
        if (this.vdt != null && this.vdt.length > 0) {
            while (i3 < this.vdt.length) {
                e eVar2 = this.vdt[i3];
                if (eVar2 != null) {
                    sl += b.b(102, eVar2);
                }
                i3++;
            }
        }
        return sl;
    }
}
