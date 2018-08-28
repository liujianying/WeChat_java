package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ach extends bhp {
    public String ID;
    public long hbZ;
    public int hcE;
    public int otY;
    public String rGT;
    public bhy reV;
    public int rfh;
    public LinkedList<pw> rfi = new LinkedList();
    public String rfj;
    public String rfk;
    public String rfl;
    public int rfq;
    public String rfr;
    public String rfs;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.reV == null) {
                throw new b("Not all required fields were included: Key");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.ID != null) {
                    aVar.g(2, this.ID);
                }
                if (this.reV != null) {
                    aVar.fV(3, this.reV.boi());
                    this.reV.a(aVar);
                }
                if (this.rfr != null) {
                    aVar.g(4, this.rfr);
                }
                if (this.rfs != null) {
                    aVar.g(5, this.rfs);
                }
                aVar.fT(6, this.hcE);
                aVar.fT(7, this.rfh);
                aVar.d(8, 8, this.rfi);
                if (this.rGT != null) {
                    aVar.g(9, this.rGT);
                }
                if (this.rfj != null) {
                    aVar.g(10, this.rfj);
                }
                if (this.rfk != null) {
                    aVar.g(11, this.rfk);
                }
                aVar.fT(12, this.rfq);
                aVar.fT(13, this.otY);
                aVar.T(14, this.hbZ);
                if (this.rfl == null) {
                    return 0;
                }
                aVar.g(15, this.rfl);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ID != null) {
                fS += f.a.a.b.b.a.h(2, this.ID);
            }
            if (this.reV != null) {
                fS += f.a.a.a.fS(3, this.reV.boi());
            }
            if (this.rfr != null) {
                fS += f.a.a.b.b.a.h(4, this.rfr);
            }
            if (this.rfs != null) {
                fS += f.a.a.b.b.a.h(5, this.rfs);
            }
            fS = ((fS + f.a.a.a.fQ(6, this.hcE)) + f.a.a.a.fQ(7, this.rfh)) + f.a.a.a.c(8, 8, this.rfi);
            if (this.rGT != null) {
                fS += f.a.a.b.b.a.h(9, this.rGT);
            }
            if (this.rfj != null) {
                fS += f.a.a.b.b.a.h(10, this.rfj);
            }
            if (this.rfk != null) {
                fS += f.a.a.b.b.a.h(11, this.rfk);
            }
            fS = ((fS + f.a.a.a.fQ(12, this.rfq)) + f.a.a.a.fQ(13, this.otY)) + f.a.a.a.S(14, this.hbZ);
            if (this.rfl != null) {
                fS += f.a.a.b.b.a.h(15, this.rfl);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rfi.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.reV != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Key");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ach ach = (ach) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        ach.six = flVar;
                    }
                    return 0;
                case 2:
                    ach.ID = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        ach.reV = bhy;
                    }
                    return 0;
                case 4:
                    ach.rfr = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ach.rfs = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ach.hcE = aVar3.vHC.rY();
                    return 0;
                case 7:
                    ach.rfh = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        pw pwVar = new pw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pwVar.a(aVar4, pwVar, bhp.a(aVar4))) {
                        }
                        ach.rfi.add(pwVar);
                    }
                    return 0;
                case 9:
                    ach.rGT = aVar3.vHC.readString();
                    return 0;
                case 10:
                    ach.rfj = aVar3.vHC.readString();
                    return 0;
                case 11:
                    ach.rfk = aVar3.vHC.readString();
                    return 0;
                case 12:
                    ach.rfq = aVar3.vHC.rY();
                    return 0;
                case 13:
                    ach.otY = aVar3.vHC.rY();
                    return 0;
                case 14:
                    ach.hbZ = aVar3.vHC.rZ();
                    return 0;
                case 15:
                    ach.rfl = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
