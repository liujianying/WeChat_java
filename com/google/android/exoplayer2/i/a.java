package com.google.android.exoplayer2.i;

public final class a {
    public static void ao(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int av(int i, int i2) {
        if (i >= 0 && i < i2) {
            return i;
        }
        throw new IndexOutOfBoundsException();
    }

    public static void ap(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void c(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static <T> T Z(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
