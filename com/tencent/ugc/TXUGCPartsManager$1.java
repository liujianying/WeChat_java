package com.tencent.ugc;

import android.os.AsyncTask;
import java.io.File;

class TXUGCPartsManager$1 extends AsyncTask {
    final /* synthetic */ String a;
    final /* synthetic */ TXUGCPartsManager b;

    TXUGCPartsManager$1(TXUGCPartsManager tXUGCPartsManager, String str) {
        this.b = tXUGCPartsManager;
        this.a = str;
    }

    protected Object doInBackground(Object[] objArr) {
        File file = new File(this.a);
        if (file.exists()) {
            file.delete();
        }
        return null;
    }
}
