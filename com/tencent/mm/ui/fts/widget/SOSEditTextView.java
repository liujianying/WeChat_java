package com.tencent.mm.ui.fts.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;

public class SOSEditTextView extends FTSEditTextView {
    private View utM;

    public SOSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SOSEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void aQS() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.i.sos_edittext_view, this, true);
    }

    @SuppressLint({"WrongViewCast"})
    protected final void init() {
        super.init();
        this.utM = findViewById(R.h.voice_btn_container);
        getEditText().setOnFocusChangeListener(null);
        getEditText().setHintTextColor(getResources().getColor(R.e.light_bg_hint_color));
        getEditText().setTextColor(getResources().getColor(R.e.normal_text_color));
    }

    public final void czi() {
        getEditText().setOnFocusChangeListener(this.jzz);
    }

    public void setIconRes(Drawable drawable) {
        getIconView().setImageDrawable(drawable);
    }

    public void setVoiceImageButtonVisibile(int i) {
        if (this.utM != null) {
            this.utM.setVisibility(i);
        }
    }

    public void setVoiceBtnClickListener(OnClickListener onClickListener) {
        if (this.utM != null) {
            this.utM.setOnClickListener(onClickListener);
        }
    }
}
