package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference extends Preference {
    private MMActivity bGc;
    private String cZH;
    private String mQi;
    private int mQj;
    private int mQk;
    private TextView nTm;
    String nTn;

    public SnsArtistPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.bGc = (MMActivity) context;
    }

    public SnsArtistPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mQi = "";
        this.cZH = "";
        this.mQj = -1;
        this.mQk = 8;
        this.nTm = null;
        this.nTn = "";
        this.bGc = (MMActivity) context;
        setLayoutResource(g.mm_preference);
        setWidgetLayoutResource(g.mm_preference_submenu);
    }

    public final void bCU() {
        if (this.nTm != null && this.nTn != null && !this.nTn.equals("") && this.bGc != null) {
            this.nTm.setText(this.bGc.getString(j.settings_sns_bg_from_artist, new Object[]{this.nTn}));
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        this.cZH = this.bGc.getString(j.settings_sns_bg_select_bg);
        layoutInflater.inflate(g.mm_preference_artist, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.nTm = (TextView) view.findViewById(f.artist_name);
        ((TextView) view.findViewById(f.album_title)).setText(this.cZH);
        TextView textView = (TextView) view.findViewById(f.text_tv_one);
        if (textView != null) {
            textView.setVisibility(this.mQk);
            textView.setText(this.mQi);
            if (this.mQj != -1) {
                textView.setBackgroundDrawable(a.f(this.bGc, this.mQj));
            }
        }
        bCU();
    }
}
