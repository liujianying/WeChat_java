package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ai extends a {
    public int vJD;
    public int vJE;
    public int vJF;

    public ai() {
        this.vJD = 0;
        this.vJE = 0;
        this.vJF = 0;
        this.vIl = 326;
    }

    public final Boolean cKf() {
        if (this.vIV < 12) {
            return Boolean.valueOf(false);
        }
        int ac = util.ac(this.vIf, this.vIU + 4);
        if (this.vIV < ac + 12) {
            return Boolean.valueOf(false);
        }
        this.vJD = ac;
        ac = util.ac(this.vIf, (this.vIU + 6) + this.vJD);
        if (this.vIV < (this.vJD + 12) + ac) {
            return Boolean.valueOf(false);
        }
        this.vJE = ac;
        ac = util.ac(this.vIf, ((this.vIU + 10) + this.vJD) + this.vJE);
        if (this.vIV < ((this.vJD + 12) + this.vJE) + ac) {
            return Boolean.valueOf(false);
        }
        this.vJF = ac;
        return Boolean.valueOf(true);
    }
}
