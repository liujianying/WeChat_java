package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends b {
    LinearLayout jeZ;
    private ImageView nDd;
    private ImageView nDe;
    private TextView nDf;
    LinearLayout nDg;
    int nDh;

    public d(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d dVar, ViewGroup viewGroup) {
        super(context, dVar, viewGroup);
    }

    protected final int getLayout() {
        return g.sns_ad_native_landing_pages_item_lbs;
    }

    protected final void bzQ() {
        this.nDf.setText((CharSequence) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.nDt).nAj.get(0));
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.nDt).nBe) {
            this.nDd.setImageDrawable(a.f(this.context, e.tel_w));
            this.nDe.setImageDrawable(a.f(this.context, e.right_arrow_w));
            this.nDf.setTextColor(-16777216);
            this.nDg.setBackgroundResource(e.adlanding_comp_click_dark);
        } else {
            this.nDd.setImageDrawable(a.f(this.context, e.tel));
            this.nDe.setImageDrawable(a.f(this.context, e.right_arrow));
            this.nDf.setTextColor(-1);
            this.nDg.setBackgroundResource(e.adlanding_comp_click_light);
        }
        this.nDg.setPadding((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.nDt).nBa, 0, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.nDt).nBb, 0);
        this.jeZ.setPadding(0, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.nDt).nAY, 0, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.nDt).nAZ);
        a(this.nDg);
        this.nDg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                d dVar = d.this;
                dVar.nDh++;
                if (c.a.qPG != null) {
                    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) d.this.nDt).nAj.size() > 1) {
                        c.a.qPG.a(d.this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) d.this.nDt).nAj, new 1(this));
                    } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) d.this.nDt).nAj.size() > 0) {
                        AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) d.this.context, (String) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) d.this.nDt).nAj.get(0));
                    }
                }
            }
        });
    }

    public final View bzM() {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.nDt).nAj.isEmpty()) {
            return null;
        }
        View view = this.contentView;
        this.nDd = (ImageView) view.findViewById(f.left_icon);
        this.nDe = (ImageView) view.findViewById(f.right_arrow);
        this.nDf = (TextView) view.findViewById(f.desc);
        this.jeZ = (LinearLayout) view.findViewById(f.container);
        this.nDg = (LinearLayout) view.findViewById(f.innter_container);
        return this.contentView;
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
