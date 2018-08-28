package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class li extends a {
    public int roA;
    public int roB;
    public String rov;
    public String rox;
    public int roy;
    public int roz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rov != null) {
                aVar.g(1, this.rov);
            }
            if (this.rox != null) {
                aVar.g(2, this.rox);
            }
            aVar.fT(3, this.roy);
            aVar.fT(4, this.roz);
            aVar.fT(5, this.roA);
            aVar.fT(6, this.roB);
            return 0;
        } else if (i == 1) {
            if (this.rov != null) {
                h = f.a.a.b.b.a.h(1, this.rov) + 0;
            } else {
                h = 0;
            }
            if (this.rox != null) {
                h += f.a.a.b.b.a.h(2, this.rox);
            }
            return (((h + f.a.a.a.fQ(3, this.roy)) + f.a.a.a.fQ(4, this.roz)) + f.a.a.a.fQ(5, this.roA)) + f.a.a.a.fQ(6, this.roB);
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
            li liVar = (li) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    liVar.rov = aVar3.vHC.readString();
                    return 0;
                case 2:
                    liVar.rox = aVar3.vHC.readString();
                    return 0;
                case 3:
                    liVar.roy = aVar3.vHC.rY();
                    return 0;
                case 4:
                    liVar.roz = aVar3.vHC.rY();
                    return 0;
                case 5:
                    liVar.roA = aVar3.vHC.rY();
                    return 0;
                case 6:
                    liVar.roB = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
