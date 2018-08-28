package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> nuS = new LinkedList();
    public LinkedList<e> nuT = new LinkedList();
    public LinkedList<e> nuU = new LinkedList();
    public LinkedList<e> nuV = new LinkedList();
    public LinkedList<f> nuW = new LinkedList();
    public LinkedList<f> nuX = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.nuS);
            aVar.d(2, 8, this.nuT);
            aVar.d(3, 8, this.nuU);
            aVar.d(4, 8, this.nuV);
            aVar.d(5, 8, this.nuW);
            aVar.d(6, 8, this.nuX);
            return 0;
        } else if (i == 1) {
            return (((((f.a.a.a.c(1, 8, this.nuS) + 0) + f.a.a.a.c(2, 8, this.nuT)) + f.a.a.a.c(3, 8, this.nuU)) + f.a.a.a.c(4, 8, this.nuV)) + f.a.a.a.c(5, 8, this.nuW)) + f.a.a.a.c(6, 8, this.nuX);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.nuS.clear();
                this.nuT.clear();
                this.nuU.clear();
                this.nuV.clear();
                this.nuW.clear();
                this.nuX.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                d dVar = (d) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList IC;
                int size;
                e eVar;
                f.a.a.a.a aVar4;
                boolean z;
                f fVar;
                switch (intValue) {
                    case 1:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            eVar = new e();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.nuS.add(eVar);
                        }
                        return 0;
                    case 2:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            eVar = new e();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.nuT.add(eVar);
                        }
                        return 0;
                    case 3:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            eVar = new e();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.nuU.add(eVar);
                        }
                        return 0;
                    case 4:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            eVar = new e();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.nuV.add(eVar);
                        }
                        return 0;
                    case 5:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            fVar = new f();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                            }
                            dVar.nuW.add(fVar);
                        }
                        return 0;
                    case 6:
                        IC = aVar3.IC(intValue);
                        size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            fVar = new f();
                            aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                            }
                            dVar.nuX.add(fVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
