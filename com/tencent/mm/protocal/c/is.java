package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class is extends bhd {
    public int qZe;
    public String qZf;
    public String riA;
    public ark rjW;
    public bij rjX;

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
            if (this.rjW != null) {
                aVar.fV(3, this.rjW.boi());
                this.rjW.a(aVar);
            }
            if (this.rjX != null) {
                aVar.fV(4, this.rjX.boi());
                this.rjX.a(aVar);
            }
            aVar.fT(5, this.qZe);
            if (this.qZf == null) {
                return 0;
            }
            aVar.g(6, this.qZf);
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
            if (this.rjW != null) {
                fS += f.a.a.a.fS(3, this.rjW.boi());
            }
            if (this.rjX != null) {
                fS += f.a.a.a.fS(4, this.rjX.boi());
            }
            fS += f.a.a.a.fQ(5, this.qZe);
            if (this.qZf != null) {
                fS += f.a.a.b.b.a.h(6, this.qZf);
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
            is isVar = (is) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
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
                        isVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    isVar.riA = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ark ark = new ark();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ark.a(aVar4, ark, bhd.a(aVar4))) {
                        }
                        isVar.rjW = ark;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bij bij = new bij();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bij.a(aVar4, bij, bhd.a(aVar4))) {
                        }
                        isVar.rjX = bij;
                    }
                    return 0;
                case 5:
                    isVar.qZe = aVar3.vHC.rY();
                    return 0;
                case 6:
                    isVar.qZf = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
