package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.smtt.sdk.WebView;

public final class FaceHeaderPreference extends Preference {
    private MMActivity bGc;
    private String cZH;
    private TextView eBO;
    private ImageView gxd;
    private int iRP;
    private Button iRQ;
    private View iRR;
    private OnClickListener iRS;
    private String iRT;
    private String iRU;

    public FaceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.bGc = (MMActivity) context;
    }

    public FaceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZH = "";
        this.iRP = WebView.NORMAL_MODE_ALPHA;
        this.iRS = null;
        this.iRT = "";
        this.iRU = "";
        this.bGc = (MMActivity) context;
        setLayoutResource(g.face_print_pref_header);
    }

    public final void cH(String str, String str2) {
        this.iRT = str;
        this.iRU = str2;
        if (this.eBO == null) {
            return;
        }
        if (bi.oW(this.iRT)) {
            this.eBO.setVisibility(8);
            return;
        }
        this.eBO.setText(this.iRT);
        this.eBO.setVisibility(0);
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
        this.gxd = (ImageView) view.findViewById(e.face_print_sucesss_icon);
        this.eBO = (TextView) view.findViewById(e.face_print_title);
        this.iRQ = (Button) view.findViewById(e.right_btn);
        this.iRR = view.findViewById(e.button_ll);
        if (bi.oW(this.iRT)) {
            this.eBO.setVisibility(8);
        } else {
            this.eBO.setText(this.iRT);
            this.eBO.setVisibility(0);
        }
        if (this.iRQ == null || this.iRS == null) {
            if (this.iRQ != null) {
                this.iRQ.setVisibility(8);
            }
            this.iRR.setVisibility(8);
            return;
        }
        this.iRQ.setOnClickListener(this.iRS);
        this.iRQ.setVisibility(0);
        this.iRR.setVisibility(0);
    }
}
