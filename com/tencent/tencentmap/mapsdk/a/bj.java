package com.tencent.tencentmap.mapsdk.a;

public class bj extends RuntimeException {
    int a;

    public bj(int i) {
        super("server error code :" + i);
        this.a = i;
    }

    public bj(String str) {
        super(str);
    }

    public bj(String str, Throwable th) {
        super(str, th);
    }

    public static bj a(int i, String str) {
        if (i == -1) {
            return new bo(i);
        }
        if (i == -2) {
            return new bp(i);
        }
        if (i == -3) {
            return new bq(i);
        }
        if (i == -4) {
            return new br(i);
        }
        if (i == -6) {
            return new bs(i);
        }
        if (i == -5) {
            return new bt(i);
        }
        return new bu(i);
    }

    public static bj a(int i) {
        return a(i, "");
    }
}
