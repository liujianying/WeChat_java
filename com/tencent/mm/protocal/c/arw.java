package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class arw extends a {
    public String rUs;
    public String rUt;
    public String rUu;
    public int rqN;
    public String type;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rUs != null) {
                aVar.g(1, this.rUs);
            }
            if (this.rUt != null) {
                aVar.g(2, this.rUt);
            }
            if (this.type != null) {
                aVar.g(3, this.type);
            }
            aVar.fT(4, this.rqN);
            if (this.rUu == null) {
                return 0;
            }
            aVar.g(5, this.rUu);
            return 0;
        } else if (i == 1) {
            if (this.rUs != null) {
                h = f.a.a.b.b.a.h(1, this.rUs) + 0;
            } else {
                h = 0;
            }
            if (this.rUt != null) {
                h += f.a.a.b.b.a.h(2, this.rUt);
            }
            if (this.type != null) {
                h += f.a.a.b.b.a.h(3, this.type);
            }
            h += f.a.a.a.fQ(4, this.rqN);
            if (this.rUu != null) {
                h += f.a.a.b.b.a.h(5, this.rUu);
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
            arw arw = (arw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arw.rUs = aVar3.vHC.readString();
                    return 0;
                case 2:
                    arw.rUt = aVar3.vHC.readString();
                    return 0;
                case 3:
                    arw.type = aVar3.vHC.readString();
                    return 0;
                case 4:
                    arw.rqN = aVar3.vHC.rY();
                    return 0;
                case 5:
                    arw.rUu = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
