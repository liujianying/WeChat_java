package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bvn extends bhp {
    public String hbL;
    public String jQb;
    public int lOH;
    public int rdV;
    public int rdW;
    public int rdX;
    public String rvP;
    public String ssa;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.jQb != null) {
                aVar.g(2, this.jQb);
            }
            if (this.rvP != null) {
                aVar.g(3, this.rvP);
            }
            if (this.ssa != null) {
                aVar.g(4, this.ssa);
            }
            if (this.hbL != null) {
                aVar.g(5, this.hbL);
            }
            aVar.fT(6, this.rdV);
            aVar.fT(7, this.rdW);
            aVar.fT(8, this.rdX);
            aVar.fT(9, this.lOH);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jQb != null) {
                fS += f.a.a.b.b.a.h(2, this.jQb);
            }
            if (this.rvP != null) {
                fS += f.a.a.b.b.a.h(3, this.rvP);
            }
            if (this.ssa != null) {
                fS += f.a.a.b.b.a.h(4, this.ssa);
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(5, this.hbL);
            }
            return (((fS + f.a.a.a.fQ(6, this.rdV)) + f.a.a.a.fQ(7, this.rdW)) + f.a.a.a.fQ(8, this.rdX)) + f.a.a.a.fQ(9, this.lOH);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bvn bvn = (bvn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bvn.six = flVar;
                    }
                    return 0;
                case 2:
                    bvn.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bvn.rvP = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bvn.ssa = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bvn.hbL = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bvn.rdV = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bvn.rdW = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bvn.rdX = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bvn.lOH = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
