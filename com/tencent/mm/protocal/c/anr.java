package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class anr extends bhd {
    public String rQt;
    public LinkedList<String> rQu = new LinkedList();
    public String ruF;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ruF == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.rQt == null) {
                throw new b("Not all required fields were included: bizchat_name");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.ruF != null) {
                    aVar.g(2, this.ruF);
                }
                if (this.rQt != null) {
                    aVar.g(3, this.rQt);
                }
                aVar.d(4, 1, this.rQu);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ruF != null) {
                fS += f.a.a.b.b.a.h(2, this.ruF);
            }
            if (this.rQt != null) {
                fS += f.a.a.b.b.a.h(3, this.rQt);
            }
            return fS + f.a.a.a.c(4, 1, this.rQu);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rQu.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ruF == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.rQt != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bizchat_name");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            anr anr = (anr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        anr.shX = fkVar;
                    }
                    return 0;
                case 2:
                    anr.ruF = aVar3.vHC.readString();
                    return 0;
                case 3:
                    anr.rQt = aVar3.vHC.readString();
                    return 0;
                case 4:
                    anr.rQu.add(aVar3.vHC.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
