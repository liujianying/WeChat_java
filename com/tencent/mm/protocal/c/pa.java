package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class pa extends a {
    public int hcJ;
    public int iwE;
    public LinkedList<apv> jQF = new LinkedList();
    public int rgt;
    public String rjL;
    public String rjM;
    public String rjN;
    public String rjO;
    public String rjP;
    public int rth;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.iwE);
            if (this.rjN != null) {
                aVar.g(7, this.rjN);
            }
            aVar.fT(2, this.rgt);
            aVar.fT(3, this.rth);
            aVar.d(4, 8, this.jQF);
            if (this.rjL != null) {
                aVar.g(5, this.rjL);
            }
            if (this.rjM != null) {
                aVar.g(6, this.rjM);
            }
            if (this.rjO != null) {
                aVar.g(8, this.rjO);
            }
            if (this.rjP != null) {
                aVar.g(9, this.rjP);
            }
            aVar.fT(10, this.hcJ);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.iwE) + 0;
            if (this.rjN != null) {
                fQ += f.a.a.b.b.a.h(7, this.rjN);
            }
            fQ = ((fQ + f.a.a.a.fQ(2, this.rgt)) + f.a.a.a.fQ(3, this.rth)) + f.a.a.a.c(4, 8, this.jQF);
            if (this.rjL != null) {
                fQ += f.a.a.b.b.a.h(5, this.rjL);
            }
            if (this.rjM != null) {
                fQ += f.a.a.b.b.a.h(6, this.rjM);
            }
            if (this.rjO != null) {
                fQ += f.a.a.b.b.a.h(8, this.rjO);
            }
            if (this.rjP != null) {
                fQ += f.a.a.b.b.a.h(9, this.rjP);
            }
            return fQ + f.a.a.a.fQ(10, this.hcJ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jQF.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            pa paVar = (pa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    paVar.iwE = aVar3.vHC.rY();
                    return 0;
                case 2:
                    paVar.rgt = aVar3.vHC.rY();
                    return 0;
                case 3:
                    paVar.rth = aVar3.vHC.rY();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        apv apv = new apv();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = apv.a(aVar4, apv, a.a(aVar4))) {
                        }
                        paVar.jQF.add(apv);
                    }
                    return 0;
                case 5:
                    paVar.rjL = aVar3.vHC.readString();
                    return 0;
                case 6:
                    paVar.rjM = aVar3.vHC.readString();
                    return 0;
                case 7:
                    paVar.rjN = aVar3.vHC.readString();
                    return 0;
                case 8:
                    paVar.rjO = aVar3.vHC.readString();
                    return 0;
                case 9:
                    paVar.rjP = aVar3.vHC.readString();
                    return 0;
                case 10:
                    paVar.hcJ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
