package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ec extends a {
    public int iwE;
    public String raI;
    public String reA;
    public bhy reB;
    public String reC;
    public bnp reD;
    public String reE;
    public int reF;
    public int reG;
    public int reH;
    public int reI;
    public sx req;
    public bhy rer;
    public bhy res;
    public int reu;
    public bhy rev;
    public cco rew;
    public cgf rex;
    public bhy rey;
    public bhy rez;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.req == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.rer == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.res == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            } else {
                aVar.fT(1, this.iwE);
                if (this.req != null) {
                    aVar.fV(2, this.req.boi());
                    this.req.a(aVar);
                }
                if (this.rer != null) {
                    aVar.fV(3, this.rer.boi());
                    this.rer.a(aVar);
                }
                if (this.res != null) {
                    aVar.fV(4, this.res.boi());
                    this.res.a(aVar);
                }
                aVar.fT(5, this.reu);
                if (this.rev != null) {
                    aVar.fV(6, this.rev.boi());
                    this.rev.a(aVar);
                }
                if (this.rew != null) {
                    aVar.fV(7, this.rew.boi());
                    this.rew.a(aVar);
                }
                if (this.rex != null) {
                    aVar.fV(8, this.rex.boi());
                    this.rex.a(aVar);
                }
                if (this.rey != null) {
                    aVar.fV(9, this.rey.boi());
                    this.rey.a(aVar);
                }
                if (this.rez != null) {
                    aVar.fV(10, this.rez.boi());
                    this.rez.a(aVar);
                }
                if (this.reA != null) {
                    aVar.g(11, this.reA);
                }
                if (this.reB != null) {
                    aVar.fV(12, this.reB.boi());
                    this.reB.a(aVar);
                }
                if (this.reC != null) {
                    aVar.g(14, this.reC);
                }
                if (this.reD != null) {
                    aVar.fV(15, this.reD.boi());
                    this.reD.a(aVar);
                }
                if (this.reE != null) {
                    aVar.g(16, this.reE);
                }
                aVar.fT(17, this.reF);
                aVar.fT(18, this.reG);
                aVar.fT(19, this.reH);
                if (this.raI != null) {
                    aVar.g(20, this.raI);
                }
                aVar.fT(21, this.reI);
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.iwE) + 0;
            if (this.req != null) {
                fQ += f.a.a.a.fS(2, this.req.boi());
            }
            if (this.rer != null) {
                fQ += f.a.a.a.fS(3, this.rer.boi());
            }
            if (this.res != null) {
                fQ += f.a.a.a.fS(4, this.res.boi());
            }
            fQ += f.a.a.a.fQ(5, this.reu);
            if (this.rev != null) {
                fQ += f.a.a.a.fS(6, this.rev.boi());
            }
            if (this.rew != null) {
                fQ += f.a.a.a.fS(7, this.rew.boi());
            }
            if (this.rex != null) {
                fQ += f.a.a.a.fS(8, this.rex.boi());
            }
            if (this.rey != null) {
                fQ += f.a.a.a.fS(9, this.rey.boi());
            }
            if (this.rez != null) {
                fQ += f.a.a.a.fS(10, this.rez.boi());
            }
            if (this.reA != null) {
                fQ += f.a.a.b.b.a.h(11, this.reA);
            }
            if (this.reB != null) {
                fQ += f.a.a.a.fS(12, this.reB.boi());
            }
            if (this.reC != null) {
                fQ += f.a.a.b.b.a.h(14, this.reC);
            }
            if (this.reD != null) {
                fQ += f.a.a.a.fS(15, this.reD.boi());
            }
            if (this.reE != null) {
                fQ += f.a.a.b.b.a.h(16, this.reE);
            }
            fQ = ((fQ + f.a.a.a.fQ(17, this.reF)) + f.a.a.a.fQ(18, this.reG)) + f.a.a.a.fQ(19, this.reH);
            if (this.raI != null) {
                fQ += f.a.a.b.b.a.h(20, this.raI);
            }
            return fQ + f.a.a.a.fQ(21, this.reI);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.req == null) {
                throw new b("Not all required fields were included: SvrPubECDHKey");
            } else if (this.rer == null) {
                throw new b("Not all required fields were included: SessionKey");
            } else if (this.res != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AutoAuthKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ec ecVar = (ec) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            a sxVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ecVar.iwE = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sxVar = new sx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        ecVar.req = sxVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sxVar = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        ecVar.rer = sxVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sxVar = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        ecVar.res = sxVar;
                    }
                    return 0;
                case 5:
                    ecVar.reu = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sxVar = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        ecVar.rev = sxVar;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sxVar = new cco();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        ecVar.rew = sxVar;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sxVar = new cgf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        ecVar.rex = sxVar;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sxVar = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        ecVar.rey = sxVar;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sxVar = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        ecVar.rez = sxVar;
                    }
                    return 0;
                case 11:
                    ecVar.reA = aVar3.vHC.readString();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sxVar = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        ecVar.reB = sxVar;
                    }
                    return 0;
                case 14:
                    ecVar.reC = aVar3.vHC.readString();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sxVar = new bnp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sxVar.a(aVar4, sxVar, a.a(aVar4))) {
                        }
                        ecVar.reD = sxVar;
                    }
                    return 0;
                case 16:
                    ecVar.reE = aVar3.vHC.readString();
                    return 0;
                case 17:
                    ecVar.reF = aVar3.vHC.rY();
                    return 0;
                case 18:
                    ecVar.reG = aVar3.vHC.rY();
                    return 0;
                case 19:
                    ecVar.reH = aVar3.vHC.rY();
                    return 0;
                case 20:
                    ecVar.raI = aVar3.vHC.readString();
                    return 0;
                case 21:
                    ecVar.reI = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
