package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class pv extends a {
    public String bIO;
    public String bIP;
    public int rua;
    public int rub;
    public String ruc;
    public int version;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.version);
            aVar.fT(2, this.rua);
            aVar.fT(3, this.rub);
            if (this.bIP != null) {
                aVar.g(4, this.bIP);
            }
            if (this.ruc != null) {
                aVar.g(5, this.ruc);
            }
            if (this.bIO != null) {
                aVar.g(6, this.bIO);
            }
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.version) + 0) + f.a.a.a.fQ(2, this.rua)) + f.a.a.a.fQ(3, this.rub);
            if (this.bIP != null) {
                fQ += f.a.a.b.b.a.h(4, this.bIP);
            }
            if (this.ruc != null) {
                fQ += f.a.a.b.b.a.h(5, this.ruc);
            }
            if (this.bIO != null) {
                return fQ + f.a.a.b.b.a.h(6, this.bIO);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            pv pvVar = (pv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pvVar.version = aVar3.vHC.rY();
                    return 0;
                case 2:
                    pvVar.rua = aVar3.vHC.rY();
                    return 0;
                case 3:
                    pvVar.rub = aVar3.vHC.rY();
                    return 0;
                case 4:
                    pvVar.bIP = aVar3.vHC.readString();
                    return 0;
                case 5:
                    pvVar.ruc = aVar3.vHC.readString();
                    return 0;
                case 6:
                    pvVar.bIO = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
