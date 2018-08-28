package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomGrantPreference extends Preference {
    String eGB = "";
    TextView hND = null;

    public RoomGrantPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomGrantPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.mm_preference);
        setWidgetLayoutResource(R.i.mm_preference_submenu);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.mm_preference_content_room, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        if (this.hND == null) {
            this.hND = (TextView) view.findViewById(R.h.content_tv);
        }
        this.hND.setText(this.eGB);
        super.onBindView(view);
    }
}
