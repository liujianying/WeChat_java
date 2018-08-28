package com.tencent.mm.protocal.c;

import com.tencent.mm.plugin.wxpay.a$k;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class cae extends bhp {
    public int rfh;
    public LinkedList<byx> rfi = new LinkedList();
    public int rxG;
    public long rxH;
    public int seq;
    public caf suQ;
    public int suR;
    public int suS;
    public int suT;
    public int suU;
    public bhy suV;
    public int svY;
    public int svZ;
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
    public int swa;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.rxG);
            aVar.fT(3, this.rfh);
            aVar.d(4, 8, this.rfi);
            aVar.T(5, this.rxH);
            aVar.fT(6, this.seq);
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
            aVar.fT(14, this.svY);
            aVar.fT(15, this.svg);
            aVar.fT(16, this.svh);
            aVar.fT(17, this.suR);
            aVar.fT(18, this.svi);
            aVar.fT(19, this.svj);
            aVar.fT(20, this.suS);
            aVar.fT(21, this.svk);
            aVar.fT(22, this.svl);
            aVar.fT(23, this.svm);
            aVar.fT(24, this.svZ);
            aVar.fT(25, this.svn);
            aVar.fT(26, this.swa);
            aVar.fT(27, this.suT);
            aVar.fT(28, this.suU);
            aVar.fT(29, this.svo);
            aVar.fT(30, this.svp);
            if (this.suV == null) {
                return 0;
            }
            aVar.fV(31, this.suV.boi());
            this.suV.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.fQ(3, this.rfh)) + f.a.a.a.c(4, 8, this.rfi)) + f.a.a.a.S(5, this.rxH)) + f.a.a.a.fQ(6, this.seq);
            if (this.suQ != null) {
                fS += f.a.a.a.fS(7, this.suQ.boi());
            }
            fS = ((((((((((((((((((((((fS + f.a.a.a.fQ(8, this.sva)) + f.a.a.a.c(9, 8, this.svb)) + f.a.a.a.fQ(10, this.svc)) + f.a.a.a.fQ(11, this.svd)) + f.a.a.a.fQ(12, this.sve)) + f.a.a.a.fQ(13, this.svf)) + f.a.a.a.fQ(14, this.svY)) + f.a.a.a.fQ(15, this.svg)) + f.a.a.a.fQ(16, this.svh)) + f.a.a.a.fQ(17, this.suR)) + f.a.a.a.fQ(18, this.svi)) + f.a.a.a.fQ(19, this.svj)) + f.a.a.a.fQ(20, this.suS)) + f.a.a.a.fQ(21, this.svk)) + f.a.a.a.fQ(22, this.svl)) + f.a.a.a.fQ(23, this.svm)) + f.a.a.a.fQ(24, this.svZ)) + f.a.a.a.fQ(25, this.svn)) + f.a.a.a.fQ(26, this.swa)) + f.a.a.a.fQ(27, this.suT)) + f.a.a.a.fQ(28, this.suU)) + f.a.a.a.fQ(29, this.svo)) + f.a.a.a.fQ(30, this.svp);
            if (this.suV != null) {
                fS += f.a.a.a.fS(31, this.suV.boi());
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
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cae cae = (cae) objArr[1];
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
                        cae.six = flVar;
                    }
                    return 0;
                case 2:
                    cae.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cae.rfh = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byx byx = new byx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byx.a(aVar4, byx, bhp.a(aVar4))) {
                        }
                        cae.rfi.add(byx);
                    }
                    return 0;
                case 5:
                    cae.rxH = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    cae.seq = aVar3.vHC.rY();
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
                        cae.suQ = caf;
                    }
                    return 0;
                case 8:
                    cae.sva = aVar3.vHC.rY();
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
                        cae.svb.add(cag);
                    }
                    return 0;
                case 10:
                    cae.svc = aVar3.vHC.rY();
                    return 0;
                case 11:
                    cae.svd = aVar3.vHC.rY();
                    return 0;
                case 12:
                    cae.sve = aVar3.vHC.rY();
                    return 0;
                case 13:
                    cae.svf = aVar3.vHC.rY();
                    return 0;
                case 14:
                    cae.svY = aVar3.vHC.rY();
                    return 0;
                case 15:
                    cae.svg = aVar3.vHC.rY();
                    return 0;
                case 16:
                    cae.svh = aVar3.vHC.rY();
                    return 0;
                case 17:
                    cae.suR = aVar3.vHC.rY();
                    return 0;
                case 18:
                    cae.svi = aVar3.vHC.rY();
                    return 0;
                case 19:
                    cae.svj = aVar3.vHC.rY();
                    return 0;
                case 20:
                    cae.suS = aVar3.vHC.rY();
                    return 0;
                case 21:
                    cae.svk = aVar3.vHC.rY();
                    return 0;
                case 22:
                    cae.svl = aVar3.vHC.rY();
                    return 0;
                case 23:
                    cae.svm = aVar3.vHC.rY();
                    return 0;
                case 24:
                    cae.svZ = aVar3.vHC.rY();
                    return 0;
                case 25:
                    cae.svn = aVar3.vHC.rY();
                    return 0;
                case 26:
                    cae.swa = aVar3.vHC.rY();
                    return 0;
                case 27:
                    cae.suT = aVar3.vHC.rY();
                    return 0;
                case 28:
                    cae.suU = aVar3.vHC.rY();
                    return 0;
                case 29:
                    cae.svo = aVar3.vHC.rY();
                    return 0;
                case a$k.AppCompatTheme_actionModeSplitBackground /*30*/:
                    cae.svp = aVar3.vHC.rY();
                    return 0;
                case 31:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        cae.suV = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
