package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class o extends a {
    public String ID;
    public long hbV;
    public m hbY;
    public int hca;
    public long hcb;
    public long hcc;
    public int hcd;
    public int hce;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.g(1, this.ID);
            }
            aVar.T(2, this.hcb);
            aVar.T(3, this.hcc);
            aVar.fT(4, this.hcd);
            aVar.fT(5, this.hce);
            aVar.T(6, this.hbV);
            if (this.hbY != null) {
                aVar.fV(7, this.hbY.boi());
                this.hbY.a(aVar);
            }
            aVar.fT(8, this.hca);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                h = f.a.a.b.b.a.h(1, this.ID) + 0;
            } else {
                h = 0;
            }
            h = ((((h + f.a.a.a.S(2, this.hcb)) + f.a.a.a.S(3, this.hcc)) + f.a.a.a.fQ(4, this.hcd)) + f.a.a.a.fQ(5, this.hce)) + f.a.a.a.S(6, this.hbV);
            if (this.hbY != null) {
                h += f.a.a.a.fS(7, this.hbY.boi());
            }
            return h + f.a.a.a.fQ(8, this.hca);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    oVar.ID = aVar3.vHC.readString();
                    return 0;
                case 2:
                    oVar.hcb = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    oVar.hcc = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    oVar.hcd = aVar3.vHC.rY();
                    return 0;
                case 5:
                    oVar.hce = aVar3.vHC.rY();
                    return 0;
                case 6:
                    oVar.hbV = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        m mVar = new m();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        oVar.hbY = mVar;
                    }
                    return 0;
                case 8:
                    oVar.hca = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
