package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.n;
import com.tencent.mm.ar.j;
import com.tencent.mm.ar.m;
import com.tencent.mm.ar.r;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class c implements e {
    private static c dFu;
    private final int dFq = 21;
    private final String dFr = "trace_config_last_update_time";
    private final long dFs = 86400000;
    private volatile boolean dFt = false;
    private ArrayList<a> dlt = new ArrayList();
    private SharedPreferences duR = ad.chZ();

    private c() {
    }

    public static c JI() {
        if (dFu == null) {
            synchronized (c.class) {
                if (dFu == null) {
                    dFu = new c();
                }
            }
        }
        return dFu;
    }

    public final void a(int i, int i2, String str, l lVar) {
        int type = lVar.getType();
        x.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(type)});
        if (!(lVar instanceof n) || ((n) lVar).Lf() != 21) {
            x.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
        } else if (type == 159) {
            if (i == 0 && i2 == 0) {
                m[] ik = r.Qp().ik(21);
                if (ik == null || ik.length == 0) {
                    x.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
                    release();
                    return;
                }
                m mVar = ik[0];
                x.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + mVar.id + " version:" + mVar.version + " status:" + mVar.status + " type:" + mVar.bPh);
                if (5 == mVar.status) {
                    au.DF().a(new j(mVar.id, 21), 0);
                    return;
                }
                x.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
                this.duR.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
                release();
                return;
            }
            release();
        } else if (type == 160) {
            if (i == 0 && i2 == 0) {
                hn(((j) lVar).ecO);
            }
            release();
        }
    }

    private void hn(int i) {
        r.Qp();
        try {
            Map z = bl.z(com.tencent.mm.a.e.ct(new File(new File(com.tencent.mm.ar.n.Qm()), r.Qp().bk(i, 21)).getPath()), "TraceConfig");
            if (z == null) {
                x.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
                return;
            }
            int i2;
            String str = ".TraceConfig.Item";
            Map hashMap = new HashMap();
            int i3 = 0;
            while (true) {
                String str2 = str + (i3 == 0 ? "" : Integer.valueOf(i3));
                String str3 = (String) z.get(str2 + ".$key");
                if (str3 == null) {
                    break;
                }
                i2 = i3 + 1;
                long j = bi.getLong((String) z.get(str2), -1);
                if (j >= 0) {
                    x.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i2 + " key: " + str3 + "|value: " + j);
                    hashMap.put(str3, Long.valueOf(j));
                    i3 = i2;
                } else {
                    i3 = i2;
                }
            }
            Editor edit = this.duR.edit();
            for (Entry entry : hashMap.entrySet()) {
                edit.putLong((String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
            edit.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
            x.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + hashMap.size());
            i2 = this.dlt.size();
            for (i3 = 0; i3 < i2; i3++) {
                ((a) this.dlt.get(i3)).JC();
            }
            m bi = r.Qp().bi(i, 21);
            bi.status = 2;
            r.Qp().b(bi);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TraceConfigUpdater", e, "", new Object[0]);
        }
    }

    private void release() {
        x.i("MicroMsg.TraceConfigUpdater", "summer release");
        this.dFt = false;
        au.DF().b(159, this);
        au.DF().b(160, this);
    }

    public final boolean a(a aVar) {
        if (aVar == null || this.dlt.contains(aVar)) {
            return false;
        }
        return this.dlt.add(aVar);
    }
}
