package com.tencent.mm.plugin.appbrand.q;

import android.graphics.Color;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    private static DisplayMetrics gBr = ad.getContext().getResources().getDisplayMetrics();

    public static int h(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 3) {
            return 0;
        }
        if (jSONArray.length() == 3) {
            return Color.rgb(jSONArray.optInt(0) & WebView.NORMAL_MODE_ALPHA, jSONArray.optInt(1) & WebView.NORMAL_MODE_ALPHA, jSONArray.optInt(2) & WebView.NORMAL_MODE_ALPHA);
        }
        return Color.argb(jSONArray.optInt(3) & WebView.NORMAL_MODE_ALPHA, jSONArray.optInt(0) & WebView.NORMAL_MODE_ALPHA, jSONArray.optInt(1) & WebView.NORMAL_MODE_ALPHA, jSONArray.optInt(2) & WebView.NORMAL_MODE_ALPHA);
    }

    public static int aQ(String str, int i) {
        try {
            return vO(str);
        } catch (Exception e) {
            return i;
        }
    }

    public static int vO(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return i;
        }
        if (str.charAt(i) == '#') {
            long parseLong;
            if (str.length() == 7) {
                parseLong = Long.parseLong(str.substring(1), 16) | -16777216;
            } else if (str.length() != 9) {
                throw new IllegalArgumentException("Unknown color");
            } else {
                parseLong = Long.parseLong(str.substring(1, 7), 16) | (Long.parseLong(str.substring(7, 9), 16) << 24);
            }
            return (int) parseLong;
        }
        try {
            return Color.parseColor(str);
        } catch (IllegalArgumentException e) {
            return i;
        }
    }

    public static int lO(int i) {
        return gBr == null ? i : (int) (((float) i) / gBr.density);
    }

    public static float ad(float f) {
        return gBr == null ? f : f / gBr.density;
    }

    public static int lP(int i) {
        return gBr == null ? i : (int) (gBr.density * ((float) i));
    }

    public static float ae(float f) {
        return gBr == null ? f : f * gBr.density;
    }

    public static int e(JSONObject jSONObject, String str) {
        return a(jSONObject, str, 0);
    }

    public static int a(JSONObject jSONObject, String str, int i) {
        if (jSONObject == null) {
            return i;
        }
        try {
            return Math.round(ae((float) jSONObject.getDouble(str)));
        } catch (Exception e) {
            return i;
        }
    }

    public static int f(JSONObject jSONObject, String str) {
        return Math.round(ae((float) jSONObject.getDouble(str)));
    }

    public static float g(JSONObject jSONObject, String str) {
        return a(jSONObject, str, 0.0f);
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        if (jSONObject == null) {
            return f;
        }
        try {
            return ae((float) jSONObject.optDouble(str, (double) f));
        } catch (Exception e) {
            return f;
        }
    }

    public static int a(JSONArray jSONArray, int i) {
        return b(jSONArray, i);
    }

    private static int b(JSONArray jSONArray, int i) {
        int i2 = 0;
        if (jSONArray == null) {
            return i2;
        }
        try {
            return Math.round(ae((float) jSONArray.getDouble(i)));
        } catch (Exception e) {
            return i2;
        }
    }

    public static int i(JSONArray jSONArray) {
        return Math.round(ae((float) jSONArray.getDouble(0)));
    }

    public static float h(JSONObject jSONObject, String str) {
        return ae((float) jSONObject.getDouble(str));
    }

    public static float c(JSONArray jSONArray, int i) {
        return ae((float) jSONArray.getDouble(i));
    }

    public static float d(JSONArray jSONArray, int i) {
        return e(jSONArray, i);
    }

    private static float e(JSONArray jSONArray, int i) {
        float f = 0.0f;
        if (jSONArray == null) {
            return f;
        }
        try {
            return ae((float) jSONArray.getDouble(i));
        } catch (Exception e) {
            return f;
        }
    }

    public static float aor() {
        if (gBr == null) {
            return 1.0f;
        }
        return gBr.density;
    }
}
