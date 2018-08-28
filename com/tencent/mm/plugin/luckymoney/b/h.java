package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class h extends a {
    public int jzh;
    public int kPV;
    public LinkedList<i> kQe = new LinkedList();
    public int kQk;
    public long kQl;
    public int kQm;
    public long kQn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.kQk);
            aVar.T(2, this.kQl);
            aVar.fT(3, this.kQm);
            aVar.T(4, this.kQn);
            aVar.fT(5, this.jzh);
            aVar.fT(6, this.kPV);
            aVar.d(7, 8, this.kQe);
            return 0;
        } else if (i == 1) {
            return ((((((f.a.a.a.fQ(1, this.kQk) + 0) + f.a.a.a.S(2, this.kQl)) + f.a.a.a.fQ(3, this.kQm)) + f.a.a.a.S(4, this.kQn)) + f.a.a.a.fQ(5, this.jzh)) + f.a.a.a.fQ(6, this.kPV)) + f.a.a.a.c(7, 8, this.kQe);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.kQe.clear();
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
                h hVar = (h) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        hVar.kQk = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        hVar.kQl = aVar3.vHC.rZ();
                        return 0;
                    case 3:
                        hVar.kQm = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        hVar.kQn = aVar3.vHC.rZ();
                        return 0;
                    case 5:
                        hVar.jzh = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        hVar.kPV = aVar3.vHC.rY();
                        return 0;
                    case 7:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            i iVar = new i();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                            }
                            hVar.kQe.add(iVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
