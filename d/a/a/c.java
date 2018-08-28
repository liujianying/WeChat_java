package d.a.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class c extends a {
    public String rvZ;
    public String rxR;
    public LinkedList<g> rxS = new LinkedList();
    public int rxT;
    public a rxU;
    public int vGZ;
    public int vHa;
    public int vHb;
    public e vHc;
    public String vHd;
    public b vHe;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.rxS);
            aVar.fT(2, this.vGZ);
            if (this.rvZ != null) {
                aVar.g(3, this.rvZ);
            }
            aVar.fT(4, this.rxT);
            if (this.rxU != null) {
                aVar.fV(5, this.rxU.boi());
                this.rxU.a(aVar);
            }
            if (this.rxR != null) {
                aVar.g(6, this.rxR);
            }
            aVar.fT(7, this.vHa);
            aVar.fT(8, this.vHb);
            if (this.vHc != null) {
                aVar.fV(9, this.vHc.boi());
                this.vHc.a(aVar);
            }
            if (this.vHd != null) {
                aVar.g(10, this.vHd);
            }
            if (this.vHe != null) {
                aVar.fV(11, this.vHe.boi());
                this.vHe.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            c = (f.a.a.a.c(1, 8, this.rxS) + 0) + f.a.a.a.fQ(2, this.vGZ);
            if (this.rvZ != null) {
                c += f.a.a.b.b.a.h(3, this.rvZ);
            }
            c += f.a.a.a.fQ(4, this.rxT);
            if (this.rxU != null) {
                c += f.a.a.a.fS(5, this.rxU.boi());
            }
            if (this.rxR != null) {
                c += f.a.a.b.b.a.h(6, this.rxR);
            }
            c = (c + f.a.a.a.fQ(7, this.vHa)) + f.a.a.a.fQ(8, this.vHb);
            if (this.vHc != null) {
                c += f.a.a.a.fS(9, this.vHc.boi());
            }
            if (this.vHd != null) {
                c += f.a.a.b.b.a.h(10, this.vHd);
            }
            if (this.vHe != null) {
                return c + f.a.a.a.fS(11, this.vHe.boi());
            }
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rxS.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
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
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        g gVar = new g();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        cVar.rxS.add(gVar);
                    }
                    return 0;
                case 2:
                    cVar.vGZ = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cVar.rvZ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cVar.rxT = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, a.a(aVar4))) {
                        }
                        cVar.rxU = aVar5;
                    }
                    return 0;
                case 6:
                    cVar.rxR = aVar3.vHC.readString();
                    return 0;
                case 7:
                    cVar.vHa = aVar3.vHC.rY();
                    return 0;
                case 8:
                    cVar.vHb = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        cVar.vHc = eVar;
                    }
                    return 0;
                case 10:
                    cVar.vHd = aVar3.vHC.readString();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        b bVar = new b();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cVar.vHe = bVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
