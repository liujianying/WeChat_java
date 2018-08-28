package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cfq extends a {
    public cft sAh;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sAh == null) {
                throw new b("Not all required fields were included: DownloadInfo");
            } else if (this.sAh == null) {
                return 0;
            } else {
                aVar.fV(4, this.sAh.boi());
                this.sAh.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.sAh != null) {
                fS = f.a.a.a.fS(4, this.sAh.boi()) + 0;
            } else {
                fS = 0;
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.sAh != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DownloadInfo");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cfq cfq = (cfq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        cft cft = new cft();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cft.a(aVar4, cft, a.a(aVar4))) {
                        }
                        cfq.sAh = cft;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
