package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class bsx extends a {
    public String bIr;
    public String bxD;
    public int gsu;
    public String kcL;
    public String knh;
    public String knj;
    public String knk;
    public String knl;
    public String sqp;
    public String sqq;
    public String title;
    public int versionCode;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.knj == null) {
                throw new b("Not all required fields were included: patchId");
            } else if (this.knk == null) {
                throw new b("Not all required fields were included: newApkMd5");
            } else if (this.knl == null) {
                throw new b("Not all required fields were included: oldApkMd5");
            } else if (this.title == null) {
                throw new b("Not all required fields were included: title");
            } else if (this.sqq == null) {
                throw new b("Not all required fields were included: okBtn");
            } else if (this.kcL == null) {
                throw new b("Not all required fields were included: cancelBtn");
            } else if (this.bxD == null) {
                throw new b("Not all required fields were included: patchMd5");
            } else {
                if (this.knj != null) {
                    aVar.g(1, this.knj);
                }
                if (this.sqp != null) {
                    aVar.g(2, this.sqp);
                }
                aVar.fT(3, this.gsu);
                if (this.knk != null) {
                    aVar.g(4, this.knk);
                }
                if (this.knl != null) {
                    aVar.g(5, this.knl);
                }
                if (this.title != null) {
                    aVar.g(6, this.title);
                }
                if (this.bIr != null) {
                    aVar.g(7, this.bIr);
                }
                if (this.sqq != null) {
                    aVar.g(8, this.sqq);
                }
                if (this.kcL != null) {
                    aVar.g(9, this.kcL);
                }
                if (this.knh != null) {
                    aVar.g(10, this.knh);
                }
                if (this.bxD != null) {
                    aVar.g(11, this.bxD);
                }
                aVar.fT(12, this.versionCode);
                return 0;
            }
        } else if (i == 1) {
            if (this.knj != null) {
                h = f.a.a.b.b.a.h(1, this.knj) + 0;
            } else {
                h = 0;
            }
            if (this.sqp != null) {
                h += f.a.a.b.b.a.h(2, this.sqp);
            }
            h += f.a.a.a.fQ(3, this.gsu);
            if (this.knk != null) {
                h += f.a.a.b.b.a.h(4, this.knk);
            }
            if (this.knl != null) {
                h += f.a.a.b.b.a.h(5, this.knl);
            }
            if (this.title != null) {
                h += f.a.a.b.b.a.h(6, this.title);
            }
            if (this.bIr != null) {
                h += f.a.a.b.b.a.h(7, this.bIr);
            }
            if (this.sqq != null) {
                h += f.a.a.b.b.a.h(8, this.sqq);
            }
            if (this.kcL != null) {
                h += f.a.a.b.b.a.h(9, this.kcL);
            }
            if (this.knh != null) {
                h += f.a.a.b.b.a.h(10, this.knh);
            }
            if (this.bxD != null) {
                h += f.a.a.b.b.a.h(11, this.bxD);
            }
            return h + f.a.a.a.fQ(12, this.versionCode);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.knj == null) {
                throw new b("Not all required fields were included: patchId");
            } else if (this.knk == null) {
                throw new b("Not all required fields were included: newApkMd5");
            } else if (this.knl == null) {
                throw new b("Not all required fields were included: oldApkMd5");
            } else if (this.title == null) {
                throw new b("Not all required fields were included: title");
            } else if (this.sqq == null) {
                throw new b("Not all required fields were included: okBtn");
            } else if (this.kcL == null) {
                throw new b("Not all required fields were included: cancelBtn");
            } else if (this.bxD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: patchMd5");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bsx bsx = (bsx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bsx.knj = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bsx.sqp = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bsx.gsu = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bsx.knk = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bsx.knl = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bsx.title = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bsx.bIr = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bsx.sqq = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bsx.kcL = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bsx.knh = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bsx.bxD = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bsx.versionCode = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
