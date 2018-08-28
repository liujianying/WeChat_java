package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.c.b;
import com.tencent.mm.plugin.radar.b.c.d;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class c$a implements e {
    String gtX;
    final LinkedList<String> mjv = new LinkedList();
    LinkedList<Integer> mjw;
    private final d mjx;
    final /* synthetic */ c mjy;

    public c$a(c cVar, d dVar) {
        this.mjy = cVar;
        this.mjx = dVar;
    }

    public final void onStart() {
        g.DF().a(30, (e) this);
    }

    private final void b(boolean z, boolean z2, String str, String str2) {
        g.DF().b(30, (e) this);
        d dVar = this.mjx;
        if (dVar != null) {
            dVar.a(z, z2, str, str2);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        b.c.b.e.i((Object) lVar, "scene");
        b bVar = c.mju;
        x.d(c.access$getTAG$cp(), "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (lVar.getType() != 30) {
            bVar = c.mju;
            x.w(c.access$getTAG$cp(), "not expected scene,  type = " + lVar.getType());
            return;
        }
        if (((m) lVar).cbz() == 2) {
            if (i == 0 && i2 == 0) {
                b(false, true, this.gtX, "");
                return;
            } else if (i == 4 && i2 == -34) {
                str = this.mjy.context.getString(f.fmessage_request_too_offen);
            } else if (i == 4 && i2 == -94) {
                str = this.mjy.context.getString(f.fmessage_user_not_support);
            } else if (i != 4 || (!(i2 == -24 || i2 == -101) || str == null)) {
                str = this.mjy.context.getString(f.sendrequest_send_fail);
            }
        } else if (i == 0 && i2 == 0) {
            b(true, false, this.gtX, "");
            return;
        } else if (i2 == -44) {
            g.DF().d((l) new m(2, this.mjv, this.mjw, "", ""));
            return;
        } else if (i2 == -87) {
            b(false, false, this.gtX, this.mjy.context.getString(f.contact_info_biz_join_fans_limit));
            return;
        } else if (i2 == -24 && !bi.oW(str)) {
            String str2 = this.gtX;
            if (str == null) {
                str = "";
            }
            b(false, false, str2, str);
            return;
        } else if (i == 4 && i2 == -22) {
            str = this.mjy.context.getString(f.addcontact_fail_blacklist);
        } else {
            str = this.mjy.context.getString(f.addcontact_fail);
        }
        b(false, false, this.gtX, str);
    }
}
