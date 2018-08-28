package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.c.ed;
import com.tencent.mm.protocal.c.ee;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 208;
    public static final String NAME = "requestAuthUserAutoFillData";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData data is invalid");
            pVar.E(i, f("fail:data is invalid", null));
            return;
        }
        int i2;
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("fields");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList.add(optJSONArray.optString(i2));
            }
        }
        final Object optString = jSONObject.optString("wording");
        final int optInt = jSONObject.optInt("authStatus", 2);
        final LinkedList linkedList2 = new LinkedList();
        optJSONArray = jSONObject.optJSONArray("authGroupList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList2.add("  " + optJSONArray.optString(i2));
            }
        }
        if (linkedList.size() == 0) {
            x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData fields is empty");
            pVar.E(i, f("fail:fields is empty", null));
        } else if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording is empty");
            pVar.E(i, f("fail:wording is empty", null));
        } else {
            x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData appId:%s", new Object[]{pVar.mAppId});
            x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "wording:%s, authType:%d, fieldIds:%s", new Object[]{optString, Integer.valueOf(optInt), jSONObject.optJSONArray("fields").toString()});
            if (jSONObject.optJSONArray("authGroupList") != null) {
                x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "authGroupList:%s", new Object[]{jSONObject.optJSONArray("authGroupList").toString()});
            }
            b.a aVar = new b.a();
            aVar.dIG = new ed();
            aVar.dIH = new ee();
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo";
            aVar.dIF = 1183;
            aVar.dII = 0;
            aVar.dIJ = 0;
            final b KT = aVar.KT();
            final ed edVar = (ed) KT.dID.dIL;
            edVar.reJ = linkedList;
            edVar.bPS = r0;
            edVar.reL = optInt;
            final p pVar2 = pVar;
            final int i3 = i;
            ah.A(new Runnable() {
                public final void run() {
                    f fVar = f.this;
                    p pVar = pVar2;
                    int i = i3;
                    ed edVar = edVar;
                    b bVar = KT;
                    int i2 = optInt;
                    CharSequence charSequence = optString;
                    LinkedList linkedList = linkedList2;
                    String string = i2 == 2 ? pVar.mContext.getString(j.app_brand_auth_user_auto_fill_data_dialog_title) : pVar.mContext.getString(j.app_brand_auth_user_auto_fill_data_dialog_title_after_write);
                    String string2 = pVar.mContext.getString(j.app_brand_auth_user_auto_fill_data_dialog_yes);
                    String string3 = pVar.mContext.getString(j.app_brand_auth_user_auto_fill_data_dialog_no);
                    CharSequence string4 = pVar.mContext.getString(j.app_brand_auth_user_auto_fill_data_dialog_know_detail);
                    LayoutInflater layoutInflater = (LayoutInflater) pVar.mContext.getSystemService("layout_inflater");
                    View inflate = layoutInflater.inflate(h.app_brand_auto_user_auto_fill_data, null);
                    TextView textView = (TextView) inflate.findViewById(g.app_brand_auth_auto_fill_data_know_detail);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(g.app_brand_auth_auto_fill_data_list);
                    ((TextView) inflate.findViewById(g.app_brand_auth_auto_fill_data_content)).setText(charSequence);
                    textView.setText(string4);
                    textView.setOnClickListener(new 2(fVar, pVar));
                    linearLayout.removeAllViews();
                    if (linkedList == null || linkedList.size() <= 0) {
                        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
                        layoutParams.leftMargin = 0;
                        textView.setLayoutParams(layoutParams);
                        linearLayout.setVisibility(8);
                    } else {
                        linearLayout.setVisibility(0);
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            textView = (TextView) layoutInflater.inflate(h.app_brand_auth_auto_fill_data_list_item, null);
                            textView.setText((String) it.next());
                            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -2);
                            layoutParams2.bottomMargin = pVar.getContentView().getResources().getDimensionPixelOffset(e.app_brand_auth_auto_fill_data_know_list_item_bottom_margin);
                            textView.setLayoutParams(layoutParams2);
                            linearLayout.addView(textView);
                        }
                    }
                    x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
                    com.tencent.mm.ui.base.h.a(pVar.mContext, false, string, inflate, string2, string3, new 3(fVar, edVar, pVar, i, bVar), new 4(fVar, edVar, pVar, i, bVar));
                }
            });
        }
    }
}
