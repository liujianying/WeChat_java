package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class ark extends a {
    public String iwF;
    public String rTM;
    public String rTN;
    public String rTO;
    public double rji;
    public double rjj;

    protected final int a(int i, Object... objArr) {
        int ec;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.c(1, this.rjj);
            aVar.c(2, this.rji);
            if (this.iwF != null) {
                aVar.g(3, this.iwF);
            }
            if (this.rTM != null) {
                aVar.g(4, this.rTM);
            }
            if (this.rTN != null) {
                aVar.g(5, this.rTN);
            }
            if (this.rTO != null) {
                aVar.g(6, this.rTO);
            }
            return 0;
        } else if (i == 1) {
            ec = ((f.a.a.b.b.a.ec(1) + 8) + 0) + (f.a.a.b.b.a.ec(2) + 8);
            if (this.iwF != null) {
                ec += f.a.a.b.b.a.h(3, this.iwF);
            }
            if (this.rTM != null) {
                ec += f.a.a.b.b.a.h(4, this.rTM);
            }
            if (this.rTN != null) {
                ec += f.a.a.b.b.a.h(5, this.rTN);
            }
            if (this.rTO != null) {
                return ec + f.a.a.b.b.a.h(6, this.rTO);
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
            ark ark = (ark) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ark.rjj = aVar3.vHC.readDouble();
                    return 0;
                case 2:
                    ark.rji = aVar3.vHC.readDouble();
                    return 0;
                case 3:
                    ark.iwF = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ark.rTM = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ark.rTN = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ark.rTO = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
