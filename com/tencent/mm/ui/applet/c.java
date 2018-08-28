package com.tencent.mm.ui.applet;

import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.mm.R;

public final class c {
    public static void gA(Context context) {
        a aVar = new a(context, LayoutInflater.from(context).inflate(R.i.trace_view, null));
        aVar.trG.addView(aVar.trF, aVar.trH);
    }
}
