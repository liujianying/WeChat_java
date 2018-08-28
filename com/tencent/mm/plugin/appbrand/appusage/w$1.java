package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import java.util.Iterator;

class w$1 implements Iterator<Object[]> {
    boolean fmF;
    final Object[] fmG = new Object[3];
    final /* synthetic */ Cursor fmH;
    final /* synthetic */ w fmI;

    w$1(w wVar, Cursor cursor) {
        this.fmI = wVar;
        this.fmH = cursor;
    }

    public final /* synthetic */ Object next() {
        this.fmG[0] = this.fmH.getString(0);
        this.fmG[1] = Integer.valueOf(this.fmH.getInt(1));
        this.fmG[2] = Integer.valueOf(0);
        return this.fmG;
    }

    public final boolean hasNext() {
        if (this.fmF) {
            boolean moveToNext = this.fmH.moveToNext();
            if (moveToNext) {
                return moveToNext;
            }
            this.fmH.close();
            return moveToNext;
        }
        this.fmF = true;
        return this.fmH.moveToFirst();
    }

    public final void remove() {
    }
}
