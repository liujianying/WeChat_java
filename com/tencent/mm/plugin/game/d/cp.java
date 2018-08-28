package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cp extends a {
    public LinkedList<cq> jSY = new LinkedList();
    public String jSZ;
    public String jSo;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.jSY);
            if (this.jSo != null) {
                aVar.g(2, this.jSo);
            }
            if (this.jSZ != null) {
                aVar.g(3, this.jSZ);
            }
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.jSY) + 0;
            if (this.jSo != null) {
                c += f.a.a.b.b.a.h(2, this.jSo);
            }
            if (this.jSZ != null) {
                return c + f.a.a.b.b.a.h(3, this.jSZ);
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jSY.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cp cpVar = (cp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cq cqVar = new cq();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cqVar.a(aVar4, cqVar, a.a(aVar4))) {
                        }
                        cpVar.jSY.add(cqVar);
                    }
                    return 0;
                case 2:
                    cpVar.jSo = aVar3.vHC.readString();
                    return 0;
                case 3:
                    cpVar.jSZ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
