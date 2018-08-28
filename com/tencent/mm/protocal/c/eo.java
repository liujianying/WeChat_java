package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class eo extends a {
    public bhy reY;
    public sx reZ;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.reY == null) {
                throw new b("Not all required fields were included: AesEncryptKey");
            }
            if (this.reY != null) {
                aVar.fV(2, this.reY.boi());
                this.reY.a(aVar);
            }
            if (this.reZ == null) {
                return 0;
            }
            aVar.fV(3, this.reZ.boi());
            this.reZ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.reY != null) {
                fS = f.a.a.a.fS(2, this.reY.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.reZ != null) {
                fS += f.a.a.a.fS(3, this.reZ.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.reY != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AesEncryptKey");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            eo eoVar = (eo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            a bhy;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        eoVar.reY = bhy;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new sx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        eoVar.reZ = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
