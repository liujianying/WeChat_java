package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ox extends bhp {
    public int hcd;
    public byt rtb;
    public bws rtc;
    public bea rtd;
    public int rte;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rtb == null) {
                throw new b("Not all required fields were included: TransRes");
            } else if (this.rtc == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.rtd == null) {
                throw new b("Not all required fields were included: QueryCtx");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.fT(2, this.hcd);
                if (this.rtb != null) {
                    aVar.fV(3, this.rtb.boi());
                    this.rtb.a(aVar);
                }
                if (this.rtc != null) {
                    aVar.fV(4, this.rtc.boi());
                    this.rtc.a(aVar);
                }
                if (this.rtd != null) {
                    aVar.fV(5, this.rtd.boi());
                    this.rtd.a(aVar);
                }
                aVar.fT(6, this.rte);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hcd);
            if (this.rtb != null) {
                fS += f.a.a.a.fS(3, this.rtb.boi());
            }
            if (this.rtc != null) {
                fS += f.a.a.a.fS(4, this.rtc.boi());
            }
            if (this.rtd != null) {
                fS += f.a.a.a.fS(5, this.rtd.boi());
            }
            return fS + f.a.a.a.fQ(6, this.rte);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rtb == null) {
                throw new b("Not all required fields were included: TransRes");
            } else if (this.rtc == null) {
                throw new b("Not all required fields were included: UploadCtx");
            } else if (this.rtd != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: QueryCtx");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ox oxVar = (ox) objArr[1];
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
                        oxVar.six = flVar;
                    }
                    return 0;
                case 2:
                    oxVar.hcd = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byt byt = new byt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byt.a(aVar4, byt, bhp.a(aVar4))) {
                        }
                        oxVar.rtb = byt;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bws bws = new bws();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bws.a(aVar4, bws, bhp.a(aVar4))) {
                        }
                        oxVar.rtc = bws;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bea bea = new bea();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bea.a(aVar4, bea, bhp.a(aVar4))) {
                        }
                        oxVar.rtd = bea;
                    }
                    return 0;
                case 6:
                    oxVar.rte = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
