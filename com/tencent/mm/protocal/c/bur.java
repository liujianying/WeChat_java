package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bur extends bhd {
    public String riE;
    public String riK;
    public hv srQ;
    public hv srR;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.riK == null) {
                throw new b("Not all required fields were included: brand_user_name");
            } else if (this.riE == null) {
                throw new b("Not all required fields were included: bizchat_id");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.riK != null) {
                    aVar.g(2, this.riK);
                }
                if (this.riE != null) {
                    aVar.g(3, this.riE);
                }
                if (this.srQ != null) {
                    aVar.fV(4, this.srQ.boi());
                    this.srQ.a(aVar);
                }
                if (this.srR == null) {
                    return 0;
                }
                aVar.fV(5, this.srR.boi());
                this.srR.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.riK != null) {
                fS += f.a.a.b.b.a.h(2, this.riK);
            }
            if (this.riE != null) {
                fS += f.a.a.b.b.a.h(3, this.riE);
            }
            if (this.srQ != null) {
                fS += f.a.a.a.fS(4, this.srQ.boi());
            }
            if (this.srR != null) {
                fS += f.a.a.a.fS(5, this.srR.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.riK == null) {
                throw new b("Not all required fields were included: brand_user_name");
            } else if (this.riE != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bizchat_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bur bur = (bur) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            hv hvVar;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bur.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bur.riK = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bur.riE = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        hvVar = new hv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hvVar.a(aVar4, hvVar, bhd.a(aVar4))) {
                        }
                        bur.srQ = hvVar;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        hvVar = new hv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hvVar.a(aVar4, hvVar, bhd.a(aVar4))) {
                        }
                        bur.srR = hvVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
