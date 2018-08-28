package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aih extends bhp {
    public LinkedList<ba> jSI = new LinkedList();
    public LinkedList<aky> jSm = new LinkedList();
    public int rLe;
    public LinkedList<bet> rLf = new LinkedList();
    public int rLg;
    public int rLh;
    public int rLi;
    public akx rLj;

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
            aVar.fT(2, this.rLe);
            aVar.d(3, 8, this.rLf);
            aVar.fT(4, this.rLg);
            aVar.fT(5, this.rLh);
            aVar.d(6, 8, this.jSI);
            aVar.fT(7, this.rLi);
            aVar.d(8, 8, this.jSm);
            if (this.rLj == null) {
                return 0;
            }
            aVar.fV(9, this.rLj.boi());
            this.rLj.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((((fS + f.a.a.a.fQ(2, this.rLe)) + f.a.a.a.c(3, 8, this.rLf)) + f.a.a.a.fQ(4, this.rLg)) + f.a.a.a.fQ(5, this.rLh)) + f.a.a.a.c(6, 8, this.jSI)) + f.a.a.a.fQ(7, this.rLi)) + f.a.a.a.c(8, 8, this.jSm);
            if (this.rLj != null) {
                fS += f.a.a.a.fS(9, this.rLj.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rLf.clear();
            this.jSI.clear();
            this.jSm.clear();
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
            aih aih = (aih) objArr[1];
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
                        aih.six = flVar;
                    }
                    return 0;
                case 2:
                    aih.rLe = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bet bet = new bet();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bet.a(aVar4, bet, bhp.a(aVar4))) {
                        }
                        aih.rLf.add(bet);
                    }
                    return 0;
                case 4:
                    aih.rLg = aVar3.vHC.rY();
                    return 0;
                case 5:
                    aih.rLh = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ba baVar = new ba();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baVar.a(aVar4, baVar, bhp.a(aVar4))) {
                        }
                        aih.jSI.add(baVar);
                    }
                    return 0;
                case 7:
                    aih.rLi = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aky aky = new aky();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aky.a(aVar4, aky, bhp.a(aVar4))) {
                        }
                        aih.jSm.add(aky);
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        akx akx = new akx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = akx.a(aVar4, akx, bhp.a(aVar4))) {
                        }
                        aih.rLj = akx;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
