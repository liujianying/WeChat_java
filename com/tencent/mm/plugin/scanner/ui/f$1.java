package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;

class f$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ f mIw;

    f$1(f fVar, Bitmap bitmap) {
        this.mIw = fVar;
        this.abc = bitmap;
    }

    public final void run() {
        f.a(this.mIw).setImageBitmap(this.abc);
        f.a(this.mIw).setBackgroundColor(0);
        if (f.b(this.mIw) != null) {
            f.b(this.mIw).notifyDataSetChanged();
        }
    }
}
