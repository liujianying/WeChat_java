package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class f extends a {
    public double pdV;
    public double pdW;
    public double pdX;
    public String pdY;
    public LinkedList<q> pdZ = new LinkedList();
    public g pea;
    public int peb;
    public String pec;
    public String ped;
    public double pee;
    public double pef;
    public int peg;
    public String peh;
    public String pei;
    public a pej;

    protected final int a(int i, Object... objArr) {
        int ec;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.c(1, this.pdV);
            aVar.c(2, this.pdW);
            aVar.c(3, this.pdX);
            if (this.pdY != null) {
                aVar.g(4, this.pdY);
            }
            aVar.d(5, 8, this.pdZ);
            if (this.pea != null) {
                aVar.fV(6, this.pea.boi());
                this.pea.a(aVar);
            }
            aVar.fT(7, this.peb);
            if (this.pec != null) {
                aVar.g(8, this.pec);
            }
            if (this.ped != null) {
                aVar.g(9, this.ped);
            }
            aVar.c(10, this.pee);
            aVar.c(11, this.pef);
            aVar.fT(12, this.peg);
            if (this.peh != null) {
                aVar.g(13, this.peh);
            }
            if (this.pei != null) {
                aVar.g(14, this.pei);
            }
            if (this.pej != null) {
                aVar.fV(15, this.pej.boi());
                this.pej.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            ec = (((f.a.a.b.b.a.ec(1) + 8) + 0) + (f.a.a.b.b.a.ec(2) + 8)) + (f.a.a.b.b.a.ec(3) + 8);
            if (this.pdY != null) {
                ec += f.a.a.b.b.a.h(4, this.pdY);
            }
            ec += f.a.a.a.c(5, 8, this.pdZ);
            if (this.pea != null) {
                ec += f.a.a.a.fS(6, this.pea.boi());
            }
            ec += f.a.a.a.fQ(7, this.peb);
            if (this.pec != null) {
                ec += f.a.a.b.b.a.h(8, this.pec);
            }
            if (this.ped != null) {
                ec += f.a.a.b.b.a.h(9, this.ped);
            }
            ec = ((ec + (f.a.a.b.b.a.ec(10) + 8)) + (f.a.a.b.b.a.ec(11) + 8)) + f.a.a.a.fQ(12, this.peg);
            if (this.peh != null) {
                ec += f.a.a.b.b.a.h(13, this.peh);
            }
            if (this.pei != null) {
                ec += f.a.a.b.b.a.h(14, this.pei);
            }
            if (this.pej != null) {
                return ec + f.a.a.a.fS(15, this.pej.boi());
            }
            return ec;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pdZ.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (ec = a.a(aVar2); ec > 0; ec = a.a(aVar2)) {
                if (!super.a(aVar2, this, ec)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    fVar.pdV = aVar3.vHC.readDouble();
                    return 0;
                case 2:
                    fVar.pdW = aVar3.vHC.readDouble();
                    return 0;
                case 3:
                    fVar.pdX = aVar3.vHC.readDouble();
                    return 0;
                case 4:
                    fVar.pdY = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        q qVar = new q();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        fVar.pdZ.add(qVar);
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        a gVar = new g();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        fVar.pea = gVar;
                    }
                    return 0;
                case 7:
                    fVar.peb = aVar3.vHC.rY();
                    return 0;
                case 8:
                    fVar.pec = aVar3.vHC.readString();
                    return 0;
                case 9:
                    fVar.ped = aVar3.vHC.readString();
                    return 0;
                case 10:
                    fVar.pee = aVar3.vHC.readDouble();
                    return 0;
                case 11:
                    fVar.pef = aVar3.vHC.readDouble();
                    return 0;
                case 12:
                    fVar.peg = aVar3.vHC.rY();
                    return 0;
                case 13:
                    fVar.peh = aVar3.vHC.readString();
                    return 0;
                case 14:
                    fVar.pei = aVar3.vHC.readString();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, a.a(aVar4))) {
                        }
                        fVar.pej = aVar5;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
