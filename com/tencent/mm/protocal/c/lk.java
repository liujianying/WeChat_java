package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public class lk extends a {
    public String huX;
    public String hyz;
    public String lMY;
    public String rnv;
    public String rnw;
    public long roL;
    public String roM;
    public String roN;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.huX != null) {
                aVar.g(2, this.huX);
            }
            if (this.hyz != null) {
                aVar.g(3, this.hyz);
            }
            if (this.url != null) {
                aVar.g(4, this.url);
            }
            aVar.T(5, this.roL);
            if (this.roM != null) {
                aVar.g(6, this.roM);
            }
            if (this.roN != null) {
                aVar.g(7, this.roN);
            }
            if (this.lMY != null) {
                aVar.g(8, this.lMY);
            }
            if (this.rnv != null) {
                aVar.g(9, this.rnv);
            }
            if (this.rnw == null) {
                return 0;
            }
            aVar.g(10, this.rnw);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = f.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.huX != null) {
                h += f.a.a.b.b.a.h(2, this.huX);
            }
            if (this.hyz != null) {
                h += f.a.a.b.b.a.h(3, this.hyz);
            }
            if (this.url != null) {
                h += f.a.a.b.b.a.h(4, this.url);
            }
            h += f.a.a.a.S(5, this.roL);
            if (this.roM != null) {
                h += f.a.a.b.b.a.h(6, this.roM);
            }
            if (this.roN != null) {
                h += f.a.a.b.b.a.h(7, this.roN);
            }
            if (this.lMY != null) {
                h += f.a.a.b.b.a.h(8, this.lMY);
            }
            if (this.rnv != null) {
                h += f.a.a.b.b.a.h(9, this.rnv);
            }
            if (this.rnw != null) {
                h += f.a.a.b.b.a.h(10, this.rnw);
            }
            return h;
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
            lk lkVar = (lk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lkVar.title = aVar3.vHC.readString();
                    return 0;
                case 2:
                    lkVar.huX = aVar3.vHC.readString();
                    return 0;
                case 3:
                    lkVar.hyz = aVar3.vHC.readString();
                    return 0;
                case 4:
                    lkVar.url = aVar3.vHC.readString();
                    return 0;
                case 5:
                    lkVar.roL = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    lkVar.roM = aVar3.vHC.readString();
                    return 0;
                case 7:
                    lkVar.roN = aVar3.vHC.readString();
                    return 0;
                case 8:
                    lkVar.lMY = aVar3.vHC.readString();
                    return 0;
                case 9:
                    lkVar.rnv = aVar3.vHC.readString();
                    return 0;
                case 10:
                    lkVar.rnw = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
