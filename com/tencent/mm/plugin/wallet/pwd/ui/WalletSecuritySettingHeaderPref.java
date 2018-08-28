package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletSecuritySettingHeaderPref extends Preference {
    private MMActivity bGc;
    TextView gVv;
    private TextView gzS;
    String iRT;
    private TextView pik;
    TextView pil;
    String pim;
    String pio;
    OnClickListener pip;
    OnClickListener piq;

    public WalletSecuritySettingHeaderPref(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.bGc = (MMActivity) context;
    }

    public WalletSecuritySettingHeaderPref(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pip = null;
        this.piq = null;
        this.bGc = (MMActivity) context;
        setLayoutResource(g.wallet_security_header_pref);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        x.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
        this.gzS = (TextView) view.findViewById(f.main_content);
        this.pik = (TextView) view.findViewById(f.desc);
        this.pil = (TextView) view.findViewById(f.details_text);
        this.gVv = (TextView) view.findViewById(f.wallet_security_close_btn);
        aL();
        if (!(this.pil == null || this.pip == null)) {
            this.pil.setOnClickListener(this.pip);
        }
        if (this.gVv != null && this.piq != null) {
            this.gVv.setOnClickListener(this.piq);
        }
    }

    final void aL() {
        if (!(bi.oW(this.iRT) || this.gzS == null)) {
            this.gzS.setText(this.iRT);
            this.gzS.setVisibility(0);
        }
        if (!(bi.oW(this.pim) || this.pik == null)) {
            this.pik.setText(this.pim);
            this.pik.setVisibility(0);
        }
        if (!(bi.oW(this.pio) || this.pil == null)) {
            this.pil.setText(this.pio);
            this.pil.setVisibility(0);
        }
        if (bi.oW(this.pio) && this.pil != null) {
            this.pil.setVisibility(8);
        }
    }
}
