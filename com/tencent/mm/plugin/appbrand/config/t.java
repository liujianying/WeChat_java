package com.tencent.mm.plugin.appbrand.config;

import android.util.Pair;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

public final class t {
    public String appId;
    public int bGM;
    public String dLS;
    public List<WxaAttributes$WxaEntryInfo> frQ;
    public List<Pair<String, String>> fsc;
    public int fsi;
    public String fsq;
    private String fsr = null;
    public String nickname;
    public String signature;
    public String username;

    public final String aep() {
        if (bi.oW(this.fsr) && !bi.cX(this.fsc)) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            for (Pair pair : this.fsc) {
                str = bi.oW((String) pair.second) ? (String) pair.first : (String) pair.second;
                if (!bi.oW(str)) {
                    stringBuilder.append("、");
                    stringBuilder.append(str);
                }
            }
            str = stringBuilder.toString();
            if (!bi.oW(str)) {
                str = str.replaceFirst("、", "");
            }
            this.fsr = str;
        }
        return bi.oV(this.fsr);
    }
}
