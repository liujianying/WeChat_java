package com.tencent.mm.protocal.c;

import com.tencent.mm.plugin.appbrand.s$l;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class yp extends bhp {
    public String SSID;
    public String bHD;
    public String hbL;
    public String jSA;
    public String ksB;
    public String qYZ;
    public int qZk;
    public bhy rEB;
    public String rEC;
    public String rED;
    public aok rEE;
    public yl rEF;
    public String rEG;
    public int rEH;
    public LinkedList<ir> rEI = new LinkedList();
    public String rEJ;
    public qw rEK;
    public bhy rEL;
    public int rEM;
    public LinkedList<amu> rEN = new LinkedList();
    public String rEO;
    public String rEP;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.rEC != null) {
                aVar.g(2, this.rEC);
            }
            if (this.rED != null) {
                aVar.g(3, this.rED);
            }
            aVar.fT(4, this.qZk);
            if (this.bHD != null) {
                aVar.g(5, this.bHD);
            }
            if (this.jSA != null) {
                aVar.g(6, this.jSA);
            }
            if (this.rEE != null) {
                aVar.fV(7, this.rEE.boi());
                this.rEE.a(aVar);
            }
            if (this.rEF != null) {
                aVar.fV(8, this.rEF.boi());
                this.rEF.a(aVar);
            }
            if (this.hbL != null) {
                aVar.g(9, this.hbL);
            }
            if (this.rEG != null) {
                aVar.g(15, this.rEG);
            }
            aVar.fT(16, this.rEH);
            aVar.d(17, 8, this.rEI);
            if (this.rEJ != null) {
                aVar.g(18, this.rEJ);
            }
            if (this.SSID != null) {
                aVar.g(20, this.SSID);
            }
            if (this.qYZ != null) {
                aVar.g(21, this.qYZ);
            }
            if (this.rEK != null) {
                aVar.fV(22, this.rEK.boi());
                this.rEK.a(aVar);
            }
            if (this.rEL != null) {
                aVar.fV(23, this.rEL.boi());
                this.rEL.a(aVar);
            }
            aVar.fT(24, this.rEM);
            aVar.d(25, 8, this.rEN);
            if (this.ksB != null) {
                aVar.g(26, this.ksB);
            }
            if (this.rEO != null) {
                aVar.g(27, this.rEO);
            }
            if (this.rEB != null) {
                aVar.fV(28, this.rEB.boi());
                this.rEB.a(aVar);
            }
            if (this.rEP == null) {
                return 0;
            }
            aVar.g(29, this.rEP);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rEC != null) {
                fS += f.a.a.b.b.a.h(2, this.rEC);
            }
            if (this.rED != null) {
                fS += f.a.a.b.b.a.h(3, this.rED);
            }
            fS += f.a.a.a.fQ(4, this.qZk);
            if (this.bHD != null) {
                fS += f.a.a.b.b.a.h(5, this.bHD);
            }
            if (this.jSA != null) {
                fS += f.a.a.b.b.a.h(6, this.jSA);
            }
            if (this.rEE != null) {
                fS += f.a.a.a.fS(7, this.rEE.boi());
            }
            if (this.rEF != null) {
                fS += f.a.a.a.fS(8, this.rEF.boi());
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(9, this.hbL);
            }
            if (this.rEG != null) {
                fS += f.a.a.b.b.a.h(15, this.rEG);
            }
            fS = (fS + f.a.a.a.fQ(16, this.rEH)) + f.a.a.a.c(17, 8, this.rEI);
            if (this.rEJ != null) {
                fS += f.a.a.b.b.a.h(18, this.rEJ);
            }
            if (this.SSID != null) {
                fS += f.a.a.b.b.a.h(20, this.SSID);
            }
            if (this.qYZ != null) {
                fS += f.a.a.b.b.a.h(21, this.qYZ);
            }
            if (this.rEK != null) {
                fS += f.a.a.a.fS(22, this.rEK.boi());
            }
            if (this.rEL != null) {
                fS += f.a.a.a.fS(23, this.rEL.boi());
            }
            fS = (fS + f.a.a.a.fQ(24, this.rEM)) + f.a.a.a.c(25, 8, this.rEN);
            if (this.ksB != null) {
                fS += f.a.a.b.b.a.h(26, this.ksB);
            }
            if (this.rEO != null) {
                fS += f.a.a.b.b.a.h(27, this.rEO);
            }
            if (this.rEB != null) {
                fS += f.a.a.a.fS(28, this.rEB.boi());
            }
            if (this.rEP != null) {
                fS += f.a.a.b.b.a.h(29, this.rEP);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rEI.clear();
            this.rEN.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            yp ypVar = (yp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bhy bhy;
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
                        ypVar.six = flVar;
                    }
                    return 0;
                case 2:
                    ypVar.rEC = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ypVar.rED = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ypVar.qZk = aVar3.vHC.rY();
                    return 0;
                case 5:
                    ypVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ypVar.jSA = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aok aok = new aok();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aok.a(aVar4, aok, bhp.a(aVar4))) {
                        }
                        ypVar.rEE = aok;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        yl ylVar = new yl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ylVar.a(aVar4, ylVar, bhp.a(aVar4))) {
                        }
                        ypVar.rEF = ylVar;
                    }
                    return 0;
                case 9:
                    ypVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 15:
                    ypVar.rEG = aVar3.vHC.readString();
                    return 0;
                case 16:
                    ypVar.rEH = aVar3.vHC.rY();
                    return 0;
                case 17:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ir irVar = new ir();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = irVar.a(aVar4, irVar, bhp.a(aVar4))) {
                        }
                        ypVar.rEI.add(irVar);
                    }
                    return 0;
                case 18:
                    ypVar.rEJ = aVar3.vHC.readString();
                    return 0;
                case 20:
                    ypVar.SSID = aVar3.vHC.readString();
                    return 0;
                case 21:
                    ypVar.qYZ = aVar3.vHC.readString();
                    return 0;
                case 22:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qw qwVar = new qw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qwVar.a(aVar4, qwVar, bhp.a(aVar4))) {
                        }
                        ypVar.rEK = qwVar;
                    }
                    return 0;
                case 23:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        ypVar.rEL = bhy;
                    }
                    return 0;
                case 24:
                    ypVar.rEM = aVar3.vHC.rY();
                    return 0;
                case 25:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amu amu = new amu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amu.a(aVar4, amu, bhp.a(aVar4))) {
                        }
                        ypVar.rEN.add(amu);
                    }
                    return 0;
                case 26:
                    ypVar.ksB = aVar3.vHC.readString();
                    return 0;
                case 27:
                    ypVar.rEO = aVar3.vHC.readString();
                    return 0;
                case s$l.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        ypVar.rEB = bhy;
                    }
                    return 0;
                case s$l.AppCompatTheme_actionModeBackground /*29*/:
                    ypVar.rEP = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
