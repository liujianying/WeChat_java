package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.InputPreference.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference extends Preference {
    private Context context;
    private TextView eSV;
    private String otc;
    String otd;
    private OnClickListener ote;
    OnClickListener otf;
    private a otg;
    private TextView oth;
    private OnClickListener oti;

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.otc = "";
        this.otd = "";
        this.ote = null;
        this.otf = null;
        this.otg = null;
        this.oth = null;
        this.eSV = null;
        this.oti = new 1(this);
        this.context = context;
        setLayoutResource(R.i.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.mm_preference_content_add_friend_search_item, viewGroup2);
        viewGroup2.setPadding(0, viewGroup2.getPaddingTop(), 0, viewGroup2.getPaddingBottom());
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        view.setOnTouchListener(new 2(this));
        this.oth = (TextView) view.findViewById(R.h.edittext);
        this.eSV = (TextView) view.findViewById(R.h.sepical_hint);
        this.eSV.setText(this.otd);
        if (this.otf != null) {
            this.eSV.setOnTouchListener(new 3(this));
        }
        if (this.otg != null) {
            Button button = (Button) view.findViewById(R.h.button);
            button.setOnClickListener(this.oti);
            button.setVisibility(0);
        }
    }
}
