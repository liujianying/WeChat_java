package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.al.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.avk;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public final class x {
    public static avl pLP;

    public static avl bTb() {
        if (pLP == null) {
            String bSY = bSY();
            pLP = new avl();
            bSY = ad.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString(bSY, "");
            if (!bi.oW(bSY)) {
                try {
                    pLP.aG(Base64.decode(bSY.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        if (b.ml((String) g.Ei().DT().get(274436, null))) {
            pLP.hbG.clear();
        }
        return pLP;
    }

    public static String bSY() {
        return "key_pb_most_search_biz_list" + q.GF();
    }

    public static void PZ(String str) {
        if (!b.ml((String) g.Ei().DT().get(274436, null)) && s.hf(str)) {
            avk avk;
            SharedPreferences sharedPreferences;
            if (pLP == null) {
                bTb();
            }
            long currentTimeMillis = System.currentTimeMillis();
            avk avk2 = null;
            int i = 0;
            while (i < pLP.hbG.size()) {
                avk = (avk) pLP.hbG.get(i);
                long j = (currentTimeMillis - avk.rYi) / 86400000;
                avk.rYh *= Math.pow(0.98d, (double) j);
                avk.rYi = (j * 86400000) + avk.rYi;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", new Object[]{Double.valueOf(avk.rYh), Long.valueOf(avk.rYi), avk.rdS});
                if (!avk.rdS.equals(str)) {
                    avk = avk2;
                }
                i++;
                avk2 = avk;
            }
            if (avk2 == null) {
                avk = new avk();
                avk.rYh = 1.0d;
                avk.rYi = currentTimeMillis;
                avk.rdS = str;
                pLP.hbG.add(avk);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", new Object[]{str});
            } else {
                avk2.rYh += 1.0d;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", new Object[]{str, Double.valueOf(avk2.rYh)});
            }
            Collections.sort(pLP.hbG, new Comparator<avk>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    avk avk = (avk) obj;
                    avk avk2 = (avk) obj2;
                    if (avk.rYh > avk2.rYh) {
                        return 1;
                    }
                    return avk.rYh < avk2.rYh ? -1 : 0;
                }
            });
            int size = pLP.hbG.size() - 1;
            while (true) {
                int i2 = size;
                if (i2 >= pLP.hbG.size() || pLP.hbG.size() <= 8) {
                    sharedPreferences = ad.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
                } else {
                    if (((avk) pLP.hbG.get(i2)).rYh < 0.5d) {
                        pLP.hbG.remove(i2);
                    }
                    size = i2 + 1;
                }
            }
            sharedPreferences = ad.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
            try {
                sharedPreferences.edit().putString(bSY(), Base64.encodeToString(pLP.toByteArray(), 0)).commit();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "useBiz pbListString %s", new Object[]{r2});
            } catch (IOException e) {
            }
        }
    }
}
