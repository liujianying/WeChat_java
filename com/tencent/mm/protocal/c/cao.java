package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class cao extends bhd {
    public LinkedList<bqo> rIv = new LinkedList();
    public double rji;
    public double rjj;
    public int rth;
    public int rxG;
    public long rxH;
    public long swW;
    public bhz swX;
    public bhz swY;
    public int swZ;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.swX == null) {
                throw new b("Not all required fields were included: NetName");
            } else if (this.swY == null) {
                throw new b("Not all required fields were included: WifiName");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                aVar.T(2, this.swW);
                aVar.T(3, this.rxH);
                aVar.fT(4, this.rth);
                if (this.swX != null) {
                    aVar.fV(5, this.swX.boi());
                    this.swX.a(aVar);
                }
                if (this.swY != null) {
                    aVar.fV(6, this.swY.boi());
                    this.swY.a(aVar);
                }
                aVar.c(7, this.rji);
                aVar.c(8, this.rjj);
                aVar.fT(9, this.rxG);
                aVar.fT(10, this.swZ);
                aVar.d(11, 8, this.rIv);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((fS + f.a.a.a.S(2, this.swW)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.fQ(4, this.rth);
            if (this.swX != null) {
                fS += f.a.a.a.fS(5, this.swX.boi());
            }
            if (this.swY != null) {
                fS += f.a.a.a.fS(6, this.swY.boi());
            }
            return ((((fS + (f.a.a.b.b.a.ec(7) + 8)) + (f.a.a.b.b.a.ec(8) + 8)) + f.a.a.a.fQ(9, this.rxG)) + f.a.a.a.fQ(10, this.swZ)) + f.a.a.a.c(11, 8, this.rIv);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rIv.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.swX == null) {
                throw new b("Not all required fields were included: NetName");
            } else if (this.swY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: WifiName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cao cao = (cao) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            com.tencent.mm.bk.a fkVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        cao.shX = fkVar;
                    }
                    return 0;
                case 2:
                    cao.swW = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    cao.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    cao.rth = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        cao.swX = fkVar;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        cao.swY = fkVar;
                    }
                    return 0;
                case 7:
                    cao.rji = aVar3.vHC.readDouble();
                    return 0;
                case 8:
                    cao.rjj = aVar3.vHC.readDouble();
                    return 0;
                case 9:
                    cao.rxG = aVar3.vHC.rY();
                    return 0;
                case 10:
                    cao.swZ = aVar3.vHC.rY();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqo bqo = new bqo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqo.a(aVar4, bqo, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        cao.rIv.add(bqo);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
