package com.tencent.mm.plugin.wallet.a;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bk.a {
    public LinkedList<b> pdN = new LinkedList();
    public k pdO;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.pdN);
            if (this.pdO != null) {
                aVar.fV(2, this.pdO.boi());
                this.pdO.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.pdN) + 0;
            if (this.pdO != null) {
                return c + f.a.a.a.fS(2, this.pdO.boi());
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pdN.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = com.tencent.mm.bk.a.a(aVar2); c > 0; c = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
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
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        b bVar = new b();
                        aVar5 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.bk.a.a(aVar5))) {
                        }
                        aVar4.pdN.add(bVar);
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        k kVar = new k();
                        aVar5 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kVar.a(aVar5, kVar, com.tencent.mm.bk.a.a(aVar5))) {
                        }
                        aVar4.pdO = kVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
