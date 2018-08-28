package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
    String cZH;
    private Context context;
    private TextView eBO;
    private TextView lWL;
    private OnTouchListener lmH;
    private final int mIh = 5;
    private TextView mIi;
    public boolean mIj = false;
    public boolean mIk = false;
    private Boolean mIl;
    private OnGlobalLayoutListener mIm;
    a mIn;
    private View mView;

    public e(Activity activity) {
        super(activity);
        setLayoutResource(R.i.mm_preference_description_text);
        this.context = activity;
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.eBO == null) {
            this.eBO = (TextView) view.findViewById(16908310);
        }
        if (this.lWL == null) {
            this.lWL = (TextView) view.findViewById(16908304);
        }
        if (this.mIi == null) {
            this.mIi = (TextView) view.findViewById(R.h.more);
        }
        if (this.lmH == null) {
            this.lmH = new 1(this);
            this.mIi.setOnTouchListener(this.lmH);
        }
        if (this.mIn != null) {
            this.mIl = this.mIn.KI(this.mKey);
            if (this.mIl == null) {
                this.mIi.setVisibility(8);
                this.lWL.setMaxLines(6);
            } else if (this.mIl.booleanValue()) {
                this.mIi.setVisibility(8);
                this.lWL.setMaxLines(2000);
            } else {
                this.mIi.setVisibility(0);
                this.lWL.setMaxLines(5);
            }
        } else {
            this.mIi.setVisibility(8);
            this.lWL.setMaxLines(6);
        }
        if (this.mIm == null) {
            this.mIm = new 2(this);
            this.lWL.getViewTreeObserver().addOnGlobalLayoutListener(this.mIm);
        }
        if (bi.oW(this.cZH)) {
            this.eBO.setVisibility(8);
            return;
        }
        this.eBO.setText(this.cZH);
        this.eBO.setVisibility(0);
    }
}
