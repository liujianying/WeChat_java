package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;

public final class ak {
    private static Rect tqL = new Rect(0, 0, 0, 0);

    @TargetApi(21)
    public static ViewGroup a(Window window, View view) {
        ViewGroup viewGroup = null;
        if (window == null) {
            return null;
        }
        ViewGroup f = f(window);
        if (f != null) {
            return f;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            while (parent != window.getDecorView() && parent != null) {
                ViewParent viewGroup2 = parent;
                parent = parent.getParent();
            }
            f = viewGroup2;
        } else {
            f = null;
        }
        if (f == null) {
            View childAt = ((ViewGroup) window.getDecorView()).getChildAt(0);
            if (childAt instanceof ViewGroup) {
                return (ViewGroup) childAt;
            }
            if (VERSION.SDK_INT >= 21) {
                window.clearFlags(Integer.MIN_VALUE);
            }
        }
        return f;
    }

    private static ViewGroup f(Window window) {
        Throwable e;
        if (VERSION.SDK_INT >= 21) {
            c cVar = new c(window, "mContentRoot", null);
            if (cVar.zR()) {
                try {
                    return (ViewGroup) cVar.get();
                } catch (NoSuchFieldException e2) {
                    e = e2;
                } catch (IllegalAccessException e3) {
                    e = e3;
                } catch (IllegalArgumentException e4) {
                    e = e4;
                }
            }
        }
        return null;
        x.printErrStackTrace("MicroMsg.UIUtils", e, "", new Object[0]);
        return null;
    }

    @TargetApi(20)
    public static boolean d(final View view, final View view2) {
        if (!d.fR(21)) {
            return true;
        }
        if (view == null || !(view instanceof ViewGroup) || view2 == null || !(view.getLayoutParams() instanceof MarginLayoutParams)) {
            return false;
        }
        view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                ak.z(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                return view.onApplyWindowInsets(windowInsets);
            }
        });
        return true;
    }

    public static void z(int i, int i2, int i3, int i4) {
        tqL.set(i, i2, i3, i4);
    }

    public static Rect cqU() {
        return tqL;
    }

    public static int gs(Context context) {
        if (gt(context)) {
            int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                return Resources.getSystem().getDimensionPixelSize(identifier);
            }
        }
        return 0;
    }

    @TargetApi(17)
    public static boolean gt(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point gu = gu(context);
        return Math.max(gu.y, gu.x) > Math.max(point.y, point.x);
    }

    public static Point gu(Context context) {
        Point point = new Point();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            if (VERSION.SDK_INT >= 14) {
                try {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception e) {
                }
            }
            defaultDisplay.getSize(point);
        }
        return point;
    }

    public static void a(Window window) {
        if (window != null && VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public static void g(Window window) {
        if (window != null && window.getDecorView() != null && VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
        }
    }

    public static int AD(int i) {
        return ((((((int) ((((float) ((i >> 24) & 255)) * 0.78f) + 56.100006f)) & 255) << 24) | ((((int) ((((float) ((i >> 16) & 255)) * 0.78f) + 0.0f)) & 255) << 16)) | ((((int) ((((float) ((i >> 8) & 255)) * 0.78f) + 0.0f)) & 255) << 8)) | ((((int) ((((float) (i & 255)) * 0.78f) + 0.0f)) & 255) << 0);
    }

    public static int eL(Context context) {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(bi.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
            return i;
        }
    }

    public static int gv(Context context) {
        return eL(context);
    }

    public static boolean gw(Context context) {
        if (!gx(context)) {
            if (!((context == null ? false : context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism")) || gy(context))) {
                if (!(context == null ? false : context.getPackageManager().hasSystemFeature("android.hardware.notch_support"))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean gx(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Class loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            x.d("MicroMsg.UIUtils", "vivo hasCutOut: %s", Boolean.valueOf(((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue()));
            return ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UIUtils", e, "hasCutOut, ClassNotFoundException!!", new Object[0]);
            x.d("MicroMsg.UIUtils", "vivo hasCutOut: %s", Boolean.valueOf(false));
            return false;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.UIUtils", e2, "hasCutOut, NoSuchMethodException!!", new Object[0]);
            x.d("MicroMsg.UIUtils", "vivo hasCutOut: %s", Boolean.valueOf(false));
            return false;
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.UIUtils", e22, "hasCutOut, IllegalAccessException!!", new Object[0]);
            x.d("MicroMsg.UIUtils", "vivo hasCutOut: %s", Boolean.valueOf(false));
            return false;
        } catch (Throwable e222) {
            x.printErrStackTrace("MicroMsg.UIUtils", e222, "hasCutOut, InvocationTargetException!!", new Object[0]);
            x.d("MicroMsg.UIUtils", "vivo hasCutOut: %s", Boolean.valueOf(false));
            return false;
        } catch (Throwable th) {
            x.d("MicroMsg.UIUtils", "vivo hasCutOut: %s", Boolean.valueOf(false));
            return false;
        }
    }

    private static boolean gy(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Class loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            x.d("MicroMsg.UIUtils", "huawei hasCutOut: %s", Boolean.valueOf(((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue()));
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UIUtils", e, "hasCutOut, ClassNotFoundException!!", new Object[0]);
            x.d("MicroMsg.UIUtils", "huawei hasCutOut: %s", Boolean.valueOf(false));
            return false;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.UIUtils", e2, "hasCutOut, NoSuchMethodException!!", new Object[0]);
            x.d("MicroMsg.UIUtils", "huawei hasCutOut: %s", Boolean.valueOf(false));
            return false;
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.UIUtils", e22, "hasCutOut, IllegalAccessException!!", new Object[0]);
            x.d("MicroMsg.UIUtils", "huawei hasCutOut: %s", Boolean.valueOf(false));
            return false;
        } catch (Throwable e222) {
            x.printErrStackTrace("MicroMsg.UIUtils", e222, "hasCutOut, InvocationTargetException!!", new Object[0]);
            x.d("MicroMsg.UIUtils", "huawei hasCutOut: %s", Boolean.valueOf(false));
            return false;
        } catch (Throwable th) {
            x.d("MicroMsg.UIUtils", "huawei hasCutOut: %s", Boolean.valueOf(false));
            return false;
        }
    }
}
