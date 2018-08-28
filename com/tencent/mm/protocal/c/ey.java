package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ey extends a {
    public int hcE;
    public int rci;
    public bhz rcj;
    public bhz rck;
    public bhz rcl;
    public String rco;
    public long rcq;
    public String rdo;
    public int rfA;
    public int rfB;
    public long rfC;
    public int rfD;
    public int rft;
    public int rfu;
    public int rfv;
    public LinkedList<bhz> rfw = new LinkedList();
    public LinkedList<bia> rfx = new LinkedList();
    public bhy rfy;
    public int rfz;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rcj == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.rck == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.rcl == null) {
                throw new b("Not all required fields were included: Content");
            } else {
                aVar.fT(1, this.hcE);
                if (this.rdo != null) {
                    aVar.g(2, this.rdo);
                }
                if (this.rcj != null) {
                    aVar.fV(3, this.rcj.boi());
                    this.rcj.a(aVar);
                }
                if (this.rck != null) {
                    aVar.fV(4, this.rck.boi());
                    this.rck.a(aVar);
                }
                if (this.rcl != null) {
                    aVar.fV(5, this.rcl.boi());
                    this.rcl.a(aVar);
                }
                aVar.fT(6, this.rft);
                aVar.fT(7, this.rfu);
                if (this.rco != null) {
                    aVar.g(8, this.rco);
                }
                aVar.fT(9, this.rci);
                aVar.fT(10, this.rfv);
                aVar.d(11, 8, this.rfw);
                aVar.d(12, 8, this.rfx);
                if (this.rfy != null) {
                    aVar.fV(13, this.rfy.boi());
                    this.rfy.a(aVar);
                }
                aVar.fT(14, this.rfz);
                aVar.fT(15, this.rfA);
                aVar.T(16, this.rcq);
                aVar.fT(17, this.rfB);
                aVar.T(18, this.rfC);
                aVar.fT(19, this.rfD);
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.hcE) + 0;
            if (this.rdo != null) {
                fQ += f.a.a.b.b.a.h(2, this.rdo);
            }
            if (this.rcj != null) {
                fQ += f.a.a.a.fS(3, this.rcj.boi());
            }
            if (this.rck != null) {
                fQ += f.a.a.a.fS(4, this.rck.boi());
            }
            if (this.rcl != null) {
                fQ += f.a.a.a.fS(5, this.rcl.boi());
            }
            fQ = (fQ + f.a.a.a.fQ(6, this.rft)) + f.a.a.a.fQ(7, this.rfu);
            if (this.rco != null) {
                fQ += f.a.a.b.b.a.h(8, this.rco);
            }
            fQ = (((fQ + f.a.a.a.fQ(9, this.rci)) + f.a.a.a.fQ(10, this.rfv)) + f.a.a.a.c(11, 8, this.rfw)) + f.a.a.a.c(12, 8, this.rfx);
            if (this.rfy != null) {
                fQ += f.a.a.a.fS(13, this.rfy.boi());
            }
            return (((((fQ + f.a.a.a.fQ(14, this.rfz)) + f.a.a.a.fQ(15, this.rfA)) + f.a.a.a.S(16, this.rcq)) + f.a.a.a.fQ(17, this.rfB)) + f.a.a.a.S(18, this.rfC)) + f.a.a.a.fQ(19, this.rfD);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rfw.clear();
            this.rfx.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rcj == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.rck == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.rcl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ey eyVar = (ey) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            a bhz;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    eyVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 2:
                    eyVar.rdo = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        eyVar.rcj = bhz;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        eyVar.rck = bhz;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        eyVar.rcl = bhz;
                    }
                    return 0;
                case 6:
                    eyVar.rft = aVar3.vHC.rY();
                    return 0;
                case 7:
                    eyVar.rfu = aVar3.vHC.rY();
                    return 0;
                case 8:
                    eyVar.rco = aVar3.vHC.readString();
                    return 0;
                case 9:
                    eyVar.rci = aVar3.vHC.rY();
                    return 0;
                case 10:
                    eyVar.rfv = aVar3.vHC.rY();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        eyVar.rfw.add(bhz);
                    }
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bia();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        eyVar.rfx.add(bhz);
                    }
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        eyVar.rfy = bhz;
                    }
                    return 0;
                case 14:
                    eyVar.rfz = aVar3.vHC.rY();
                    return 0;
                case 15:
                    eyVar.rfA = aVar3.vHC.rY();
                    return 0;
                case 16:
                    eyVar.rcq = aVar3.vHC.rZ();
                    return 0;
                case 17:
                    eyVar.rfB = aVar3.vHC.rY();
                    return 0;
                case 18:
                    eyVar.rfC = aVar3.vHC.rZ();
                    return 0;
                case 19:
                    eyVar.rfD = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
