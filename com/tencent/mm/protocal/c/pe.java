package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class pe extends bhd {
    public String rco;
    public String riA;
    public String rtA;
    public LinkedList<pd> rtB = new LinkedList();
    public int rtz;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rtz);
            if (this.rtA != null) {
                aVar.g(3, this.rtA);
            }
            if (this.riA != null) {
                aVar.g(4, this.riA);
            }
            if (this.rco != null) {
                aVar.g(5, this.rco);
            }
            aVar.d(6, 8, this.rtB);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rtz);
            if (this.rtA != null) {
                fS += f.a.a.b.b.a.h(3, this.rtA);
            }
            if (this.riA != null) {
                fS += f.a.a.b.b.a.h(4, this.riA);
            }
            if (this.rco != null) {
                fS += f.a.a.b.b.a.h(5, this.rco);
            }
            return fS + f.a.a.a.c(6, 8, this.rtB);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rtB.clear();
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
            pe peVar = (pe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        peVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    peVar.rtz = aVar3.vHC.rY();
                    return 0;
                case 3:
                    peVar.rtA = aVar3.vHC.readString();
                    return 0;
                case 4:
                    peVar.riA = aVar3.vHC.readString();
                    return 0;
                case 5:
                    peVar.rco = aVar3.vHC.readString();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        pd pdVar = new pd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pdVar.a(aVar4, pdVar, bhd.a(aVar4))) {
                        }
                        peVar.rtB.add(pdVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
