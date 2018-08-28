package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ch extends a {
    public int bVU;
    public int mwQ;
    public String myl;
    public String rcD;
    public String rcE;
    public String rcF;
    public xb rcG;
    public String rcH;
    public int rcI;
    public int scene;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rcD == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.rcF == null) {
                throw new b("Not all required fields were included: payok_checksign");
            } else {
                if (this.rcD != null) {
                    aVar.g(1, this.rcD);
                }
                if (this.rcE != null) {
                    aVar.g(2, this.rcE);
                }
                aVar.fT(3, this.bVU);
                aVar.fT(4, this.mwQ);
                aVar.fT(5, this.scene);
                if (this.rcF != null) {
                    aVar.g(6, this.rcF);
                }
                if (this.rcG != null) {
                    aVar.fV(7, this.rcG.boi());
                    this.rcG.a(aVar);
                }
                if (this.rcH != null) {
                    aVar.g(8, this.rcH);
                }
                if (this.myl != null) {
                    aVar.g(9, this.myl);
                }
                aVar.fT(10, this.rcI);
                return 0;
            }
        } else if (i == 1) {
            if (this.rcD != null) {
                h = f.a.a.b.b.a.h(1, this.rcD) + 0;
            } else {
                h = 0;
            }
            if (this.rcE != null) {
                h += f.a.a.b.b.a.h(2, this.rcE);
            }
            h = ((h + f.a.a.a.fQ(3, this.bVU)) + f.a.a.a.fQ(4, this.mwQ)) + f.a.a.a.fQ(5, this.scene);
            if (this.rcF != null) {
                h += f.a.a.b.b.a.h(6, this.rcF);
            }
            if (this.rcG != null) {
                h += f.a.a.a.fS(7, this.rcG.boi());
            }
            if (this.rcH != null) {
                h += f.a.a.b.b.a.h(8, this.rcH);
            }
            if (this.myl != null) {
                h += f.a.a.b.b.a.h(9, this.myl);
            }
            return h + f.a.a.a.fQ(10, this.rcI);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rcD == null) {
                throw new b("Not all required fields were included: f2f_id");
            } else if (this.rcF != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: payok_checksign");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ch chVar = (ch) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    chVar.rcD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    chVar.rcE = aVar3.vHC.readString();
                    return 0;
                case 3:
                    chVar.bVU = aVar3.vHC.rY();
                    return 0;
                case 4:
                    chVar.mwQ = aVar3.vHC.rY();
                    return 0;
                case 5:
                    chVar.scene = aVar3.vHC.rY();
                    return 0;
                case 6:
                    chVar.rcF = aVar3.vHC.readString();
                    return 0;
                case 7:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        xb xbVar = new xb();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = xbVar.a(aVar4, xbVar, a.a(aVar4))) {
                        }
                        chVar.rcG = xbVar;
                    }
                    return 0;
                case 8:
                    chVar.rcH = aVar3.vHC.readString();
                    return 0;
                case 9:
                    chVar.myl = aVar3.vHC.readString();
                    return 0;
                case 10:
                    chVar.rcI = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
