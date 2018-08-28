package com.google.a.a;

public final class g {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int[] bfQ = new int[0];
    public static final long[] bfR = new long[0];
    public static final float[] bfS = new float[0];
    public static final double[] bfT = new double[0];
    public static final boolean[] bfU = new boolean[0];
    public static final byte[][] bfV = new byte[0][];
    public static final byte[] bfW = new byte[0];

    static int ef(int i) {
        return i & 7;
    }

    public static int eg(int i) {
        return i >>> 3;
    }

    static int aJ(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean a(a aVar, int i) {
        return aVar.dU(i);
    }

    public static final int b(a aVar, int i) {
        int i2 = 1;
        int position = aVar.getPosition();
        aVar.dU(i);
        while (aVar.rX() == i) {
            aVar.dU(i);
            i2++;
        }
        aVar.dX(position);
        return i2;
    }
}
