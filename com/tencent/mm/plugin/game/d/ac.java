package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ac extends a {
    public String jOU;
    public String jPA;
    public int jPC;
    public int jPF;
    public cw jQA;
    public n jQB;
    public n jQC;
    public String jQb;
    public bz jQr;
    public dk jQs;
    public ci jQt;
    public cj jQu;
    public av jQv;
    public cr jQw;
    public ar jQx;
    public o jQy;
    public cm jQz;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.jPF);
            aVar.fT(2, this.jPC);
            if (this.jPA != null) {
                aVar.g(3, this.jPA);
            }
            if (this.jQb != null) {
                aVar.g(4, this.jQb);
            }
            if (this.jOU != null) {
                aVar.g(17, this.jOU);
            }
            if (this.jQr != null) {
                aVar.fV(5, this.jQr.boi());
                this.jQr.a(aVar);
            }
            if (this.jQs != null) {
                aVar.fV(6, this.jQs.boi());
                this.jQs.a(aVar);
            }
            if (this.jQt != null) {
                aVar.fV(7, this.jQt.boi());
                this.jQt.a(aVar);
            }
            if (this.jQu != null) {
                aVar.fV(8, this.jQu.boi());
                this.jQu.a(aVar);
            }
            if (this.jQv != null) {
                aVar.fV(9, this.jQv.boi());
                this.jQv.a(aVar);
            }
            if (this.jQw != null) {
                aVar.fV(10, this.jQw.boi());
                this.jQw.a(aVar);
            }
            if (this.jQx != null) {
                aVar.fV(11, this.jQx.boi());
                this.jQx.a(aVar);
            }
            if (this.jQy != null) {
                aVar.fV(12, this.jQy.boi());
                this.jQy.a(aVar);
            }
            if (this.jQz != null) {
                aVar.fV(13, this.jQz.boi());
                this.jQz.a(aVar);
            }
            if (this.jQA != null) {
                aVar.fV(14, this.jQA.boi());
                this.jQA.a(aVar);
            }
            if (this.jQB != null) {
                aVar.fV(15, this.jQB.boi());
                this.jQB.a(aVar);
            }
            if (this.jQC != null) {
                aVar.fV(16, this.jQC.boi());
                this.jQC.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.jPF) + 0) + f.a.a.a.fQ(2, this.jPC);
            if (this.jPA != null) {
                fQ += f.a.a.b.b.a.h(3, this.jPA);
            }
            if (this.jQb != null) {
                fQ += f.a.a.b.b.a.h(4, this.jQb);
            }
            if (this.jOU != null) {
                fQ += f.a.a.b.b.a.h(17, this.jOU);
            }
            if (this.jQr != null) {
                fQ += f.a.a.a.fS(5, this.jQr.boi());
            }
            if (this.jQs != null) {
                fQ += f.a.a.a.fS(6, this.jQs.boi());
            }
            if (this.jQt != null) {
                fQ += f.a.a.a.fS(7, this.jQt.boi());
            }
            if (this.jQu != null) {
                fQ += f.a.a.a.fS(8, this.jQu.boi());
            }
            if (this.jQv != null) {
                fQ += f.a.a.a.fS(9, this.jQv.boi());
            }
            if (this.jQw != null) {
                fQ += f.a.a.a.fS(10, this.jQw.boi());
            }
            if (this.jQx != null) {
                fQ += f.a.a.a.fS(11, this.jQx.boi());
            }
            if (this.jQy != null) {
                fQ += f.a.a.a.fS(12, this.jQy.boi());
            }
            if (this.jQz != null) {
                fQ += f.a.a.a.fS(13, this.jQz.boi());
            }
            if (this.jQA != null) {
                fQ += f.a.a.a.fS(14, this.jQA.boi());
            }
            if (this.jQB != null) {
                fQ += f.a.a.a.fS(15, this.jQB.boi());
            }
            if (this.jQC != null) {
                return fQ + f.a.a.a.fS(16, this.jQC.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ac acVar = (ac) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            n nVar;
            switch (intValue) {
                case 1:
                    acVar.jPF = aVar3.vHC.rY();
                    return 0;
                case 2:
                    acVar.jPC = aVar3.vHC.rY();
                    return 0;
                case 3:
                    acVar.jPA = aVar3.vHC.readString();
                    return 0;
                case 4:
                    acVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bz bzVar = new bz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzVar.a(aVar4, bzVar, a.a(aVar4))) {
                        }
                        acVar.jQr = bzVar;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        dk dkVar = new dk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dkVar.a(aVar4, dkVar, a.a(aVar4))) {
                        }
                        acVar.jQs = dkVar;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ci ciVar = new ci();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ciVar.a(aVar4, ciVar, a.a(aVar4))) {
                        }
                        acVar.jQt = ciVar;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cj cjVar = new cj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.a(aVar4, cjVar, a.a(aVar4))) {
                        }
                        acVar.jQu = cjVar;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        av avVar = new av();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avVar.a(aVar4, avVar, a.a(aVar4))) {
                        }
                        acVar.jQv = avVar;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cr crVar = new cr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = crVar.a(aVar4, crVar, a.a(aVar4))) {
                        }
                        acVar.jQw = crVar;
                    }
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ar arVar = new ar();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arVar.a(aVar4, arVar, a.a(aVar4))) {
                        }
                        acVar.jQx = arVar;
                    }
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        o oVar = new o();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        acVar.jQy = oVar;
                    }
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cm cmVar = new cm();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmVar.a(aVar4, cmVar, a.a(aVar4))) {
                        }
                        acVar.jQz = cmVar;
                    }
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cw cwVar = new cw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwVar.a(aVar4, cwVar, a.a(aVar4))) {
                        }
                        acVar.jQA = cwVar;
                    }
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        nVar = new n();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nVar.a(aVar4, nVar, a.a(aVar4))) {
                        }
                        acVar.jQB = nVar;
                    }
                    return 0;
                case 16:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        nVar = new n();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nVar.a(aVar4, nVar, a.a(aVar4))) {
                        }
                        acVar.jQC = nVar;
                    }
                    return 0;
                case 17:
                    acVar.jOU = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
