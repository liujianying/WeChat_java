package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class cu extends a {
    public String hbL;
    public int jTf;
    public long jTg;
    public String jTh;
    public boolean jTi;
    public int jTj;
    public String jTk;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL == null) {
                throw new b("Not all required fields were included: UserName");
            }
            if (this.hbL != null) {
                aVar.g(1, this.hbL);
            }
            aVar.fT(2, this.jTf);
            aVar.T(3, this.jTg);
            if (this.jTh != null) {
                aVar.g(4, this.jTh);
            }
            aVar.av(5, this.jTi);
            aVar.fT(6, this.jTj);
            if (this.jTk == null) {
                return 0;
            }
            aVar.g(7, this.jTk);
            return 0;
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            h = (h + f.a.a.a.fQ(2, this.jTf)) + f.a.a.a.S(3, this.jTg);
            if (this.jTh != null) {
                h += f.a.a.b.b.a.h(4, this.jTh);
            }
            h = (h + (f.a.a.b.b.a.ec(5) + 1)) + f.a.a.a.fQ(6, this.jTj);
            if (this.jTk != null) {
                h += f.a.a.b.b.a.h(7, this.jTk);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.hbL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cu cuVar = (cu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cuVar.jTf = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cuVar.jTg = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    cuVar.jTh = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cuVar.jTi = aVar3.cJQ();
                    return 0;
                case 6:
                    cuVar.jTj = aVar3.vHC.rY();
                    return 0;
                case 7:
                    cuVar.jTk = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
