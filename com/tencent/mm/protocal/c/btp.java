package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class btp extends a {
    public String jPe;
    public double rji;
    public double rjj;
    public String sbw;

    protected final int a(int i, Object... objArr) {
        int ec;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.c(1, this.rjj);
            aVar.c(2, this.rji);
            if (this.jPe != null) {
                aVar.g(3, this.jPe);
            }
            if (this.sbw != null) {
                aVar.g(4, this.sbw);
            }
            return 0;
        } else if (i == 1) {
            ec = ((f.a.a.b.b.a.ec(1) + 8) + 0) + (f.a.a.b.b.a.ec(2) + 8);
            if (this.jPe != null) {
                ec += f.a.a.b.b.a.h(3, this.jPe);
            }
            if (this.sbw != null) {
                return ec + f.a.a.b.b.a.h(4, this.sbw);
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
            btp btp = (btp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btp.rjj = aVar3.vHC.readDouble();
                    return 0;
                case 2:
                    btp.rji = aVar3.vHC.readDouble();
                    return 0;
                case 3:
                    btp.jPe = aVar3.vHC.readString();
                    return 0;
                case 4:
                    btp.sbw = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
