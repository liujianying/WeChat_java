package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class d {
    private static Boolean dgC = null;

    public static Activity cJ(Context context) {
        Context context2;
        if (context == null || !(context instanceof ContextWrapper) || (context instanceof Activity)) {
            context2 = context;
        } else {
            context2 = ((ContextWrapper) context).getBaseContext();
        }
        return context2 instanceof Activity ? (Activity) context2 : null;
    }

    public static boolean c(Window window) {
        if (window == null || window.getDecorView() == null || VERSION.SDK_INT < 23 || (window.getDecorView().getSystemUiVisibility() & 8192) == 0) {
            return false;
        }
        return true;
    }

    public static int AD(int i) {
        return ak.AD(i);
    }

    public static void a(Window window) {
        if (window == null || VERSION.SDK_INT < 21) {
            return;
        }
        if ((window.getAttributes().flags & Integer.MIN_VALUE) == 0 || window.getStatusBarColor() != 0) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public static boolean a(Window window, boolean z) {
        if (window == null || window.getDecorView() == null || VERSION.SDK_INT < 23 || Af()) {
            return false;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (z) {
            systemUiVisibility |= 8192;
        } else {
            systemUiVisibility &= -8193;
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
        return true;
    }

    public static boolean Af() {
        Throwable e;
        if (dgC == null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    dgC = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                    properties.load(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.StatusBarUIUtils", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                        dgC = Boolean.valueOf(false);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return dgC.booleanValue();
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.StatusBarUIUtils", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                dgC = Boolean.valueOf(false);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e42) {
                    }
                }
                return dgC.booleanValue();
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e52) {
                    }
                }
                throw e;
            }
        }
        return dgC.booleanValue();
    }

    public static boolean apT() {
        try {
            return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            if (Build.DEVICE.equals("mx2")) {
                return true;
            }
            if (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) {
                return false;
            }
            return false;
        }
    }
}
