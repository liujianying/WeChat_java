package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bk.a;

public final class i extends a {
    public String kLZ;
    public int kPI;
    public String kPM;
    public long kPP;
    public long kPR;
    public String kPS;
    public int kQd;
    public String kQo;
    public long kQp;
    public String kQq;
    public String kQr;
    public String kQs;
    public long kQt;
    public int kQu;
    public int status;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.kQo != null) {
                aVar.g(1, this.kQo);
            }
            if (this.kPM != null) {
                aVar.g(2, this.kPM);
            }
            aVar.T(3, this.kQp);
            if (this.kQq != null) {
                aVar.g(4, this.kQq);
            }
            aVar.fT(5, this.kPI);
            if (this.kQr != null) {
                aVar.g(6, this.kQr);
            }
            if (this.kQs != null) {
                aVar.g(7, this.kQs);
            }
            aVar.T(8, this.kPR);
            aVar.T(9, this.kQt);
            aVar.T(10, this.kPP);
            aVar.fT(11, this.status);
            aVar.fT(12, this.kQu);
            if (this.kPS != null) {
                aVar.g(13, this.kPS);
            }
            if (this.kLZ != null) {
                aVar.g(14, this.kLZ);
            }
            aVar.fT(15, this.kQd);
            return 0;
        } else if (i == 1) {
            if (this.kQo != null) {
                h = f.a.a.b.b.a.h(1, this.kQo) + 0;
            } else {
                h = 0;
            }
            if (this.kPM != null) {
                h += f.a.a.b.b.a.h(2, this.kPM);
            }
            h += f.a.a.a.S(3, this.kQp);
            if (this.kQq != null) {
                h += f.a.a.b.b.a.h(4, this.kQq);
            }
            h += f.a.a.a.fQ(5, this.kPI);
            if (this.kQr != null) {
                h += f.a.a.b.b.a.h(6, this.kQr);
            }
            if (this.kQs != null) {
                h += f.a.a.b.b.a.h(7, this.kQs);
            }
            h = ((((h + f.a.a.a.S(8, this.kPR)) + f.a.a.a.S(9, this.kQt)) + f.a.a.a.S(10, this.kPP)) + f.a.a.a.fQ(11, this.status)) + f.a.a.a.fQ(12, this.kQu);
            if (this.kPS != null) {
                h += f.a.a.b.b.a.h(13, this.kPS);
            }
            if (this.kLZ != null) {
                h += f.a.a.b.b.a.h(14, this.kLZ);
            }
            return h + f.a.a.a.fQ(15, this.kQd);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.kQo = aVar3.vHC.readString();
                    return 0;
                case 2:
                    iVar.kPM = aVar3.vHC.readString();
                    return 0;
                case 3:
                    iVar.kQp = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    iVar.kQq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    iVar.kPI = aVar3.vHC.rY();
                    return 0;
                case 6:
                    iVar.kQr = aVar3.vHC.readString();
                    return 0;
                case 7:
                    iVar.kQs = aVar3.vHC.readString();
                    return 0;
                case 8:
                    iVar.kPR = aVar3.vHC.rZ();
                    return 0;
                case 9:
                    iVar.kQt = aVar3.vHC.rZ();
                    return 0;
                case 10:
                    iVar.kPP = aVar3.vHC.rZ();
                    return 0;
                case 11:
                    iVar.status = aVar3.vHC.rY();
                    return 0;
                case 12:
                    iVar.kQu = aVar3.vHC.rY();
                    return 0;
                case 13:
                    iVar.kPS = aVar3.vHC.readString();
                    return 0;
                case 14:
                    iVar.kLZ = aVar3.vHC.readString();
                    return 0;
                case 15:
                    iVar.kQd = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
