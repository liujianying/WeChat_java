package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends i {
    int nCM;
    private RecyclerView nCN;
    private b nCO;
    Map<Integer, a> nCP = new HashMap();
    LinearLayoutManager nCQ;
    Set<Integer> nCR = new HashSet();

    private class a {
        int count;
        boolean isVisible;
        long nCS;
        long time;

        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        final void bzO() {
            if (this.isVisible) {
                this.isVisible = false;
                if (this.nCS > 0) {
                    this.time += System.currentTimeMillis() - this.nCS;
                    this.nCS = 0;
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar) {
        cVar.bzN();
        int fi = cVar.nCQ.fi();
        int fj = cVar.nCQ.fj();
        for (Entry entry : cVar.nCP.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < fi || ((Integer) entry.getKey()).intValue() > fj) {
                ((a) entry.getValue()).bzO();
            }
        }
    }

    public c(Context context, m mVar, ViewGroup viewGroup) {
        super(context, mVar, viewGroup);
        this.nCM = com.tencent.mm.bp.a.fromDPToPix(context, 12);
    }

    protected final int getLayout() {
        return g.sns_ad_native_landing_pages_item_carousel;
    }

    public final View bzM() {
        this.nCN = (RecyclerView) this.contentView.findViewById(f.recyclerView);
        this.nCN.setBackgroundColor(((m) this.nDt).backgroundColor);
        Iterator it = ((m) this.nDt).nAH.iterator();
        int i = 0;
        while (it.hasNext()) {
            s sVar = (s) it.next();
            if (sVar instanceof p) {
                p pVar = (p) sVar;
                int i2 = ((int) ((sVar.nAY + sVar.nAZ) + pVar.height)) + (this.nCM << 1);
                if (i <= i2) {
                    i = i2;
                }
            }
            i = i;
        }
        LayoutParams layoutParams = this.nCN.getLayoutParams();
        layoutParams.height = i;
        this.nCN.setLayoutParams(layoutParams);
        this.nCO = new b(this, (byte) 0);
        this.nCN.setAdapter(this.nCO);
        this.nCQ = new LinearLayoutManager();
        this.nCQ.setOrientation(0);
        this.nCN.setLayoutManager(this.nCQ);
        this.nCN.a(new c(this, this.nCN, this.nCQ));
        this.nCN.setNestedScrollingEnabled(false);
        this.nCN.setHasFixedSize(true);
        return this.contentView;
    }

    private void bzN() {
        if (this.nCQ != null) {
            dw(this.nCQ.fi(), this.nCQ.fj());
        }
    }

    final void dw(int i, int i2) {
        while (i <= i2) {
            a aVar = (a) this.nCP.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a(this, (byte) 0);
                this.nCP.put(Integer.valueOf(i), aVar);
            }
            if (!aVar.isVisible) {
                aVar.isVisible = true;
                aVar.nCS = System.currentTimeMillis();
                aVar.count++;
            }
            i++;
        }
    }

    public final void bzA() {
        super.bzA();
        bzN();
    }

    public final void bzB() {
        super.bzB();
        if (this.nCQ != null) {
            int fi = this.nCQ.fi();
            int fj = this.nCQ.fj();
            for (int i = fi; i <= fj; i++) {
                a aVar = (a) this.nCP.get(Integer.valueOf(i));
                if (aVar != null) {
                    aVar.bzO();
                }
            }
        }
    }

    public final boolean r(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.aa(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        try {
            Map map = this.nCP;
            Set set = this.nCR;
            this.nCR = new HashSet();
            this.nCP = new HashMap();
            for (Entry entry : map.entrySet()) {
                s sVar = (s) ((m) this.nDt).nAH.get(((Integer) entry.getKey()).intValue());
                if (!sVar.nBj && (sVar instanceof p)) {
                    p pVar = (p) sVar;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", ((s) ((m) this.nDt).nAH.get(((Integer) entry.getKey()).intValue())).nAW);
                    jSONObject2.put("exposureCount", ((a) entry.getValue()).count);
                    jSONObject2.put("stayTime", ((a) entry.getValue()).time);
                    if (set.contains(entry.getKey())) {
                        String ce = ac.ce(pVar.nAL);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("urlMd5", ce);
                        jSONObject3.put("needDownload", 1);
                        jSONObject2.put("imgUrlInfo", jSONObject3);
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            return true;
        } catch (Throwable e) {
            x.e("AdLandingCarouselComp", bi.i(e));
            return false;
        }
    }
}
