package com.tencent.mm.loader.stub;

import android.os.Build.VERSION;

public class BaseBuildInfo {
    public static String BUILD_TAG = "MicroMessenger_Android_GIT_RELEASE_GRADLE #6878";
    public static String CLIENT_VERSION = "0x26060736";
    public static String COMMAND = "null";
    public static String DEVICE_TYPE = ("android-" + VERSION.SDK_INT);
    public static boolean ENABLE_STETHO = false;
    public static boolean EX_DEVICE_LOGIN = false;
    public static String HOSTNAME = "45ea8765cf33";
    public static String OWNER = "amm_code_helper";
    public static String PATCH_ENABLED = "true";
    public static String PATCH_REV = null;
    public static int PATCH_TINKER_FLAG = 7;
    public static boolean REDESIGN_ENTRANCE = false;
    public static String REV = "f6b4b06b7ce8bc23015c8c8704a7aaf7d858dfb6";
    public static String SVNPATH = "origin/RB-2018-APR@git";
    public static String TIME = "2018-05-31 14:12:58";

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
