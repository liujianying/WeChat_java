package com.tencent.mm.plugin.qqmail.b;

import android.os.AsyncTask;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qqmail.b.h.c;
import com.tencent.mm.plugin.qqmail.b.p.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;

class p$b extends AsyncTask<d, Integer, d> implements h$a {
    final /* synthetic */ p mdg;
    private h mdh;
    d mdi;

    private p$b(p pVar) {
        this.mdg = pVar;
    }

    /* synthetic */ p$b(p pVar, byte b) {
        this(pVar);
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        d dVar = ((d[]) objArr)[0];
        if (!bi.oW((String) dVar.mdo.mcz.get("skey"))) {
            if (!dVar.mdn.mdk && dVar.mdn.mdl) {
                byte[] m = p.c(this.mdg).m(dVar.uri, dVar.mdo.mcy);
                String str = m == null ? null : new String(m);
                if (str != null) {
                    dVar.mdp = new c(304, null, str);
                    if (dVar.mdn.mdm || !(dVar.mdp.status == 304 || dVar.mdp.status == 200)) {
                        x.e("MicroMsg.NormalMailAppService", "http error, %d", new Object[]{Integer.valueOf(dVar.mdp.status)});
                    } else {
                        dVar.mdq = bl.z(dVar.mdp.content, "Response");
                    }
                }
            }
            if (dVar.mdo.mcA != null) {
                this.mdh = new f();
            } else {
                this.mdh = new g();
            }
            dVar.mdp = this.mdh.a("https://", dVar.uri, dVar.mdo, this);
            if (dVar.mdp == null) {
                return null;
            }
            if (dVar.mdn.mdm) {
            }
            x.e("MicroMsg.NormalMailAppService", "http error, %d", new Object[]{Integer.valueOf(dVar.mdp.status)});
        }
        return dVar;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        d dVar = (d) obj;
        if (dVar != null) {
            if (bi.oW((String) dVar.mdo.mcz.get("skey"))) {
                dVar.mdr.onError(-5, "");
            } else if (dVar.mdp.status == 304) {
                p.a(dVar);
            } else if (dVar.mdp.status == 200) {
                p.a(this.mdg, dVar.mdp.mcz);
                if (p.a(dVar) == 0 && dVar.mdn.mdl) {
                    p.c(this.mdg).a(dVar.uri, dVar.mdo.mcy, dVar.mdp.content.getBytes());
                }
            } else {
                dVar.mdr.onError(dVar.mdp.status, p.uV(dVar.mdp.status));
            }
            dVar.mdr.onComplete();
            p.a(this.mdg).remove(Long.valueOf(dVar.id));
            p.b(this.mdg).remove(Long.valueOf(dVar.id));
        }
    }

    protected final /* synthetic */ void onProgressUpdate(Object[] objArr) {
        this.mdi.mdr.onProgress(((Integer[]) objArr)[0].intValue());
    }

    public final boolean b(d dVar) {
        if (!dVar.mdr.onReady()) {
            return false;
        }
        this.mdi = dVar;
        super.execute(new d[]{dVar});
        return true;
    }

    public final void bol() {
        publishProgress(new Integer[]{Integer.valueOf(0)});
    }

    protected final void onCancelled() {
        au.Em().H(new 1(this));
        super.onCancelled();
    }
}
