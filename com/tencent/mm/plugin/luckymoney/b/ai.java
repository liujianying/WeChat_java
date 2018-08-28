package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.bk.a;

public final class ai extends a {
    public String content;
    public int ddp;
    public String iconUrl;
    public int kRD;
    public int kRE;
    public String name;
    public String type;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.ddp);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.type != null) {
                aVar.g(3, this.type);
            }
            if (this.content != null) {
                aVar.g(4, this.content);
            }
            aVar.fT(5, this.kRD);
            if (this.iconUrl != null) {
                aVar.g(6, this.iconUrl);
            }
            aVar.fT(7, this.kRE);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.ddp) + 0;
            if (this.name != null) {
                fQ += f.a.a.b.b.a.h(2, this.name);
            }
            if (this.type != null) {
                fQ += f.a.a.b.b.a.h(3, this.type);
            }
            if (this.content != null) {
                fQ += f.a.a.b.b.a.h(4, this.content);
            }
            fQ += f.a.a.a.fQ(5, this.kRD);
            if (this.iconUrl != null) {
                fQ += f.a.a.b.b.a.h(6, this.iconUrl);
            }
            return fQ + f.a.a.a.fQ(7, this.kRE);
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
            ai aiVar = (ai) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aiVar.ddp = aVar3.vHC.rY();
                    return 0;
                case 2:
                    aiVar.name = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aiVar.type = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aiVar.content = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aiVar.kRD = aVar3.vHC.rY();
                    return 0;
                case 6:
                    aiVar.iconUrl = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aiVar.kRE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
