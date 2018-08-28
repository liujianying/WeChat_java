package com.tencent.mm.br;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.game.f$k;

public final class c extends a {
    public int dHJ;
    public int sLL;
    public int sLM;
    public int sLN;
    public int sLO = -1;
    public int sLP;
    public int size;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.sLL);
            aVar.fT(2, this.sLM);
            aVar.fT(3, this.sLN);
            aVar.fT(41, this.sLO);
            aVar.fT(5, this.sLP);
            aVar.fT(6, this.dHJ);
            aVar.fT(7, this.size);
            return 0;
        } else if (i == 1) {
            return ((((((f.a.a.a.fQ(1, this.sLL) + 0) + f.a.a.a.fQ(2, this.sLM)) + f.a.a.a.fQ(3, this.sLN)) + f.a.a.a.fQ(41, this.sLO)) + f.a.a.a.fQ(5, this.sLP)) + f.a.a.a.fQ(6, this.dHJ)) + f.a.a.a.fQ(7, this.size);
        } else {
            if (i == 2) {
                f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                c cVar = (c) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cVar.sLL = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        cVar.sLM = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        cVar.sLN = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        cVar.sLP = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        cVar.dHJ = aVar3.vHC.rY();
                        return 0;
                    case 7:
                        cVar.size = aVar3.vHC.rY();
                        return 0;
                    case f$k.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                        cVar.sLO = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
