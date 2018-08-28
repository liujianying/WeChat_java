package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ja extends bhd {
    public String myl;
    public String rcD;
    public String rcE;
    public String rcF;
    public int rcI;
    public b rkr;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rcD != null) {
                aVar.g(2, this.rcD);
            }
            if (this.rcE != null) {
                aVar.g(3, this.rcE);
            }
            if (this.myl != null) {
                aVar.g(4, this.myl);
            }
            aVar.fT(5, this.rcI);
            if (this.rkr != null) {
                aVar.b(6, this.rkr);
            }
            if (this.rcF == null) {
                return 0;
            }
            aVar.g(7, this.rcF);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rcD != null) {
                fS += f.a.a.b.b.a.h(2, this.rcD);
            }
            if (this.rcE != null) {
                fS += f.a.a.b.b.a.h(3, this.rcE);
            }
            if (this.myl != null) {
                fS += f.a.a.b.b.a.h(4, this.myl);
            }
            fS += f.a.a.a.fQ(5, this.rcI);
            if (this.rkr != null) {
                fS += f.a.a.a.a(6, this.rkr);
            }
            if (this.rcF != null) {
                fS += f.a.a.b.b.a.h(7, this.rcF);
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
            ja jaVar = (ja) objArr[1];
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
                        jaVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    jaVar.rcD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    jaVar.rcE = aVar3.vHC.readString();
                    return 0;
                case 4:
                    jaVar.myl = aVar3.vHC.readString();
                    return 0;
                case 5:
                    jaVar.rcI = aVar3.vHC.rY();
                    return 0;
                case 6:
                    jaVar.rkr = aVar3.cJR();
                    return 0;
                case 7:
                    jaVar.rcF = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
