package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class MusicPreference extends Preference {
    private boolean hTT;
    public String mFv;
    public String mFw;
    public String mFx;
    private ImageButton mIx;
    a mIy;
    private View mView;
    private OnClickListener mtE;

    public MusicPreference(Context context) {
        this(context, null);
    }

    public MusicPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mView = null;
        this.mIx = null;
        this.mFv = "";
        this.mFw = "";
        this.mFx = "";
        setLayoutResource(R.i.mm_preference_music);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    public final void hv(boolean z) {
        this.hTT = z;
        if (this.mIx == null) {
            return;
        }
        if (z) {
            this.mIx.setImageResource(R.g.product_music_stop_btn);
        } else {
            this.mIx.setImageResource(R.g.product_music_play_btn);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.mtE == null) {
            this.mtE = new OnClickListener() {
                public final void onClick(View view) {
                    if (MusicPreference.this.mIy != null && view.getId() == R.h.pref_music_play_ib) {
                        if (MusicPreference.this.hTT) {
                            MusicPreference.this.hTT = false;
                            MusicPreference.this.mIx.setImageResource(R.g.product_music_play_btn);
                        } else {
                            MusicPreference.this.hTT = true;
                            MusicPreference.this.mIx.setImageResource(R.g.product_music_stop_btn);
                        }
                        MusicPreference.this.mIy.d(MusicPreference.this);
                    }
                }
            };
        }
        this.mIx = (ImageButton) view.findViewById(R.h.pref_music_play_ib);
        this.mIx.setOnClickListener(this.mtE);
        if (this.hTT) {
            this.mIx.setImageResource(R.g.product_music_stop_btn);
        } else {
            this.mIx.setImageResource(R.g.product_music_play_btn);
        }
    }
}
