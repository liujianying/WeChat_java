package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.pluginsdk.model.k.1;

class k$1$1 implements Runnable {
    final /* synthetic */ Object nnI;
    final /* synthetic */ 1 qyX;

    k$1$1(1 1, Object obj) {
        this.qyX = 1;
        this.nnI = obj;
    }

    public final void run() {
        this.qyX.qyW.onPostExecute(this.nnI);
    }
}
