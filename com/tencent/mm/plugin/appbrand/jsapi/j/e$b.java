package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

final class e$b extends c implements Runnable {
    private final AtomicReference<a[]> fXj;
    final /* synthetic */ e fXk;

    private e$b(e eVar) {
        this.fXk = eVar;
        this.fXj = new AtomicReference();
    }

    /* synthetic */ e$b(e eVar, byte b) {
        this(eVar);
    }

    final void u(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("current");
        if (optJSONArray == null || optJSONArray2 == null || optJSONArray.length() != optJSONArray2.length()) {
            h("fail:invalid data", null);
        } else if (optJSONArray.length() <= 0) {
            h("ok", null);
            x.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
            c.runOnUiThread(new 1(this));
        } else {
            try {
                Object obj = new a[optJSONArray.length()];
                int i = 1;
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    int i3;
                    JSONArray jSONArray = optJSONArray.getJSONArray(i2);
                    int i4 = optJSONArray2.getInt(i2);
                    String[] strArr = new String[jSONArray.length()];
                    for (i3 = 0; i3 < strArr.length; i3++) {
                        strArr[i3] = jSONArray.getString(i3);
                    }
                    obj[i2] = new a(strArr, i4);
                    if (jSONArray.length() <= 0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    i &= i3;
                }
                if (i != 0) {
                    h("ok", null);
                    x.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
                    c.runOnUiThread(new 2(this));
                    return;
                }
                this.fXj.set(obj);
                c.runOnUiThread(this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", e, "opt params", new Object[0]);
                h("fail:invalid data", null);
            }
        }
    }

    public final void run() {
        AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) C(AppBrandMultiOptionsPicker.class);
        if (appBrandMultiOptionsPicker == null) {
            h("fail cant init view", null);
            return;
        }
        a[] aVarArr = (a[]) this.fXj.get();
        if (aVarArr == null || aVarArr.length <= 0) {
            h("fail error data", null);
            return;
        }
        if (aVarArr != null && aVarArr.length > 0) {
            com.tencent.mm.plugin.appbrand.widget.picker.c appBrandMultiOptionsPicker$2;
            int pickersCount = appBrandMultiOptionsPicker.getPickersCount();
            appBrandMultiOptionsPicker.setLayoutFrozen(true);
            if (pickersCount < aVarArr.length) {
                pickersCount = aVarArr.length - pickersCount;
                if (pickersCount > 0) {
                    while (pickersCount > 0) {
                        appBrandMultiOptionsPicker$2 = new AppBrandMultiOptionsPicker$2(appBrandMultiOptionsPicker, appBrandMultiOptionsPicker.getContext());
                        appBrandMultiOptionsPicker$2.setOnValueChangedListener(appBrandMultiOptionsPicker.gMX);
                        appBrandMultiOptionsPicker$2.setEllipsizeType("end");
                        appBrandMultiOptionsPicker$2.setDividerHeight(com.tencent.mm.bp.a.fromDPToPix(appBrandMultiOptionsPicker.getContext(), 1));
                        appBrandMultiOptionsPicker$2.setTag(g.app_brand_multi_options_picker_view_index_tag, Integer.valueOf(appBrandMultiOptionsPicker.gMV.getChildCount()));
                        appBrandMultiOptionsPicker.gMV.addView(appBrandMultiOptionsPicker$2, new LayoutParams(0, -1, 1.0f));
                        pickersCount--;
                    }
                }
            } else if (pickersCount > aVarArr.length) {
                appBrandMultiOptionsPicker.mm(pickersCount - aVarArr.length);
            }
            for (pickersCount = 0; pickersCount < aVarArr.length; pickersCount++) {
                appBrandMultiOptionsPicker$2 = appBrandMultiOptionsPicker.ml(pickersCount);
                a aVar = aVarArr[pickersCount];
                appBrandMultiOptionsPicker$2.setOptionsArray(aVar.gMZ);
                appBrandMultiOptionsPicker$2.setValue(aVar.gNa);
                appBrandMultiOptionsPicker$2.setOnValueChangedListener(appBrandMultiOptionsPicker.gMX);
            }
            appBrandMultiOptionsPicker.gMV.setWeightSum((float) appBrandMultiOptionsPicker.getPickersCount());
            appBrandMultiOptionsPicker.setLayoutFrozen(false);
        }
        this.gMI.setOnResultListener(new 3(this));
        this.gMI.setOnValueUpdateListener(new 4(this));
        this.gMI.show();
    }
}
