package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class pz extends a {
    public int eJH;
    public String eJM;
    public String hbL;
    public String hcS;
    public String jTB;
    public bhy rcn;
    public String ruh;
    public String rui;
    public int ruj;
    public int ruk;
    public String rul;
    public int rum;
    public String run;
    public String ruo;
    public int rup;
    public int ruq;
    public LinkedList<bhx> rur = new LinkedList();
    public String rus;
    public int rut;
    public int ruu;
    public int ruv;
    public int ruw;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rcn == null) {
                throw new b("Not all required fields were included: ImgBuf");
            }
            if (this.hbL != null) {
                aVar.g(1, this.hbL);
            }
            if (this.hcS != null) {
                aVar.g(2, this.hcS);
            }
            if (this.ruh != null) {
                aVar.g(3, this.ruh);
            }
            if (this.rui != null) {
                aVar.g(4, this.rui);
            }
            aVar.fT(5, this.eJH);
            if (this.rcn != null) {
                aVar.fV(6, this.rcn.boi());
                this.rcn.a(aVar);
            }
            aVar.fT(7, this.ruj);
            aVar.fT(8, this.ruk);
            if (this.rul != null) {
                aVar.g(9, this.rul);
            }
            aVar.fT(10, this.rum);
            if (this.run != null) {
                aVar.g(11, this.run);
            }
            if (this.ruo != null) {
                aVar.g(12, this.ruo);
            }
            aVar.fT(13, this.rup);
            aVar.fT(14, this.ruq);
            aVar.d(15, 8, this.rur);
            if (this.rus != null) {
                aVar.g(16, this.rus);
            }
            aVar.fT(17, this.rut);
            aVar.fT(18, this.ruu);
            if (this.jTB != null) {
                aVar.g(19, this.jTB);
            }
            aVar.fT(20, this.ruv);
            aVar.fT(21, this.ruw);
            if (this.eJM == null) {
                return 0;
            }
            aVar.g(22, this.eJM);
            return 0;
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(2, this.hcS);
            }
            if (this.ruh != null) {
                h += f.a.a.b.b.a.h(3, this.ruh);
            }
            if (this.rui != null) {
                h += f.a.a.b.b.a.h(4, this.rui);
            }
            h += f.a.a.a.fQ(5, this.eJH);
            if (this.rcn != null) {
                h += f.a.a.a.fS(6, this.rcn.boi());
            }
            h = (h + f.a.a.a.fQ(7, this.ruj)) + f.a.a.a.fQ(8, this.ruk);
            if (this.rul != null) {
                h += f.a.a.b.b.a.h(9, this.rul);
            }
            h += f.a.a.a.fQ(10, this.rum);
            if (this.run != null) {
                h += f.a.a.b.b.a.h(11, this.run);
            }
            if (this.ruo != null) {
                h += f.a.a.b.b.a.h(12, this.ruo);
            }
            h = ((h + f.a.a.a.fQ(13, this.rup)) + f.a.a.a.fQ(14, this.ruq)) + f.a.a.a.c(15, 8, this.rur);
            if (this.rus != null) {
                h += f.a.a.b.b.a.h(16, this.rus);
            }
            h = (h + f.a.a.a.fQ(17, this.rut)) + f.a.a.a.fQ(18, this.ruu);
            if (this.jTB != null) {
                h += f.a.a.b.b.a.h(19, this.jTB);
            }
            h = (h + f.a.a.a.fQ(20, this.ruv)) + f.a.a.a.fQ(21, this.ruw);
            if (this.eJM != null) {
                h += f.a.a.b.b.a.h(22, this.eJM);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rur.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rcn != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImgBuf");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            pz pzVar = (pz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    pzVar.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    pzVar.hcS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    pzVar.ruh = aVar3.vHC.readString();
                    return 0;
                case 4:
                    pzVar.rui = aVar3.vHC.readString();
                    return 0;
                case 5:
                    pzVar.eJH = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        pzVar.rcn = bhy;
                    }
                    return 0;
                case 7:
                    pzVar.ruj = aVar3.vHC.rY();
                    return 0;
                case 8:
                    pzVar.ruk = aVar3.vHC.rY();
                    return 0;
                case 9:
                    pzVar.rul = aVar3.vHC.readString();
                    return 0;
                case 10:
                    pzVar.rum = aVar3.vHC.rY();
                    return 0;
                case 11:
                    pzVar.run = aVar3.vHC.readString();
                    return 0;
                case 12:
                    pzVar.ruo = aVar3.vHC.readString();
                    return 0;
                case 13:
                    pzVar.rup = aVar3.vHC.rY();
                    return 0;
                case 14:
                    pzVar.ruq = aVar3.vHC.rY();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhx bhx = new bhx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhx.a(aVar4, bhx, a.a(aVar4))) {
                        }
                        pzVar.rur.add(bhx);
                    }
                    return 0;
                case 16:
                    pzVar.rus = aVar3.vHC.readString();
                    return 0;
                case 17:
                    pzVar.rut = aVar3.vHC.rY();
                    return 0;
                case 18:
                    pzVar.ruu = aVar3.vHC.rY();
                    return 0;
                case 19:
                    pzVar.jTB = aVar3.vHC.readString();
                    return 0;
                case 20:
                    pzVar.ruv = aVar3.vHC.rY();
                    return 0;
                case 21:
                    pzVar.ruw = aVar3.vHC.rY();
                    return 0;
                case 22:
                    pzVar.eJM = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
