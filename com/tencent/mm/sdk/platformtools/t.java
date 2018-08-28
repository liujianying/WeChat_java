package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.bp.a;

public class t {
    private static int sFQ = -1;
    public static int sFR = -1;
    private static boolean sFS = false;
    private static int sFT = -1;
    private static int sFU = -1;

    public static void chB() {
        sFS = false;
    }

    public static final int fx(Context context) {
        if (sFS) {
            return fz(context);
        }
        if (!fB(context)) {
            return ad.chZ().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
        }
        int i = ad.chZ().getInt("com.tencent.mm.compatible.util.keybord.height", a.fromDPToPix(context, 230));
        sFQ = i;
        return i;
    }

    public static final int s(Context context, boolean z) {
        if (sFS) {
            return fz(context);
        }
        if (sFQ <= 0 || !z) {
            return fx(context);
        }
        return sFQ;
    }

    public static final boolean ak(Context context, int i) {
        if (sFQ == i) {
            return true;
        }
        if (!fB(context)) {
            return false;
        }
        if (i < 0) {
            return false;
        }
        sFQ = i;
        x.d("MicroMsg.KeyBordUtil", "save keybord: %d", Integer.valueOf(i));
        return ad.chZ().edit().putInt("com.tencent.mm.compatible.util.keybord.height", i).commit();
    }

    public static final int fy(Context context) {
        if (sFS) {
            return fz(context);
        }
        if (sFT > 0) {
            return sFT;
        }
        if (!fB(context)) {
            return 1140;
        }
        int fromDPToPix = a.fromDPToPix(context, 380);
        sFT = fromDPToPix;
        return fromDPToPix;
    }

    public static final int fz(Context context) {
        if (sFU > 0) {
            return sFU;
        }
        if (!fB(context)) {
            return sFU * 3;
        }
        int fromDPToPix = a.fromDPToPix(context, 230);
        sFU = fromDPToPix;
        return fromDPToPix;
    }

    public static final int al(Context context, int i) {
        int fz = fz(context);
        int fy;
        if (fC(context)) {
            if (i <= 0) {
                i = s(context, true);
            }
            fy = fy(context);
            if (i > fy) {
                return fy;
            }
            if (i < fz) {
                return fz;
            }
            return i;
        }
        fy = (int) (((double) fz) / 1.5d);
        fz = db(context)[0];
        if (fy > fz / 2) {
            return fz / 2;
        }
        return fy;
    }

    public static final int fA(Context context) {
        return al(context, -1);
    }

    private static final boolean fB(Context context) {
        if (context == null) {
            context = ad.getContext();
        }
        return context != null;
    }

    public static boolean fC(Context context) {
        int[] db = db(context);
        return db[0] < db[1] ? true : true;
    }

    public static int[] db(Context context) {
        Context context2;
        if (context == null) {
            context2 = ad.getContext();
        } else {
            context2 = context;
        }
        int[] iArr = new int[2];
        if (context2 instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context2).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    public static int S(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }
}
