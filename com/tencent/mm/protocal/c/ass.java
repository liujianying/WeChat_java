package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ass extends a {
    public String hbL;
    public sx reZ;
    public bhy rhB;
    public String rhI;
    public String rhU;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rhB == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else if (this.reZ == null) {
                throw new b("Not all required fields were included: CliPubECDHKey");
            } else {
                if (this.rhB != null) {
                    aVar.fV(1, this.rhB.boi());
                    this.rhB.a(aVar);
                }
                if (this.reZ != null) {
                    aVar.fV(2, this.reZ.boi());
                    this.reZ.a(aVar);
                }
                if (this.hbL != null) {
                    aVar.g(3, this.hbL);
                }
                if (this.rhI != null) {
                    aVar.g(4, this.rhI);
                }
                if (this.rhU == null) {
                    return 0;
                }
                aVar.g(5, this.rhU);
                return 0;
            }
        } else if (i == 1) {
            if (this.rhB != null) {
                fS = f.a.a.a.fS(1, this.rhB.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.reZ != null) {
                fS += f.a.a.a.fS(2, this.reZ.boi());
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(3, this.hbL);
            }
            if (this.rhI != null) {
                fS += f.a.a.b.b.a.h(4, this.rhI);
            }
            if (this.rhU != null) {
                fS += f.a.a.b.b.a.h(5, this.rhU);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rhB == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            } else if (this.reZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CliPubECDHKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ass ass = (ass) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            a bhy;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        ass.rhB = bhy;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new sx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        ass.reZ = bhy;
                    }
                    return 0;
                case 3:
                    ass.hbL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ass.rhI = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ass.rhU = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
