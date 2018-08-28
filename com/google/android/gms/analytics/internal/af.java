package com.google.android.gms.analytics.internal;

import android.util.DisplayMetrics;
import com.google.android.gms.c.al;
import java.util.Locale;

public final class af extends o {
    af(q qVar) {
        super(qVar);
    }

    protected final void mE() {
    }

    public final al og() {
        np();
        DisplayMetrics displayMetrics = this.aFn.ns().mContext.getResources().getDisplayMetrics();
        al alVar = new al();
        alVar.aYE = k.c(Locale.getDefault());
        alVar.aYG = displayMetrics.widthPixels;
        alVar.aYH = displayMetrics.heightPixels;
        return alVar;
    }
}
