package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class agl extends bhp {
    public String jOS;
    public String jPe;
    public LinkedList<ts> rHC = new LinkedList();
    public String rJT;
    public bhy rcT;
    public LinkedList<ta> rgD = new LinkedList();
    public String rgK;
    public String rxm;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rJT == null) {
                throw new b("Not all required fields were included: BannerUrl");
            } else if (this.jPe == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.jOS == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.rxm == null) {
                throw new b("Not all required fields were included: HeadUrl");
            } else if (this.rgK == null) {
                throw new b("Not all required fields were included: BizName");
            } else if (this.rcT == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.rJT != null) {
                    aVar.g(2, this.rJT);
                }
                if (this.jPe != null) {
                    aVar.g(3, this.jPe);
                }
                if (this.jOS != null) {
                    aVar.g(4, this.jOS);
                }
                if (this.rxm != null) {
                    aVar.g(5, this.rxm);
                }
                if (this.rgK != null) {
                    aVar.g(6, this.rgK);
                }
                aVar.d(7, 8, this.rHC);
                if (this.rcT != null) {
                    aVar.fV(8, this.rcT.boi());
                    this.rcT.a(aVar);
                }
                aVar.d(9, 8, this.rgD);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rJT != null) {
                fS += f.a.a.b.b.a.h(2, this.rJT);
            }
            if (this.jPe != null) {
                fS += f.a.a.b.b.a.h(3, this.jPe);
            }
            if (this.jOS != null) {
                fS += f.a.a.b.b.a.h(4, this.jOS);
            }
            if (this.rxm != null) {
                fS += f.a.a.b.b.a.h(5, this.rxm);
            }
            if (this.rgK != null) {
                fS += f.a.a.b.b.a.h(6, this.rgK);
            }
            fS += f.a.a.a.c(7, 8, this.rHC);
            if (this.rcT != null) {
                fS += f.a.a.a.fS(8, this.rcT.boi());
            }
            return fS + f.a.a.a.c(9, 8, this.rgD);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rHC.clear();
            this.rgD.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rJT == null) {
                throw new b("Not all required fields were included: BannerUrl");
            } else if (this.jPe == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.jOS == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.rxm == null) {
                throw new b("Not all required fields were included: HeadUrl");
            } else if (this.rgK == null) {
                throw new b("Not all required fields were included: BizName");
            } else if (this.rcT != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            agl agl = (agl) objArr[1];
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
                        agl.six = flVar;
                    }
                    return 0;
                case 2:
                    agl.rJT = aVar3.vHC.readString();
                    return 0;
                case 3:
                    agl.jPe = aVar3.vHC.readString();
                    return 0;
                case 4:
                    agl.jOS = aVar3.vHC.readString();
                    return 0;
                case 5:
                    agl.rxm = aVar3.vHC.readString();
                    return 0;
                case 6:
                    agl.rgK = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ts tsVar = new ts();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tsVar.a(aVar4, tsVar, bhp.a(aVar4))) {
                        }
                        agl.rHC.add(tsVar);
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        agl.rcT = bhy;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ta taVar = new ta();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = taVar.a(aVar4, taVar, bhp.a(aVar4))) {
                        }
                        agl.rgD.add(taVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
