package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cbf extends a {
    public String sxq;
    public String sxr;
    public String sxs;
    public String sxt;
    public int sxu;
    public float sxv;
    public float sxw;
    public String sxx;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sxq != null) {
                aVar.g(1, this.sxq);
            }
            if (this.sxr != null) {
                aVar.g(2, this.sxr);
            }
            if (this.sxs != null) {
                aVar.g(3, this.sxs);
            }
            if (this.sxt != null) {
                aVar.g(4, this.sxt);
            }
            aVar.fT(5, this.sxu);
            aVar.l(6, this.sxv);
            aVar.l(7, this.sxw);
            if (this.sxx == null) {
                return 0;
            }
            aVar.g(8, this.sxx);
            return 0;
        } else if (i == 1) {
            if (this.sxq != null) {
                h = f.a.a.b.b.a.h(1, this.sxq) + 0;
            } else {
                h = 0;
            }
            if (this.sxr != null) {
                h += f.a.a.b.b.a.h(2, this.sxr);
            }
            if (this.sxs != null) {
                h += f.a.a.b.b.a.h(3, this.sxs);
            }
            if (this.sxt != null) {
                h += f.a.a.b.b.a.h(4, this.sxt);
            }
            h = ((h + f.a.a.a.fQ(5, this.sxu)) + (f.a.a.b.b.a.ec(6) + 4)) + (f.a.a.b.b.a.ec(7) + 4);
            if (this.sxx != null) {
                h += f.a.a.b.b.a.h(8, this.sxx);
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
            cbf cbf = (cbf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbf.sxq = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cbf.sxr = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cbf.sxs = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cbf.sxt = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cbf.sxu = aVar3.vHC.rY();
                    return 0;
                case 6:
                    cbf.sxv = aVar3.vHC.readFloat();
                    return 0;
                case 7:
                    cbf.sxw = aVar3.vHC.readFloat();
                    return 0;
                case 8:
                    cbf.sxx = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
