package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class b$d {
    public String bGH;
    public String bPg;
    public String bvk;
    public String nxZ = "";
    public List<b$g> nzE = new ArrayList();

    public final void s(Map<String, String> map, String str) {
        this.nxZ = bi.aG((String) map.get(str + ".adxml.adTurnActionLink"), "");
        String str2 = (String) map.get(str + ".adxml.adTurnActionExtWeApp.appUserName");
        if (!TextUtils.isEmpty(str2)) {
            this.bPg = str2;
            this.bvk = (String) map.get(str + ".adxml.adTurnActionExtWeApp.appVersion");
            this.bGH = (String) map.get(str + ".adxml.adTurnActionExtWeApp.relativePagePath");
        }
        String str3 = str + ".adxml.adTurnInfo.materialInfo";
        int i = 0;
        while (true) {
            String str4;
            if (i > 0) {
                str4 = str3 + i;
            } else {
                str4 = str3;
            }
            if (map.get(str4 + ".displayType") != null && ((String) map.get(str4 + ".displayType")).length() > 0) {
                b$g b_g = new b$g();
                b_g.title = bi.aG((String) map.get(str4 + ".title"), "");
                b_g.desc = bi.aG((String) map.get(str4 + ".desc"), "");
                b_g.nzK = bi.WU((String) map.get(str4 + ".displayType"));
                this.nzE.add(b_g);
                i++;
            } else {
                return;
            }
        }
    }
}
