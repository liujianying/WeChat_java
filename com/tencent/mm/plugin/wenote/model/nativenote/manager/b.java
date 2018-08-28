package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class b {
    private static float qpM = Float.MAX_VALUE;
    private static float qpN = Float.MAX_VALUE;
    private static int qpO = -1;
    public static float qpP = 48.0f;

    private static float bZA() {
        float f;
        synchronized (b.class) {
            if (qpM == Float.MAX_VALUE) {
                qpM = getDisplayMetrics().density;
            }
            f = qpM;
        }
        return f;
    }

    public static float getTextSize() {
        return qpP;
    }

    public static void setTextSize(float f) {
        qpP = f;
    }

    public static int Bt(int i) {
        return Math.round(((float) i) * bZB());
    }

    public static int Bu(int i) {
        return Math.round(((float) i) / bZB());
    }

    private static DisplayMetrics getDisplayMetrics() {
        Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    private static float bZB() {
        float f;
        synchronized (b.class) {
            if (qpN == Float.MAX_VALUE) {
                qpN = getDisplayMetrics().density * ad.getContext().getResources().getConfiguration().fontScale;
            }
            f = qpN;
        }
        return f;
    }

    public static int bZC() {
        if (qpO == -1) {
            qpO = Math.round(bZA() * 30.0f);
        }
        return qpO;
    }
}
