package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends a {
    private List<i> ayR = new ArrayList();
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e nDk;
    private h nDl;

    public e(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e eVar, ViewGroup viewGroup) {
        super(context, eVar, viewGroup);
        this.nDk = eVar;
    }

    protected final void bzQ() {
        if (this.nDl == null) {
            this.nDl = new h(this.nDk.ayR, this.context, 0, (FrameLayout) this.contentView);
            this.nDl.bAD();
            return;
        }
        this.nDl.cl(this.nDk.ayR);
    }

    protected final View bzR() {
        return new FrameLayout(this.context);
    }

    public final void bzA() {
        super.bzA();
        for (i bzA : this.ayR) {
            bzA.bzA();
        }
    }

    public final void bzB() {
        super.bzB();
        for (i bzB : this.ayR) {
            bzB.bzB();
        }
    }

    public final void W(int i, int i2, int i3) {
        super.W(i, i2, i3);
        for (i W : this.ayR) {
            W.W(i, i2, i3);
        }
    }

    public final void bzz() {
        super.bzz();
        for (i bzz : this.ayR) {
            bzz.bzz();
        }
    }

    public final boolean r(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.aa(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        for (i iVar : this.ayR) {
            JSONObject jSONObject2 = new JSONObject();
            if (iVar != null && iVar.aa(jSONObject2)) {
                jSONArray.put(jSONObject2);
            }
        }
        return true;
    }

    public final void a(s sVar) {
        if (sVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) {
            this.nDk = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) sVar;
        }
        super.a(sVar);
    }
}
