package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class yf extends bhd {
    public int mEk;
    public String rjL;
    public String rjM;
    public String rjN;
    public String rjO;
    public String rjP;
    public String rjQ;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rjL != null) {
                aVar.g(2, this.rjL);
            }
            if (this.rjM != null) {
                aVar.g(3, this.rjM);
            }
            if (this.rjN != null) {
                aVar.g(4, this.rjN);
            }
            if (this.rjO != null) {
                aVar.g(5, this.rjO);
            }
            if (this.rjP != null) {
                aVar.g(6, this.rjP);
            }
            aVar.fT(7, this.mEk);
            if (this.rjQ == null) {
                return 0;
            }
            aVar.g(8, this.rjQ);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rjL != null) {
                fS += f.a.a.b.b.a.h(2, this.rjL);
            }
            if (this.rjM != null) {
                fS += f.a.a.b.b.a.h(3, this.rjM);
            }
            if (this.rjN != null) {
                fS += f.a.a.b.b.a.h(4, this.rjN);
            }
            if (this.rjO != null) {
                fS += f.a.a.b.b.a.h(5, this.rjO);
            }
            if (this.rjP != null) {
                fS += f.a.a.b.b.a.h(6, this.rjP);
            }
            fS += f.a.a.a.fQ(7, this.mEk);
            if (this.rjQ != null) {
                fS += f.a.a.b.b.a.h(8, this.rjQ);
            }
            return fS;
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
            yf yfVar = (yf) objArr[1];
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
                        yfVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    yfVar.rjL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    yfVar.rjM = aVar3.vHC.readString();
                    return 0;
                case 4:
                    yfVar.rjN = aVar3.vHC.readString();
                    return 0;
                case 5:
                    yfVar.rjO = aVar3.vHC.readString();
                    return 0;
                case 6:
                    yfVar.rjP = aVar3.vHC.readString();
                    return 0;
                case 7:
                    yfVar.mEk = aVar3.vHC.rY();
                    return 0;
                case 8:
                    yfVar.rjQ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
