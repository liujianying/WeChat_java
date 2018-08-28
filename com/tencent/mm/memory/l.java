package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l {
    private static j dvd = new j();
    private static m dve = new m();
    private static int dvf = -1;

    public abstract Bitmap a(String str, Options options, DecodeResultLogger decodeResultLogger);

    public abstract Bitmap a(String str, Rect rect, Options options, DecodeResultLogger decodeResultLogger);

    public abstract void l(Bitmap bitmap);

    public static l Fu() {
        if (dvf == -1) {
            if (Fv()) {
                dvf = 1;
            } else {
                dvf = 2;
            }
        }
        switch (dvf) {
            case 1:
                return dvd;
            case 2:
                return dve;
            default:
                return dve;
        }
    }

    public static boolean Fv() {
        boolean fR = d.fR(19);
        boolean cje = bi.cje();
        x.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", new Object[]{Boolean.valueOf(fR), Boolean.valueOf(cje), Boolean.valueOf(fR)});
        return fR;
    }

    protected static void i(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            if (inputStream instanceof FileInputStream) {
                inputStream = new i((FileInputStream) inputStream);
            } else {
                inputStream = new BufferedInputStream(inputStream, 65536);
            }
        }
        try {
            inputStream.reset();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PlatformBitmapFactory", e, "reset stream error: %s", new Object[]{e.getMessage()});
        }
    }
}
