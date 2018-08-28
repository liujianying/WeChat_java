package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bnx extends a {
    public int lOS;
    public cf rII;
    public String rmM;
    public LinkedList<bbs> slP = new LinkedList();
    public um slQ;
    public LinkedList<bfm> slR = new LinkedList();
    public int slS;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.lOS);
            aVar.d(2, 8, this.slP);
            if (this.slQ != null) {
                aVar.fV(3, this.slQ.boi());
                this.slQ.a(aVar);
            }
            if (this.rII != null) {
                aVar.fV(4, this.rII.boi());
                this.rII.a(aVar);
            }
            aVar.d(5, 8, this.slR);
            aVar.fT(6, this.slS);
            if (this.rmM != null) {
                aVar.g(7, this.rmM);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.lOS) + 0) + f.a.a.a.c(2, 8, this.slP);
            if (this.slQ != null) {
                fQ += f.a.a.a.fS(3, this.slQ.boi());
            }
            if (this.rII != null) {
                fQ += f.a.a.a.fS(4, this.rII.boi());
            }
            fQ = (fQ + f.a.a.a.c(5, 8, this.slR)) + f.a.a.a.fQ(6, this.slS);
            if (this.rmM != null) {
                return fQ + f.a.a.b.b.a.h(7, this.rmM);
            }
            return fQ;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.slP.clear();
            this.slR.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bnx bnx = (bnx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bnx.lOS = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bbs bbs = new bbs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbs.a(aVar4, bbs, a.a(aVar4))) {
                        }
                        bnx.slP.add(bbs);
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        um umVar = new um();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = umVar.a(aVar4, umVar, a.a(aVar4))) {
                        }
                        bnx.slQ = umVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cf cfVar = new cf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfVar.a(aVar4, cfVar, a.a(aVar4))) {
                        }
                        bnx.rII = cfVar;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bfm bfm = new bfm();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfm.a(aVar4, bfm, a.a(aVar4))) {
                        }
                        bnx.slR.add(bfm);
                    }
                    return 0;
                case 6:
                    bnx.slS = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bnx.rmM = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
