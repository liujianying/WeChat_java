package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class blg extends bhd {
    public String jSA;
    public int otY;
    public aqr rva;
    public int sko;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rva == null) {
                throw new b("Not all required fields were included: Loc");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rva != null) {
                aVar.fV(2, this.rva.boi());
                this.rva.a(aVar);
            }
            aVar.fT(3, this.sko);
            aVar.fT(4, this.otY);
            if (this.jSA == null) {
                return 0;
            }
            aVar.g(5, this.jSA);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rva != null) {
                fS += f.a.a.a.fS(2, this.rva.boi());
            }
            fS = (fS + f.a.a.a.fQ(3, this.sko)) + f.a.a.a.fQ(4, this.otY);
            if (this.jSA != null) {
                fS += f.a.a.b.b.a.h(5, this.jSA);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rva != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Loc");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            blg blg = (blg) objArr[1];
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
                        blg.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqr aqr = new aqr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqr.a(aVar4, aqr, bhd.a(aVar4))) {
                        }
                        blg.rva = aqr;
                    }
                    return 0;
                case 3:
                    blg.sko = aVar3.vHC.rY();
                    return 0;
                case 4:
                    blg.otY = aVar3.vHC.rY();
                    return 0;
                case 5:
                    blg.jSA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
