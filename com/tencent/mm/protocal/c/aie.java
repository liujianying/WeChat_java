package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aie extends bhd {
    public String hcS;
    public String iwP;
    public String rKV;
    public String rKW;
    public String rKX;
    public String rKY;
    public String rKZ;
    public int rLa;
    public String reS;
    public bhy rhB;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rhB == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rhB != null) {
                aVar.fV(2, this.rhB.boi());
                this.rhB.a(aVar);
            }
            if (this.rKV != null) {
                aVar.g(3, this.rKV);
            }
            if (this.rKW != null) {
                aVar.g(4, this.rKW);
            }
            if (this.hcS != null) {
                aVar.g(5, this.hcS);
            }
            if (this.rKX != null) {
                aVar.g(6, this.rKX);
            }
            if (this.rKY != null) {
                aVar.g(7, this.rKY);
            }
            if (this.rKZ != null) {
                aVar.g(8, this.rKZ);
            }
            aVar.fT(9, this.rLa);
            if (this.iwP != null) {
                aVar.g(10, this.iwP);
            }
            if (this.reS == null) {
                return 0;
            }
            aVar.g(11, this.reS);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rhB != null) {
                fS += f.a.a.a.fS(2, this.rhB.boi());
            }
            if (this.rKV != null) {
                fS += f.a.a.b.b.a.h(3, this.rKV);
            }
            if (this.rKW != null) {
                fS += f.a.a.b.b.a.h(4, this.rKW);
            }
            if (this.hcS != null) {
                fS += f.a.a.b.b.a.h(5, this.hcS);
            }
            if (this.rKX != null) {
                fS += f.a.a.b.b.a.h(6, this.rKX);
            }
            if (this.rKY != null) {
                fS += f.a.a.b.b.a.h(7, this.rKY);
            }
            if (this.rKZ != null) {
                fS += f.a.a.b.b.a.h(8, this.rKZ);
            }
            fS += f.a.a.a.fQ(9, this.rLa);
            if (this.iwP != null) {
                fS += f.a.a.b.b.a.h(10, this.iwP);
            }
            if (this.reS != null) {
                fS += f.a.a.b.b.a.h(11, this.reS);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rhB != null) {
                return 0;
            }
            throw new b("Not all required fields were included: RandomEncryKey");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aie aie = (aie) objArr[1];
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
                        aie.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        aie.rhB = bhy;
                    }
                    return 0;
                case 3:
                    aie.rKV = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aie.rKW = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aie.hcS = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aie.rKX = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aie.rKY = aVar3.vHC.readString();
                    return 0;
                case 8:
                    aie.rKZ = aVar3.vHC.readString();
                    return 0;
                case 9:
                    aie.rLa = aVar3.vHC.rY();
                    return 0;
                case 10:
                    aie.iwP = aVar3.vHC.readString();
                    return 0;
                case 11:
                    aie.reS = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
