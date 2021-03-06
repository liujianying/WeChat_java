package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONException;

public final class u implements d {
    public final String getMethod() {
        return "setFontWeight";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return false;
        }
        try {
            String string = jSONArray.getString(0);
            boolean z = true;
            switch (string.hashCode()) {
                case -1039745817:
                    if (string.equals("normal")) {
                        z = true;
                        break;
                    }
                    break;
                case 3029637:
                    if (string.equals("bold")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    fVar.fnf.setFakeBoldText(true);
                    fVar.fng.setFakeBoldText(true);
                    break;
                case true:
                    fVar.fnf.setFakeBoldText(false);
                    fVar.fng.setFakeBoldText(false);
                    break;
            }
            return true;
        } catch (JSONException e) {
            x.i("MicroMsg.SetFontWeight", "get 'fontWeight' error.");
            return false;
        }
    }
}
