package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cbz extends a {
    public caz sxO;
    public cbq sxY;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sxO == null) {
                throw new b("Not all required fields were included: base_response");
            }
            if (this.sxO != null) {
                aVar.fV(1, this.sxO.boi());
                this.sxO.a(aVar);
            }
            if (this.sxY == null) {
                return 0;
            }
            aVar.fV(2, this.sxY.boi());
            this.sxY.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.sxO != null) {
                fS = f.a.a.a.fS(1, this.sxO.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.sxY != null) {
                fS += f.a.a.a.fS(2, this.sxY.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.sxO != null) {
                return 0;
            }
            throw new b("Not all required fields were included: base_response");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cbz cbz = (cbz) objArr[1];
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
                        caz caz = new caz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = caz.a(aVar4, caz, a.a(aVar4))) {
                        }
                        cbz.sxO = caz;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cbq cbq = new cbq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbq.a(aVar4, cbq, a.a(aVar4))) {
                        }
                        cbz.sxY = cbq;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
