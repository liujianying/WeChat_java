package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ab extends a {
    public int vJw;

    public ab() {
        this.vJw = 0;
        this.vIl = 306;
    }

    public final Boolean cKf() {
        if (this.vIV < 2) {
            return Boolean.valueOf(false);
        }
        this.vJw = util.ac(this.vIf, this.vIU);
        if (this.vJw + 2 > this.vIV) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }
}
