package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class t extends a {
    public int vJr;

    public t() {
        this.vJr = 0;
        this.vIl = 282;
    }

    public final Boolean cKf() {
        if (this.vIV < 5) {
            return Boolean.valueOf(false);
        }
        int ab = util.ab(this.vIf, ((this.vIU + 2) + 1) + 1);
        if (this.vIV < ab + 5) {
            return Boolean.valueOf(false);
        }
        this.vJr = ab;
        return Boolean.valueOf(true);
    }
}
