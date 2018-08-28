package com.tencent.tencentmap.mapsdk.a;

import android.os.AsyncTask;
import com.tencent.tencentmap.mapsdk.a.nl.a;
import com.tencent.tencentmap.mapsdk.a.nl.c;
import java.lang.ref.WeakReference;

class nl$b extends AsyncTask<String, Void, c> {
    final /* synthetic */ nl a;
    private WeakReference<a> b;

    public nl$b(nl nlVar, a aVar) {
        this.a = nlVar;
        this.b = new WeakReference(aVar);
    }

    /* renamed from: a */
    protected c doInBackground(String... strArr) {
        po a;
        try {
            a = pn.a().a(nl.b(this.a));
        } catch (Throwable th) {
            a = null;
        }
        if (a == null) {
            return null;
        }
        return nl.a(this.a, a.toString());
    }

    /* renamed from: a */
    protected void onPostExecute(c cVar) {
        super.onPostExecute(cVar);
        a aVar = null;
        if (this.b != null) {
            aVar = (a) this.b.get();
        }
        if (aVar != null) {
            aVar.a(cVar);
        }
    }
}
