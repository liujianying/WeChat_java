package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class oe extends bhd {
    public String bHD;
    public String jQb;
    public int otY;
    public String rsp;
    public String rsq;
    public String rsr;
    public String rss;
    public String rst;
    public String rsu;
    public String rsv;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rsp != null) {
                aVar.g(2, this.rsp);
            }
            if (this.bHD != null) {
                aVar.g(3, this.bHD);
            }
            if (this.rsq != null) {
                aVar.g(4, this.rsq);
            }
            if (this.rsr != null) {
                aVar.g(5, this.rsr);
            }
            if (this.rss != null) {
                aVar.g(6, this.rss);
            }
            if (this.rst != null) {
                aVar.g(7, this.rst);
            }
            if (this.rsu != null) {
                aVar.g(8, this.rsu);
            }
            if (this.jQb != null) {
                aVar.g(9, this.jQb);
            }
            aVar.fT(10, this.otY);
            if (this.rsv == null) {
                return 0;
            }
            aVar.g(11, this.rsv);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rsp != null) {
                fS += f.a.a.b.b.a.h(2, this.rsp);
            }
            if (this.bHD != null) {
                fS += f.a.a.b.b.a.h(3, this.bHD);
            }
            if (this.rsq != null) {
                fS += f.a.a.b.b.a.h(4, this.rsq);
            }
            if (this.rsr != null) {
                fS += f.a.a.b.b.a.h(5, this.rsr);
            }
            if (this.rss != null) {
                fS += f.a.a.b.b.a.h(6, this.rss);
            }
            if (this.rst != null) {
                fS += f.a.a.b.b.a.h(7, this.rst);
            }
            if (this.rsu != null) {
                fS += f.a.a.b.b.a.h(8, this.rsu);
            }
            if (this.jQb != null) {
                fS += f.a.a.b.b.a.h(9, this.jQb);
            }
            fS += f.a.a.a.fQ(10, this.otY);
            if (this.rsv != null) {
                fS += f.a.a.b.b.a.h(11, this.rsv);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            oe oeVar = (oe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        oeVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    oeVar.rsp = aVar3.vHC.readString();
                    return 0;
                case 3:
                    oeVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 4:
                    oeVar.rsq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    oeVar.rsr = aVar3.vHC.readString();
                    return 0;
                case 6:
                    oeVar.rss = aVar3.vHC.readString();
                    return 0;
                case 7:
                    oeVar.rst = aVar3.vHC.readString();
                    return 0;
                case 8:
                    oeVar.rsu = aVar3.vHC.readString();
                    return 0;
                case 9:
                    oeVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 10:
                    oeVar.otY = aVar3.vHC.rY();
                    return 0;
                case 11:
                    oeVar.rsv = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
