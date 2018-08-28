package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class arg extends bhd {
    public LinkedList<bhz> rTA = new LinkedList();
    public int rTB;
    public LinkedList<bhz> rTC = new LinkedList();
    public int rTz;
    public String rwj;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rwj != null) {
                aVar.g(2, this.rwj);
            }
            aVar.fT(3, this.rTz);
            aVar.d(4, 8, this.rTA);
            aVar.fT(5, this.rTB);
            aVar.d(6, 8, this.rTC);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rwj != null) {
                fS += f.a.a.b.b.a.h(2, this.rwj);
            }
            return (((fS + f.a.a.a.fQ(3, this.rTz)) + f.a.a.a.c(4, 8, this.rTA)) + f.a.a.a.fQ(5, this.rTB)) + f.a.a.a.c(6, 8, this.rTC);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rTA.clear();
            this.rTC.clear();
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
            arg arg = (arg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bhz bhz;
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
                        arg.shX = fkVar;
                    }
                    return 0;
                case 2:
                    arg.rwj = aVar3.vHC.readString();
                    return 0;
                case 3:
                    arg.rTz = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        arg.rTA.add(bhz);
                    }
                    return 0;
                case 5:
                    arg.rTB = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        arg.rTC.add(bhz);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
