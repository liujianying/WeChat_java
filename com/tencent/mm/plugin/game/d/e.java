package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class e extends a {
    public int hcD;
    public int hcd;
    public String jOS;
    public String jOX;
    public String jOZ;
    public String jPc;
    public String jPd;
    public String jPe;
    public String jPf;
    public String jPg;
    public int jPh;
    public q jPi;
    public int jPj;
    public boolean jPk;
    public LinkedList<String> jPl = new LinkedList();
    public boolean jPm;
    public boolean jPn;
    public boolean jPo;
    public boolean jPp;
    public cf jPq;
    public int jPr;
    public bw jPs;
    public LinkedList<String> jPt = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPc == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.jPd == null) {
                throw new b("Not all required fields were included: IconURL");
            } else {
                if (this.jPc != null) {
                    aVar.g(1, this.jPc);
                }
                if (this.jPd != null) {
                    aVar.g(2, this.jPd);
                }
                if (this.jPe != null) {
                    aVar.g(3, this.jPe);
                }
                if (this.jOS != null) {
                    aVar.g(4, this.jOS);
                }
                if (this.jPf != null) {
                    aVar.g(5, this.jPf);
                }
                if (this.jOX != null) {
                    aVar.g(6, this.jOX);
                }
                if (this.jPg != null) {
                    aVar.g(7, this.jPg);
                }
                aVar.fT(8, this.jPh);
                if (this.jPi != null) {
                    aVar.fV(9, this.jPi.boi());
                    this.jPi.a(aVar);
                }
                aVar.fT(10, this.hcd);
                aVar.fT(11, this.jPj);
                if (this.jOZ != null) {
                    aVar.g(12, this.jOZ);
                }
                aVar.av(13, this.jPk);
                aVar.d(14, 1, this.jPl);
                aVar.av(15, this.jPm);
                aVar.fT(16, this.hcD);
                aVar.av(17, this.jPn);
                aVar.av(18, this.jPo);
                aVar.av(19, this.jPp);
                if (this.jPq != null) {
                    aVar.fV(20, this.jPq.boi());
                    this.jPq.a(aVar);
                }
                aVar.fT(21, this.jPr);
                if (this.jPs != null) {
                    aVar.fV(22, this.jPs.boi());
                    this.jPs.a(aVar);
                }
                aVar.d(23, 1, this.jPt);
                return 0;
            }
        } else if (i == 1) {
            if (this.jPc != null) {
                h = f.a.a.b.b.a.h(1, this.jPc) + 0;
            } else {
                h = 0;
            }
            if (this.jPd != null) {
                h += f.a.a.b.b.a.h(2, this.jPd);
            }
            if (this.jPe != null) {
                h += f.a.a.b.b.a.h(3, this.jPe);
            }
            if (this.jOS != null) {
                h += f.a.a.b.b.a.h(4, this.jOS);
            }
            if (this.jPf != null) {
                h += f.a.a.b.b.a.h(5, this.jPf);
            }
            if (this.jOX != null) {
                h += f.a.a.b.b.a.h(6, this.jOX);
            }
            if (this.jPg != null) {
                h += f.a.a.b.b.a.h(7, this.jPg);
            }
            h += f.a.a.a.fQ(8, this.jPh);
            if (this.jPi != null) {
                h += f.a.a.a.fS(9, this.jPi.boi());
            }
            h = (h + f.a.a.a.fQ(10, this.hcd)) + f.a.a.a.fQ(11, this.jPj);
            if (this.jOZ != null) {
                h += f.a.a.b.b.a.h(12, this.jOZ);
            }
            h = ((((((h + (f.a.a.b.b.a.ec(13) + 1)) + f.a.a.a.c(14, 1, this.jPl)) + (f.a.a.b.b.a.ec(15) + 1)) + f.a.a.a.fQ(16, this.hcD)) + (f.a.a.b.b.a.ec(17) + 1)) + (f.a.a.b.b.a.ec(18) + 1)) + (f.a.a.b.b.a.ec(19) + 1);
            if (this.jPq != null) {
                h += f.a.a.a.fS(20, this.jPq.boi());
            }
            h += f.a.a.a.fQ(21, this.jPr);
            if (this.jPs != null) {
                h += f.a.a.a.fS(22, this.jPs.boi());
            }
            return h + f.a.a.a.c(23, 1, this.jPt);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jPl.clear();
            this.jPt.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jPc == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.jPd != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: IconURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    eVar.jPc = aVar3.vHC.readString();
                    return 0;
                case 2:
                    eVar.jPd = aVar3.vHC.readString();
                    return 0;
                case 3:
                    eVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 4:
                    eVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 5:
                    eVar.jPf = aVar3.vHC.readString();
                    return 0;
                case 6:
                    eVar.jOX = aVar3.vHC.readString();
                    return 0;
                case 7:
                    eVar.jPg = aVar3.vHC.readString();
                    return 0;
                case 8:
                    eVar.jPh = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        q qVar = new q();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        eVar.jPi = qVar;
                    }
                    return 0;
                case 10:
                    eVar.hcd = aVar3.vHC.rY();
                    return 0;
                case 11:
                    eVar.jPj = aVar3.vHC.rY();
                    return 0;
                case 12:
                    eVar.jOZ = aVar3.vHC.readString();
                    return 0;
                case 13:
                    eVar.jPk = aVar3.cJQ();
                    return 0;
                case 14:
                    eVar.jPl.add(aVar3.vHC.readString());
                    return 0;
                case 15:
                    eVar.jPm = aVar3.cJQ();
                    return 0;
                case 16:
                    eVar.hcD = aVar3.vHC.rY();
                    return 0;
                case 17:
                    eVar.jPn = aVar3.cJQ();
                    return 0;
                case 18:
                    eVar.jPo = aVar3.cJQ();
                    return 0;
                case 19:
                    eVar.jPp = aVar3.cJQ();
                    return 0;
                case 20:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cf cfVar = new cf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfVar.a(aVar4, cfVar, a.a(aVar4))) {
                        }
                        eVar.jPq = cfVar;
                    }
                    return 0;
                case 21:
                    eVar.jPr = aVar3.vHC.rY();
                    return 0;
                case 22:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bw bwVar = new bw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bwVar.a(aVar4, bwVar, a.a(aVar4))) {
                        }
                        eVar.jPs = bwVar;
                    }
                    return 0;
                case 23:
                    eVar.jPt.add(aVar3.vHC.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
