package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h {
    public boolean bKE = true;
    public String kCA = "";
    public String ntX = "";
    public String ntY = "";
    public int nuA = 0;
    public List<a> nuB = new ArrayList();
    public String nuN = "";
    public int[] nuO;

    public final boolean bzi() {
        return this.bKE && this.nuB != null && this.nuB.size() > 0;
    }

    public final boolean d(String str, String str2, Map<String, String> map) {
        this.ntY = str;
        this.ntX = str2;
        if (map != null) {
            try {
                this.nuB.clear();
                this.kCA = bi.aG((String) map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
                this.nuN = bi.aG((String) map.get("first_step_order"), "");
                String[] split = this.nuN.split("\\|");
                this.nuO = new int[split.length];
                if (this.nuO.length == 0) {
                    this.bKE = false;
                }
                int i = 0;
                while (i < split.length) {
                    this.nuO[i] = bi.WU(split[i]);
                    if (this.nuO[i] <= 0 || this.nuO[i] > 3) {
                        this.bKE = false;
                    }
                    i++;
                }
                int WU = bi.WU((String) map.get("wording_count"));
                int WU2 = bi.WU((String) map.get("expertype"));
                for (int i2 = 0; i2 < WU; i2++) {
                    a aVar = new a();
                    aVar.ntq = bi.WU((String) map.get(String.format("wording_%d_id", new Object[]{Integer.valueOf(i2 + 1)})));
                    aVar.ntr = bi.aG((String) map.get(String.format("wording_%d_zh_CN", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.nts = bi.aG((String) map.get(String.format("wording_%d_zh_TW", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.ntt = bi.aG((String) map.get(String.format("wording_%d_en", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.ntu = bi.WU((String) map.get(String.format("wording_%d_action_type", new Object[]{Integer.valueOf(i2 + 1)})));
                    this.nuB.add(aVar);
                }
                x.i("MicroMsg.SnsAdAbTestInfo", "expertType " + WU2 + " " + str + " " + this.nuN);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", e, "feed xml error ", new Object[0]);
            }
        }
        return false;
    }
}
