package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class aef extends a {
    public int rIr;
    public int rIs;
    public alx rgS;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rgS == null) {
                throw new b("Not all required fields were included: Device");
            }
            aVar.fT(1, this.rIr);
            aVar.fT(2, this.rIs);
            if (this.rgS != null) {
                aVar.fV(3, this.rgS.boi());
                this.rgS.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.rIr) + 0) + f.a.a.a.fQ(2, this.rIs);
            if (this.rgS != null) {
                return fQ + f.a.a.a.fS(3, this.rgS.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rgS != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Device");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aef aef = (aef) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aef.rIr = aVar3.vHC.rY();
                    return 0;
                case 2:
                    aef.rIs = aVar3.vHC.rY();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        alx alx = new alx();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = alx.a(aVar4, alx, a.a(aVar4))) {
                        }
                        aef.rgS = alx;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
