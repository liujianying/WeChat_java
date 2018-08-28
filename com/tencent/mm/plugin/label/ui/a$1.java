package com.tencent.mm.plugin.label.ui;

import android.database.Cursor;

class a$1 implements Runnable {
    final /* synthetic */ Cursor kBv;
    final /* synthetic */ a kBw;

    a$1(a aVar, Cursor cursor) {
        this.kBw = aVar;
        this.kBv = cursor;
    }

    public final void run() {
        this.kBw.l(this.kBv);
    }
}
