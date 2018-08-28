package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class aso extends a {
    public String bPS;
    public boolean rUO;
    public boolean rUP;
    public int rUQ;
    public int rUR;
    public String rUS;
    public boolean rUT;

    protected final int a(int i, Object... objArr) {
        int ec;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.av(1, this.rUO);
            aVar.av(2, this.rUP);
            aVar.fT(3, this.rUQ);
            aVar.fT(4, this.rUR);
            if (this.rUS != null) {
                aVar.g(5, this.rUS);
            }
            aVar.av(6, this.rUT);
            if (this.bPS != null) {
                aVar.g(7, this.bPS);
            }
            return 0;
        } else if (i == 1) {
            ec = ((((f.a.a.b.b.a.ec(1) + 1) + 0) + (f.a.a.b.b.a.ec(2) + 1)) + f.a.a.a.fQ(3, this.rUQ)) + f.a.a.a.fQ(4, this.rUR);
            if (this.rUS != null) {
                ec += f.a.a.b.b.a.h(5, this.rUS);
            }
            ec += f.a.a.b.b.a.ec(6) + 1;
            if (this.bPS != null) {
                return ec + f.a.a.b.b.a.h(7, this.bPS);
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
            aso aso = (aso) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aso.rUO = aVar3.cJQ();
                    return 0;
                case 2:
                    aso.rUP = aVar3.cJQ();
                    return 0;
                case 3:
                    aso.rUQ = aVar3.vHC.rY();
                    return 0;
                case 4:
                    aso.rUR = aVar3.vHC.rY();
                    return 0;
                case 5:
                    aso.rUS = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aso.rUT = aVar3.cJQ();
                    return 0;
                case 7:
                    aso.bPS = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
