package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class axl extends bhp {
    public int rvX;
    public qa saB;
    public qa saC;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.saB == null) {
                throw new b("Not all required fields were included: SmallContentBuff");
            } else if (this.saC == null) {
                throw new b("Not all required fields were included: BigContentBuff");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.saB != null) {
                    aVar.fV(2, this.saB.boi());
                    this.saB.a(aVar);
                }
                if (this.saC != null) {
                    aVar.fV(3, this.saC.boi());
                    this.saC.a(aVar);
                }
                aVar.fT(4, this.rvX);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.saB != null) {
                fS += f.a.a.a.fS(2, this.saB.boi());
            }
            if (this.saC != null) {
                fS += f.a.a.a.fS(3, this.saC.boi());
            }
            return fS + f.a.a.a.fQ(4, this.rvX);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.saB == null) {
                throw new b("Not all required fields were included: SmallContentBuff");
            } else if (this.saC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BigContentBuff");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            axl axl = (axl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            qa qaVar;
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
                        axl.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qaVar = new qa();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qaVar.a(aVar4, qaVar, bhp.a(aVar4))) {
                        }
                        axl.saB = qaVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qaVar = new qa();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qaVar.a(aVar4, qaVar, bhp.a(aVar4))) {
                        }
                        axl.saC = qaVar;
                    }
                    return 0;
                case 4:
                    axl.rvX = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
