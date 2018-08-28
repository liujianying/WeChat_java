package com.tencent.mm.ui.applet;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.mm.R;

public final class d {
    private static int trY = 0;

    static /* synthetic */ int crc() {
        int i = trY;
        trY = i - 1;
        return i;
    }

    public static void gB(Context context) {
        if (trY <= 0) {
            a aVar = new a(context, LayoutInflater.from(context).inflate(R.i.trace_view, null));
            aVar.trG.addView(aVar.trF, aVar.trH);
            trY++;
        }
    }
}
