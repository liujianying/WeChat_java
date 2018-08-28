package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.ui.chatting.gallery.e.5;

class e$5$1 implements Runnable {
    final /* synthetic */ Bitmap tVj;
    final /* synthetic */ 5 tVk;

    e$5$1(5 5, Bitmap bitmap) {
        this.tVk = 5;
        this.tVj = bitmap;
    }

    public final void run() {
        this.tVk.tVi.tVd.put(Integer.valueOf(this.tVk.hW), this.tVj);
    }
}
