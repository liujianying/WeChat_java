package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class adn extends bhp {
    public int rHV;
    public int rHW;
    public LinkedList<Integer> rHX = new LinkedList();
    public LinkedList<un> rHY = new LinkedList();
    public int rHZ;

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
            aVar.fT(2, this.rHV);
            aVar.fT(3, this.rHW);
            aVar.d(4, 2, this.rHX);
            aVar.d(5, 8, this.rHY);
            aVar.fT(6, this.rHZ);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return ((((fS + f.a.a.a.fQ(2, this.rHV)) + f.a.a.a.fQ(3, this.rHW)) + f.a.a.a.c(4, 2, this.rHX)) + f.a.a.a.c(5, 8, this.rHY)) + f.a.a.a.fQ(6, this.rHZ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rHX.clear();
            this.rHY.clear();
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
            adn adn = (adn) objArr[1];
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
                        adn.six = flVar;
                    }
                    return 0;
                case 2:
                    adn.rHV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    adn.rHW = aVar3.vHC.rY();
                    return 0;
                case 4:
                    adn.rHX.add(Integer.valueOf(aVar3.vHC.rY()));
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        un unVar = new un();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = unVar.a(aVar4, unVar, bhp.a(aVar4))) {
                        }
                        adn.rHY.add(unVar);
                    }
                    return 0;
                case 6:
                    adn.rHZ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
