package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ahd extends bhp {
    public int hUm;
    public String hUn;
    public boolean pjc;
    public boolean rKA;
    public boolean rKB;
    public String rKC;
    public String rKD;
    public String rKE;
    public String rKF;
    public boolean rKG;
    public LinkedList<String> rKH = new LinkedList();
    public String rKr;
    public String rKs;
    public String rKt;
    public String rKu;
    public String rKv;
    public boolean rKw;
    public String rKx;
    public long rKy;
    public boolean rKz;

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
            aVar.fT(2, this.hUm);
            if (this.hUn != null) {
                aVar.g(3, this.hUn);
            }
            if (this.rKr != null) {
                aVar.g(4, this.rKr);
            }
            if (this.rKs != null) {
                aVar.g(5, this.rKs);
            }
            if (this.rKt != null) {
                aVar.g(6, this.rKt);
            }
            if (this.rKu != null) {
                aVar.g(7, this.rKu);
            }
            if (this.rKv != null) {
                aVar.g(8, this.rKv);
            }
            aVar.av(9, this.rKw);
            if (this.rKx != null) {
                aVar.g(10, this.rKx);
            }
            aVar.T(11, this.rKy);
            aVar.av(12, this.rKz);
            aVar.av(13, this.rKA);
            aVar.av(14, this.rKB);
            if (this.rKC != null) {
                aVar.g(15, this.rKC);
            }
            if (this.rKD != null) {
                aVar.g(16, this.rKD);
            }
            if (this.rKE != null) {
                aVar.g(17, this.rKE);
            }
            if (this.rKF != null) {
                aVar.g(18, this.rKF);
            }
            aVar.av(19, this.rKG);
            aVar.d(20, 1, this.rKH);
            aVar.av(21, this.pjc);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hUm);
            if (this.hUn != null) {
                fS += f.a.a.b.b.a.h(3, this.hUn);
            }
            if (this.rKr != null) {
                fS += f.a.a.b.b.a.h(4, this.rKr);
            }
            if (this.rKs != null) {
                fS += f.a.a.b.b.a.h(5, this.rKs);
            }
            if (this.rKt != null) {
                fS += f.a.a.b.b.a.h(6, this.rKt);
            }
            if (this.rKu != null) {
                fS += f.a.a.b.b.a.h(7, this.rKu);
            }
            if (this.rKv != null) {
                fS += f.a.a.b.b.a.h(8, this.rKv);
            }
            fS += f.a.a.b.b.a.ec(9) + 1;
            if (this.rKx != null) {
                fS += f.a.a.b.b.a.h(10, this.rKx);
            }
            fS = (((fS + f.a.a.a.S(11, this.rKy)) + (f.a.a.b.b.a.ec(12) + 1)) + (f.a.a.b.b.a.ec(13) + 1)) + (f.a.a.b.b.a.ec(14) + 1);
            if (this.rKC != null) {
                fS += f.a.a.b.b.a.h(15, this.rKC);
            }
            if (this.rKD != null) {
                fS += f.a.a.b.b.a.h(16, this.rKD);
            }
            if (this.rKE != null) {
                fS += f.a.a.b.b.a.h(17, this.rKE);
            }
            if (this.rKF != null) {
                fS += f.a.a.b.b.a.h(18, this.rKF);
            }
            return ((fS + (f.a.a.b.b.a.ec(19) + 1)) + f.a.a.a.c(20, 1, this.rKH)) + (f.a.a.b.b.a.ec(21) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rKH.clear();
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
            ahd ahd = (ahd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        ahd.six = flVar;
                    }
                    return 0;
                case 2:
                    ahd.hUm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    ahd.hUn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ahd.rKr = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ahd.rKs = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ahd.rKt = aVar3.vHC.readString();
                    return 0;
                case 7:
                    ahd.rKu = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ahd.rKv = aVar3.vHC.readString();
                    return 0;
                case 9:
                    ahd.rKw = aVar3.cJQ();
                    return 0;
                case 10:
                    ahd.rKx = aVar3.vHC.readString();
                    return 0;
                case 11:
                    ahd.rKy = aVar3.vHC.rZ();
                    return 0;
                case 12:
                    ahd.rKz = aVar3.cJQ();
                    return 0;
                case 13:
                    ahd.rKA = aVar3.cJQ();
                    return 0;
                case 14:
                    ahd.rKB = aVar3.cJQ();
                    return 0;
                case 15:
                    ahd.rKC = aVar3.vHC.readString();
                    return 0;
                case 16:
                    ahd.rKD = aVar3.vHC.readString();
                    return 0;
                case 17:
                    ahd.rKE = aVar3.vHC.readString();
                    return 0;
                case 18:
                    ahd.rKF = aVar3.vHC.readString();
                    return 0;
                case 19:
                    ahd.rKG = aVar3.cJQ();
                    return 0;
                case 20:
                    ahd.rKH.add(aVar3.vHC.readString());
                    return 0;
                case 21:
                    ahd.pjc = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
