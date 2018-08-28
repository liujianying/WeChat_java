package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class aun extends a {
    public int rXH;
    public alx rhk;
    public aly rhl;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rhk == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.rhl == null) {
                throw new b("Not all required fields were included: HardDeviceAttr");
            } else {
                if (this.rhk != null) {
                    aVar.fV(1, this.rhk.boi());
                    this.rhk.a(aVar);
                }
                if (this.rhl != null) {
                    aVar.fV(2, this.rhl.boi());
                    this.rhl.a(aVar);
                }
                aVar.fT(3, this.rXH);
                return 0;
            }
        } else if (i == 1) {
            if (this.rhk != null) {
                fS = f.a.a.a.fS(1, this.rhk.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rhl != null) {
                fS += f.a.a.a.fS(2, this.rhl.boi());
            }
            return fS + f.a.a.a.fQ(3, this.rXH);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rhk == null) {
                throw new b("Not all required fields were included: HardDevice");
            } else if (this.rhl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: HardDeviceAttr");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aun aun = (aun) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        alx alx = new alx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alx.a(aVar4, alx, a.a(aVar4))) {
                        }
                        aun.rhk = alx;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aly aly = new aly();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aly.a(aVar4, aly, a.a(aVar4))) {
                        }
                        aun.rhl = aly;
                    }
                    return 0;
                case 3:
                    aun.rXH = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
