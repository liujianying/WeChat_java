package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a$b {
    private List<a> nyv = new ArrayList();
    public Map<String, List<a>> nyw = new HashMap();

    public final List<a> bzl() {
        Object obj;
        String fD = w.fD(ad.getContext());
        if ("zh_CN".equals(fD) || "zh_TW".equals(fD) || "zh_HK".equals(fD)) {
            String obj2 = fD;
        } else {
            obj2 = "en";
        }
        if (!this.nyw.containsKey(obj2)) {
            List arrayList = new ArrayList();
            for (a aVar : this.nyv) {
                if ("zh_CN".equals(obj2) && !bi.oW(aVar.nyy)) {
                    arrayList.add(aVar);
                } else if (("zh_TW".equals(obj2) || "zh_HK".equals(obj2)) && !bi.oW(aVar.nyz)) {
                    arrayList.add(aVar);
                } else if ("en".equals(obj2) && !bi.oW(aVar.nyA)) {
                    arrayList.add(aVar);
                }
            }
            this.nyw.put(obj2, arrayList);
        }
        return (List) this.nyw.get(obj2);
    }

    public a$b(Map<String, String> map, String str) {
        String str2 = str + ".dislikeInfo.ReasonList";
        int i = 0;
        while (true) {
            String str3;
            int i2 = i;
            String str4 = str2 + ".Reason";
            if (i2 > 0) {
                str3 = str4 + i2;
            } else {
                str3 = str4;
            }
            if (map.get(str3 + ".ReasonId") != null) {
                this.nyv.add(new a(bi.aG((String) map.get(str3 + ".Wording.zh"), ""), bi.aG((String) map.get(str3 + ".Wording.tw"), ""), bi.aG((String) map.get(str3 + ".Wording.en"), ""), bi.WU((String) map.get(str3 + ".ReasonId"))));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
