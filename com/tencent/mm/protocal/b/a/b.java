package com.tencent.mm.protocal.b.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class b extends a {
    public String bIr;
    public int id;
    public LinkedList<a> qXY = new LinkedList();
    public String title;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.id);
            if (this.title != null) {
                aVar.g(2, this.title);
            }
            if (this.bIr != null) {
                aVar.g(3, this.bIr);
            }
            aVar.d(4, 8, this.qXY);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.id) + 0;
            if (this.title != null) {
                fQ += f.a.a.b.b.a.h(2, this.title);
            }
            if (this.bIr != null) {
                fQ += f.a.a.b.b.a.h(3, this.bIr);
            }
            return fQ + f.a.a.a.c(4, 8, this.qXY);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qXY.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.id = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bVar.title = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bVar.bIr = aVar3.vHC.readString();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        a aVar4 = new a();
                        f.a.a.a.a aVar5 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        bVar.qXY.add(aVar4);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
