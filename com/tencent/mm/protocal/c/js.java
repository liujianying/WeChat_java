package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class js extends a {
    public String bHD;
    public String jOS;
    public String lPl;
    public jv rlg;
    public jw rlh;
    public jp rli;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jOS == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.lPl == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else if (this.rlg == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else if (this.rli == null) {
                throw new b("Not all required fields were included: ActionInfo");
            } else {
                if (this.bHD != null) {
                    aVar.g(1, this.bHD);
                }
                if (this.jOS != null) {
                    aVar.g(2, this.jOS);
                }
                if (this.lPl != null) {
                    aVar.g(3, this.lPl);
                }
                if (this.rlg != null) {
                    aVar.fV(4, this.rlg.boi());
                    this.rlg.a(aVar);
                }
                if (this.rlh != null) {
                    aVar.fV(5, this.rlh.boi());
                    this.rlh.a(aVar);
                }
                if (this.rli == null) {
                    return 0;
                }
                aVar.fV(6, this.rli.boi());
                this.rli.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            if (this.jOS != null) {
                h += f.a.a.b.b.a.h(2, this.jOS);
            }
            if (this.lPl != null) {
                h += f.a.a.b.b.a.h(3, this.lPl);
            }
            if (this.rlg != null) {
                h += f.a.a.a.fS(4, this.rlg.boi());
            }
            if (this.rlh != null) {
                h += f.a.a.a.fS(5, this.rlh.boi());
            }
            if (this.rli != null) {
                h += f.a.a.a.fS(6, this.rli.boi());
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jOS == null) {
                throw new b("Not all required fields were included: Desc");
            } else if (this.lPl == null) {
                throw new b("Not all required fields were included: ThumbUrl");
            } else if (this.rlg == null) {
                throw new b("Not all required fields were included: DetailInfo");
            } else if (this.rli != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ActionInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            js jsVar = (js) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jsVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    jsVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    jsVar.lPl = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        jv jvVar = new jv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jvVar.a(aVar4, jvVar, a.a(aVar4))) {
                        }
                        jsVar.rlg = jvVar;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        jw jwVar = new jw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jwVar.a(aVar4, jwVar, a.a(aVar4))) {
                        }
                        jsVar.rlh = jwVar;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        jp jpVar = new jp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jpVar.a(aVar4, jpVar, a.a(aVar4))) {
                        }
                        jsVar.rli = jpVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
