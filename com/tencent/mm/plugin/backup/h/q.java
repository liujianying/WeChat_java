package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;

public final class q extends a {
    public String hbQ;
    public String hck;
    public String hcl;
    public String hcm;
    public String hcn;
    public long hco;
    public long hcp;
    public String hcq;
    public String hcr;
    public b hcs;
    public b hct;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hck == null) {
                throw new f.a.a.b("Not all required fields were included: WeChatVersion");
            } else if (this.hcl == null) {
                throw new f.a.a.b("Not all required fields were included: WeChatUserID");
            } else if (this.hcm == null) {
                throw new f.a.a.b("Not all required fields were included: WeChatNickName");
            } else if (this.hcn == null) {
                throw new f.a.a.b("Not all required fields were included: WeChatInstallDir");
            } else if (this.hcq == null) {
                throw new f.a.a.b("Not all required fields were included: Manufacturer");
            } else if (this.hbQ == null) {
                throw new f.a.a.b("Not all required fields were included: Model");
            } else if (this.hcr == null) {
                throw new f.a.a.b("Not all required fields were included: Version");
            } else {
                if (this.hck != null) {
                    aVar.g(1, this.hck);
                }
                if (this.hcl != null) {
                    aVar.g(2, this.hcl);
                }
                if (this.hcm != null) {
                    aVar.g(3, this.hcm);
                }
                if (this.hcn != null) {
                    aVar.g(4, this.hcn);
                }
                aVar.T(5, this.hco);
                aVar.T(6, this.hcp);
                if (this.hcq != null) {
                    aVar.g(7, this.hcq);
                }
                if (this.hbQ != null) {
                    aVar.g(8, this.hbQ);
                }
                if (this.hcr != null) {
                    aVar.g(9, this.hcr);
                }
                if (this.hcs != null) {
                    aVar.b(10, this.hcs);
                }
                if (this.hct == null) {
                    return 0;
                }
                aVar.b(11, this.hct);
                return 0;
            }
        } else if (i == 1) {
            if (this.hck != null) {
                h = f.a.a.b.b.a.h(1, this.hck) + 0;
            } else {
                h = 0;
            }
            if (this.hcl != null) {
                h += f.a.a.b.b.a.h(2, this.hcl);
            }
            if (this.hcm != null) {
                h += f.a.a.b.b.a.h(3, this.hcm);
            }
            if (this.hcn != null) {
                h += f.a.a.b.b.a.h(4, this.hcn);
            }
            h = (h + f.a.a.a.S(5, this.hco)) + f.a.a.a.S(6, this.hcp);
            if (this.hcq != null) {
                h += f.a.a.b.b.a.h(7, this.hcq);
            }
            if (this.hbQ != null) {
                h += f.a.a.b.b.a.h(8, this.hbQ);
            }
            if (this.hcr != null) {
                h += f.a.a.b.b.a.h(9, this.hcr);
            }
            if (this.hcs != null) {
                h += f.a.a.a.a(10, this.hcs);
            }
            if (this.hct != null) {
                h += f.a.a.a.a(11, this.hct);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.hck == null) {
                throw new f.a.a.b("Not all required fields were included: WeChatVersion");
            } else if (this.hcl == null) {
                throw new f.a.a.b("Not all required fields were included: WeChatUserID");
            } else if (this.hcm == null) {
                throw new f.a.a.b("Not all required fields were included: WeChatNickName");
            } else if (this.hcn == null) {
                throw new f.a.a.b("Not all required fields were included: WeChatInstallDir");
            } else if (this.hcq == null) {
                throw new f.a.a.b("Not all required fields were included: Manufacturer");
            } else if (this.hbQ == null) {
                throw new f.a.a.b("Not all required fields were included: Model");
            } else if (this.hcr != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: Version");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.hck = aVar3.vHC.readString();
                    return 0;
                case 2:
                    qVar.hcl = aVar3.vHC.readString();
                    return 0;
                case 3:
                    qVar.hcm = aVar3.vHC.readString();
                    return 0;
                case 4:
                    qVar.hcn = aVar3.vHC.readString();
                    return 0;
                case 5:
                    qVar.hco = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    qVar.hcp = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    qVar.hcq = aVar3.vHC.readString();
                    return 0;
                case 8:
                    qVar.hbQ = aVar3.vHC.readString();
                    return 0;
                case 9:
                    qVar.hcr = aVar3.vHC.readString();
                    return 0;
                case 10:
                    qVar.hcs = aVar3.cJR();
                    return 0;
                case 11:
                    qVar.hct = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
