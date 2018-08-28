package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bwj extends bhp {
    public int lOH;
    public int rci;
    public bhz rcj;
    public bhz rck;
    public long rcq;
    public int rdV;
    public int rdW;
    public int rdX;
    public String rmC;
    public String rmy;
    public bhz ssC;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.ssC == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.rcj == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.rck == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.fT(2, this.rci);
                if (this.ssC != null) {
                    aVar.fV(3, this.ssC.boi());
                    this.ssC.a(aVar);
                }
                if (this.rcj != null) {
                    aVar.fV(4, this.rcj.boi());
                    this.rcj.a(aVar);
                }
                if (this.rck != null) {
                    aVar.fV(5, this.rck.boi());
                    this.rck.a(aVar);
                }
                aVar.fT(6, this.rdV);
                aVar.fT(7, this.rdW);
                aVar.fT(8, this.rdX);
                aVar.fT(9, this.lOH);
                aVar.T(10, this.rcq);
                if (this.rmy != null) {
                    aVar.g(11, this.rmy);
                }
                if (this.rmC == null) {
                    return 0;
                }
                aVar.g(12, this.rmC);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rci);
            if (this.ssC != null) {
                fS += f.a.a.a.fS(3, this.ssC.boi());
            }
            if (this.rcj != null) {
                fS += f.a.a.a.fS(4, this.rcj.boi());
            }
            if (this.rck != null) {
                fS += f.a.a.a.fS(5, this.rck.boi());
            }
            fS = ((((fS + f.a.a.a.fQ(6, this.rdV)) + f.a.a.a.fQ(7, this.rdW)) + f.a.a.a.fQ(8, this.rdX)) + f.a.a.a.fQ(9, this.lOH)) + f.a.a.a.S(10, this.rcq);
            if (this.rmy != null) {
                fS += f.a.a.b.b.a.h(11, this.rmy);
            }
            if (this.rmC != null) {
                fS += f.a.a.b.b.a.h(12, this.rmC);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.ssC == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.rcj == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.rck != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ToUserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bwj bwj = (bwj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            bhz bhz;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bwj.six = flVar;
                    }
                    return 0;
                case 2:
                    bwj.rci = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        bwj.ssC = bhz;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        bwj.rcj = bhz;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        bwj.rck = bhz;
                    }
                    return 0;
                case 6:
                    bwj.rdV = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bwj.rdW = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bwj.rdX = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bwj.lOH = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bwj.rcq = aVar3.vHC.rZ();
                    return 0;
                case 11:
                    bwj.rmy = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bwj.rmC = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
