package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.q;

public class AppHeaderPreference extends Preference {
    boolean ccZ = false;
    private ImageView eBM;
    private TextView eBR;
    private boolean eFt = false;
    private TextView eZp;
    private TextView lWV;
    a osE;

    public AppHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        this.eBM = (ImageView) view.findViewById(R.h.contact_info_avatar_iv);
        this.eBR = (TextView) view.findViewById(R.h.contact_info_status_tv);
        this.lWV = (TextView) view.findViewById(R.h.contact_info_nickname_tv);
        this.eZp = (TextView) view.findViewById(R.h.contact_info_helper_hing_tv);
        this.eFt = true;
        if (!this.eFt || this.osE == null) {
            x.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.eFt);
        } else {
            Bitmap bGx = this.osE.bGx();
            if (!(this.eBM == null || bGx == null || bGx.isRecycled())) {
                this.eBM.setImageBitmap(bGx);
            }
            CharSequence bGw = this.osE.bGw();
            if (!(this.lWV == null || bGw == null || bGw.length() <= 0)) {
                this.lWV.setText(bGw);
            }
            bGw = this.osE.getHint();
            if (bGw != null) {
                this.eZp.setText(bGw);
                this.eZp.setVisibility(0);
            } else {
                this.eZp.setVisibility(8);
            }
            boolean z = this.ccZ;
            if (this.eBR != null) {
                CharSequence ix = this.osE.ix(z);
                if (z) {
                    if (ix == null || ix.length() <= 0) {
                        this.eBR.setVisibility(8);
                    } else {
                        this.eBR.setTextColor(q.hb(this.mContext));
                        this.eBR.setText(ix);
                        this.eBR.setCompoundDrawablesWithIntrinsicBounds(R.g.status_enable, 0, 0, 0);
                    }
                } else if (ix == null || ix.length() <= 0) {
                    this.eBR.setVisibility(8);
                } else {
                    this.eBR.setTextColor(q.hc(this.mContext));
                    this.eBR.setText(ix);
                    this.eBR.setCompoundDrawablesWithIntrinsicBounds(R.g.status_disable, 0, 0, 0);
                }
            }
        }
        super.onBindView(view);
    }
}
