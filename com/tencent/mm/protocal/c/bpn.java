package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bpn extends a {
    public int sij;
    public int snB;
    public LinkedList<bou> snC = new LinkedList();
    public int snD;
    public int snE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.snB);
            aVar.d(2, 8, this.snC);
            aVar.fT(3, this.snD);
            aVar.fT(4, this.sij);
            aVar.fT(5, this.snE);
            return 0;
        } else if (i == 1) {
            return ((((f.a.a.a.fQ(1, this.snB) + 0) + f.a.a.a.c(2, 8, this.snC)) + f.a.a.a.fQ(3, this.snD)) + f.a.a.a.fQ(4, this.sij)) + f.a.a.a.fQ(5, this.snE);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.snC.clear();
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
                bpn bpn = (bpn) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        bpn.snB = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            bou bou = new bou();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = bou.a(aVar4, bou, a.a(aVar4))) {
                            }
                            bpn.snC.add(bou);
                        }
                        return 0;
                    case 3:
                        bpn.snD = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        bpn.sij = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        bpn.snE = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
