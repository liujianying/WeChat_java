package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference extends Preference {
    private String bWI;
    private String cCR;
    Bitmap dHf = null;
    private TextView eMf = null;
    ImageView jev = null;
    private TextView mQc = null;
    int mQd = -1;
    String mQe = null;
    private OnClickListener mQf;
    private String username;

    public PersonalPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PersonalPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(g.mm_preference);
        setWidgetLayoutResource(g.mm_preference_submenu);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, g.mm_preference_content_personal, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        if (this.jev == null) {
            this.jev = (ImageView) view.findViewById(f.image_iv);
        }
        if (this.dHf != null) {
            this.jev.setImageBitmap(this.dHf);
        } else if (this.mQd > 0) {
            this.jev.setImageResource(this.mQd);
        } else if (this.mQe != null) {
            b.a(this.jev, this.mQe);
        }
        this.jev.setOnClickListener(this.mQf);
        if (!(this.eMf == null || this.bWI == null)) {
            this.eMf.setText(j.a(this.mContext, this.bWI, this.eMf.getTextSize()));
        }
        if (this.mQc != null) {
            String str = bi.oW(this.cCR) ? this.username : this.cCR;
            if (bi.oW(this.cCR) && ab.XT(this.username)) {
                this.mQc.setVisibility(8);
            }
            this.mQc.setText(this.mContext.getString(i.app_field_username) + str);
        }
        super.onBindView(view);
    }
}
