package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public LinkedList<a> egs = new LinkedList();
    public int hWb;
    public String iconUrl;
    public int mFp;
    public int mFq;
    public String mFr;
    public boolean mFs;
    public String title;
    public int type = 1;

    public static LinkedList<a> m(Map<String, String> map, String str) {
        LinkedList<a> linkedList = new LinkedList();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= BaseReportManager.MAX_READ_COUNT) {
                return linkedList;
            }
            a aVar = new a();
            String str2 = str + ".actionlist" + (i3 > 0 ? Integer.valueOf(i3) : "");
            if (!bi.oW((String) map.get(str2 + ".$type"))) {
                aVar.type = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
            }
            aVar.title = bi.oV((String) map.get(str2 + ".$title"));
            aVar.iconUrl = bi.oV((String) map.get(str2 + ".$iconurl"));
            aVar.hWb = bi.getInt((String) map.get(str2 + ".$iconwidth"), 34);
            aVar.mFp = bi.getInt((String) map.get(str2 + ".$iconheight"), 34);
            aVar.mFr = bi.oV((String) map.get(str2 + ".$referkey"));
            aVar.mFq = bi.getInt((String) map.get(str2 + ".$listshowtype"), 0);
            LinkedList linkedList2 = new LinkedList();
            i2 = 0;
            while (true) {
                int i4 = i2;
                if (i4 >= BaseReportManager.MAX_READ_COUNT) {
                    i2 = i;
                    break;
                }
                String str3 = str2 + ".action" + (i4 > 0 ? Integer.valueOf(i4) : "");
                if (!bi.oW((String) map.get(str3 + ".$type"))) {
                    i = 0;
                    a n = n(map, str3);
                    if (n != null) {
                        linkedList2.add(n);
                        if (!k.a(n)) {
                            i2 = true;
                            i4++;
                        }
                    }
                    boolean z = false;
                    i4++;
                } else if (i != 0) {
                    return linkedList;
                } else {
                    i2 = 1;
                    aVar.egs = linkedList2;
                }
            }
            aVar.mFs = false;
            linkedList.add(aVar);
            i3++;
        }
    }

    public static a n(Map<String, String> map, String str) {
        int i = bi.getInt((String) map.get(str + ".$type"), 0);
        a aVar = new a(i);
        aVar.type = i;
        aVar.mFy = bi.oV((String) map.get(str + ".statid"));
        aVar.name = bi.oV((String) map.get(str + ".name"));
        aVar.desc = bi.oV((String) map.get(str + ".desc"));
        aVar.dzA = bi.oV((String) map.get(str + ".digest"));
        aVar.showType = bi.getInt((String) map.get(str + ".showtype"), 0);
        aVar.mFt = bi.oV((String) map.get(str + ".image"));
        aVar.aAL = bi.oV((String) map.get(str + ".$key"));
        aVar.iconUrl = bi.oV((String) map.get(str + ".iconurl"));
        if (i == 1) {
            aVar.egr = bi.oV((String) map.get(str + ".link"));
            return aVar;
        } else if (i == 2) {
            aVar.username = bi.oV((String) map.get(str + ".username"));
            aVar.nickname = bi.oV((String) map.get(str + ".nickname"));
            aVar.mFC = bi.oV((String) map.get(str + ".strbeforefollow"));
            aVar.mFD = bi.oV((String) map.get(str + ".strafterfollow"));
            return aVar;
        } else if (i == 3) {
            aVar.thumburl = bi.oV((String) map.get(str + ".thumburl"));
            aVar.egr = bi.oV((String) map.get(str + ".link"));
            return aVar;
        } else if (i == 4) {
            aVar.thumburl = bi.oV((String) map.get(str + ".thumburl"));
            aVar.username = bi.oV((String) map.get(str + ".username"));
            aVar.nickname = bi.oV((String) map.get(str + ".nickname"));
            return aVar;
        } else {
            if (i == 5) {
                aVar.mFv = bi.oV((String) map.get(str + ".wifiurl"));
                aVar.mFw = bi.oV((String) map.get(str + ".wapurl"));
                aVar.mFx = bi.oV((String) map.get(str + ".weburl"));
                if (bi.oW(aVar.mFv) && bi.oW(aVar.mFw) && bi.oW(aVar.mFx)) {
                    return null;
                }
            } else if (i != 6) {
                if (i == 7) {
                    aVar.thumburl = bi.oV((String) map.get(str + ".thumburl"));
                    aVar.mFu = bi.oV((String) map.get(str + ".playurl"));
                    return aVar;
                } else if (i == 9) {
                    aVar.mFz = bi.oV((String) map.get(str + ".productid"));
                    return aVar;
                } else if (i == 8) {
                    aVar.mFA = bi.oV((String) map.get(str + ".cardext"));
                    aVar.mFB = bi.oV((String) map.get(str + ".cardid"));
                    return aVar;
                } else if (i == 10) {
                    aVar.mFz = bi.oV((String) map.get(str + ".id"));
                    return aVar;
                } else if (i == 12) {
                    aVar.thumburl = bi.oV((String) map.get(str + ".image"));
                    aVar.egr = bi.oV((String) map.get(str + ".link"));
                    return aVar;
                } else if (i == 22) {
                    aVar.content = bi.oV((String) map.get(str + ".content"));
                    aVar.egr = bi.oV((String) map.get(str + ".link"));
                    aVar.nickname = bi.oV((String) map.get(str + ".nickname"));
                    aVar.thumburl = bi.oV((String) map.get(str + ".image"));
                    return aVar;
                } else if (i == 21) {
                    aVar.mFr = bi.oV((String) map.get(str + ".referkey"));
                    return aVar;
                } else {
                    aVar.egr = bi.oV((String) map.get(str + ".link"));
                }
            }
            return aVar;
        }
    }
}
