package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bhe extends bhd {
    public String lMV;
    public String muA;
    public String muB;
    public int mun;
    public String ref;
    public int shY;
    public String shZ;
    public int sia;
    public int sib;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.muA != null) {
                aVar.g(2, this.muA);
            }
            if (this.muB != null) {
                aVar.g(3, this.muB);
            }
            if (this.lMV != null) {
                aVar.g(4, this.lMV);
            }
            aVar.fT(5, this.mun);
            aVar.fT(6, this.shY);
            if (this.shZ != null) {
                aVar.g(7, this.shZ);
            }
            aVar.fT(8, this.sia);
            aVar.fT(9, this.sib);
            if (this.ref == null) {
                return 0;
            }
            aVar.g(10, this.ref);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.muA != null) {
                fS += f.a.a.b.b.a.h(2, this.muA);
            }
            if (this.muB != null) {
                fS += f.a.a.b.b.a.h(3, this.muB);
            }
            if (this.lMV != null) {
                fS += f.a.a.b.b.a.h(4, this.lMV);
            }
            fS = (fS + f.a.a.a.fQ(5, this.mun)) + f.a.a.a.fQ(6, this.shY);
            if (this.shZ != null) {
                fS += f.a.a.b.b.a.h(7, this.shZ);
            }
            fS = (fS + f.a.a.a.fQ(8, this.sia)) + f.a.a.a.fQ(9, this.sib);
            if (this.ref != null) {
                fS += f.a.a.b.b.a.h(10, this.ref);
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
            bhe bhe = (bhe) objArr[1];
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
                        bhe.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bhe.muA = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bhe.muB = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bhe.lMV = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bhe.mun = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bhe.shY = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bhe.shZ = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bhe.sia = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bhe.sib = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bhe.ref = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
