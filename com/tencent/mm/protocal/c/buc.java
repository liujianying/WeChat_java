package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class buc extends a {
    public bhy rEB;
    public int rfn;
    public int srA;
    public int srv;
    public String sry;
    public String srz;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.srv);
            if (this.sry != null) {
                aVar.g(2, this.sry);
            }
            aVar.fT(3, this.rfn);
            if (this.srz != null) {
                aVar.g(4, this.srz);
            }
            if (this.rEB != null) {
                aVar.fV(5, this.rEB.boi());
                this.rEB.a(aVar);
            }
            aVar.fT(6, this.srA);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.srv) + 0;
            if (this.sry != null) {
                fQ += f.a.a.b.b.a.h(2, this.sry);
            }
            fQ += f.a.a.a.fQ(3, this.rfn);
            if (this.srz != null) {
                fQ += f.a.a.b.b.a.h(4, this.srz);
            }
            if (this.rEB != null) {
                fQ += f.a.a.a.fS(5, this.rEB.boi());
            }
            return fQ + f.a.a.a.fQ(6, this.srA);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            buc buc = (buc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    buc.srv = aVar3.vHC.rY();
                    return 0;
                case 2:
                    buc.sry = aVar3.vHC.readString();
                    return 0;
                case 3:
                    buc.rfn = aVar3.vHC.rY();
                    return 0;
                case 4:
                    buc.srz = aVar3.vHC.readString();
                    return 0;
                case 5:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        buc.rEB = bhy;
                    }
                    return 0;
                case 6:
                    buc.srA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
