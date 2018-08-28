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

public final class a$aj extends e {
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
    public o[] vef;
    public o[] vei;
    public int vej;
    public int vek;
    public int vel;
    public byte[] vem;

    public a$aj() {
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.veb = o.cEu();
        this.vea = av.cEA();
        this.vdp = null;
        this.ved = 0;
        this.vee = g.bfQ;
        this.vec = aw.cEB();
        this.vcK = null;
        this.vef = o.cEu();
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
        if (this.vec != null && this.vec.length > 0) {
            for (e eVar22 : this.vec) {
                if (eVar22 != null) {
                    bVar.a(9, eVar22);
                }
            }
        }
        if (this.vcK != null) {
            bVar.a(10, this.vcK);
        }
        if (this.vef != null && this.vef.length > 0) {
            for (e eVar222 : this.vef) {
                if (eVar222 != null) {
                    bVar.a(11, eVar222);
                }
            }
        }
        if (this.vdt != null && this.vdt.length > 0) {
            for (e eVar2222 : this.vdt) {
                if (eVar2222 != null) {
                    bVar.a(12, eVar2222);
                }
            }
        }
        if (this.vei != null && this.vei.length > 0) {
            while (i < this.vei.length) {
                e eVar3 = this.vei[i];
                if (eVar3 != null) {
                    bVar.a(13, eVar3);
                }
                i++;
            }
        }
        if (this.vej != 0) {
            bVar.aE(14, this.vej);
        }
        if (this.vek != 0) {
            bVar.aE(15, this.vek);
        }
        if (this.vel != 0) {
            bVar.aE(16, this.vel);
        }
        if (!Arrays.equals(this.vem, g.bfW)) {
            bVar.b(17, this.vem);
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
        if (this.vec != null && this.vec.length > 0) {
            i = 0;
            while (true) {
                i2 = sl;
                if (i >= this.vec.length) {
                    break;
                }
                eVar = this.vec[i];
                if (eVar != null) {
                    i2 += b.b(9, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vcK != null) {
            sl += b.b(10, this.vcK);
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
                    i2 += b.b(11, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
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
                    i2 += b.b(12, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vei != null && this.vei.length > 0) {
            while (i3 < this.vei.length) {
                e eVar2 = this.vei[i3];
                if (eVar2 != null) {
                    sl += b.b(13, eVar2);
                }
                i3++;
            }
        }
        if (this.vej != 0) {
            sl += b.aG(14, this.vej);
        }
        if (this.vek != 0) {
            sl += b.aG(15, this.vek);
        }
        if (this.vel != 0) {
            sl += b.aG(16, this.vel);
        }
        if (Arrays.equals(this.vem, g.bfW)) {
            return sl;
        }
        return sl + b.c(17, this.vem);
    }
}
