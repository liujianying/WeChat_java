package com.tencent.mm.y;

import com.tencent.mm.bk.a;

public final class m extends a {
    public String dzA;
    public int dzB;
    public int dzC;
    public String dzD;
    public String dzE;
    public int dzF;
    public int dzG;
    public String dzH;
    public String dzI;
    public String dzJ;
    public String dzK;
    public String dzL;
    public String dzM;
    public int dzN;
    public int dzO;
    public String dzw;
    public String dzx;
    public String dzy;
    public String dzz;
    public long time;
    public String title;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.dzw != null) {
                aVar.g(3, this.dzw);
            }
            if (this.dzx != null) {
                aVar.g(4, this.dzx);
            }
            aVar.T(5, this.time);
            if (this.dzy != null) {
                aVar.g(6, this.dzy);
            }
            if (this.dzz != null) {
                aVar.g(7, this.dzz);
            }
            if (this.dzA != null) {
                aVar.g(8, this.dzA);
            }
            aVar.fT(9, this.type);
            aVar.fT(10, this.dzB);
            aVar.fT(11, this.dzC);
            if (this.dzD != null) {
                aVar.g(12, this.dzD);
            }
            if (this.dzE != null) {
                aVar.g(13, this.dzE);
            }
            aVar.fT(14, this.dzF);
            aVar.fT(15, this.dzG);
            if (this.dzH != null) {
                aVar.g(16, this.dzH);
            }
            if (this.dzI != null) {
                aVar.g(17, this.dzI);
            }
            if (this.dzJ != null) {
                aVar.g(18, this.dzJ);
            }
            if (this.dzK != null) {
                aVar.g(19, this.dzK);
            }
            if (this.dzL != null) {
                aVar.g(20, this.dzL);
            }
            if (this.dzM != null) {
                aVar.g(21, this.dzM);
            }
            aVar.fT(22, this.dzN);
            aVar.fT(23, this.dzO);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = f.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.url != null) {
                h += f.a.a.b.b.a.h(2, this.url);
            }
            if (this.dzw != null) {
                h += f.a.a.b.b.a.h(3, this.dzw);
            }
            if (this.dzx != null) {
                h += f.a.a.b.b.a.h(4, this.dzx);
            }
            h += f.a.a.a.S(5, this.time);
            if (this.dzy != null) {
                h += f.a.a.b.b.a.h(6, this.dzy);
            }
            if (this.dzz != null) {
                h += f.a.a.b.b.a.h(7, this.dzz);
            }
            if (this.dzA != null) {
                h += f.a.a.b.b.a.h(8, this.dzA);
            }
            h = ((h + f.a.a.a.fQ(9, this.type)) + f.a.a.a.fQ(10, this.dzB)) + f.a.a.a.fQ(11, this.dzC);
            if (this.dzD != null) {
                h += f.a.a.b.b.a.h(12, this.dzD);
            }
            if (this.dzE != null) {
                h += f.a.a.b.b.a.h(13, this.dzE);
            }
            h = (h + f.a.a.a.fQ(14, this.dzF)) + f.a.a.a.fQ(15, this.dzG);
            if (this.dzH != null) {
                h += f.a.a.b.b.a.h(16, this.dzH);
            }
            if (this.dzI != null) {
                h += f.a.a.b.b.a.h(17, this.dzI);
            }
            if (this.dzJ != null) {
                h += f.a.a.b.b.a.h(18, this.dzJ);
            }
            if (this.dzK != null) {
                h += f.a.a.b.b.a.h(19, this.dzK);
            }
            if (this.dzL != null) {
                h += f.a.a.b.b.a.h(20, this.dzL);
            }
            if (this.dzM != null) {
                h += f.a.a.b.b.a.h(21, this.dzM);
            }
            return (h + f.a.a.a.fQ(22, this.dzN)) + f.a.a.a.fQ(23, this.dzO);
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
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.title = aVar3.vHC.readString();
                    return 0;
                case 2:
                    mVar.url = aVar3.vHC.readString();
                    return 0;
                case 3:
                    mVar.dzw = aVar3.vHC.readString();
                    return 0;
                case 4:
                    mVar.dzx = aVar3.vHC.readString();
                    return 0;
                case 5:
                    mVar.time = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    mVar.dzy = aVar3.vHC.readString();
                    return 0;
                case 7:
                    mVar.dzz = aVar3.vHC.readString();
                    return 0;
                case 8:
                    mVar.dzA = aVar3.vHC.readString();
                    return 0;
                case 9:
                    mVar.type = aVar3.vHC.rY();
                    return 0;
                case 10:
                    mVar.dzB = aVar3.vHC.rY();
                    return 0;
                case 11:
                    mVar.dzC = aVar3.vHC.rY();
                    return 0;
                case 12:
                    mVar.dzD = aVar3.vHC.readString();
                    return 0;
                case 13:
                    mVar.dzE = aVar3.vHC.readString();
                    return 0;
                case 14:
                    mVar.dzF = aVar3.vHC.rY();
                    return 0;
                case 15:
                    mVar.dzG = aVar3.vHC.rY();
                    return 0;
                case 16:
                    mVar.dzH = aVar3.vHC.readString();
                    return 0;
                case 17:
                    mVar.dzI = aVar3.vHC.readString();
                    return 0;
                case 18:
                    mVar.dzJ = aVar3.vHC.readString();
                    return 0;
                case 19:
                    mVar.dzK = aVar3.vHC.readString();
                    return 0;
                case 20:
                    mVar.dzL = aVar3.vHC.readString();
                    return 0;
                case 21:
                    mVar.dzM = aVar3.vHC.readString();
                    return 0;
                case 22:
                    mVar.dzN = aVar3.vHC.rY();
                    return 0;
                case 23:
                    mVar.dzO = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
