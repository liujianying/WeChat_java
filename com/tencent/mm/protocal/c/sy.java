package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class sy extends bhd {
    public String iwP;
    public String reS;
    public int rfe;
    public bhy rhB;
    public String rhI;
    public String rhg;
    public String rwg;
    public String rwh;
    public int rwi;

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
            aVar.fT(3, this.rfe);
            if (this.rhg != null) {
                aVar.g(4, this.rhg);
            }
            if (this.iwP != null) {
                aVar.g(5, this.iwP);
            }
            if (this.rhI != null) {
                aVar.g(6, this.rhI);
            }
            if (this.rwg != null) {
                aVar.g(7, this.rwg);
            }
            if (this.reS != null) {
                aVar.g(8, this.reS);
            }
            if (this.rwh != null) {
                aVar.g(9, this.rwh);
            }
            aVar.fT(10, this.rwi);
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
            fS += f.a.a.a.fQ(3, this.rfe);
            if (this.rhg != null) {
                fS += f.a.a.b.b.a.h(4, this.rhg);
            }
            if (this.iwP != null) {
                fS += f.a.a.b.b.a.h(5, this.iwP);
            }
            if (this.rhI != null) {
                fS += f.a.a.b.b.a.h(6, this.rhI);
            }
            if (this.rwg != null) {
                fS += f.a.a.b.b.a.h(7, this.rwg);
            }
            if (this.reS != null) {
                fS += f.a.a.b.b.a.h(8, this.reS);
            }
            if (this.rwh != null) {
                fS += f.a.a.b.b.a.h(9, this.rwh);
            }
            return fS + f.a.a.a.fQ(10, this.rwi);
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
            sy syVar = (sy) objArr[1];
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
                        syVar.shX = fkVar;
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
                        syVar.rhB = bhy;
                    }
                    return 0;
                case 3:
                    syVar.rfe = aVar3.vHC.rY();
                    return 0;
                case 4:
                    syVar.rhg = aVar3.vHC.readString();
                    return 0;
                case 5:
                    syVar.iwP = aVar3.vHC.readString();
                    return 0;
                case 6:
                    syVar.rhI = aVar3.vHC.readString();
                    return 0;
                case 7:
                    syVar.rwg = aVar3.vHC.readString();
                    return 0;
                case 8:
                    syVar.reS = aVar3.vHC.readString();
                    return 0;
                case 9:
                    syVar.rwh = aVar3.vHC.readString();
                    return 0;
                case 10:
                    syVar.rwi = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
