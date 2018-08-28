package com.tencent.mm.loader.stub;

import android.os.Build.VERSION;

public final class a {
    public static String BUILD_TAG;
    public static String CLIENT_VERSION;
    public static String COMMAND;
    public static boolean DEBUG = false;
    public static String DEVICE_TYPE = ("android-" + VERSION.SDK_INT);
    public static boolean ENABLE_STETHO = false;
    public static boolean EX_DEVICE_LOGIN = false;
    public static String HOSTNAME;
    public static String OWNER;
    public static String PATCH_ENABLED;
    public static String PATCH_REV;
    public static int PATCH_TINKER_FLAG;
    public static String REV;
    public static String SVNPATH;
    public static String TIME;
    public static boolean duK = false;
    public static Boolean duL = Boolean.valueOf(false);

    public static String codeRevision() {
        return PATCH_REV == null ? REV : REV + "." + PATCH_REV;
    }

    public static String baseRevision() {
        return REV;
    }

    public static boolean patchEnabled() {
        return !"false".equalsIgnoreCase(PATCH_ENABLED);
    }
}
