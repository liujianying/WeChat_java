package com.tencent.mm.c;

import com.tencent.mm.bk.a;

public final class b extends a {
    public String apkMd5;
    public int bxk;
    public String bxl;
    public int bxm;
    public String bxn;
    public String bxo;
    public boolean bxp;
    public int bxq;
    public boolean bxr;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.apkMd5 == null) {
                throw new f.a.a.b("Not all required fields were included: apkMd5");
            }
            if (this.apkMd5 != null) {
                aVar.g(1, this.apkMd5);
            }
            aVar.fU(2, this.bxk);
            if (this.bxl != null) {
                aVar.g(3, this.bxl);
            }
            aVar.fU(4, this.bxm);
            if (this.bxn != null) {
                aVar.g(5, this.bxn);
            }
            if (this.bxo != null) {
                aVar.g(6, this.bxo);
            }
            aVar.av(7, this.bxp);
            aVar.fU(8, this.bxq);
            aVar.av(9, this.bxr);
            return 0;
        } else if (i == 1) {
            if (this.apkMd5 != null) {
                h = f.a.a.a.h(1, this.apkMd5) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fR(2, this.bxk);
            if (this.bxl != null) {
                h += f.a.a.a.h(3, this.bxl);
            }
            h += f.a.a.a.fR(4, this.bxm);
            if (this.bxn != null) {
                h += f.a.a.a.h(5, this.bxn);
            }
            if (this.bxo != null) {
                h += f.a.a.a.h(6, this.bxo);
            }
            return ((h + f.a.a.a.IB(7)) + f.a.a.a.fR(8, this.bxq)) + f.a.a.a.IB(9);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.apkMd5 != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: apkMd5");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.apkMd5 = aVar3.cJP();
                    return 0;
                case 2:
                    bVar.bxk = aVar3.cJN();
                    return 0;
                case 3:
                    bVar.bxl = aVar3.cJP();
                    return 0;
                case 4:
                    bVar.bxm = aVar3.cJN();
                    return 0;
                case 5:
                    bVar.bxn = aVar3.cJP();
                    return 0;
                case 6:
                    bVar.bxo = aVar3.cJP();
                    return 0;
                case 7:
                    bVar.bxp = aVar3.cJQ();
                    return 0;
                case 8:
                    bVar.bxq = aVar3.cJN();
                    return 0;
                case 9:
                    bVar.bxr = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
