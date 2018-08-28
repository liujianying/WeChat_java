package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;

public final class j {
    private static int dwJ = 0;
    private static final int jBc;
    private static final int jBd;

    static {
        int i;
        int i2 = 960;
        r2 = new int[2];
        Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
        r2[0] = defaultDisplay.getWidth();
        r2[1] = defaultDisplay.getHeight();
        if (r2[0] > 960) {
            i = r2[0];
        } else {
            i = 960;
        }
        jBc = i;
        if (r2[1] > 960) {
            i2 = r2[1];
        }
        jBd = i2;
    }

    public static Bitmap a(long j, int i, String str, String str2) {
        if (c.aRf() == null) {
            return null;
        }
        Bitmap cT;
        switch (i) {
            case 1:
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                cT = cT(str, str2);
                if (cT != null) {
                    return cT;
                }
                x.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s], [%s]", new Object[]{str, str2});
                if (decodeResultLogger.getDecodeResult() < 2000) {
                    return cT;
                }
                h.mEJ.k(12712, KVStatHelper.getKVStatString(str2, 1, decodeResultLogger));
                return cT;
            case 2:
                cT = k(j, str2);
                if (cT == null) {
                    return cT(str, str2);
                }
                return cT;
            default:
                return null;
        }
    }

    private static int aRF() {
        if (dwJ > 0) {
            return dwJ;
        }
        int b = b.b(ad.getContext(), 150.0f);
        dwJ = b;
        return b;
    }

    private static Bitmap cT(String str, String str2) {
        x.d("MicroMsg.MediaManager", "current thread %s", new Object[]{Thread.currentThread().getName()});
        if (bi.oW(str)) {
            x.e("MicroMsg.MediaManager", "filePath is null or nill");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap a = c.a(str, aRF(), aRF(), false, null, 0);
        String str3 = "MicroMsg.MediaManager";
        String str4 = "getImageThumb[%s]FromThumbFilePath, bmp size[%d, %d]: total time:[%dms]";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(a == null ? 0 : a.getWidth());
        objArr[2] = Integer.valueOf(a == null ? 0 : a.getHeight());
        objArr[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        x.v(str3, str4, objArr);
        if (a == null) {
            x.w("MicroMsg.MediaManager", "get bitmap from thumb failed, try to get thumb from orig image:[%s]", new Object[]{str2});
            if (bi.oW(str2)) {
                x.e("MicroMsg.MediaManager", "get bit from orig image faield:[%s]", new Object[]{str2});
            } else {
                currentTimeMillis = System.currentTimeMillis();
                a = c.a(str2, aRF(), aRF(), false, null, 0);
                str3 = "MicroMsg.MediaManager";
                str4 = "getImageThumb[%s]FromOrigFilePath[%s], bmp size[%d, %d]:total time:[%dms]";
                objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = Integer.valueOf(a == null ? 0 : a.getWidth());
                objArr[3] = Integer.valueOf(a == null ? 0 : a.getHeight());
                objArr[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                x.v(str3, str4, objArr);
            }
        }
        if (a != null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Bitmap b = c.b(a, (float) ExifHelper.VX(str2));
            x.d("MicroMsg.MediaManager", "do rotate finish, width[%d] height[%d] rotate[%d] use[%dms]", new Object[]{Integer.valueOf(a.getWidth()), Integer.valueOf(a.getHeight()), Integer.valueOf(r4), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            if (b != null) {
                return b;
            }
        }
        return null;
    }

    public static Bitmap CU(String str) {
        Object obj = 1;
        if (bi.oW(str)) {
            x.e("MicroMsg.MediaManager", "filepath is null or nil");
            return null;
        }
        try {
            if (e.cn(str)) {
                int i = jBc;
                int i2 = jBd;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                if (options.outWidth <= 0 || options.outHeight <= 0) {
                    x.d("MicroMsg.MediaManager", "get bitmap fail, file is not a image file = " + str);
                    return null;
                }
                int i3;
                int i4;
                Object obj2 = (!z.bv(options.outWidth, options.outHeight) || options.outWidth <= 480) ? null : 1;
                if (!z.bu(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                    obj = null;
                }
                if (!(obj2 == null && obj == null)) {
                    i2 = options.outHeight;
                    i = options.outWidth;
                }
                int VX = ExifHelper.VX(str);
                if (VX == 90 || VX == 270) {
                    i3 = i;
                    i4 = i2;
                } else {
                    i3 = i2;
                    i4 = i;
                }
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                Bitmap a = c.a(str, i3, i4, false, decodeResultLogger, 0);
                if (a == null) {
                    x.e("MicroMsg.MediaManager", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                    if (decodeResultLogger.getDecodeResult() >= 2000) {
                        h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 1, decodeResultLogger));
                    }
                    return null;
                }
                a = c.b(a, (float) VX);
                x.i("MicroMsg.MediaManager", "bmp height = " + a.getHeight() + ",bmp width = " + a.getWidth());
                return a;
            }
            x.e("MicroMsg.MediaManager", "getSuitableBmp fail, file does not exist, filePath = " + str);
            return null;
        } catch (Exception e) {
            x.e("MicroMsg.MediaManager", "decode bitmap err: " + e.getMessage());
            return null;
        }
    }

    @TargetApi(8)
    private static Bitmap k(long j, String str) {
        Bitmap thumbnail;
        try {
            thumbnail = Thumbnails.getThumbnail(ad.getContext().getContentResolver(), j, 1, null);
        } catch (Throwable e) {
            x.e("MicroMsg.MediaManager", "exception: %s", new Object[]{bi.i(e)});
            thumbnail = null;
        }
        if (thumbnail == null) {
            x.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", new Object[]{Long.valueOf(j), str});
            if (VERSION.SDK_INT >= 8) {
                thumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            }
            if (thumbnail == null && !bi.oW(str)) {
                x.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", new Object[]{Long.valueOf(j), str});
                ad.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str)));
            }
        }
        return thumbnail;
    }
}
