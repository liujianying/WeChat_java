package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.webview.fts.j.2;
import com.tencent.mm.plugin.webview.fts.j.3;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.picker.CustomTimePicker;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

class j$1 implements Runnable {
    final /* synthetic */ String fwv;
    final /* synthetic */ String pPE;
    final /* synthetic */ r pPF;
    final /* synthetic */ j pPG;

    j$1(j jVar, String str, String str2, r rVar) {
        this.pPG = jVar;
        this.fwv = str;
        this.pPE = str2;
        this.pPF = rVar;
    }

    public final void run() {
        Date date = null;
        try {
            String optString;
            JSONObject jSONObject = new JSONObject(this.fwv);
            Bundle bundle = new Bundle();
            String str = this.pPE;
            if (this.pPE.equals("date")) {
                optString = jSONObject.optString("mode");
            } else {
                optString = str;
            }
            int i = -1;
            switch (optString.hashCode()) {
                case 3076014:
                    if (optString.equals("date")) {
                        i = 1;
                        break;
                    }
                    break;
                case 3560141:
                    if (optString.equals("time")) {
                        i = 2;
                        break;
                    }
                    break;
                case 1191572447:
                    if (optString.equals("selector")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            r rVar;
            switch (i) {
                case 0:
                    j.a(this.pPG, jSONObject, bundle, this.pPF);
                    return;
                case 1:
                    Date parse;
                    Date parse2;
                    Date parse3;
                    j jVar = this.pPG;
                    rVar = this.pPF;
                    String optString2 = jSONObject.optString("value");
                    String optString3 = jSONObject.optString("start");
                    String optString4 = jSONObject.optString("end");
                    String optString5 = jSONObject.optString("fields");
                    String str2 = "yyyy-MM-dd";
                    if ("month".equals(optString5)) {
                        str2 = "yyyy-MM";
                    } else if ("year".equals(optString5)) {
                        str2 = "yyyy";
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
                    try {
                        parse = simpleDateFormat.parse(optString2);
                    } catch (Throwable e) {
                        x.printErrStackTrace("WxaShowPickerListenerImpl", e, "", new Object[0]);
                        parse = date;
                    }
                    try {
                        parse2 = simpleDateFormat.parse(optString3);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("WxaShowPickerListenerImpl", e2, "", new Object[0]);
                        parse2 = date;
                    }
                    try {
                        parse3 = simpleDateFormat.parse(optString4);
                    } catch (Throwable e22) {
                        x.printErrStackTrace("WxaShowPickerListenerImpl", e22, "", new Object[0]);
                        parse3 = date;
                    }
                    a aVar = new a(jVar.context);
                    aVar.uLe = new 3(jVar, aVar, simpleDateFormat, bundle, rVar);
                    if (parse != null) {
                        aVar.ao(parse.getYear() + 1900, parse.getMonth() + 1, parse.getDate());
                    }
                    if (parse2 != null) {
                        aVar.ap(parse2.getYear() + 1900, parse2.getMonth() + 1, parse2.getDate());
                    }
                    if (parse3 != null) {
                        aVar.aq(parse3.getYear() + 1900, parse3.getMonth() + 1, parse3.getDate());
                    }
                    if (!TextUtils.isEmpty(optString5)) {
                        if (optString5.equals("year")) {
                            aVar.Z(false, false);
                        } else if (optString5.equals("month")) {
                            aVar.Z(true, false);
                        }
                        if (optString5.equals("day")) {
                            aVar.Z(true, true);
                        }
                    }
                    aVar.show();
                    return;
                case 2:
                    Date parse4;
                    Date parse5;
                    int minutes;
                    j jVar2 = this.pPG;
                    rVar = this.pPF;
                    c cVar = new c(jVar2.context);
                    str = jSONObject.optString("value");
                    String optString6 = jSONObject.optString("start");
                    String optString7 = jSONObject.optString("end");
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm");
                    try {
                        parse4 = simpleDateFormat2.parse(str);
                    } catch (Throwable e3) {
                        x.printErrStackTrace("WxaShowPickerListenerImpl", e3, "", new Object[0]);
                        parse4 = date;
                    }
                    try {
                        parse5 = simpleDateFormat2.parse(optString6);
                    } catch (Throwable e32) {
                        x.printErrStackTrace("WxaShowPickerListenerImpl", e32, "", new Object[0]);
                        parse5 = date;
                    }
                    try {
                        date = simpleDateFormat2.parse(optString7);
                    } catch (Throwable e4) {
                        x.printErrStackTrace("WxaShowPickerListenerImpl", e4, "", new Object[0]);
                    }
                    if (parse4 != null) {
                        int hours = parse4.getHours();
                        minutes = parse4.getMinutes();
                        if (cVar.uLn != null) {
                            CustomTimePicker customTimePicker = cVar.uLn;
                            if (f.GF(hours) && f.GE(minutes)) {
                                customTimePicker.setCurrentHour(Integer.valueOf(hours));
                                customTimePicker.setCurrentMinute(Integer.valueOf(minutes));
                            }
                            customTimePicker.aqt();
                        }
                    }
                    if (parse5 != null) {
                        minutes = parse5.getHours();
                        i = parse5.getMinutes();
                        if (cVar.uLn != null) {
                            CustomTimePicker customTimePicker2 = cVar.uLn;
                            customTimePicker2.fXv = minutes;
                            customTimePicker2.fXw = i;
                            if (f.GF(customTimePicker2.fXv) && customTimePicker2.gNn != null) {
                                customTimePicker2.gNn.setMinValue(customTimePicker2.fXv);
                            }
                        }
                    }
                    if (date != null) {
                        i = date.getHours();
                        int minutes2 = date.getMinutes();
                        if (cVar.uLn != null) {
                            CustomTimePicker customTimePicker3 = cVar.uLn;
                            customTimePicker3.fXx = i;
                            customTimePicker3.fXy = minutes2;
                            if (f.GF(customTimePicker3.fXx) && customTimePicker3.gNn != null) {
                                customTimePicker3.gNn.setMaxValue(customTimePicker3.fXx);
                            }
                        }
                    }
                    cVar.uLo = new 2(jVar2, cVar, bundle, rVar);
                    if (cVar.tYZ != null) {
                        if (cVar.uLn != null) {
                            cVar.uLn.aqt();
                        }
                        cVar.tYZ.show();
                        return;
                    }
                    return;
                default:
                    x.i("WxaShowPickerListenerImpl", "unknown mode %s", new Object[]{this.pPE});
                    return;
            }
        } catch (Throwable e5) {
            x.printErrStackTrace("WxaShowPickerListenerImpl", e5, "", new Object[0]);
        }
        x.printErrStackTrace("WxaShowPickerListenerImpl", e5, "", new Object[0]);
    }
}
