package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ajk extends bhd {
    public bhz rMm;
    public bhz rMn;
    public bhy rMo;
    public bhy rhB;
    public bhz rvi;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rvi == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.rMm == null) {
                throw new b("Not all required fields were included: Pwd");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.rvi != null) {
                    aVar.fV(2, this.rvi.boi());
                    this.rvi.a(aVar);
                }
                if (this.rMm != null) {
                    aVar.fV(3, this.rMm.boi());
                    this.rMm.a(aVar);
                }
                if (this.rMn != null) {
                    aVar.fV(4, this.rMn.boi());
                    this.rMn.a(aVar);
                }
                if (this.rhB != null) {
                    aVar.fV(5, this.rhB.boi());
                    this.rhB.a(aVar);
                }
                if (this.rMo == null) {
                    return 0;
                }
                aVar.fV(6, this.rMo.boi());
                this.rMo.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rvi != null) {
                fS += f.a.a.a.fS(2, this.rvi.boi());
            }
            if (this.rMm != null) {
                fS += f.a.a.a.fS(3, this.rMm.boi());
            }
            if (this.rMn != null) {
                fS += f.a.a.a.fS(4, this.rMn.boi());
            }
            if (this.rhB != null) {
                fS += f.a.a.a.fS(5, this.rhB.boi());
            }
            if (this.rMo != null) {
                fS += f.a.a.a.fS(6, this.rMo.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rvi == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.rMm != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Pwd");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ajk ajk = (ajk) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        ajk.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        ajk.rvi = bhz;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        ajk.rMm = bhz;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        ajk.rMn = bhz;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        ajk.rhB = bhy;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        ajk.rMo = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
