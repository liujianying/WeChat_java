package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bg extends bhd {
    public String bssid;
    public String egF;
    public int rbC;
    public bf rbD;
    public bi rbE;
    public int rbF;
    public int rbG;
    public int rbH;
    public String rbn;
    public long rbo;
    public int rbq;
    public String rbs;
    public int rbt;
    public int scene;
    public int source;
    public String ssid;
    public int type;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.egF != null) {
                aVar.g(2, this.egF);
            }
            aVar.fT(3, this.scene);
            aVar.fT(4, this.type);
            aVar.fT(5, this.rbC);
            if (this.ssid != null) {
                aVar.g(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.g(7, this.bssid);
            }
            aVar.T(8, this.rbo);
            if (this.rbD != null) {
                aVar.fV(9, this.rbD.boi());
                this.rbD.a(aVar);
            }
            if (this.rbE != null) {
                aVar.fV(10, this.rbE.boi());
                this.rbE.a(aVar);
            }
            aVar.fT(11, this.rbq);
            if (this.rbn != null) {
                aVar.g(12, this.rbn);
            }
            aVar.fT(13, this.source);
            if (this.rbs != null) {
                aVar.g(14, this.rbs);
            }
            aVar.fT(15, this.rbF);
            aVar.fT(16, this.rbG);
            aVar.fT(17, this.rbH);
            aVar.fT(18, this.rbt);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.egF != null) {
                fS += f.a.a.b.b.a.h(2, this.egF);
            }
            fS = ((fS + f.a.a.a.fQ(3, this.scene)) + f.a.a.a.fQ(4, this.type)) + f.a.a.a.fQ(5, this.rbC);
            if (this.ssid != null) {
                fS += f.a.a.b.b.a.h(6, this.ssid);
            }
            if (this.bssid != null) {
                fS += f.a.a.b.b.a.h(7, this.bssid);
            }
            fS += f.a.a.a.S(8, this.rbo);
            if (this.rbD != null) {
                fS += f.a.a.a.fS(9, this.rbD.boi());
            }
            if (this.rbE != null) {
                fS += f.a.a.a.fS(10, this.rbE.boi());
            }
            fS += f.a.a.a.fQ(11, this.rbq);
            if (this.rbn != null) {
                fS += f.a.a.b.b.a.h(12, this.rbn);
            }
            fS += f.a.a.a.fQ(13, this.source);
            if (this.rbs != null) {
                fS += f.a.a.b.b.a.h(14, this.rbs);
            }
            return (((fS + f.a.a.a.fQ(15, this.rbF)) + f.a.a.a.fQ(16, this.rbG)) + f.a.a.a.fQ(17, this.rbH)) + f.a.a.a.fQ(18, this.rbt);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bg bgVar = (bg) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bgVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bgVar.egF = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bgVar.scene = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bgVar.type = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bgVar.rbC = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bgVar.ssid = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bgVar.bssid = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bgVar.rbo = aVar3.vHC.rZ();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bf bfVar = new bf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfVar.a(aVar4, bfVar, bhd.a(aVar4))) {
                        }
                        bgVar.rbD = bfVar;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bi biVar = new bi();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = biVar.a(aVar4, biVar, bhd.a(aVar4))) {
                        }
                        bgVar.rbE = biVar;
                    }
                    return 0;
                case 11:
                    bgVar.rbq = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bgVar.rbn = aVar3.vHC.readString();
                    return 0;
                case 13:
                    bgVar.source = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bgVar.rbs = aVar3.vHC.readString();
                    return 0;
                case 15:
                    bgVar.rbF = aVar3.vHC.rY();
                    return 0;
                case 16:
                    bgVar.rbG = aVar3.vHC.rY();
                    return 0;
                case 17:
                    bgVar.rbH = aVar3.vHC.rY();
                    return 0;
                case 18:
                    bgVar.rbt = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
