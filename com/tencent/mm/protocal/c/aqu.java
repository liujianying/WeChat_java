package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aqu extends bhp {
    public int noH;
    public int rHb;
    public LinkedList<aqp> rHc = new LinkedList();
    public int rTs;
    public int rTt;
    public int rTu;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.rHb);
            aVar.d(3, 8, this.rHc);
            aVar.fT(4, this.noH);
            aVar.fT(5, this.rTs);
            aVar.fT(6, this.rTt);
            aVar.fT(7, this.rTu);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return (((((fS + f.a.a.a.fQ(2, this.rHb)) + f.a.a.a.c(3, 8, this.rHc)) + f.a.a.a.fQ(4, this.noH)) + f.a.a.a.fQ(5, this.rTs)) + f.a.a.a.fQ(6, this.rTt)) + f.a.a.a.fQ(7, this.rTu);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rHc.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
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
            aqu aqu = (aqu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        aqu.six = flVar;
                    }
                    return 0;
                case 2:
                    aqu.rHb = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqp aqp = new aqp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqp.a(aVar4, aqp, bhp.a(aVar4))) {
                        }
                        aqu.rHc.add(aqp);
                    }
                    return 0;
                case 4:
                    aqu.noH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    aqu.rTs = aVar3.vHC.rY();
                    return 0;
                case 6:
                    aqu.rTt = aVar3.vHC.rY();
                    return 0;
                case 7:
                    aqu.rTu = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
