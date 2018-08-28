package com.qq.wx.voice.vad;

public final class a {
    public static boolean DEBUG = false;
    public static boolean bgy = false;
    public long bgv = 0;
    public EVadNative bgw = new EVadNative();
    public MMVoipVadNative bgx = new MMVoipVadNative();

    public static void ay(boolean z) {
        bgy = z;
        if (z) {
            System.loadLibrary("MMVoipVadEmbed");
            if (DEBUG) {
                System.out.println("EVad loadLib MMVoipVadEmbed");
                return;
            }
            return;
        }
        System.loadLibrary("EVadEmbed");
        if (DEBUG) {
            System.out.println("EVad loadLib EVadEmbed");
        }
    }
}
