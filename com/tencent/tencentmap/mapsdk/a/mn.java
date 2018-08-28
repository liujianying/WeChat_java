package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class mn {
    private String a = "";
    private Context b;

    public mn(Context context) {
        this.b = context;
        this.a = kh.c();
    }

    public Integer a() {
        Integer num = null;
        try {
            po a = pn.a().a(this.a);
            if (a == null || a.a == null) {
                return num;
            }
            try {
                try {
                    JSONObject jSONObject = new JSONObject(new String(a.a, a.b));
                    try {
                        jSONObject.getJSONObject("detail");
                    } catch (JSONException e) {
                    }
                    try {
                        try {
                            return Integer.valueOf(jSONObject.getJSONObject("info").getInt("error"));
                        } catch (JSONException e2) {
                            return num;
                        }
                    } catch (JSONException e3) {
                        return num;
                    }
                } catch (Exception e4) {
                    return num;
                }
            } catch (UnsupportedEncodingException e5) {
                return num;
            }
        } catch (Exception e6) {
            return num;
        }
    }
}
