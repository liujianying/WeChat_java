package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference extends Preference {
    private MMActivity bGc;
    private String cZH;
    private TextView eBO;
    private TextView eYC;
    private ImageView gxd;
    private int iRP;
    private Button iRQ;
    private View iRR;
    private OnClickListener iRS;
    private String iRT;
    private String iRU;

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.bGc = (MMActivity) context;
    }

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZH = "";
        this.iRP = 255;
        this.iRS = null;
        this.iRT = "";
        this.iRU = "";
        this.bGc = (MMActivity) context;
        setLayoutResource(R.i.voice_print_pref_header);
    }

    public final void cH(String str, String str2) {
        this.iRT = str;
        this.iRU = str2;
        if (this.eBO != null) {
            if (bi.oW(this.iRT)) {
                this.eBO.setVisibility(8);
            } else {
                this.eBO.setText(this.iRT);
                this.eBO.setVisibility(0);
            }
        }
        if (this.eYC == null) {
            return;
        }
        if (bi.oW(this.iRU)) {
            this.eYC.setVisibility(8);
            return;
        }
        this.eYC.setText(this.iRU);
        this.eYC.setVisibility(0);
    }

    public final void a(OnClickListener onClickListener) {
        this.iRS = onClickListener;
        if (this.iRQ != null && this.iRR != null) {
            if (this.iRQ == null || this.iRS == null) {
                this.iRQ.setVisibility(8);
                this.iRR.setVisibility(8);
                return;
            }
            this.iRQ.setOnClickListener(onClickListener);
            this.iRQ.setVisibility(0);
            this.iRR.setVisibility(0);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.gxd = (ImageView) view.findViewById(R.h.voice_print_sucesss_icon);
        this.eBO = (TextView) view.findViewById(R.h.voice_print_title);
        this.eYC = (TextView) view.findViewById(R.h.voice_print_title_tip);
        this.iRQ = (Button) view.findViewById(R.h.right_btn);
        this.iRR = view.findViewById(R.h.button_ll);
        if (bi.oW(this.iRT)) {
            this.eBO.setVisibility(8);
        } else {
            this.eBO.setText(this.iRT);
            this.eBO.setVisibility(0);
        }
        if (bi.oW(this.iRU)) {
            this.eYC.setVisibility(8);
        } else {
            this.eYC.setText(this.iRU);
            this.eYC.setVisibility(0);
        }
        if (this.iRQ == null || this.iRS == null) {
            this.iRQ.setVisibility(8);
            this.iRR.setVisibility(8);
            return;
        }
        this.iRQ.setOnClickListener(this.iRS);
        this.iRQ.setVisibility(0);
        this.iRR.setVisibility(0);
    }
}
