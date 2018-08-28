package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class iw extends a {
    public String riK;
    public LinkedList<String> rkj = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.riK == null) {
                throw new b("Not all required fields were included: brand_user_name");
            }
            if (this.riK != null) {
                aVar.g(2, this.riK);
            }
            aVar.d(3, 1, this.rkj);
            return 0;
        } else if (i == 1) {
            if (this.riK != null) {
                h = f.a.a.b.b.a.h(2, this.riK) + 0;
            } else {
                h = 0;
            }
            return h + f.a.a.a.c(3, 1, this.rkj);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.rkj.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.riK != null) {
                return 0;
            }
            throw new b("Not all required fields were included: brand_user_name");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            iw iwVar = (iw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    iwVar.riK = aVar3.vHC.readString();
                    return 0;
                case 3:
                    iwVar.rkj.add(aVar3.vHC.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
