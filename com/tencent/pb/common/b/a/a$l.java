package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.ao;
import com.tencent.pb.common.b.a.a.az;
import java.util.Arrays;

public final class a$l extends e {
    public int elY;
    public String groupId;
    public int kpU;
    public int oLB;
    public long oLC;
    public int vcZ;
    public byte[] vda;
    public az[] vdb;
    public ao[] vdc;
    public int vdd;
    public int vde;

    public a$l() {
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.kpU = -1;
        this.vcZ = 0;
        this.vda = g.bfW;
        this.vdb = az.cEC();
        this.vdc = ao.cEx();
        this.vdd = 0;
        this.vde = 0;
        this.elY = 0;
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
        if (this.kpU != -1) {
            bVar.aE(4, this.kpU);
        }
        if (this.vcZ != 0) {
            bVar.aE(5, this.vcZ);
        }
        if (!Arrays.equals(this.vda, g.bfW)) {
            bVar.b(6, this.vda);
        }
        if (this.vdb != null && this.vdb.length > 0) {
            for (e eVar : this.vdb) {
                if (eVar != null) {
                    bVar.a(7, eVar);
                }
            }
        }
        if (this.vdc != null && this.vdc.length > 0) {
            while (i < this.vdc.length) {
                e eVar2 = this.vdc[i];
                if (eVar2 != null) {
                    bVar.a(8, eVar2);
                }
                i++;
            }
        }
        if (this.vdd != 0) {
            bVar.aE(9, this.vdd);
        }
        if (this.vde != 0) {
            bVar.aE(10, this.vde);
        }
        if (this.elY != 0) {
            bVar.aE(11, this.elY);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int i = 0;
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
        if (this.kpU != -1) {
            sl += b.aG(4, this.kpU);
        }
        if (this.vcZ != 0) {
            sl += b.aG(5, this.vcZ);
        }
        if (!Arrays.equals(this.vda, g.bfW)) {
            sl += b.c(6, this.vda);
        }
        if (this.vdb != null && this.vdb.length > 0) {
            int i2;
            int i3 = 0;
            while (true) {
                i2 = sl;
                if (i3 >= this.vdb.length) {
                    break;
                }
                e eVar = this.vdb[i3];
                if (eVar != null) {
                    i2 += b.b(7, eVar);
                }
                sl = i3 + 1;
            }
            sl = i2;
        }
        if (this.vdc != null && this.vdc.length > 0) {
            while (i < this.vdc.length) {
                e eVar2 = this.vdc[i];
                if (eVar2 != null) {
                    sl += b.b(8, eVar2);
                }
                i++;
            }
        }
        if (this.vdd != 0) {
            sl += b.aG(9, this.vdd);
        }
        if (this.vde != 0) {
            sl += b.aG(10, this.vde);
        }
        if (this.elY != 0) {
            return sl + b.aG(11, this.elY);
        }
        return sl;
    }
}
