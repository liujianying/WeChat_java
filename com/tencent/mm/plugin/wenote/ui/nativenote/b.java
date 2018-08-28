package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class b extends com.tencent.mm.pluginsdk.ui.b.b {
    private TextView eBO = null;

    public b(Context context) {
        super(context);
        if (this.view != null) {
            this.eBO = (TextView) this.view.findViewById(R.h.wenote_banner_text_view);
            this.eBO.setTextSize(0, (float) a.ad(this.eBO.getContext(), R.f.HintTextSize));
            this.view.setOnClickListener(new 1(this));
        }
    }

    public final int getLayoutId() {
        return R.i.wenote_banner_view;
    }

    public final int getOrder() {
        return 0;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.wenote_banner_view).setVisibility(i);
        }
    }

    public final boolean anR() {
        boolean z;
        p bZY = h.bZX().bZY();
        if (bZY != null && bZY.qpf && bZY.qph > 0 && !bi.oW(bZY.qpk)) {
            z = true;
        } else if (bZY == null || bZY.qpf || f.eo(bZY.qpg) == null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            CharSequence charSequence = bZY.qpj;
            if (this.eBO != null) {
                this.eBO.setText(charSequence);
            }
            setVisibility(0);
            return true;
        }
        if (bZY != null) {
            h.bZX().a(null);
        }
        setVisibility(8);
        return false;
    }
}
