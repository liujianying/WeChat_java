package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.au.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayoutWithAll extends FTSMainUIEducationLayout {
    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void aRb() {
        dr(getContext().getResources().getString(R.l.search_option_all), a.a(null, getContext().getString(R.l.search_option_all), getContext()));
    }

    private void dr(String str, int i) {
        LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.i.fts_main_ui_education_cell_layout_all, null);
        linearLayout.findViewById(R.h.textview_all).setOnClickListener(this.jxn);
        ((TextView) linearLayout.findViewById(R.h.textview_all)).setText(str);
        this.jzM.add(linearLayout);
        this.jzN.put(Integer.valueOf(i), (TextView) linearLayout.findViewById(R.h.textview_all));
        addView(linearLayout);
    }

    protected final boolean K(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null) {
            return false;
        }
        int ad;
        if (w.fD(ad.getContext()).equalsIgnoreCase("en")) {
            ad = com.tencent.mm.bp.a.ad(getContext(), R.f.BigerMoreTextSize);
        } else {
            ad = com.tencent.mm.bp.a.ad(getContext(), R.f.NormalTextSize);
        }
        Object obj = null;
        Object obj2 = null;
        String str = null;
        String str2 = null;
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (i % 3 == 0) {
                str2 = optJSONObject.optString("hotword");
                obj2 = optJSONObject;
            } else if (i % 3 == 1) {
                str = optJSONObject.optString("hotword");
                JSONObject obj3 = optJSONObject;
            } else {
                a(str2, obj2, str, obj3, optJSONObject.optString("hotword"), optJSONObject, ad);
                obj3 = null;
                obj2 = null;
                str = null;
                str2 = null;
            }
        }
        if (!(str2 == null || obj2 == null)) {
            a(str2, obj2, str, obj3, null, null, ad);
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("all");
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            aRb();
        } else {
            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(0);
            dr(optJSONObject2.optString("hotword"), optJSONObject2.optInt("businessType"));
        }
        return true;
    }
}
