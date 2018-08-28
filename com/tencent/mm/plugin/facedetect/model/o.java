package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.mm.a.e;
import com.tencent.mm.bk.b;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.model.a.a;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.protocal.c.hm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class o {
    public static String a(FaceResult faceResult) {
        if (faceResult == null || faceResult.result != 0) {
            x.e("MicroMsg.FaceUtils", "alvinluo face result is null or result code not 0");
            return null;
        }
        try {
            String str = aJX() + File.separator + "release_out.fd";
            hm hmVar = new hm();
            hmVar.rih = b.bi(faceResult.sidedata);
            hmVar.rii = b.bi(faceResult.data);
            byte[] toByteArray = hmVar.toByteArray();
            try {
                if (FileOp.mM(str)) {
                    FileOp.l(str, toByteArray);
                    return str;
                }
                x.e("MicroMsg.FaceUtils", "hy: create file failed!");
                return str;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in save debug jpeg", new Object[0]);
                return str;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.FaceUtils", e2, "", new Object[0]);
            return null;
        }
    }

    public static Bitmap AT(String str) {
        try {
            if (bi.oW(str)) {
                x.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
                return null;
            }
            String str2 = a.iNg + ac.ce(str);
            if (new File(str2).exists()) {
                byte[] e = FileOp.e(str2, 0, -1);
                if (e != null) {
                    e = a.f(e, AU(str));
                    if (e.length > 0) {
                        return com.tencent.mm.compatible.g.a.decodeByteArray(e, 0, e.length);
                    }
                    x.w("MicroMsg.FaceUtils", "hy: decrypt err. return null");
                    return null;
                }
                x.w("MicroMsg.FaceUtils", "hy: nothing in file");
                return null;
            }
            x.w("MicroMsg.FaceUtils", "hy: no last file. return");
            return null;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.FaceUtils", e2, "hy: err in encrypt", new Object[0]);
            return null;
        }
    }

    public static boolean b(Bitmap bitmap, String str) {
        if (bitmap == null) {
            try {
                x.w("MicroMsg.FaceUtils", "hy: bm is null. abort");
                return false;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in encrypt", new Object[0]);
                return false;
            }
        } else if (bi.oW(str)) {
            x.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
            return false;
        } else {
            File file = new File(a.iNg);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = a.iNg + ac.ce(str);
            File file2 = new File(str2);
            if (!file2.exists()) {
                x.i("MicroMsg.FaceUtils", "hy: last file already exists. del");
                file2.createNewFile();
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (toByteArray != null) {
                byte[] f = a.f(toByteArray, AU(str));
                if (f.length <= 0) {
                    x.w("MicroMsg.FaceUtils", "hy: enc err. return null");
                    return false;
                }
                FileOp.l(str2, f);
                return true;
            }
            x.w("MicroMsg.FaceUtils", "hy: nothing in stream");
            return false;
        }
    }

    private static String AU(String str) {
        return Base64.encodeToString((str + str.hashCode()).getBytes(), 0);
    }

    public static boolean q(Activity activity) {
        boolean bj = com.tencent.mm.pluginsdk.permission.a.bj(activity, "android.permission.CAMERA");
        boolean bj2 = com.tencent.mm.pluginsdk.permission.a.bj(activity, "android.permission.RECORD_AUDIO");
        x.d("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], checkAudio[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(bj), Boolean.valueOf(bj2), bi.cjd(), activity});
        ArrayList arrayList = new ArrayList();
        if (!bj) {
            arrayList.add("android.permission.CAMERA");
        }
        if (!bj2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (bj && bj2) {
            return true;
        }
        x.i("MicroMsg.FaceUtils", "hy: above 23 and no permission. requesting...");
        android.support.v4.app.a.a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 23);
        return false;
    }

    public static void r(Activity activity) {
        activity.getWindow().setFlags(1024, 1024);
    }

    public static boolean aJW() {
        boolean z;
        String aJY = aJY();
        String aJZ = aJZ();
        if (bi.oW(aJY) || bi.oW(aJZ)) {
            x.w("MicroMsg.FaceUtils", "hy: not valid model path. start ");
            z = false;
        } else {
            File file = new File(aJY);
            File file2 = new File(aJZ);
            if (file.exists() || pz(0)) {
                z = true;
            } else {
                x.e("MicroMsg.FaceUtils", "hy: no detect model in storage and sdcard");
                z = false;
            }
            if (!(file2.exists() || pz(1))) {
                x.e("MicroMsg.FaceUtils", "hy: no alignment model in storage and sdcard");
                z = false;
            }
        }
        if (!z) {
            x.i("MicroMsg.FaceUtils", "hy: trigger start download model file");
            g.DF().a(new m(42), 0);
        }
        return z;
    }

    public static String aJX() {
        String str;
        if (a.iNe) {
            str = h.getExternalStorageDirectory().getAbsolutePath() + File.separator + "face_detect";
        } else {
            str = ad.getContext().getFilesDir().getParent() + File.separator + "face_detect";
        }
        File file = new File(str);
        if (!file.exists()) {
            x.i("MicroMsg.FaceUtils", "hy: face dir not exist. mk dir");
            file.mkdirs();
        }
        return str;
    }

    public static String aJY() {
        return aJX() + File.separator + "ufdmtcc.bin";
    }

    public static String aJZ() {
        return aJX() + File.separator + "ufat.bin";
    }

    public static boolean pz(int i) {
        String str = "";
        switch (i) {
            case 0:
                str = at.dBv.I("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", "");
                break;
            case 1:
                str = at.dBv.I("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", "");
                break;
        }
        if (bi.oW(str)) {
            x.w("MicroMsg.FaceUtils", "hy: no such path for type: %d", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (new File(str).exists()) {
            File file = new File(pA(i));
            if (file.exists()) {
                file.delete();
            }
            e.y(str, pA(i));
            return true;
        } else {
            x.e("MicroMsg.FaceUtils", "originFile file not exist");
            return false;
        }
    }

    public static String pA(int i) {
        switch (i) {
            case 0:
                return aJY();
            case 1:
                return aJZ();
            default:
                return "";
        }
    }

    public static void p(Context context, String str, String str2) {
        Throwable e;
        x.i("MicroMsg.FaceUtils", "alvinluo copyFileFromAssets src: %s, dst: %s", new Object[]{str, str2});
        InputStream open;
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str2);
            open = context.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    x.i("MicroMsg.FaceUtils", "alvinluo copyFileFromAssets %s successfully, file len: %d", new Object[]{str, Long.valueOf(file.length())});
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    fileOutputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.FaceUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Exception e4) {
                                return;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Exception e5) {
                                throw e;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                x.printErrStackTrace("MicroMsg.FaceUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e42) {
                        return;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e52) {
                        throw e;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            fileOutputStream = null;
            open = null;
        } catch (Throwable th3) {
            e = th3;
            fileOutputStream = null;
            open = null;
            if (open != null) {
                try {
                    open.close();
                } catch (Exception e522) {
                    throw e;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
    }

    public static Bitmap o(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap == null) {
            bitmap2 = null;
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            bitmap2 = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * 0.1f), Math.round(((float) bitmap.getHeight()) * 0.1f), false);
            bitmap2 = bitmap2.copy(bitmap2.getConfig(), true);
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            int[] iArr = new int[(width * height)];
            x.e("pix", width + " " + height + " " + iArr.length);
            bitmap2.getPixels(iArr, 0, width, 0, 0, width, height);
            int i = width - 1;
            int i2 = height - 1;
            int i3 = width * height;
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            int[] iArr4 = new int[i3];
            int[] iArr5 = new int[Math.max(width, height)];
            int[] iArr6 = new int[246016];
            for (int i4 = 0; i4 < 246016; i4++) {
                iArr6[i4] = i4 / 961;
            }
            int i5 = 0;
            int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{61, 3});
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int i8 = i5;
                int i9 = i6;
                int i10;
                int i11;
                int i12;
                int i13;
                int i14;
                int i15;
                int i16;
                int i17;
                int i18;
                if (i9 < height) {
                    i10 = 0;
                    if (b.de(currentTimeMillis2)) {
                        bitmap2 = null;
                        break;
                    }
                    int[] iArr8;
                    i5 = 0;
                    i6 = 0;
                    i11 = 0;
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    i15 = 0;
                    i16 = 0;
                    while (true) {
                        i17 = i10;
                        if (-30 > 30) {
                            break;
                        }
                        i10 = iArr[Math.min(i, Math.max(-30, 0)) + i8];
                        iArr8 = iArr7[-30 + 30];
                        iArr8[0] = (16711680 & i10) >> 16;
                        iArr8[1] = (65280 & i10) >> 8;
                        iArr8[2] = i10 & 255;
                        i10 = 31 - Math.abs(-30);
                        i17 += iArr8[0] * i10;
                        i16 += iArr8[1] * i10;
                        i15 += i10 * iArr8[2];
                        if (-30 > null) {
                            i11 += iArr8[0];
                            i6 += iArr8[1];
                            i5 += iArr8[2];
                        } else {
                            i14 += iArr8[0];
                            i13 += iArr8[1];
                            i12 += iArr8[2];
                        }
                        i10 = -30 + 1;
                    }
                    i10 = 30;
                    if (b.de(currentTimeMillis2)) {
                        bitmap2 = null;
                        break;
                    }
                    for (i18 = 0; i18 < width; i18++) {
                        iArr2[i8] = iArr6[i17];
                        iArr3[i8] = iArr6[i16];
                        iArr4[i8] = iArr6[i15];
                        i17 -= i14;
                        i16 -= i13;
                        i15 -= i12;
                        iArr8 = iArr7[((i10 - 30) + 61) % 61];
                        i14 -= iArr8[0];
                        i13 -= iArr8[1];
                        i12 -= iArr8[2];
                        if (i9 == 0) {
                            iArr5[i18] = Math.min((i18 + 30) + 1, i);
                        }
                        int i19 = iArr[iArr5[i18] + i7];
                        iArr8[0] = (16711680 & i19) >> 16;
                        iArr8[1] = (65280 & i19) >> 8;
                        iArr8[2] = i19 & 255;
                        i11 += iArr8[0];
                        i6 += iArr8[1];
                        i5 += iArr8[2];
                        i17 += i11;
                        i16 += i6;
                        i15 += i5;
                        i10 = (i10 + 1) % 61;
                        iArr8 = iArr7[i10 % 61];
                        i14 += iArr8[0];
                        i13 += iArr8[1];
                        i12 += iArr8[2];
                        i11 -= iArr8[0];
                        i6 -= iArr8[1];
                        i5 -= iArr8[2];
                        i8++;
                    }
                    i5 = i7 + width;
                    i6 = i9 + 1;
                } else {
                    for (i18 = 0; i18 < width; i18++) {
                        i10 = 0;
                        i5 = width * -30;
                        if (b.de(currentTimeMillis2)) {
                            bitmap2 = null;
                            break;
                        }
                        i6 = 0;
                        i11 = 0;
                        i12 = 0;
                        i13 = 0;
                        i14 = 0;
                        i8 = 0;
                        i17 = 0;
                        i7 = 0;
                        while (true) {
                            i9 = i10;
                            if (-30 > 30) {
                                break;
                            }
                            i10 = Math.max(0, i5) + i18;
                            int[] iArr9 = iArr7[-30 + 30];
                            iArr9[0] = iArr2[i10];
                            iArr9[1] = iArr3[i10];
                            iArr9[2] = iArr4[i10];
                            i = 31 - Math.abs(-30);
                            i9 += iArr2[i10] * i;
                            i7 += iArr3[i10] * i;
                            i17 += iArr4[i10] * i;
                            if (-30 > null) {
                                i12 += iArr9[0];
                                i11 += iArr9[1];
                                i6 += iArr9[2];
                            } else {
                                i8 += iArr9[0];
                                i14 += iArr9[1];
                                i13 += iArr9[2];
                            }
                            if (-30 < i2) {
                                i5 += width;
                            }
                            i10 = -30 + 1;
                        }
                        i15 = 30;
                        if (b.de(currentTimeMillis2)) {
                            bitmap2 = null;
                            break;
                        }
                        i16 = 0;
                        i5 = i6;
                        i10 = i18;
                        while (i16 < height) {
                            iArr[i10] = (((-16777216 & iArr[i10]) | (iArr6[i9] << 16)) | (iArr6[i7] << 8)) | iArr6[i17];
                            i6 = i9 - i8;
                            i7 -= i14;
                            i17 -= i13;
                            int[] iArr10 = iArr7[((i15 - 30) + 61) % 61];
                            i8 -= iArr10[0];
                            i14 -= iArr10[1];
                            i13 -= iArr10[2];
                            if (i18 == 0) {
                                iArr5[i16] = Math.min(i16 + 31, i2) * width;
                            }
                            i = iArr5[i16] + i18;
                            iArr10[0] = iArr2[i];
                            iArr10[1] = iArr3[i];
                            iArr10[2] = iArr4[i];
                            i12 += iArr10[0];
                            i11 += iArr10[1];
                            i5 += iArr10[2];
                            i9 = i6 + i12;
                            i7 += i11;
                            i17 += i5;
                            i15 = (i15 + 1) % 61;
                            int[] iArr11 = iArr7[i15];
                            i8 += iArr11[0];
                            i14 += iArr11[1];
                            i13 += iArr11[2];
                            i12 -= iArr11[0];
                            i5 -= iArr11[2];
                            i10 += width;
                            i16++;
                            i11 -= iArr11[1];
                        }
                    }
                    x.e("pix", width + " " + height + " " + i3);
                    bitmap2.setPixels(iArr, 0, width, 0, 0, width, height);
                }
            }
        }
        x.i("MicroMsg.FaceUtils", "hy: blur using %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        Object obj = 1;
        if (bitmap2 == null) {
            x.w("MicroMsg.FaceUtils", "hy: null on blur. use default");
            obj = null;
            bitmap2 = AT(str);
            if (bitmap2 == null) {
                bitmap2 = c.CV(d.face_black);
            }
        }
        if (obj != null) {
            com.tencent.mm.sdk.f.e.post(new 1(bitmap2, str), "FaceUtils_SaveFile");
        }
        return bitmap2;
    }

    public static String AV(String str) {
        return com.tencent.mm.a.g.u((bi.VG() + ", " + str).getBytes());
    }
}
