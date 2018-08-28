package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.compatible.d.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.vfs.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class z {
    public static boolean bu(int i, int i2) {
        return ((double) i2) > ((double) i) * 2.0d;
    }

    public static boolean bv(int i, int i2) {
        return ((double) i) > ((double) i2) * 2.0d;
    }

    public static int Wn(String str) {
        Bitmap bitmap = null;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            bitmap = MMBitmapFactory.decodeStream(d.openRead(str), null, options, 0);
        } catch (FileNotFoundException e) {
        }
        if (bitmap != null) {
            x.i("MicroMsg.LongBitmapHandler", "isLongPicture bitmap recycle. %s", new Object[]{bitmap});
            bitmap.recycle();
        }
        float f = ((float) options.outWidth) / ((float) options.outHeight);
        float f2 = ((float) options.outHeight) / ((float) options.outWidth);
        if (f >= 2.0f) {
            return 1;
        }
        if (f2 >= 2.0f) {
            return 2;
        }
        return -1;
    }

    public static Bitmap l(String str, int i, int i2, int i3) {
        Throwable e;
        InputStream inputStream;
        x.i("MicroMsg.LongBitmapHandler", "hy: createLongPictureBitmap: path: %s, minShorter: %d, maxLonger: %d, type: %d, rotateDegree: %d, decodeStrategy: %d", new Object[]{str, Integer.valueOf(56), Integer.valueOf(144), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        int i4 = a.dbt;
        a.aK(0);
        if (bi.oW(str) || !(i == 2 || i == 1)) {
            x.w("MicroMsg.LongBitmapHandler", "hy: createLongPictureBitmap precheck failed!");
            i4 = a.dbt;
            a.aK(1);
            return null;
        }
        Point Wa = c.Wa(str);
        if (Wa == null || Wa.x <= 0 || Wa.y <= 0) {
            x.w("MicroMsg.LongBitmapHandler", "hy: can not retrieve original picture size!");
            i4 = a.dbt;
            a.aK(3);
            return null;
        }
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Bitmap decodeRegion;
        int i10 = Wa.x;
        int i11 = Wa.y;
        boolean z = i == 1 ? ((double) i10) / ((double) i11) > 2.5d : ((double) i11) / ((double) i10) > 2.5d;
        int i12;
        if (!z) {
            i5 = i == 1 ? i10 : i11;
            if (i == 1) {
                i4 = i11;
            } else {
                i4 = i10;
            }
            i6 = 0;
            i7 = 0;
            i8 = i11;
            i9 = i10;
        } else if (i == 1) {
            i12 = (int) (((double) i11) * 2.5d);
            i6 = 0;
            i4 = i11;
            i5 = i12;
            i7 = (int) ((((double) i10) - (((double) i11) * 2.5d)) / 2.0d);
            i8 = i11;
            i9 = i12;
        } else {
            i12 = (int) (((double) i10) * 2.5d);
            i7 = 0;
            i4 = i10;
            i5 = i12;
            i8 = i12;
            i6 = (int) ((((double) i11) - (((double) i10) * 2.5d)) / 2.0d);
            i9 = i10;
        }
        x.d("MicroMsg.LongBitmapHandler", "hy: need crop: %b, croppedWidth: %d, croppedHeight: %d, rectStartX: %d, rectStartY: %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i9), Integer.valueOf(i8), Integer.valueOf(i7), Integer.valueOf(i6)});
        i10 = 1;
        float f = 1.0f;
        if (i5 > 144) {
            i10 = c.ai(i4, i5, i4);
            x.d("MicroMsg.LongBitmapHandler", "hy: need sample. use sampleSize: %d, need post scale: %f", new Object[]{Integer.valueOf(i10), Float.valueOf(144.0f / ((float) (i5 / i10)))});
            f = r0;
        } else if (i4 < 56) {
            x.d("MicroMsg.LongBitmapHandler", "hy: need scale larger. scale times: %f", new Object[]{Float.valueOf(56.0f / ((float) i4))});
            f = r0;
        }
        Options options = new Options();
        options.inSampleSize = i10;
        if (z) {
            InputStream inputStream2 = null;
            try {
                inputStream2 = d.openRead(str);
                try {
                    decodeRegion = MMBitmapFactory.decodeRegion(inputStream2, new Rect(i7, i6, i7 + i9, i8 + i6), options, null);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    inputStream = inputStream2;
                } catch (Throwable th) {
                    e = th;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw e;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                inputStream = inputStream2;
            } catch (Throwable th2) {
                e = th2;
                inputStream = inputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e42) {
                    }
                }
                throw e;
            }
        }
        decodeRegion = MMBitmapFactory.decodeFile(str, options, null, i3, new int[0]);
        if (decodeRegion == null) {
            x.e("MicroMsg.LongBitmapHandler", "hy: can not decode non matrixed bitmap!!");
            i4 = a.dbt;
            a.aK(5);
            return null;
        }
        i10 = a.dbt;
        a.aK(6);
        if (f == 1.0f && i2 == 0) {
            x.d("MicroMsg.LongBitmapHandler", "hy: not need to post handle. return directly");
            return decodeRegion;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        matrix.postRotate((float) i2);
        Bitmap createBitmap = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix, true);
        if (createBitmap != decodeRegion) {
            decodeRegion.recycle();
        }
        if (createBitmap != null) {
            x.d("MicroMsg.LongBitmapHandler", "hy: created bitmap is %d * %d", new Object[]{Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight())});
        }
        return createBitmap;
        try {
            x.printErrStackTrace("MicroMsg.LongBitmapHandler", e, "hy: file not found when decode region", new Object[0]);
            i4 = a.dbt;
            a.aK(4);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            return null;
        } catch (Throwable th3) {
            e = th3;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e422) {
                }
            }
            throw e;
        }
        return null;
    }

    private static boolean a(String str, CompressFormat compressFormat, String str2, int i, PInt pInt, PInt pInt2) {
        Bitmap l = l(str, i, 0, 1);
        try {
            pInt.value = l.getWidth();
            pInt2.value = l.getHeight();
            c.a(l, 90, compressFormat, str2, true);
            return true;
        } catch (IOException e) {
            x.e("MicroMsg.LongBitmapHandler", "create thumbnail from orig failed: " + str2);
            return false;
        }
    }

    public static boolean a(String str, CompressFormat compressFormat, String str2, int i) {
        return a(str, compressFormat, str2, i, new PInt(), new PInt());
    }
}
