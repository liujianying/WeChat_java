package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bsu extends a {
    public int csE;
    public int dwt;
    public String hbL;
    public String ksA;
    public int lOH;
    public String nNV;
    public av nsB;
    public cfn nsD;
    public String ogR;
    public String qIb;
    public String qIc;
    public int rVG;
    public String spZ;
    public arj sqa;
    public dc sqb;
    public qc sqc;
    public String sqd;
    public int sqe;
    public int sqf;
    public String sqg;
    public brh sqh;
    public cdo sqi;
    public int sqj;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ksA != null) {
                aVar.g(1, this.ksA);
            }
            if (this.hbL != null) {
                aVar.g(2, this.hbL);
            }
            aVar.fT(3, this.rVG);
            aVar.fT(4, this.lOH);
            if (this.spZ != null) {
                aVar.g(5, this.spZ);
            }
            if (this.sqa != null) {
                aVar.fV(6, this.sqa.boi());
                this.sqa.a(aVar);
            }
            if (this.sqb != null) {
                aVar.fV(7, this.sqb.boi());
                this.sqb.a(aVar);
            }
            if (this.sqc != null) {
                aVar.fV(8, this.sqc.boi());
                this.sqc.a(aVar);
            }
            if (this.qIb != null) {
                aVar.g(9, this.qIb);
            }
            if (this.qIc != null) {
                aVar.g(10, this.qIc);
            }
            if (this.sqd != null) {
                aVar.g(11, this.sqd);
            }
            aVar.fT(12, this.sqe);
            aVar.fT(13, this.sqf);
            if (this.sqg != null) {
                aVar.g(14, this.sqg);
            }
            if (this.nsB != null) {
                aVar.fV(15, this.nsB.boi());
                this.nsB.a(aVar);
            }
            aVar.fT(16, this.dwt);
            if (this.sqh != null) {
                aVar.fV(17, this.sqh.boi());
                this.sqh.a(aVar);
            }
            if (this.nNV != null) {
                aVar.g(18, this.nNV);
            }
            if (this.ogR != null) {
                aVar.g(19, this.ogR);
            }
            if (this.sqi != null) {
                aVar.fV(20, this.sqi.boi());
                this.sqi.a(aVar);
            }
            aVar.fT(21, this.sqj);
            if (this.nsD != null) {
                aVar.fV(22, this.nsD.boi());
                this.nsD.a(aVar);
            }
            aVar.fT(23, this.csE);
            return 0;
        } else if (i == 1) {
            if (this.ksA != null) {
                h = f.a.a.b.b.a.h(1, this.ksA) + 0;
            } else {
                h = 0;
            }
            if (this.hbL != null) {
                h += f.a.a.b.b.a.h(2, this.hbL);
            }
            h = (h + f.a.a.a.fQ(3, this.rVG)) + f.a.a.a.fQ(4, this.lOH);
            if (this.spZ != null) {
                h += f.a.a.b.b.a.h(5, this.spZ);
            }
            if (this.sqa != null) {
                h += f.a.a.a.fS(6, this.sqa.boi());
            }
            if (this.sqb != null) {
                h += f.a.a.a.fS(7, this.sqb.boi());
            }
            if (this.sqc != null) {
                h += f.a.a.a.fS(8, this.sqc.boi());
            }
            if (this.qIb != null) {
                h += f.a.a.b.b.a.h(9, this.qIb);
            }
            if (this.qIc != null) {
                h += f.a.a.b.b.a.h(10, this.qIc);
            }
            if (this.sqd != null) {
                h += f.a.a.b.b.a.h(11, this.sqd);
            }
            h = (h + f.a.a.a.fQ(12, this.sqe)) + f.a.a.a.fQ(13, this.sqf);
            if (this.sqg != null) {
                h += f.a.a.b.b.a.h(14, this.sqg);
            }
            if (this.nsB != null) {
                h += f.a.a.a.fS(15, this.nsB.boi());
            }
            h += f.a.a.a.fQ(16, this.dwt);
            if (this.sqh != null) {
                h += f.a.a.a.fS(17, this.sqh.boi());
            }
            if (this.nNV != null) {
                h += f.a.a.b.b.a.h(18, this.nNV);
            }
            if (this.ogR != null) {
                h += f.a.a.b.b.a.h(19, this.ogR);
            }
            if (this.sqi != null) {
                h += f.a.a.a.fS(20, this.sqi.boi());
            }
            h += f.a.a.a.fQ(21, this.sqj);
            if (this.nsD != null) {
                h += f.a.a.a.fS(22, this.nsD.boi());
            }
            return h + f.a.a.a.fQ(23, this.csE);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bsu bsu = (bsu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bsu.ksA = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bsu.hbL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bsu.rVG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bsu.lOH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bsu.spZ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        arj arj = new arj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arj.a(aVar4, arj, a.a(aVar4))) {
                        }
                        bsu.sqa = arj;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        dc dcVar = new dc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dcVar.a(aVar4, dcVar, a.a(aVar4))) {
                        }
                        bsu.sqb = dcVar;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        qc qcVar = new qc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qcVar.a(aVar4, qcVar, a.a(aVar4))) {
                        }
                        bsu.sqc = qcVar;
                    }
                    return 0;
                case 9:
                    bsu.qIb = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bsu.qIc = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bsu.sqd = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bsu.sqe = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bsu.sqf = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bsu.sqg = aVar3.vHC.readString();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        av avVar = new av();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avVar.a(aVar4, avVar, a.a(aVar4))) {
                        }
                        bsu.nsB = avVar;
                    }
                    return 0;
                case 16:
                    bsu.dwt = aVar3.vHC.rY();
                    return 0;
                case 17:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        brh brh = new brh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brh.a(aVar4, brh, a.a(aVar4))) {
                        }
                        bsu.sqh = brh;
                    }
                    return 0;
                case 18:
                    bsu.nNV = aVar3.vHC.readString();
                    return 0;
                case 19:
                    bsu.ogR = aVar3.vHC.readString();
                    return 0;
                case 20:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cdo cdo = new cdo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdo.a(aVar4, cdo, a.a(aVar4))) {
                        }
                        bsu.sqi = cdo;
                    }
                    return 0;
                case 21:
                    bsu.sqj = aVar3.vHC.rY();
                    return 0;
                case 22:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cfn cfn = new cfn();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfn.a(aVar4, cfn, a.a(aVar4))) {
                        }
                        bsu.nsD = cfn;
                    }
                    return 0;
                case 23:
                    bsu.csE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
