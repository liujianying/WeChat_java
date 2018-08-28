package com.tencent.matrix.resource.c.a;

import java.util.Arrays;

public final class b {
    public final byte[] bsd;

    public b(byte[] bArr) {
        int length = bArr.length;
        this.bsd = new byte[length];
        System.arraycopy(bArr, 0, this.bsd, 0, length);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return Arrays.equals(this.bsd, ((b) obj).bsd);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.bsd);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        for (byte b : this.bsd) {
            stringBuilder.append(Integer.toHexString(b & 255));
        }
        return stringBuilder.toString();
    }
}
