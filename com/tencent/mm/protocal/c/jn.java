package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class jn extends bhd {
    public ch rkA;
    public btd rkR;
    public String rkS;
    public int rld;
    public String token;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rkR == null) {
                throw new b("Not all required fields were included: tock_mess");
            } else if (this.rkA == null) {
                throw new b("Not all required fields were included: after_placeorder_comm_req");
            } else if (this.token == null) {
                throw new b("Not all required fields were included: token");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.rkR != null) {
                    aVar.fV(2, this.rkR.boi());
                    this.rkR.a(aVar);
                }
                if (this.rkA != null) {
                    aVar.fV(3, this.rkA.boi());
                    this.rkA.a(aVar);
                }
                if (this.rkS != null) {
                    aVar.g(4, this.rkS);
                }
                aVar.fT(5, this.rld);
                if (this.token == null) {
                    return 0;
                }
                aVar.g(6, this.token);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rkR != null) {
                fS += f.a.a.a.fS(2, this.rkR.boi());
            }
            if (this.rkA != null) {
                fS += f.a.a.a.fS(3, this.rkA.boi());
            }
            if (this.rkS != null) {
                fS += f.a.a.b.b.a.h(4, this.rkS);
            }
            fS += f.a.a.a.fQ(5, this.rld);
            if (this.token != null) {
                fS += f.a.a.b.b.a.h(6, this.token);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rkR == null) {
                throw new b("Not all required fields were included: tock_mess");
            } else if (this.rkA == null) {
                throw new b("Not all required fields were included: after_placeorder_comm_req");
            } else if (this.token != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: token");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            jn jnVar = (jn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
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
                        jnVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        btd btd = new btd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btd.a(aVar4, btd, bhd.a(aVar4))) {
                        }
                        jnVar.rkR = btd;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ch chVar = new ch();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chVar.a(aVar4, chVar, bhd.a(aVar4))) {
                        }
                        jnVar.rkA = chVar;
                    }
                    return 0;
                case 4:
                    jnVar.rkS = aVar3.vHC.readString();
                    return 0;
                case 5:
                    jnVar.rld = aVar3.vHC.rY();
                    return 0;
                case 6:
                    jnVar.token = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
