package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bnb extends a {
    public int Height;
    public int Width;
    public String rwt;
    public String siz;
    public String sle;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rwt != null) {
                aVar.g(1, this.rwt);
            }
            aVar.fT(2, this.Width);
            aVar.fT(3, this.Height);
            if (this.siz != null) {
                aVar.g(4, this.siz);
            }
            if (this.sle == null) {
                return 0;
            }
            aVar.g(5, this.sle);
            return 0;
        } else if (i == 1) {
            if (this.rwt != null) {
                h = f.a.a.b.b.a.h(1, this.rwt) + 0;
            } else {
                h = 0;
            }
            h = (h + f.a.a.a.fQ(2, this.Width)) + f.a.a.a.fQ(3, this.Height);
            if (this.siz != null) {
                h += f.a.a.b.b.a.h(4, this.siz);
            }
            if (this.sle != null) {
                h += f.a.a.b.b.a.h(5, this.sle);
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
            bnb bnb = (bnb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bnb.rwt = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bnb.Width = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bnb.Height = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bnb.siz = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bnb.sle = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
