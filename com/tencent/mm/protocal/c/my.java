package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class my extends a {
    public String hbL;
    public String hcS;
    public String rqY;
    public String rqZ;
    public String rra;
    public int rrb;
    public String rrc;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL != null) {
                aVar.g(1, this.hbL);
            }
            if (this.hcS != null) {
                aVar.g(2, this.hcS);
            }
            if (this.rqY != null) {
                aVar.g(3, this.rqY);
            }
            if (this.rqZ != null) {
                aVar.g(4, this.rqZ);
            }
            if (this.rra != null) {
                aVar.g(5, this.rra);
            }
            aVar.fT(6, this.rrb);
            if (this.rrc == null) {
                return 0;
            }
            aVar.g(7, this.rrc);
            return 0;
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(2, this.hcS);
            }
            if (this.rqY != null) {
                h += f.a.a.b.b.a.h(3, this.rqY);
            }
            if (this.rqZ != null) {
                h += f.a.a.b.b.a.h(4, this.rqZ);
            }
            if (this.rra != null) {
                h += f.a.a.b.b.a.h(5, this.rra);
            }
            h += f.a.a.a.fQ(6, this.rrb);
            if (this.rrc != null) {
                h += f.a.a.b.b.a.h(7, this.rrc);
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
            my myVar = (my) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    myVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    myVar.hcS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    myVar.rqY = aVar3.vHC.readString();
                    return 0;
                case 4:
                    myVar.rqZ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    myVar.rra = aVar3.vHC.readString();
                    return 0;
                case 6:
                    myVar.rrb = aVar3.vHC.rY();
                    return 0;
                case 7:
                    myVar.rrc = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
