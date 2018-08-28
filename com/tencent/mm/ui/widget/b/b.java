package com.tencent.mm.ui.widget.b;

import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.mm.bw.a.j;
import com.tencent.mm.ui.ap;

public final class b {
    private static DisplayMetrics tIh = null;

    public static a a(Context context, int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int i8;
        a aVar = new a();
        if (tIh == null) {
            tIh = context.getResources().getDisplayMetrics();
        }
        DisplayMetrics displayMetrics = tIh;
        int fromDPToPix = ap.fromDPToPix(context, 95);
        if (i < fromDPToPix) {
            i = fromDPToPix;
        }
        if (i2 < 0) {
            aVar.gLh = 0;
            aVar.gLi = displayMetrics.widthPixels - ((i5 * 2) + i);
            i6 = 0;
            i7 = 1;
        } else if (displayMetrics.widthPixels - ((i2 + i) + (i5 * 2)) < 0) {
            aVar.gLh = (i2 - i) - i5;
            aVar.gLi = (displayMetrics.widthPixels - i2) - i5;
            i6 = 1;
            i7 = 0;
        } else {
            aVar.gLh = i2;
            aVar.gLi = displayMetrics.widthPixels - (i2 + i);
            i6 = 0;
            i7 = 1;
        }
        if (i3 < 0 || i3 > displayMetrics.heightPixels) {
            i3 = (int) (((float) displayMetrics.heightPixels) / 2.0f);
        }
        if (z) {
            if (i3 >= i4 + i5) {
                aVar.ohR = (i3 - i5) - i4;
                fromDPToPix = 0;
                i8 = 1;
            }
            aVar.ohR = i3 - i5;
            fromDPToPix = 1;
            i8 = 0;
        } else {
            if (displayMetrics.heightPixels - i3 < (i5 * 3) + i4) {
                aVar.ohR = (i3 - i5) - i4;
                fromDPToPix = 0;
                i8 = 1;
            }
            aVar.ohR = i3 - i5;
            fromDPToPix = 1;
            i8 = 0;
        }
        if (i8 != 0) {
            aVar.ohR -= i5 * 2;
        } else if (fromDPToPix != 0) {
            aVar.ohR += i5 * 2;
        }
        if (i7 == 0 || fromDPToPix == 0) {
            if (i6 != 0 && fromDPToPix != 0) {
                aVar.uLa = j.PopRightTopAnimation;
                return aVar;
            } else if (i7 != 0 && i8 != 0) {
                aVar.uLa = j.PopLeftBottomAnimation;
                return aVar;
            } else if (!(i6 == 0 || i8 == 0)) {
                aVar.uLa = j.PopRightBottomAnimation;
                return aVar;
            }
        }
        aVar.uLa = j.PopLeftTopAnimation;
        return aVar;
    }
}
