package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.am.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.Preference;

public final class c extends Preference {
    String cYO = null;
    String cZH = null;
    private TextView gsY = null;
    private ImageView hVP = null;
    private Context mContext = null;
    private View mView = null;

    public c(Context context) {
        super(context);
        this.mContext = context;
        setLayoutResource(g.collect_pay_info_preference);
    }

    public c(Context context, int i) {
        super(context);
        this.mContext = context;
        setLayoutResource(i);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.gsY = (TextView) view.findViewById(16908310);
        this.hVP = (ImageView) view.findViewById(f.collect_payer_avatar);
        this.gsY.setText(j.a(this.mContext, this.cZH, this.gsY.getTextSize()));
        if (bi.oW(this.cYO)) {
            this.hVP.setVisibility(8);
            return;
        }
        this.hVP.setVisibility(0);
        com.tencent.mm.kernel.g.Ek();
        ab Yf = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yf(this.cYO);
        if (Yf == null || ((int) Yf.dhP) <= 0) {
            x.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
            a.dBr.a(this.cYO, "", new 1(this, bi.VF()));
            return;
        }
        b.a(this.hVP, this.cYO);
    }
}
