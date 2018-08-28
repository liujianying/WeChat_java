package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import com.tencent.mm.plugin.game.f$k;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ji extends bhp {
    public String bQa;
    public int hwV;
    public String hwW;
    public int mxW = 0;
    public String mxX;
    public String mxY;
    public String mxZ;
    public String mya;
    public String rcD;
    public String rcE;
    public String rcF;
    public String rkB;
    public String rkK;
    public bnn rkL;
    public String rkM;
    public String rkN;
    public int rkO;
    public int rkP;
    public int rkQ;
    public btd rkR;
    public String rkS;
    public int rkT;
    public int rkU;
    public int rkV;
    public b rkW;
    public int rkX;
    public int rkY;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new f.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.hwV);
            if (this.hwW != null) {
                aVar.g(3, this.hwW);
            }
            if (this.bQa != null) {
                aVar.g(4, this.bQa);
            }
            if (this.rkK != null) {
                aVar.g(5, this.rkK);
            }
            if (this.rkL != null) {
                aVar.fV(6, this.rkL.boi());
                this.rkL.a(aVar);
            }
            if (this.rcD != null) {
                aVar.g(7, this.rcD);
            }
            if (this.rcF != null) {
                aVar.g(8, this.rcF);
            }
            if (this.rkM != null) {
                aVar.g(9, this.rkM);
            }
            if (this.rkN != null) {
                aVar.g(10, this.rkN);
            }
            aVar.fT(11, this.rkO);
            if (this.rcE != null) {
                aVar.g(12, this.rcE);
            }
            if (this.rkB != null) {
                aVar.g(13, this.rkB);
            }
            aVar.fT(14, this.rkP);
            aVar.fT(15, this.rkQ);
            if (this.rkR != null) {
                aVar.fV(16, this.rkR.boi());
                this.rkR.a(aVar);
            }
            if (this.rkS != null) {
                aVar.g(17, this.rkS);
            }
            aVar.fT(18, this.rkT);
            aVar.fT(19, this.rkU);
            aVar.fT(20, this.rkV);
            if (this.rkW != null) {
                aVar.b(21, this.rkW);
            }
            aVar.fT(22, this.rkX);
            aVar.fT(23, this.mxW);
            if (this.mxX != null) {
                aVar.g(24, this.mxX);
            }
            if (this.mxY != null) {
                aVar.g(25, this.mxY);
            }
            aVar.fT(26, this.rkY);
            if (this.mxZ != null) {
                aVar.g(27, this.mxZ);
            }
            if (this.mya == null) {
                return 0;
            }
            aVar.g(28, this.mya);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hwV);
            if (this.hwW != null) {
                fS += f.a.a.b.b.a.h(3, this.hwW);
            }
            if (this.bQa != null) {
                fS += f.a.a.b.b.a.h(4, this.bQa);
            }
            if (this.rkK != null) {
                fS += f.a.a.b.b.a.h(5, this.rkK);
            }
            if (this.rkL != null) {
                fS += f.a.a.a.fS(6, this.rkL.boi());
            }
            if (this.rcD != null) {
                fS += f.a.a.b.b.a.h(7, this.rcD);
            }
            if (this.rcF != null) {
                fS += f.a.a.b.b.a.h(8, this.rcF);
            }
            if (this.rkM != null) {
                fS += f.a.a.b.b.a.h(9, this.rkM);
            }
            if (this.rkN != null) {
                fS += f.a.a.b.b.a.h(10, this.rkN);
            }
            fS += f.a.a.a.fQ(11, this.rkO);
            if (this.rcE != null) {
                fS += f.a.a.b.b.a.h(12, this.rcE);
            }
            if (this.rkB != null) {
                fS += f.a.a.b.b.a.h(13, this.rkB);
            }
            fS = (fS + f.a.a.a.fQ(14, this.rkP)) + f.a.a.a.fQ(15, this.rkQ);
            if (this.rkR != null) {
                fS += f.a.a.a.fS(16, this.rkR.boi());
            }
            if (this.rkS != null) {
                fS += f.a.a.b.b.a.h(17, this.rkS);
            }
            fS = ((fS + f.a.a.a.fQ(18, this.rkT)) + f.a.a.a.fQ(19, this.rkU)) + f.a.a.a.fQ(20, this.rkV);
            if (this.rkW != null) {
                fS += f.a.a.a.a(21, this.rkW);
            }
            fS = (fS + f.a.a.a.fQ(22, this.rkX)) + f.a.a.a.fQ(23, this.mxW);
            if (this.mxX != null) {
                fS += f.a.a.b.b.a.h(24, this.mxX);
            }
            if (this.mxY != null) {
                fS += f.a.a.b.b.a.h(25, this.mxY);
            }
            fS += f.a.a.a.fQ(26, this.rkY);
            if (this.mxZ != null) {
                fS += f.a.a.b.b.a.h(27, this.mxZ);
            }
            if (this.mya != null) {
                fS += f.a.a.b.b.a.h(28, this.mya);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ji jiVar = (ji) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        jiVar.six = flVar;
                    }
                    return 0;
                case 2:
                    jiVar.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    jiVar.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    jiVar.bQa = aVar3.vHC.readString();
                    return 0;
                case 5:
                    jiVar.rkK = aVar3.vHC.readString();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnn bnn = new bnn();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnn.a(aVar4, bnn, bhp.a(aVar4))) {
                        }
                        jiVar.rkL = bnn;
                    }
                    return 0;
                case 7:
                    jiVar.rcD = aVar3.vHC.readString();
                    return 0;
                case 8:
                    jiVar.rcF = aVar3.vHC.readString();
                    return 0;
                case 9:
                    jiVar.rkM = aVar3.vHC.readString();
                    return 0;
                case 10:
                    jiVar.rkN = aVar3.vHC.readString();
                    return 0;
                case 11:
                    jiVar.rkO = aVar3.vHC.rY();
                    return 0;
                case 12:
                    jiVar.rcE = aVar3.vHC.readString();
                    return 0;
                case 13:
                    jiVar.rkB = aVar3.vHC.readString();
                    return 0;
                case 14:
                    jiVar.rkP = aVar3.vHC.rY();
                    return 0;
                case 15:
                    jiVar.rkQ = aVar3.vHC.rY();
                    return 0;
                case 16:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        btd btd = new btd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btd.a(aVar4, btd, bhp.a(aVar4))) {
                        }
                        jiVar.rkR = btd;
                    }
                    return 0;
                case 17:
                    jiVar.rkS = aVar3.vHC.readString();
                    return 0;
                case 18:
                    jiVar.rkT = aVar3.vHC.rY();
                    return 0;
                case 19:
                    jiVar.rkU = aVar3.vHC.rY();
                    return 0;
                case 20:
                    jiVar.rkV = aVar3.vHC.rY();
                    return 0;
                case 21:
                    jiVar.rkW = aVar3.cJR();
                    return 0;
                case 22:
                    jiVar.rkX = aVar3.vHC.rY();
                    return 0;
                case 23:
                    jiVar.mxW = aVar3.vHC.rY();
                    return 0;
                case 24:
                    jiVar.mxX = aVar3.vHC.readString();
                    return 0;
                case 25:
                    jiVar.mxY = aVar3.vHC.readString();
                    return 0;
                case 26:
                    jiVar.rkY = aVar3.vHC.rY();
                    return 0;
                case 27:
                    jiVar.mxZ = aVar3.vHC.readString();
                    return 0;
                case f$k.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    jiVar.mya = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
