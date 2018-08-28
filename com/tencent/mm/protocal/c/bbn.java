package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bbn extends bhp {
    public int rIK;
    public String rmM;
    public int rmN;
    public String rmO;
    public LinkedList<um> sdH = new LinkedList();
    public LinkedList<au> sdI = new LinkedList();
    public int sdJ;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.rIK);
            aVar.d(3, 8, this.sdH);
            if (this.rmM != null) {
                aVar.g(4, this.rmM);
            }
            aVar.fT(5, this.rmN);
            if (this.rmO != null) {
                aVar.g(6, this.rmO);
            }
            aVar.d(7, 8, this.sdI);
            aVar.fT(8, this.sdJ);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rIK)) + f.a.a.a.c(3, 8, this.sdH);
            if (this.rmM != null) {
                fS += f.a.a.b.b.a.h(4, this.rmM);
            }
            fS += f.a.a.a.fQ(5, this.rmN);
            if (this.rmO != null) {
                fS += f.a.a.b.b.a.h(6, this.rmO);
            }
            return (fS + f.a.a.a.c(7, 8, this.sdI)) + f.a.a.a.fQ(8, this.sdJ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sdH.clear();
            this.sdI.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bbn bbn = (bbn) objArr[1];
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
                        bbn.six = flVar;
                    }
                    return 0;
                case 2:
                    bbn.rIK = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        um umVar = new um();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = umVar.a(aVar4, umVar, bhp.a(aVar4))) {
                        }
                        bbn.sdH.add(umVar);
                    }
                    return 0;
                case 4:
                    bbn.rmM = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bbn.rmN = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bbn.rmO = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        au auVar = new au();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = auVar.a(aVar4, auVar, bhp.a(aVar4))) {
                        }
                        bbn.sdI.add(auVar);
                    }
                    return 0;
                case 8:
                    bbn.sdJ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
