package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.c.cfh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private PowerManager pJg = ((PowerManager) ad.getContext().getSystemService("power"));
    private KeyguardManager pJh = ((KeyguardManager) ad.getContext().getSystemService("keyguard"));
    LinkedHashMap<String, a> pKi = new LinkedHashMap();

    private class a {
        String content;
        String otZ;

        public a(String str, String str2) {
            this.otZ = str;
            this.content = str2;
        }
    }

    public static ts PR(String str) {
        ts tsVar = new ts();
        tsVar.cfs.bIH = 1;
        tsVar.cfs.username = str;
        com.tencent.mm.sdk.b.a.sFg.m(tsVar);
        return tsVar;
    }

    public final void bSB() {
        if (PR(null).cft.cfu != 0) {
            x.i("MicroMsg.wear.WearYoLogic", "current show yo");
            return;
        }
        a aVar;
        synchronized (this.pKi) {
            Iterator it = this.pKi.entrySet().iterator();
            if (it.hasNext()) {
                aVar = (a) ((Entry) it.next()).getValue();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                this.pKi.remove(aVar.otZ);
            }
        }
        if (aVar != null) {
            int i;
            String str = aVar.content;
            cfh cfh = new cfh();
            Map z = bl.z(str, "msg");
            if (z == null) {
                cfh.hcE = 0;
            } else {
                cfh.hcE = bi.getInt((String) z.get(".msg.yo.$type"), 0);
                cfh.hbF = bi.getInt((String) z.get(".msg.yo.$count"), 0);
            }
            Intent intent = new Intent();
            intent.putExtra("key_talker", aVar.otZ);
            try {
                intent.putExtra("key_data", cfh.toByteArray());
            } catch (IOException e) {
            }
            intent.addFlags(268435456);
            if (this.pJh.inKeyguardRestrictedInputMode() || !this.pJg.isScreenOn()) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                intent.setClass(ad.getContext(), WearYoLockUI.class);
            } else {
                intent.setClass(ad.getContext(), WearYoNoLockUI.class);
            }
            ad.getContext().startActivity(intent);
        }
    }
}
