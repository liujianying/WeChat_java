package com.tencent.mm.plugin.gcm.modelgcm;

import android.os.AsyncTask;
import com.google.android.gms.gcm.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class a$a extends AsyncTask<Void, Void, String> {
    final /* synthetic */ a khm;

    a$a(a aVar) {
        this.khm = aVar;
    }

    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
    }

    private String aVP() {
        Object obj = null;
        f.mDy.a(452, 5, 1, false);
        String c;
        String str;
        try {
            x.i("GcmRegister", "RegisterAsyncTask doInBackground.");
            if (a.a(this.khm) == null) {
                a.a(this.khm, a.al(a.b(this.khm)));
            }
            c = a.a(this.khm).c(new String[]{"546136561403"});
            str = "Device registered, registration ID=" + c;
            if (c == null || c.length() <= 0) {
                h.mEJ.k(11250, "2,1");
                f.mDy.a(452, 7, 1, false);
                c = str;
                x.i("GcmRegister", c);
                if (obj == null && a.c(this.khm) > 0) {
                    a.a(this.khm, a.c(this.khm) - 1);
                    this.khm.aVH();
                }
                return c;
            }
            this.khm.aq(a.b(this.khm), c);
            this.khm.aVM();
            obj = 1;
            f.mDy.a(452, 6, 1, false);
            c = str;
            x.i("GcmRegister", c);
            a.a(this.khm, a.c(this.khm) - 1);
            this.khm.aVH();
            return c;
        } catch (Throwable e) {
            str = "Device register Error :" + e.getMessage();
            x.printErrStackTrace("GcmRegister", e, "", new Object[0]);
            h.mEJ.k(11250, "2,1");
            f.mDy.a(452, 8, 1, false);
            c = str;
        } catch (Throwable e2) {
            a.a(this.khm, 0);
            str = "Device register Error :" + e2.getMessage();
            x.printErrStackTrace("GcmRegister", e2, "", new Object[0]);
            h.mEJ.k(11250, "2,1");
            f.mDy.a(452, 9, 1, false);
            c = str;
        } catch (Throwable e22) {
            str = "Device register Error :" + e22.getMessage();
            x.printErrStackTrace("GcmRegister", e22, "", new Object[0]);
            h.mEJ.k(11250, "2,1");
            f.mDy.a(452, 10, 1, false);
            c = str;
        }
    }
}
