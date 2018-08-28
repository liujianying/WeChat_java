package com.tencent.mm.plugin.websearch.api;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public class z {
    private static volatile z pLY;
    private ah egm;
    private boolean pLT = false;
    private boolean pLU = false;
    private Boolean pLV;
    private h pLW = new t();
    private Map<Integer, aa> pLX;

    static /* synthetic */ void G(String str, String str2, int i) {
        Intent intent = new Intent();
        intent.putExtra("tools_param_preload_url", str2);
        intent.putExtra("tools_process_action_code_key", str);
        intent.putExtra("tools_param_preload_search_biz", i);
        ToolsProcessStarterService.af(intent);
    }

    static /* synthetic */ void a(z zVar) {
        if (zVar.egm == null) {
            zVar.egm = new ah();
        }
        zVar.egm.H(new 2(zVar));
    }

    private z() {
    }

    public static z bTc() {
        if (pLY == null) {
            synchronized (z.class) {
                if (pLY == null) {
                    pLY = new z();
                }
            }
        }
        return pLY;
    }

    public final h Aa(int i) {
        if (i <= 0) {
            return this.pLW;
        }
        if (this.pLX == null) {
            this.pLX = new HashMap();
        }
        aa aaVar = (aa) this.pLX.get(Integer.valueOf(i));
        if (aaVar != null) {
            return aaVar;
        }
        h aaVar2 = new aa(i);
        this.pLX.put(Integer.valueOf(i), aaVar2);
        return aaVar2;
    }

    public final void cu(String str, int i) {
        if (ad.cie()) {
            Aa(i).PU(str);
        } else {
            g.Em().H(new 1(this, i, str));
        }
    }

    public final void ai(Intent intent) {
        cu(intent.getStringExtra("tools_param_preload_url"), intent.getIntExtra("tools_param_preload_search_biz", -1));
    }

    public final void jP(boolean z) {
        this.pLV = Boolean.valueOf(z);
    }

    public final boolean bTd() {
        if (this.pLV != null) {
            x.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload cmdPreloadSwitch %b", new Object[]{this.pLV});
            return this.pLV.booleanValue();
        } else if (p.zP(0) >= 80007181) {
            return this.pLT;
        } else {
            x.e("MicroMsg.WebSearch.WebSearchPreloadExport", "current search template not support preload");
            return false;
        }
    }

    public final boolean bTe() {
        if (this.pLV == null) {
            return this.pLU;
        }
        x.i("MicroMsg.WebSearch.WebSearchPreloadExport", "isOpenRecommendPreload cmdPreloadSwitch %b", new Object[]{this.pLV});
        return this.pLV.booleanValue();
    }
}
