package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.o;
import java.util.Arrays;

public final class a$z extends e {
    public String groupId;
    public int oLB;
    public long oLC;
    public String vcI;
    public at vcK;
    public int vcN;
    public int vdi;
    public av[] vdo;
    public a$as vdp;
    public av[] vdt;
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

    public a$z() {
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.vcN = 0;
        this.veb = o.cEu();
        this.vec = aw.cEB();
        this.vdp = null;
        this.vcI = "";
        this.vdo = av.cEA();
        this.ved = 0;
        this.vee = g.bfQ;
        this.vcK = null;
        this.vdi = 0;
        this.vef = o.cEu();
        this.veg = 0;
        this.veh = 0;
        this.vdt = av.cEA();
        this.vei = o.cEu();
        this.vej = 0;
        this.vek = 0;
        this.vel = 0;
        this.vem = g.bfW;
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
        if (this.vcN != 0) {
            bVar.aF(4, this.vcN);
        }
        if (this.veb != null && this.veb.length > 0) {
            for (e eVar : this.veb) {
                if (eVar != null) {
                    bVar.a(5, eVar);
                }
            }
        }
        if (this.vec != null && this.vec.length > 0) {
            for (e eVar2 : this.vec) {
                if (eVar2 != null) {
                    bVar.a(6, eVar2);
                }
            }
        }
        if (this.vdp != null) {
            bVar.a(7, this.vdp);
        }
        if (!this.vcI.equals("")) {
            bVar.g(8, this.vcI);
        }
        if (this.vdo != null && this.vdo.length > 0) {
            for (e eVar22 : this.vdo) {
                if (eVar22 != null) {
                    bVar.a(9, eVar22);
                }
            }
        }
        if (this.ved != 0) {
            bVar.aE(10, this.ved);
        }
        if (this.vee != null && this.vee.length > 0) {
            for (int aE : this.vee) {
                bVar.aE(11, aE);
            }
        }
        if (this.vcK != null) {
            bVar.a(12, this.vcK);
        }
        if (this.vdi != 0) {
            bVar.aF(13, this.vdi);
        }
        if (this.vef != null && this.vef.length > 0) {
            for (e eVar222 : this.vef) {
                if (eVar222 != null) {
                    bVar.a(14, eVar222);
                }
            }
        }
        if (this.veg != 0) {
            bVar.aF(15, this.veg);
        }
        if (this.veh != 0) {
            bVar.aF(16, this.veh);
        }
        if (this.vdt != null && this.vdt.length > 0) {
            for (e eVar2222 : this.vdt) {
                if (eVar2222 != null) {
                    bVar.a(17, eVar2222);
                }
            }
        }
        if (this.vei != null && this.vei.length > 0) {
            while (i < this.vei.length) {
                e eVar3 = this.vei[i];
                if (eVar3 != null) {
                    bVar.a(18, eVar3);
                }
                i++;
            }
        }
        if (this.vej != 0) {
            bVar.aE(19, this.vej);
        }
        if (this.vek != 0) {
            bVar.aE(20, this.vek);
        }
        if (this.vel != 0) {
            bVar.aE(21, this.vel);
        }
        if (!Arrays.equals(this.vem, g.bfW)) {
            bVar.b(22, this.vem);
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
        if (this.vcN != 0) {
            sl += b.aH(4, this.vcN);
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
                    i2 += b.b(5, eVar);
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
                    i2 += b.b(6, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vdp != null) {
            sl += b.b(7, this.vdp);
        }
        if (!this.vcI.equals("")) {
            sl += b.h(8, this.vcI);
        }
        if (this.vdo != null && this.vdo.length > 0) {
            i = 0;
            while (true) {
                i2 = sl;
                if (i >= this.vdo.length) {
                    break;
                }
                eVar = this.vdo[i];
                if (eVar != null) {
                    i2 += b.b(9, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.ved != 0) {
            sl += b.aG(10, this.ved);
        }
        if (this.vee != null && this.vee.length > 0) {
            i2 = 0;
            for (int ea : this.vee) {
                i2 += b.ea(ea);
            }
            sl = (sl + i2) + (this.vee.length * 1);
        }
        if (this.vcK != null) {
            sl += b.b(12, this.vcK);
        }
        if (this.vdi != 0) {
            sl += b.aH(13, this.vdi);
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
                    i2 += b.b(14, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.veg != 0) {
            sl += b.aH(15, this.veg);
        }
        if (this.veh != 0) {
            sl += b.aH(16, this.veh);
        }
        if (this.vdt != null && this.vdt.length > 0) {
            i = 0;
            while (true) {
                i2 = sl;
                if (i >= this.vdt.length) {
                    break;
                }
                eVar = this.vdt[i];
                if (eVar != null) {
                    i2 += b.b(17, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vei != null && this.vei.length > 0) {
            while (i3 < this.vei.length) {
                e eVar2 = this.vei[i3];
                if (eVar2 != null) {
                    sl += b.b(18, eVar2);
                }
                i3++;
            }
        }
        if (this.vej != 0) {
            sl += b.aG(19, this.vej);
        }
        if (this.vek != 0) {
            sl += b.aG(20, this.vek);
        }
        if (this.vel != 0) {
            sl += b.aG(21, this.vel);
        }
        if (Arrays.equals(this.vem, g.bfW)) {
            return sl;
        }
        return sl + b.c(22, this.vem);
    }
}
