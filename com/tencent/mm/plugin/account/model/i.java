package com.tencent.mm.plugin.account.model;

import android.content.SharedPreferences;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.g.a.a.b;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class i implements ar {
    public static int eOe = a.eOk;
    private static al eOf = null;
    private static int emz = 0;
    private a eOd;
    private n eOg = new n() {
        public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
            if (bi.oV(str).equals("ChangeLaunchImage") && map != null) {
                x.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", new Object[]{(String) map.get(".sysmsg.ChangeLaunchImage.BeginTime"), (String) map.get(".sysmsg.ChangeLaunchImage.EndTime"), (String) map.get(".sysmsg.ChangeLaunchImage.ResId.SubType")});
                if (!bi.G(new String[]{r0, r9, r10})) {
                    h.mEJ.a(723, 5, 1, false);
                    int WU = bi.WU(r10);
                    if (WU > 0) {
                        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 0);
                        sharedPreferences.edit().putLong("new_launch_image_begin_time", bi.WV(r0)).apply();
                        sharedPreferences.edit().putInt("new_launch_image_sub_type", WU).apply();
                        sharedPreferences.edit().putLong("new_launch_image_end_time", bi.WV(r9)).commit();
                        c.ccr();
                        i.pG(b.ew(43, WU));
                    }
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c eOh = new 3(this);

    static /* synthetic */ void pG(String str) {
        x.i("MicroMsg.SubCoreAccountSync", "filePath: %s", new Object[]{str});
        if (!bi.oW(str)) {
            File file = new File(str);
            if (file.exists()) {
                String str2 = e.duN + "splashWelcomeImg";
                if (com.tencent.mm.a.e.deleteFile(str2)) {
                    com.tencent.mm.a.e.y(file.getAbsolutePath(), str2);
                }
            }
        }
    }

    static /* synthetic */ int wy() {
        int i = emz;
        emz = i + 1;
        return i;
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.sFg.c(this.eOd.eNN);
        this.eOd = null;
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.eOg);
        this.eOh.dead();
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        this.eOd = new a();
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.eOg);
        this.eOh.cht();
        c.ccr();
        b.BK(43);
    }

    public final void bo(boolean z) {
    }

    public static void jj(int i) {
        eOe = i;
        switch (4.eOj[i - 1]) {
            case 1:
                emz = 0;
                if (eOf == null) {
                    eOf = new al(new 1(), true);
                }
                x.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
                eOf.J(900000, 900000);
                return;
            case 2:
            case 3:
                if (eOf != null) {
                    eOf.SO();
                }
                x.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
                eOe = a.eOk;
                ((com.tencent.mm.plugin.notification.b.a) g.n(com.tencent.mm.plugin.notification.b.a.class)).getNotification().xT();
                emz = 0;
                eOf = null;
                return;
            default:
                return;
        }
    }
}
