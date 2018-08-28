package com.tencent.mm.ar;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class d extends a {
    public int ecA;
    public int ecB;
    public int ecC;
    public String ecD;
    public String ecE;
    public int ecF;
    public int ecG;
    public int ecH;
    public LinkedList<e> ecy = new LinkedList();
    public int ecz;
    public int maxSize;
    public String name;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.ecy);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            aVar.fT(3, this.ecz);
            aVar.fT(4, this.ecA);
            aVar.fT(5, this.ecB);
            aVar.fT(6, this.ecC);
            if (this.ecD != null) {
                aVar.g(7, this.ecD);
            }
            if (this.ecE != null) {
                aVar.g(8, this.ecE);
            }
            aVar.fT(9, this.ecF);
            aVar.fT(10, this.ecG);
            aVar.fT(11, this.ecH);
            aVar.fT(12, this.maxSize);
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.ecy) + 0;
            if (this.name != null) {
                c += f.a.a.b.b.a.h(2, this.name);
            }
            c = (((c + f.a.a.a.fQ(3, this.ecz)) + f.a.a.a.fQ(4, this.ecA)) + f.a.a.a.fQ(5, this.ecB)) + f.a.a.a.fQ(6, this.ecC);
            if (this.ecD != null) {
                c += f.a.a.b.b.a.h(7, this.ecD);
            }
            if (this.ecE != null) {
                c += f.a.a.b.b.a.h(8, this.ecE);
            }
            return (((c + f.a.a.a.fQ(9, this.ecF)) + f.a.a.a.fQ(10, this.ecG)) + f.a.a.a.fQ(11, this.ecH)) + f.a.a.a.fQ(12, this.maxSize);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ecy.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        dVar.ecy.add(eVar);
                    }
                    return 0;
                case 2:
                    dVar.name = aVar3.vHC.readString();
                    return 0;
                case 3:
                    dVar.ecz = aVar3.vHC.rY();
                    return 0;
                case 4:
                    dVar.ecA = aVar3.vHC.rY();
                    return 0;
                case 5:
                    dVar.ecB = aVar3.vHC.rY();
                    return 0;
                case 6:
                    dVar.ecC = aVar3.vHC.rY();
                    return 0;
                case 7:
                    dVar.ecD = aVar3.vHC.readString();
                    return 0;
                case 8:
                    dVar.ecE = aVar3.vHC.readString();
                    return 0;
                case 9:
                    dVar.ecF = aVar3.vHC.rY();
                    return 0;
                case 10:
                    dVar.ecG = aVar3.vHC.rY();
                    return 0;
                case 11:
                    dVar.ecH = aVar3.vHC.rY();
                    return 0;
                case 12:
                    dVar.maxSize = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
