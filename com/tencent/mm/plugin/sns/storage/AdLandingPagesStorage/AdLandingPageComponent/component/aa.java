package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class aa extends a {
    TextView ePz;
    private Runnable epp;

    public aa(Context context, u uVar, ViewGroup viewGroup) {
        super(context, uVar, viewGroup);
    }

    protected final int getLayout() {
        return g.sns_ad_native_landing_pages_item_text;
    }

    public final void bzz() {
        super.bzz();
        if (!e.remove(this.epp)) {
            e.S(this.epp);
        }
    }

    protected final void bzQ() {
        if (((u) this.nDt).bID != 1) {
            this.ePz.setText(((u) this.nDt).nBt);
        } else if (!bi.oW(((u) this.nDt).nBt)) {
            String replace = ((u) this.nDt).nBt.replace("<icon", "<img");
            e.remove(this.epp);
            this.epp = new 1(this, replace);
            e.post(this.epp, "");
        }
        if (((u) this.nDt).textAlignment == 0) {
            this.ePz.setGravity(3);
        } else if (((u) this.nDt).textAlignment == 1) {
            this.ePz.setGravity(17);
        } else if (((u) this.nDt).textAlignment == 2) {
            this.ePz.setGravity(5);
        }
        if (((u) this.nDt).nBu == null || ((u) this.nDt).nBu.length() <= 0) {
            this.ePz.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            try {
                this.ePz.setTextColor(Color.parseColor(((u) this.nDt).nBu));
            } catch (Exception e) {
                x.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((u) this.nDt).nBu);
            }
        }
        if (((u) this.nDt).duz > 0.0f) {
            this.ePz.setTextSize(0, ((u) this.nDt).duz);
        }
        TextPaint paint = this.ePz.getPaint();
        if (((u) this.nDt).nBv) {
            paint.setFakeBoldText(true);
        }
        if (((u) this.nDt).nBw) {
            paint.setTextSkewX(-0.25f);
        }
        if (((u) this.nDt).nBx) {
            paint.setUnderlineText(true);
        }
        if (((u) this.nDt).maxLines > 0) {
            this.ePz.setMaxLines(((u) this.nDt).maxLines);
        }
        if (((u) this.nDt).nBy == u.nBs) {
            this.ePz.setTypeface(ad.eg(this.context));
        }
    }

    @TargetApi(17)
    public final View bzM() {
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        view.findViewById(f.sns_ad_landingpage_text_layout).setBackgroundColor(this.backgroundColor);
        view.findViewById(f.sns_ad_landingpage_text_wordTitle).setBackgroundColor(this.backgroundColor);
        this.ePz = (TextView) view.findViewById(f.sns_ad_landingpage_text_wordTitle);
        return view;
    }

    public final void bzA() {
        super.bzA();
    }

    public final void bzB() {
        super.bzB();
    }
}
