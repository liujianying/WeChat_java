package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;

public final class v extends i {
    TextView ePz;
    private RelativeLayout nFv;
    ImageView nFw;

    public v(Context context, t tVar, ViewGroup viewGroup) {
        super(context, tVar, viewGroup);
        this.nDt = tVar;
    }

    protected final int getLayout() {
        return g.sns_ad_native_landing_pages_item_process_bar;
    }

    public final void bzz() {
        super.bzz();
    }

    protected final void bzQ() {
        this.ePz.setText(((t) this.nDt).label);
        this.ePz.setTextSize(0, ((t) this.nDt).azb);
        if (((t) this.nDt).fpc != null && ((t) this.nDt).fpc.length() > 0) {
            this.nFv.setBackgroundColor(Color.parseColor(((t) this.nDt).fpc));
        }
        d.a(((t) this.nDt).nBn, ((t) this.nDt).nAX, new 1(this));
    }

    public final View bzM() {
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        this.ePz = (TextView) view.findViewById(f.sns_ad_landingpage_processbar_label);
        this.nFv = (RelativeLayout) view.findViewById(f.sns_ad_landingpage_processbar_bg);
        this.nFw = (ImageView) view.findViewById(f.sns_ad_landingpage_processbar_front);
        return view;
    }

    public final void bzA() {
        super.bzA();
    }

    public final void bzB() {
        super.bzB();
    }
}
