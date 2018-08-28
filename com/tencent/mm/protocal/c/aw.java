package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class aw extends a {
    public String csK;
    public String csL;
    public double latitude;
    public double longitude;
    public long raY;
    public String raZ;
    public String rba;
    public String rbb;
    public String rbc;
    public String rbd;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.csK != null) {
                aVar.g(1, this.csK);
            }
            if (this.csL != null) {
                aVar.g(2, this.csL);
            }
            aVar.c(3, this.latitude);
            aVar.c(4, this.longitude);
            aVar.T(5, this.raY);
            if (this.raZ != null) {
                aVar.g(6, this.raZ);
            }
            if (this.rba != null) {
                aVar.g(7, this.rba);
            }
            if (this.rbb != null) {
                aVar.g(8, this.rbb);
            }
            if (this.rbc != null) {
                aVar.g(9, this.rbc);
            }
            if (this.rbd == null) {
                return 0;
            }
            aVar.g(10, this.rbd);
            return 0;
        } else if (i == 1) {
            if (this.csK != null) {
                h = f.a.a.b.b.a.h(1, this.csK) + 0;
            } else {
                h = 0;
            }
            if (this.csL != null) {
                h += f.a.a.b.b.a.h(2, this.csL);
            }
            h = ((h + (f.a.a.b.b.a.ec(3) + 8)) + (f.a.a.b.b.a.ec(4) + 8)) + f.a.a.a.S(5, this.raY);
            if (this.raZ != null) {
                h += f.a.a.b.b.a.h(6, this.raZ);
            }
            if (this.rba != null) {
                h += f.a.a.b.b.a.h(7, this.rba);
            }
            if (this.rbb != null) {
                h += f.a.a.b.b.a.h(8, this.rbb);
            }
            if (this.rbc != null) {
                h += f.a.a.b.b.a.h(9, this.rbc);
            }
            if (this.rbd != null) {
                h += f.a.a.b.b.a.h(10, this.rbd);
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
            aw awVar = (aw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awVar.csK = aVar3.vHC.readString();
                    return 0;
                case 2:
                    awVar.csL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    awVar.latitude = aVar3.vHC.readDouble();
                    return 0;
                case 4:
                    awVar.longitude = aVar3.vHC.readDouble();
                    return 0;
                case 5:
                    awVar.raY = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    awVar.raZ = aVar3.vHC.readString();
                    return 0;
                case 7:
                    awVar.rba = aVar3.vHC.readString();
                    return 0;
                case 8:
                    awVar.rbb = aVar3.vHC.readString();
                    return 0;
                case 9:
                    awVar.rbc = aVar3.vHC.readString();
                    return 0;
                case 10:
                    awVar.rbd = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
