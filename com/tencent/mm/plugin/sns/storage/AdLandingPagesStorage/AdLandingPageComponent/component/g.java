package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class g extends b {
    private LinearLayout jeZ;
    private ImageView nDe;
    private TextView nDf;
    private LinearLayout nDg;
    int nDh;
    h nDo;
    private View nDp;
    private ImageView nDq;

    public g(Context context, h hVar, ViewGroup viewGroup) {
        super(context, hVar, viewGroup);
        this.nDo = hVar;
    }

    public final View bzM() {
        View view = this.contentView;
        this.nDq = (ImageView) view.findViewById(f.left_icon);
        this.nDe = (ImageView) view.findViewById(f.right_arrow);
        this.nDf = (TextView) view.findViewById(f.desc);
        this.nDg = (LinearLayout) view.findViewById(f.innter_container);
        this.jeZ = (LinearLayout) view.findViewById(f.container);
        this.nDp = this.nDg;
        return this.contentView;
    }

    protected final void bzQ() {
        this.nDf.setText(this.nDo.nAl.kCz);
        if (this.nDo.nBe) {
            this.nDq.setImageDrawable(a.f(this.context, e.lbs_w));
            this.nDe.setImageDrawable(a.f(this.context, e.right_arrow_w));
            this.nDf.setTextColor(-16777216);
            this.nDg.setBackgroundResource(e.adlanding_comp_click_dark);
        } else {
            this.nDq.setImageDrawable(a.f(this.context, e.lbs));
            this.nDe.setImageDrawable(a.f(this.context, e.right_arrow));
            this.nDf.setTextColor(-1);
            this.nDg.setBackgroundResource(e.adlanding_comp_click_light);
        }
        this.nDg.setPadding((int) this.nDo.nBa, 0, (int) this.nDo.nBb, 0);
        this.jeZ.setPadding(0, (int) this.nDo.nAY, 0, (int) this.nDo.nAZ);
        a(this.nDg);
        1 1 = new 1(this);
        if (this.nDp != null) {
            this.nDp.setOnClickListener(1);
        }
    }

    protected final int getLayout() {
        return com.tencent.mm.plugin.sns.i.g.sns_ad_native_landing_pages_item_lbs;
    }

    public final boolean aa(JSONObject jSONObject) {
        if (!super.aa(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("clickCount", this.nDh);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("AdLandingBorderedComp", e, "", new Object[0]);
            return false;
        }
    }
}
