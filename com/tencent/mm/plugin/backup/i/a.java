package com.tencent.mm.plugin.backup.i;

import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.backup.i.b.1;
import com.tencent.mm.plugin.backup.i.b.2;
import com.tencent.mm.plugin.backup.i.b.3;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a implements ar {
    public static a hdd;
    private c hde = new 1(this);
    private c hdf = new 2(this);
    private c hdg = new 3(this);
    private c hdh = new 4(this);
    private com.tencent.mm.model.bv.a hdi = new com.tencent.mm.model.bv.a() {
        public final void a(com.tencent.mm.ab.d.a aVar) {
            x.i("MicroMsg.BackupCore.BackupToPc", "backupcore onreceiveMsg");
            h.mEJ.a(400, 0, 1, false);
            String str = (String) bl.z(ab.a(aVar.dIN.rcl), "sysmsg").get(".sysmsg.MMBakChatNotify.url");
            if (bi.oW(str)) {
                x.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
            }
            Intent className = new Intent().setClassName(ad.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
            Intent C = bi.C(ad.getContext(), className);
            if (C == null) {
                C = className;
            }
            ad.getContext().startService(C.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, str).putExtra("isFromWifi", true));
        }
    };

    public a() {
        x.i("MicroMsg.BackupCore", "BackupCore init");
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        b att = b.att();
        x.i("MicroMsg.BackupEventListener", "init addListener");
        att.hdm = new 1(att);
        com.tencent.mm.sdk.b.a.sFg.b(att.hdm);
        att.hdn = new 2(att);
        com.tencent.mm.sdk.b.a.sFg.b(att.hdn);
        att.bannerOnInitListener = new 3(att);
        com.tencent.mm.sdk.b.a.sFg.b(att.bannerOnInitListener);
        au.getSysCmdMsgExtension().a("MMBakChatNotify", this.hdi, true);
        com.tencent.mm.sdk.b.a.sFg.a(this.hde);
        com.tencent.mm.sdk.b.a.sFg.a(this.hdf);
        com.tencent.mm.sdk.b.a.sFg.a(this.hdg);
        com.tencent.mm.sdk.b.a.sFg.a(this.hdh);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        b att = b.att();
        com.tencent.mm.sdk.b.a.sFg.c(att.hdm);
        com.tencent.mm.sdk.b.a.sFg.c(att.hdn);
        com.tencent.mm.sdk.b.a.sFg.c(att.bannerOnInitListener);
        au.getSysCmdMsgExtension().b("MMBakChatNotify", this.hdi, true);
        com.tencent.mm.sdk.b.a.sFg.c(this.hde);
        com.tencent.mm.sdk.b.a.sFg.c(this.hdf);
        com.tencent.mm.sdk.b.a.sFg.c(this.hdg);
        com.tencent.mm.sdk.b.a.sFg.c(this.hdh);
    }
}
