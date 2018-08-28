package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class ib extends bhd {
    public int otY;
    public String rem;
    public LinkedList<String> rjg = new LinkedList();
    public String rjh;
    public double rji;
    public double rjj;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rem != null) {
                aVar.g(2, this.rem);
            }
            aVar.d(3, 1, this.rjg);
            aVar.fT(4, this.otY);
            if (this.rjh != null) {
                aVar.g(5, this.rjh);
            }
            aVar.c(6, this.rji);
            aVar.c(7, this.rjj);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rem != null) {
                fS += f.a.a.b.b.a.h(2, this.rem);
            }
            fS = (fS + f.a.a.a.c(3, 1, this.rjg)) + f.a.a.a.fQ(4, this.otY);
            if (this.rjh != null) {
                fS += f.a.a.b.b.a.h(5, this.rjh);
            }
            return (fS + (f.a.a.b.b.a.ec(6) + 8)) + (f.a.a.b.b.a.ec(7) + 8);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rjg.clear();
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
            ib ibVar = (ib) objArr[1];
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
                        ibVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    ibVar.rem = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ibVar.rjg.add(aVar3.vHC.readString());
                    return 0;
                case 4:
                    ibVar.otY = aVar3.vHC.rY();
                    return 0;
                case 5:
                    ibVar.rjh = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ibVar.rji = aVar3.vHC.readDouble();
                    return 0;
                case 7:
                    ibVar.rjj = aVar3.vHC.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
