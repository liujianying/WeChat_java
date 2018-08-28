package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class aei extends a {
    public int rIr;
    public int rfn;
    public alx rgS;
    public String rwj;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rfn);
            if (this.rgS != null) {
                aVar.fV(2, this.rgS.boi());
                this.rgS.a(aVar);
            }
            if (this.rwj != null) {
                aVar.g(3, this.rwj);
            }
            aVar.fT(4, this.rIr);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rfn) + 0;
            if (this.rgS != null) {
                fQ += f.a.a.a.fS(2, this.rgS.boi());
            }
            if (this.rwj != null) {
                fQ += f.a.a.b.b.a.h(3, this.rwj);
            }
            return fQ + f.a.a.a.fQ(4, this.rIr);
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
            aei aei = (aei) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aei.rfn = aVar3.vHC.rY();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        alx alx = new alx();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = alx.a(aVar4, alx, a.a(aVar4))) {
                        }
                        aei.rgS = alx;
                    }
                    return 0;
                case 3:
                    aei.rwj = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aei.rIr = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
