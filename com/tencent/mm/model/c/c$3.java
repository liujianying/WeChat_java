package com.tencent.mm.model.c;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;

class c$3 implements a {
    final /* synthetic */ c dEF;

    c$3(c cVar) {
        this.dEF = cVar;
    }

    public final void a(String str, l lVar) {
        if (str != null && str.length() > 0 && "event_updated".equals(str)) {
            c fJ = c.Jx().fJ("100205");
            if (fJ.isValid()) {
                Map ckq = fJ.ckq();
                int i = bi.getInt((String) ckq.get("main_thread_watch_enable"), 65535);
                int i2 = bi.getInt((String) ckq.get("main_thread_watch_timeout"), 5000);
                int i3 = bi.getInt((String) ckq.get("main_thread_watch_log_loop"), 0);
                ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("main_thread_watch_enable", i).putInt("main_thread_watch_timeout", i2).putInt("main_thread_watch_log_loop", i3).putInt("main_thread_watch_report", bi.getInt((String) ckq.get("main_thread_watch_report"), 0)).commit();
                x.i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(r0)});
            }
            c.Jz();
        }
    }
}
