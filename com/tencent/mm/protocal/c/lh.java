package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class lh extends a {
    public int hcd;
    public int rca;
    public String ros;
    public long rot;
    public int rou;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ros != null) {
                aVar.g(1, this.ros);
            }
            aVar.T(2, this.rot);
            aVar.fT(3, this.rou);
            aVar.fT(4, this.rca);
            aVar.fT(5, this.hcd);
            return 0;
        } else if (i == 1) {
            if (this.ros != null) {
                h = f.a.a.b.b.a.h(1, this.ros) + 0;
            } else {
                h = 0;
            }
            return (((h + f.a.a.a.S(2, this.rot)) + f.a.a.a.fQ(3, this.rou)) + f.a.a.a.fQ(4, this.rca)) + f.a.a.a.fQ(5, this.hcd);
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
            lh lhVar = (lh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lhVar.ros = aVar3.vHC.readString();
                    return 0;
                case 2:
                    lhVar.rot = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    lhVar.rou = aVar3.vHC.rY();
                    return 0;
                case 4:
                    lhVar.rca = aVar3.vHC.rY();
                    return 0;
                case 5:
                    lhVar.hcd = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
