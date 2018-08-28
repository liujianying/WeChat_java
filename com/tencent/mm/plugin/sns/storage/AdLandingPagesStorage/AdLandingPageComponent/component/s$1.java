package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;

class s$1 implements OnClickListener {
    final /* synthetic */ l nFj;
    final /* synthetic */ s nFk;

    s$1(s sVar, l lVar) {
        this.nFk = sVar;
        this.nFj = lVar;
    }

    public final void onClick(View view) {
        this.nFk.bzZ();
        f bl = g.bl(this.nFj.nAt, true);
        if (bl == null || TextUtils.isEmpty(bl.field_packageName) || !this.nFk.t(view.getContext(), bl.field_packageName, g.b(view.getContext(), bl, null))) {
            this.nFk.bAb();
        }
    }
}
