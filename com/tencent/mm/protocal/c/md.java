package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class md extends bhd {
    public int amount;
    public String rcD;
    public String rcE;
    public String rqo;
    public String rqp;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rcD == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.rcE == null) {
                throw new b("Not all required fields were included: trans_id");
            } else if (this.rqp == null) {
                throw new b("Not all required fields were included: receiver_open_id");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.rcD != null) {
                    aVar.g(2, this.rcD);
                }
                if (this.rcE != null) {
                    aVar.g(3, this.rcE);
                }
                if (this.rqo != null) {
                    aVar.g(4, this.rqo);
                }
                if (this.rqp != null) {
                    aVar.g(5, this.rqp);
                }
                aVar.fT(6, this.amount);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rcD != null) {
                fS += f.a.a.b.b.a.h(2, this.rcD);
            }
            if (this.rcE != null) {
                fS += f.a.a.b.b.a.h(3, this.rcE);
            }
            if (this.rqo != null) {
                fS += f.a.a.b.b.a.h(4, this.rqo);
            }
            if (this.rqp != null) {
                fS += f.a.a.b.b.a.h(5, this.rqp);
            }
            return fS + f.a.a.a.fQ(6, this.amount);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rcD == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.rcE == null) {
                throw new b("Not all required fields were included: trans_id");
            } else if (this.rqp != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: receiver_open_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            md mdVar = (md) objArr[1];
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
                        mdVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    mdVar.rcD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    mdVar.rcE = aVar3.vHC.readString();
                    return 0;
                case 4:
                    mdVar.rqo = aVar3.vHC.readString();
                    return 0;
                case 5:
                    mdVar.rqp = aVar3.vHC.readString();
                    return 0;
                case 6:
                    mdVar.amount = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
