package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class aq extends a {
    public LinkedList<String> jQY = new LinkedList();
    public String jQf;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQf == null) {
                throw new b("Not all required fields were included: Detail");
            }
            if (this.jQf != null) {
                aVar.g(2, this.jQf);
            }
            aVar.d(3, 1, this.jQY);
            return 0;
        } else if (i == 1) {
            if (this.jQf != null) {
                h = f.a.a.b.b.a.h(2, this.jQf) + 0;
            } else {
                h = 0;
            }
            return h + f.a.a.a.c(3, 1, this.jQY);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.jQY.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jQf != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Detail");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aq aqVar = (aq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    aqVar.jQf = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aqVar.jQY.add(aVar3.vHC.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
