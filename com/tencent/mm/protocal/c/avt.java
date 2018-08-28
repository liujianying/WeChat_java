package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class avt extends a {
    public amt rhJ;
    public iz rhK;
    public avs rhL;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rhJ != null) {
                aVar.fV(1, this.rhJ.boi());
                this.rhJ.a(aVar);
            }
            if (this.rhL != null) {
                aVar.fV(2, this.rhL.boi());
                this.rhL.a(aVar);
            }
            if (this.rhK == null) {
                return 0;
            }
            aVar.fV(3, this.rhK.boi());
            this.rhK.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.rhJ != null) {
                fS = f.a.a.a.fS(1, this.rhJ.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rhL != null) {
                fS += f.a.a.a.fS(2, this.rhL.boi());
            }
            if (this.rhK != null) {
                fS += f.a.a.a.fS(3, this.rhK.boi());
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
            avt avt = (avt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            a amt;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amt = new amt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amt.a(aVar4, amt, a.a(aVar4))) {
                        }
                        avt.rhJ = amt;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amt = new avs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amt.a(aVar4, amt, a.a(aVar4))) {
                        }
                        avt.rhL = amt;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amt = new iz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amt.a(aVar4, amt, a.a(aVar4))) {
                        }
                        avt.rhK = amt;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
