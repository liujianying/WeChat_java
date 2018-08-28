package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class g extends a {
    public int vJf;
    public int vJg;
    public int vJh;
    public int vJi;

    public g() {
        this.vJf = 0;
        this.vJg = 0;
        this.vJh = 0;
        this.vJi = 0;
        this.vIl = 261;
    }

    public final Boolean cKf() {
        if (this.vIV < 2) {
            return Boolean.valueOf(false);
        }
        this.vJg = util.ac(this.vIf, this.vIU);
        if (this.vIV < (this.vJg + 2) + 2) {
            return Boolean.valueOf(false);
        }
        this.vJf = util.ac(this.vIf, (this.vIU + 2) + this.vJg);
        if (this.vIV < ((this.vJg + 2) + 2) + this.vJf) {
            return Boolean.valueOf(false);
        }
        this.vJi = this.vIU + 2;
        this.vJh = ((this.vJg + 2) + 2) + this.vIU;
        return Boolean.valueOf(true);
    }
}
