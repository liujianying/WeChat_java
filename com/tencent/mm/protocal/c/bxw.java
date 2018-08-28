package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bxw extends bhp {
    public bhz rMn;
    public bhy rcn;
    public String reA;
    public bhy reB;
    public bhy rev;
    public bhz rhY;
    public bhy rhZ;
    public String rwj;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rMn == null) {
                throw new b("Not all required fields were included: ImgSid");
            } else if (this.rcn == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rMn != null) {
                    aVar.fV(2, this.rMn.boi());
                    this.rMn.a(aVar);
                }
                if (this.rcn != null) {
                    aVar.fV(3, this.rcn.boi());
                    this.rcn.a(aVar);
                }
                if (this.rwj != null) {
                    aVar.g(4, this.rwj);
                }
                if (this.rhY != null) {
                    aVar.fV(5, this.rhY.boi());
                    this.rhY.a(aVar);
                }
                if (this.reB != null) {
                    aVar.fV(6, this.reB.boi());
                    this.reB.a(aVar);
                }
                if (this.rhZ != null) {
                    aVar.fV(7, this.rhZ.boi());
                    this.rhZ.a(aVar);
                }
                if (this.reA != null) {
                    aVar.g(8, this.reA);
                }
                if (this.rev == null) {
                    return 0;
                }
                aVar.fV(9, this.rev.boi());
                this.rev.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rMn != null) {
                fS += f.a.a.a.fS(2, this.rMn.boi());
            }
            if (this.rcn != null) {
                fS += f.a.a.a.fS(3, this.rcn.boi());
            }
            if (this.rwj != null) {
                fS += f.a.a.b.b.a.h(4, this.rwj);
            }
            if (this.rhY != null) {
                fS += f.a.a.a.fS(5, this.rhY.boi());
            }
            if (this.reB != null) {
                fS += f.a.a.a.fS(6, this.reB.boi());
            }
            if (this.rhZ != null) {
                fS += f.a.a.a.fS(7, this.rhZ.boi());
            }
            if (this.reA != null) {
                fS += f.a.a.b.b.a.h(8, this.reA);
            }
            if (this.rev != null) {
                fS += f.a.a.a.fS(9, this.rev.boi());
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
            } else if (this.rMn == null) {
                throw new b("Not all required fields were included: ImgSid");
            } else if (this.rcn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bxw bxw = (bxw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            bhz bhz;
            bhy bhy;
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
                        bxw.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        bxw.rMn = bhz;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bxw.rcn = bhy;
                    }
                    return 0;
                case 4:
                    bxw.rwj = aVar3.vHC.readString();
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
                        bxw.rhY = bhz;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bxw.reB = bhy;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bxw.rhZ = bhy;
                    }
                    return 0;
                case 8:
                    bxw.reA = aVar3.vHC.readString();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bxw.rev = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
