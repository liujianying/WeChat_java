package com.google.android.gms.c;

import android.os.Binder;

public abstract class j<T> {
    private static final Object aEv = new Object();
    static a aXs = null;
    private static int aXt = 0;
    private static String aXu = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private T aIk = null;
    protected final String aXv;
    protected final T aXw;

    protected j(String str, T t) {
        this.aXv = str;
        this.aXw = t;
    }

    public static j<Float> a(String str, Float f) {
        return new 4(str, f);
    }

    public static j<Integer> a(String str, Integer num) {
        return new j<Integer>(str, num) {
            protected final /* synthetic */ Object pW() {
                return j.aXs.qa();
            }
        };
    }

    public static j<Long> a(String str, Long l) {
        return new 2(str, l);
    }

    public static boolean isInitialized() {
        return aXs != null;
    }

    public static j<Boolean> j(String str, boolean z) {
        return new j<Boolean>(str, Boolean.valueOf(z)) {
            protected final /* synthetic */ Object pW() {
                return j.aXs.pY();
            }
        };
    }

    public static j<String> o(String str, String str2) {
        return new 5(str, str2);
    }

    public static int pV() {
        return aXt;
    }

    public final T get() {
        return this.aIk != null ? this.aIk : pW();
    }

    protected abstract T pW();

    public final T pX() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            T t = get();
            return t;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
