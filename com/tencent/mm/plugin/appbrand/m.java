package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class m {
    public static boolean f(Context context, String str, int i) {
        if (context == null || str == null) {
            x.e("MicroMsg.AppBrandShortcutManager", "add fail, invalid argument");
            return false;
        }
        bs bsVar = new bs();
        bsVar.bJc.username = str;
        a.sFg.m(bsVar);
        if (bsVar.bJd.bJe == null) {
            x.e("MicroMsg.AppBrandShortcutManager", "no such user");
            return false;
        }
        Bitmap a = a(bsVar);
        if (a == null) {
            x.i("MicroMsg.AppBrandShortcutManager", "bitmap do not exist, delay get.");
            return true;
        }
        Intent a2 = a(context, bsVar, i, a(context, a, i), true);
        if (a2 == null) {
            x.e("MicroMsg.AppBrandShortcutManager", "add fail, intent is null");
            return false;
        }
        String bT;
        if (((Intent) a2.getParcelableExtra("android.intent.extra.shortcut.INTENT")) != null) {
            bT = b.bT(bsVar.bJd.appId + String.valueOf(i), q.zy());
            if (bT != null) {
                bT = b.aa(bT.getBytes());
            } else {
                bT = null;
            }
            x.i("MicroMsg.AppBrandShortcutManager", "alvinluo appId: %s, shortcutId: %s", new Object[]{r4, bT});
        } else {
            bT = null;
        }
        b.a(context, a2, bT, true);
        x.i("MicroMsg.AppBrandShortcutManager", "add shortcut %s", new Object[]{str});
        return true;
    }

    public static Intent a(Context context, bs bsVar, int i, Bitmap bitmap, boolean z) {
        if (context == null || bsVar.bJc.username == null) {
            x.e("MicroMsg.AppBrandShortcutManager", "buildIntent, wrong parameters");
            return null;
        } else if (bitmap == null && z) {
            x.e("MicroMsg.AppBrandShortcutManager", "no bmp");
            return null;
        } else {
            String str = bsVar.bJc.username;
            String str2 = TextUtils.isEmpty(bsVar.bJd.nickname) ? str : bsVar.bJd.nickname;
            String str3 = bsVar.bJd.appId;
            String wP = c.wP(str);
            if (bi.oW(wP)) {
                return null;
            }
            str = z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT";
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : bsVar.bJd.bJe) {
                stringBuilder.append(append);
            }
            String u = g.u((str2 + stringBuilder.toString()).getBytes());
            Intent intent = new Intent(str);
            intent.putExtra("android.intent.extra.shortcut.NAME", str2);
            intent.putExtra("duplicate", false);
            Parcelable intent2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
            intent2.putExtra("type", 1);
            intent2.putExtra("id", wP);
            intent2.putExtra("ext_info", c.wP(str3));
            StringBuilder stringBuilder2 = new StringBuilder();
            com.tencent.mm.kernel.g.Eg();
            intent2.putExtra("token", c.bU(str3, stringBuilder2.append(com.tencent.mm.kernel.a.Df()).toString()));
            intent2.putExtra("digest", u);
            intent2.putExtra("ext_info_1", i);
            intent2.setPackage(context.getPackageName());
            intent2.addFlags(67108864);
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            intent.putExtra("shortcut_is_adaptive_icon", true);
            return intent;
        }
    }

    public static Bitmap a(bs bsVar) {
        for (String str : bsVar.bJd.bJe) {
            if (!bi.oW(str)) {
                Bitmap a = com.tencent.mm.modelappbrand.b.b.Ka().a(str, null);
                if (!(a == null || a.isRecycled())) {
                    return a;
                }
            }
        }
        return null;
    }

    public static Bitmap a(Context context, Bitmap bitmap, int i) {
        Bitmap bitmap2 = null;
        if (!(context == null || bitmap == null || bitmap.isRecycled())) {
            int density = (int) (com.tencent.mm.bp.a.getDensity(context) * 48.0f);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, density, density, false);
            if (createScaledBitmap != null) {
                bitmap2 = createScaledBitmap.copy(Config.ARGB_8888, true);
                createScaledBitmap.recycle();
            }
            if (i == 2) {
                a(context, bitmap2, com.tencent.mm.bp.a.af(context, j.app_brand_shortcut_tag_beta));
            } else if (i == 1) {
                a(context, bitmap2, com.tencent.mm.bp.a.af(context, j.app_brand_shortcut_tag_dev));
            }
        }
        return bitmap2;
    }

    private static void a(Context context, Bitmap bitmap, String str) {
        if (context != null && bitmap != null && !bitmap.isRecycled() && !bi.oW(str)) {
            RectF rectF;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float density = com.tencent.mm.bp.a.getDensity(context);
            float f = density * 4.0f;
            float f2 = density * 2.0f;
            density *= 6.0f;
            Paint paint = new Paint();
            paint.setTextSize(density);
            paint.setFakeBoldText(true);
            paint.setAntiAlias(true);
            float measureText = paint.measureText(str);
            FontMetrics fontMetrics = paint.getFontMetrics();
            float f3 = fontMetrics.bottom - fontMetrics.top;
            paint.setColor(Color.parseColor("#459AE9"));
            Canvas canvas = new Canvas(bitmap);
            if (VERSION.SDK_INT < 26) {
                rectF = new RectF((((float) width) - measureText) - (f * 2.0f), (((float) height) - f3) - (f2 * 2.0f), (float) width, (float) height);
            } else {
                rectF = new RectF(0.0f, (((float) height) - f3) - (f2 * 2.0f), measureText + (f * 2.0f), (float) height);
            }
            canvas.drawRoundRect(rectF, 4.0f, 4.0f, paint);
            paint.setColor(-1);
            canvas.drawText(str, rectF.left + f, (rectF.top + f2) - fontMetrics.ascent, paint);
        }
    }
}
