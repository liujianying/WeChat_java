package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class by extends a {
    public int hcd;
    public int jQd;
    public int lOH;
    public int rci;
    public bhz rcj;
    public bhz rck;
    public bhz rcl;
    public int rcm;
    public bhy rcn;
    public String rco;
    public String rcp;
    public long rcq;
    public int rcr;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rcj == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.rck == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.rcl == null) {
                throw new b("Not all required fields were included: Content");
            } else if (this.rcn == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                aVar.fT(1, this.rci);
                if (this.rcj != null) {
                    aVar.fV(2, this.rcj.boi());
                    this.rcj.a(aVar);
                }
                if (this.rck != null) {
                    aVar.fV(3, this.rck.boi());
                    this.rck.a(aVar);
                }
                aVar.fT(4, this.jQd);
                if (this.rcl != null) {
                    aVar.fV(5, this.rcl.boi());
                    this.rcl.a(aVar);
                }
                aVar.fT(6, this.hcd);
                aVar.fT(7, this.rcm);
                if (this.rcn != null) {
                    aVar.fV(8, this.rcn.boi());
                    this.rcn.a(aVar);
                }
                aVar.fT(9, this.lOH);
                if (this.rco != null) {
                    aVar.g(10, this.rco);
                }
                if (this.rcp != null) {
                    aVar.g(11, this.rcp);
                }
                aVar.T(12, this.rcq);
                aVar.fT(13, this.rcr);
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rci) + 0;
            if (this.rcj != null) {
                fQ += f.a.a.a.fS(2, this.rcj.boi());
            }
            if (this.rck != null) {
                fQ += f.a.a.a.fS(3, this.rck.boi());
            }
            fQ += f.a.a.a.fQ(4, this.jQd);
            if (this.rcl != null) {
                fQ += f.a.a.a.fS(5, this.rcl.boi());
            }
            fQ = (fQ + f.a.a.a.fQ(6, this.hcd)) + f.a.a.a.fQ(7, this.rcm);
            if (this.rcn != null) {
                fQ += f.a.a.a.fS(8, this.rcn.boi());
            }
            fQ += f.a.a.a.fQ(9, this.lOH);
            if (this.rco != null) {
                fQ += f.a.a.b.b.a.h(10, this.rco);
            }
            if (this.rcp != null) {
                fQ += f.a.a.b.b.a.h(11, this.rcp);
            }
            return (fQ + f.a.a.a.S(12, this.rcq)) + f.a.a.a.fQ(13, this.rcr);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rcj == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.rck == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.rcl == null) {
                throw new b("Not all required fields were included: Content");
            } else if (this.rcn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            by byVar = (by) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            a bhz;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    byVar.rci = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        byVar.rcj = bhz;
                    }
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
                        byVar.rck = bhz;
                    }
                    return 0;
                case 4:
                    byVar.jQd = aVar3.vHC.rY();
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
                        byVar.rcl = bhz;
                    }
                    return 0;
                case 6:
                    byVar.hcd = aVar3.vHC.rY();
                    return 0;
                case 7:
                    byVar.rcm = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        byVar.rcn = bhz;
                    }
                    return 0;
                case 9:
                    byVar.lOH = aVar3.vHC.rY();
                    return 0;
                case 10:
                    byVar.rco = aVar3.vHC.readString();
                    return 0;
                case 11:
                    byVar.rcp = aVar3.vHC.readString();
                    return 0;
                case 12:
                    byVar.rcq = aVar3.vHC.rZ();
                    return 0;
                case 13:
                    byVar.rcr = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
