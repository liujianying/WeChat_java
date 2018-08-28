package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class qn extends bhd {
    public int hLg;
    public int otY;
    public LinkedList<ati> rbQ = new LinkedList();
    public bhz ruR;
    public bhy ruS;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ruR == null) {
                throw new b("Not all required fields were included: Topic");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.ruR != null) {
                aVar.fV(2, this.ruR.boi());
                this.ruR.a(aVar);
            }
            aVar.fT(3, this.hLg);
            aVar.d(4, 8, this.rbQ);
            aVar.fT(5, this.otY);
            if (this.ruS == null) {
                return 0;
            }
            aVar.fV(6, this.ruS.boi());
            this.ruS.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ruR != null) {
                fS += f.a.a.a.fS(2, this.ruR.boi());
            }
            fS = ((fS + f.a.a.a.fQ(3, this.hLg)) + f.a.a.a.c(4, 8, this.rbQ)) + f.a.a.a.fQ(5, this.otY);
            if (this.ruS != null) {
                fS += f.a.a.a.fS(6, this.ruS.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rbQ.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ruR != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Topic");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            qn qnVar = (qn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            com.tencent.mm.bk.a fkVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qnVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qnVar.ruR = fkVar;
                    }
                    return 0;
                case 3:
                    qnVar.hLg = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ati ati = new ati();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ati.a(aVar4, ati, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qnVar.rbQ.add(ati);
                    }
                    return 0;
                case 5:
                    qnVar.otY = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qnVar.ruS = fkVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
