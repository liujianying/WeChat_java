package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bkw extends bhd {
    public String bLe;
    public String bPS;
    public String lMV;
    public String reM;
    public LinkedList<Integer> skh = new LinkedList();
    public String ski;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.bPS != null) {
                aVar.g(2, this.bPS);
            }
            aVar.d(3, 2, this.skh);
            if (this.ski != null) {
                aVar.g(4, this.ski);
            }
            if (this.reM != null) {
                aVar.g(5, this.reM);
            }
            if (this.bLe != null) {
                aVar.g(6, this.bLe);
            }
            if (this.lMV == null) {
                return 0;
            }
            aVar.g(7, this.lMV);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.bPS != null) {
                fS += f.a.a.b.b.a.h(2, this.bPS);
            }
            fS += f.a.a.a.c(3, 2, this.skh);
            if (this.ski != null) {
                fS += f.a.a.b.b.a.h(4, this.ski);
            }
            if (this.reM != null) {
                fS += f.a.a.b.b.a.h(5, this.reM);
            }
            if (this.bLe != null) {
                fS += f.a.a.b.b.a.h(6, this.bLe);
            }
            if (this.lMV != null) {
                fS += f.a.a.b.b.a.h(7, this.lMV);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.skh.clear();
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
            bkw bkw = (bkw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bkw.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bkw.bPS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bkw.skh.add(Integer.valueOf(aVar3.vHC.rY()));
                    return 0;
                case 4:
                    bkw.ski = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bkw.reM = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bkw.bLe = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bkw.lMV = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
