package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class yc extends a {
    public xv rDZ;
    public LinkedList<String> rEa = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rDZ == null) {
                throw new b("Not all required fields were included: GameItem");
            }
            if (this.rDZ != null) {
                aVar.fV(1, this.rDZ.boi());
                this.rDZ.a(aVar);
            }
            aVar.d(2, 1, this.rEa);
            return 0;
        } else if (i == 1) {
            if (this.rDZ != null) {
                fS = f.a.a.a.fS(1, this.rDZ.boi()) + 0;
            } else {
                fS = 0;
            }
            return fS + f.a.a.a.c(2, 1, this.rEa);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rEa.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rDZ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: GameItem");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            yc ycVar = (yc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xv xvVar = new xv();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = xvVar.a(aVar4, xvVar, a.a(aVar4))) {
                        }
                        ycVar.rDZ = xvVar;
                    }
                    return 0;
                case 2:
                    ycVar.rEa.add(aVar3.vHC.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
