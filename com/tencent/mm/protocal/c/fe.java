package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class fe extends a {
    public String knE;
    public String lMV;
    public String lNU;
    public String rga;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rga != null) {
                aVar.g(1, this.rga);
            }
            if (this.lMV != null) {
                aVar.g(2, this.lMV);
            }
            if (this.knE != null) {
                aVar.g(3, this.knE);
            }
            if (this.lNU == null) {
                return 0;
            }
            aVar.g(4, this.lNU);
            return 0;
        } else if (i == 1) {
            if (this.rga != null) {
                h = f.a.a.b.b.a.h(1, this.rga) + 0;
            } else {
                h = 0;
            }
            if (this.lMV != null) {
                h += f.a.a.b.b.a.h(2, this.lMV);
            }
            if (this.knE != null) {
                h += f.a.a.b.b.a.h(3, this.knE);
            }
            if (this.lNU != null) {
                h += f.a.a.b.b.a.h(4, this.lNU);
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
            fe feVar = (fe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    feVar.rga = aVar3.vHC.readString();
                    return 0;
                case 2:
                    feVar.lMV = aVar3.vHC.readString();
                    return 0;
                case 3:
                    feVar.knE = aVar3.vHC.readString();
                    return 0;
                case 4:
                    feVar.lNU = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
