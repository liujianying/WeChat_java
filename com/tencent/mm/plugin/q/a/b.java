package com.tencent.mm.plugin.q.a;

import com.tencent.mm.bk.a;

public final class b extends a {
    public String csD;
    public int knA;
    public String knB;
    public String knC;
    public String knD;
    public String knE;
    public String knF;
    public String knG;
    public String knH;
    public String knI;
    public String knJ;
    public String title;
    public String type;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.knA);
            if (this.type != null) {
                aVar.g(2, this.type);
            }
            if (this.title != null) {
                aVar.g(3, this.title);
            }
            if (this.knB != null) {
                aVar.g(4, this.knB);
            }
            if (this.knC != null) {
                aVar.g(5, this.knC);
            }
            if (this.knD != null) {
                aVar.g(6, this.knD);
            }
            if (this.knE != null) {
                aVar.g(7, this.knE);
            }
            if (this.knF != null) {
                aVar.g(8, this.knF);
            }
            if (this.knG != null) {
                aVar.g(9, this.knG);
            }
            if (this.knH != null) {
                aVar.g(10, this.knH);
            }
            if (this.csD != null) {
                aVar.g(11, this.csD);
            }
            if (this.knI != null) {
                aVar.g(12, this.knI);
            }
            if (this.knJ != null) {
                aVar.g(13, this.knJ);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.knA) + 0;
            if (this.type != null) {
                fQ += f.a.a.b.b.a.h(2, this.type);
            }
            if (this.title != null) {
                fQ += f.a.a.b.b.a.h(3, this.title);
            }
            if (this.knB != null) {
                fQ += f.a.a.b.b.a.h(4, this.knB);
            }
            if (this.knC != null) {
                fQ += f.a.a.b.b.a.h(5, this.knC);
            }
            if (this.knD != null) {
                fQ += f.a.a.b.b.a.h(6, this.knD);
            }
            if (this.knE != null) {
                fQ += f.a.a.b.b.a.h(7, this.knE);
            }
            if (this.knF != null) {
                fQ += f.a.a.b.b.a.h(8, this.knF);
            }
            if (this.knG != null) {
                fQ += f.a.a.b.b.a.h(9, this.knG);
            }
            if (this.knH != null) {
                fQ += f.a.a.b.b.a.h(10, this.knH);
            }
            if (this.csD != null) {
                fQ += f.a.a.b.b.a.h(11, this.csD);
            }
            if (this.knI != null) {
                fQ += f.a.a.b.b.a.h(12, this.knI);
            }
            if (this.knJ != null) {
                return fQ + f.a.a.b.b.a.h(13, this.knJ);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.knA = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bVar.type = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bVar.title = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bVar.knB = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bVar.knC = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bVar.knD = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bVar.knE = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bVar.knF = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bVar.knG = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bVar.knH = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bVar.csD = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bVar.knI = aVar3.vHC.readString();
                    return 0;
                case 13:
                    bVar.knJ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
