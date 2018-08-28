package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class abc extends bhp {
    public kg roC;
    public kg roD;
    public kg roE;
    public bhy roF;
    public bhy roG;
    public kg roH;
    public int roI;
    public kf roJ;
    public kf roK;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.roC == null) {
                throw new b("Not all required fields were included: DnsInfo");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.roC != null) {
                    aVar.fV(2, this.roC.boi());
                    this.roC.a(aVar);
                }
                if (this.roD != null) {
                    aVar.fV(3, this.roD.boi());
                    this.roD.a(aVar);
                }
                if (this.roE != null) {
                    aVar.fV(4, this.roE.boi());
                    this.roE.a(aVar);
                }
                if (this.roF != null) {
                    aVar.fV(5, this.roF.boi());
                    this.roF.a(aVar);
                }
                if (this.roG != null) {
                    aVar.fV(6, this.roG.boi());
                    this.roG.a(aVar);
                }
                if (this.roH != null) {
                    aVar.fV(7, this.roH.boi());
                    this.roH.a(aVar);
                }
                aVar.fT(8, this.roI);
                if (this.roJ != null) {
                    aVar.fV(9, this.roJ.boi());
                    this.roJ.a(aVar);
                }
                if (this.roK == null) {
                    return 0;
                }
                aVar.fV(10, this.roK.boi());
                this.roK.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.roC != null) {
                fS += f.a.a.a.fS(2, this.roC.boi());
            }
            if (this.roD != null) {
                fS += f.a.a.a.fS(3, this.roD.boi());
            }
            if (this.roE != null) {
                fS += f.a.a.a.fS(4, this.roE.boi());
            }
            if (this.roF != null) {
                fS += f.a.a.a.fS(5, this.roF.boi());
            }
            if (this.roG != null) {
                fS += f.a.a.a.fS(6, this.roG.boi());
            }
            if (this.roH != null) {
                fS += f.a.a.a.fS(7, this.roH.boi());
            }
            fS += f.a.a.a.fQ(8, this.roI);
            if (this.roJ != null) {
                fS += f.a.a.a.fS(9, this.roJ.boi());
            }
            if (this.roK != null) {
                fS += f.a.a.a.fS(10, this.roK.boi());
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
            } else if (this.roC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DnsInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            abc abc = (abc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            kg kgVar;
            bhy bhy;
            kf kfVar;
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
                        abc.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        kgVar = new kg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kgVar.a(aVar4, kgVar, bhp.a(aVar4))) {
                        }
                        abc.roC = kgVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        kgVar = new kg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kgVar.a(aVar4, kgVar, bhp.a(aVar4))) {
                        }
                        abc.roD = kgVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        kgVar = new kg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kgVar.a(aVar4, kgVar, bhp.a(aVar4))) {
                        }
                        abc.roE = kgVar;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        abc.roF = bhy;
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
                        abc.roG = bhy;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        kgVar = new kg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kgVar.a(aVar4, kgVar, bhp.a(aVar4))) {
                        }
                        abc.roH = kgVar;
                    }
                    return 0;
                case 8:
                    abc.roI = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        kfVar = new kf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kfVar.a(aVar4, kfVar, bhp.a(aVar4))) {
                        }
                        abc.roJ = kfVar;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        kfVar = new kf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kfVar.a(aVar4, kfVar, bhp.a(aVar4))) {
                        }
                        abc.roK = kfVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
