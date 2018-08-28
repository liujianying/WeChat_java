package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ad extends a {
    public int vJx;

    public ad() {
        this.vJx = 0;
        this.vIl = 312;
    }

    public final Boolean cKf() {
        if (this.vIV < 4) {
            return Boolean.valueOf(false);
        }
        this.vJx = util.ad(this.vIf, this.vIU);
        if (this.vIV < (this.vJx * 10) + 4) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public final int cKh() {
        for (int i = 0; i < this.vJx; i++) {
            if (util.ac(this.vIf, (this.vIU + 4) + (i * 10)) == 266) {
                return util.ad(this.vIf, ((i * 10) + (this.vIU + 4)) + 2);
            }
        }
        return 0;
    }
}
