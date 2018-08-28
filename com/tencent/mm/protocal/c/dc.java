package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class dc extends a {
    public String hcr;
    public String jSv;
    public String ksA;
    public String rdf;
    public String rdg;
    public int rdh;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ksA != null) {
                aVar.g(1, this.ksA);
            }
            if (this.hcr != null) {
                aVar.g(2, this.hcr);
            }
            if (this.jSv != null) {
                aVar.g(3, this.jSv);
            }
            if (this.rdf != null) {
                aVar.g(4, this.rdf);
            }
            if (this.rdg != null) {
                aVar.g(5, this.rdg);
            }
            aVar.fT(6, this.rdh);
            return 0;
        } else if (i == 1) {
            if (this.ksA != null) {
                h = f.a.a.b.b.a.h(1, this.ksA) + 0;
            } else {
                h = 0;
            }
            if (this.hcr != null) {
                h += f.a.a.b.b.a.h(2, this.hcr);
            }
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(3, this.jSv);
            }
            if (this.rdf != null) {
                h += f.a.a.b.b.a.h(4, this.rdf);
            }
            if (this.rdg != null) {
                h += f.a.a.b.b.a.h(5, this.rdg);
            }
            return h + f.a.a.a.fQ(6, this.rdh);
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
            dc dcVar = (dc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcVar.ksA = aVar3.vHC.readString();
                    return 0;
                case 2:
                    dcVar.hcr = aVar3.vHC.readString();
                    return 0;
                case 3:
                    dcVar.jSv = aVar3.vHC.readString();
                    return 0;
                case 4:
                    dcVar.rdf = aVar3.vHC.readString();
                    return 0;
                case 5:
                    dcVar.rdg = aVar3.vHC.readString();
                    return 0;
                case 6:
                    dcVar.rdh = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
