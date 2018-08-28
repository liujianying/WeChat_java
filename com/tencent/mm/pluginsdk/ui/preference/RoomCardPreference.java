package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomCardPreference extends Preference {
    public boolean bIq = false;
    public CharSequence fyL;
    private LinearLayout gxf;
    private TextView qPr;
    public CharSequence qPs;

    public RoomCardPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomCardPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        viewGroup2.setPadding(0, 0, 0, 0);
        View.inflate(this.mContext, R.i.mm_preference_roominfo, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.h.content).findViewById(R.h.real_content);
        if (this.gxf == null) {
            this.gxf = (LinearLayout) viewGroup.getChildAt(1);
        }
        if (this.qPr == null) {
            this.qPr = (TextView) viewGroup.findViewById(R.h.room_info_notice);
        }
        if (this.bIq) {
            this.gxf.setVisibility(0);
            this.qPr.setVisibility(0);
        } else {
            this.gxf.setVisibility(8);
            this.qPr.setVisibility(8);
        }
        if (this.qPs != null) {
            this.qPr.setText(this.qPs);
        }
    }
}
