package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aez extends bhd {
    public int otY;
    public String rDH;
    public bhy rIW;
    public int rIX;
    public int rIY;
    public LinkedList<bat> rIZ = new LinkedList();
    public int rJa;
    public int rfe;
    public aqr rva;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rva == null) {
                throw new b("Not all required fields were included: Loc");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rfe);
            aVar.fT(3, this.otY);
            if (this.rIW != null) {
                aVar.fV(4, this.rIW.boi());
                this.rIW.a(aVar);
            }
            if (this.rva != null) {
                aVar.fV(5, this.rva.boi());
                this.rva.a(aVar);
            }
            if (this.rDH != null) {
                aVar.g(6, this.rDH);
            }
            aVar.fT(7, this.rIX);
            aVar.fT(8, this.rIY);
            aVar.d(11, 8, this.rIZ);
            aVar.fT(12, this.rJa);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rfe)) + f.a.a.a.fQ(3, this.otY);
            if (this.rIW != null) {
                fS += f.a.a.a.fS(4, this.rIW.boi());
            }
            if (this.rva != null) {
                fS += f.a.a.a.fS(5, this.rva.boi());
            }
            if (this.rDH != null) {
                fS += f.a.a.b.b.a.h(6, this.rDH);
            }
            return (((fS + f.a.a.a.fQ(7, this.rIX)) + f.a.a.a.fQ(8, this.rIY)) + f.a.a.a.c(11, 8, this.rIZ)) + f.a.a.a.fQ(12, this.rJa);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rIZ.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            aez aez = (aez) objArr[1];
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
                        aez.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aez.rfe = aVar3.vHC.rY();
                    return 0;
                case 3:
                    aez.otY = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        aez.rIW = bhy;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqr aqr = new aqr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqr.a(aVar4, aqr, bhd.a(aVar4))) {
                        }
                        aez.rva = aqr;
                    }
                    return 0;
                case 6:
                    aez.rDH = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aez.rIX = aVar3.vHC.rY();
                    return 0;
                case 8:
                    aez.rIY = aVar3.vHC.rY();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bat bat = new bat();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bat.a(aVar4, bat, bhd.a(aVar4))) {
                        }
                        aez.rIZ.add(bat);
                    }
                    return 0;
                case 12:
                    aez.rJa = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
