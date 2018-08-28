package com.tencent.mm.protocal.c;

import android.support.design.a$i;
import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class caf extends a {
    public int kpK;
    public cak suK;
    public cak suL;
    public int swb;
    public byy swc;
    public byy swd;
    public int swe;
    public int swf;
    public int swg;
    public int swh;
    public bhy swi;
    public int swj;
    public byy swk;
    public int swl;
    public int swm;
    public int swn;
    public int swo;
    public int swp;
    public int swq;
    public bhy swr;
    public bhy sws;
    public int swt;
    public bhy swu;
    public int swv;
    public int sww;
    public int swx;
    public api swy;
    public bhy swz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.suK == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.suL == null) {
                throw new b("Not all required fields were included: CapInfo");
            } else {
                if (this.suK != null) {
                    aVar.fV(1, this.suK.boi());
                    this.suK.a(aVar);
                }
                if (this.suL != null) {
                    aVar.fV(2, this.suL.boi());
                    this.suL.a(aVar);
                }
                aVar.fT(3, this.swb);
                if (this.swc != null) {
                    aVar.fV(4, this.swc.boi());
                    this.swc.a(aVar);
                }
                if (this.swd != null) {
                    aVar.fV(5, this.swd.boi());
                    this.swd.a(aVar);
                }
                aVar.fT(6, this.swe);
                aVar.fT(7, this.swf);
                aVar.fT(8, this.swg);
                aVar.fT(9, this.swh);
                if (this.swi != null) {
                    aVar.fV(10, this.swi.boi());
                    this.swi.a(aVar);
                }
                aVar.fT(11, this.swj);
                if (this.swk != null) {
                    aVar.fV(12, this.swk.boi());
                    this.swk.a(aVar);
                }
                aVar.fT(13, this.swl);
                aVar.fT(14, this.swm);
                aVar.fT(15, this.swn);
                aVar.fT(16, this.swo);
                aVar.fT(17, this.swp);
                aVar.fT(18, this.kpK);
                aVar.fT(19, this.swq);
                if (this.swr != null) {
                    aVar.fV(20, this.swr.boi());
                    this.swr.a(aVar);
                }
                if (this.sws != null) {
                    aVar.fV(21, this.sws.boi());
                    this.sws.a(aVar);
                }
                aVar.fT(22, this.swt);
                if (this.swu != null) {
                    aVar.fV(23, this.swu.boi());
                    this.swu.a(aVar);
                }
                aVar.fT(24, this.swv);
                aVar.fT(25, this.sww);
                aVar.fT(26, this.swx);
                if (this.swy != null) {
                    aVar.fV(27, this.swy.boi());
                    this.swy.a(aVar);
                }
                if (this.swz == null) {
                    return 0;
                }
                aVar.fV(28, this.swz.boi());
                this.swz.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.suK != null) {
                fS = f.a.a.a.fS(1, this.suK.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.suL != null) {
                fS += f.a.a.a.fS(2, this.suL.boi());
            }
            fS += f.a.a.a.fQ(3, this.swb);
            if (this.swc != null) {
                fS += f.a.a.a.fS(4, this.swc.boi());
            }
            if (this.swd != null) {
                fS += f.a.a.a.fS(5, this.swd.boi());
            }
            fS = (((fS + f.a.a.a.fQ(6, this.swe)) + f.a.a.a.fQ(7, this.swf)) + f.a.a.a.fQ(8, this.swg)) + f.a.a.a.fQ(9, this.swh);
            if (this.swi != null) {
                fS += f.a.a.a.fS(10, this.swi.boi());
            }
            fS += f.a.a.a.fQ(11, this.swj);
            if (this.swk != null) {
                fS += f.a.a.a.fS(12, this.swk.boi());
            }
            fS = ((((((fS + f.a.a.a.fQ(13, this.swl)) + f.a.a.a.fQ(14, this.swm)) + f.a.a.a.fQ(15, this.swn)) + f.a.a.a.fQ(16, this.swo)) + f.a.a.a.fQ(17, this.swp)) + f.a.a.a.fQ(18, this.kpK)) + f.a.a.a.fQ(19, this.swq);
            if (this.swr != null) {
                fS += f.a.a.a.fS(20, this.swr.boi());
            }
            if (this.sws != null) {
                fS += f.a.a.a.fS(21, this.sws.boi());
            }
            fS += f.a.a.a.fQ(22, this.swt);
            if (this.swu != null) {
                fS += f.a.a.a.fS(23, this.swu.boi());
            }
            fS = ((fS + f.a.a.a.fQ(24, this.swv)) + f.a.a.a.fQ(25, this.sww)) + f.a.a.a.fQ(26, this.swx);
            if (this.swy != null) {
                fS += f.a.a.a.fS(27, this.swy.boi());
            }
            if (this.swz != null) {
                fS += f.a.a.a.fS(28, this.swz.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.suK == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.suL != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            caf caf = (caf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            cak cak;
            f.a.a.a.a aVar4;
            boolean z;
            byy byy;
            bhy bhy;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cak = new cak();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cak.a(aVar4, cak, a.a(aVar4))) {
                        }
                        caf.suK = cak;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cak = new cak();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cak.a(aVar4, cak, a.a(aVar4))) {
                        }
                        caf.suL = cak;
                    }
                    return 0;
                case 3:
                    caf.swb = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byy = new byy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byy.a(aVar4, byy, a.a(aVar4))) {
                        }
                        caf.swc = byy;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byy = new byy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byy.a(aVar4, byy, a.a(aVar4))) {
                        }
                        caf.swd = byy;
                    }
                    return 0;
                case 6:
                    caf.swe = aVar3.vHC.rY();
                    return 0;
                case 7:
                    caf.swf = aVar3.vHC.rY();
                    return 0;
                case 8:
                    caf.swg = aVar3.vHC.rY();
                    return 0;
                case 9:
                    caf.swh = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        caf.swi = bhy;
                    }
                    return 0;
                case 11:
                    caf.swj = aVar3.vHC.rY();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byy = new byy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byy.a(aVar4, byy, a.a(aVar4))) {
                        }
                        caf.swk = byy;
                    }
                    return 0;
                case 13:
                    caf.swl = aVar3.vHC.rY();
                    return 0;
                case 14:
                    caf.swm = aVar3.vHC.rY();
                    return 0;
                case 15:
                    caf.swn = aVar3.vHC.rY();
                    return 0;
                case 16:
                    caf.swo = aVar3.vHC.rY();
                    return 0;
                case 17:
                    caf.swp = aVar3.vHC.rY();
                    return 0;
                case 18:
                    caf.kpK = aVar3.vHC.rY();
                    return 0;
                case 19:
                    caf.swq = aVar3.vHC.rY();
                    return 0;
                case 20:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        caf.swr = bhy;
                    }
                    return 0;
                case 21:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        caf.sws = bhy;
                    }
                    return 0;
                case 22:
                    caf.swt = aVar3.vHC.rY();
                    return 0;
                case 23:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        caf.swu = bhy;
                    }
                    return 0;
                case 24:
                    caf.swv = aVar3.vHC.rY();
                    return 0;
                case 25:
                    caf.sww = aVar3.vHC.rY();
                    return 0;
                case 26:
                    caf.swx = aVar3.vHC.rY();
                    return 0;
                case a$i.AppCompatTheme_actionModeStyle /*27*/:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        api api = new api();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = api.a(aVar4, api, a.a(aVar4))) {
                        }
                        caf.swy = api;
                    }
                    return 0;
                case a$i.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        caf.swz = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
