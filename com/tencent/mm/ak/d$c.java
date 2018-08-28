package com.tencent.mm.ak;

class d$c {
    d$a dTI;
    Object dTJ;

    public d$c(d$a d_a, Object obj) {
        this.dTI = d_a;
        this.dTJ = obj;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d$c)) {
            return false;
        }
        if (this.dTI == ((d$c) obj).dTI) {
            return true;
        }
        return false;
    }
}
