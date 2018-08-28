package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.fl;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class az extends bhp {
    public e jOV;
    public br jRA;
    public ct jRB;
    public LinkedList<u> jRC = new LinkedList();
    public cy jRD;
    public bt jRE;
    public bq jRF;
    public String jRw;
    public LinkedList<t> jRx = new LinkedList();
    public ce jRy;
    public bu jRz;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.jOV == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.jRw == null) {
                throw new b("Not all required fields were included: BackGroundURL");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.jOV != null) {
                    aVar.fV(2, this.jOV.boi());
                    this.jOV.a(aVar);
                }
                if (this.jRw != null) {
                    aVar.g(3, this.jRw);
                }
                aVar.d(4, 8, this.jRx);
                if (this.jRy != null) {
                    aVar.fV(5, this.jRy.boi());
                    this.jRy.a(aVar);
                }
                if (this.jRz != null) {
                    aVar.fV(7, this.jRz.boi());
                    this.jRz.a(aVar);
                }
                if (this.jRA != null) {
                    aVar.fV(8, this.jRA.boi());
                    this.jRA.a(aVar);
                }
                if (this.jRB != null) {
                    aVar.fV(9, this.jRB.boi());
                    this.jRB.a(aVar);
                }
                aVar.d(10, 8, this.jRC);
                if (this.jRD != null) {
                    aVar.fV(11, this.jRD.boi());
                    this.jRD.a(aVar);
                }
                if (this.jRE != null) {
                    aVar.fV(12, this.jRE.boi());
                    this.jRE.a(aVar);
                }
                if (this.jRF == null) {
                    return 0;
                }
                aVar.fV(13, this.jRF.boi());
                this.jRF.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jOV != null) {
                fS += f.a.a.a.fS(2, this.jOV.boi());
            }
            if (this.jRw != null) {
                fS += f.a.a.b.b.a.h(3, this.jRw);
            }
            fS += f.a.a.a.c(4, 8, this.jRx);
            if (this.jRy != null) {
                fS += f.a.a.a.fS(5, this.jRy.boi());
            }
            if (this.jRz != null) {
                fS += f.a.a.a.fS(7, this.jRz.boi());
            }
            if (this.jRA != null) {
                fS += f.a.a.a.fS(8, this.jRA.boi());
            }
            if (this.jRB != null) {
                fS += f.a.a.a.fS(9, this.jRB.boi());
            }
            fS += f.a.a.a.c(10, 8, this.jRC);
            if (this.jRD != null) {
                fS += f.a.a.a.fS(11, this.jRD.boi());
            }
            if (this.jRE != null) {
                fS += f.a.a.a.fS(12, this.jRE.boi());
            }
            if (this.jRF != null) {
                fS += f.a.a.a.fS(13, this.jRF.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jRx.clear();
            this.jRC.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.jOV == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.jRw != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BackGroundURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            az azVar = (az) objArr[1];
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
                        azVar.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, bhp.a(aVar4))) {
                        }
                        azVar.jOV = eVar;
                    }
                    return 0;
                case 3:
                    azVar.jRw = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        t tVar = new t();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.a(aVar4, tVar, bhp.a(aVar4))) {
                        }
                        azVar.jRx.add(tVar);
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ce ceVar = new ce();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ceVar.a(aVar4, ceVar, bhp.a(aVar4))) {
                        }
                        azVar.jRy = ceVar;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bu buVar = new bu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buVar.a(aVar4, buVar, bhp.a(aVar4))) {
                        }
                        azVar.jRz = buVar;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        br brVar = new br();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brVar.a(aVar4, brVar, bhp.a(aVar4))) {
                        }
                        azVar.jRA = brVar;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ct ctVar = new ct();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ctVar.a(aVar4, ctVar, bhp.a(aVar4))) {
                        }
                        azVar.jRB = ctVar;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        u uVar = new u();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uVar.a(aVar4, uVar, bhp.a(aVar4))) {
                        }
                        azVar.jRC.add(uVar);
                    }
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cy cyVar = new cy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyVar.a(aVar4, cyVar, bhp.a(aVar4))) {
                        }
                        azVar.jRD = cyVar;
                    }
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bt btVar = new bt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btVar.a(aVar4, btVar, bhp.a(aVar4))) {
                        }
                        azVar.jRE = btVar;
                    }
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bq bqVar = new bq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqVar.a(aVar4, bqVar, bhp.a(aVar4))) {
                        }
                        azVar.jRF = bqVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
