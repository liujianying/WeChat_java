package com.tencent.mm.plugin.appbrand.game.b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import com.tencent.magicbrush.a.a$a;
import com.tencent.mm.plugin.appbrand.game.c.d;
import com.tencent.mm.plugin.appbrand.game.c.d.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

final class b$e implements a$a {
    private final int fAU;
    private final int fAV;

    private b$e() {
        this.fAU = 2048;
        this.fAV = 2048;
    }

    public /* synthetic */ b$e(byte b) {
        this();
    }

    @SuppressLint({"DefaultLocale"})
    public final Bitmap a(String str, InputStream inputStream) {
        if (inputStream != null) {
            try {
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                Options a = c.a(inputStream, decodeResultLogger, false);
                if (decodeResultLogger.getDecodeResult() != 0) {
                    x.e("MicroMsg.MBImageHandlerRegistry", "hy: get bitmap options error!! path: %s, errorcode: %d, is native: %b", new Object[]{str, Integer.valueOf(decodeResultLogger.getDecodeResult()), Boolean.valueOf(decodeResultLogger.isDecodeByMMDecoder())});
                    a(str, decodeResultLogger);
                    bi.d(inputStream);
                    return null;
                }
                x.d("MicroMsg.MBImageHandlerRegistry", "hy: %s out mime type: %s, width: %d, height: %d", new Object[]{str, a.outMimeType, Integer.valueOf(a.outWidth), Integer.valueOf(a.outHeight)});
                if (a.outWidth > 2048 || r2 > 2048) {
                    x.w("MicroMsg.MBImageHandlerRegistry", "hy: size exceed the limit!!");
                    j(str, a.fBx, String.format(ad.getContext().getString(j.appbrand_game_image_size_exceed), new Object[]{Integer.valueOf(2048), Integer.valueOf(2048), Integer.valueOf(r1), Integer.valueOf(r2)}));
                    II(3);
                    bi.d(inputStream);
                    return null;
                }
                Options options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream, null, options, decodeResultLogger, 0, new int[0]);
                x.i("MicroMsg.MBImageHandlerRegistry", "hy: %s decoderesult is %s", new Object[]{str, decodeResultLogger.toLogString()});
                if (decodeStream == null) {
                    x.e("MicroMsg.MBImageHandlerRegistry", "hy: decode error!!path: %s errorcode: %d, is native: %b", new Object[]{str, Integer.valueOf(decodeResultLogger.getDecodeResult()), Boolean.valueOf(decodeResultLogger.isDecodeByMMDecoder())});
                    a(str, decodeResultLogger);
                } else if (decodeStream.getConfig() != Config.ARGB_8888) {
                    Bitmap createBitmap = Bitmap.createBitmap(decodeStream.getWidth(), decodeStream.getHeight(), Config.ARGB_8888);
                    new Canvas(createBitmap).drawBitmap(decodeStream, 0.0f, 0.0f, null);
                    decodeStream.recycle();
                    decodeStream = createBitmap;
                }
                bi.d(inputStream);
                return decodeStream;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MBImageHandlerRegistry", e, "hy: decode out of memory in %s", new Object[]{str});
                j(str, a.fBx, ad.getContext().getString(j.appbrand_game_image_decode_resource_error_out_of_memory));
                II(1);
                bi.d(inputStream);
                return null;
            } catch (Throwable e2) {
                bi.d(inputStream);
                throw e2;
            }
        }
        x.w("MicroMsg.MBImageHandlerRegistry", "hy: input steam is null! regard as not found file: %s", new Object[]{str});
        j(str, a.fBx, ad.getContext().getString(j.appbrand_game_image_load_error));
        II(7);
        return null;
    }

    private static void a(String str, DecodeResultLogger decodeResultLogger) {
        String format = String.format(ad.getContext().getString(j.appbrand_game_image_decode_resource_error), new Object[]{Integer.valueOf(decodeResultLogger.getDecodeResult())});
        if (decodeResultLogger.getDecodeResult() == 1006) {
            format = format + ad.getContext().getString(j.appbrand_game_image_decode_resource_error_format);
            II(0);
        } else if (decodeResultLogger.getDecodeResult() == 1005) {
            format = format + ad.getContext().getString(j.appbrand_game_image_decode_resource_error_io);
            II(4);
        } else if (decodeResultLogger.getDecodeResult() >= 2000) {
            format = format + ad.getContext().getString(j.appbrand_game_image_decode_resource_error_content);
            II(2);
        } else {
            format = format + ad.getContext().getString(j.appbrand_game_image_decode_resource_error_unknown);
            II(6);
        }
        j(str, a.fBx, format);
    }

    private static void j(String str, int i, String str2) {
        int i2 = 0;
        d ags = d.ags();
        String str3 = str + ": " + str2;
        if (i == 0 || bi.oW(str3)) {
            x.e("MicroMsg.GameInspector", "hy: not valid console!");
            return;
        }
        switch (d$2.fBt[i - 1]) {
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                i2 = 3;
                break;
        }
        ags.G(i2, str3);
    }

    private static void II(int i) {
        h.mEJ.e(807, (long) i, 1);
    }
}
