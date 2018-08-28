package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class mr extends bhd {
    public String bQa;
    public String myl;
    public String myq;
    public long mzF;
    public String rqG;
    public String rqo;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.bQa == null) {
                throw new b("Not all required fields were included: req_key");
            } else if (this.rqG == null) {
                throw new b("Not all required fields were included: transfer_id");
            } else if (this.myq == null) {
                throw new b("Not all required fields were included: transaction_id");
            } else if (this.myl == null) {
                throw new b("Not all required fields were included: receiver_openid");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.bQa != null) {
                    aVar.g(2, this.bQa);
                }
                if (this.rqG != null) {
                    aVar.g(3, this.rqG);
                }
                if (this.myq != null) {
                    aVar.g(4, this.myq);
                }
                if (this.myl != null) {
                    aVar.g(5, this.myl);
                }
                aVar.T(6, this.mzF);
                if (this.rqo == null) {
                    return 0;
                }
                aVar.g(7, this.rqo);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.bQa != null) {
                fS += f.a.a.b.b.a.h(2, this.bQa);
            }
            if (this.rqG != null) {
                fS += f.a.a.b.b.a.h(3, this.rqG);
            }
            if (this.myq != null) {
                fS += f.a.a.b.b.a.h(4, this.myq);
            }
            if (this.myl != null) {
                fS += f.a.a.b.b.a.h(5, this.myl);
            }
            fS += f.a.a.a.S(6, this.mzF);
            if (this.rqo != null) {
                fS += f.a.a.b.b.a.h(7, this.rqo);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.bQa == null) {
                throw new b("Not all required fields were included: req_key");
            } else if (this.rqG == null) {
                throw new b("Not all required fields were included: transfer_id");
            } else if (this.myq == null) {
                throw new b("Not all required fields were included: transaction_id");
            } else if (this.myl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: receiver_openid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            mr mrVar = (mr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        mrVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    mrVar.bQa = aVar3.vHC.readString();
                    return 0;
                case 3:
                    mrVar.rqG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    mrVar.myq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    mrVar.myl = aVar3.vHC.readString();
                    return 0;
                case 6:
                    mrVar.mzF = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    mrVar.rqo = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
