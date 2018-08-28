package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class ok extends bhd {
    public int hcE;
    public String rsH;
    public LinkedList<bnb> rsI = new LinkedList();
    public LinkedList<bnd> rsJ = new LinkedList();
    public LinkedList<bna> rsK = new LinkedList();
    public LinkedList<bmz> rsL = new LinkedList();
    public LinkedList<bnc> rsM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.hcE);
            if (this.rsH != null) {
                aVar.g(3, this.rsH);
            }
            aVar.d(4, 8, this.rsI);
            aVar.d(5, 8, this.rsJ);
            aVar.d(6, 8, this.rsK);
            aVar.d(7, 8, this.rsL);
            aVar.d(8, 8, this.rsM);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hcE);
            if (this.rsH != null) {
                fS += f.a.a.b.b.a.h(3, this.rsH);
            }
            return ((((fS + f.a.a.a.c(4, 8, this.rsI)) + f.a.a.a.c(5, 8, this.rsJ)) + f.a.a.a.c(6, 8, this.rsK)) + f.a.a.a.c(7, 8, this.rsL)) + f.a.a.a.c(8, 8, this.rsM);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rsI.clear();
            this.rsJ.clear();
            this.rsK.clear();
            this.rsL.clear();
            this.rsM.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ok okVar = (ok) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        okVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    okVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 3:
                    okVar.rsH = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnb bnb = new bnb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnb.a(aVar4, bnb, bhd.a(aVar4))) {
                        }
                        okVar.rsI.add(bnb);
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnd bnd = new bnd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnd.a(aVar4, bnd, bhd.a(aVar4))) {
                        }
                        okVar.rsJ.add(bnd);
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bna bna = new bna();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bna.a(aVar4, bna, bhd.a(aVar4))) {
                        }
                        okVar.rsK.add(bna);
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bmz bmz = new bmz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmz.a(aVar4, bmz, bhd.a(aVar4))) {
                        }
                        okVar.rsL.add(bmz);
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnc bnc = new bnc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnc.a(aVar4, bnc, bhd.a(aVar4))) {
                        }
                        okVar.rsM.add(bnc);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
