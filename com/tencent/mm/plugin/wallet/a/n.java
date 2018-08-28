package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bk.a;

public final class n extends a {
    public String desc;
    public String dzE;
    public String id;
    public String name;
    public String pdR;
    public String peu;
    public String pev;
    public String pew = "0";
    public String pex = "0";
    public int pey = 0;
    public int pez;
    public int status;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.g(1, this.id);
            }
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.desc != null) {
                aVar.g(3, this.desc);
            }
            aVar.fT(4, this.status);
            if (this.url != null) {
                aVar.g(5, this.url);
            }
            aVar.fT(6, this.type);
            if (this.peu != null) {
                aVar.g(7, this.peu);
            }
            if (this.pev != null) {
                aVar.g(8, this.pev);
            }
            if (this.pew != null) {
                aVar.g(9, this.pew);
            }
            if (this.pex != null) {
                aVar.g(10, this.pex);
            }
            aVar.fT(11, this.pey);
            if (this.pdR != null) {
                aVar.g(12, this.pdR);
            }
            if (this.dzE != null) {
                aVar.g(13, this.dzE);
            }
            aVar.fT(14, this.pez);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                h = f.a.a.b.b.a.h(1, this.id) + 0;
            } else {
                h = 0;
            }
            if (this.name != null) {
                h += f.a.a.b.b.a.h(2, this.name);
            }
            if (this.desc != null) {
                h += f.a.a.b.b.a.h(3, this.desc);
            }
            h += f.a.a.a.fQ(4, this.status);
            if (this.url != null) {
                h += f.a.a.b.b.a.h(5, this.url);
            }
            h += f.a.a.a.fQ(6, this.type);
            if (this.peu != null) {
                h += f.a.a.b.b.a.h(7, this.peu);
            }
            if (this.pev != null) {
                h += f.a.a.b.b.a.h(8, this.pev);
            }
            if (this.pew != null) {
                h += f.a.a.b.b.a.h(9, this.pew);
            }
            if (this.pex != null) {
                h += f.a.a.b.b.a.h(10, this.pex);
            }
            h += f.a.a.a.fQ(11, this.pey);
            if (this.pdR != null) {
                h += f.a.a.b.b.a.h(12, this.pdR);
            }
            if (this.dzE != null) {
                h += f.a.a.b.b.a.h(13, this.dzE);
            }
            return h + f.a.a.a.fQ(14, this.pez);
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
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.id = aVar3.vHC.readString();
                    return 0;
                case 2:
                    nVar.name = aVar3.vHC.readString();
                    return 0;
                case 3:
                    nVar.desc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    nVar.status = aVar3.vHC.rY();
                    return 0;
                case 5:
                    nVar.url = aVar3.vHC.readString();
                    return 0;
                case 6:
                    nVar.type = aVar3.vHC.rY();
                    return 0;
                case 7:
                    nVar.peu = aVar3.vHC.readString();
                    return 0;
                case 8:
                    nVar.pev = aVar3.vHC.readString();
                    return 0;
                case 9:
                    nVar.pew = aVar3.vHC.readString();
                    return 0;
                case 10:
                    nVar.pex = aVar3.vHC.readString();
                    return 0;
                case 11:
                    nVar.pey = aVar3.vHC.rY();
                    return 0;
                case 12:
                    nVar.pdR = aVar3.vHC.readString();
                    return 0;
                case 13:
                    nVar.dzE = aVar3.vHC.readString();
                    return 0;
                case 14:
                    nVar.pez = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
