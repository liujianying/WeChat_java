package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d {
    public boolean bKE = true;
    public String kCA = "";
    public String ntX = "";
    public String ntY = "";
    public int nuA = 0;
    public List<b> nuB = new ArrayList();

    static class b {
        public List<a> frZ = new ArrayList();
        public int nuF;
        public int showType;
        public String title;

        b() {
        }
    }

    public final boolean d(String str, String str2, Map<String, String> map) {
        this.ntY = str;
        this.ntX = str2;
        if (map != null) {
            try {
                this.nuB.clear();
                this.kCA = bi.aG((String) map.get("language"), "");
                if (!this.kCA.equals("zh_cn")) {
                    this.bKE = false;
                }
                int WU = bi.WU((String) map.get("tipcount"));
                int WU2 = bi.WU((String) map.get("expertype"));
                for (int i = 0; i < WU; i++) {
                    b bVar = new b();
                    bVar.title = bi.aG((String) map.get(String.format("tip_%d_basetextformat", new Object[]{Integer.valueOf(i)})), "");
                    bVar.nuF = bi.WU((String) map.get(String.format("tip_%d_id", new Object[]{Integer.valueOf(i)})));
                    bVar.showType = bi.WU((String) map.get(String.format("tip_%d_showtype", new Object[]{Integer.valueOf(i)})));
                    int WU3 = bi.WU((String) map.get(String.format("tip_%d_button_count", new Object[]{Integer.valueOf(i)})));
                    if (bVar.showType >= 6) {
                        this.bKE = false;
                    }
                    for (int i2 = 0; i2 < WU3; i2++) {
                        a aVar = new a();
                        aVar.index = bi.WU((String) map.get(String.format("tip_%d_button_%d_index", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        aVar.actionType = bi.WU((String) map.get(String.format("tip_%d_button_%d_actiontype", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        aVar.nuC = bi.aG((String) map.get(String.format("tip_%d_button_%d_basetextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.jumpUrl = bi.aG((String) map.get(String.format("tip_%d_button_%d_jumpurl", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.nuD = bi.aG((String) map.get(String.format("tip_%d_button_%d_priortextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.nuE = bi.WU((String) map.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        if (aVar.actionType >= 9) {
                            this.bKE = false;
                        }
                        bVar.frZ.add(aVar);
                    }
                    this.nuB.add(bVar);
                }
                x.i("Micromsg.SnsABTestInfo", "expertType " + WU2 + " " + str);
            } catch (Throwable e) {
                x.printErrStackTrace("Micromsg.SnsABTestInfo", e, "feed xml error ", new Object[0]);
            }
        }
        return false;
    }
}
