package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class kx extends a {
    public String code;
    public int rmV;
    public int rmW;
    public LinkedList<lk> rmX = new LinkedList();
    public LinkedList<lk> rmY = new LinkedList();
    public LinkedList<lk> rmZ = new LinkedList();
    public LinkedList<String> rna = new LinkedList();
    public int rnb;
    public int rnc;
    public LinkedList<pr> rnd = new LinkedList();
    public long rne;
    public int rnf;
    public String rng;
    public pr rnh;
    public LinkedList<ax> rni = new LinkedList();
    public pr rnj;
    public pr rnk;
    public pr rnl;
    public se rnm;
    public String rnn;
    public pr rno;
    public String rnp;
    public pr rnq;
    public boolean rnr;
    public boolean rns;
    public int status;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.status);
            aVar.fT(2, this.rmV);
            aVar.fT(3, this.rmW);
            aVar.d(4, 8, this.rmX);
            aVar.d(5, 8, this.rmY);
            aVar.d(6, 8, this.rmZ);
            aVar.d(7, 1, this.rna);
            aVar.fT(8, this.rnb);
            if (this.code != null) {
                aVar.g(9, this.code);
            }
            aVar.fT(10, this.rnc);
            aVar.d(11, 8, this.rnd);
            aVar.T(12, this.rne);
            aVar.fT(13, this.rnf);
            if (this.rng != null) {
                aVar.g(14, this.rng);
            }
            if (this.rnh != null) {
                aVar.fV(15, this.rnh.boi());
                this.rnh.a(aVar);
            }
            aVar.d(16, 8, this.rni);
            if (this.rnj != null) {
                aVar.fV(17, this.rnj.boi());
                this.rnj.a(aVar);
            }
            if (this.rnk != null) {
                aVar.fV(18, this.rnk.boi());
                this.rnk.a(aVar);
            }
            if (this.rnl != null) {
                aVar.fV(19, this.rnl.boi());
                this.rnl.a(aVar);
            }
            if (this.rnm != null) {
                aVar.fV(20, this.rnm.boi());
                this.rnm.a(aVar);
            }
            if (this.rnn != null) {
                aVar.g(21, this.rnn);
            }
            if (this.rno != null) {
                aVar.fV(22, this.rno.boi());
                this.rno.a(aVar);
            }
            if (this.rnp != null) {
                aVar.g(23, this.rnp);
            }
            if (this.rnq != null) {
                aVar.fV(24, this.rnq.boi());
                this.rnq.a(aVar);
            }
            aVar.av(25, this.rnr);
            aVar.av(26, this.rns);
            return 0;
        } else if (i == 1) {
            fQ = (((((((f.a.a.a.fQ(1, this.status) + 0) + f.a.a.a.fQ(2, this.rmV)) + f.a.a.a.fQ(3, this.rmW)) + f.a.a.a.c(4, 8, this.rmX)) + f.a.a.a.c(5, 8, this.rmY)) + f.a.a.a.c(6, 8, this.rmZ)) + f.a.a.a.c(7, 1, this.rna)) + f.a.a.a.fQ(8, this.rnb);
            if (this.code != null) {
                fQ += f.a.a.b.b.a.h(9, this.code);
            }
            fQ = (((fQ + f.a.a.a.fQ(10, this.rnc)) + f.a.a.a.c(11, 8, this.rnd)) + f.a.a.a.S(12, this.rne)) + f.a.a.a.fQ(13, this.rnf);
            if (this.rng != null) {
                fQ += f.a.a.b.b.a.h(14, this.rng);
            }
            if (this.rnh != null) {
                fQ += f.a.a.a.fS(15, this.rnh.boi());
            }
            fQ += f.a.a.a.c(16, 8, this.rni);
            if (this.rnj != null) {
                fQ += f.a.a.a.fS(17, this.rnj.boi());
            }
            if (this.rnk != null) {
                fQ += f.a.a.a.fS(18, this.rnk.boi());
            }
            if (this.rnl != null) {
                fQ += f.a.a.a.fS(19, this.rnl.boi());
            }
            if (this.rnm != null) {
                fQ += f.a.a.a.fS(20, this.rnm.boi());
            }
            if (this.rnn != null) {
                fQ += f.a.a.b.b.a.h(21, this.rnn);
            }
            if (this.rno != null) {
                fQ += f.a.a.a.fS(22, this.rno.boi());
            }
            if (this.rnp != null) {
                fQ += f.a.a.b.b.a.h(23, this.rnp);
            }
            if (this.rnq != null) {
                fQ += f.a.a.a.fS(24, this.rnq.boi());
            }
            return (fQ + (f.a.a.b.b.a.ec(25) + 1)) + (f.a.a.b.b.a.ec(26) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rmX.clear();
            this.rmY.clear();
            this.rmZ.clear();
            this.rna.clear();
            this.rnd.clear();
            this.rni.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            kx kxVar = (kx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            lk lkVar;
            f.a.a.a.a aVar4;
            boolean z;
            pr prVar;
            switch (intValue) {
                case 1:
                    kxVar.status = aVar3.vHC.rY();
                    return 0;
                case 2:
                    kxVar.rmV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    kxVar.rmW = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        lkVar = new lk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lkVar.a(aVar4, lkVar, a.a(aVar4))) {
                        }
                        kxVar.rmX.add(lkVar);
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        lkVar = new lk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lkVar.a(aVar4, lkVar, a.a(aVar4))) {
                        }
                        kxVar.rmY.add(lkVar);
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        lkVar = new lk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lkVar.a(aVar4, lkVar, a.a(aVar4))) {
                        }
                        kxVar.rmZ.add(lkVar);
                    }
                    return 0;
                case 7:
                    kxVar.rna.add(aVar3.vHC.readString());
                    return 0;
                case 8:
                    kxVar.rnb = aVar3.vHC.rY();
                    return 0;
                case 9:
                    kxVar.code = aVar3.vHC.readString();
                    return 0;
                case 10:
                    kxVar.rnc = aVar3.vHC.rY();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        prVar = new pr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = prVar.a(aVar4, prVar, a.a(aVar4))) {
                        }
                        kxVar.rnd.add(prVar);
                    }
                    return 0;
                case 12:
                    kxVar.rne = aVar3.vHC.rZ();
                    return 0;
                case 13:
                    kxVar.rnf = aVar3.vHC.rY();
                    return 0;
                case 14:
                    kxVar.rng = aVar3.vHC.readString();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        prVar = new pr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = prVar.a(aVar4, prVar, a.a(aVar4))) {
                        }
                        kxVar.rnh = prVar;
                    }
                    return 0;
                case 16:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ax axVar = new ax();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axVar.a(aVar4, axVar, a.a(aVar4))) {
                        }
                        kxVar.rni.add(axVar);
                    }
                    return 0;
                case 17:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        prVar = new pr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = prVar.a(aVar4, prVar, a.a(aVar4))) {
                        }
                        kxVar.rnj = prVar;
                    }
                    return 0;
                case 18:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        prVar = new pr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = prVar.a(aVar4, prVar, a.a(aVar4))) {
                        }
                        kxVar.rnk = prVar;
                    }
                    return 0;
                case 19:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        prVar = new pr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = prVar.a(aVar4, prVar, a.a(aVar4))) {
                        }
                        kxVar.rnl = prVar;
                    }
                    return 0;
                case 20:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        se seVar = new se();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = seVar.a(aVar4, seVar, a.a(aVar4))) {
                        }
                        kxVar.rnm = seVar;
                    }
                    return 0;
                case 21:
                    kxVar.rnn = aVar3.vHC.readString();
                    return 0;
                case 22:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        prVar = new pr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = prVar.a(aVar4, prVar, a.a(aVar4))) {
                        }
                        kxVar.rno = prVar;
                    }
                    return 0;
                case 23:
                    kxVar.rnp = aVar3.vHC.readString();
                    return 0;
                case 24:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        prVar = new pr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = prVar.a(aVar4, prVar, a.a(aVar4))) {
                        }
                        kxVar.rnq = prVar;
                    }
                    return 0;
                case 25:
                    kxVar.rnr = aVar3.cJQ();
                    return 0;
                case 26:
                    kxVar.rns = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
