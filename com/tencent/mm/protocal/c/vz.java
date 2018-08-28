package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class vz extends a {
    public String appId;
    public String bGy;
    public int bJt;
    public String bSS;
    public String bWQ;
    public String cca;
    public long createTime;
    public boolean dUe = false;
    public String egr;
    public boolean rBc = false;
    public boolean rBd = false;
    public boolean rBe = false;
    public String rBf;
    public boolean rBg = false;
    public String rBh;
    public boolean rBi = false;
    public boolean rBj = false;
    public boolean rBk = false;
    public boolean rBl = false;
    public boolean rBm = false;
    public String rBn;
    public boolean rBo = false;
    public boolean rBp = false;
    public String toUser;

    public final vz CJ(int i) {
        this.bJt = i;
        this.rBc = true;
        return this;
    }

    public final vz Vf(String str) {
        this.bSS = str;
        this.rBd = true;
        return this;
    }

    public final vz Vg(String str) {
        this.toUser = str;
        this.rBe = true;
        return this;
    }

    public final vz Vh(String str) {
        this.rBf = str;
        this.rBg = true;
        return this;
    }

    public final vz Vi(String str) {
        this.rBh = str;
        this.rBi = true;
        return this;
    }

    public final vz fR(long j) {
        this.createTime = j;
        this.dUe = true;
        return this;
    }

    public final vz Vj(String str) {
        this.bWQ = str;
        this.rBj = true;
        return this;
    }

    public final vz Vk(String str) {
        this.appId = str;
        this.rBl = true;
        return this;
    }

    public final vz Vl(String str) {
        this.egr = str;
        this.rBm = true;
        return this;
    }

    public final vz Vm(String str) {
        this.bGy = str;
        this.rBp = true;
        return this;
    }

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rBc) {
                if (this.rBc) {
                    aVar.fT(1, this.bJt);
                }
                if (this.bSS != null) {
                    aVar.g(2, this.bSS);
                }
                if (this.toUser != null) {
                    aVar.g(3, this.toUser);
                }
                if (this.rBf != null) {
                    aVar.g(4, this.rBf);
                }
                if (this.rBh != null) {
                    aVar.g(5, this.rBh);
                }
                if (this.dUe) {
                    aVar.T(6, this.createTime);
                }
                if (this.bWQ != null) {
                    aVar.g(7, this.bWQ);
                }
                if (this.cca != null) {
                    aVar.g(8, this.cca);
                }
                if (this.appId != null) {
                    aVar.g(9, this.appId);
                }
                if (this.egr != null) {
                    aVar.g(10, this.egr);
                }
                if (this.rBn != null) {
                    aVar.g(11, this.rBn);
                }
                if (this.bGy == null) {
                    return 0;
                }
                aVar.g(12, this.bGy);
                return 0;
            }
            throw new b("Not all required fields were included: sourceType");
        } else if (i == 1) {
            if (this.rBc) {
                fQ = f.a.a.a.fQ(1, this.bJt) + 0;
            } else {
                fQ = 0;
            }
            if (this.bSS != null) {
                fQ += f.a.a.b.b.a.h(2, this.bSS);
            }
            if (this.toUser != null) {
                fQ += f.a.a.b.b.a.h(3, this.toUser);
            }
            if (this.rBf != null) {
                fQ += f.a.a.b.b.a.h(4, this.rBf);
            }
            if (this.rBh != null) {
                fQ += f.a.a.b.b.a.h(5, this.rBh);
            }
            if (this.dUe) {
                fQ += f.a.a.a.S(6, this.createTime);
            }
            if (this.bWQ != null) {
                fQ += f.a.a.b.b.a.h(7, this.bWQ);
            }
            if (this.cca != null) {
                fQ += f.a.a.b.b.a.h(8, this.cca);
            }
            if (this.appId != null) {
                fQ += f.a.a.b.b.a.h(9, this.appId);
            }
            if (this.egr != null) {
                fQ += f.a.a.b.b.a.h(10, this.egr);
            }
            if (this.rBn != null) {
                fQ += f.a.a.b.b.a.h(11, this.rBn);
            }
            if (this.bGy != null) {
                fQ += f.a.a.b.b.a.h(12, this.bGy);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rBc) {
                return 0;
            }
            throw new b("Not all required fields were included: sourceType");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            vz vzVar = (vz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vzVar.bJt = aVar3.vHC.rY();
                    vzVar.rBc = true;
                    return 0;
                case 2:
                    vzVar.bSS = aVar3.vHC.readString();
                    vzVar.rBd = true;
                    return 0;
                case 3:
                    vzVar.toUser = aVar3.vHC.readString();
                    vzVar.rBe = true;
                    return 0;
                case 4:
                    vzVar.rBf = aVar3.vHC.readString();
                    vzVar.rBg = true;
                    return 0;
                case 5:
                    vzVar.rBh = aVar3.vHC.readString();
                    vzVar.rBi = true;
                    return 0;
                case 6:
                    vzVar.createTime = aVar3.vHC.rZ();
                    vzVar.dUe = true;
                    return 0;
                case 7:
                    vzVar.bWQ = aVar3.vHC.readString();
                    vzVar.rBj = true;
                    return 0;
                case 8:
                    vzVar.cca = aVar3.vHC.readString();
                    vzVar.rBk = true;
                    return 0;
                case 9:
                    vzVar.appId = aVar3.vHC.readString();
                    vzVar.rBl = true;
                    return 0;
                case 10:
                    vzVar.egr = aVar3.vHC.readString();
                    vzVar.rBm = true;
                    return 0;
                case 11:
                    vzVar.rBn = aVar3.vHC.readString();
                    vzVar.rBo = true;
                    return 0;
                case 12:
                    vzVar.bGy = aVar3.vHC.readString();
                    vzVar.rBp = true;
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
