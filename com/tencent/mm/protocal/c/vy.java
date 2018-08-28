package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.appbrand.s$l;
import java.util.LinkedList;

public final class vy extends a {
    public String desc;
    public String fky;
    public wf qYa;
    public long qYb;
    public vz rAJ;
    public boolean rAK = false;
    public we rAL;
    public boolean rAM = false;
    public xa rAN;
    public boolean rAO = false;
    public wk rAP;
    public boolean rAQ = false;
    public wu rAR;
    public boolean rAS = false;
    public boolean rAT = false;
    public long rAU;
    public boolean rAV = false;
    public int rAW = -1;
    public boolean rAX = false;
    public boolean rAY = false;
    public boolean rAZ = false;
    public vv rBa;
    public boolean rBb = false;
    public boolean rzh = false;
    public boolean rzi = false;
    public String title;

    public final vy c(vz vzVar) {
        this.rAJ = vzVar;
        this.rAK = true;
        return this;
    }

    public final vy a(we weVar) {
        this.rAL = weVar;
        this.rAM = true;
        return this;
    }

    public final vy a(xa xaVar) {
        this.rAN = xaVar;
        this.rAO = true;
        return this;
    }

    public final vy a(wk wkVar) {
        this.rAP = wkVar;
        this.rAQ = true;
        return this;
    }

    public final vy a(wu wuVar) {
        this.rAR = wuVar;
        this.rAS = true;
        return this;
    }

    public final vy a(vv vvVar) {
        this.rBa = vvVar;
        this.rBb = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rAJ != null) {
                aVar.fV(1, this.rAJ.boi());
                this.rAJ.a(aVar);
            }
            if (this.rAL != null) {
                aVar.fV(2, this.rAL.boi());
                this.rAL.a(aVar);
            }
            if (this.rAN != null) {
                aVar.fV(3, this.rAN.boi());
                this.rAN.a(aVar);
            }
            if (this.rAP != null) {
                aVar.fV(4, this.rAP.boi());
                this.rAP.a(aVar);
            }
            if (this.rAR != null) {
                aVar.fV(5, this.rAR.boi());
                this.rAR.a(aVar);
            }
            if (this.fky != null) {
                aVar.g(6, this.fky);
            }
            if (this.title != null) {
                aVar.g(7, this.title);
            }
            if (this.desc != null) {
                aVar.g(8, this.desc);
            }
            if (this.rAV) {
                aVar.T(9, this.rAU);
            }
            if (this.rAX) {
                aVar.fT(s$l.AppCompatTheme_buttonStyleSmall, this.rAW);
            }
            if (this.rAY) {
                aVar.T(11, this.qYb);
            }
            if (this.qYa != null) {
                aVar.fV(12, this.qYa.boi());
                this.qYa.a(aVar);
            }
            if (this.rBa == null) {
                return 0;
            }
            aVar.fV(13, this.rBa.boi());
            this.rBa.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.rAJ != null) {
                fS = f.a.a.a.fS(1, this.rAJ.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rAL != null) {
                fS += f.a.a.a.fS(2, this.rAL.boi());
            }
            if (this.rAN != null) {
                fS += f.a.a.a.fS(3, this.rAN.boi());
            }
            if (this.rAP != null) {
                fS += f.a.a.a.fS(4, this.rAP.boi());
            }
            if (this.rAR != null) {
                fS += f.a.a.a.fS(5, this.rAR.boi());
            }
            if (this.fky != null) {
                fS += f.a.a.b.b.a.h(6, this.fky);
            }
            if (this.title != null) {
                fS += f.a.a.b.b.a.h(7, this.title);
            }
            if (this.desc != null) {
                fS += f.a.a.b.b.a.h(8, this.desc);
            }
            if (this.rAV) {
                fS += f.a.a.a.S(9, this.rAU);
            }
            if (this.rAX) {
                fS += f.a.a.a.fQ(s$l.AppCompatTheme_buttonStyleSmall, this.rAW);
            }
            if (this.rAY) {
                fS += f.a.a.a.S(11, this.qYb);
            }
            if (this.qYa != null) {
                fS += f.a.a.a.fS(12, this.qYa.boi());
            }
            if (this.rBa != null) {
                fS += f.a.a.a.fS(13, this.rBa.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            vy vyVar = (vy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        vz vzVar = new vz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vzVar.a(aVar4, vzVar, a.a(aVar4))) {
                        }
                        vyVar.rAJ = vzVar;
                    }
                    vyVar.rAK = true;
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        we weVar = new we();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = weVar.a(aVar4, weVar, a.a(aVar4))) {
                        }
                        vyVar.rAL = weVar;
                    }
                    vyVar.rAM = true;
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xa xaVar = new xa();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xaVar.a(aVar4, xaVar, a.a(aVar4))) {
                        }
                        vyVar.rAN = xaVar;
                    }
                    vyVar.rAO = true;
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        wk wkVar = new wk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wkVar.a(aVar4, wkVar, a.a(aVar4))) {
                        }
                        vyVar.rAP = wkVar;
                    }
                    vyVar.rAQ = true;
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        wu wuVar = new wu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wuVar.a(aVar4, wuVar, a.a(aVar4))) {
                        }
                        vyVar.rAR = wuVar;
                    }
                    vyVar.rAS = true;
                    return 0;
                case 6:
                    vyVar.fky = aVar3.vHC.readString();
                    vyVar.rAT = true;
                    return 0;
                case 7:
                    vyVar.title = aVar3.vHC.readString();
                    vyVar.rzh = true;
                    return 0;
                case 8:
                    vyVar.desc = aVar3.vHC.readString();
                    vyVar.rzi = true;
                    return 0;
                case 9:
                    vyVar.rAU = aVar3.vHC.rZ();
                    vyVar.rAV = true;
                    return 0;
                case 11:
                    vyVar.qYb = aVar3.vHC.rZ();
                    vyVar.rAY = true;
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        wf wfVar = new wf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wfVar.a(aVar4, wfVar, a.a(aVar4))) {
                        }
                        vyVar.qYa = wfVar;
                    }
                    vyVar.rAZ = true;
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        vv vvVar = new vv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vvVar.a(aVar4, vvVar, a.a(aVar4))) {
                        }
                        vyVar.rBa = vvVar;
                    }
                    vyVar.rBb = true;
                    return 0;
                case s$l.AppCompatTheme_buttonStyleSmall /*101*/:
                    vyVar.rAW = aVar3.vHC.rY();
                    vyVar.rAX = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
