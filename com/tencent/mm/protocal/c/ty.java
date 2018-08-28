package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ty extends bhd {
    public int rdq;
    public String riA;
    public b rvr;
    public b rxL;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.riA != null) {
                aVar.g(2, this.riA);
            }
            aVar.fT(3, this.rdq);
            if (this.rxL != null) {
                aVar.b(4, this.rxL);
            }
            if (this.rvr == null) {
                return 0;
            }
            aVar.b(5, this.rvr);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.riA != null) {
                fS += f.a.a.b.b.a.h(2, this.riA);
            }
            fS += f.a.a.a.fQ(3, this.rdq);
            if (this.rxL != null) {
                fS += f.a.a.a.a(4, this.rxL);
            }
            if (this.rvr != null) {
                fS += f.a.a.a.a(5, this.rvr);
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
            ty tyVar = (ty) objArr[1];
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
                        tyVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    tyVar.riA = aVar3.vHC.readString();
                    return 0;
                case 3:
                    tyVar.rdq = aVar3.vHC.rY();
                    return 0;
                case 4:
                    tyVar.rxL = aVar3.cJR();
                    return 0;
                case 5:
                    tyVar.rvr = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
