package com.tencent.mm.plugin.topstory;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.c.btf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class b$1 implements n {
    final /* synthetic */ b oyG;

    b$1(b bVar) {
        this.oyG = bVar;
    }

    public final void onNewXmlReceived(String str, Map<String, String> map, a aVar) {
        if (map != null && str != null && str.equals("mmsearch_reddot_new")) {
            int WU = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.entry"));
            if (WU == 2 || WU == 3) {
                btf btf = new btf();
                b.b(btf);
                x.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recv %s, %s", new Object[]{"mmsearch_reddot_new", map.toString()});
                btf.sqF = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.clear"));
                btf.pMm = WU;
                btf.bWQ = bi.q((String) map.get(".sysmsg.mmsearch_reddot_new.msgid"), new Object[0]);
                btf.pMo = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.discovery"));
                btf.pMn = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
                btf.eiD = bi.WV((String) map.get(".sysmsg.mmsearch_reddot_new.expire_time"));
                btf.pLn = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.h5_version"));
                btf.type = bi.WU((String) map.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
                btf.text = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_text");
                btf.bWP = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
                btf.sqE = bi.WV((String) map.get(".sysmsg.mmsearch_reddot_new.timestamp"));
                btf.sqG = System.currentTimeMillis();
                this.oyG.a(btf);
            }
        }
    }
}
