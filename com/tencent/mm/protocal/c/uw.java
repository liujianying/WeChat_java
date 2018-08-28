package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class uw extends a {
    public String rya;
    public String ryl;
    public LinkedList<String> rym = new LinkedList();
    public boolean ryn;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rya == null) {
                throw new b("Not all required fields were included: LoginUrl");
            }
            if (this.rya != null) {
                aVar.g(1, this.rya);
            }
            if (this.ryl != null) {
                aVar.g(2, this.ryl);
            }
            aVar.d(3, 1, this.rym);
            aVar.av(4, this.ryn);
            return 0;
        } else if (i == 1) {
            if (this.rya != null) {
                h = f.a.a.b.b.a.h(1, this.rya) + 0;
            } else {
                h = 0;
            }
            if (this.ryl != null) {
                h += f.a.a.b.b.a.h(2, this.ryl);
            }
            return (h + f.a.a.a.c(3, 1, this.rym)) + (f.a.a.b.b.a.ec(4) + 1);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.rym.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rya != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LoginUrl");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            uw uwVar = (uw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uwVar.rya = aVar3.vHC.readString();
                    return 0;
                case 2:
                    uwVar.ryl = aVar3.vHC.readString();
                    return 0;
                case 3:
                    uwVar.rym.add(aVar3.vHC.readString());
                    return 0;
                case 4:
                    uwVar.ryn = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
