package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class avy extends bhp {
    public int qZH;
    public bhy rYQ;
    public bhy rYR;
    public int rYS;
    public int rYT;
    public LinkedList<pm> rYU = new LinkedList();
    public int rlm;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rYQ == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.rYR == null) {
                throw new b("Not all required fields were included: MaxSynckey");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rYQ != null) {
                    aVar.fV(2, this.rYQ.boi());
                    this.rYQ.a(aVar);
                }
                if (this.rYR != null) {
                    aVar.fV(3, this.rYR.boi());
                    this.rYR.a(aVar);
                }
                aVar.fT(4, this.rlm);
                aVar.fT(5, this.rYS);
                aVar.fT(6, this.rYT);
                aVar.d(7, 8, this.rYU);
                aVar.fT(8, this.qZH);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rYQ != null) {
                fS += f.a.a.a.fS(2, this.rYQ.boi());
            }
            if (this.rYR != null) {
                fS += f.a.a.a.fS(3, this.rYR.boi());
            }
            return ((((fS + f.a.a.a.fQ(4, this.rlm)) + f.a.a.a.fQ(5, this.rYS)) + f.a.a.a.fQ(6, this.rYT)) + f.a.a.a.c(7, 8, this.rYU)) + f.a.a.a.fQ(8, this.qZH);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rYU.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rYQ == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.rYR != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MaxSynckey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            avy avy = (avy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bhy bhy;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        avy.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        avy.rYQ = bhy;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        avy.rYR = bhy;
                    }
                    return 0;
                case 4:
                    avy.rlm = aVar3.vHC.rY();
                    return 0;
                case 5:
                    avy.rYS = aVar3.vHC.rY();
                    return 0;
                case 6:
                    avy.rYT = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        pm pmVar = new pm();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pmVar.a(aVar4, pmVar, bhp.a(aVar4))) {
                        }
                        avy.rYU.add(pmVar);
                    }
                    return 0;
                case 8:
                    avy.qZH = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
