package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;

public final class m extends a {
    CircularImageView nDJ;

    public m(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
    }

    protected final View bzR() {
        return new CircularImageView(this.context);
    }

    public final View bzM() {
        this.nDJ = (CircularImageView) this.contentView;
        return this.contentView;
    }

    protected final void bzQ() {
        if (this.contentView != null && this.nDJ != null) {
            p pVar = (p) this.nDt;
            if (pVar != null) {
                d.a(pVar.nAL, pVar.nAX, new 1(this));
            }
        }
    }
}
