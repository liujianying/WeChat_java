package com.tencent.mm.protocal.c;

import com.tencent.mm.plugin.appbrand.s$l;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bza extends bhp {
    public int rfh;
    public LinkedList<byx> rfi = new LinkedList();
    public int rxG;
    public long rxH;
    public int suP;
    public caf suQ;
    public int suR;
    public int suS;
    public int suT;
    public int suU;
    public bhy suV;
    public int sva;
    public LinkedList<cag> svb = new LinkedList();
    public int svc;
    public int svd;
    public int sve;
    public int svf;
    public int svg;
    public int svh;
    public int svi;
    public int svj;
    public int svk;
    public int svl;
    public int svm;
    public int svn;
    public int svo;
    public int svp;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.suQ == null) {
                throw new b("Not all required fields were included: RelayData");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.fT(2, this.rfh);
                aVar.d(3, 8, this.rfi);
                aVar.fT(4, this.rxG);
                aVar.T(5, this.rxH);
                aVar.fT(6, this.suP);
                if (this.suQ != null) {
                    aVar.fV(7, this.suQ.boi());
                    this.suQ.a(aVar);
                }
                aVar.fT(8, this.sva);
                aVar.d(9, 8, this.svb);
                aVar.fT(10, this.svc);
                aVar.fT(11, this.svd);
                aVar.fT(12, this.sve);
                aVar.fT(13, this.svf);
                aVar.fT(14, this.svg);
                aVar.fT(15, this.svh);
                aVar.fT(16, this.suR);
                aVar.fT(17, this.svi);
                aVar.fT(18, this.svj);
                aVar.fT(19, this.suS);
                aVar.fT(20, this.svk);
                aVar.fT(21, this.svl);
                aVar.fT(22, this.svm);
                aVar.fT(23, this.svn);
                aVar.fT(24, this.suT);
                aVar.fT(25, this.suU);
                aVar.fT(26, this.svo);
                aVar.fT(27, this.svp);
                if (this.suV == null) {
                    return 0;
                }
                aVar.fV(28, this.suV.boi());
                this.suV.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((fS + f.a.a.a.fQ(2, this.rfh)) + f.a.a.a.c(3, 8, this.rfi)) + f.a.a.a.fQ(4, this.rxG)) + f.a.a.a.S(5, this.rxH)) + f.a.a.a.fQ(6, this.suP);
            if (this.suQ != null) {
                fS += f.a.a.a.fS(7, this.suQ.boi());
            }
            fS = (((((((((((((((((((fS + f.a.a.a.fQ(8, this.sva)) + f.a.a.a.c(9, 8, this.svb)) + f.a.a.a.fQ(10, this.svc)) + f.a.a.a.fQ(11, this.svd)) + f.a.a.a.fQ(12, this.sve)) + f.a.a.a.fQ(13, this.svf)) + f.a.a.a.fQ(14, this.svg)) + f.a.a.a.fQ(15, this.svh)) + f.a.a.a.fQ(16, this.suR)) + f.a.a.a.fQ(17, this.svi)) + f.a.a.a.fQ(18, this.svj)) + f.a.a.a.fQ(19, this.suS)) + f.a.a.a.fQ(20, this.svk)) + f.a.a.a.fQ(21, this.svl)) + f.a.a.a.fQ(22, this.svm)) + f.a.a.a.fQ(23, this.svn)) + f.a.a.a.fQ(24, this.suT)) + f.a.a.a.fQ(25, this.suU)) + f.a.a.a.fQ(26, this.svo)) + f.a.a.a.fQ(27, this.svp);
            if (this.suV != null) {
                fS += f.a.a.a.fS(28, this.suV.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rfi.clear();
            this.svb.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.suQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RelayData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bza bza = (bza) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bza.six = flVar;
                    }
                    return 0;
                case 2:
                    bza.rfh = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byx byx = new byx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byx.a(aVar4, byx, bhp.a(aVar4))) {
                        }
                        bza.rfi.add(byx);
                    }
                    return 0;
                case 4:
                    bza.rxG = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bza.rxH = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    bza.suP = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        caf caf = new caf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = caf.a(aVar4, caf, bhp.a(aVar4))) {
                        }
                        bza.suQ = caf;
                    }
                    return 0;
                case 8:
                    bza.sva = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cag cag = new cag();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cag.a(aVar4, cag, bhp.a(aVar4))) {
                        }
                        bza.svb.add(cag);
                    }
                    return 0;
                case 10:
                    bza.svc = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bza.svd = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bza.sve = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bza.svf = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bza.svg = aVar3.vHC.rY();
                    return 0;
                case 15:
                    bza.svh = aVar3.vHC.rY();
                    return 0;
                case 16:
                    bza.suR = aVar3.vHC.rY();
                    return 0;
                case 17:
                    bza.svi = aVar3.vHC.rY();
                    return 0;
                case 18:
                    bza.svj = aVar3.vHC.rY();
                    return 0;
                case 19:
                    bza.suS = aVar3.vHC.rY();
                    return 0;
                case 20:
                    bza.svk = aVar3.vHC.rY();
                    return 0;
                case 21:
                    bza.svl = aVar3.vHC.rY();
                    return 0;
                case 22:
                    bza.svm = aVar3.vHC.rY();
                    return 0;
                case 23:
                    bza.svn = aVar3.vHC.rY();
                    return 0;
                case 24:
                    bza.suT = aVar3.vHC.rY();
                    return 0;
                case 25:
                    bza.suU = aVar3.vHC.rY();
                    return 0;
                case 26:
                    bza.svo = aVar3.vHC.rY();
                    return 0;
                case 27:
                    bza.svp = aVar3.vHC.rY();
                    return 0;
                case s$l.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bza.suV = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
