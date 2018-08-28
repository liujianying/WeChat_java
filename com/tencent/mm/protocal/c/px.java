package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class px extends bhd {
    public String jQb;
    public String reT;
    public String ruf;
    public String rug;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ruf == null) {
                throw new b("Not all required fields were included: DeviceId");
            } else if (this.reT == null) {
                throw new b("Not all required fields were included: DeviceType");
            } else if (this.rug == null) {
                throw new b("Not all required fields were included: ClientInfo");
            } else if (this.jQb == null) {
                throw new b("Not all required fields were included: AppId");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.ruf != null) {
                    aVar.g(2, this.ruf);
                }
                if (this.reT != null) {
                    aVar.g(3, this.reT);
                }
                if (this.rug != null) {
                    aVar.g(4, this.rug);
                }
                if (this.jQb == null) {
                    return 0;
                }
                aVar.g(5, this.jQb);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ruf != null) {
                fS += f.a.a.b.b.a.h(2, this.ruf);
            }
            if (this.reT != null) {
                fS += f.a.a.b.b.a.h(3, this.reT);
            }
            if (this.rug != null) {
                fS += f.a.a.b.b.a.h(4, this.rug);
            }
            if (this.jQb != null) {
                fS += f.a.a.b.b.a.h(5, this.jQb);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ruf == null) {
                throw new b("Not all required fields were included: DeviceId");
            } else if (this.reT == null) {
                throw new b("Not all required fields were included: DeviceType");
            } else if (this.rug == null) {
                throw new b("Not all required fields were included: ClientInfo");
            } else if (this.jQb != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppId");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            px pxVar = (px) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        pxVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    pxVar.ruf = aVar3.vHC.readString();
                    return 0;
                case 3:
                    pxVar.reT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    pxVar.rug = aVar3.vHC.readString();
                    return 0;
                case 5:
                    pxVar.jQb = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
