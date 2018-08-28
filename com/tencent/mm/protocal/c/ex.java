package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ex extends a implements bnu {
    public String ID;
    public bhy reV;
    public String rfm;
    public int rfn;
    public bhy rfo;
    public String rfp;
    public int rfq;
    public String rfr;
    public String rfs;

    public final int getRet() {
        return this.rfn;
    }

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rfo == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            } else if (this.reV == null) {
                throw new b("Not all required fields were included: Key");
            } else {
                aVar.fT(1, this.rfn);
                if (this.rfo != null) {
                    aVar.fV(2, this.rfo.boi());
                    this.rfo.a(aVar);
                }
                if (this.rfp != null) {
                    aVar.g(3, this.rfp);
                }
                if (this.reV != null) {
                    aVar.fV(4, this.reV.boi());
                    this.reV.a(aVar);
                }
                if (this.rfr != null) {
                    aVar.g(5, this.rfr);
                }
                if (this.rfs != null) {
                    aVar.g(6, this.rfs);
                }
                aVar.fT(7, this.rfq);
                if (this.ID != null) {
                    aVar.g(8, this.ID);
                }
                if (this.rfm != null) {
                    aVar.g(9, this.rfm);
                }
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rfn) + 0;
            if (this.rfo != null) {
                fQ += f.a.a.a.fS(2, this.rfo.boi());
            }
            if (this.rfp != null) {
                fQ += f.a.a.b.b.a.h(3, this.rfp);
            }
            if (this.reV != null) {
                fQ += f.a.a.a.fS(4, this.reV.boi());
            }
            if (this.rfr != null) {
                fQ += f.a.a.b.b.a.h(5, this.rfr);
            }
            if (this.rfs != null) {
                fQ += f.a.a.b.b.a.h(6, this.rfs);
            }
            fQ += f.a.a.a.fQ(7, this.rfq);
            if (this.ID != null) {
                fQ += f.a.a.b.b.a.h(8, this.ID);
            }
            if (this.rfm != null) {
                return fQ + f.a.a.b.b.a.h(9, this.rfm);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rfo == null) {
                throw new b("Not all required fields were included: QRCodeBuffer");
            } else if (this.reV != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Key");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ex exVar = (ex) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            bhy bhy;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    exVar.rfn = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        exVar.rfo = bhy;
                    }
                    return 0;
                case 3:
                    exVar.rfp = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        exVar.reV = bhy;
                    }
                    return 0;
                case 5:
                    exVar.rfr = aVar3.vHC.readString();
                    return 0;
                case 6:
                    exVar.rfs = aVar3.vHC.readString();
                    return 0;
                case 7:
                    exVar.rfq = aVar3.vHC.rY();
                    return 0;
                case 8:
                    exVar.ID = aVar3.vHC.readString();
                    return 0;
                case 9:
                    exVar.rfm = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
