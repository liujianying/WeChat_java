package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.game.f$k;
import java.util.LinkedList;

public final class wl extends a {
    public String desc;
    public String fky;
    public wf qYa;
    public long qYb;
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
    public wr rBG;
    public boolean rBH = false;
    public LinkedList<vx> rBI = new LinkedList();
    public boolean rBJ = false;
    public boolean rBK = false;
    public vv rBa;
    public boolean rBb = false;
    public boolean rzh = false;
    public boolean rzi = false;
    public String title;
    public int version;

    public final wl a(wr wrVar) {
        this.rBG = wrVar;
        this.rBH = true;
        return this;
    }

    public final wl ar(LinkedList<vx> linkedList) {
        this.rBI = linkedList;
        this.rBJ = true;
        return this;
    }

    public final wl b(we weVar) {
        this.rAL = weVar;
        this.rAM = true;
        return this;
    }

    public final wl b(xa xaVar) {
        this.rAN = xaVar;
        this.rAO = true;
        return this;
    }

    public final wl Vt(String str) {
        this.fky = str;
        this.rAT = true;
        return this;
    }

    public final wl Vu(String str) {
        this.title = str;
        this.rzh = true;
        return this;
    }

    public final wl Vv(String str) {
        this.desc = str;
        this.rzi = true;
        return this;
    }

    public final wl fS(long j) {
        this.rAU = j;
        this.rAV = true;
        return this;
    }

    public final wl CM(int i) {
        this.rAW = i;
        this.rAX = true;
        return this;
    }

    public final wl b(wk wkVar) {
        this.rAP = wkVar;
        this.rAQ = true;
        return this;
    }

    public final wl fT(long j) {
        this.qYb = j;
        this.rAY = true;
        return this;
    }

    public final wl b(wu wuVar) {
        this.rAR = wuVar;
        this.rAS = true;
        return this;
    }

    public final wl CN(int i) {
        this.version = i;
        this.rBK = true;
        return this;
    }

    public final wl a(wf wfVar) {
        this.qYa = wfVar;
        this.rAZ = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rBG != null) {
                aVar.fV(1, this.rBG.boi());
                this.rBG.a(aVar);
            }
            aVar.d(2, 8, this.rBI);
            if (this.rAL != null) {
                aVar.fV(3, this.rAL.boi());
                this.rAL.a(aVar);
            }
            if (this.rAN != null) {
                aVar.fV(4, this.rAN.boi());
                this.rAN.a(aVar);
            }
            if (this.fky != null) {
                aVar.g(5, this.fky);
            }
            if (this.title != null) {
                aVar.g(6, this.title);
            }
            if (this.desc != null) {
                aVar.g(7, this.desc);
            }
            if (this.rAV) {
                aVar.T(8, this.rAU);
            }
            if (this.rAX) {
                aVar.fT(91, this.rAW);
            }
            if (this.rAP != null) {
                aVar.fV(10, this.rAP.boi());
                this.rAP.a(aVar);
            }
            if (this.rAY) {
                aVar.T(11, this.qYb);
            }
            if (this.rAR != null) {
                aVar.fV(12, this.rAR.boi());
                this.rAR.a(aVar);
            }
            if (this.rBK) {
                aVar.fT(13, this.version);
            }
            if (this.qYa != null) {
                aVar.fV(14, this.qYa.boi());
                this.qYa.a(aVar);
            }
            if (this.rBa == null) {
                return 0;
            }
            aVar.fV(15, this.rBa.boi());
            this.rBa.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.rBG != null) {
                fS = f.a.a.a.fS(1, this.rBG.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.c(2, 8, this.rBI);
            if (this.rAL != null) {
                fS += f.a.a.a.fS(3, this.rAL.boi());
            }
            if (this.rAN != null) {
                fS += f.a.a.a.fS(4, this.rAN.boi());
            }
            if (this.fky != null) {
                fS += f.a.a.b.b.a.h(5, this.fky);
            }
            if (this.title != null) {
                fS += f.a.a.b.b.a.h(6, this.title);
            }
            if (this.desc != null) {
                fS += f.a.a.b.b.a.h(7, this.desc);
            }
            if (this.rAV) {
                fS += f.a.a.a.S(8, this.rAU);
            }
            if (this.rAX) {
                fS += f.a.a.a.fQ(91, this.rAW);
            }
            if (this.rAP != null) {
                fS += f.a.a.a.fS(10, this.rAP.boi());
            }
            if (this.rAY) {
                fS += f.a.a.a.S(11, this.qYb);
            }
            if (this.rAR != null) {
                fS += f.a.a.a.fS(12, this.rAR.boi());
            }
            if (this.rBK) {
                fS += f.a.a.a.fQ(13, this.version);
            }
            if (this.qYa != null) {
                fS += f.a.a.a.fS(14, this.qYa.boi());
            }
            if (this.rBa != null) {
                fS += f.a.a.a.fS(15, this.rBa.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rBI.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            wl wlVar = (wl) objArr[1];
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
                        wr wrVar = new wr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wrVar.a(aVar4, wrVar, a.a(aVar4))) {
                        }
                        wlVar.rBG = wrVar;
                    }
                    wlVar.rBH = true;
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        vx vxVar = new vx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vxVar.a(aVar4, vxVar, a.a(aVar4))) {
                        }
                        wlVar.rBI.add(vxVar);
                    }
                    wlVar.rBJ = true;
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        we weVar = new we();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = weVar.a(aVar4, weVar, a.a(aVar4))) {
                        }
                        wlVar.rAL = weVar;
                    }
                    wlVar.rAM = true;
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xa xaVar = new xa();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xaVar.a(aVar4, xaVar, a.a(aVar4))) {
                        }
                        wlVar.rAN = xaVar;
                    }
                    wlVar.rAO = true;
                    return 0;
                case 5:
                    wlVar.fky = aVar3.vHC.readString();
                    wlVar.rAT = true;
                    return 0;
                case 6:
                    wlVar.title = aVar3.vHC.readString();
                    wlVar.rzh = true;
                    return 0;
                case 7:
                    wlVar.desc = aVar3.vHC.readString();
                    wlVar.rzi = true;
                    return 0;
                case 8:
                    wlVar.rAU = aVar3.vHC.rZ();
                    wlVar.rAV = true;
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        wk wkVar = new wk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wkVar.a(aVar4, wkVar, a.a(aVar4))) {
                        }
                        wlVar.rAP = wkVar;
                    }
                    wlVar.rAQ = true;
                    return 0;
                case 11:
                    wlVar.qYb = aVar3.vHC.rZ();
                    wlVar.rAY = true;
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        wu wuVar = new wu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wuVar.a(aVar4, wuVar, a.a(aVar4))) {
                        }
                        wlVar.rAR = wuVar;
                    }
                    wlVar.rAS = true;
                    return 0;
                case 13:
                    wlVar.version = aVar3.vHC.rY();
                    wlVar.rBK = true;
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        wf wfVar = new wf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wfVar.a(aVar4, wfVar, a.a(aVar4))) {
                        }
                        wlVar.qYa = wfVar;
                    }
                    wlVar.rAZ = true;
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        vv vvVar = new vv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vvVar.a(aVar4, vvVar, a.a(aVar4))) {
                        }
                        wlVar.rBa = vvVar;
                    }
                    wlVar.rBb = true;
                    return 0;
                case f$k.AppCompatTheme_alertDialogStyle /*91*/:
                    wlVar.rAW = aVar3.vHC.rY();
                    wlVar.rAX = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
