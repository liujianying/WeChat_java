package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ama extends bhp {
    public bhy rOI;
    public bhy rOJ;
    public int rOK;
    public int rOL;
    public int rOM;
    public bhy rer;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rer == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.rOI == null) {
                throw new b("Not all required fields were included: SessionBuffer");
            } else if (this.rOJ == null) {
                throw new b("Not all required fields were included: KeyBuffer");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rer != null) {
                    aVar.fV(2, this.rer.boi());
                    this.rer.a(aVar);
                }
                if (this.rOI != null) {
                    aVar.fV(3, this.rOI.boi());
                    this.rOI.a(aVar);
                }
                if (this.rOJ != null) {
                    aVar.fV(4, this.rOJ.boi());
                    this.rOJ.a(aVar);
                }
                aVar.fT(5, this.rOK);
                aVar.fT(6, this.rOL);
                aVar.fT(7, this.rOM);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rer != null) {
                fS += f.a.a.a.fS(2, this.rer.boi());
            }
            if (this.rOI != null) {
                fS += f.a.a.a.fS(3, this.rOI.boi());
            }
            if (this.rOJ != null) {
                fS += f.a.a.a.fS(4, this.rOJ.boi());
            }
            return ((fS + f.a.a.a.fQ(5, this.rOK)) + f.a.a.a.fQ(6, this.rOL)) + f.a.a.a.fQ(7, this.rOM);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rer == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.rOI == null) {
                throw new b("Not all required fields were included: SessionBuffer");
            } else if (this.rOJ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuffer");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ama ama = (ama) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
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
                        ama.six = flVar;
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
                        ama.rer = bhy;
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
                        ama.rOI = bhy;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        ama.rOJ = bhy;
                    }
                    return 0;
                case 5:
                    ama.rOK = aVar3.vHC.rY();
                    return 0;
                case 6:
                    ama.rOL = aVar3.vHC.rY();
                    return 0;
                case 7:
                    ama.rOM = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
