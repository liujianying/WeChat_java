package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$u extends e {
    public int nc;
    public int qXJ;
    public int ret;
    public String userName;
    public int vcN;
    public int vdU;
    public int vdV;

    public a$u() {
        this.userName = "";
        this.nc = 0;
        this.vdU = 0;
        this.ret = 0;
        this.vdV = 0;
        this.vcN = 0;
        this.qXJ = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (!this.userName.equals("")) {
            bVar.g(2, this.userName);
        }
        if (this.nc != 0) {
            bVar.aE(3, this.nc);
        }
        if (this.vdU != 0) {
            bVar.aF(4, this.vdU);
        }
        if (this.ret != 0) {
            bVar.aE(5, this.ret);
        }
        if (this.vdV != 0) {
            bVar.aE(6, this.vdV);
        }
        if (this.vcN != 0) {
            bVar.aF(7, this.vcN);
        }
        if (this.qXJ != 0) {
            bVar.aF(8, this.qXJ);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (!this.userName.equals("")) {
            sl += b.h(2, this.userName);
        }
        if (this.nc != 0) {
            sl += b.aG(3, this.nc);
        }
        if (this.vdU != 0) {
            sl += b.aH(4, this.vdU);
        }
        if (this.ret != 0) {
            sl += b.aG(5, this.ret);
        }
        if (this.vdV != 0) {
            sl += b.aG(6, this.vdV);
        }
        if (this.vcN != 0) {
            sl += b.aH(7, this.vcN);
        }
        if (this.qXJ != 0) {
            return sl + b.aH(8, this.qXJ);
        }
        return sl;
    }
}
