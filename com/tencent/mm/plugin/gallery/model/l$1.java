package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.plugin.gallery.model.g.a;
import java.util.ArrayList;

class l$1 implements Runnable {
    final /* synthetic */ l jBn;

    l$1(l lVar) {
        this.jBn = lVar;
    }

    public final void run() {
        ArrayList aRz = this.jBn.jBl.aRz();
        l lVar = this.jBn;
        a[] aVarArr = new a[lVar.jBj.size()];
        lVar.jBj.toArray(aVarArr);
        for (a w : aVarArr) {
            w.w(aRz);
        }
    }

    public final String toString() {
        return super.toString() + "|queryAlbums";
    }
}
