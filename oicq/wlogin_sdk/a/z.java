package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class z extends a {
    public int vJt;
    public int vJu;

    public z() {
        this.vJt = 0;
        this.vJu = 0;
        this.vIl = 293;
    }

    public final Boolean cKf() {
        if (this.vIV < 2) {
            return Boolean.valueOf(false);
        }
        this.vJt = util.ac(this.vIf, this.vIU);
        if (this.vIV < (this.vJt + 2) + 2) {
            return Boolean.valueOf(false);
        }
        this.vJu = util.ac(this.vIf, (this.vIU + 2) + this.vJt);
        return Boolean.valueOf(true);
    }
}
