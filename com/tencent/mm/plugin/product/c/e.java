package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bk.a;

public final class e extends a {
    public int id;
    public String name;
    public int value;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.id);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            aVar.fT(3, this.value);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.id) + 0;
            if (this.name != null) {
                fQ += f.a.a.b.b.a.h(2, this.name);
            }
            return fQ + f.a.a.a.fQ(3, this.value);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.id = aVar3.vHC.rY();
                    return 0;
                case 2:
                    eVar.name = aVar3.vHC.readString();
                    return 0;
                case 3:
                    eVar.value = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
