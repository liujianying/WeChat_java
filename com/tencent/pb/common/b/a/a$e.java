package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.m;
import com.tencent.pb.common.b.a.a.s;

public final class a$e extends e {
    public String groupId;
    public int netType;
    public int oLB;
    public long oLC;
    public int vcG;
    public at vcK;
    public a$ba vcM;
    public int vcO;
    public String[] vcR;
    public m[] vcS;
    public int vcT;
    public int vcU;
    public s vcV;
    public int vcW;

    public a$e() {
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.vcM = null;
        this.vcU = 0;
        this.vcO = 0;
        this.vcG = 0;
        this.netType = 0;
        this.vcK = null;
        this.vcR = g.EMPTY_STRING_ARRAY;
        this.vcS = m.cEs();
        this.vcV = null;
        this.vcW = 0;
        this.vcT = 0;
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
        if (this.vcM != null) {
            bVar.a(4, this.vcM);
        }
        if (this.vcU != 0) {
            bVar.aE(5, this.vcU);
        }
        if (this.vcO != 0) {
            bVar.aF(6, this.vcO);
        }
        if (this.vcG != 0) {
            bVar.aE(7, this.vcG);
        }
        if (this.netType != 0) {
            bVar.aF(8, this.netType);
        }
        if (this.vcK != null) {
            bVar.a(200, this.vcK);
        }
        if (this.vcR != null && this.vcR.length > 0) {
            for (String str : this.vcR) {
                if (str != null) {
                    bVar.g(201, str);
                }
            }
        }
        if (this.vcS != null && this.vcS.length > 0) {
            while (i < this.vcS.length) {
                e eVar = this.vcS[i];
                if (eVar != null) {
                    bVar.a(202, eVar);
                }
                i++;
            }
        }
        if (this.vcV != null) {
            bVar.a(com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX, this.vcV);
        }
        if (this.vcW != 0) {
            bVar.aF(204, this.vcW);
        }
        if (this.vcT != 0) {
            bVar.aF(240, this.vcT);
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
        if (this.vcM != null) {
            sl += b.b(4, this.vcM);
        }
        if (this.vcU != 0) {
            sl += b.aG(5, this.vcU);
        }
        if (this.vcO != 0) {
            sl += b.aH(6, this.vcO);
        }
        if (this.vcG != 0) {
            sl += b.aG(7, this.vcG);
        }
        if (this.netType != 0) {
            sl += b.aH(8, this.netType);
        }
        if (this.vcK != null) {
            sl += b.b(200, this.vcK);
        }
        if (this.vcR != null && this.vcR.length > 0) {
            int i2 = 0;
            int i3 = 0;
            for (String str : this.vcR) {
                if (str != null) {
                    i3++;
                    i2 += b.bE(str);
                }
            }
            sl = (sl + i2) + (i3 * 2);
        }
        if (this.vcS != null && this.vcS.length > 0) {
            while (i < this.vcS.length) {
                e eVar = this.vcS[i];
                if (eVar != null) {
                    sl += b.b(202, eVar);
                }
                i++;
            }
        }
        if (this.vcV != null) {
            sl += b.b((int) com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX, this.vcV);
        }
        if (this.vcW != 0) {
            sl += b.aH(204, this.vcW);
        }
        if (this.vcT != 0) {
            return sl + b.aH(240, this.vcT);
        }
        return sl;
    }
}
