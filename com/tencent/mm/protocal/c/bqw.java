package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bqw extends a {
    public bqx soW;
    public bqv soX;
    public bqu soY;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.soW != null) {
                aVar.fV(1, this.soW.boi());
                this.soW.a(aVar);
            }
            if (this.soX != null) {
                aVar.fV(2, this.soX.boi());
                this.soX.a(aVar);
            }
            if (this.soY == null) {
                return 0;
            }
            aVar.fV(3, this.soY.boi());
            this.soY.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.soW != null) {
                fS = f.a.a.a.fS(1, this.soW.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.soX != null) {
                fS += f.a.a.a.fS(2, this.soX.boi());
            }
            if (this.soY != null) {
                fS += f.a.a.a.fS(3, this.soY.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bqw bqw = (bqw) objArr[1];
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
                        bqx bqx = new bqx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqx.a(aVar4, bqx, a.a(aVar4))) {
                        }
                        bqw.soW = bqx;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqv bqv = new bqv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqv.a(aVar4, bqv, a.a(aVar4))) {
                        }
                        bqw.soX = bqv;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqu bqu = new bqu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqu.a(aVar4, bqu, a.a(aVar4))) {
                        }
                        bqw.soY = bqu;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
