package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bk.a;
import com.tencent.mm.protocal.c.boi;
import f.a.a.b;
import java.util.LinkedList;

public final class e extends a {
    public boi nnO;
    public String nuY;
    public int nuZ;
    public String nva;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.nuY == null) {
                throw new b("Not all required fields were included: clientID");
            } else if (this.nnO == null) {
                throw new b("Not all required fields were included: actionGroup");
            } else {
                if (this.nuY != null) {
                    aVar.g(1, this.nuY);
                }
                if (this.nnO != null) {
                    aVar.fV(2, this.nnO.boi());
                    this.nnO.a(aVar);
                }
                aVar.fT(3, this.nuZ);
                if (this.nva == null) {
                    return 0;
                }
                aVar.g(4, this.nva);
                return 0;
            }
        } else if (i == 1) {
            if (this.nuY != null) {
                h = f.a.a.b.b.a.h(1, this.nuY) + 0;
            } else {
                h = 0;
            }
            if (this.nnO != null) {
                h += f.a.a.a.fS(2, this.nnO.boi());
            }
            h += f.a.a.a.fQ(3, this.nuZ);
            if (this.nva != null) {
                h += f.a.a.b.b.a.h(4, this.nva);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.nuY == null) {
                throw new b("Not all required fields were included: clientID");
            } else if (this.nnO != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: actionGroup");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.nuY = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        boi boi = new boi();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = boi.a(aVar4, boi, a.a(aVar4))) {
                        }
                        eVar.nnO = boi;
                    }
                    return 0;
                case 3:
                    eVar.nuZ = aVar3.vHC.rY();
                    return 0;
                case 4:
                    eVar.nva = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
