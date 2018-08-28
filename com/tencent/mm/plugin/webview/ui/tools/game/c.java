package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    long jUq = 0;
    long jUr = 0;
    long mStartTime = 0;
    private long qfU = 0;
    Bundle qfV;
    public a qfW = new a(this);

    public static /* synthetic */ void a(c cVar) {
        if (cVar.mStartTime != 0) {
            cVar.qfU = System.currentTimeMillis() - cVar.mStartTime;
            x.i("MicroMsg.GamePageTimeReport", "visit page(%s), stayTime:%sms, foregroundTime:%sms", new Object[]{Integer.valueOf(cVar.hashCode()), Long.valueOf(cVar.qfU), Long.valueOf(cVar.jUq)});
            if (cVar.qfV == null) {
                x.i("MicroMsg.GamePageTimeReport", "report game page time fail. ReportData is null");
                return;
            }
            String string = cVar.qfV.getString("game_page_report_format_data");
            String string2 = cVar.qfV.getString("game_page_report_tabs_format_data");
            if (!bi.oW(string)) {
                cVar.qfV.putString("game_page_report_format_data", string.replace("__ALLSTAYTIME__", String.valueOf(cVar.qfU / 1000)).replace("__FOREGROUNDTIME__", String.valueOf(cVar.jUq / 1000)));
                x.i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportFormatData:%s", new Object[]{Integer.valueOf(cVar.hashCode()), string});
            } else if (!bi.oW(string2)) {
                string = cVar.RD(string2);
                if (!bi.oW(string)) {
                    cVar.qfV.putString("game_page_report_tabs_format_data", string);
                    x.i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportTabsFormatdata:%s", new Object[]{Integer.valueOf(cVar.hashCode()), string});
                } else {
                    return;
                }
            } else {
                return;
            }
            if (ad.cic()) {
                aa(cVar.qfV);
            } else {
                cVar.A(cVar.qfV);
            }
            cVar.qfV = null;
        }
    }

    public static void aa(Bundle bundle) {
        if (bundle != null) {
            Set<String> keySet = bundle.keySet();
            if (keySet != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str : keySet) {
                        jSONObject.put(str, bundle.get(str));
                    }
                    gl glVar = new gl();
                    glVar.bPC.nc = 4;
                    glVar.bPC.bPE = jSONObject.toString();
                    a.sFg.m(glVar);
                } catch (JSONException e) {
                }
            }
        }
    }

    public void A(Bundle bundle) {
    }

    private String RD(String str) {
        Matcher matcher = Pattern.compile("\\(.*?\\)").matcher(str);
        while (matcher.find()) {
            try {
                CharSequence oV = bi.oV(matcher.group());
                String replace = oV.replace("(", "").replace(")", "").replace(" ", "");
                CharSequence replace2;
                String[] split;
                if (replace.contains("__ALLSTAYTIME__")) {
                    replace2 = replace.replace("__ALLSTAYTIME__", String.valueOf(this.qfU / 1000));
                    split = replace2.split("\\+");
                    if (split.length == 2) {
                        replace2 = String.valueOf(Long.parseLong(split[0]) + Long.parseLong(split[1]));
                    }
                    str = str.replace(oV, replace2);
                } else if (oV.contains("__FOREGROUNDTIME__")) {
                    replace2 = replace.replace("__FOREGROUNDTIME__", String.valueOf(this.jUq / 1000));
                    split = replace2.split("\\+");
                    if (split.length == 2) {
                        replace2 = String.valueOf(Long.parseLong(split[0]) + Long.parseLong(split[1]));
                    }
                    str = str.replace(oV, replace2);
                }
            } catch (NumberFormatException e) {
                x.i("MicroMsg.GamePageTimeReport", "matchTimeMark, err:%s", new Object[]{e.getMessage()});
                return null;
            }
        }
        return str;
    }
}
