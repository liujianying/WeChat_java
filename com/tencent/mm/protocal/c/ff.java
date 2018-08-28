package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ff extends a {
    public String hFn;
    public String knE;
    public String lMV;
    public String pjw;
    public String rgb;
    public String rgc;
    public String rgd;
    public boolean rge;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.knE != null) {
                aVar.g(1, this.knE);
            }
            if (this.lMV != null) {
                aVar.g(2, this.lMV);
            }
            if (this.hFn != null) {
                aVar.g(3, this.hFn);
            }
            if (this.pjw != null) {
                aVar.g(4, this.pjw);
            }
            if (this.rgb != null) {
                aVar.g(5, this.rgb);
            }
            if (this.rgc != null) {
                aVar.g(6, this.rgc);
            }
            if (this.rgd != null) {
                aVar.g(8, this.rgd);
            }
            aVar.av(9, this.rge);
            return 0;
        } else if (i == 1) {
            if (this.knE != null) {
                h = f.a.a.b.b.a.h(1, this.knE) + 0;
            } else {
                h = 0;
            }
            if (this.lMV != null) {
                h += f.a.a.b.b.a.h(2, this.lMV);
            }
            if (this.hFn != null) {
                h += f.a.a.b.b.a.h(3, this.hFn);
            }
            if (this.pjw != null) {
                h += f.a.a.b.b.a.h(4, this.pjw);
            }
            if (this.rgb != null) {
                h += f.a.a.b.b.a.h(5, this.rgb);
            }
            if (this.rgc != null) {
                h += f.a.a.b.b.a.h(6, this.rgc);
            }
            if (this.rgd != null) {
                h += f.a.a.b.b.a.h(8, this.rgd);
            }
            return h + (f.a.a.b.b.a.ec(9) + 1);
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
            ff ffVar = (ff) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ffVar.knE = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ffVar.lMV = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ffVar.hFn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ffVar.pjw = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ffVar.rgb = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ffVar.rgc = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ffVar.rgd = aVar3.vHC.readString();
                    return 0;
                case 9:
                    ffVar.rge = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
