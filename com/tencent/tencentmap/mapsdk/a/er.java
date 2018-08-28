package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import com.tencent.tencentmap.mapsdk.a.eq.a;
import java.util.Map;
import java.util.Set;

public final class er {
    private static er a;
    private eq b;
    private es c = et.a();

    private er() {
        a(false);
    }

    public static synchronized er a() {
        er erVar;
        synchronized (er.class) {
            if (a == null) {
                a = new er();
            }
            erVar = a;
        }
        return erVar;
    }

    private synchronized void a(boolean z) {
        String a = fw.a();
        fx.a("AccessSchedulerStorageManager", "try updateCacheInfo...currentApn:" + a);
        if (TextUtils.isEmpty(a) || a.equals("unknown")) {
            fx.c("AccessSchedulerStorageManager", "updateCacheInfo failed... get current apn from ApnInfo:" + a);
        } else if (this.b == null || !this.b.b().equals(a) || z) {
            this.b = this.c.a(a);
            if (this.b != null) {
                fx.a("AccessSchedulerStorageManager", "cache succ for current apn:" + a);
            } else {
                fx.c("AccessSchedulerStorageManager", "cache failed for apn:" + a);
            }
        } else {
            fx.b("AccessSchedulerStorageManager", "same apn. no need update.");
        }
    }

    public final synchronized a a(String str) {
        a a;
        a(false);
        a = (this.b == null || !this.b.b().equals(fw.a())) ? null : this.b.a(str);
        return a;
    }

    public final synchronized void a(eq eqVar) {
        fx.b("AccessSchedulerStorageManager", "try updateAccessInfo...");
        if (eqVar == null) {
            fx.c("AccessSchedulerStorageManager", "updateAccessInfo info==null");
        } else {
            this.b = eqVar;
            this.c.a(eqVar);
        }
    }

    public final void a(String str, ep epVar) {
        String a = fw.a();
        if (TextUtils.isEmpty(a) || a.equals("unknown")) {
            fx.c("AccessSchedulerStorageManager", "updateApnUserTime... failed with apnName:" + a);
            return;
        }
        this.c.a(a, str, epVar.c());
        a(true);
        fx.b("AccessSchedulerStorageManager", "updateApnUseTime... apnName:" + a);
    }

    public final synchronized boolean a(Set set) {
        boolean z;
        fx.b("AccessSchedulerStorageManager", "isNeedScheduler... ");
        a(false);
        if (this.b == null) {
            fx.b("AccessSchedulerStorageManager", "no cache, need schedule...");
            z = true;
        } else {
            Map a = this.b.a();
            if (a == null) {
                fx.b("AccessSchedulerStorageManager", "DomainAccessInfo is null, need schedule...");
                z = true;
            } else if (a.size() < set.size()) {
                fx.b("AccessSchedulerStorageManager", "DomainAccessInfo map not enough, need schedule...map.size:" + a.size());
                z = true;
            } else {
                for (String str : set) {
                    a aVar = (a) a.get(str);
                    if (aVar != null) {
                        if (aVar.g()) {
                        }
                    }
                    fx.b("AccessSchedulerStorageManager", "domainInfo for domain:" + str + " is null or expired. need schedule...");
                    z = true;
                }
                z = false;
            }
        }
        return z;
    }
}
