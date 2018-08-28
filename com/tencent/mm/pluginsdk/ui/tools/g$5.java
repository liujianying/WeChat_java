package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.mm.pluginsdk.ui.tools.g.c;
import com.tencent.mm.sdk.platformtools.x;

class g$5 implements Runnable {
    final /* synthetic */ g qSF;
    final /* synthetic */ SparseArray qSG;
    final /* synthetic */ c qSH;

    g$5(g gVar, SparseArray sparseArray, c cVar) {
        this.qSF = gVar;
        this.qSG = sparseArray;
        this.qSH = cVar;
    }

    public final void run() {
        x.i("MicroMsg.ImageEngine", "begin do recycled");
        for (int i = 0; i < this.qSG.size(); i++) {
            Bitmap bitmap = (Bitmap) this.qSG.valueAt(i);
            if (bitmap != null) {
                x.d("MicroMsg.ImageEngine", "recycled def bmp %s", new Object[]{bitmap.toString()});
                bitmap.recycle();
            }
        }
        this.qSG.clear();
        x.i("MicroMsg.ImageEngine", "clear drawable cache");
        this.qSH.clear();
        x.i("MicroMsg.ImageEngine", "end do recycled");
    }
}
