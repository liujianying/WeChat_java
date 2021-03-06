package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomContributePreference extends Preference {
    private ImageView eBM;
    private MaskLayout hNB;
    private String hNC;

    public RoomContributePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public RoomContributePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.mm_preference);
        setWidgetLayoutResource(R.i.mm_preference_image_right);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        this.hNB = (MaskLayout) onCreateView.findViewById(R.h.image_mask);
        this.eBM = (ImageView) onCreateView.findViewById(R.h.image);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.eBM != null && !bi.oW(this.hNC)) {
            b.a(this.eBM, this.hNC);
        }
    }
}
