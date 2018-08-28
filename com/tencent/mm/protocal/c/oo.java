package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class oo extends a {
    public String rsP;
    public String rsQ;
    public LinkedList<bsw> rsR = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rsP == null) {
                throw new b("Not all required fields were included: baseid");
            }
            if (this.rsP != null) {
                aVar.g(1, this.rsP);
            }
            if (this.rsQ != null) {
                aVar.g(2, this.rsQ);
            }
            aVar.d(3, 8, this.rsR);
            return 0;
        } else if (i == 1) {
            if (this.rsP != null) {
                h = f.a.a.b.b.a.h(1, this.rsP) + 0;
            } else {
                h = 0;
            }
            if (this.rsQ != null) {
                h += f.a.a.b.b.a.h(2, this.rsQ);
            }
            return h + f.a.a.a.c(3, 8, this.rsR);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rsR.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rsP != null) {
                return 0;
            }
            throw new b("Not all required fields were included: baseid");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            oo ooVar = (oo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ooVar.rsP = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ooVar.rsQ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bsw bsw = new bsw();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bsw.a(aVar4, bsw, a.a(aVar4))) {
                        }
                        ooVar.rsR.add(bsw);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
