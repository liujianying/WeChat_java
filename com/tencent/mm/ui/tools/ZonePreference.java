package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference extends Preference {
    Region uCD;
    private CharSequence uCE;
    private TextView uCF;

    public ZonePreference(Context context) {
        this(context, null);
    }

    public ZonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZonePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.mm_preference);
    }

    public final void a(Region region) {
        if (region == null || ai.oW(region.getName()) || ai.oW(region.getCode())) {
            x.e("MicroMsg.ZonePreference", "setZoneItem item = null");
            return;
        }
        setKey(region.getCode() + region.isCity());
        this.uCD = region;
    }

    public final void setSummary(CharSequence charSequence) {
        this.uCE = charSequence;
        czW();
    }

    private void czW() {
        if (this.uCF != null) {
            if (this.uCE == null || ai.oW(this.uCE.toString())) {
                this.uCF.setVisibility(8);
            } else {
                this.uCF.setVisibility(0);
            }
            this.uCF.setText(this.uCE);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.mm_preference_content_zone, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.uCD != null) {
            ((TextView) view.findViewById(R.h.zonename)).setText(this.uCD.getName());
            this.uCF = (TextView) view.findViewById(R.h.summery);
            czW();
        }
    }
}
