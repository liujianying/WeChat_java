package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class atm extends a {
    public String bSc;
    public String rWQ;
    public String rWR;
    public String rWS;
    public int rWT;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bSc == null) {
                throw new b("Not all required fields were included: wording");
            }
            aVar.fT(1, this.type);
            if (this.bSc != null) {
                aVar.g(2, this.bSc);
            }
            if (this.url != null) {
                aVar.g(3, this.url);
            }
            if (this.rWQ != null) {
                aVar.g(4, this.rWQ);
            }
            if (this.rWR != null) {
                aVar.g(5, this.rWR);
            }
            if (this.rWS != null) {
                aVar.g(6, this.rWS);
            }
            aVar.fT(7, this.rWT);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.type) + 0;
            if (this.bSc != null) {
                fQ += f.a.a.b.b.a.h(2, this.bSc);
            }
            if (this.url != null) {
                fQ += f.a.a.b.b.a.h(3, this.url);
            }
            if (this.rWQ != null) {
                fQ += f.a.a.b.b.a.h(4, this.rWQ);
            }
            if (this.rWR != null) {
                fQ += f.a.a.b.b.a.h(5, this.rWR);
            }
            if (this.rWS != null) {
                fQ += f.a.a.b.b.a.h(6, this.rWS);
            }
            return fQ + f.a.a.a.fQ(7, this.rWT);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.bSc != null) {
                return 0;
            }
            throw new b("Not all required fields were included: wording");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            atm atm = (atm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atm.type = aVar3.vHC.rY();
                    return 0;
                case 2:
                    atm.bSc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    atm.url = aVar3.vHC.readString();
                    return 0;
                case 4:
                    atm.rWQ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    atm.rWR = aVar3.vHC.readString();
                    return 0;
                case 6:
                    atm.rWS = aVar3.vHC.readString();
                    return 0;
                case 7:
                    atm.rWT = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
