package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public class l extends a {
    public String lRR;
    public int lRS;
    public LinkedList<e> lRT = new LinkedList();
    public int lRn;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lRR == null) {
                throw new b("Not all required fields were included: id_info");
            }
            if (this.lRR != null) {
                aVar.g(1, this.lRR);
            }
            aVar.fT(2, this.lRS);
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            aVar.d(4, 8, this.lRT);
            aVar.fT(5, this.lRn);
            return 0;
        } else if (i == 1) {
            if (this.lRR != null) {
                h = f.a.a.b.b.a.h(1, this.lRR) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.lRS);
            if (this.url != null) {
                h += f.a.a.b.b.a.h(3, this.url);
            }
            return (h + f.a.a.a.c(4, 8, this.lRT)) + f.a.a.a.fQ(5, this.lRn);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.lRT.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.lRR != null) {
                return 0;
            }
            throw new b("Not all required fields were included: id_info");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lVar.lRR = aVar3.vHC.readString();
                    return 0;
                case 2:
                    lVar.lRS = aVar3.vHC.rY();
                    return 0;
                case 3:
                    lVar.url = aVar3.vHC.readString();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        lVar.lRT.add(eVar);
                    }
                    return 0;
                case 5:
                    lVar.lRn = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
