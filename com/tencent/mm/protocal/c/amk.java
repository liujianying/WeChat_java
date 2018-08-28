package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class amk extends a {
    public String mug;
    public String rPb;
    public long rPc;
    public String rPd;
    public String rPe;
    public String rPf;
    public String rlf;
    public int state;
    public String title;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rlf != null) {
                aVar.g(1, this.rlf);
            }
            aVar.fT(2, this.state);
            if (this.title != null) {
                aVar.g(3, this.title);
            }
            if (this.rPb != null) {
                aVar.g(4, this.rPb);
            }
            aVar.T(5, this.rPc);
            if (this.rPd != null) {
                aVar.g(6, this.rPd);
            }
            if (this.mug != null) {
                aVar.g(7, this.mug);
            }
            if (this.rPe != null) {
                aVar.g(8, this.rPe);
            }
            if (this.rPf == null) {
                return 0;
            }
            aVar.g(9, this.rPf);
            return 0;
        } else if (i == 1) {
            if (this.rlf != null) {
                h = f.a.a.b.b.a.h(1, this.rlf) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.state);
            if (this.title != null) {
                h += f.a.a.b.b.a.h(3, this.title);
            }
            if (this.rPb != null) {
                h += f.a.a.b.b.a.h(4, this.rPb);
            }
            h += f.a.a.a.S(5, this.rPc);
            if (this.rPd != null) {
                h += f.a.a.b.b.a.h(6, this.rPd);
            }
            if (this.mug != null) {
                h += f.a.a.b.b.a.h(7, this.mug);
            }
            if (this.rPe != null) {
                h += f.a.a.b.b.a.h(8, this.rPe);
            }
            if (this.rPf != null) {
                h += f.a.a.b.b.a.h(9, this.rPf);
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
            amk amk = (amk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amk.rlf = aVar3.vHC.readString();
                    return 0;
                case 2:
                    amk.state = aVar3.vHC.rY();
                    return 0;
                case 3:
                    amk.title = aVar3.vHC.readString();
                    return 0;
                case 4:
                    amk.rPb = aVar3.vHC.readString();
                    return 0;
                case 5:
                    amk.rPc = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    amk.rPd = aVar3.vHC.readString();
                    return 0;
                case 7:
                    amk.mug = aVar3.vHC.readString();
                    return 0;
                case 8:
                    amk.rPe = aVar3.vHC.readString();
                    return 0;
                case 9:
                    amk.rPf = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
