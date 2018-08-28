package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class fg extends a {
    public String knE;
    public String lMV;
    public String mug;
    public int muh;
    public int mui;
    public String muj;
    public String muk;
    public String mul;
    public LinkedList<ua> rgf = new LinkedList();
    public String rgg;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lMV != null) {
                aVar.g(1, this.lMV);
            }
            if (this.knE != null) {
                aVar.g(2, this.knE);
            }
            if (this.mug != null) {
                aVar.g(3, this.mug);
            }
            aVar.fT(4, this.muh);
            aVar.fT(5, this.mui);
            aVar.d(6, 8, this.rgf);
            if (this.muj != null) {
                aVar.g(7, this.muj);
            }
            if (this.muk != null) {
                aVar.g(8, this.muk);
            }
            if (this.mul != null) {
                aVar.g(9, this.mul);
            }
            if (this.rgg == null) {
                return 0;
            }
            aVar.g(10, this.rgg);
            return 0;
        } else if (i == 1) {
            if (this.lMV != null) {
                h = f.a.a.b.b.a.h(1, this.lMV) + 0;
            } else {
                h = 0;
            }
            if (this.knE != null) {
                h += f.a.a.b.b.a.h(2, this.knE);
            }
            if (this.mug != null) {
                h += f.a.a.b.b.a.h(3, this.mug);
            }
            h = ((h + f.a.a.a.fQ(4, this.muh)) + f.a.a.a.fQ(5, this.mui)) + f.a.a.a.c(6, 8, this.rgf);
            if (this.muj != null) {
                h += f.a.a.b.b.a.h(7, this.muj);
            }
            if (this.muk != null) {
                h += f.a.a.b.b.a.h(8, this.muk);
            }
            if (this.mul != null) {
                h += f.a.a.b.b.a.h(9, this.mul);
            }
            if (this.rgg != null) {
                h += f.a.a.b.b.a.h(10, this.rgg);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rgf.clear();
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
            fg fgVar = (fg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fgVar.lMV = aVar3.vHC.readString();
                    return 0;
                case 2:
                    fgVar.knE = aVar3.vHC.readString();
                    return 0;
                case 3:
                    fgVar.mug = aVar3.vHC.readString();
                    return 0;
                case 4:
                    fgVar.muh = aVar3.vHC.rY();
                    return 0;
                case 5:
                    fgVar.mui = aVar3.vHC.rY();
                    return 0;
                case 6:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ua uaVar = new ua();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = uaVar.a(aVar4, uaVar, a.a(aVar4))) {
                        }
                        fgVar.rgf.add(uaVar);
                    }
                    return 0;
                case 7:
                    fgVar.muj = aVar3.vHC.readString();
                    return 0;
                case 8:
                    fgVar.muk = aVar3.vHC.readString();
                    return 0;
                case 9:
                    fgVar.mul = aVar3.vHC.readString();
                    return 0;
                case 10:
                    fgVar.rgg = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
