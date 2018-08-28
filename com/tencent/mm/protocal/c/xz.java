package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class xz extends bhd {
    public String eJQ;
    public String jRj;
    public LinkedList<String> rDI = new LinkedList();
    public LinkedList<String> rDP = new LinkedList();
    public int rDQ;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.d(2, 1, this.rDP);
            aVar.d(3, 1, this.rDI);
            if (this.jRj != null) {
                aVar.g(4, this.jRj);
            }
            if (this.eJQ != null) {
                aVar.g(5, this.eJQ);
            }
            aVar.fT(6, this.rDQ);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.c(2, 1, this.rDP)) + f.a.a.a.c(3, 1, this.rDI);
            if (this.jRj != null) {
                fS += f.a.a.b.b.a.h(4, this.jRj);
            }
            if (this.eJQ != null) {
                fS += f.a.a.b.b.a.h(5, this.eJQ);
            }
            return fS + f.a.a.a.fQ(6, this.rDQ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rDP.clear();
            this.rDI.clear();
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
            xz xzVar = (xz) objArr[1];
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
                        xzVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    xzVar.rDP.add(aVar3.vHC.readString());
                    return 0;
                case 3:
                    xzVar.rDI.add(aVar3.vHC.readString());
                    return 0;
                case 4:
                    xzVar.jRj = aVar3.vHC.readString();
                    return 0;
                case 5:
                    xzVar.eJQ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    xzVar.rDQ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
