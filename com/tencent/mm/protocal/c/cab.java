package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class cab extends bhd {
    public int rxG;
    public long rxH;
    public int rxy;
    public long suO;
    public int svU;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rxG);
            aVar.T(3, this.rxH);
            aVar.fT(4, this.rxy);
            aVar.T(5, this.suO);
            aVar.fT(6, this.svU);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            return ((((fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.fQ(4, this.rxy)) + f.a.a.a.S(5, this.suO)) + f.a.a.a.fQ(6, this.svU);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            cab cab = (cab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        cab.shX = fkVar;
                    }
                    return 0;
                case 2:
                    cab.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cab.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    cab.rxy = aVar3.vHC.rY();
                    return 0;
                case 5:
                    cab.suO = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    cab.svU = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
