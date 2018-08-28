package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import java.util.Arrays;

public final class a$p extends e {
    public long bJC;
    public String groupId;
    public int oLB;
    public long oLC;
    public at vcK;
    public int vcN;
    public a$ay vcP;
    public int vdm;
    public aw[] vdn;
    public av[] vdo;
    public a$as vdp;
    public int vdq;
    public byte[] vdr;
    public byte[] vds;
    public av[] vdt;

    public a$p() {
        this.vdm = 0;
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.vcN = 0;
        this.vcK = null;
        this.vdn = aw.cEB();
        this.vdo = av.cEA();
        this.vdp = null;
        this.vcP = null;
        this.bJC = 0;
        this.vdq = 0;
        this.vdr = g.bfW;
        this.vds = g.bfW;
        this.vdt = av.cEA();
        this.bfP = -1;
    }

    public final void a(b bVar) {
        int i = 0;
        if (this.vdm != 0) {
            bVar.aE(1, this.vdm);
        }
        if (!this.groupId.equals("")) {
            bVar.g(2, this.groupId);
        }
        if (this.oLB != 0) {
            bVar.aE(3, this.oLB);
        }
        if (this.oLC != 0) {
            bVar.j(4, this.oLC);
        }
        if (this.vcN != 0) {
            bVar.aF(5, this.vcN);
        }
        if (this.vcK != null) {
            bVar.a(6, this.vcK);
        }
        if (this.vdn != null && this.vdn.length > 0) {
            for (e eVar : this.vdn) {
                if (eVar != null) {
                    bVar.a(7, eVar);
                }
            }
        }
        if (this.vdo != null && this.vdo.length > 0) {
            for (e eVar2 : this.vdo) {
                if (eVar2 != null) {
                    bVar.a(8, eVar2);
                }
            }
        }
        if (this.vdp != null) {
            bVar.a(9, this.vdp);
        }
        if (this.vcP != null) {
            bVar.a(10, this.vcP);
        }
        if (this.bJC != 0) {
            bVar.i(101, this.bJC);
        }
        if (this.vdq != 0) {
            bVar.aF(102, this.vdq);
        }
        if (!Arrays.equals(this.vdr, g.bfW)) {
            bVar.b(103, this.vdr);
        }
        if (!Arrays.equals(this.vds, g.bfW)) {
            bVar.b(200, this.vds);
        }
        if (this.vdt != null && this.vdt.length > 0) {
            while (i < this.vdt.length) {
                e eVar3 = this.vdt[i];
                if (eVar3 != null) {
                    bVar.a(CdnLogic.kAppTypeNearEvent, eVar3);
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
        if (this.vdm != 0) {
            sl += b.aG(1, this.vdm);
        }
        if (!this.groupId.equals("")) {
            sl += b.h(2, this.groupId);
        }
        if (this.oLB != 0) {
            sl += b.aG(3, this.oLB);
        }
        if (this.oLC != 0) {
            sl += b.l(4, this.oLC);
        }
        if (this.vcN != 0) {
            sl += b.aH(5, this.vcN);
        }
        if (this.vcK != null) {
            sl += b.b(6, this.vcK);
        }
        if (this.vdn != null && this.vdn.length > 0) {
            i = 0;
            while (true) {
                i2 = sl;
                if (i >= this.vdn.length) {
                    break;
                }
                eVar = this.vdn[i];
                if (eVar != null) {
                    i2 += b.b(7, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
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
                    i2 += b.b(8, eVar);
                }
                sl = i + 1;
            }
            sl = i2;
        }
        if (this.vdp != null) {
            sl += b.b(9, this.vdp);
        }
        if (this.vcP != null) {
            sl += b.b(10, this.vcP);
        }
        if (this.bJC != 0) {
            sl += b.k(101, this.bJC);
        }
        if (this.vdq != 0) {
            sl += b.aH(102, this.vdq);
        }
        if (!Arrays.equals(this.vdr, g.bfW)) {
            sl += b.c(103, this.vdr);
        }
        if (!Arrays.equals(this.vds, g.bfW)) {
            sl += b.c(200, this.vds);
        }
        if (this.vdt != null && this.vdt.length > 0) {
            while (i3 < this.vdt.length) {
                e eVar2 = this.vdt[i3];
                if (eVar2 != null) {
                    sl += b.b(CdnLogic.kAppTypeNearEvent, eVar2);
                }
                i3++;
            }
        }
        return sl;
    }
}
