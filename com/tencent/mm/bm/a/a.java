package com.tencent.mm.bm.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import java.util.Arrays;

public final class a {
    public static Bitmap a(Context context, Bitmap bitmap, byte[] bArr, int[] iArr) {
        int i;
        int i2;
        int i3;
        int width = bitmap.getWidth();
        int b = b.b(context, 197.0f);
        if (b < width) {
            b = width;
        }
        int i4 = (int) (((double) iArr[0]) * 0.1d);
        b /= iArr[0] + (i4 * 2);
        if (b == 0) {
            i = 1;
        } else {
            i = b;
        }
        int i5 = i4 * i;
        int i6 = i * (iArr[0] + (i4 * 2));
        int i7 = (iArr[1] * i) + (i4 * (i * 2));
        if (i6 < width) {
            i6 = width;
        }
        if (i7 < width) {
            i7 = width;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Config.ARGB_8888);
        int[] iArr2 = new int[(i6 * i7)];
        int i8 = (i6 - width) / 2;
        int i9 = 0;
        for (int i10 = i8; i10 < i6 - i8 && i9 < width; i10++) {
            i2 = 0;
            i3 = i8;
            while (i3 < i7 - i8 && i2 < width) {
                iArr2[(i10 * i6) + i3] = bitmap.getPixel(i2, i9);
                i3++;
                i2++;
            }
            i9++;
        }
        for (width = 0; width < iArr[1]; width++) {
            for (i2 = 0; i2 < iArr[0]; i2++) {
                if (bArr[(iArr[0] * width) + i2] == (byte) 1) {
                    for (i8 = 0; i8 < i; i8++) {
                        for (i3 = 0; i3 < i; i3++) {
                            if (iArr2[((((((width * i) + i5) + i8) * i6) + (i2 * i)) + i5) + i3] == 0) {
                                iArr2[((((((width * i) + i5) + i8) * i6) + (i2 * i)) + i5) + i3] = -16777216;
                            }
                        }
                    }
                } else {
                    for (i8 = 0; i8 < i; i8++) {
                        for (i3 = 0; i3 < i; i3++) {
                            if (iArr2[((((((width * i) + i5) + i8) * i6) + (i2 * i)) + i5) + i3] == 0) {
                                iArr2[((((((width * i) + i5) + i8) * i6) + (i2 * i)) + i5) + i3] = -1;
                            }
                        }
                    }
                }
            }
        }
        createBitmap.setPixels(iArr2, 0, i6, 0, 0, i6, i7);
        return createBitmap;
    }

    public static Bitmap b(Context context, String str, int i, int i2) {
        byte[] bArr = new byte[40000];
        int[] iArr = new int[2];
        int a = QbarNative.a(bArr, iArr, str, i, i2, "UTF-8");
        QbarNative.nativeRelease();
        if (a > 0) {
            int i3;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i4 = displayMetrics.widthPixels;
            int i5 = displayMetrics.heightPixels;
            if (i4 >= i5) {
                i4 = i5;
            }
            int i6 = (int) (((double) i4) * 0.8d);
            int i7 = (int) (((double) iArr[0]) * 0.1d);
            if (i == 0) {
                i4 = i6 / (iArr[0] + (i7 * 2));
                if (i4 == 0) {
                    i4 = 1;
                }
                i6 = i4;
                i3 = i4;
            } else if (i == 5) {
                i4 = i6 / (iArr[0] + (i7 * 2));
                if (i4 == 0) {
                    i4 = 1;
                }
                i6 = (iArr[0] * i4) / iArr[1];
                i3 = i4;
            } else {
                i6 = 0;
                i3 = 0;
            }
            int i8 = i7 * i3;
            i5 = i3 * (iArr[0] + (i7 * 2));
            int i9 = (iArr[1] * i6) + (i7 * (i3 * 2));
            Bitmap createBitmap = Bitmap.createBitmap(i5, i9, Config.ARGB_8888);
            int[] iArr2 = new int[(i5 * i9)];
            Arrays.fill(iArr2, -1);
            for (i4 = 0; i4 < iArr[1]; i4++) {
                for (i7 = 0; i7 < iArr[0]; i7++) {
                    int i10;
                    int i11;
                    if (bArr[(iArr[0] * i4) + i7] == (byte) 1) {
                        for (i10 = 0; i10 < i6; i10++) {
                            for (i11 = 0; i11 < i3; i11++) {
                                iArr2[((((((i4 * i6) + i8) + i10) * i5) + (i7 * i3)) + i8) + i11] = -16777216;
                            }
                        }
                    } else {
                        for (i10 = 0; i10 < i6; i10++) {
                            for (i11 = 0; i11 < i3; i11++) {
                                iArr2[((((((i4 * i6) + i8) + i10) * i5) + (i7 * i3)) + i8) + i11] = -1;
                            }
                        }
                    }
                }
            }
            createBitmap.setPixels(iArr2, 0, i5, 0, 0, i5, i9);
            if (createBitmap == null) {
                x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[]{Integer.valueOf(a), bi.cjd().toString()});
            } else {
                x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[]{createBitmap});
            }
            return createBitmap;
        }
        x.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[]{Integer.valueOf(a), bi.cjd().toString()});
        return null;
    }
}
