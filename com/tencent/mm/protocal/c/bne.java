package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bne extends bhd {
    public int hbF;
    public int otY;
    public LinkedList<Integer> rgy = new LinkedList();
    public String slg;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.slg != null) {
                aVar.g(2, this.slg);
            }
            aVar.fT(3, this.otY);
            aVar.fT(4, this.hbF);
            aVar.c(5, this.rgy);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.slg != null) {
                fS += f.a.a.b.b.a.h(2, this.slg);
            }
            return ((fS + f.a.a.a.fQ(3, this.otY)) + f.a.a.a.fQ(4, this.hbF)) + f.a.a.a.b(5, this.rgy);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rgy.clear();
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
            bne bne = (bne) objArr[1];
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
                        bne.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bne.slg = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bne.otY = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bne.hbF = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bne.rgy = new f.a.a.a.a(aVar3.cJR().lR, unknownTagHandler).cJO();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
