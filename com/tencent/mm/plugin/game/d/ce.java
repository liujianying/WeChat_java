package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ce extends a {
    public String bHD;
    public String jQf;
    public LinkedList<ck> jSG = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jQf == null) {
                throw new b("Not all required fields were included: Detail");
            } else {
                if (this.bHD != null) {
                    aVar.g(1, this.bHD);
                }
                aVar.d(2, 8, this.jSG);
                if (this.jQf == null) {
                    return 0;
                }
                aVar.g(3, this.jQf);
                return 0;
            }
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.c(2, 8, this.jSG);
            if (this.jQf != null) {
                h += f.a.a.b.b.a.h(3, this.jQf);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jSG.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jQf != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Detail");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ce ceVar = (ce) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ceVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ck ckVar = new ck();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ckVar.a(aVar4, ckVar, a.a(aVar4))) {
                        }
                        ceVar.jSG.add(ckVar);
                    }
                    return 0;
                case 3:
                    ceVar.jQf = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
