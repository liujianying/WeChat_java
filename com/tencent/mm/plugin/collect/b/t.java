package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.bk.a;
import f.a.a.b;

public class t extends a {
    public String bJg;
    public String bOe;
    public String daA;
    public double hUL;
    public String hUM;
    public int msgType;
    public int scene;
    public int status;
    public int timestamp;
    public String type;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.bOe == null) {
                throw new b("Not all required fields were included: transactionId");
            } else if (this.bJg == null) {
                throw new b("Not all required fields were included: feeType");
            } else {
                if (this.username != null) {
                    aVar.g(1, this.username);
                }
                if (this.bOe != null) {
                    aVar.g(2, this.bOe);
                }
                aVar.c(3, this.hUL);
                if (this.bJg != null) {
                    aVar.g(4, this.bJg);
                }
                aVar.fT(5, this.timestamp);
                aVar.fT(6, this.scene);
                aVar.fT(7, this.status);
                if (this.daA != null) {
                    aVar.g(8, this.daA);
                }
                if (this.hUM != null) {
                    aVar.g(9, this.hUM);
                }
                aVar.fT(10, this.msgType);
                if (this.type == null) {
                    return 0;
                }
                aVar.g(11, this.type);
                return 0;
            }
        } else if (i == 1) {
            if (this.username != null) {
                h = f.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            if (this.bOe != null) {
                h += f.a.a.b.b.a.h(2, this.bOe);
            }
            h += f.a.a.b.b.a.ec(3) + 8;
            if (this.bJg != null) {
                h += f.a.a.b.b.a.h(4, this.bJg);
            }
            h = ((h + f.a.a.a.fQ(5, this.timestamp)) + f.a.a.a.fQ(6, this.scene)) + f.a.a.a.fQ(7, this.status);
            if (this.daA != null) {
                h += f.a.a.b.b.a.h(8, this.daA);
            }
            if (this.hUM != null) {
                h += f.a.a.b.b.a.h(9, this.hUM);
            }
            h += f.a.a.a.fQ(10, this.msgType);
            if (this.type != null) {
                h += f.a.a.b.b.a.h(11, this.type);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            } else if (this.bOe == null) {
                throw new b("Not all required fields were included: transactionId");
            } else if (this.bJg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: feeType");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.username = aVar3.vHC.readString();
                    return 0;
                case 2:
                    tVar.bOe = aVar3.vHC.readString();
                    return 0;
                case 3:
                    tVar.hUL = aVar3.vHC.readDouble();
                    return 0;
                case 4:
                    tVar.bJg = aVar3.vHC.readString();
                    return 0;
                case 5:
                    tVar.timestamp = aVar3.vHC.rY();
                    return 0;
                case 6:
                    tVar.scene = aVar3.vHC.rY();
                    return 0;
                case 7:
                    tVar.status = aVar3.vHC.rY();
                    return 0;
                case 8:
                    tVar.daA = aVar3.vHC.readString();
                    return 0;
                case 9:
                    tVar.hUM = aVar3.vHC.readString();
                    return 0;
                case 10:
                    tVar.msgType = aVar3.vHC.rY();
                    return 0;
                case 11:
                    tVar.type = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
