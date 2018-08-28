package com.tencent.mm.ui.widget.picker;

public final class f {
    public static boolean GE(int i) {
        return i >= 0 && i <= 59;
    }

    public static boolean GF(int i) {
        return i >= 0 && i <= 23;
    }

    public static int[] abB(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String[] split = str.split(":");
        if (split == null || split.length != 2) {
            return null;
        }
        int abC = abC(split[0]);
        int abC2 = abC(split[1]);
        if (!GF(abC) || !GE(abC2)) {
            return null;
        }
        return new int[]{abC, abC2};
    }

    private static int abC(String str) {
        try {
            return Integer.parseInt(str, 10);
        } catch (Exception e) {
            return -1;
        }
    }
}
