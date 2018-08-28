package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ara extends bhd {
    public int bYt;
    public String dxc;
    public String iEL;
    public String username;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.iEL == null) {
                throw new b("Not all required fields were included: appusername");
            } else if (this.dxc == null) {
                throw new b("Not all required fields were included: rankid");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.username != null) {
                    aVar.g(2, this.username);
                }
                if (this.iEL != null) {
                    aVar.g(3, this.iEL);
                }
                aVar.fT(4, this.bYt);
                if (this.dxc == null) {
                    return 0;
                }
                aVar.g(5, this.dxc);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.username != null) {
                fS += f.a.a.b.b.a.h(2, this.username);
            }
            if (this.iEL != null) {
                fS += f.a.a.b.b.a.h(3, this.iEL);
            }
            fS += f.a.a.a.fQ(4, this.bYt);
            if (this.dxc != null) {
                fS += f.a.a.b.b.a.h(5, this.dxc);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.iEL == null) {
                throw new b("Not all required fields were included: appusername");
            } else if (this.dxc != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ara ara = (ara) objArr[1];
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
                        ara.shX = fkVar;
                    }
                    return 0;
                case 2:
                    ara.username = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ara.iEL = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ara.bYt = aVar3.vHC.rY();
                    return 0;
                case 5:
                    ara.dxc = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
