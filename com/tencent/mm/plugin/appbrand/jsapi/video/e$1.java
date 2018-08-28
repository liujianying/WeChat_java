package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

class e$1 implements a {
    final /* synthetic */ e gbt;

    e$1(e eVar) {
        this.gbt = eVar;
    }

    public final boolean vD() {
        try {
            int currPosMs = this.gbt.gbp.getCurrPosMs();
            if (Math.abs(currPosMs - this.gbt.gbs) >= 250) {
                JSONObject aka = this.gbt.aka();
                this.gbt.gbs = currPosMs;
                aka.put("position", new BigDecimal((((double) currPosMs) * 1.0d) / 1000.0d).setScale(3, 4).doubleValue());
                aka.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, this.gbt.gbp.getDuration());
                this.gbt.a(new g((byte) 0), aka);
            }
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", new Object[]{e});
        }
        return true;
    }
}
