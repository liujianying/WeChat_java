package com.tencent.mm.bp;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static float density = -1.0f;
    private static a sCx = null;
    private static SparseIntArray sCy = new SparseIntArray();
    private static float scale = 0.0f;

    public interface a {
        ColorStateList cgA();

        Drawable cgB();

        int cgC();

        String cgD();

        int cgz();
    }

    public static int g(Context context, int i) {
        if (sCx != null) {
            return sCx.cgz();
        }
        if (context != null) {
            return context.getResources().getColor(i);
        }
        x.e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", Integer.valueOf(i));
        return 0;
    }

    public static ColorStateList ac(Context context, int i) {
        if (sCx != null) {
            return sCx.cgA();
        }
        if (context != null) {
            return context.getResources().getColorStateList(i);
        }
        x.e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", Integer.valueOf(i));
        return null;
    }

    public static Drawable f(Context context, int i) {
        if (sCx != null) {
            return sCx.cgB();
        }
        if (context != null) {
            return context.getResources().getDrawable(i);
        }
        x.e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", Integer.valueOf(i));
        return null;
    }

    public static int ad(Context context, int i) {
        float f = 1.625f;
        float f2 = scale;
        if (f2 <= 1.625f) {
            f = f2;
        }
        int i2;
        if (sCx != null) {
            i2 = sCy.get(i, 0);
            if (i2 == 0) {
                i2 = sCx.cgC();
                sCy.put(i, i2);
            }
            return (int) (f * ((float) i2));
        } else if (context == null) {
            x.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            return 0;
        } else {
            i2 = sCy.get(i, 0);
            if (i2 == 0) {
                i2 = context.getResources().getDimensionPixelSize(i);
                sCy.put(i, i2);
            }
            return (int) (f * ((float) i2));
        }
    }

    public static int ae(Context context, int i) {
        int i2;
        if (sCx != null) {
            i2 = sCy.get(i, 0);
            if (i2 != 0) {
                return i2;
            }
            i2 = sCx.cgC();
            sCy.put(i, i2);
            return i2;
        } else if (context == null) {
            x.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            return 0;
        } else {
            i2 = sCy.get(i, 0);
            if (i2 != 0) {
                return i2;
            }
            i2 = context.getResources().getDimensionPixelSize(i);
            sCy.put(i, i2);
            return i2;
        }
    }

    public static String af(Context context, int i) {
        if (sCx != null) {
            return sCx.cgD();
        }
        if (context != null) {
            return context.getResources().getString(i);
        }
        x.e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", Integer.valueOf(i));
        return "";
    }

    public static float getDensity(Context context) {
        if (context == null) {
            context = ad.getContext();
        }
        if (density < 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static int fromDPToPix(Context context, int i) {
        return Math.round(getDensity(context) * ((float) i));
    }

    public static int ag(Context context, int i) {
        return Math.round(((float) i) / getDensity(context));
    }

    public static float fe(Context context) {
        if (scale == 0.0f) {
            if (context == null) {
                scale = 1.0f;
            } else {
                scale = context.getSharedPreferences(ad.chY(), 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        return scale;
    }

    public static int ff(Context context) {
        float fe = fe(context);
        if (fe == 0.875f) {
            return 1;
        }
        if (fe == 1.0f) {
            return 2;
        }
        if (fe == 1.125f) {
            return 3;
        }
        if (fe == 1.25f) {
            return 4;
        }
        if (fe == 1.375f) {
            return 5;
        }
        if (fe == 1.625f) {
            return 6;
        }
        if (fe == 1.875f) {
            return 7;
        }
        if (fe == 2.025f) {
            return 8;
        }
        return 2;
    }

    public static float fg(Context context) {
        if (fi(context)) {
            return 1.3f;
        }
        return 1.0f;
    }

    public static float fh(Context context) {
        if (fi(context)) {
            return 1.2f;
        }
        return 1.0f;
    }

    public static void g(Context context, float f) {
        Editor edit = context.getSharedPreferences(ad.chY(), 0).edit();
        edit.putFloat("text_size_scale_key", f);
        edit.commit();
        scale = f;
    }

    public static boolean fi(Context context) {
        float fe = fe(context);
        scale = fe;
        return Float.compare(fe, 1.125f) > 0;
    }

    public static boolean fj(Context context) {
        float fe = fe(context);
        scale = fe;
        if (fe == 0.875f) {
            return true;
        }
        return false;
    }

    public static int fk(Context context) {
        if (sCx != null) {
            return 0;
        }
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        x.e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
        return 0;
    }

    public static int fl(Context context) {
        if (sCx != null) {
            return 0;
        }
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        x.e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
        return 0;
    }
}
