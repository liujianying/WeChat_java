package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class pr extends a {
    public String huX;
    public String huY;
    public String lMY;
    public String rnv;
    public String rnw;
    public long roL;
    public String roM;
    public String roN;
    public akz rtT;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.huX != null) {
                aVar.g(2, this.huX);
            }
            if (this.huY != null) {
                aVar.g(3, this.huY);
            }
            if (this.url != null) {
                aVar.g(4, this.url);
            }
            aVar.T(5, this.roL);
            if (this.roM != null) {
                aVar.g(6, this.roM);
            }
            if (this.roN != null) {
                aVar.g(7, this.roN);
            }
            if (this.lMY != null) {
                aVar.g(8, this.lMY);
            }
            if (this.rtT != null) {
                aVar.fV(9, this.rtT.boi());
                this.rtT.a(aVar);
            }
            if (this.rnv != null) {
                aVar.g(10, this.rnv);
            }
            if (this.rnw == null) {
                return 0;
            }
            aVar.g(11, this.rnw);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = f.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.huX != null) {
                h += f.a.a.b.b.a.h(2, this.huX);
            }
            if (this.huY != null) {
                h += f.a.a.b.b.a.h(3, this.huY);
            }
            if (this.url != null) {
                h += f.a.a.b.b.a.h(4, this.url);
            }
            h += f.a.a.a.S(5, this.roL);
            if (this.roM != null) {
                h += f.a.a.b.b.a.h(6, this.roM);
            }
            if (this.roN != null) {
                h += f.a.a.b.b.a.h(7, this.roN);
            }
            if (this.lMY != null) {
                h += f.a.a.b.b.a.h(8, this.lMY);
            }
            if (this.rtT != null) {
                h += f.a.a.a.fS(9, this.rtT.boi());
            }
            if (this.rnv != null) {
                h += f.a.a.b.b.a.h(10, this.rnv);
            }
            if (this.rnw != null) {
                h += f.a.a.b.b.a.h(11, this.rnw);
            }
            return h;
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
            pr prVar = (pr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    prVar.title = aVar3.vHC.readString();
                    return 0;
                case 2:
                    prVar.huX = aVar3.vHC.readString();
                    return 0;
                case 3:
                    prVar.huY = aVar3.vHC.readString();
                    return 0;
                case 4:
                    prVar.url = aVar3.vHC.readString();
                    return 0;
                case 5:
                    prVar.roL = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    prVar.roM = aVar3.vHC.readString();
                    return 0;
                case 7:
                    prVar.roN = aVar3.vHC.readString();
                    return 0;
                case 8:
                    prVar.lMY = aVar3.vHC.readString();
                    return 0;
                case 9:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        akz akz = new akz();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = akz.a(aVar4, akz, a.a(aVar4))) {
                        }
                        prVar.rtT = akz;
                    }
                    return 0;
                case 10:
                    prVar.rnv = aVar3.vHC.readString();
                    return 0;
                case 11:
                    prVar.rnw = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
