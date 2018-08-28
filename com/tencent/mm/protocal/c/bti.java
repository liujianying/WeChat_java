package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bti extends a {
    public long bHu;
    public boolean bIq;
    public String bhd;
    public int dwI;
    public int dwJ;
    public String ixy;
    public String ixz;
    public String lRt;
    public String nzH;
    public String pLA;
    public String pLw;
    public String pLx;
    public String pLy;
    public String pLz;
    public LinkedList<bnq> rBV = new LinkedList();
    public String sqQ;
    public int sqR;
    public String sqS;
    public long sqT;
    public String sqU;
    public String sqV;
    public int sqW;
    public String sqX;
    public String sqY;
    public String sqZ;
    public long sra;
    public long srb;
    public LinkedList<String> srd = new LinkedList();
    public LinkedList<xe> sre = new LinkedList();
    public long timestamp;
    public String title;
    public String videoUrl;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.videoUrl != null) {
                aVar.g(2, this.videoUrl);
            }
            if (this.sqQ != null) {
                aVar.g(3, this.sqQ);
            }
            aVar.fT(4, this.sqR);
            if (this.sqS != null) {
                aVar.g(5, this.sqS);
            }
            aVar.fT(6, this.dwJ);
            aVar.fT(7, this.dwI);
            if (this.ixy != null) {
                aVar.g(8, this.ixy);
            }
            if (this.ixz != null) {
                aVar.g(9, this.ixz);
            }
            if (this.nzH != null) {
                aVar.g(10, this.nzH);
            }
            if (this.pLw != null) {
                aVar.g(11, this.pLw);
            }
            if (this.pLx != null) {
                aVar.g(12, this.pLx);
            }
            if (this.pLy != null) {
                aVar.g(13, this.pLy);
            }
            if (this.bhd != null) {
                aVar.g(14, this.bhd);
            }
            if (this.lRt != null) {
                aVar.g(15, this.lRt);
            }
            aVar.T(16, this.sqT);
            if (this.sqU != null) {
                aVar.g(17, this.sqU);
            }
            if (this.sqV != null) {
                aVar.g(18, this.sqV);
            }
            if (this.pLz != null) {
                aVar.g(19, this.pLz);
            }
            if (this.pLA != null) {
                aVar.g(20, this.pLA);
            }
            aVar.fT(21, this.sqW);
            if (this.sqX != null) {
                aVar.g(22, this.sqX);
            }
            if (this.sqY != null) {
                aVar.g(23, this.sqY);
            }
            aVar.d(24, 8, this.rBV);
            aVar.T(25, this.timestamp);
            aVar.av(26, this.bIq);
            if (this.sqZ != null) {
                aVar.g(27, this.sqZ);
            }
            aVar.T(28, this.sra);
            aVar.T(29, this.bHu);
            aVar.T(30, this.srb);
            aVar.d(31, 1, this.srd);
            aVar.d(32, 8, this.sre);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = f.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.videoUrl != null) {
                h += f.a.a.b.b.a.h(2, this.videoUrl);
            }
            if (this.sqQ != null) {
                h += f.a.a.b.b.a.h(3, this.sqQ);
            }
            h += f.a.a.a.fQ(4, this.sqR);
            if (this.sqS != null) {
                h += f.a.a.b.b.a.h(5, this.sqS);
            }
            h = (h + f.a.a.a.fQ(6, this.dwJ)) + f.a.a.a.fQ(7, this.dwI);
            if (this.ixy != null) {
                h += f.a.a.b.b.a.h(8, this.ixy);
            }
            if (this.ixz != null) {
                h += f.a.a.b.b.a.h(9, this.ixz);
            }
            if (this.nzH != null) {
                h += f.a.a.b.b.a.h(10, this.nzH);
            }
            if (this.pLw != null) {
                h += f.a.a.b.b.a.h(11, this.pLw);
            }
            if (this.pLx != null) {
                h += f.a.a.b.b.a.h(12, this.pLx);
            }
            if (this.pLy != null) {
                h += f.a.a.b.b.a.h(13, this.pLy);
            }
            if (this.bhd != null) {
                h += f.a.a.b.b.a.h(14, this.bhd);
            }
            if (this.lRt != null) {
                h += f.a.a.b.b.a.h(15, this.lRt);
            }
            h += f.a.a.a.S(16, this.sqT);
            if (this.sqU != null) {
                h += f.a.a.b.b.a.h(17, this.sqU);
            }
            if (this.sqV != null) {
                h += f.a.a.b.b.a.h(18, this.sqV);
            }
            if (this.pLz != null) {
                h += f.a.a.b.b.a.h(19, this.pLz);
            }
            if (this.pLA != null) {
                h += f.a.a.b.b.a.h(20, this.pLA);
            }
            h += f.a.a.a.fQ(21, this.sqW);
            if (this.sqX != null) {
                h += f.a.a.b.b.a.h(22, this.sqX);
            }
            if (this.sqY != null) {
                h += f.a.a.b.b.a.h(23, this.sqY);
            }
            h = ((h + f.a.a.a.c(24, 8, this.rBV)) + f.a.a.a.S(25, this.timestamp)) + (f.a.a.b.b.a.ec(26) + 1);
            if (this.sqZ != null) {
                h += f.a.a.b.b.a.h(27, this.sqZ);
            }
            return ((((h + f.a.a.a.S(28, this.sra)) + f.a.a.a.S(29, this.bHu)) + f.a.a.a.S(30, this.srb)) + f.a.a.a.c(31, 1, this.srd)) + f.a.a.a.c(32, 8, this.sre);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rBV.clear();
            this.srd.clear();
            this.sre.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bti bti = (bti) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bti.title = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bti.videoUrl = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bti.sqQ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bti.sqR = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bti.sqS = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bti.dwJ = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bti.dwI = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bti.ixy = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bti.ixz = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bti.nzH = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bti.pLw = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bti.pLx = aVar3.vHC.readString();
                    return 0;
                case 13:
                    bti.pLy = aVar3.vHC.readString();
                    return 0;
                case 14:
                    bti.bhd = aVar3.vHC.readString();
                    return 0;
                case 15:
                    bti.lRt = aVar3.vHC.readString();
                    return 0;
                case 16:
                    bti.sqT = aVar3.vHC.rZ();
                    return 0;
                case 17:
                    bti.sqU = aVar3.vHC.readString();
                    return 0;
                case 18:
                    bti.sqV = aVar3.vHC.readString();
                    return 0;
                case 19:
                    bti.pLz = aVar3.vHC.readString();
                    return 0;
                case 20:
                    bti.pLA = aVar3.vHC.readString();
                    return 0;
                case 21:
                    bti.sqW = aVar3.vHC.rY();
                    return 0;
                case 22:
                    bti.sqX = aVar3.vHC.readString();
                    return 0;
                case 23:
                    bti.sqY = aVar3.vHC.readString();
                    return 0;
                case 24:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnq bnq = new bnq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnq.a(aVar4, bnq, a.a(aVar4))) {
                        }
                        bti.rBV.add(bnq);
                    }
                    return 0;
                case 25:
                    bti.timestamp = aVar3.vHC.rZ();
                    return 0;
                case 26:
                    bti.bIq = aVar3.cJQ();
                    return 0;
                case 27:
                    bti.sqZ = aVar3.vHC.readString();
                    return 0;
                case 28:
                    bti.sra = aVar3.vHC.rZ();
                    return 0;
                case 29:
                    bti.bHu = aVar3.vHC.rZ();
                    return 0;
                case 30:
                    bti.srb = aVar3.vHC.rZ();
                    return 0;
                case 31:
                    bti.srd.add(aVar3.vHC.readString());
                    return 0;
                case 32:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xe xeVar = new xe();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xeVar.a(aVar4, xeVar, a.a(aVar4))) {
                        }
                        bti.sre.add(xeVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
