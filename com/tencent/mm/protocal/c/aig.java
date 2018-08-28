package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aig extends bhd {
    public int jPr;
    public LinkedList<bhz> jRK = new LinkedList();
    public String jRj;
    public int jSa;
    public int jSb;
    public int rLd;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.jPr);
            aVar.fT(3, this.jSa);
            aVar.fT(4, this.jSb);
            if (this.jRj != null) {
                aVar.g(5, this.jRj);
            }
            aVar.fT(6, this.rLd);
            aVar.d(7, 8, this.jRK);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((fS + f.a.a.a.fQ(2, this.jPr)) + f.a.a.a.fQ(3, this.jSa)) + f.a.a.a.fQ(4, this.jSb);
            if (this.jRj != null) {
                fS += f.a.a.b.b.a.h(5, this.jRj);
            }
            return (fS + f.a.a.a.fQ(6, this.rLd)) + f.a.a.a.c(7, 8, this.jRK);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jRK.clear();
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
            aig aig = (aig) objArr[1];
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
                        aig.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aig.jPr = aVar3.vHC.rY();
                    return 0;
                case 3:
                    aig.jSa = aVar3.vHC.rY();
                    return 0;
                case 4:
                    aig.jSb = aVar3.vHC.rY();
                    return 0;
                case 5:
                    aig.jRj = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aig.rLd = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        aig.jRK.add(bhz);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
