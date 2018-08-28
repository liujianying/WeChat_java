package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public class bgl extends a {
    public int jTf;
    public String riA;
    public long shs;
    public int sht;
    public boolean shu;
    public boolean shv;
    public int shw;
    public boolean shx;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.riA != null) {
                aVar.g(1, this.riA);
            }
            aVar.T(2, this.shs);
            aVar.fT(3, this.sht);
            aVar.av(4, this.shu);
            aVar.av(5, this.shv);
            aVar.fT(6, this.shw);
            aVar.fT(7, this.jTf);
            aVar.av(8, this.shx);
            return 0;
        } else if (i == 1) {
            if (this.riA != null) {
                h = f.a.a.b.b.a.h(1, this.riA) + 0;
            } else {
                h = 0;
            }
            return ((((((h + f.a.a.a.S(2, this.shs)) + f.a.a.a.fQ(3, this.sht)) + (f.a.a.b.b.a.ec(4) + 1)) + (f.a.a.b.b.a.ec(5) + 1)) + f.a.a.a.fQ(6, this.shw)) + f.a.a.a.fQ(7, this.jTf)) + (f.a.a.b.b.a.ec(8) + 1);
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
            bgl bgl = (bgl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgl.riA = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bgl.shs = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    bgl.sht = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bgl.shu = aVar3.cJQ();
                    return 0;
                case 5:
                    bgl.shv = aVar3.cJQ();
                    return 0;
                case 6:
                    bgl.shw = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bgl.jTf = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bgl.shx = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
