package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bez extends a {
    public int id;
    public bhz sgA;
    public bhz sgB;
    public bhz sgC;
    public bhz sgD;
    public bhz sgE;
    public bhz sgF;
    public bhz sgx;
    public bhz sgy;
    public bhz sgz;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sgy == null) {
                throw new b("Not all required fields were included: province");
            } else if (this.sgz == null) {
                throw new b("Not all required fields were included: city");
            } else if (this.sgA == null) {
                throw new b("Not all required fields were included: district");
            } else if (this.sgB == null) {
                throw new b("Not all required fields were included: zipcode");
            } else if (this.sgC == null) {
                throw new b("Not all required fields were included: detail");
            } else if (this.sgD == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.sgE == null) {
                throw new b("Not all required fields were included: phone");
            } else {
                aVar.fT(1, this.id);
                if (this.sgx != null) {
                    aVar.fV(2, this.sgx.boi());
                    this.sgx.a(aVar);
                }
                if (this.sgy != null) {
                    aVar.fV(3, this.sgy.boi());
                    this.sgy.a(aVar);
                }
                if (this.sgz != null) {
                    aVar.fV(4, this.sgz.boi());
                    this.sgz.a(aVar);
                }
                if (this.sgA != null) {
                    aVar.fV(5, this.sgA.boi());
                    this.sgA.a(aVar);
                }
                if (this.sgB != null) {
                    aVar.fV(6, this.sgB.boi());
                    this.sgB.a(aVar);
                }
                if (this.sgC != null) {
                    aVar.fV(7, this.sgC.boi());
                    this.sgC.a(aVar);
                }
                if (this.sgD != null) {
                    aVar.fV(8, this.sgD.boi());
                    this.sgD.a(aVar);
                }
                if (this.sgE != null) {
                    aVar.fV(9, this.sgE.boi());
                    this.sgE.a(aVar);
                }
                if (this.sgF != null) {
                    aVar.fV(10, this.sgF.boi());
                    this.sgF.a(aVar);
                }
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.id) + 0;
            if (this.sgx != null) {
                fQ += f.a.a.a.fS(2, this.sgx.boi());
            }
            if (this.sgy != null) {
                fQ += f.a.a.a.fS(3, this.sgy.boi());
            }
            if (this.sgz != null) {
                fQ += f.a.a.a.fS(4, this.sgz.boi());
            }
            if (this.sgA != null) {
                fQ += f.a.a.a.fS(5, this.sgA.boi());
            }
            if (this.sgB != null) {
                fQ += f.a.a.a.fS(6, this.sgB.boi());
            }
            if (this.sgC != null) {
                fQ += f.a.a.a.fS(7, this.sgC.boi());
            }
            if (this.sgD != null) {
                fQ += f.a.a.a.fS(8, this.sgD.boi());
            }
            if (this.sgE != null) {
                fQ += f.a.a.a.fS(9, this.sgE.boi());
            }
            if (this.sgF != null) {
                return fQ + f.a.a.a.fS(10, this.sgF.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.sgy == null) {
                throw new b("Not all required fields were included: province");
            } else if (this.sgz == null) {
                throw new b("Not all required fields were included: city");
            } else if (this.sgA == null) {
                throw new b("Not all required fields were included: district");
            } else if (this.sgB == null) {
                throw new b("Not all required fields were included: zipcode");
            } else if (this.sgC == null) {
                throw new b("Not all required fields were included: detail");
            } else if (this.sgD == null) {
                throw new b("Not all required fields were included: name");
            } else if (this.sgE != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: phone");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bez bez = (bez) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            bhz bhz;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bez.id = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bez.sgx = bhz;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bez.sgy = bhz;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bez.sgz = bhz;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bez.sgA = bhz;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bez.sgB = bhz;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bez.sgC = bhz;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bez.sgD = bhz;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bez.sgE = bhz;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bez.sgF = bhz;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
