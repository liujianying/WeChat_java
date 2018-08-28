package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class akl extends bhd {
    public String bPS;
    public String rLl;
    public String rMZ;
    public int rNa;
    public int rNb;
    public ayx rNc;
    public int rkb;
    public int type;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.type);
            if (this.bPS != null) {
                aVar.g(3, this.bPS);
            }
            aVar.fT(4, this.rkb);
            if (this.rMZ != null) {
                aVar.g(5, this.rMZ);
            }
            aVar.fT(6, this.rNa);
            aVar.fT(7, this.rNb);
            if (this.rLl != null) {
                aVar.g(8, this.rLl);
            }
            if (this.rNc == null) {
                return 0;
            }
            aVar.fV(10, this.rNc.boi());
            this.rNc.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.type);
            if (this.bPS != null) {
                fS += f.a.a.b.b.a.h(3, this.bPS);
            }
            fS += f.a.a.a.fQ(4, this.rkb);
            if (this.rMZ != null) {
                fS += f.a.a.b.b.a.h(5, this.rMZ);
            }
            fS = (fS + f.a.a.a.fQ(6, this.rNa)) + f.a.a.a.fQ(7, this.rNb);
            if (this.rLl != null) {
                fS += f.a.a.b.b.a.h(8, this.rLl);
            }
            if (this.rNc != null) {
                fS += f.a.a.a.fS(10, this.rNc.boi());
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
            akl akl = (akl) objArr[1];
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
                        akl.shX = fkVar;
                    }
                    return 0;
                case 2:
                    akl.type = aVar3.vHC.rY();
                    return 0;
                case 3:
                    akl.bPS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    akl.rkb = aVar3.vHC.rY();
                    return 0;
                case 5:
                    akl.rMZ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    akl.rNa = aVar3.vHC.rY();
                    return 0;
                case 7:
                    akl.rNb = aVar3.vHC.rY();
                    return 0;
                case 8:
                    akl.rLl = aVar3.vHC.readString();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ayx ayx = new ayx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayx.a(aVar4, ayx, bhd.a(aVar4))) {
                        }
                        akl.rNc = ayx;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
