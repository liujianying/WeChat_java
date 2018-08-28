package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class b$a {
    public List<b> list = new LinkedList();

    public final b$a r(Map<String, String> map, String str) {
        String str2 = str + ".adxml.feedbackInfo.feedbackList.item";
        int i = 0;
        while (true) {
            String str3;
            if (i > 0) {
                str3 = str2 + i;
            } else {
                str3 = str2;
            }
            String str4 = str3 + ".url";
            if (map.get(str4) == null || ((String) map.get(str4)).length() <= 0) {
                return this;
            }
            b bVar = new b();
            bVar.url = bi.aG((String) map.get(str4), "");
            bVar.nzz = bi.aG((String) map.get(str3 + ".Wording.zh"), "");
            bVar.ntt = bi.aG((String) map.get(str3 + ".Wording.en"), "");
            bVar.nzA = bi.aG((String) map.get(str3 + ".Wording.tw"), "");
            if ((bVar.nzz.length() + bVar.ntt.length()) + bVar.nzA.length() > 0) {
                this.list.add(bVar);
            }
            i++;
        }
        return this;
    }
}
