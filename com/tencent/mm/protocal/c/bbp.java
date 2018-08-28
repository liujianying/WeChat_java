package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bbp extends bhd {
    public String jTB;
    public int lOM;
    public String rem;
    public String sdK;
    public String sdL;
    public int sdM;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rem != null) {
                aVar.g(2, this.rem);
            }
            if (this.sdK != null) {
                aVar.g(3, this.sdK);
            }
            if (this.sdL != null) {
                aVar.g(4, this.sdL);
            }
            aVar.fT(5, this.lOM);
            if (this.jTB != null) {
                aVar.g(7, this.jTB);
            }
            aVar.fT(8, this.sdM);
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
            if (this.sdK != null) {
                fS += f.a.a.b.b.a.h(3, this.sdK);
            }
            if (this.sdL != null) {
                fS += f.a.a.b.b.a.h(4, this.sdL);
            }
            fS += f.a.a.a.fQ(5, this.lOM);
            if (this.jTB != null) {
                fS += f.a.a.b.b.a.h(7, this.jTB);
            }
            return fS + f.a.a.a.fQ(8, this.sdM);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bbp bbp = (bbp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        bbp.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bbp.rem = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bbp.sdK = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bbp.sdL = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bbp.lOM = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bbp.jTB = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bbp.sdM = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
