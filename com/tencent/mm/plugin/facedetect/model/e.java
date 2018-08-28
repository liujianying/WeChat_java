package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.model.at;

public final class e {
    private static long iNr = -1;
    private static long iNs = -1;
    private static float iNt = -1.0f;

    public static void df(long j) {
        iNr = j;
    }

    public static boolean aJE() {
        return Boolean.parseBoolean(at.dBv.I("last_login_face_use_debug_mode", "false"));
    }

    public static boolean aJF() {
        return Boolean.parseBoolean(at.dBv.I("last_login_face_is_force_upload_face", "false"));
    }

    public static boolean aJG() {
        return Boolean.parseBoolean(at.dBv.I("last_login_face_save_correct_debug_mode", "false"));
    }

    public static boolean aJH() {
        return Boolean.parseBoolean(at.dBv.I("last_login_face_save_final_debug_mode", "false"));
    }

    public static boolean aJI() {
        return Boolean.parseBoolean(at.dBv.I("last_login_face_save_lip_reading", "false"));
    }

    public static boolean aJJ() {
        return Boolean.parseBoolean(at.dBv.I("last_login_face_save_final_voice", "false"));
    }

    public static void eD(boolean z) {
        at.dBv.T("last_login_face_use_debug_mode", String.valueOf(z));
    }

    public static void eE(boolean z) {
        at.dBv.T("last_login_face_save_correct_debug_mode", String.valueOf(z));
    }

    public static void eF(boolean z) {
        at.dBv.T("last_login_face_save_final_debug_mode", String.valueOf(z));
    }

    public static void eG(boolean z) {
        at.dBv.T("last_login_face_save_lip_reading", String.valueOf(z));
    }

    public static void eH(boolean z) {
        at.dBv.T("last_login_face_save_final_voice", String.valueOf(z));
    }

    public static void eI(boolean z) {
        at.dBv.T("last_login_face_is_force_upload_face", String.valueOf(z));
    }
}
