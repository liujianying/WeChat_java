package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bko extends bhd {
    public int hbF;
    public LinkedList<ato> hbG = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            aVar.fT(1, this.hbF);
            aVar.d(2, 8, this.hbG);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.fQ(1, this.hbF) + 0) + f.a.a.a.c(2, 8, this.hbG);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.hbG.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = bhd.a(aVar2); a > 0; a = bhd.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                bko bko = (bko) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        bko.hbF = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            ato ato = new ato();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = ato.a(aVar4, ato, bhd.a(aVar4))) {
                            }
                            bko.hbG.add(ato);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
