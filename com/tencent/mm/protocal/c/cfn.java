package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cfn extends a {
    public String bhd;
    public String ixy;
    public String ixz;
    public String lRt;
    public String nzH;
    public String pLA;
    public String pLB;
    public String pLC;
    public String pLr;
    public String pLs;
    public String pLt;
    public String pLu;
    public long pLv;
    public String pLw;
    public String pLx;
    public String pLy;
    public String pLz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.pLr != null) {
                aVar.g(1, this.pLr);
            }
            if (this.pLs != null) {
                aVar.g(2, this.pLs);
            }
            if (this.pLt != null) {
                aVar.g(3, this.pLt);
            }
            if (this.pLu != null) {
                aVar.g(4, this.pLu);
            }
            aVar.T(5, this.pLv);
            if (this.pLz != null) {
                aVar.g(6, this.pLz);
            }
            if (this.ixy != null) {
                aVar.g(7, this.ixy);
            }
            if (this.ixz != null) {
                aVar.g(8, this.ixz);
            }
            if (this.nzH != null) {
                aVar.g(9, this.nzH);
            }
            if (this.pLw != null) {
                aVar.g(10, this.pLw);
            }
            if (this.pLx != null) {
                aVar.g(11, this.pLx);
            }
            if (this.pLy != null) {
                aVar.g(12, this.pLy);
            }
            if (this.bhd != null) {
                aVar.g(13, this.bhd);
            }
            if (this.lRt != null) {
                aVar.g(14, this.lRt);
            }
            if (this.pLA != null) {
                aVar.g(15, this.pLA);
            }
            if (this.pLB != null) {
                aVar.g(16, this.pLB);
            }
            if (this.pLC == null) {
                return 0;
            }
            aVar.g(17, this.pLC);
            return 0;
        } else if (i == 1) {
            if (this.pLr != null) {
                h = f.a.a.b.b.a.h(1, this.pLr) + 0;
            } else {
                h = 0;
            }
            if (this.pLs != null) {
                h += f.a.a.b.b.a.h(2, this.pLs);
            }
            if (this.pLt != null) {
                h += f.a.a.b.b.a.h(3, this.pLt);
            }
            if (this.pLu != null) {
                h += f.a.a.b.b.a.h(4, this.pLu);
            }
            h += f.a.a.a.S(5, this.pLv);
            if (this.pLz != null) {
                h += f.a.a.b.b.a.h(6, this.pLz);
            }
            if (this.ixy != null) {
                h += f.a.a.b.b.a.h(7, this.ixy);
            }
            if (this.ixz != null) {
                h += f.a.a.b.b.a.h(8, this.ixz);
            }
            if (this.nzH != null) {
                h += f.a.a.b.b.a.h(9, this.nzH);
            }
            if (this.pLw != null) {
                h += f.a.a.b.b.a.h(10, this.pLw);
            }
            if (this.pLx != null) {
                h += f.a.a.b.b.a.h(11, this.pLx);
            }
            if (this.pLy != null) {
                h += f.a.a.b.b.a.h(12, this.pLy);
            }
            if (this.bhd != null) {
                h += f.a.a.b.b.a.h(13, this.bhd);
            }
            if (this.lRt != null) {
                h += f.a.a.b.b.a.h(14, this.lRt);
            }
            if (this.pLA != null) {
                h += f.a.a.b.b.a.h(15, this.pLA);
            }
            if (this.pLB != null) {
                h += f.a.a.b.b.a.h(16, this.pLB);
            }
            if (this.pLC != null) {
                h += f.a.a.b.b.a.h(17, this.pLC);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cfn cfn = (cfn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfn.pLr = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cfn.pLs = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cfn.pLt = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cfn.pLu = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cfn.pLv = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    cfn.pLz = aVar3.vHC.readString();
                    return 0;
                case 7:
                    cfn.ixy = aVar3.vHC.readString();
                    return 0;
                case 8:
                    cfn.ixz = aVar3.vHC.readString();
                    return 0;
                case 9:
                    cfn.nzH = aVar3.vHC.readString();
                    return 0;
                case 10:
                    cfn.pLw = aVar3.vHC.readString();
                    return 0;
                case 11:
                    cfn.pLx = aVar3.vHC.readString();
                    return 0;
                case 12:
                    cfn.pLy = aVar3.vHC.readString();
                    return 0;
                case 13:
                    cfn.bhd = aVar3.vHC.readString();
                    return 0;
                case 14:
                    cfn.lRt = aVar3.vHC.readString();
                    return 0;
                case 15:
                    cfn.pLA = aVar3.vHC.readString();
                    return 0;
                case 16:
                    cfn.pLB = aVar3.vHC.readString();
                    return 0;
                case 17:
                    cfn.pLC = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
