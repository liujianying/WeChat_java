package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class nm extends bhd {
    public String jPc;
    public String jTB;
    public String jTu;
    public int otY;
    public int rdq;
    public String rrA;
    public int rrx;
    public LinkedList<bhz> rry = new LinkedList();
    public String rrz;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rdq);
            if (this.jTu != null) {
                aVar.g(3, this.jTu);
            }
            if (this.jTB != null) {
                aVar.g(4, this.jTB);
            }
            if (this.jPc != null) {
                aVar.g(5, this.jPc);
            }
            aVar.fT(6, this.rrx);
            aVar.d(7, 8, this.rry);
            if (this.rrz != null) {
                aVar.g(8, this.rrz);
            }
            if (this.rrA != null) {
                aVar.g(9, this.rrA);
            }
            aVar.fT(10, this.otY);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rdq);
            if (this.jTu != null) {
                fS += f.a.a.b.b.a.h(3, this.jTu);
            }
            if (this.jTB != null) {
                fS += f.a.a.b.b.a.h(4, this.jTB);
            }
            if (this.jPc != null) {
                fS += f.a.a.b.b.a.h(5, this.jPc);
            }
            fS = (fS + f.a.a.a.fQ(6, this.rrx)) + f.a.a.a.c(7, 8, this.rry);
            if (this.rrz != null) {
                fS += f.a.a.b.b.a.h(8, this.rrz);
            }
            if (this.rrA != null) {
                fS += f.a.a.b.b.a.h(9, this.rrA);
            }
            return fS + f.a.a.a.fQ(10, this.otY);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rry.clear();
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
            nm nmVar = (nm) objArr[1];
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
                        nmVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    nmVar.rdq = aVar3.vHC.rY();
                    return 0;
                case 3:
                    nmVar.jTu = aVar3.vHC.readString();
                    return 0;
                case 4:
                    nmVar.jTB = aVar3.vHC.readString();
                    return 0;
                case 5:
                    nmVar.jPc = aVar3.vHC.readString();
                    return 0;
                case 6:
                    nmVar.rrx = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        nmVar.rry.add(bhz);
                    }
                    return 0;
                case 8:
                    nmVar.rrz = aVar3.vHC.readString();
                    return 0;
                case 9:
                    nmVar.rrA = aVar3.vHC.readString();
                    return 0;
                case 10:
                    nmVar.otY = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
