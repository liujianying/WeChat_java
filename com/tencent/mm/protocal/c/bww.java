package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bww extends bhp {
    public String jTu;
    public String jTv;
    public int lOH;
    public int rci;
    public long rcq;
    public String rdo;
    public int rgC;
    public int rjC;
    public int rvV;
    public int rvX;
    public int rvY;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.jTv != null) {
                aVar.g(1, this.jTv);
            }
            if (this.jTu != null) {
                aVar.g(2, this.jTu);
            }
            aVar.fT(3, this.rjC);
            aVar.fT(4, this.rvV);
            aVar.fT(5, this.lOH);
            if (this.rdo != null) {
                aVar.g(6, this.rdo);
            }
            aVar.fT(7, this.rci);
            aVar.fT(8, this.rvX);
            aVar.fT(9, this.rgC);
            if (this.six != null) {
                aVar.fV(10, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(11, this.rvY);
            aVar.T(12, this.rcq);
            return 0;
        } else if (i == 1) {
            if (this.jTv != null) {
                h = f.a.a.b.b.a.h(1, this.jTv) + 0;
            } else {
                h = 0;
            }
            if (this.jTu != null) {
                h += f.a.a.b.b.a.h(2, this.jTu);
            }
            h = ((h + f.a.a.a.fQ(3, this.rjC)) + f.a.a.a.fQ(4, this.rvV)) + f.a.a.a.fQ(5, this.lOH);
            if (this.rdo != null) {
                h += f.a.a.b.b.a.h(6, this.rdo);
            }
            h = ((h + f.a.a.a.fQ(7, this.rci)) + f.a.a.a.fQ(8, this.rvX)) + f.a.a.a.fQ(9, this.rgC);
            if (this.six != null) {
                h += f.a.a.a.fS(10, this.six.boi());
            }
            return (h + f.a.a.a.fQ(11, this.rvY)) + f.a.a.a.S(12, this.rcq);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = bhp.a(aVar2); h > 0; h = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bww bww = (bww) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bww.jTv = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bww.jTu = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bww.rjC = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bww.rvV = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bww.lOH = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bww.rdo = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bww.rci = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bww.rvX = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bww.rgC = aVar3.vHC.rY();
                    return 0;
                case 10:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bww.six = flVar;
                    }
                    return 0;
                case 11:
                    bww.rvY = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bww.rcq = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
