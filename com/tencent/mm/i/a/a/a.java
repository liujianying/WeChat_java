package com.tencent.mm.i.a.a;

import java.util.LinkedList;

public final class a extends com.tencent.mm.bk.a {
    public int bUd;
    public int bWA;
    public LinkedList<b> dav = new LinkedList();
    public int daw;
    public String dax;
    public int daz;
    public int status;
    public int type;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.dav);
            aVar.fT(2, this.bWA);
            aVar.fT(3, this.type);
            aVar.fT(4, this.status);
            aVar.fT(5, this.daw);
            if (this.dax != null) {
                aVar.g(6, this.dax);
            }
            aVar.fT(7, this.bUd);
            aVar.fT(8, this.daz);
            return 0;
        } else if (i == 1) {
            c = ((((f.a.a.a.c(1, 8, this.dav) + 0) + f.a.a.a.fQ(2, this.bWA)) + f.a.a.a.fQ(3, this.type)) + f.a.a.a.fQ(4, this.status)) + f.a.a.a.fQ(5, this.daw);
            if (this.dax != null) {
                c += f.a.a.b.b.a.h(6, this.dax);
            }
            return (c + f.a.a.a.fQ(7, this.bUd)) + f.a.a.a.fQ(8, this.daz);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.dav.clear();
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
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a bVar = new b();
                        f.a.a.a.a aVar5 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.bk.a.a(aVar5))) {
                        }
                        aVar4.dav.add(bVar);
                    }
                    return 0;
                case 2:
                    aVar4.bWA = aVar3.vHC.rY();
                    return 0;
                case 3:
                    aVar4.type = aVar3.vHC.rY();
                    return 0;
                case 4:
                    aVar4.status = aVar3.vHC.rY();
                    return 0;
                case 5:
                    aVar4.daw = aVar3.vHC.rY();
                    return 0;
                case 6:
                    aVar4.dax = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aVar4.bUd = aVar3.vHC.rY();
                    return 0;
                case 8:
                    aVar4.daz = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
