package com.tencent.tencentmap.mapsdk.a;

import android.os.AsyncTask;

class nm$1 extends AsyncTask<String, Void, Void> {
    final /* synthetic */ nm a;

    nm$1(nm nmVar) {
        this.a = nmVar;
    }

    /* renamed from: a */
    protected Void doInBackground(String... strArr) {
        nm.a(this.a);
        return null;
    }

    /* renamed from: a */
    protected void onPostExecute(Void voidR) {
        super.onPostExecute(voidR);
        synchronized (nm.b(this.a)) {
            nm.c(this.a);
        }
        this.a.e();
    }
}
