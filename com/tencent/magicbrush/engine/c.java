package com.tencent.magicbrush.engine;

import android.graphics.Bitmap;
import android.os.Environment;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;

public final class c {
    public static String bnC = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String bnD = "/tencent/MicroMsg/AppBrandGame";
    public static String bnE = (bnC + bnD);

    public static void b(String str, Bitmap bitmap) {
        MBNativeHandlerJNI.nativeOnImageDecoded(str, bitmap);
    }

    public static MBCanvasContentHolder tc() {
        return MBNativeHandlerJNI.nativeCaptureScreenshot();
    }

    public static MBCanvasContentHolder ek(int i) {
        return MBNativeHandlerJNI.nativeCaptureCanvasSnapshot(i);
    }

    public static void aC(boolean z) {
        MBNativeHandlerJNI.nativeSetV8Debug(z);
    }
}
