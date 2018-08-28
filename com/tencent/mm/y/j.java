package com.tencent.mm.y;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public class j extends a {
    public String bZG;
    public String bZH;
    public String cGB;
    public LinkedList<m> dzs = new LinkedList();
    public int dzt;
    public String name;
    public int type;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.type);
            if (this.name != null) {
                aVar.g(2, this.name);
            }
            if (this.bZG != null) {
                aVar.g(3, this.bZG);
            }
            if (this.bZH != null) {
                aVar.g(4, this.bZH);
            }
            if (this.cGB != null) {
                aVar.g(5, this.cGB);
            }
            aVar.d(6, 8, this.dzs);
            aVar.fT(7, this.dzt);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.type) + 0;
            if (this.name != null) {
                fQ += f.a.a.b.b.a.h(2, this.name);
            }
            if (this.bZG != null) {
                fQ += f.a.a.b.b.a.h(3, this.bZG);
            }
            if (this.bZH != null) {
                fQ += f.a.a.b.b.a.h(4, this.bZH);
            }
            if (this.cGB != null) {
                fQ += f.a.a.b.b.a.h(5, this.cGB);
            }
            return (fQ + f.a.a.a.c(6, 8, this.dzs)) + f.a.a.a.fQ(7, this.dzt);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.dzs.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.type = aVar3.vHC.rY();
                    return 0;
                case 2:
                    jVar.name = aVar3.vHC.readString();
                    return 0;
                case 3:
                    jVar.bZG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    jVar.bZH = aVar3.vHC.readString();
                    return 0;
                case 5:
                    jVar.cGB = aVar3.vHC.readString();
                    return 0;
                case 6:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        m mVar = new m();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        jVar.dzs.add(mVar);
                    }
                    return 0;
                case 7:
                    jVar.dzt = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
