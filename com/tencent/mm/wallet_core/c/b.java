package com.tencent.mm.wallet_core.c;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b {
    public String bPL = "";
    public String title = "";
    public String uWW = "";
    public String uWX = "";
    public String uWY = "";

    public b(String str) {
        if (!bi.oW(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.title = jSONObject.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                this.uWW = jSONObject.optString("body1");
                this.uWX = jSONObject.optString("body2");
                this.uWY = jSONObject.optString("button");
            } catch (Exception e) {
                x.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", new Object[]{e.getMessage()});
            }
        }
    }
}
