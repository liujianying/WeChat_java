package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public abstract class k extends a {
    int nDh = 0;

    public k(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
    }

    protected final void bzZ() {
        this.nDh++;
    }

    public final boolean aa(JSONObject jSONObject) {
        if (!super.aa(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("clickCount", this.nDh);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", e, "", new Object[0]);
            return false;
        }
    }
}
