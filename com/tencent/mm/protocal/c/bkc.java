package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bkc extends a {
    public int reH;
    public sx req;
    public bhy rer;
    public bhy res;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.res == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else if (this.req == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.rer == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else {
                if (this.res != null) {
                    aVar.fV(1, this.res.boi());
                    this.res.a(aVar);
                }
                if (this.req != null) {
                    aVar.fV(2, this.req.boi());
                    this.req.a(aVar);
                }
                if (this.rer != null) {
                    aVar.fV(3, this.rer.boi());
                    this.rer.a(aVar);
                }
                aVar.fT(4, this.reH);
                return 0;
            }
        } else if (i == 1) {
            if (this.res != null) {
                fS = f.a.a.a.fS(1, this.res.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.req != null) {
                fS += f.a.a.a.fS(2, this.req.boi());
            }
            if (this.rer != null) {
                fS += f.a.a.a.fS(3, this.rer.boi());
            }
            return fS + f.a.a.a.fQ(4, this.reH);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.res == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else if (this.req == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.rer != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SessionKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bkc bkc = (bkc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            a bhy;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        bkc.res = bhy;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new sx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        bkc.req = bhy;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        bkc.rer = bhy;
                    }
                    return 0;
                case 4:
                    bkc.reH = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
