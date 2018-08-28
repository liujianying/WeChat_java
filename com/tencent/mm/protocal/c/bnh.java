package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class bnh extends a {
    public String content;
    public String slj;
    public String slk;
    public String sll;
    public String slm;
    public int sln;
    public int state;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.content != null) {
                aVar.g(1, this.content);
            }
            if (this.slj != null) {
                aVar.g(2, this.slj);
            }
            if (this.slk != null) {
                aVar.g(3, this.slk);
            }
            if (this.sll != null) {
                aVar.g(4, this.sll);
            }
            if (this.slm != null) {
                aVar.g(5, this.slm);
            }
            aVar.fT(6, this.sln);
            aVar.fT(7, this.state);
            return 0;
        } else if (i == 1) {
            if (this.content != null) {
                h = f.a.a.b.b.a.h(1, this.content) + 0;
            } else {
                h = 0;
            }
            if (this.slj != null) {
                h += f.a.a.b.b.a.h(2, this.slj);
            }
            if (this.slk != null) {
                h += f.a.a.b.b.a.h(3, this.slk);
            }
            if (this.sll != null) {
                h += f.a.a.b.b.a.h(4, this.sll);
            }
            if (this.slm != null) {
                h += f.a.a.b.b.a.h(5, this.slm);
            }
            return (h + f.a.a.a.fQ(6, this.sln)) + f.a.a.a.fQ(7, this.state);
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
            bnh bnh = (bnh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bnh.content = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bnh.slj = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bnh.slk = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bnh.sll = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bnh.slm = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bnh.sln = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bnh.state = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
