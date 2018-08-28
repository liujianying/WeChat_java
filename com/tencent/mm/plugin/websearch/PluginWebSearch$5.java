package com.tencent.mm.plugin.websearch;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.g.a.os;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class PluginWebSearch$5 implements n {
    final /* synthetic */ PluginWebSearch pKx;

    PluginWebSearch$5(PluginWebSearch pluginWebSearch) {
        this.pKx = pluginWebSearch;
    }

    public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
        if (map != null && str != null) {
            if (str.equals("mmsearch_reddot_new")) {
                int WU = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.entry"));
                if (WU == 1) {
                    x.i("MicroMsg.WebSearch.PluginWebSearch", "recv %s, %s", new Object[]{"mmsearch_reddot_new", map.toString()});
                    int WU2 = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.clear"));
                    String q = bi.q((String) map.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
                    int WU3 = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.discovery"));
                    int WU4 = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
                    long WV = bi.WV((String) map.get(".sysmsg.mmsearch_reddot_new.expire_time"));
                    int WU5 = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.h5_version"));
                    int WU6 = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
                    String str2 = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_text");
                    String str3 = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
                    long WV2 = bi.WV((String) map.get(".sysmsg.mmsearch_reddot_new.timestamp"));
                    ac bTg = ac.bTg();
                    ac.a aVar2 = null;
                    switch (WU) {
                        case 1:
                            aVar2 = bTg.pMk;
                            break;
                    }
                    if (aVar2 == null) {
                        aVar2 = new ac.a();
                    }
                    if (aVar2.timestamp < WV2) {
                        aVar2.id = q;
                        aVar2.pMo = WU3;
                        aVar2.pMm = WU;
                        aVar2.pMn = WU4;
                        aVar2.kSz = WV;
                        aVar2.pLn = WU5;
                        aVar2.type = WU6;
                        aVar2.text = str2;
                        aVar2.bWP = str3;
                        aVar2.timestamp = WV2;
                        aVar2.clear = WU2;
                        aVar2.eaP = System.currentTimeMillis();
                    } else {
                        x.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "timestamp %d not big than last msg %d", new Object[]{Long.valueOf(WV2), Long.valueOf(aVar2.timestamp)});
                    }
                    bTg.save();
                    com.tencent.mm.sdk.b.a.sFg.m(new os());
                }
            }
        }
    }
}
