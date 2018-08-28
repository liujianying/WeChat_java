package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ajh extends bhp {
    public String dxc;
    public boolean ixT;
    public LinkedList<String> rLU = new LinkedList();
    public String rLV;
    public String rLW;
    public boolean rLY;
    public LinkedList<cie> rMb = new LinkedList();
    public LinkedList<cif> rMc = new LinkedList();
    public String rMd;
    public String rMe;
    public String rMf;
    public String rMg;
    public boolean rMh;
    public int rMi;
    public String rMj;
    public LinkedList<xj> rch = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rMd == null) {
                throw new b("Not all required fields were included: championcoverurl");
            } else if (this.rMe == null) {
                throw new b("Not all required fields were included: championmotto");
            } else if (this.dxc == null) {
                throw new b("Not all required fields were included: rankid");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.d(2, 8, this.rMb);
                aVar.d(3, 8, this.rMc);
                aVar.d(4, 1, this.rLU);
                if (this.rMd != null) {
                    aVar.g(5, this.rMd);
                }
                if (this.rMe != null) {
                    aVar.g(6, this.rMe);
                }
                if (this.dxc != null) {
                    aVar.g(7, this.dxc);
                }
                if (this.rMf != null) {
                    aVar.g(8, this.rMf);
                }
                if (this.rLV != null) {
                    aVar.g(9, this.rLV);
                }
                aVar.av(10, this.ixT);
                if (this.rLW != null) {
                    aVar.g(11, this.rLW);
                }
                aVar.d(12, 8, this.rch);
                aVar.av(13, this.rLY);
                if (this.rMg != null) {
                    aVar.g(14, this.rMg);
                }
                aVar.av(15, this.rMh);
                aVar.fT(16, this.rMi);
                if (this.rMj == null) {
                    return 0;
                }
                aVar.g(17, this.rMj);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((fS + f.a.a.a.c(2, 8, this.rMb)) + f.a.a.a.c(3, 8, this.rMc)) + f.a.a.a.c(4, 1, this.rLU);
            if (this.rMd != null) {
                fS += f.a.a.b.b.a.h(5, this.rMd);
            }
            if (this.rMe != null) {
                fS += f.a.a.b.b.a.h(6, this.rMe);
            }
            if (this.dxc != null) {
                fS += f.a.a.b.b.a.h(7, this.dxc);
            }
            if (this.rMf != null) {
                fS += f.a.a.b.b.a.h(8, this.rMf);
            }
            if (this.rLV != null) {
                fS += f.a.a.b.b.a.h(9, this.rLV);
            }
            fS += f.a.a.b.b.a.ec(10) + 1;
            if (this.rLW != null) {
                fS += f.a.a.b.b.a.h(11, this.rLW);
            }
            fS = (fS + f.a.a.a.c(12, 8, this.rch)) + (f.a.a.b.b.a.ec(13) + 1);
            if (this.rMg != null) {
                fS += f.a.a.b.b.a.h(14, this.rMg);
            }
            fS = (fS + (f.a.a.b.b.a.ec(15) + 1)) + f.a.a.a.fQ(16, this.rMi);
            if (this.rMj != null) {
                fS += f.a.a.b.b.a.h(17, this.rMj);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rMb.clear();
            this.rMc.clear();
            this.rLU.clear();
            this.rch.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rMd == null) {
                throw new b("Not all required fields were included: championcoverurl");
            } else if (this.rMe == null) {
                throw new b("Not all required fields were included: championmotto");
            } else if (this.dxc != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: rankid");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ajh ajh = (ajh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
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
                        ajh.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cie cie = new cie();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cie.a(aVar4, cie, bhp.a(aVar4))) {
                        }
                        ajh.rMb.add(cie);
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cif cif = new cif();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cif.a(aVar4, cif, bhp.a(aVar4))) {
                        }
                        ajh.rMc.add(cif);
                    }
                    return 0;
                case 4:
                    ajh.rLU.add(aVar3.vHC.readString());
                    return 0;
                case 5:
                    ajh.rMd = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ajh.rMe = aVar3.vHC.readString();
                    return 0;
                case 7:
                    ajh.dxc = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ajh.rMf = aVar3.vHC.readString();
                    return 0;
                case 9:
                    ajh.rLV = aVar3.vHC.readString();
                    return 0;
                case 10:
                    ajh.ixT = aVar3.cJQ();
                    return 0;
                case 11:
                    ajh.rLW = aVar3.vHC.readString();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xj xjVar = new xj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xjVar.a(aVar4, xjVar, bhp.a(aVar4))) {
                        }
                        ajh.rch.add(xjVar);
                    }
                    return 0;
                case 13:
                    ajh.rLY = aVar3.cJQ();
                    return 0;
                case 14:
                    ajh.rMg = aVar3.vHC.readString();
                    return 0;
                case 15:
                    ajh.rMh = aVar3.cJQ();
                    return 0;
                case 16:
                    ajh.rMi = aVar3.vHC.rY();
                    return 0;
                case 17:
                    ajh.rMj = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
