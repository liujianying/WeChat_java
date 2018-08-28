package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.alt;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {
    private static final String jLG = (b.bnE + "Game/HvMenu/");

    public static void a(gl glVar) {
        x.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", new Object[]{Integer.valueOf(glVar.bPC.nc)});
        Context context;
        JSONObject jSONObject;
        switch (glVar.bPC.nc) {
            case 1:
                context = glVar.bPC.context;
                if (context != null) {
                    jSONObject = new JSONObject();
                    a dr = f.dr(context);
                    if (dr != null) {
                        try {
                            jSONObject.put("gameRegionName", f.a(dr));
                        } catch (JSONException e) {
                        }
                    }
                    glVar.bPD.result = jSONObject.toString();
                    return;
                }
                return;
            case 2:
                final String str = glVar.bPC.bPE;
                x.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[]{str});
                if (!bi.oW(str)) {
                    com.tencent.mm.kernel.g.DF().a(1369, new e() {
                        public final void a(int i, int i2, String str, l lVar) {
                            if (i == 0 && i2 == 0) {
                                x.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", new Object[]{str});
                                com.tencent.mm.kernel.g.DF().b(1369, this);
                                final alt alt = (alt) ((ba) lVar).ivx.dIE.dIL;
                                ah.A(new Runnable() {
                                    public final void run() {
                                        g.a(alt, str);
                                    }
                                });
                                return;
                            }
                            x.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", new Object[]{str});
                        }
                    });
                    com.tencent.mm.kernel.g.DF().a(new ba(str), 0);
                    return;
                }
                return;
            case 3:
                String str2 = glVar.bPC.bPE;
                x.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[]{str2});
                if (!bi.oW(str2)) {
                    byte[] Dw = ((c) com.tencent.mm.kernel.g.l(c.class)).aSk().Dw("pb_game_hv_menu_" + str2);
                    if (!bi.bC(Dw)) {
                        try {
                            glVar.bPD.result = new String(Dw, "ISO-8859-1");
                            x.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[]{str2});
                            return;
                        } catch (UnsupportedEncodingException e2) {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 4:
                b(glVar);
                return;
            case 10001:
                context = glVar.bPC.context;
                if (context != null) {
                    jSONObject = new JSONObject();
                    Object dz = f.dz(context);
                    if (bi.oW(dz)) {
                        dz = f.aTA();
                    }
                    try {
                        jSONObject.put("regionCode", dz);
                    } catch (JSONException e3) {
                    }
                    glVar.bPD.result = jSONObject.toString();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void a(List<atl> list, a aVar) {
        if (!bi.cX(list)) {
            atl atl = (atl) list.remove(0);
            if (atl == null || bi.oW(atl.lPl)) {
                x.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
                return;
            }
            String str = jLG + com.tencent.mm.a.g.u(atl.lPl.getBytes());
            com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
            aVar2.dXy = true;
            aVar2.dXA = str;
            o.Pj().a(atl.lPl, aVar2.Pt(), new 3(atl, list, aVar));
        } else if (aVar != null) {
            aVar.onComplete();
        }
    }

    private static void b(gl glVar) {
        String str = glVar.bPC.bPE;
        if (!bi.oW(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = bi.getInt(jSONObject.getString("game_page_report_id"), 0);
                boolean z = jSONObject.getBoolean("game_page_report_instantly");
                str = jSONObject.optString("game_page_report_format_data");
                String optString = jSONObject.optString("game_page_report_tabs_format_data");
                x.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), str, optString});
                if (i == 0) {
                    x.i("MicroMsg.GameCommOpertionProcessor", "reportId format exception");
                } else if (bi.oW(str)) {
                    if (!bi.oW(optString)) {
                        try {
                            JSONArray jSONArray = new JSONArray(optString);
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                optString = jSONArray.getString(i2);
                                if (!bi.oW(optString)) {
                                    if (z) {
                                        an.ao(i, optString);
                                    } else {
                                        h.mEJ.k(i, optString);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            x.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", new Object[]{e.getMessage()});
                        }
                    }
                } else if (z) {
                    an.ao(i, str);
                } else {
                    h.mEJ.k(i, str);
                }
            } catch (JSONException e2) {
                x.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", new Object[]{e2.getMessage()});
            }
        }
    }
}
