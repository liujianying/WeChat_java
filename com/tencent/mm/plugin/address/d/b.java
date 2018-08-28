package com.tencent.mm.plugin.address.d;

import com.tencent.mm.bk.a;

public final class b extends a {
    public String eXX;
    public String eXY;
    public String eXZ;
    public String eYa;
    public String eYb;
    public String eYc;
    public String eYd;
    public String eYe;
    public String eYf;
    public int id;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.id);
            if (this.eXX != null) {
                aVar.g(2, this.eXX);
            }
            if (this.eXY != null) {
                aVar.g(3, this.eXY);
            }
            if (this.eXZ != null) {
                aVar.g(4, this.eXZ);
            }
            if (this.eYa != null) {
                aVar.g(5, this.eYa);
            }
            if (this.eYb != null) {
                aVar.g(6, this.eYb);
            }
            if (this.eYc != null) {
                aVar.g(7, this.eYc);
            }
            if (this.eYd != null) {
                aVar.g(8, this.eYd);
            }
            if (this.eYe != null) {
                aVar.g(9, this.eYe);
            }
            if (this.eYf != null) {
                aVar.g(10, this.eYf);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.id) + 0;
            if (this.eXX != null) {
                fQ += f.a.a.b.b.a.h(2, this.eXX);
            }
            if (this.eXY != null) {
                fQ += f.a.a.b.b.a.h(3, this.eXY);
            }
            if (this.eXZ != null) {
                fQ += f.a.a.b.b.a.h(4, this.eXZ);
            }
            if (this.eYa != null) {
                fQ += f.a.a.b.b.a.h(5, this.eYa);
            }
            if (this.eYb != null) {
                fQ += f.a.a.b.b.a.h(6, this.eYb);
            }
            if (this.eYc != null) {
                fQ += f.a.a.b.b.a.h(7, this.eYc);
            }
            if (this.eYd != null) {
                fQ += f.a.a.b.b.a.h(8, this.eYd);
            }
            if (this.eYe != null) {
                fQ += f.a.a.b.b.a.h(9, this.eYe);
            }
            if (this.eYf != null) {
                return fQ + f.a.a.b.b.a.h(10, this.eYf);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.id = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bVar.eXX = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bVar.eXY = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bVar.eXZ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bVar.eYa = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bVar.eYb = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bVar.eYc = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bVar.eYd = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bVar.eYe = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bVar.eYf = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
