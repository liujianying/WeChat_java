package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q extends a {
    private h nDl;
    LinearLayout nEE;

    public q(Context context, r rVar, ViewGroup viewGroup) {
        super(context, rVar, viewGroup);
    }

    public final void bzA() {
        super.bzA();
        for (i bzA : this.nDl.bAu()) {
            bzA.bzA();
        }
    }

    public final void W(int i, int i2, int i3) {
        super.W(i, i2, i3);
        for (i W : this.nDl.bAu()) {
            W.W(i, i2, i3);
        }
    }

    public final void bzB() {
        super.bzB();
        for (i bzB : this.nDl.bAu()) {
            bzB.bzB();
        }
    }

    public final void bzz() {
        super.bzz();
        for (i bzz : this.nDl.bAu()) {
            bzz.bzz();
        }
    }

    protected final void bzQ() {
        if (((r) this.nDt).nAV == 0) {
            this.nEE.setOrientation(1);
        } else if (((r) this.nDt).nAV == 1) {
            this.nEE.setOrientation(0);
        }
        if (this.nDl == null) {
            this.nDl = new h(((r) this.nDt).nAU, this.context, ((r) this.nDt).bgColor, this.nEE);
            this.nDl.bAD();
            return;
        }
        this.nDl.cl(((r) this.nDt).nAU);
    }

    public final View bzM() {
        View view = this.contentView;
        this.nEE = (LinearLayout) view.findViewById(i$f.sns_ad_native_landing_pages_item_page_linear_layout);
        return view;
    }

    protected final int getLayout() {
        return i$g.sns_ad_native_landing_pages_item_linear_layout;
    }

    public final boolean r(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.aa(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        for (i iVar : this.nDl.bAu()) {
            JSONObject jSONObject2 = new JSONObject();
            if (iVar != null && iVar.aa(jSONObject2)) {
                jSONArray.put(jSONObject2);
            }
        }
        return true;
    }
}
