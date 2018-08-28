package com.google.android.exoplayer2.g;

import android.text.TextUtils;

final class b$a {
    public final int aeg;
    public final String mimeType;
    public final int sampleRate;

    public b$a(int i, int i2, String str) {
        this.aeg = i;
        this.sampleRate = i2;
        this.mimeType = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b$a b_a = (b$a) obj;
        if (this.aeg == b_a.aeg && this.sampleRate == b_a.sampleRate && TextUtils.equals(this.mimeType, b_a.mimeType)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.mimeType != null ? this.mimeType.hashCode() : 0) + (((this.aeg * 31) + this.sampleRate) * 31);
    }
}
