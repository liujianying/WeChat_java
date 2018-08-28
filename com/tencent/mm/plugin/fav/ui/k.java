package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.m.d;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.b;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class k {
    private static Map<String, a> jaQ = new HashMap();
    private static f<String, Bitmap> jaR = new f(10);
    private static aa<String, Bitmap> jaS = new aa(20);
    public Context context;
    public e jaN;
    public HashMap<String, String[]> jaO = new HashMap();
    private HashMap<String, String[]> jaP = new HashMap();

    static /* synthetic */ boolean BD(String str) {
        if (!new b(str).exists()) {
            a aVar = (a) jaQ.get(str);
            if (aVar == null) {
                jaQ.put(str, new a());
                return true;
            } else if (aVar.Ad() > 30000) {
                x.v("MicroMsg.FavoriteImageLogic", "error diff time");
                aVar.dgA = SystemClock.elapsedRealtime();
                return true;
            }
        }
        return false;
    }

    public k(Context context, int i) {
        this.context = context;
        if (i <= 0) {
            i = 24;
        }
        this.jaN = new e(i);
    }

    public final void destory() {
        e eVar = this.jaN;
        synchronized (eVar.dsN) {
            x.d("MicroMsg.ImageEngine", "do clear mark");
            eVar.qSx.clear();
            eVar.qSy.clear();
            eVar.qSx = new HashMap();
            eVar.qSy = new HashMap();
        }
        this.jaO.clear();
        this.jaP.clear();
        this.jaN.destroy();
        this.context = null;
        this.jaO = null;
        this.jaP = null;
        this.jaN = null;
    }

    public final void a(ImageView imageView, vx vxVar, g gVar, String str, int i, int i2, int i3) {
        String Ba = com.tencent.mm.plugin.fav.a.b.Ba(vxVar.jdM);
        String[] strArr = null;
        if (vxVar.jdM != null) {
            String[] strArr2 = (String[]) this.jaP.get(Ba);
            if (strArr2 == null) {
                strArr = new String[]{com.tencent.mm.plugin.fav.a.b.c(vxVar)};
                this.jaP.put(Ba, strArr);
            } else {
                strArr = strArr2;
            }
        }
        this.jaN.a(imageView, strArr, str, i, i2, i3);
        if (strArr != null && strArr.length > 0) {
            com.tencent.mm.kernel.g.Em().H(new 1(this, strArr[0], gVar, vxVar));
        }
    }

    public final void a(ImageView imageView, vx vxVar, g gVar, int i, int i2, int i3) {
        String str = null;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.zZ()) {
                imageView.setImageResource(d.nosdcard_chatting_bg);
            } else if (gVar != null) {
                wk wkVar;
                switch (gVar.field_type) {
                    case 4:
                    case 16:
                        if (vxVar != null) {
                            a(imageView, vxVar, gVar, vxVar.bJv, i, i2, i3);
                            return;
                        }
                        return;
                    case 5:
                        xa xaVar = gVar.field_favProto.rAN;
                        if (vxVar != null) {
                            String str2;
                            if (xaVar != null) {
                                str = xaVar.thumbUrl;
                            }
                            if (bi.oW(str)) {
                                str2 = vxVar.bJv;
                            } else {
                                str2 = str;
                            }
                            a(imageView, vxVar, gVar, str2, i, i2, i3);
                            return;
                        } else if (xaVar != null) {
                            this.jaN.a(imageView, null, xaVar.thumbUrl, i, i2, i3);
                            return;
                        } else {
                            return;
                        }
                    case 7:
                        if (vxVar != null) {
                            a(imageView, vxVar, gVar, vxVar.bJv, i, i2, i3);
                            return;
                        }
                        return;
                    case 10:
                        wkVar = gVar.field_favProto.rAP;
                        if (wkVar != null) {
                            this.jaN.a(imageView, null, wkVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        wkVar = gVar.field_favProto.rAP;
                        if (wkVar != null) {
                            this.jaN.a(imageView, null, wkVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 15:
                        wu wuVar = gVar.field_favProto.rAR;
                        if (wuVar != null) {
                            this.jaN.a(imageView, null, wuVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        x.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[]{Integer.valueOf(gVar.field_type)});
                        return;
                }
            }
        }
    }

    public final void b(ImageView imageView, vx vxVar, g gVar, int i, int i2, int i3) {
        String str = null;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.zZ()) {
                imageView.setImageResource(d.nosdcard_chatting_bg);
            } else if (gVar == null || vxVar == null) {
                imageView.setImageDrawable(com.tencent.mm.bp.a.f(this.context, i));
            } else {
                wk wkVar;
                switch (vxVar.bjS) {
                    case 4:
                    case 15:
                        a(imageView, vxVar, gVar, vxVar.bJv, i, i2, i3);
                        return;
                    case 5:
                        xa xaVar;
                        String str2;
                        if (vxVar.rAi != null) {
                            xaVar = vxVar.rAi.rAN;
                        } else {
                            x.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{vxVar.jdM, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id)});
                            xaVar = null;
                        }
                        if (xaVar != null) {
                            str = xaVar.thumbUrl;
                        }
                        if (bi.oW(str)) {
                            str2 = vxVar.bJv;
                        } else {
                            str2 = str;
                        }
                        a(imageView, vxVar, gVar, str2, i, i2, i3);
                        return;
                    case 7:
                        a(imageView, vxVar, gVar, vxVar.bJv, i, i2, i3);
                        return;
                    case 10:
                        if (vxVar.rAi == null) {
                            x.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{vxVar.jdM, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id)});
                            return;
                        }
                        wkVar = vxVar.rAi.rAP;
                        if (wkVar != null) {
                            this.jaN.a(imageView, null, wkVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        if (vxVar.rAi == null) {
                            x.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{vxVar.jdM, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id)});
                            return;
                        }
                        wkVar = vxVar.rAi.rAP;
                        if (wkVar != null) {
                            this.jaN.a(imageView, null, wkVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 14:
                        if (vxVar.rAi == null) {
                            x.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{vxVar.jdM, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id)});
                            return;
                        }
                        wu wuVar = vxVar.rAi.rAR;
                        if (wuVar != null) {
                            this.jaN.a(imageView, null, wuVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 19:
                        if (vxVar.rAi == null) {
                            x.w("MicroMsg.FavoriteImageLogic", "app brand: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{vxVar.jdM, Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_id)});
                            return;
                        }
                        vv vvVar = vxVar.rAi.rBa;
                        if (vvVar != null) {
                            this.jaN.a(imageView, null, vvVar.iconUrl, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        x.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[]{Integer.valueOf(gVar.field_type)});
                        return;
                }
            }
        }
    }

    private static Bitmap a(vx vxVar, boolean z, boolean z2) {
        String c;
        if (z) {
            c = com.tencent.mm.plugin.fav.a.b.c(vxVar);
        } else {
            c = com.tencent.mm.plugin.fav.a.b.b(vxVar);
        }
        if (com.tencent.mm.vfs.d.cn(c)) {
            return c.at(c, z2);
        }
        x.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
        return null;
    }

    public static Bitmap b(final vx vxVar, final g gVar, int i) {
        if (!com.tencent.mm.compatible.util.f.zZ()) {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), d.nosdcard_chatting_bg);
        }
        if (vxVar.jdM == null) {
            return null;
        }
        Bitmap bitmap;
        String b = com.tencent.mm.plugin.fav.a.b.b(vxVar);
        if (com.tencent.mm.vfs.d.cn(b)) {
            bitmap = (Bitmap) jaR.get(b);
            if (bitmap != null) {
                x.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", new Object[]{b});
            } else {
                int i2;
                x.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
                Options options = new Options();
                options.inJustDecodeBounds = true;
                bitmap = BitmapFactory.decodeFile(b, options);
                if (bitmap != null) {
                    x.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", new Object[]{bitmap});
                    bitmap.recycle();
                }
                int i3 = options.outWidth;
                int i4 = options.outHeight;
                x.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                if (i3 > i) {
                    i4 = (options.outHeight * i) / options.outWidth;
                } else {
                    i = i3;
                }
                int max = Math.max(1, i);
                i3 = Math.max(1, i4);
                x.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(max), Integer.valueOf(i3)});
                int VX = ExifHelper.VX(b);
                if (VX == 90 || VX == 270) {
                    i4 = max;
                    i2 = i3;
                } else {
                    i4 = i3;
                    i2 = max;
                }
                bitmap = c.e(b, i4, i2, false);
                if (bitmap == null) {
                    x.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = " + b);
                    bitmap = null;
                } else {
                    bitmap = c.b(bitmap, (float) VX);
                    jaR.put(b, bitmap);
                }
            }
        } else {
            x.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        final String b2 = com.tencent.mm.plugin.fav.a.b.b(vxVar);
        com.tencent.mm.kernel.g.Em().H(new Runnable() {
            final /* synthetic */ boolean jaU = false;

            public final void run() {
                if (this.jaU || k.BD(b2)) {
                    com.tencent.mm.plugin.fav.a.b.a(gVar, vxVar, this.jaU);
                }
            }

            public final String toString() {
                return super.toString() + "|getBigImg";
            }
        });
        return bitmap;
    }

    public static Bitmap j(vx vxVar) {
        if (!com.tencent.mm.compatible.util.f.zZ()) {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), d.nosdcard_chatting_bg);
        }
        if (vxVar.jdM == null) {
            return null;
        }
        return a(vxVar, false, true);
    }

    public static Bitmap a(final vx vxVar, final g gVar, final boolean z) {
        if (!com.tencent.mm.compatible.util.f.zZ()) {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), d.nosdcard_chatting_bg);
        }
        if (vxVar.jdM == null) {
            return null;
        }
        Bitmap a = a(vxVar, false, false);
        if (a != null) {
            return a;
        }
        final String b = com.tencent.mm.plugin.fav.a.b.b(vxVar);
        com.tencent.mm.kernel.g.Em().H(new Runnable() {
            public final void run() {
                if (z || k.BD(b)) {
                    com.tencent.mm.plugin.fav.a.b.a(gVar, vxVar, z);
                }
            }

            public final String toString() {
                return super.toString() + "|getBigImg";
            }
        });
        return a;
    }

    public static Bitmap a(vx vxVar, g gVar) {
        if (!com.tencent.mm.compatible.util.f.zZ()) {
            return BitmapFactory.decodeResource(ad.getContext().getResources(), d.nosdcard_chatting_bg);
        }
        if (com.tencent.mm.plugin.fav.a.b.Ba(vxVar.jdM) == null) {
            return null;
        }
        Bitmap a = a(vxVar, true, false);
        if (a != null) {
            return a;
        }
        com.tencent.mm.kernel.g.Em().H(new 5(com.tencent.mm.plugin.fav.a.b.c(vxVar), gVar, vxVar));
        return a;
    }

    public static Bitmap b(String str, int i, int i2, boolean z) {
        boolean z2 = false;
        if (com.tencent.mm.vfs.d.cn(str)) {
            Bitmap bitmap = (Bitmap) jaS.get(str);
            if (bitmap != null || z) {
                String str2 = "MicroMsg.FavoriteImageLogic";
                String str3 = "return bm path %s, bm %s";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                if (bitmap != null) {
                    z2 = true;
                }
                objArr[1] = Boolean.valueOf(z2);
                x.d(str2, str3, objArr);
                return bitmap;
            }
            try {
                int i3;
                int i4;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                c.decodeFile(str, options);
                int i5 = options.outWidth;
                int i6 = options.outHeight;
                int VX = ExifHelper.VX(str);
                if (VX == 90 || VX == 270) {
                    i3 = i5;
                    i4 = i6;
                    z2 = true;
                } else {
                    i3 = i6;
                    i4 = i5;
                }
                options.inSampleSize = 1;
                while (i3 / options.inSampleSize > i2 && i4 / options.inSampleSize > i) {
                    options.inSampleSize++;
                }
                int i7 = (i4 * i2) / i;
                x.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i7), Boolean.valueOf(z2)});
                if (i7 <= 0 || i3 <= i7) {
                    options.inJustDecodeBounds = false;
                    bitmap = c.decodeFile(str, options);
                } else {
                    Rect rect = new Rect();
                    rect.top = 0;
                    rect.left = 0;
                    if (z2) {
                        rect.right = i7;
                        rect.bottom = i4;
                    } else {
                        rect.right = i4;
                        rect.bottom = i7;
                    }
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(str, true);
                    options.inJustDecodeBounds = false;
                    bitmap = newInstance.decodeRegion(rect, options);
                }
                if (bitmap != null && z2) {
                    bitmap = c.b(bitmap, (float) VX);
                }
                if (bitmap != null) {
                    x.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(i2)});
                    jaS.put(str, bitmap);
                    return bitmap;
                }
                x.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
                return bitmap;
            } catch (IOException e) {
                x.e("MicroMsg.FavoriteImageLogic", e.getMessage());
                return bitmap;
            }
        }
        x.w("MicroMsg.FavoriteImageLogic", "file not exist");
        return null;
    }

    public static void a(ImageView imageView, int i, vx vxVar, g gVar, boolean z, int i2, int i3) {
        if (!com.tencent.mm.compatible.util.f.zZ()) {
            imageView.setImageBitmap(BitmapFactory.decodeResource(ad.getContext().getResources(), d.nosdcard_chatting_bg));
        }
        if (vxVar.jdM == null) {
            imageView.setImageResource(i);
        }
        Bitmap a = a(vxVar, gVar);
        String b = com.tencent.mm.plugin.fav.a.b.b(vxVar);
        if (com.tencent.mm.vfs.d.cn(b)) {
            a = b(b, i2, i3, true);
        }
        if (a == null) {
            imageView.setImageResource(i);
            imageView.setTag(b);
            com.tencent.mm.kernel.g.Em().H(new 6(b, i2, i3, gVar, vxVar, z, imageView));
            return;
        }
        imageView.setImageBitmap(a);
    }

    private static void b(final g gVar, final vx vxVar, final boolean z) {
        final String b = com.tencent.mm.plugin.fav.a.b.b(vxVar);
        com.tencent.mm.kernel.g.Em().H(new Runnable() {
            public final void run() {
                if (z || k.BD(b)) {
                    com.tencent.mm.plugin.fav.a.b.a(gVar, vxVar, z);
                }
            }

            public final String toString() {
                return super.toString() + "|reDownload";
            }
        });
    }

    public static void b(g gVar, vx vxVar) {
        b(gVar, vxVar, true);
    }
}
