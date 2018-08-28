package com.tencent.mm.modelsimple;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.util.LinkedList;
import java.util.Map;

public final class v$b {
    public String desc;
    public LinkedList<v$a> egs;
    public String title;

    public static LinkedList<v$a> g(Map<String, String> map, String str) {
        LinkedList<v$a> linkedList = new LinkedList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= TbsLog.TBSLOG_CODE_SDK_BASE) {
                return linkedList;
            }
            String str2 = str + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
            try {
                i = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
                v$a v_a = new v$a();
                if (i != 5) {
                    return linkedList;
                }
                v_a.dvS = bi.oV((String) map.get(str2 + ".iconurl"));
                v_a.desc = bi.oV((String) map.get(str2 + ".desc"));
                v_a.egr = bi.oV((String) map.get(str2 + ".link"));
                if (bi.oW(v_a.dvS) && bi.oW(v_a.desc) && bi.oW(v_a.egr)) {
                    return linkedList;
                }
                linkedList.add(v_a);
                i = i2 + 1;
            } catch (Exception e) {
                x.w("MicroMsg.NetSceneScanStreetView", "parseVendorsFromXml() " + e.getMessage());
                return linkedList;
            }
        }
    }
}
