package com.google.android.gms.tagmanager;

import java.util.Arrays;

final class c$a {
    public final String aXv;
    public final Object bbv;

    c$a(String str, Object obj) {
        this.aXv = str;
        this.bbv = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c$a)) {
            return false;
        }
        c$a c_a = (c$a) obj;
        return this.aXv.equals(c_a.aXv) && this.bbv.equals(c_a.bbv);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Integer[]{Integer.valueOf(this.aXv.hashCode()), Integer.valueOf(this.bbv.hashCode())});
    }

    public final String toString() {
        return "Key: " + this.aXv + " value: " + this.bbv.toString();
    }
}
