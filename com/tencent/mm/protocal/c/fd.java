package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class fd extends a {
    public String knE;
    public String lMV;
    public String lMW;
    public String pjw;
    public String rfW;
    public String rfX;
    public String rfY;
    public String rfZ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rfW != null) {
                aVar.g(1, this.rfW);
            }
            if (this.pjw != null) {
                aVar.g(2, this.pjw);
            }
            if (this.lMV != null) {
                aVar.g(3, this.lMV);
            }
            if (this.lMW != null) {
                aVar.g(4, this.lMW);
            }
            if (this.knE != null) {
                aVar.g(5, this.knE);
            }
            if (this.rfX != null) {
                aVar.g(6, this.rfX);
            }
            if (this.rfY != null) {
                aVar.g(7, this.rfY);
            }
            if (this.rfZ == null) {
                return 0;
            }
            aVar.g(8, this.rfZ);
            return 0;
        } else if (i == 1) {
            if (this.rfW != null) {
                h = f.a.a.b.b.a.h(1, this.rfW) + 0;
            } else {
                h = 0;
            }
            if (this.pjw != null) {
                h += f.a.a.b.b.a.h(2, this.pjw);
            }
            if (this.lMV != null) {
                h += f.a.a.b.b.a.h(3, this.lMV);
            }
            if (this.lMW != null) {
                h += f.a.a.b.b.a.h(4, this.lMW);
            }
            if (this.knE != null) {
                h += f.a.a.b.b.a.h(5, this.knE);
            }
            if (this.rfX != null) {
                h += f.a.a.b.b.a.h(6, this.rfX);
            }
            if (this.rfY != null) {
                h += f.a.a.b.b.a.h(7, this.rfY);
            }
            if (this.rfZ != null) {
                h += f.a.a.b.b.a.h(8, this.rfZ);
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
            fd fdVar = (fd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fdVar.rfW = aVar3.vHC.readString();
                    return 0;
                case 2:
                    fdVar.pjw = aVar3.vHC.readString();
                    return 0;
                case 3:
                    fdVar.lMV = aVar3.vHC.readString();
                    return 0;
                case 4:
                    fdVar.lMW = aVar3.vHC.readString();
                    return 0;
                case 5:
                    fdVar.knE = aVar3.vHC.readString();
                    return 0;
                case 6:
                    fdVar.rfX = aVar3.vHC.readString();
                    return 0;
                case 7:
                    fdVar.rfY = aVar3.vHC.readString();
                    return 0;
                case 8:
                    fdVar.rfZ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
