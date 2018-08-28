package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMSingelLinePanel;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;

public class ContactLabelPreference extends Preference {
    private TextView eBO;
    private MMSingelLinePanel lUM;
    private ArrayList<String> lUN;
    private String title;

    public ContactLabelPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ContactLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lUN = new ArrayList();
        setLayoutResource(R.i.mm_preference);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.mm_preference_content_label_info, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.eBO = (TextView) view.findViewById(R.h.title);
        this.lUM = (MMSingelLinePanel) view.findViewById(R.h.contact_label_panel);
        this.lUM.setSingleLine(true);
        this.lUM.txB = false;
        this.lUM.lL(false);
        if (this.eBO != null) {
            this.eBO.setText(this.title);
        }
        if (!(this.lUM == null || this.lUN == null || this.lUN.size() <= 0)) {
            this.lUM.a(this.lUN, this.lUN);
        }
        super.onBindView(view);
    }
}
