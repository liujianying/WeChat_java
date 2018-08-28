package com.tencent.mm.ui.chatting.h.a;

import android.text.Spannable;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.h.a.a.b.c;
import org.json.JSONException;
import org.json.JSONObject;

class a$b$a$a implements a$b$b {
    private a$b$a$a() {
    }

    /* synthetic */ a$b$a$a(byte b) {
        this();
    }

    public final c a(Object obj, Spannable spannable) {
        String aG;
        String substring = spannable.toString().substring(spannable.getSpanStart(obj), spannable.getSpanEnd(obj));
        try {
            aG = bi.aG(new JSONObject(obj.toString()).optString("type"), obj.getClass().getName());
        } catch (JSONException e) {
            aG = obj.getClass().getName();
        }
        return new c(substring, aG);
    }
}
