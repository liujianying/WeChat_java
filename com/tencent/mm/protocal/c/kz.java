package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class kz extends a {
    public int create_time;
    public int mXw;
    public String rnt;
    public String text;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.type);
            if (this.text != null) {
                aVar.g(2, this.text);
            }
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            aVar.fT(4, this.mXw);
            aVar.fT(5, this.create_time);
            if (this.rnt != null) {
                aVar.g(6, this.rnt);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.type) + 0;
            if (this.text != null) {
                fQ += f.a.a.b.b.a.h(2, this.text);
            }
            if (this.url != null) {
                fQ += f.a.a.b.b.a.h(3, this.url);
            }
            fQ = (fQ + f.a.a.a.fQ(4, this.mXw)) + f.a.a.a.fQ(5, this.create_time);
            if (this.rnt != null) {
                return fQ + f.a.a.b.b.a.h(6, this.rnt);
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
            kz kzVar = (kz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kzVar.type = aVar3.vHC.rY();
                    return 0;
                case 2:
                    kzVar.text = aVar3.vHC.readString();
                    return 0;
                case 3:
                    kzVar.url = aVar3.vHC.readString();
                    return 0;
                case 4:
                    kzVar.mXw = aVar3.vHC.rY();
                    return 0;
                case 5:
                    kzVar.create_time = aVar3.vHC.rY();
                    return 0;
                case 6:
                    kzVar.rnt = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
