package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class afs extends a {
    public String aem;
    public String hva;
    public LinkedList<String> rJC = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.aem != null) {
                aVar.g(1, this.aem);
            }
            if (this.hva != null) {
                aVar.g(2, this.hva);
            }
            aVar.d(3, 1, this.rJC);
            return 0;
        } else if (i == 1) {
            if (this.aem != null) {
                h = f.a.a.b.b.a.h(1, this.aem) + 0;
            } else {
                h = 0;
            }
            if (this.hva != null) {
                h += f.a.a.b.b.a.h(2, this.hva);
            }
            return h + f.a.a.a.c(3, 1, this.rJC);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.rJC.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            afs afs = (afs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    afs.aem = aVar3.vHC.readString();
                    return 0;
                case 2:
                    afs.hva = aVar3.vHC.readString();
                    return 0;
                case 3:
                    afs.rJC.add(aVar3.vHC.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
