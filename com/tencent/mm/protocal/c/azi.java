package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class azi extends a {
    public String bSc;
    public String bWP;
    public String poH;
    public String ppQ;
    public long pqc;
    public long pqd;
    public long pqe;
    public int pqf;
    public int pqg;
    public long pqh;
    public String pwk;
    public String sbX;
    public String sbY;
    public String sbZ;
    public int sca;
    public String title;
    public String type;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.g(1, this.url);
            }
            if (this.bSc != null) {
                aVar.g(2, this.bSc);
            }
            if (this.bWP != null) {
                aVar.g(3, this.bWP);
            }
            if (this.pwk != null) {
                aVar.g(4, this.pwk);
            }
            if (this.ppQ != null) {
                aVar.g(5, this.ppQ);
            }
            if (this.sbX != null) {
                aVar.g(6, this.sbX);
            }
            if (this.type != null) {
                aVar.g(7, this.type);
            }
            if (this.title != null) {
                aVar.g(8, this.title);
            }
            aVar.T(9, this.pqc);
            aVar.T(10, this.pqd);
            if (this.poH != null) {
                aVar.g(11, this.poH);
            }
            aVar.T(12, this.pqe);
            aVar.fT(13, this.pqf);
            aVar.fT(14, this.pqg);
            if (this.sbY != null) {
                aVar.g(15, this.sbY);
            }
            if (this.sbZ != null) {
                aVar.g(16, this.sbZ);
            }
            aVar.T(17, this.pqh);
            aVar.fT(18, this.sca);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                h = f.a.a.b.b.a.h(1, this.url) + 0;
            } else {
                h = 0;
            }
            if (this.bSc != null) {
                h += f.a.a.b.b.a.h(2, this.bSc);
            }
            if (this.bWP != null) {
                h += f.a.a.b.b.a.h(3, this.bWP);
            }
            if (this.pwk != null) {
                h += f.a.a.b.b.a.h(4, this.pwk);
            }
            if (this.ppQ != null) {
                h += f.a.a.b.b.a.h(5, this.ppQ);
            }
            if (this.sbX != null) {
                h += f.a.a.b.b.a.h(6, this.sbX);
            }
            if (this.type != null) {
                h += f.a.a.b.b.a.h(7, this.type);
            }
            if (this.title != null) {
                h += f.a.a.b.b.a.h(8, this.title);
            }
            h = (h + f.a.a.a.S(9, this.pqc)) + f.a.a.a.S(10, this.pqd);
            if (this.poH != null) {
                h += f.a.a.b.b.a.h(11, this.poH);
            }
            h = ((h + f.a.a.a.S(12, this.pqe)) + f.a.a.a.fQ(13, this.pqf)) + f.a.a.a.fQ(14, this.pqg);
            if (this.sbY != null) {
                h += f.a.a.b.b.a.h(15, this.sbY);
            }
            if (this.sbZ != null) {
                h += f.a.a.b.b.a.h(16, this.sbZ);
            }
            return (h + f.a.a.a.S(17, this.pqh)) + f.a.a.a.fQ(18, this.sca);
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
            azi azi = (azi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azi.url = aVar3.vHC.readString();
                    return 0;
                case 2:
                    azi.bSc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    azi.bWP = aVar3.vHC.readString();
                    return 0;
                case 4:
                    azi.pwk = aVar3.vHC.readString();
                    return 0;
                case 5:
                    azi.ppQ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    azi.sbX = aVar3.vHC.readString();
                    return 0;
                case 7:
                    azi.type = aVar3.vHC.readString();
                    return 0;
                case 8:
                    azi.title = aVar3.vHC.readString();
                    return 0;
                case 9:
                    azi.pqc = aVar3.vHC.rZ();
                    return 0;
                case 10:
                    azi.pqd = aVar3.vHC.rZ();
                    return 0;
                case 11:
                    azi.poH = aVar3.vHC.readString();
                    return 0;
                case 12:
                    azi.pqe = aVar3.vHC.rZ();
                    return 0;
                case 13:
                    azi.pqf = aVar3.vHC.rY();
                    return 0;
                case 14:
                    azi.pqg = aVar3.vHC.rY();
                    return 0;
                case 15:
                    azi.sbY = aVar3.vHC.readString();
                    return 0;
                case 16:
                    azi.sbZ = aVar3.vHC.readString();
                    return 0;
                case 17:
                    azi.pqh = aVar3.vHC.rZ();
                    return 0;
                case 18:
                    azi.sca = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
