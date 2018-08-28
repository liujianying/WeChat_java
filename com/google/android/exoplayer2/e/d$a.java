package com.google.android.exoplayer2.e;

import android.text.TextUtils;

final class d$a {
    public final boolean apr;
    public final String mimeType;

    public d$a(String str, boolean z) {
        this.mimeType = str;
        this.apr = z;
    }

    public final int hashCode() {
        return (this.apr ? 1231 : 1237) + (((this.mimeType == null ? 0 : this.mimeType.hashCode()) + 31) * 31);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != d$a.class) {
            return false;
        }
        d$a d_a = (d$a) obj;
        if (TextUtils.equals(this.mimeType, d_a.mimeType) && this.apr == d_a.apr) {
            return true;
        }
        return false;
    }
}
