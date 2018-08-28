package com.tencent.mm.plugin.downloader.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static BroadcastReceiver icC = null;
    private static int icD = -1;

    private static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (!g.Eg().Dx() || com.tencent.mm.kernel.a.Dr()) {
                x.e("MicroMsg.Downloader.NetWorkManager", "acc has not ready");
                return;
            }
            int netType = ao.getNetType(ad.getContext());
            if (netType != a.icD) {
                a.icD = netType;
                x.i("MicroMsg.Downloader.NetWorkManager", "onNetStateChange, netState = " + netType);
                LinkedList aCT;
                Iterator it;
                com.tencent.mm.plugin.downloader.c.a aVar;
                if (!ao.isConnected(context)) {
                    x.w("MicroMsg.Downloader.NetWorkManager", "network is not connected");
                } else if (ao.isWifi(netType)) {
                    aCT = c.aCT();
                    if (aCT != null) {
                        it = aCT.iterator();
                        while (it.hasNext()) {
                            aVar = (com.tencent.mm.plugin.downloader.c.a) it.next();
                            x.i("MicroMsg.Downloader.NetWorkManager", "resumeTask, appId = %s, state = %d", new Object[]{aVar.field_appId, Integer.valueOf(aVar.field_status)});
                            if (aVar.field_status == 5) {
                                c.ct(aVar.field_downloadId);
                            } else if (aVar.field_status == 2) {
                                d.aCU().co(aVar.field_downloadId);
                            } else {
                                d aCU = d.aCU();
                                if (aVar.field_downloaderType == 3) {
                                    aCU.aCY().a(aVar);
                                } else {
                                    aCU.aCV().a(aVar);
                                }
                            }
                        }
                    }
                } else {
                    aCT = c.aCS();
                    if (aCT != null) {
                        it = aCT.iterator();
                        while (it.hasNext()) {
                            aVar = (com.tencent.mm.plugin.downloader.c.a) it.next();
                            d.aCU().cn(aVar.field_downloadId);
                            gt gtVar = new gt();
                            gtVar.bPU.opType = 9;
                            gtVar.bPU.bGm = aVar.field_downloadId;
                            com.tencent.mm.sdk.b.a.sFg.m(gtVar);
                        }
                    }
                }
            }
        }
    }

    public static void aDb() {
        if (icC == null) {
            icC = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            ad.getContext().registerReceiver(icC, intentFilter);
        } catch (Exception e) {
            x.e("MicroMsg.Downloader.NetWorkManager", e.getMessage());
        }
    }

    public static void aDc() {
        if (icC != null) {
            try {
                ad.getContext().unregisterReceiver(icC);
            } catch (Exception e) {
                x.e("MicroMsg.Downloader.NetWorkManager", e.getMessage());
            }
        }
        icC = null;
    }
}
