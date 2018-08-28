package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.content.d;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import java.io.File;
import java.net.URI;

public final class ad {
    private static Typeface nGd = null;

    public static Bitmap getBitmap(String str) {
        String str2 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str3 = str2 + "/" + ("adId" + "_image_" + ac.ce(str));
        if (FileOp.cn(str3)) {
            return b.e(str3, 1.0f);
        }
        return null;
    }

    public static int au(float f) {
        int i = (int) f;
        if (((double) (f - ((float) i))) > 0.001d) {
            return i + 1;
        }
        return i;
    }

    public static int[] ee(Context context) {
        int i;
        int i2;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            i = point.x;
            i2 = point.y;
        } else {
            i = defaultDisplay.getWidth();
            i2 = defaultDisplay.getHeight();
        }
        return new int[]{i, i2};
    }

    public static void I(Activity activity) {
        x.i("LandingPageUtil", "setFullScreen");
        int i = 514;
        if (ak.gw(activity)) {
            x.i("LandingPageUtil", "has cut out");
        } else {
            i = 1542;
        }
        if (VERSION.SDK_INT >= 19) {
            i |= 4096;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(i);
    }

    public static void J(Activity activity) {
        x.i("LandingPageUtil", "exitFullScreen");
        activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() & -1543);
    }

    public static void ef(Context context) {
        d.O(context).a(new Intent("com.tencent.mm.adlanding.set_uioption"));
    }

    public static String l(String str, String... strArr) {
        try {
            URI uri = new URI(str);
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : strArr) {
                stringBuilder.append(append).append("&");
            }
            if (stringBuilder.length() <= 1) {
                return str;
            }
            String stringBuilder2;
            StringBuilder deleteCharAt = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            String query = uri.getQuery();
            if (query == null) {
                stringBuilder2 = deleteCharAt.toString();
            } else {
                stringBuilder2 = query + "&" + deleteCharAt.toString();
            }
            return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuilder2, uri.getFragment()).toString();
        } catch (Throwable e) {
            x.printErrStackTrace("LandingPageUtil", e, "", new Object[0]);
            return str;
        }
    }

    public static String Na(String str) {
        if (bi.oW(str)) {
            return "";
        }
        if (!str.contains("_")) {
            return str;
        }
        String[] split = str.split("_");
        if (split.length > 0) {
            return split[split.length - 1];
        }
        return str;
    }

    public static Typeface eg(Context context) {
        if (nGd == null) {
            nGd = Typeface.createFromAsset(context.getAssets(), "fonts/WeChatNum.ttf");
        }
        return nGd;
    }

    public static boolean Nb(String str) {
        return str != null && str.length() >= 102400;
    }

    public static String Nc(String str) {
        if (bi.oW(str)) {
            return "";
        }
        File file = new File(com.tencent.mm.loader.stub.b.duO.replace("/data/user/0", "/data/data"), "tmpLargeCanvasDir");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            String absolutePath = new File(file, System.currentTimeMillis()).getAbsolutePath();
            if (e.b(absolutePath, bytes, bytes.length) == 0) {
                return absolutePath;
            }
        } catch (Exception e) {
            x.e("LandingPageUtil", "writeTempCanvasXmlToLocal fail");
        }
        return "";
    }

    public static String Nd(String str) {
        if (bi.oW(str)) {
            return "";
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            String ct = e.ct(str);
            file.delete();
            return ct;
        } catch (Exception e) {
            x.e("LandingPageUtil", "readTempCanvasXmlFromLocalAndDeleteIt fail");
            return "";
        }
    }
}
