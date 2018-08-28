package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class cbq extends a {
    public boolean sxG;
    public String sxH;
    public String sxI;
    public int sxJ;
    public int sxK;
    public int sxL;

    protected final int a(int i, Object... objArr) {
        int ec;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.av(1, this.sxG);
            if (this.sxH != null) {
                aVar.g(2, this.sxH);
            }
            if (this.sxI != null) {
                aVar.g(3, this.sxI);
            }
            aVar.fT(4, this.sxJ);
            aVar.fT(5, this.sxK);
            aVar.fT(6, this.sxL);
            return 0;
        } else if (i == 1) {
            ec = (f.a.a.b.b.a.ec(1) + 1) + 0;
            if (this.sxH != null) {
                ec += f.a.a.b.b.a.h(2, this.sxH);
            }
            if (this.sxI != null) {
                ec += f.a.a.b.b.a.h(3, this.sxI);
            }
            return ((ec + f.a.a.a.fQ(4, this.sxJ)) + f.a.a.a.fQ(5, this.sxK)) + f.a.a.a.fQ(6, this.sxL);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ec = a.a(aVar2); ec > 0; ec = a.a(aVar2)) {
                if (!super.a(aVar2, this, ec)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cbq cbq = (cbq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbq.sxG = aVar3.cJQ();
                    return 0;
                case 2:
                    cbq.sxH = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cbq.sxI = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cbq.sxJ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    cbq.sxK = aVar3.vHC.rY();
                    return 0;
                case 6:
                    cbq.sxL = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
