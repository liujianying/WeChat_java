package com.tencent.mm.br;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bk.a {
    public LinkedList<d> sLn = new LinkedList();
    public LinkedList<c> sLo = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(3, 8, this.sLn);
            aVar.d(4, 8, this.sLo);
            return 0;
        } else if (i == 1) {
            return (f.a.a.a.c(3, 8, this.sLn) + 0) + f.a.a.a.c(4, 8, this.sLo);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.sLn.clear();
                this.sLo.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = com.tencent.mm.bk.a.a(aVar2); a > 0; a = com.tencent.mm.bk.a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                a aVar4 = (a) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList IC;
                int size;
                f.a.a.a.a aVar5;
                boolean z;
                switch (intValue) {
                    case 3:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            d dVar = new d();
                            aVar5 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = dVar.a(aVar5, dVar, com.tencent.mm.bk.a.a(aVar5))) {
                            }
                            aVar4.sLn.add(dVar);
                        }
                        return 0;
                    case 4:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            c cVar = new c();
                            aVar5 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = cVar.a(aVar5, cVar, com.tencent.mm.bk.a.a(aVar5))) {
                            }
                            aVar4.sLo.add(cVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
