package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class c extends a {
    public String detail;
    public String dzA;
    public String lNV;
    public int lRA;
    public int lRB;
    public int lRC;
    public LinkedList<String> lRD = new LinkedList();
    public LinkedList<String> lRE = new LinkedList();
    public LinkedList<b> lRF = new LinkedList();
    public LinkedList<String> lRG = new LinkedList();
    public int lRH;
    public int lRI;
    public LinkedList<m> lRJ = new LinkedList();
    public LinkedList<a> lRK = new LinkedList();
    public k lRL;
    public LinkedList<d> lRz = new LinkedList();
    public String name;
    public int version;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.g(1, this.name);
            }
            aVar.d(2, 8, this.lRz);
            aVar.fT(3, this.lRA);
            aVar.fT(4, this.lRB);
            aVar.fT(5, this.lRC);
            aVar.d(6, 1, this.lRD);
            if (this.dzA != null) {
                aVar.g(7, this.dzA);
            }
            if (this.detail != null) {
                aVar.g(8, this.detail);
            }
            aVar.d(9, 1, this.lRE);
            aVar.d(10, 8, this.lRF);
            aVar.d(11, 1, this.lRG);
            aVar.fT(12, this.lRH);
            aVar.fT(13, this.lRI);
            aVar.d(14, 8, this.lRJ);
            aVar.fT(15, this.version);
            aVar.d(16, 8, this.lRK);
            if (this.lNV != null) {
                aVar.g(17, this.lNV);
            }
            if (this.lRL == null) {
                return 0;
            }
            aVar.fV(18, this.lRL.boi());
            this.lRL.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                h = f.a.a.b.b.a.h(1, this.name) + 0;
            } else {
                h = 0;
            }
            h = ((((h + f.a.a.a.c(2, 8, this.lRz)) + f.a.a.a.fQ(3, this.lRA)) + f.a.a.a.fQ(4, this.lRB)) + f.a.a.a.fQ(5, this.lRC)) + f.a.a.a.c(6, 1, this.lRD);
            if (this.dzA != null) {
                h += f.a.a.b.b.a.h(7, this.dzA);
            }
            if (this.detail != null) {
                h += f.a.a.b.b.a.h(8, this.detail);
            }
            h = (((((((h + f.a.a.a.c(9, 1, this.lRE)) + f.a.a.a.c(10, 8, this.lRF)) + f.a.a.a.c(11, 1, this.lRG)) + f.a.a.a.fQ(12, this.lRH)) + f.a.a.a.fQ(13, this.lRI)) + f.a.a.a.c(14, 8, this.lRJ)) + f.a.a.a.fQ(15, this.version)) + f.a.a.a.c(16, 8, this.lRK);
            if (this.lNV != null) {
                h += f.a.a.b.b.a.h(17, this.lNV);
            }
            if (this.lRL != null) {
                h += f.a.a.a.fS(18, this.lRL.boi());
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.lRz.clear();
            this.lRD.clear();
            this.lRE.clear();
            this.lRF.clear();
            this.lRG.clear();
            this.lRJ.clear();
            this.lRK.clear();
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.name = aVar3.vHC.readString();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        d dVar = new d();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.lRz.add(dVar);
                    }
                    return 0;
                case 3:
                    cVar.lRA = aVar3.vHC.rY();
                    return 0;
                case 4:
                    cVar.lRB = aVar3.vHC.rY();
                    return 0;
                case 5:
                    cVar.lRC = aVar3.vHC.rY();
                    return 0;
                case 6:
                    cVar.lRD.add(aVar3.vHC.readString());
                    return 0;
                case 7:
                    cVar.dzA = aVar3.vHC.readString();
                    return 0;
                case 8:
                    cVar.detail = aVar3.vHC.readString();
                    return 0;
                case 9:
                    cVar.lRE.add(aVar3.vHC.readString());
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        b bVar = new b();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cVar.lRF.add(bVar);
                    }
                    return 0;
                case 11:
                    cVar.lRG.add(aVar3.vHC.readString());
                    return 0;
                case 12:
                    cVar.lRH = aVar3.vHC.rY();
                    return 0;
                case 13:
                    cVar.lRI = aVar3.vHC.rY();
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        m mVar = new m();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        cVar.lRJ.add(mVar);
                    }
                    return 0;
                case 15:
                    cVar.version = aVar3.vHC.rY();
                    return 0;
                case 16:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, a.a(aVar4))) {
                        }
                        cVar.lRK.add(aVar5);
                    }
                    return 0;
                case 17:
                    cVar.lNV = aVar3.vHC.readString();
                    return 0;
                case 18:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        k kVar = new k();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                        }
                        cVar.lRL = kVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
