package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class iz extends a {
    public int rkm;
    public int rkn;
    public int rko;
    public LinkedList<iy> rkp = new LinkedList();
    public LinkedList<iy> rkq = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rkm);
            aVar.fT(2, this.rkn);
            aVar.fT(5, this.rko);
            aVar.d(3, 8, this.rkp);
            aVar.d(4, 8, this.rkq);
            return 0;
        } else if (i == 1) {
            return ((((f.a.a.a.fQ(1, this.rkm) + 0) + f.a.a.a.fQ(2, this.rkn)) + f.a.a.a.fQ(5, this.rko)) + f.a.a.a.c(3, 8, this.rkp)) + f.a.a.a.c(4, 8, this.rkq);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.rkp.clear();
                this.rkq.clear();
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
                iz izVar = (iz) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList IC;
                int size;
                a iyVar;
                f.a.a.a.a aVar4;
                boolean z;
                switch (intValue) {
                    case 1:
                        izVar.rkm = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        izVar.rkn = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            iyVar = new iy();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = iyVar.a(aVar4, iyVar, a.a(aVar4))) {
                            }
                            izVar.rkp.add(iyVar);
                        }
                        return 0;
                    case 4:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            iyVar = new iy();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = iyVar.a(aVar4, iyVar, a.a(aVar4))) {
                            }
                            izVar.rkq.add(iyVar);
                        }
                        return 0;
                    case 5:
                        izVar.rko = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
