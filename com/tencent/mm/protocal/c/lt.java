package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class lt extends bhp {
    public int myh;
    public String myi;
    public String myj;
    public String plj;
    public LinkedList<atm> rpN = new LinkedList();
    public atm rpO;
    public String rpP;
    public boolean rpQ;
    public String rpR;
    public int rpS;
    public att rpT;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.url == null) {
                throw new b("Not all required fields were included: url");
            } else if (this.rpO == null) {
                throw new b("Not all required fields were included: bottom_item");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.url != null) {
                    aVar.g(2, this.url);
                }
                aVar.d(3, 8, this.rpN);
                if (this.rpO != null) {
                    aVar.fV(4, this.rpO.boi());
                    this.rpO.a(aVar);
                }
                if (this.plj != null) {
                    aVar.g(5, this.plj);
                }
                if (this.rpP != null) {
                    aVar.g(6, this.rpP);
                }
                aVar.av(7, this.rpQ);
                aVar.fT(8, this.myh);
                if (this.rpR != null) {
                    aVar.g(9, this.rpR);
                }
                if (this.myi != null) {
                    aVar.g(10, this.myi);
                }
                if (this.myj != null) {
                    aVar.g(11, this.myj);
                }
                aVar.fT(12, this.rpS);
                if (this.rpT == null) {
                    return 0;
                }
                aVar.fV(13, this.rpT.boi());
                this.rpT.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.url != null) {
                fS += f.a.a.b.b.a.h(2, this.url);
            }
            fS += f.a.a.a.c(3, 8, this.rpN);
            if (this.rpO != null) {
                fS += f.a.a.a.fS(4, this.rpO.boi());
            }
            if (this.plj != null) {
                fS += f.a.a.b.b.a.h(5, this.plj);
            }
            if (this.rpP != null) {
                fS += f.a.a.b.b.a.h(6, this.rpP);
            }
            fS = (fS + (f.a.a.b.b.a.ec(7) + 1)) + f.a.a.a.fQ(8, this.myh);
            if (this.rpR != null) {
                fS += f.a.a.b.b.a.h(9, this.rpR);
            }
            if (this.myi != null) {
                fS += f.a.a.b.b.a.h(10, this.myi);
            }
            if (this.myj != null) {
                fS += f.a.a.b.b.a.h(11, this.myj);
            }
            fS += f.a.a.a.fQ(12, this.rpS);
            if (this.rpT != null) {
                fS += f.a.a.a.fS(13, this.rpT.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rpN.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.url == null) {
                throw new b("Not all required fields were included: url");
            } else if (this.rpO != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bottom_item");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            lt ltVar = (lt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            atm atm;
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
                        ltVar.six = flVar;
                    }
                    return 0;
                case 2:
                    ltVar.url = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        atm = new atm();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atm.a(aVar4, atm, bhp.a(aVar4))) {
                        }
                        ltVar.rpN.add(atm);
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        atm = new atm();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atm.a(aVar4, atm, bhp.a(aVar4))) {
                        }
                        ltVar.rpO = atm;
                    }
                    return 0;
                case 5:
                    ltVar.plj = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ltVar.rpP = aVar3.vHC.readString();
                    return 0;
                case 7:
                    ltVar.rpQ = aVar3.cJQ();
                    return 0;
                case 8:
                    ltVar.myh = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ltVar.rpR = aVar3.vHC.readString();
                    return 0;
                case 10:
                    ltVar.myi = aVar3.vHC.readString();
                    return 0;
                case 11:
                    ltVar.myj = aVar3.vHC.readString();
                    return 0;
                case 12:
                    ltVar.rpS = aVar3.vHC.rY();
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        att att = new att();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = att.a(aVar4, att, bhp.a(aVar4))) {
                        }
                        ltVar.rpT = att;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
