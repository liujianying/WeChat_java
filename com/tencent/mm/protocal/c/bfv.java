package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bfv extends bhp {
    public int hbF;
    public int rSw;
    public String rmO;
    public LinkedList<bxg> sgY = new LinkedList();
    public btp sgZ;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.hbF);
            aVar.d(3, 8, this.sgY);
            if (this.rmO != null) {
                aVar.g(4, this.rmO);
            }
            aVar.fT(5, this.rSw);
            if (this.sgZ == null) {
                return 0;
            }
            aVar.fV(6, this.sgZ.boi());
            this.sgZ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.hbF)) + f.a.a.a.c(3, 8, this.sgY);
            if (this.rmO != null) {
                fS += f.a.a.b.b.a.h(4, this.rmO);
            }
            fS += f.a.a.a.fQ(5, this.rSw);
            if (this.sgZ != null) {
                fS += f.a.a.a.fS(6, this.sgZ.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sgY.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            bfv bfv = (bfv) objArr[1];
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
                        bfv.six = flVar;
                    }
                    return 0;
                case 2:
                    bfv.hbF = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bxg bxg = new bxg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxg.a(aVar4, bxg, bhp.a(aVar4))) {
                        }
                        bfv.sgY.add(bxg);
                    }
                    return 0;
                case 4:
                    bfv.rmO = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bfv.rSw = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        btp btp = new btp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btp.a(aVar4, btp, bhp.a(aVar4))) {
                        }
                        bfv.sgZ = btp;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
