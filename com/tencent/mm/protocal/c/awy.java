package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class awy extends a {
    public int rZZ;
    public b rgs;
    public String saa;
    public bhy sab;
    public int sac;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sab == null) {
                throw new f.a.a.b("Not all required fields were included: ClientKey");
            }
            aVar.fT(1, this.rZZ);
            if (this.rgs != null) {
                aVar.b(2, this.rgs);
            }
            if (this.saa != null) {
                aVar.g(3, this.saa);
            }
            if (this.sab != null) {
                aVar.fV(4, this.sab.boi());
                this.sab.a(aVar);
            }
            aVar.fT(5, this.sac);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rZZ) + 0;
            if (this.rgs != null) {
                fQ += f.a.a.a.a(2, this.rgs);
            }
            if (this.saa != null) {
                fQ += f.a.a.b.b.a.h(3, this.saa);
            }
            if (this.sab != null) {
                fQ += f.a.a.a.fS(4, this.sab.boi());
            }
            return fQ + f.a.a.a.fQ(5, this.sac);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.sab != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: ClientKey");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            awy awy = (awy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awy.rZZ = aVar3.vHC.rY();
                    return 0;
                case 2:
                    awy.rgs = aVar3.cJR();
                    return 0;
                case 3:
                    awy.saa = aVar3.vHC.readString();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        awy.sab = bhy;
                    }
                    return 0;
                case 5:
                    awy.sac = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
