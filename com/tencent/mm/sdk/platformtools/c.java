package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.a.b;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.vfs.d;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private static DisplayMetrics ewi = null;
    public static boolean sFw;

    public static Options a(InputStream inputStream, DecodeResultLogger decodeResultLogger, boolean z) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        c(options);
        if (inputStream == null) {
            x.e("MicroMsg.BitmapUtil", "getImageOptions decode stream is null!!");
        } else {
            InputStream inputStream2;
            if (z) {
                inputStream2 = inputStream;
            } else {
                if (!inputStream.markSupported()) {
                    if (inputStream instanceof FileInputStream) {
                        inputStream = new i((FileInputStream) inputStream);
                    } else {
                        inputStream = new BufferedInputStream(inputStream);
                    }
                }
                inputStream.mark(8388608);
                inputStream2 = inputStream;
            }
            try {
                Bitmap decodeStream = MMBitmapFactory.decodeStream(inputStream2, null, options, decodeResultLogger, 0, new int[0]);
                if (decodeStream != null) {
                    x.i("MicroMsg.BitmapUtil", "getImageOptions bitmap recycle. %s", decodeStream);
                    decodeStream.recycle();
                }
                if (z) {
                    try {
                        inputStream2.close();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.BitmapUtil", e, "hy: stream close failed ", new Object[0]);
                    }
                } else {
                    x.w("MicroMsg.BitmapUtil", "hy: not auto close. reset for invoker");
                    try {
                        inputStream2.reset();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.BitmapUtil", e2, "hy: stream reset failed", new Object[0]);
                    }
                }
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.BitmapUtil", e3, "Decode bitmap failed.", new Object[0]);
                if (z) {
                    try {
                        inputStream2.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.BitmapUtil", e22, "hy: stream close failed ", new Object[0]);
                    }
                } else {
                    x.w("MicroMsg.BitmapUtil", "hy: not auto close. reset for invoker");
                    try {
                        inputStream2.reset();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.BitmapUtil", e222, "hy: stream reset failed", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                if (z) {
                    try {
                        inputStream2.close();
                    } catch (Throwable e2222) {
                        x.printErrStackTrace("MicroMsg.BitmapUtil", e2222, "hy: stream close failed ", new Object[0]);
                    }
                } else {
                    x.w("MicroMsg.BitmapUtil", "hy: not auto close. reset for invoker");
                    try {
                        inputStream2.reset();
                    } catch (Throwable e22222) {
                        x.printErrStackTrace("MicroMsg.BitmapUtil", e22222, "hy: stream reset failed", new Object[0]);
                    }
                }
            }
        }
        return options;
    }

    public static Options VZ(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.BitmapUtil", "getImageOptions invalid path");
            return null;
        }
        try {
            return a(d.openRead(str), null, true);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BitmapUtil", e, "Decode bitmap failed.", new Object[0]);
            return new Options();
        }
    }

    public static Bitmap ah(int i, int i2, int i3) {
        Bitmap createBitmap = createBitmap(i2, i3, Config.ARGB_8888, false);
        new Canvas(createBitmap).drawColor(i);
        return createBitmap;
    }

    public static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, String str3) {
        return b(str, i, i2, compressFormat, i3, str2 + str3);
    }

    public static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        return b(str, i, i2, compressFormat, i3, str2);
    }

    public static int ai(int i, int i2, int i3) {
        int i4 = 1;
        if (i > 144 || i2 > i3) {
            if (i2 > i) {
                i4 = Math.round((((float) i) / 144.0f) + 0.5f);
            } else {
                i4 = Math.round((((float) i2) / ((float) i3)) + 0.5f);
            }
            while (((float) (i2 * i)) / ((float) (i4 * i4)) > ((float) ((i3 * 144) * 2))) {
                i4++;
            }
        }
        return i4;
    }

    public static Point Wa(String str) {
        Options VZ = VZ(str);
        if (VZ != null) {
            return new Point(VZ.outWidth, VZ.outHeight);
        }
        return null;
    }

    private static boolean b(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        return a(str, i, i2, compressFormat, i3, str2, false, new PInt(), new PInt());
    }

    public static boolean c(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        return a(str, i, i2, compressFormat, i3, str2, true, new PInt(), new PInt());
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, boolean z, PInt pInt, PInt pInt2) {
        return a(str, i, i2, compressFormat, i3, str2, z, pInt, pInt2, false);
    }

    public static boolean a(String str, int i, int i2, CompressFormat compressFormat, String str2, PInt pInt, PInt pInt2) {
        return a(str, i, i2, compressFormat, 80, str2, true, pInt, pInt2, true);
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, boolean z, PInt pInt, PInt pInt2, boolean z2) {
        Bitmap e = e(str, i, i2, z2);
        if (e == null) {
            return false;
        }
        Bitmap b;
        if (z) {
            int i4 = 0;
            Exif exif = new Exif();
            try {
                x.e("EXIFTEST", "parseFromFile ret = " + exif.parseFromFile(str));
                i4 = exif.getOrientationInDegree();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.BitmapUtil", e2, "Can't read EXIF from " + str, new Object[0]);
            }
            b = b(e, (float) i4);
        } else {
            b = e;
        }
        try {
            pInt.value = b.getWidth();
            pInt2.value = b.getHeight();
            a(b, i3, compressFormat, str2, true);
            return true;
        } catch (IOException e3) {
            x.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: " + str2);
            return false;
        }
    }

    public static int a(boolean z, String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, b bVar) {
        int i4 = false;
        Bitmap a = a(str, i, i2, (boolean) i4, null, i4);
        if (a == null) {
            return -1;
        }
        Exif exif = new Exif();
        try {
            x.e("EXIFTEST", "parseFromFile ret = " + exif.parseFromFile(str));
            i4 = exif.getOrientationInDegree();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BitmapUtil", e, "Can't read EXIF from " + str, new Object[i4]);
        }
        a = b(a, (float) i4);
        if (bVar != null) {
            bVar.tZ();
        }
        if (z) {
            try {
                x.i("MicroMsg.BitmapUtil", "dkimgopt compressByQualityOptim ret:%d  [%d,%d,%d] path:%s", Integer.valueOf(n.a(a, i3, str2)), Integer.valueOf(i3), Integer.valueOf(a.getWidth()), Integer.valueOf(a.getHeight()), str2);
                return n.a(a, i3, str2);
            } catch (IOException e2) {
                x.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: " + str2);
                return -2;
            }
        }
        a(a, i3, compressFormat, str2, true);
        return 1;
    }

    public static Bitmap ai(String str, int i, int i2) {
        return j(str, i, i2, 1);
    }

    public static Bitmap j(String str, int i, int i2, int i3) {
        Bitmap a = a(str, i, i2, false, null, i3);
        if (a == null) {
            return null;
        }
        int orientationInDegree;
        Exif exif = new Exif();
        try {
            x.e("EXIFTEST", "parseFromFile ret = " + exif.parseFromFile(str));
            orientationInDegree = exif.getOrientationInDegree();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BitmapUtil", e, "Can't read EXIF from " + str, new Object[0]);
            orientationInDegree = 0;
        }
        x.d("MicroMsg.BitmapUtil", "degress:%d", Integer.valueOf(orientationInDegree));
        return b(a, (float) orientationInDegree);
    }

    public static boolean b(String str, int i, int i2, CompressFormat compressFormat, String str2, PInt pInt, PInt pInt2) {
        if (bi.oW(str)) {
            x.w("MicroMsg.BitmapUtil", "file path is null.");
            return false;
        } else if (d.cn(str)) {
            int orientationInDegree;
            Bitmap b;
            Exif exif = new Exif();
            try {
                x.e("EXIFTEST", "parseFromFile ret = " + exif.parseFromFile(str));
                orientationInDegree = exif.getOrientationInDegree();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BitmapUtil", e, "Can't read EXIF from " + str, new Object[0]);
                orientationInDegree = 0;
            }
            x.d("MicroMsg.BitmapUtil", "degress:%d", Integer.valueOf(orientationInDegree));
            if (orientationInDegree == 90 || orientationInDegree == 270) {
                b = b(e(str, i2, i, true), (float) orientationInDegree);
            } else {
                b = b(e(str, i, i2, true), (float) orientationInDegree);
            }
            if (b == null) {
                return false;
            }
            try {
                pInt.value = b.getWidth();
                pInt2.value = b.getHeight();
                a(b, 80, compressFormat, str2, true);
                return true;
            } catch (IOException e2) {
                x.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: " + str2);
                return false;
            }
        } else {
            x.w("MicroMsg.BitmapUtil", "file did not exists.");
            return false;
        }
    }

    public static Bitmap P(Bitmap bitmap) {
        int width;
        float f = 2.5f;
        int i = 120;
        float height;
        if (bitmap.getHeight() >= bitmap.getWidth()) {
            height = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            if (height <= 2.0f) {
                width = (int) ((((double) bitmap.getWidth()) * 120.0d) / ((double) bitmap.getHeight()));
            } else {
                if (((double) height) > 2.5d) {
                    bitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - ((int) (((float) bitmap.getWidth()) * 2.5f))) / 2, bitmap.getWidth(), (int) (((float) bitmap.getWidth()) * 2.5f));
                } else {
                    f = height;
                }
                int i2 = (int) (f * 56.0f);
                width = 56;
                i = i2;
            }
        } else {
            height = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            if (height <= 2.0f) {
                width = 120;
                i = (int) ((((double) bitmap.getHeight()) * 120.0d) / ((double) bitmap.getWidth()));
            } else {
                if (((double) height) > 2.5d) {
                    bitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - ((int) (((float) bitmap.getHeight()) * 2.5f))) / 2, 0, (int) (((float) bitmap.getHeight()) * 2.5f), bitmap.getHeight());
                } else {
                    f = height;
                }
                width = (int) (f * 56.0f);
                i = 56;
            }
        }
        x.d("MicroMsg.BitmapUtil", "bitmap decoded size=" + bitmap.getWidth() + "x" + bitmap.getHeight());
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, i, true);
        if (createScaledBitmap == null || bitmap == createScaledBitmap) {
            return bitmap;
        }
        x.i("MicroMsg.BitmapUtil", "extractThumeNail bitmap recycle. %s", bitmap);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static Bitmap Wb(String str) {
        return cU(str, 1);
    }

    public static Bitmap cU(String str, int i) {
        return a(str, 0, 0, 0.0f, null, i, new int[0]);
    }

    public static Bitmap CV(int i) {
        return a(i, null, false, 0.0f, 0, 0);
    }

    public static Bitmap CW(int i) {
        return a(i, null, false, 1.25f, 0, 0);
    }

    public static Bitmap aj(int i, int i2, int i3) {
        return a(i, null, false, 0.0f, i2, i3);
    }

    public static Bitmap f(String str, float f) {
        return b(str, f, 1);
    }

    public static Bitmap b(String str, float f, int i) {
        return a(str, 0, 0, f, null, i, new int[0]);
    }

    public static Bitmap aj(String str, int i, int i2) {
        return a(str, i, i2, null, 1, new int[0]);
    }

    public static Bitmap a(String str, int i, int i2, DecodeResultLogger decodeResultLogger, int i3, int... iArr) {
        return a(str, i, i2, 0.0f, decodeResultLogger, i3, iArr);
    }

    public static Bitmap a(String str, int i, int i2, float f, DecodeResultLogger decodeResultLogger, int i3, int... iArr) {
        return a(0, str, null, null, false, f, i, i2, decodeResultLogger, i3, iArr);
    }

    public static Bitmap m(Uri uri) {
        return a(0, null, null, uri, false, 0.0f, 0, 0, null, 1, new int[0]);
    }

    private static Bitmap createBitmap(int i, int i2, Config config, boolean z) {
        Bitmap bitmap = null;
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (Throwable th) {
            return bitmap;
        }
    }

    public static Bitmap createBitmap(int i, int i2, Config config) {
        return createBitmap(i, i2, config, false);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        return a(bArr, i, i2, new int[0]);
    }

    public static Bitmap a(byte[] bArr, int i, int i2, int... iArr) {
        if (bi.bC(bArr)) {
            x.w("MicroMsg.BitmapUtil", "error input: data is null");
            return null;
        } else if (i >= 0 && i2 >= 0) {
            return a(0, null, bArr, null, false, 0.0f, i, i2, null, 0, iArr);
        } else {
            x.w("MicroMsg.BitmapUtil", "error input: targetWidth %d, targetHeight %d", Integer.valueOf(i), Integer.valueOf(i2));
            return null;
        }
    }

    public static Bitmap bs(byte[] bArr) {
        return decodeByteArray(bArr, 0, 0);
    }

    public static Bitmap bt(byte[] bArr) {
        return a(bArr, 0, 0, new int[0]);
    }

    public static Bitmap decodeFile(String str, Options options) {
        return a(str, options, 1, new int[0]);
    }

    public static Bitmap a(String str, Options options, int i, int... iArr) {
        Options options2;
        IOException e;
        InputStream inputStream;
        Throwable th;
        if (options == null) {
            options2 = new Options();
        } else {
            options2 = options;
        }
        try {
            InputStream openRead = d.openRead(str);
            try {
                c(options2);
                Bitmap decodeStream = MMBitmapFactory.decodeStream(openRead, null, options2, null, i, iArr);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                    }
                }
                return decodeStream;
            } catch (IOException e3) {
                e = e3;
                inputStream = openRead;
            } catch (Throwable th2) {
                th = th2;
                inputStream = openRead;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e42) {
                }
            }
            throw th;
        }
        try {
            x.e("MicroMsg.BitmapUtil", "Cannot decode file '%s': %s", str, e.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            return null;
        } catch (Throwable th32) {
            th = th32;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e422) {
                }
            }
            throw th;
        }
        return null;
    }

    public static Bitmap a(InputStream inputStream, float f, int i, int i2) {
        Options options = new Options();
        if (f != 0.0f) {
            options.inDensity = (int) (160.0f * f);
        }
        if (!(i == 0 && i2 == 0)) {
            if (i == 0) {
                i = Integer.MAX_VALUE;
            }
            if (i2 == 0) {
                i2 = Integer.MAX_VALUE;
            }
            if (inputStream instanceof FileInputStream) {
                inputStream = new i((FileInputStream) inputStream);
            } else if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream, 65536);
            }
            inputStream.mark(25165824);
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(inputStream, null, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            if (i3 > i || i4 > i2) {
                options.inSampleSize = (int) Math.max(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
            }
            options.inJustDecodeBounds = false;
            try {
                inputStream.reset();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BitmapUtil", e, "Failed seeking InputStream.", new Object[0]);
            }
        }
        options.inPreferredConfig = Config.ARGB_8888;
        c(options);
        try {
            return MMBitmapFactory.decodeStream(inputStream, null, options);
        } catch (OutOfMemoryError e2) {
            options.inPreferredConfig = Config.RGB_565;
            c(options);
            try {
                return MMBitmapFactory.decodeStream(inputStream, null, options);
            } catch (OutOfMemoryError e3) {
                x.e("MicroMsg.BitmapUtil", "decodeStream OutOfMemoryError return null");
                return null;
            }
        }
    }

    public static Bitmap a(InputStream inputStream, float f) {
        return a(inputStream, f, 0, 0);
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        return a(inputStream, 0.0f, 0, 0);
    }

    public static DisplayMetrics chu() {
        if (ewi == null) {
            ewi = ad.getContext().getResources().getDisplayMetrics();
        }
        return ewi;
    }

    private static Bitmap a(int i, String str, boolean z, float f, int i2, int i3) {
        return a(i, str, null, null, z, f, i2, i3, null, 1, new int[0]);
    }

    private static Bitmap a(int i, String str, byte[] bArr, Uri uri, boolean z, float f, int i2, int i3, DecodeResultLogger decodeResultLogger, int i4, int... iArr) {
        Object obj = (i2 == 0 && i3 == 0) ? 1 : null;
        if (i2 < 0 || i3 < 0) {
            return null;
        }
        Options options;
        int i5;
        try {
            options = new Options();
            if (f != 0.0f) {
                options.inDensity = (int) (160.0f * f);
            }
            if (obj == null) {
                options.inJustDecodeBounds = true;
                a(options, bArr, str, uri, z, i, decodeResultLogger, i4, iArr);
                i5 = options.outWidth;
                int i6 = options.outHeight;
                options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                if (i5 > i2 || i6 > i3) {
                    options.inSampleSize = (int) Math.max(((float) i5) / ((float) i2), ((float) i6) / ((float) i3));
                    int i7 = options.inSampleSize;
                }
            }
            c(options);
            return a(options, bArr, str, uri, z, i, decodeResultLogger, i4, iArr);
        } catch (Throwable th) {
            return null;
        }
    }

    private static Bitmap a(Options options, byte[] bArr, String str, Uri uri, boolean z, int i, DecodeResultLogger decodeResultLogger, int i2, int... iArr) {
        Bitmap bitmap = null;
        if (bi.bC(bArr) && bi.oW(str) && uri == null && i <= 0) {
            return bitmap;
        }
        int i3;
        if (bi.bC(bArr)) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i3 != 0) {
            return MMBitmapFactory.decodeByteArray(bArr, 0, bArr.length, options, decodeResultLogger, i2, iArr);
        } else if (i > 0) {
            return a.decodeResource(ad.getContext().getResources(), i, options);
        } else {
            InputStream open;
            if (z) {
                try {
                    if (bi.oW(str)) {
                        return bitmap;
                    }
                    open = ad.getContext().getAssets().open(str);
                } catch (Throwable th) {
                    if (bitmap != null) {
                        try {
                            bitmap.close();
                        } catch (IOException e) {
                        }
                    }
                }
            } else if (uri != null) {
                open = ad.getContext().getContentResolver().openInputStream(uri);
            } else {
                open = d.openRead(str);
            }
            Bitmap decodeStream = MMBitmapFactory.decodeStream(open, null, options, decodeResultLogger, i2, iArr);
            if (open == null) {
                return decodeStream;
            }
            try {
                open.close();
                return decodeStream;
            } catch (IOException e2) {
                return decodeStream;
            }
        }
    }

    public static void c(Options options) {
        if (VERSION.SDK_INT < 14 && !sFw) {
            try {
                Options.class.getField("inNativeAlloc").setBoolean(options, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BitmapUtil", e, "", new Object[0]);
                sFw = true;
            }
        }
    }

    @TargetApi(11)
    private static Bitmap a(InputStream inputStream, int i, int i2, boolean z, DecodeResultLogger decodeResultLogger, int i3) {
        if (i2 <= 0 || i <= 0) {
            x.e("MicroMsg.BitmapUtil", "extractThumbNail height:" + i2 + " width:" + i);
            return null;
        }
        InputStream iVar;
        Options options;
        Bitmap decodeStream;
        if (!inputStream.markSupported()) {
            if (inputStream instanceof FileInputStream) {
                iVar = new i((FileInputStream) inputStream);
            } else if (!inputStream.markSupported()) {
                iVar = new BufferedInputStream(inputStream);
            }
            options = new Options();
            options.inJustDecodeBounds = true;
            iVar.mark(8388608);
            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, i3, new int[0]);
            iVar.reset();
            if (decodeStream != null) {
                x.i("MicroMsg.BitmapUtil", "extractThumeNail bitmap recycle, adsf. %s", decodeStream);
                decodeStream.recycle();
            }
            if (options.outHeight > 0 || options.outWidth <= 0) {
                x.e("MicroMsg.BitmapUtil", "decode[%s] error, outHeight[%d] outWidth[%d]", iVar, Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
                return null;
            }
            int ceil;
            int i4;
            int i5;
            x.i("MicroMsg.BitmapUtil", "extractThumbNail: round=" + i + "x" + i2 + ", crop=" + z);
            double d = (((double) options.outHeight) * 1.0d) / ((double) i2);
            double d2 = (((double) options.outWidth) * 1.0d) / ((double) i);
            x.d("MicroMsg.BitmapUtil", "extractThumbNail: extract beX = " + d2 + ", beY = " + d);
            double d3 = z ? d > d2 ? d2 : d : d < d2 ? d2 : d;
            options.inSampleSize = (int) d3;
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }
            while (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
                options.inSampleSize++;
            }
            if (z) {
                if (d > d2) {
                    ceil = (int) Math.ceil(((((double) i) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
                    i4 = i;
                } else {
                    i4 = (int) Math.ceil(((((double) i2) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                    ceil = i2;
                }
            } else if (d < d2) {
                ceil = (int) Math.ceil(((((double) i) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
                i4 = i;
            } else {
                i4 = (int) Math.ceil(((((double) i2) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                ceil = i2;
            }
            int i6 = ceil > 0 ? ceil : 1;
            if (i4 > 0) {
                i5 = i4;
            } else {
                i5 = 1;
            }
            options.inJustDecodeBounds = false;
            if (VERSION.SDK_INT >= 11) {
                options.inMutable = true;
            }
            x.i("MicroMsg.BitmapUtil", "bitmap required size=" + i5 + "x" + i6 + ", orig=" + options.outWidth + "x" + options.outHeight + ", sample=" + options.inSampleSize);
            c(options);
            Bitmap decodeStream2 = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, i3, new int[0]);
            if (decodeStream2 == null) {
                x.e("MicroMsg.BitmapUtil", "bitmap decode failed");
                return null;
            }
            x.d("MicroMsg.BitmapUtil", "bitmap decoded size=" + decodeStream2.getWidth() + "x" + decodeStream2.getHeight());
            decodeStream = Bitmap.createScaledBitmap(decodeStream2, i5, i6, true);
            if (decodeStream2 == decodeStream || decodeStream == null) {
                decodeStream = decodeStream2;
            } else {
                x.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfad. %s", decodeStream2);
                decodeStream2.recycle();
            }
            if (z) {
                if (decodeStream.getWidth() < i) {
                    x.e("MicroMsg.BitmapUtil", "bmw < width %d %d", Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(i));
                    i = decodeStream.getWidth();
                }
                if (decodeStream.getHeight() < i2) {
                    x.e("MicroMsg.BitmapUtil", "bmh < height %d %d", Integer.valueOf(decodeStream.getHeight()), Integer.valueOf(i2));
                    i2 = decodeStream.getHeight();
                }
                int width = (decodeStream.getWidth() - i) >> 1;
                int height = (decodeStream.getHeight() - i2) >> 1;
                if (width < 0 || height < 0) {
                    x.e("MicroMsg.BitmapUtil", "fix crop image error %d %d %d %d", Integer.valueOf(decodeStream.getWidth()), Integer.valueOf(decodeStream.getHeight()), Integer.valueOf(i), Integer.valueOf(i2));
                    if (width < 0) {
                        width = 0;
                    }
                    if (height < 0) {
                        height = 0;
                    }
                }
                decodeStream2 = Bitmap.createBitmap(decodeStream, width, height, i, i2);
                if (decodeStream2 == null) {
                    return decodeStream;
                }
                if (decodeStream2 != decodeStream) {
                    x.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfaasdfad. %s", decodeStream);
                    decodeStream.recycle();
                } else {
                    decodeStream2 = decodeStream;
                }
                x.d("MicroMsg.BitmapUtil", "bitmap croped size=" + decodeStream2.getWidth() + "x" + decodeStream2.getHeight());
            } else {
                decodeStream2 = decodeStream;
            }
            return decodeStream2;
        }
        iVar = inputStream;
        options = new Options();
        try {
            options.inJustDecodeBounds = true;
            iVar.mark(8388608);
            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, i3, new int[0]);
            iVar.reset();
            if (decodeStream != null) {
                x.i("MicroMsg.BitmapUtil", "extractThumeNail bitmap recycle, adsf. %s", decodeStream);
                decodeStream.recycle();
            }
            if (options.outHeight > 0) {
            }
            x.e("MicroMsg.BitmapUtil", "decode[%s] error, outHeight[%d] outWidth[%d]", iVar, Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
            return null;
        } catch (OutOfMemoryError e) {
            x.e("MicroMsg.BitmapUtil", "decode bitmap failed: " + e.getMessage());
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.BitmapUtil", e2, "Failed decode bitmap", new Object[0]);
            return null;
        }
    }

    public static Bitmap e(String str, int i, int i2, boolean z) {
        return a(str, i, i2, z, null, 0);
    }

    public static Bitmap a(String str, int i, int i2, boolean z, DecodeResultLogger decodeResultLogger, int i3) {
        Throwable e;
        InputStream inputStream;
        if (bi.oW(str)) {
            x.e("MicroMsg.BitmapUtil", "extractThumbNail path null or nil");
            return null;
        }
        try {
            InputStream openRead = d.openRead(str);
            try {
                Bitmap a = a(openRead, i2, i, z, decodeResultLogger, i3);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                    }
                }
                return a;
            } catch (FileNotFoundException e3) {
                e = e3;
                inputStream = openRead;
            } catch (Throwable th) {
                e = th;
                inputStream = openRead;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw e;
            }
        } catch (Throwable e5) {
            e = e5;
            inputStream = null;
            try {
                x.printErrStackTrace("MicroMsg.BitmapUtil", e, "Failed decode bitmap.", new Object[0]);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                return null;
            } catch (Throwable e52) {
                e = e52;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e42) {
                    }
                }
                throw e;
            }
        } catch (Throwable e522) {
            e = e522;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e422) {
                }
            }
            throw e;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
        if (bitmap == null) {
            x.e("MicroMsg.BitmapUtil", "extractThumbNail bitmap is null.");
            return null;
        } else if (i <= 0 || i2 <= 0) {
            x.e("MicroMsg.BitmapUtil", "extractThumbNail height:" + i + " width:" + i2);
            return null;
        } else {
            int ceil;
            int i3;
            Bitmap createBitmap;
            Options options = new Options();
            c(options);
            options.outHeight = bitmap.getHeight();
            options.outWidth = bitmap.getWidth();
            x.i("MicroMsg.BitmapUtil", "extractThumbNail: round=" + i2 + "x" + i + ", crop=" + z + ", recycle=" + z2);
            double d = (((double) options.outHeight) * 1.0d) / ((double) i);
            double d2 = (((double) options.outWidth) * 1.0d) / ((double) i2);
            x.d("MicroMsg.BitmapUtil", "extractThumbNail: extract beX = " + d2 + ", beY = " + d);
            double d3 = z ? d > d2 ? d2 : d : d < d2 ? d2 : d;
            options.inSampleSize = (int) d3;
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }
            while (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
                options.inSampleSize++;
            }
            if (z) {
                if (d > d2) {
                    ceil = (int) Math.ceil(((((double) i2) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
                    i3 = i2;
                } else {
                    i3 = (int) Math.ceil(((((double) i) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                    ceil = i;
                }
            } else if (d < d2) {
                ceil = (int) Math.ceil(((((double) i2) * 1.0d) * ((double) options.outHeight)) / ((double) options.outWidth));
                i3 = i2;
            } else {
                i3 = (int) Math.ceil(((((double) i) * 1.0d) * ((double) options.outWidth)) / ((double) options.outHeight));
                ceil = i;
            }
            options.inJustDecodeBounds = false;
            x.i("MicroMsg.BitmapUtil", "bitmap required size=" + i3 + "x" + ceil + ", orig=" + options.outWidth + "x" + options.outHeight + ", sample=" + options.inSampleSize);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, ceil, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = bitmap;
            } else if (z2 && bitmap != createScaledBitmap) {
                x.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle asdfjasjdfja asdfasd. %s", bitmap);
                bitmap.recycle();
            }
            if (z) {
                if (createScaledBitmap.getWidth() < i2) {
                    x.e("MicroMsg.BitmapUtil", "bmw < width %d %d", Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(i2));
                    i2 = createScaledBitmap.getWidth();
                }
                if (createScaledBitmap.getHeight() < i) {
                    x.e("MicroMsg.BitmapUtil", "bmh < height %d %d", Integer.valueOf(createScaledBitmap.getHeight()), Integer.valueOf(i));
                    i = createScaledBitmap.getHeight();
                }
                createBitmap = Bitmap.createBitmap(createScaledBitmap, (createScaledBitmap.getWidth() - i2) >> 1, (createScaledBitmap.getHeight() - i) >> 1, i2, i);
                if (createBitmap == null) {
                    return createScaledBitmap;
                }
                if (z2 && createScaledBitmap != createBitmap) {
                    x.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle ajdfjajsdfjdsajjfsad. %s", createScaledBitmap);
                    createScaledBitmap.recycle();
                }
                x.d("MicroMsg.BitmapUtil", "bitmap croped size=" + createBitmap.getWidth() + "x" + createBitmap.getHeight());
            } else {
                createBitmap = createScaledBitmap;
            }
            return createBitmap;
        }
    }

    public static Bitmap ak(String str, int i, int i2) {
        return a(0, str, true, 0.0f, i, i2);
    }

    public static Bitmap a(Bitmap bitmap, float f, float f2) {
        if (bitmap == null) {
            return null;
        }
        if (((double) f) > 0.999d && ((double) f) < 1.001d && ((double) f2) > 0.999d && ((double) f2) < 1.001d) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        if (((double) f) < 0.999d || ((double) f) > 1.001d || ((double) f2) < 0.999d || ((double) f2) > 1.001d) {
            matrix.postScale(f, f2);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        x.d("MicroMsg.BitmapUtil", "resultBmp is null: " + (createBitmap == null) + "  degree:0.0");
        if (bitmap != createBitmap) {
            x.i("MicroMsg.BitmapUtil", "rotateAndScale bitmap recycle asdfasdjfjasdfjsadfjdsa. %s", bitmap);
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap b(Bitmap bitmap, float f) {
        if (f % 360.0f == 0.0f) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        try {
            boolean z;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            String str = "MicroMsg.BitmapUtil";
            StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
            if (createBitmap == null) {
                z = true;
            } else {
                z = false;
            }
            x.d(str, stringBuilder.append(z).append("  degree:").append(f).toString());
            if (bitmap != createBitmap) {
                x.i("MicroMsg.BitmapUtil", "rotate bitmap recycle ajsdfasdf adsf. %s", bitmap);
                bitmap.recycle();
            }
            return createBitmap;
        } catch (Throwable th) {
            x.d("MicroMsg.BitmapUtil", "createBitmap failed : %s ", bi.i(th));
            return bitmap;
        }
    }

    public static boolean a(String str, int i, CompressFormat compressFormat, int i2, String str2) {
        Bitmap cU = cU(str, 1);
        if (cU == null) {
            x.e("MicroMsg.BitmapUtil", "rotate: create bitmap fialed");
            return false;
        }
        float width = (float) cU.getWidth();
        float height = (float) cU.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, width / 2.0f, height / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(cU, 0, 0, (int) width, (int) height, matrix, true);
        if (cU != createBitmap) {
            x.i("MicroMsg.BitmapUtil", "rotate bitmap recycle adjfjads fadsj fsadjf dsa. %s", cU.toString());
            cU.recycle();
        }
        try {
            a(createBitmap, i2, compressFormat, str2, true);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BitmapUtil", e, "create thumbnail from orig failed: " + str2, new Object[0]);
            return false;
        }
    }

    public static boolean a(String str, int i, CompressFormat compressFormat, String str2, String str3) {
        return a(str, i, compressFormat, 90, str2 + str3);
    }

    public static void a(Bitmap bitmap, int i, CompressFormat compressFormat, OutputStream outputStream, boolean z) {
        a(bitmap, compressFormat, i, outputStream);
        if (z) {
            x.i("MicroMsg.BitmapUtil", "saveBitmapToStream bitmap recycle. %s", bitmap);
            bitmap.recycle();
        }
    }

    public static void a(Bitmap bitmap, int i, CompressFormat compressFormat, String str, boolean z) {
        OutputStream outputStream = null;
        if (bi.oW(str)) {
            throw new IOException("saveBitmapToImage pathName null or nil");
        }
        x.d("MicroMsg.BitmapUtil", "saving to " + str);
        Uri cBV = new com.tencent.mm.vfs.b(new com.tencent.mm.vfs.b(str).cBX()).cBV();
        d.mL(cBV == null ? null : cBV.toString());
        try {
            outputStream = d.mG(str);
            a(bitmap, i, compressFormat, outputStream, z);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.BitmapUtil", e2, "saveBitmapToImage failed: %s", str);
            throw new IOException(e2);
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, boolean z) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float max = Math.max(((float) i) / ((float) width), ((float) i2) / ((float) height));
        float f = ((float) width) * max;
        float f2 = ((float) height) * max;
        max = (((float) i) - f) / 2.0f;
        float f3 = (((float) i2) - f2) / 2.0f;
        RectF rectF = new RectF(max, f3, f + max, f2 + f3);
        Config config = bitmap.getConfig();
        if (config == null) {
            x.w("MicroMsg.BitmapUtil", "get center crop bitmap, config is null");
            config = Config.ARGB_8888;
        }
        try {
            createBitmap = Bitmap.createBitmap(i, i2, config);
        } catch (Throwable th) {
            x.e("MicroMsg.BitmapUtil", "BitmapUtil decode getCenterCropBitmap fail");
            return bitmap;
        }
        new Canvas(createBitmap).drawBitmap(bitmap, null, rectF, null);
        if (!z) {
            return createBitmap;
        }
        x.i("MicroMsg.BitmapUtil", "getCenterCropBitmap bitmap recycle %s", bitmap);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap, boolean z, float f, boolean z2) {
        if (bitmap == null || bitmap.isRecycled()) {
            x.e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap in bitmap is null");
            return null;
        }
        Bitmap createBitmap = createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888, z2);
        if (createBitmap == null) {
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-4144960);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (z) {
            x.i("MicroMsg.BitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap, boolean z, float f) {
        return a(bitmap, z, f, false);
    }

    public static Bitmap s(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888, false);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static byte[] Q(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return new byte[0];
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(bitmap, CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BitmapUtil", e, "", new Object[0]);
            return toByteArray;
        }
    }

    public static byte[] R(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return new byte[0];
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(bitmap, CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BitmapUtil", e, "", new Object[0]);
            return toByteArray;
        }
    }

    public static void c(String str, PInt pInt, PInt pInt2) {
        Bitmap bitmap = null;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        c(options);
        try {
            bitmap = MMBitmapFactory.decodeStream(d.openRead(str), null, options, 0);
        } catch (FileNotFoundException e) {
        }
        if (bitmap != null) {
            x.i("MicroMsg.BitmapUtil", "getRent bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        pInt.value = options.outWidth;
        pInt2.value = options.outHeight;
    }

    public static Bitmap dk(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        }
        view.draw(canvas);
        return createBitmap;
    }

    public static void a(Canvas canvas, View view) {
        view.draw(canvas);
        List<r> j = j(view, (int) view.getX(), (int) view.getY());
        if (j.size() > 0) {
            for (r rVar : j) {
                if (!(rVar == null || rVar.sFP == null)) {
                    TextureView textureView = rVar.sFP;
                    Bitmap bitmap = textureView.getBitmap(textureView.getWidth(), textureView.getHeight());
                    if (bitmap == null || bitmap.isRecycled()) {
                        x.e("MicroMsg.BitmapUtil", "get thumb bitmap null or is recycled");
                    } else {
                        canvas.drawBitmap(bitmap, (float) rVar.left, (float) rVar.top, null);
                    }
                }
            }
        }
    }

    private static List<r> j(View view, int i, int i2) {
        List<r> arrayList = new ArrayList();
        if (view instanceof TextureView) {
            r rVar = new r();
            rVar.sFP = (TextureView) view;
            rVar.left = i;
            rVar.top = i2;
            arrayList.add(rVar);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                arrayList.addAll(j(viewGroup.getChildAt(i3), (int) (viewGroup.getX() + ((float) i)), (int) (viewGroup.getY() + ((float) i2))));
            }
        }
        return arrayList;
    }

    public static Bitmap d(Bitmap bitmap, int i) {
        x.d("MicroMsg.BitmapUtil", "begin createChattingImage");
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap == null) {
            x.w("MicroMsg.BitmapUtil", "sourceBitmap is null .");
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            x.w("MicroMsg.BitmapUtil", "sourceBitmap width or height is 0.");
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            Bitmap createBitmap = createBitmap(width, height, Config.ARGB_8888, false);
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) ad.getContext().getResources().getDrawable(i);
            ninePatchDrawable.setBounds(0, 0, width, height);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            x.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis2));
            if (createBitmap == null) {
                x.e("MicroMsg.BitmapUtil", "[createChattingImage] maskBitmap is null.");
                return null;
            }
            int width2 = createBitmap.getWidth();
            int height2 = createBitmap.getHeight();
            if (width2 <= 0 || height2 <= 0) {
                x.w("MicroMsg.BitmapUtil", "maskBitmap width or height is 0.");
                return null;
            } else if (height2 == height && width2 == width) {
                int[] iArr = new int[(width * height)];
                int[] iArr2 = new int[(width2 * height2)];
                bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                createBitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
                currentTimeMillis2 = System.currentTimeMillis();
                width2 = 0;
                while (width2 < iArr2.length) {
                    try {
                        if (iArr2[width2] != -16777216) {
                            if (iArr2[width2] == 0) {
                                iArr[width2] = 0;
                            } else if (iArr2[width2] != -1) {
                                iArr[width2] = iArr[width2] & iArr2[width2];
                            }
                        }
                        width2++;
                    } catch (Exception e) {
                        x.e("MicroMsg.BitmapUtil", e.toString());
                    }
                }
                x.d("MicroMsg.BitmapUtil", "meger pixels  " + (System.currentTimeMillis() - currentTimeMillis2));
                long currentTimeMillis3 = System.currentTimeMillis();
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                x.d("MicroMsg.BitmapUtil", "setPixels " + (System.currentTimeMillis() - currentTimeMillis3));
                x.d("MicroMsg.BitmapUtil", "createTime" + (System.currentTimeMillis() - currentTimeMillis));
                return createBitmap;
            } else {
                x.e("MicroMsg.BitmapUtil", "maskHeiht maskWidth != height width.");
                return null;
            }
        } catch (Exception e2) {
            x.e("MicroMsg.BitmapUtil", "[createChattingImage] create nine pathc bitmap faild.");
            return null;
        }
    }

    public static Bitmap y(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0) {
            x.w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap createBitmap = createBitmap(i3, i4, Config.ARGB_8888, false);
        NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) ad.getContext().getResources().getDrawable(i);
        ninePatchDrawable.setBounds(0, 0, i3, i4);
        ninePatchDrawable.draw(new Canvas(createBitmap));
        x.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        return d(createBitmap, i2);
    }

    public static Bitmap k(String str, int i, int i2, int i3) {
        if (str == null || str.equals("") || i < 0 || i2 < 0 || i3 < 0) {
            x.w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
            return null;
        }
        Bitmap decodeByteArray = decodeByteArray(d.dv(str, -1), 0, 0);
        if (decodeByteArray == null || decodeByteArray.isRecycled()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap createBitmap = createBitmap(i2, i3, Config.ARGB_8888, false);
        Canvas canvas = new Canvas(createBitmap);
        x.d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(decodeByteArray.getHeight()), Integer.valueOf(i2), Integer.valueOf(i3));
        canvas.drawBitmap(decodeByteArray, null, new Rect(0, 0, i2, i3), new Paint());
        x.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        return d(createBitmap, i);
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, int i3) {
        if (bitmap == null || i < 0 || i2 < 0 || i3 < 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap createBitmap = createBitmap(i2, i3, Config.ARGB_8888, false);
        Canvas canvas = new Canvas(createBitmap);
        x.d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i2), Integer.valueOf(i3));
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, i2, i3), new Paint());
        x.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - currentTimeMillis));
        return d(createBitmap, i);
    }

    public static Bitmap e(Bitmap bitmap, int i) {
        if (bitmap == null) {
            x.w("MicroMsg.BitmapUtil", "fastblur: but sentBitmap is null");
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        if (i <= 0) {
            return null;
        }
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int width = copy.getWidth();
        int height = copy.getHeight();
        int[] iArr = new int[(width * height)];
        x.e("pix", width + " " + height + " " + iArr.length);
        copy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i13 = width - 1;
        int i14 = height - 1;
        int i15 = width * height;
        int i16 = (i + i) + 1;
        int[] iArr2 = new int[i15];
        int[] iArr3 = new int[i15];
        int[] iArr4 = new int[i15];
        int[] iArr5 = new int[Math.max(width, height)];
        int i17 = (i16 + 1) >> 1;
        int i18 = i17 * i17;
        int[] iArr6 = new int[(i18 * 256)];
        for (i17 = 0; i17 < i18 * 256; i17++) {
            iArr6[i17] = i17 / i18;
        }
        i18 = 0;
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i16, 3});
        int i19 = i + 1;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            i2 = i18;
            i3 = i20;
            if (i3 >= height) {
                break;
            }
            int[] iArr8;
            i4 = 0;
            i5 = -i;
            i18 = 0;
            i20 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = 0;
            i11 = 0;
            while (true) {
                i12 = i4;
                if (i5 > i) {
                    break;
                }
                i4 = iArr[Math.min(i13, Math.max(i5, 0)) + i2];
                iArr8 = iArr7[i5 + i];
                iArr8[0] = (16711680 & i4) >> 16;
                iArr8[1] = (65280 & i4) >> 8;
                iArr8[2] = i4 & 255;
                i4 = i19 - Math.abs(i5);
                i12 += iArr8[0] * i4;
                i11 += iArr8[1] * i4;
                i10 += i4 * iArr8[2];
                if (i5 > 0) {
                    i6 += iArr8[0];
                    i20 += iArr8[1];
                    i18 += iArr8[2];
                } else {
                    i9 += iArr8[0];
                    i8 += iArr8[1];
                    i7 += iArr8[2];
                }
                i4 = i5 + 1;
            }
            i4 = i;
            for (i5 = 0; i5 < width; i5++) {
                iArr2[i2] = iArr6[i12];
                iArr3[i2] = iArr6[i11];
                iArr4[i2] = iArr6[i10];
                i12 -= i9;
                i11 -= i8;
                i10 -= i7;
                iArr8 = iArr7[((i4 - i) + i16) % i16];
                i9 -= iArr8[0];
                i8 -= iArr8[1];
                i7 -= iArr8[2];
                if (i3 == 0) {
                    iArr5[i5] = Math.min((i5 + i) + 1, i13);
                }
                int i22 = iArr[iArr5[i5] + i21];
                iArr8[0] = (16711680 & i22) >> 16;
                iArr8[1] = (65280 & i22) >> 8;
                iArr8[2] = i22 & 255;
                i6 += iArr8[0];
                i20 += iArr8[1];
                i18 += iArr8[2];
                i12 += i6;
                i11 += i20;
                i10 += i18;
                i4 = (i4 + 1) % i16;
                iArr8 = iArr7[i4 % i16];
                i9 += iArr8[0];
                i8 += iArr8[1];
                i7 += iArr8[2];
                i6 -= iArr8[0];
                i20 -= iArr8[1];
                i18 -= iArr8[2];
                i2++;
            }
            i18 = i21 + width;
            i20 = i3 + 1;
        }
        for (i5 = 0; i5 < width; i5++) {
            i4 = 0;
            i18 = (-i) * width;
            i10 = -i;
            i20 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i2 = 0;
            i12 = 0;
            i21 = 0;
            while (true) {
                i3 = i4;
                if (i10 > i) {
                    break;
                }
                i4 = Math.max(0, i18) + i5;
                int[] iArr9 = iArr7[i10 + i];
                iArr9[0] = iArr2[i4];
                iArr9[1] = iArr3[i4];
                iArr9[2] = iArr4[i4];
                i13 = i19 - Math.abs(i10);
                i3 += iArr2[i4] * i13;
                i21 += iArr3[i4] * i13;
                i12 += iArr4[i4] * i13;
                if (i10 > 0) {
                    i7 += iArr9[0];
                    i6 += iArr9[1];
                    i20 += iArr9[2];
                } else {
                    i2 += iArr9[0];
                    i9 += iArr9[1];
                    i8 += iArr9[2];
                }
                if (i10 < i14) {
                    i18 += width;
                }
                i4 = i10 + 1;
            }
            i11 = 0;
            i18 = i20;
            i4 = i5;
            i10 = i;
            while (i11 < height) {
                iArr[i4] = (((-16777216 & iArr[i4]) | (iArr6[i3] << 16)) | (iArr6[i21] << 8)) | iArr6[i12];
                i20 = i3 - i2;
                i21 -= i9;
                i12 -= i8;
                int[] iArr10 = iArr7[((i10 - i) + i16) % i16];
                i2 -= iArr10[0];
                i9 -= iArr10[1];
                i8 -= iArr10[2];
                if (i5 == 0) {
                    iArr5[i11] = Math.min(i11 + i19, i14) * width;
                }
                i13 = iArr5[i11] + i5;
                iArr10[0] = iArr2[i13];
                iArr10[1] = iArr3[i13];
                iArr10[2] = iArr4[i13];
                i7 += iArr10[0];
                i6 += iArr10[1];
                i18 += iArr10[2];
                i3 = i20 + i7;
                i21 += i6;
                i12 += i18;
                i10 = (i10 + 1) % i16;
                int[] iArr11 = iArr7[i10];
                i2 += iArr11[0];
                i9 += iArr11[1];
                i8 += iArr11[2];
                i7 -= iArr11[0];
                i18 -= iArr11[2];
                i4 += width;
                i11++;
                i6 -= iArr11[1];
            }
        }
        x.e("pix", width + " " + height + " " + i15);
        copy.setPixels(iArr, 0, width, 0, 0, width, height);
        return copy;
    }

    public static Bitmap c(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAlpha((int) (255.0f * f));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap S(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Bitmap T(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static String bu(byte[] bArr) {
        for (int i = 0; i < bArr.length - 1; i++) {
            if ((bArr[i] & 255) == 255) {
                byte b = bArr[i + 1];
                if ((b & 255) >= 192 && (b & 255) <= 207) {
                    x.d("MicroMsg.BitmapUtil", "match 0xff-" + Integer.toHexString(b & 255) + "  at:" + i);
                    if ((i + 1) + 17 >= bArr.length) {
                        x.d("MicroMsg.BitmapUtil", "not engouht len at " + i);
                        break;
                    }
                    int i2 = i + 2;
                    if (bArr[i2 + 7] != (byte) 3) {
                        x.d("MicroMsg.BitmapUtil", "num != 3 at " + i);
                    } else {
                        byte b2 = bArr[i2 + 8];
                        byte b3 = bArr[i2 + 11];
                        byte b4 = bArr[i2 + 14];
                        if (b2 == (byte) 1 || b3 == (byte) 2 || b4 == (byte) 3) {
                            b2 = bArr[i2 + 9];
                            b3 = bArr[i2 + 12];
                            b = bArr[i2 + 15];
                            if (!(b2 == (byte) 0 || b3 == (byte) 0 || b == (byte) 0)) {
                                if (b2 == b3 && b2 == b) {
                                    return "YUV444";
                                }
                                int i3 = ((b2 & 255) >> 4) & 15;
                                int i4 = b2 & 15;
                                int i5 = ((b3 & 255) >> 4) & 15;
                                int i6 = b3 & 15;
                                int i7 = ((b & 255) >> 4) & 15;
                                i2 = b & 15;
                                if (!(i5 == 0 || i7 == 0 || i6 == 0 || i2 == 0 || i3 / i5 != 2 || i3 / i7 != 2)) {
                                    if (i4 / i6 == 2 && i4 / i2 == 2) {
                                        return "YUV420";
                                    }
                                    if (i4 == i6 && i4 == i2) {
                                        return "YUV422";
                                    }
                                }
                            }
                        }
                        x.d("MicroMsg.BitmapUtil", "Y/Cb/Cr Tag is not right at " + i);
                    }
                }
            }
        }
        return null;
    }

    private static boolean a(Bitmap bitmap, CompressFormat compressFormat, int i, OutputStream outputStream) {
        if (bitmap == null) {
            x.e("MicroMsg.BitmapUtil", "bitmap error %s", bitmap);
            return false;
        }
        boolean compress = bitmap.compress(compressFormat, i, outputStream);
        if (!compress) {
            x.e("MicroMsg.BitmapUtil", "compress error %s", bi.cjd().toString());
        }
        return compress;
    }
}
