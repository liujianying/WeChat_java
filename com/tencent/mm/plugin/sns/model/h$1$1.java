package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.model.h.1;

class h$1$1 implements Runnable {
    final /* synthetic */ Object nnI;
    final /* synthetic */ 1 nnJ;

    h$1$1(1 1, Object obj) {
        this.nnJ = 1;
        this.nnI = obj;
    }

    public final void run() {
        this.nnJ.nnH.onPostExecute(this.nnI);
    }
}
