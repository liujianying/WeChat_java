package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class th extends a {
    public ts rwE;
    public ti rwF;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rwE == null) {
                throw new b("Not all required fields were included: BannerSummary");
            } else if (this.rwF == null) {
                throw new b("Not all required fields were included: BannerImg");
            } else {
                if (this.rwE != null) {
                    aVar.fV(1, this.rwE.boi());
                    this.rwE.a(aVar);
                }
                if (this.rwF == null) {
                    return 0;
                }
                aVar.fV(2, this.rwF.boi());
                this.rwF.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.rwE != null) {
                fS = f.a.a.a.fS(1, this.rwE.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rwF != null) {
                fS += f.a.a.a.fS(2, this.rwF.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rwE == null) {
                throw new b("Not all required fields were included: BannerSummary");
            } else if (this.rwF != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BannerImg");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            th thVar = (th) objArr[1];
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
                        ts tsVar = new ts();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tsVar.a(aVar4, tsVar, a.a(aVar4))) {
                        }
                        thVar.rwE = tsVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ti tiVar = new ti();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tiVar.a(aVar4, tiVar, a.a(aVar4))) {
                        }
                        thVar.rwF = tiVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
