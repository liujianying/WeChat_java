package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class cax extends bhp {
    public int rlm;
    public bhy rny;
    public int rxG;
    public long rxH;
    public bzu sxi;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rny == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.sxi == null) {
                throw new b("Not all required fields were included: CmdList");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.fT(3, this.rxG);
                if (this.rny != null) {
                    aVar.fV(4, this.rny.boi());
                    this.rny.a(aVar);
                }
                if (this.sxi != null) {
                    aVar.fV(5, this.sxi.boi());
                    this.sxi.a(aVar);
                }
                aVar.fT(7, this.rlm);
                aVar.T(8, this.rxH);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(3, this.rxG);
            if (this.rny != null) {
                fS += f.a.a.a.fS(4, this.rny.boi());
            }
            if (this.sxi != null) {
                fS += f.a.a.a.fS(5, this.sxi.boi());
            }
            return (fS + f.a.a.a.fQ(7, this.rlm)) + f.a.a.a.S(8, this.rxH);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rny == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.sxi != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CmdList");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cax cax = (cax) objArr[1];
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
                        cax.six = flVar;
                    }
                    return 0;
                case 3:
                    cax.rxG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        cax.rny = bhy;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bzu bzu = new bzu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzu.a(aVar4, bzu, bhp.a(aVar4))) {
                        }
                        cax.sxi = bzu;
                    }
                    return 0;
                case 7:
                    cax.rlm = aVar3.vHC.rY();
                    return 0;
                case 8:
                    cax.rxH = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
