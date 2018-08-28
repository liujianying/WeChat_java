package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class amy extends a {
    public String jTh;
    public float rPK;
    public String rPL;
    public float rjG;
    public float rjH;

    protected final int a(int i, Object... objArr) {
        int ec;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.l(1, this.rjG);
            aVar.l(2, this.rjH);
            aVar.l(3, this.rPK);
            if (this.jTh != null) {
                aVar.g(4, this.jTh);
            }
            if (this.rPL != null) {
                aVar.g(5, this.rPL);
            }
            return 0;
        } else if (i == 1) {
            ec = (((f.a.a.b.b.a.ec(1) + 4) + 0) + (f.a.a.b.b.a.ec(2) + 4)) + (f.a.a.b.b.a.ec(3) + 4);
            if (this.jTh != null) {
                ec += f.a.a.b.b.a.h(4, this.jTh);
            }
            if (this.rPL != null) {
                return ec + f.a.a.b.b.a.h(5, this.rPL);
            }
            return ec;
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
            amy amy = (amy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amy.rjG = aVar3.vHC.readFloat();
                    return 0;
                case 2:
                    amy.rjH = aVar3.vHC.readFloat();
                    return 0;
                case 3:
                    amy.rPK = aVar3.vHC.readFloat();
                    return 0;
                case 4:
                    amy.jTh = aVar3.vHC.readString();
                    return 0;
                case 5:
                    amy.rPL = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
