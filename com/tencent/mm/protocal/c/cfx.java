package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cfx extends a {
    public String rcY;
    public String rwk;
    public int sAo;
    public int sAp;
    public String sAt;
    public cfq sAu;
    public cfw sAv;
    public String syW;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sAt == null) {
                throw new b("Not all required fields were included: EntranceDomain");
            } else if (this.syW == null) {
                throw new b("Not all required fields were included: Charset");
            } else {
                if (this.sAt != null) {
                    aVar.g(4, this.sAt);
                }
                if (this.syW != null) {
                    aVar.g(12, this.syW);
                }
                if (this.sAu != null) {
                    aVar.fV(9, this.sAu.boi());
                    this.sAu.a(aVar);
                }
                if (this.sAv != null) {
                    aVar.fV(10, this.sAv.boi());
                    this.sAv.a(aVar);
                }
                if (this.rwk != null) {
                    aVar.g(5, this.rwk);
                }
                if (this.rcY != null) {
                    aVar.g(6, this.rcY);
                }
                aVar.fT(7, this.sAo);
                aVar.fT(8, this.sAp);
                return 0;
            }
        } else if (i == 1) {
            if (this.sAt != null) {
                h = f.a.a.b.b.a.h(4, this.sAt) + 0;
            } else {
                h = 0;
            }
            if (this.syW != null) {
                h += f.a.a.b.b.a.h(12, this.syW);
            }
            if (this.sAu != null) {
                h += f.a.a.a.fS(9, this.sAu.boi());
            }
            if (this.sAv != null) {
                h += f.a.a.a.fS(10, this.sAv.boi());
            }
            if (this.rwk != null) {
                h += f.a.a.b.b.a.h(5, this.rwk);
            }
            if (this.rcY != null) {
                h += f.a.a.b.b.a.h(6, this.rcY);
            }
            return (h + f.a.a.a.fQ(7, this.sAo)) + f.a.a.a.fQ(8, this.sAp);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.sAt == null) {
                throw new b("Not all required fields were included: EntranceDomain");
            } else if (this.syW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Charset");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cfx cfx = (cfx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 4:
                    cfx.sAt = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cfx.rwk = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cfx.rcY = aVar3.vHC.readString();
                    return 0;
                case 7:
                    cfx.sAo = aVar3.vHC.rY();
                    return 0;
                case 8:
                    cfx.sAp = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cfq cfq = new cfq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfq.a(aVar4, cfq, a.a(aVar4))) {
                        }
                        cfx.sAu = cfq;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cfw cfw = new cfw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfw.a(aVar4, cfw, a.a(aVar4))) {
                        }
                        cfx.sAv = cfw;
                    }
                    return 0;
                case 12:
                    cfx.syW = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
