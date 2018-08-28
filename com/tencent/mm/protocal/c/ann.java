package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ann extends a {
    public int bVY;
    public String rQh;
    public String rQl;
    public String rQm;
    public String rQn;
    public ayw rQo;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rQh == null) {
                throw new b("Not all required fields were included: session_data");
            }
            aVar.fT(1, this.bVY);
            if (this.rQh != null) {
                aVar.g(2, this.rQh);
            }
            if (this.rQl != null) {
                aVar.g(3, this.rQl);
            }
            if (this.rQm != null) {
                aVar.g(4, this.rQm);
            }
            if (this.rQn != null) {
                aVar.g(5, this.rQn);
            }
            if (this.rQo != null) {
                aVar.fV(6, this.rQo.boi());
                this.rQo.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.bVY) + 0;
            if (this.rQh != null) {
                fQ += f.a.a.b.b.a.h(2, this.rQh);
            }
            if (this.rQl != null) {
                fQ += f.a.a.b.b.a.h(3, this.rQl);
            }
            if (this.rQm != null) {
                fQ += f.a.a.b.b.a.h(4, this.rQm);
            }
            if (this.rQn != null) {
                fQ += f.a.a.b.b.a.h(5, this.rQn);
            }
            if (this.rQo != null) {
                return fQ + f.a.a.a.fS(6, this.rQo.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rQh != null) {
                return 0;
            }
            throw new b("Not all required fields were included: session_data");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ann ann = (ann) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ann.bVY = aVar3.vHC.rY();
                    return 0;
                case 2:
                    ann.rQh = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ann.rQl = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ann.rQm = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ann.rQn = aVar3.vHC.readString();
                    return 0;
                case 6:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        ayw ayw = new ayw();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ayw.a(aVar4, ayw, a.a(aVar4))) {
                        }
                        ann.rQo = ayw;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
