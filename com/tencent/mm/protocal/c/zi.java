package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class zi extends bhp {
    public axj rFo;
    public int rFp;
    public String rit;
    public String riu;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rFo == null) {
                throw new b("Not all required fields were included: AppInfo");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rFo != null) {
                    aVar.fV(2, this.rFo.boi());
                    this.rFo.a(aVar);
                }
                aVar.fT(3, this.rFp);
                if (this.riu != null) {
                    aVar.g(4, this.riu);
                }
                if (this.rit == null) {
                    return 0;
                }
                aVar.g(5, this.rit);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rFo != null) {
                fS += f.a.a.a.fS(2, this.rFo.boi());
            }
            fS += f.a.a.a.fQ(3, this.rFp);
            if (this.riu != null) {
                fS += f.a.a.b.b.a.h(4, this.riu);
            }
            if (this.rit != null) {
                fS += f.a.a.b.b.a.h(5, this.rit);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rFo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            zi ziVar = (zi) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        ziVar.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        axj axj = new axj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axj.a(aVar4, axj, bhp.a(aVar4))) {
                        }
                        ziVar.rFo = axj;
                    }
                    return 0;
                case 3:
                    ziVar.rFp = aVar3.vHC.rY();
                    return 0;
                case 4:
                    ziVar.riu = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ziVar.rit = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}