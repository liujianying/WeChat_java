package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class gi extends a {
    public LinkedList<gh> rgM = new LinkedList();
    public gg rgN;
    public int rgO;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.rgM);
            if (this.rgN != null) {
                aVar.fV(2, this.rgN.boi());
                this.rgN.a(aVar);
            }
            aVar.fT(3, this.rgO);
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.rgM) + 0;
            if (this.rgN != null) {
                c += f.a.a.a.fS(2, this.rgN.boi());
            }
            return c + f.a.a.a.fQ(3, this.rgO);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rgM.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            gi giVar = (gi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        gh ghVar = new gh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ghVar.a(aVar4, ghVar, a.a(aVar4))) {
                        }
                        giVar.rgM.add(ghVar);
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        gg ggVar = new gg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ggVar.a(aVar4, ggVar, a.a(aVar4))) {
                        }
                        giVar.rgN = ggVar;
                    }
                    return 0;
                case 3:
                    giVar.rgO = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
