package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bps extends a {
    public int hbF;
    public LinkedList<bhz> hbG = new LinkedList();
    public String jSt;
    public long snO;

    protected final int a(int i, Object... objArr) {
        int S;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.snO);
            if (this.jSt != null) {
                aVar.g(2, this.jSt);
            }
            aVar.fT(3, this.hbF);
            aVar.d(4, 8, this.hbG);
            return 0;
        } else if (i == 1) {
            S = f.a.a.a.S(1, this.snO) + 0;
            if (this.jSt != null) {
                S += f.a.a.b.b.a.h(2, this.jSt);
            }
            return (S + f.a.a.a.fQ(3, this.hbF)) + f.a.a.a.c(4, 8, this.hbG);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.hbG.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bps bps = (bps) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bps.snO = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    bps.jSt = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bps.hbF = aVar3.vHC.rY();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bps.hbG.add(bhz);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
