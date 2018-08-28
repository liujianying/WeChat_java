package com.google.android.gms.c;

public final class bh {
    public static final int[] bal = new int[0];
    public static final long[] bam = new long[0];
    public static final float[] ban = new float[0];
    public static final double[] bao = new double[0];
    public static final boolean[] bap = new boolean[0];
    public static final String[] baq = new String[0];
    public static final byte[][] bar = new byte[0][];
    public static final byte[] bas = new byte[0];

    static int aC(int i, int i2) {
        return (i << 3) | i2;
    }

    public static final int b(aw awVar, int i) {
        int i2 = 1;
        int position = awVar.getPosition();
        awVar.dA(i);
        while (awVar.qw() == i) {
            awVar.dA(i);
            i2++;
        }
        awVar.dD(position);
        return i2;
    }

    static int dO(int i) {
        return i & 7;
    }

    public static int dP(int i) {
        return i >>> 3;
    }
}
