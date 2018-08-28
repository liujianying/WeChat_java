package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class xv extends a {
    public String jPG;
    public String jPe;
    public String jPf;
    public String jQb;
    public ye rDE;
    public int rDF;
    public String rDG;
    public String rul;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQb == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.jPe == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.rul == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.jPG == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.rDE == null) {
                throw new b("Not all required fields were included: DownloadInfo");
            } else {
                if (this.jQb != null) {
                    aVar.g(1, this.jQb);
                }
                if (this.jPe != null) {
                    aVar.g(2, this.jPe);
                }
                if (this.rul != null) {
                    aVar.g(3, this.rul);
                }
                if (this.jPG != null) {
                    aVar.g(4, this.jPG);
                }
                if (this.jPf != null) {
                    aVar.g(5, this.jPf);
                }
                if (this.rDE != null) {
                    aVar.fV(6, this.rDE.boi());
                    this.rDE.a(aVar);
                }
                aVar.fT(7, this.rDF);
                if (this.rDG == null) {
                    return 0;
                }
                aVar.g(8, this.rDG);
                return 0;
            }
        } else if (i == 1) {
            if (this.jQb != null) {
                h = f.a.a.b.b.a.h(1, this.jQb) + 0;
            } else {
                h = 0;
            }
            if (this.jPe != null) {
                h += f.a.a.b.b.a.h(2, this.jPe);
            }
            if (this.rul != null) {
                h += f.a.a.b.b.a.h(3, this.rul);
            }
            if (this.jPG != null) {
                h += f.a.a.b.b.a.h(4, this.jPG);
            }
            if (this.jPf != null) {
                h += f.a.a.b.b.a.h(5, this.jPf);
            }
            if (this.rDE != null) {
                h += f.a.a.a.fS(6, this.rDE.boi());
            }
            h += f.a.a.a.fQ(7, this.rDF);
            if (this.rDG != null) {
                h += f.a.a.b.b.a.h(8, this.rDG);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jQb == null) {
                throw new b("Not all required fields were included: AppId");
            } else if (this.jPe == null) {
                throw new b("Not all required fields were included: Name");
            } else if (this.rul == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.jPG == null) {
                throw new b("Not all required fields were included: IconUrl");
            } else if (this.rDE != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DownloadInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            xv xvVar = (xv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    xvVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 2:
                    xvVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 3:
                    xvVar.rul = aVar3.vHC.readString();
                    return 0;
                case 4:
                    xvVar.jPG = aVar3.vHC.readString();
                    return 0;
                case 5:
                    xvVar.jPf = aVar3.vHC.readString();
                    return 0;
                case 6:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        ye yeVar = new ye();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = yeVar.a(aVar4, yeVar, a.a(aVar4))) {
                        }
                        xvVar.rDE = yeVar;
                    }
                    return 0;
                case 7:
                    xvVar.rDF = aVar3.vHC.rY();
                    return 0;
                case 8:
                    xvVar.rDG = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
