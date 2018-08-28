package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class m extends a {
    public String hbO;
    public String hbP;
    public String hbQ;
    public String hbR;
    public String hbS;
    public int hbT;
    public long hbU;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbO == null) {
                throw new b("Not all required fields were included: DeviceID");
            } else if (this.hbP == null) {
                throw new b("Not all required fields were included: DeviceName");
            } else if (this.hbQ == null) {
                throw new b("Not all required fields were included: Model");
            } else if (this.hbR == null) {
                throw new b("Not all required fields were included: SystemName");
            } else if (this.hbS == null) {
                throw new b("Not all required fields were included: SystemVersion");
            } else {
                if (this.hbO != null) {
                    aVar.g(1, this.hbO);
                }
                if (this.hbP != null) {
                    aVar.g(2, this.hbP);
                }
                if (this.hbQ != null) {
                    aVar.g(3, this.hbQ);
                }
                if (this.hbR != null) {
                    aVar.g(4, this.hbR);
                }
                if (this.hbS != null) {
                    aVar.g(5, this.hbS);
                }
                aVar.fT(6, this.hbT);
                aVar.T(7, this.hbU);
                return 0;
            }
        } else if (i == 1) {
            if (this.hbO != null) {
                h = f.a.a.b.b.a.h(1, this.hbO) + 0;
            } else {
                h = 0;
            }
            if (this.hbP != null) {
                h += f.a.a.b.b.a.h(2, this.hbP);
            }
            if (this.hbQ != null) {
                h += f.a.a.b.b.a.h(3, this.hbQ);
            }
            if (this.hbR != null) {
                h += f.a.a.b.b.a.h(4, this.hbR);
            }
            if (this.hbS != null) {
                h += f.a.a.b.b.a.h(5, this.hbS);
            }
            return (h + f.a.a.a.fQ(6, this.hbT)) + f.a.a.a.S(7, this.hbU);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.hbO == null) {
                throw new b("Not all required fields were included: DeviceID");
            } else if (this.hbP == null) {
                throw new b("Not all required fields were included: DeviceName");
            } else if (this.hbQ == null) {
                throw new b("Not all required fields were included: Model");
            } else if (this.hbR == null) {
                throw new b("Not all required fields were included: SystemName");
            } else if (this.hbS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SystemVersion");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.hbO = aVar3.vHC.readString();
                    return 0;
                case 2:
                    mVar.hbP = aVar3.vHC.readString();
                    return 0;
                case 3:
                    mVar.hbQ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    mVar.hbR = aVar3.vHC.readString();
                    return 0;
                case 5:
                    mVar.hbS = aVar3.vHC.readString();
                    return 0;
                case 6:
                    mVar.hbT = aVar3.vHC.rY();
                    return 0;
                case 7:
                    mVar.hbU = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
