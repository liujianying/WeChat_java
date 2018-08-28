package com.tencent.mm.plugin.af.a;

import android.os.AsyncTask;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.x;

class a$b extends AsyncTask<String, Integer, d> {
    final /* synthetic */ a miR;

    a$b(a aVar) {
        this.miR = aVar;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        d dVar = (d) obj;
        if (this.miR.miP != null) {
            this.miR.miP.a(dVar);
        }
    }

    private d x(String... strArr) {
        d dVar = null;
        x.d("dktest", "doInBackground :" + strArr);
        if (strArr == null || strArr.length != 1) {
            return null;
        }
        try {
            this.miR.miQ = System.currentTimeMillis();
            a aVar = new a();
            dVar = this.miR.Kf(strArr[0]);
            x.d("MicroMsg.scanner.DecodeFile", "time: " + aVar.Ad());
            return dVar;
        } catch (OutOfMemoryError e) {
            x.e("MicroMsg.scanner.DecodeFile", "decode failed, OutOfMemoryError");
            return dVar;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.scanner.DecodeFile", e2, "decode failed due to Exception", new Object[]{""});
            return dVar;
        }
    }
}
