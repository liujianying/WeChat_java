package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bb extends bhd {
    public String bssid;
    public String egF;
    public int egJ;
    public String rbn;
    public long rbo;
    public bm rbp;
    public int rbq;
    public int rbr;
    public String rbs;
    public int rbt;
    public int scene;
    public int source;
    public String ssid;

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
            aVar.fT(3, this.egJ);
            if (this.rbn != null) {
                aVar.g(4, this.rbn);
            }
            aVar.fT(5, this.scene);
            if (this.ssid != null) {
                aVar.g(6, this.ssid);
            }
            if (this.bssid != null) {
                aVar.g(7, this.bssid);
            }
            aVar.T(8, this.rbo);
            if (this.rbp != null) {
                aVar.fV(9, this.rbp.boi());
                this.rbp.a(aVar);
            }
            aVar.fT(10, this.rbq);
            aVar.fT(11, this.rbr);
            aVar.fT(12, this.source);
            if (this.rbs != null) {
                aVar.g(13, this.rbs);
            }
            aVar.fT(14, this.rbt);
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
            fS += f.a.a.a.fQ(3, this.egJ);
            if (this.rbn != null) {
                fS += f.a.a.b.b.a.h(4, this.rbn);
            }
            fS += f.a.a.a.fQ(5, this.scene);
            if (this.ssid != null) {
                fS += f.a.a.b.b.a.h(6, this.ssid);
            }
            if (this.bssid != null) {
                fS += f.a.a.b.b.a.h(7, this.bssid);
            }
            fS += f.a.a.a.S(8, this.rbo);
            if (this.rbp != null) {
                fS += f.a.a.a.fS(9, this.rbp.boi());
            }
            fS = ((fS + f.a.a.a.fQ(10, this.rbq)) + f.a.a.a.fQ(11, this.rbr)) + f.a.a.a.fQ(12, this.source);
            if (this.rbs != null) {
                fS += f.a.a.b.b.a.h(13, this.rbs);
            }
            return fS + f.a.a.a.fQ(14, this.rbt);
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
            bb bbVar = (bb) objArr[1];
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
                        bbVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bbVar.egF = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bbVar.egJ = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bbVar.rbn = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bbVar.scene = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bbVar.ssid = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bbVar.bssid = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bbVar.rbo = aVar3.vHC.rZ();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bm bmVar = new bm();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmVar.a(aVar4, bmVar, bhd.a(aVar4))) {
                        }
                        bbVar.rbp = bmVar;
                    }
                    return 0;
                case 10:
                    bbVar.rbq = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bbVar.rbr = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bbVar.source = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bbVar.rbs = aVar3.vHC.readString();
                    return 0;
                case 14:
                    bbVar.rbt = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
