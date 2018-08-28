package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bub extends a {
    public int otY;
    public bhy rEB;
    public int srv;
    public String srw;
    public String srx;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.srv);
            if (this.srw != null) {
                aVar.g(2, this.srw);
            }
            if (this.srx != null) {
                aVar.g(3, this.srx);
            }
            aVar.fT(4, this.otY);
            if (this.rEB != null) {
                aVar.fV(5, this.rEB.boi());
                this.rEB.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.srv) + 0;
            if (this.srw != null) {
                fQ += f.a.a.b.b.a.h(2, this.srw);
            }
            if (this.srx != null) {
                fQ += f.a.a.b.b.a.h(3, this.srx);
            }
            fQ += f.a.a.a.fQ(4, this.otY);
            if (this.rEB != null) {
                return fQ + f.a.a.a.fS(5, this.rEB.boi());
            }
            return fQ;
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
            bub bub = (bub) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bub.srv = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bub.srw = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bub.srx = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bub.otY = aVar3.vHC.rY();
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
                        bub.rEB = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
