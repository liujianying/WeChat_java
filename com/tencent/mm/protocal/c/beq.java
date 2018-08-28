package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class beq extends a {
    public String hbL;
    public String hcS;
    public String rEJ;
    public String rwN;
    public String ryZ;
    public int sdg;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL != null) {
                aVar.g(1, this.hbL);
            }
            aVar.fT(2, this.sdg);
            if (this.hcS != null) {
                aVar.g(3, this.hcS);
            }
            if (this.rwN != null) {
                aVar.g(4, this.rwN);
            }
            if (this.ryZ != null) {
                aVar.g(5, this.ryZ);
            }
            if (this.rEJ == null) {
                return 0;
            }
            aVar.g(6, this.rEJ);
            return 0;
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.sdg);
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(3, this.hcS);
            }
            if (this.rwN != null) {
                h += f.a.a.b.b.a.h(4, this.rwN);
            }
            if (this.ryZ != null) {
                h += f.a.a.b.b.a.h(5, this.ryZ);
            }
            if (this.rEJ != null) {
                h += f.a.a.b.b.a.h(6, this.rEJ);
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
            beq beq = (beq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    beq.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    beq.sdg = aVar3.vHC.rY();
                    return 0;
                case 3:
                    beq.hcS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    beq.rwN = aVar3.vHC.readString();
                    return 0;
                case 5:
                    beq.ryZ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    beq.rEJ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
