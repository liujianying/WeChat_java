package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.widget.ListView;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;
import java.util.HashMap;
import java.util.Map.Entry;

public final class c {
    Activity activity;
    HashMap<String, Integer> unI = new HashMap();
    int unJ = -1;
    public int unK = -1;
    g unL;
    com.tencent.mm.sdk.b.c unM = new 1(this);
    com.tencent.mm.sdk.b.c unN = new 2(this);
    com.tencent.mm.sdk.b.c unO = new com.tencent.mm.sdk.b.c<jh>() {
        private final long INTERVAL;
        long unR;
        int unS;

        {
            this.INTERVAL = 3000;
            this.unR = 0;
            this.unS = -1;
            this.sFo = jh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (c.this.activity != null) {
                x.d("MicroMsg.ConvUnreadHelper", "trigger double tab");
                c.this.unh.postDelayed(new 1(this), 100);
            }
            return false;
        }
    };
    ListView unh;

    public final void Z(Activity activity) {
        this.unK = ((LauncherUI) activity).tkn.tjF.cqE();
    }

    public final void cyG() {
        if (this.activity != null) {
            long currentTimeMillis = System.currentTimeMillis();
            LauncherUI launcherUI = (LauncherUI) this.activity;
            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  resetStatus %d", new Object[]{Integer.valueOf(this.unJ)});
            switch (this.unJ) {
                case 1:
                    return;
                case 2:
                    int i = 0;
                    for (Entry entry : this.unI.entrySet()) {
                        int i2;
                        String str = (String) entry.getKey();
                        int intValue = ((Integer) entry.getValue()).intValue();
                        x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s, preunread %d", new Object[]{str, Integer.valueOf(intValue)});
                        ai aaQ = aaQ(str);
                        if (aaQ == null || al.cqV().contains(str)) {
                            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov == null username %s, change %d", new Object[]{str, Integer.valueOf(0 - intValue)});
                            i2 = intValue;
                        } else {
                            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov != null username %s, change %d", new Object[]{str, Integer.valueOf((aaQ.field_unReadCount - intValue) + 0)});
                            i2 = intValue;
                        }
                        if (i2 != 0 && this.unL.aaR(str)) {
                            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s isWithoutItemCache", new Object[]{str});
                            au.HU();
                            ab Yg = com.tencent.mm.model.c.FR().Yg(str);
                            if (Yg != null) {
                                if (s.fq(str)) {
                                    if (Yg.csI == 0) {
                                    }
                                } else if (Yg.BD()) {
                                }
                            }
                        }
                        x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  real change usename %s, change %d, totalchange %d", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i + i2)});
                        i = intValue;
                    }
                    this.unK += i;
                    z zVar = launcherUI.tkn.tjF;
                    zVar.toc.DX(this.unK);
                    x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_PART totalUnReadCount %d, change %d, usetime %d,", new Object[]{Integer.valueOf(this.unK), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return;
                default:
                    this.unK = launcherUI.tkn.tjF.cqE();
                    x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_ALL totalUnReadCount %d, usetime %d,", new Object[]{Integer.valueOf(this.unK), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return;
            }
        }
    }

    final ai aaQ(String str) {
        if (this.unL != null) {
            return (ai) this.unL.cn(str);
        }
        return null;
    }
}
