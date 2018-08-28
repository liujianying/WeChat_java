package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONException;

public final class t implements d {
    public final String getMethod() {
        return "setFontStyle";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return false;
        }
        try {
            String string = jSONArray.getString(0);
            boolean z = true;
            switch (string.hashCode()) {
                case -1657669071:
                    if (string.equals("oblique")) {
                        z = false;
                        break;
                    }
                    break;
                case -1178781136:
                    if (string.equals("italic")) {
                        z = true;
                        break;
                    }
                    break;
                case -1039745817:
                    if (string.equals("normal")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    fVar.fnf.jN(2);
                    fVar.fng.jN(2);
                    break;
                case true:
                    fVar.fnf.jN(2);
                    fVar.fng.jN(2);
                    break;
                case true:
                    fVar.fnf.jN(0);
                    fVar.fng.jN(0);
                    break;
            }
            return true;
        } catch (JSONException e) {
            x.i("MicroMsg.SetFontStyle", "get 'fontStyle' error.");
            return false;
        }
    }
}
