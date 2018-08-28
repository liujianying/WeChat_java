package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bth extends a {
    public String bHt;
    public String fuu;
    public int offset;
    public LinkedList<ps> pKZ = new LinkedList();
    public int scene;
    public String sqA;
    public String sqH;
    public String sqI;
    public String sqJ;
    public String sqK;
    public long sqL;
    public bti sqM;
    public bnq sqN;
    public long sqO;
    public boolean sqP;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sqH != null) {
                aVar.g(1, this.sqH);
            }
            if (this.sqI != null) {
                aVar.g(2, this.sqI);
            }
            if (this.sqJ != null) {
                aVar.g(3, this.sqJ);
            }
            if (this.sqK != null) {
                aVar.g(4, this.sqK);
            }
            aVar.T(5, this.sqL);
            aVar.fT(6, this.scene);
            if (this.fuu != null) {
                aVar.g(7, this.fuu);
            }
            if (this.bHt != null) {
                aVar.g(8, this.bHt);
            }
            if (this.sqM != null) {
                aVar.fV(9, this.sqM.boi());
                this.sqM.a(aVar);
            }
            if (this.sqN != null) {
                aVar.fV(10, this.sqN.boi());
                this.sqN.a(aVar);
            }
            aVar.d(11, 8, this.pKZ);
            aVar.T(12, this.sqO);
            if (this.sqA != null) {
                aVar.g(13, this.sqA);
            }
            aVar.fT(14, this.offset);
            aVar.av(15, this.sqP);
            return 0;
        } else if (i == 1) {
            if (this.sqH != null) {
                h = f.a.a.b.b.a.h(1, this.sqH) + 0;
            } else {
                h = 0;
            }
            if (this.sqI != null) {
                h += f.a.a.b.b.a.h(2, this.sqI);
            }
            if (this.sqJ != null) {
                h += f.a.a.b.b.a.h(3, this.sqJ);
            }
            if (this.sqK != null) {
                h += f.a.a.b.b.a.h(4, this.sqK);
            }
            h = (h + f.a.a.a.S(5, this.sqL)) + f.a.a.a.fQ(6, this.scene);
            if (this.fuu != null) {
                h += f.a.a.b.b.a.h(7, this.fuu);
            }
            if (this.bHt != null) {
                h += f.a.a.b.b.a.h(8, this.bHt);
            }
            if (this.sqM != null) {
                h += f.a.a.a.fS(9, this.sqM.boi());
            }
            if (this.sqN != null) {
                h += f.a.a.a.fS(10, this.sqN.boi());
            }
            h = (h + f.a.a.a.c(11, 8, this.pKZ)) + f.a.a.a.S(12, this.sqO);
            if (this.sqA != null) {
                h += f.a.a.b.b.a.h(13, this.sqA);
            }
            return (h + f.a.a.a.fQ(14, this.offset)) + (f.a.a.b.b.a.ec(15) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pKZ.clear();
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
            bth bth = (bth) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bth.sqH = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bth.sqI = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bth.sqJ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bth.sqK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bth.sqL = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    bth.scene = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bth.fuu = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bth.bHt = aVar3.vHC.readString();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bti bti = new bti();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bti.a(aVar4, bti, a.a(aVar4))) {
                        }
                        bth.sqM = bti;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnq bnq = new bnq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnq.a(aVar4, bnq, a.a(aVar4))) {
                        }
                        bth.sqN = bnq;
                    }
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ps psVar = new ps();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = psVar.a(aVar4, psVar, a.a(aVar4))) {
                        }
                        bth.pKZ.add(psVar);
                    }
                    return 0;
                case 12:
                    bth.sqO = aVar3.vHC.rZ();
                    return 0;
                case 13:
                    bth.sqA = aVar3.vHC.readString();
                    return 0;
                case 14:
                    bth.offset = aVar3.vHC.rY();
                    return 0;
                case 15:
                    bth.sqP = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
