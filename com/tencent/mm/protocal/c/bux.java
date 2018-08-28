package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bux extends bhd {
    public String cCR;
    public String devicetype;
    public String lKa;
    public int srT;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.devicetype == null) {
                throw new b("Not all required fields were included: devicetype");
            } else if (this.lKa == null) {
                throw new b("Not all required fields were included: deviceid");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.devicetype != null) {
                    aVar.g(2, this.devicetype);
                }
                if (this.lKa != null) {
                    aVar.g(3, this.lKa);
                }
                if (this.cCR != null) {
                    aVar.g(4, this.cCR);
                }
                aVar.fT(5, this.srT);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.devicetype != null) {
                fS += f.a.a.b.b.a.h(2, this.devicetype);
            }
            if (this.lKa != null) {
                fS += f.a.a.b.b.a.h(3, this.lKa);
            }
            if (this.cCR != null) {
                fS += f.a.a.b.b.a.h(4, this.cCR);
            }
            return fS + f.a.a.a.fQ(5, this.srT);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.devicetype == null) {
                throw new b("Not all required fields were included: devicetype");
            } else if (this.lKa != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: deviceid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bux bux = (bux) objArr[1];
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
                        bux.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bux.devicetype = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bux.lKa = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bux.cCR = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bux.srT = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
