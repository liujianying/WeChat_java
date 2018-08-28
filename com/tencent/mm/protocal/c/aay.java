package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class aay extends a implements bnu {
    public int rGc;
    public int rGd;
    public int rGe;
    public LinkedList<bhz> rGf = new LinkedList();
    public int rfn;

    public final int getRet() {
        return this.rfn;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rfn);
            aVar.fT(2, this.rGc);
            aVar.fT(3, this.rGd);
            aVar.fT(4, this.rGe);
            aVar.d(5, 8, this.rGf);
            return 0;
        } else if (i == 1) {
            return ((((f.a.a.a.fQ(1, this.rfn) + 0) + f.a.a.a.fQ(2, this.rGc)) + f.a.a.a.fQ(3, this.rGd)) + f.a.a.a.fQ(4, this.rGe)) + f.a.a.a.c(5, 8, this.rGf);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.rGf.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                aay aay = (aay) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        aay.rfn = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        aay.rGc = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        aay.rGd = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        aay.rGe = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            bhz bhz = new bhz();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                            }
                            aay.rGf.add(bhz);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
