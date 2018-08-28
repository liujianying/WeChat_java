package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.game.f$k;
import f.a.a.b;
import java.util.LinkedList;

public final class bxb extends a {
    public String csY;
    public String eJR;
    public int rEA;
    public bqd rTk;
    public String rXk;
    public String rXl;
    public int raE;
    public arc rcy;
    public bic rhO;
    public String rhh;
    public String rqZ;
    public String rra;
    public String stA;
    public String stB;
    public String stC;
    public ayz stD;
    public String stE;
    public int stF;
    public long stG;
    public String stH;
    public String stp;
    public String stq;
    public int str;
    public int sts;
    public int stt;
    public String stu;
    public int stv;
    public bhz stw;
    public int stx;
    public String sty;
    public String stz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rTk == null) {
                throw new b("Not all required fields were included: SnsUserInfo");
            }
            if (this.rTk != null) {
                aVar.fV(1, this.rTk.boi());
                this.rTk.a(aVar);
            }
            if (this.eJR != null) {
                aVar.g(2, this.eJR);
            }
            if (this.stp != null) {
                aVar.g(3, this.stp);
            }
            if (this.stq != null) {
                aVar.g(4, this.stq);
            }
            aVar.fT(5, this.str);
            aVar.fT(6, this.sts);
            aVar.fT(7, this.stt);
            if (this.stu != null) {
                aVar.g(8, this.stu);
            }
            if (this.rqZ != null) {
                aVar.g(9, this.rqZ);
            }
            if (this.rra != null) {
                aVar.g(10, this.rra);
            }
            aVar.fT(11, this.stv);
            if (this.stw != null) {
                aVar.fV(12, this.stw.boi());
                this.stw.a(aVar);
            }
            if (this.rhO != null) {
                aVar.fV(13, this.rhO.boi());
                this.rhO.a(aVar);
            }
            aVar.fT(14, this.raE);
            aVar.fT(15, this.stx);
            if (this.rhh != null) {
                aVar.g(16, this.rhh);
            }
            if (this.rXk != null) {
                aVar.g(17, this.rXk);
            }
            if (this.rXl != null) {
                aVar.g(18, this.rXl);
            }
            if (this.sty != null) {
                aVar.g(19, this.sty);
            }
            if (this.stz != null) {
                aVar.g(20, this.stz);
            }
            if (this.stA != null) {
                aVar.g(21, this.stA);
            }
            if (this.stB != null) {
                aVar.g(22, this.stB);
            }
            if (this.rcy != null) {
                aVar.fV(23, this.rcy.boi());
                this.rcy.a(aVar);
            }
            if (this.stC != null) {
                aVar.g(24, this.stC);
            }
            if (this.stD != null) {
                aVar.fV(25, this.stD.boi());
                this.stD.a(aVar);
            }
            if (this.stE != null) {
                aVar.g(26, this.stE);
            }
            aVar.fT(27, this.stF);
            if (this.csY != null) {
                aVar.g(28, this.csY);
            }
            aVar.fT(29, this.rEA);
            aVar.T(30, this.stG);
            if (this.stH == null) {
                return 0;
            }
            aVar.g(31, this.stH);
            return 0;
        } else if (i == 1) {
            if (this.rTk != null) {
                fS = f.a.a.a.fS(1, this.rTk.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.eJR != null) {
                fS += f.a.a.b.b.a.h(2, this.eJR);
            }
            if (this.stp != null) {
                fS += f.a.a.b.b.a.h(3, this.stp);
            }
            if (this.stq != null) {
                fS += f.a.a.b.b.a.h(4, this.stq);
            }
            fS = ((fS + f.a.a.a.fQ(5, this.str)) + f.a.a.a.fQ(6, this.sts)) + f.a.a.a.fQ(7, this.stt);
            if (this.stu != null) {
                fS += f.a.a.b.b.a.h(8, this.stu);
            }
            if (this.rqZ != null) {
                fS += f.a.a.b.b.a.h(9, this.rqZ);
            }
            if (this.rra != null) {
                fS += f.a.a.b.b.a.h(10, this.rra);
            }
            fS += f.a.a.a.fQ(11, this.stv);
            if (this.stw != null) {
                fS += f.a.a.a.fS(12, this.stw.boi());
            }
            if (this.rhO != null) {
                fS += f.a.a.a.fS(13, this.rhO.boi());
            }
            fS = (fS + f.a.a.a.fQ(14, this.raE)) + f.a.a.a.fQ(15, this.stx);
            if (this.rhh != null) {
                fS += f.a.a.b.b.a.h(16, this.rhh);
            }
            if (this.rXk != null) {
                fS += f.a.a.b.b.a.h(17, this.rXk);
            }
            if (this.rXl != null) {
                fS += f.a.a.b.b.a.h(18, this.rXl);
            }
            if (this.sty != null) {
                fS += f.a.a.b.b.a.h(19, this.sty);
            }
            if (this.stz != null) {
                fS += f.a.a.b.b.a.h(20, this.stz);
            }
            if (this.stA != null) {
                fS += f.a.a.b.b.a.h(21, this.stA);
            }
            if (this.stB != null) {
                fS += f.a.a.b.b.a.h(22, this.stB);
            }
            if (this.rcy != null) {
                fS += f.a.a.a.fS(23, this.rcy.boi());
            }
            if (this.stC != null) {
                fS += f.a.a.b.b.a.h(24, this.stC);
            }
            if (this.stD != null) {
                fS += f.a.a.a.fS(25, this.stD.boi());
            }
            if (this.stE != null) {
                fS += f.a.a.b.b.a.h(26, this.stE);
            }
            fS += f.a.a.a.fQ(27, this.stF);
            if (this.csY != null) {
                fS += f.a.a.b.b.a.h(28, this.csY);
            }
            fS = (fS + f.a.a.a.fQ(29, this.rEA)) + f.a.a.a.S(30, this.stG);
            if (this.stH != null) {
                fS += f.a.a.b.b.a.h(31, this.stH);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rTk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SnsUserInfo");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bxb bxb = (bxb) objArr[1];
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
                        bqd bqd = new bqd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqd.a(aVar4, bqd, a.a(aVar4))) {
                        }
                        bxb.rTk = bqd;
                    }
                    return 0;
                case 2:
                    bxb.eJR = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bxb.stp = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bxb.stq = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bxb.str = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bxb.sts = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bxb.stt = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bxb.stu = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bxb.rqZ = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bxb.rra = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bxb.stv = aVar3.vHC.rY();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bxb.stw = bhz;
                    }
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bic bic = new bic();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bic.a(aVar4, bic, a.a(aVar4))) {
                        }
                        bxb.rhO = bic;
                    }
                    return 0;
                case 14:
                    bxb.raE = aVar3.vHC.rY();
                    return 0;
                case 15:
                    bxb.stx = aVar3.vHC.rY();
                    return 0;
                case 16:
                    bxb.rhh = aVar3.vHC.readString();
                    return 0;
                case 17:
                    bxb.rXk = aVar3.vHC.readString();
                    return 0;
                case 18:
                    bxb.rXl = aVar3.vHC.readString();
                    return 0;
                case 19:
                    bxb.sty = aVar3.vHC.readString();
                    return 0;
                case 20:
                    bxb.stz = aVar3.vHC.readString();
                    return 0;
                case 21:
                    bxb.stA = aVar3.vHC.readString();
                    return 0;
                case 22:
                    bxb.stB = aVar3.vHC.readString();
                    return 0;
                case 23:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        arc arc = new arc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arc.a(aVar4, arc, a.a(aVar4))) {
                        }
                        bxb.rcy = arc;
                    }
                    return 0;
                case 24:
                    bxb.stC = aVar3.vHC.readString();
                    return 0;
                case 25:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ayz ayz = new ayz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayz.a(aVar4, ayz, a.a(aVar4))) {
                        }
                        bxb.stD = ayz;
                    }
                    return 0;
                case 26:
                    bxb.stE = aVar3.vHC.readString();
                    return 0;
                case 27:
                    bxb.stF = aVar3.vHC.rY();
                    return 0;
                case f$k.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    bxb.csY = aVar3.vHC.readString();
                    return 0;
                case f$k.AppCompatTheme_actionModeBackground /*29*/:
                    bxb.rEA = aVar3.vHC.rY();
                    return 0;
                case 30:
                    bxb.stG = aVar3.vHC.rZ();
                    return 0;
                case f$k.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    bxb.stH = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
