package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;

class a$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ a mGN;

    a$1(a aVar, Bitmap bitmap) {
        this.mGN = aVar;
        this.abc = bitmap;
    }

    public final void run() {
        a.a(this.mGN).setImageBitmap(this.abc);
        a.a(this.mGN).setVisibility(0);
        if (a.b(this.mGN) != null) {
            a.b(this.mGN).notifyDataSetChanged();
        }
    }
}
