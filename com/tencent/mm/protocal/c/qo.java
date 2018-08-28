package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class qo extends bhp {
    public int hLg;
    public LinkedList<atj> rbQ = new LinkedList();
    public bhz rbR;
    public bhy rcn;
    public String rqZ;
    public String rra;
    public bhz ruR;
    public bhz ruT;
    public bhz ruU;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.ruR == null) {
                throw new b("Not all required fields were included: Topic");
            } else if (this.ruT == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ruU == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.rbR == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.rcn == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.ruR != null) {
                    aVar.fV(2, this.ruR.boi());
                    this.ruR.a(aVar);
                }
                if (this.ruT != null) {
                    aVar.fV(3, this.ruT.boi());
                    this.ruT.a(aVar);
                }
                if (this.ruU != null) {
                    aVar.fV(4, this.ruU.boi());
                    this.ruU.a(aVar);
                }
                aVar.fT(5, this.hLg);
                aVar.d(6, 8, this.rbQ);
                if (this.rbR != null) {
                    aVar.fV(7, this.rbR.boi());
                    this.rbR.a(aVar);
                }
                if (this.rcn != null) {
                    aVar.fV(8, this.rcn.boi());
                    this.rcn.a(aVar);
                }
                if (this.rqZ != null) {
                    aVar.g(9, this.rqZ);
                }
                if (this.rra == null) {
                    return 0;
                }
                aVar.g(10, this.rra);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ruR != null) {
                fS += f.a.a.a.fS(2, this.ruR.boi());
            }
            if (this.ruT != null) {
                fS += f.a.a.a.fS(3, this.ruT.boi());
            }
            if (this.ruU != null) {
                fS += f.a.a.a.fS(4, this.ruU.boi());
            }
            fS = (fS + f.a.a.a.fQ(5, this.hLg)) + f.a.a.a.c(6, 8, this.rbQ);
            if (this.rbR != null) {
                fS += f.a.a.a.fS(7, this.rbR.boi());
            }
            if (this.rcn != null) {
                fS += f.a.a.a.fS(8, this.rcn.boi());
            }
            if (this.rqZ != null) {
                fS += f.a.a.b.b.a.h(9, this.rqZ);
            }
            if (this.rra != null) {
                fS += f.a.a.b.b.a.h(10, this.rra);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rbQ.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.ruR == null) {
                throw new b("Not all required fields were included: Topic");
            } else if (this.ruT == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ruU == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.rbR == null) {
                throw new b("Not all required fields were included: ChatRoomName");
            } else if (this.rcn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            qo qoVar = (qo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            com.tencent.mm.bk.a flVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qoVar.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        flVar = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qoVar.ruR = flVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        flVar = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qoVar.ruT = flVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        flVar = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qoVar.ruU = flVar;
                    }
                    return 0;
                case 5:
                    qoVar.hLg = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        atj atj = new atj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atj.a(aVar4, atj, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qoVar.rbQ.add(atj);
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        flVar = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qoVar.rbR = flVar;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        flVar = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qoVar.rcn = flVar;
                    }
                    return 0;
                case 9:
                    qoVar.rqZ = aVar3.vHC.readString();
                    return 0;
                case 10:
                    qoVar.rra = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
