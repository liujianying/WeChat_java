package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.f;

public class VoiceSearchEditText extends EditText {
    private Context context;
    public String gLA = "";
    private OnClickListener mVS;
    final Drawable tBo = getResources().getDrawable(f.voicesearch_enter_btn);
    final Drawable tBp = null;
    final Drawable tBq = getResources().getDrawable(f.search_clear);
    private a tBr;
    private boolean tBs = true;
    private boolean tBt = false;
    private boolean tBu = false;

    static /* synthetic */ void e(VoiceSearchEditText voiceSearchEditText) {
        x.d("MicroMsg.VoiceSearchEditText", "checkView");
        if (voiceSearchEditText.getText().toString().equals("") && voiceSearchEditText.tBt) {
            voiceSearchEditText.tBs = true;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.tBp, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.tBo, voiceSearchEditText.getCompoundDrawables()[3]);
        } else if (voiceSearchEditText.getText().toString().length() > 0) {
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.tBp, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.tBq, voiceSearchEditText.getCompoundDrawables()[3]);
        } else {
            voiceSearchEditText.tBs = false;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.tBp, voiceSearchEditText.getCompoundDrawables()[1], null, voiceSearchEditText.getCompoundDrawables()[3]);
        }
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void setNeedIcon(boolean z) {
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.mVS = onClickListener;
        this.tBt = true;
        csg();
    }

    public void setOnContentClearListener(a aVar) {
        this.tBr = aVar;
    }

    private void init(Context context) {
        this.context = context;
        this.tBt = false;
        this.tBo.setBounds(0, 0, this.tBo.getIntrinsicWidth(), this.tBo.getIntrinsicHeight());
        this.tBq.setBounds(0, 0, this.tBq.getIntrinsicWidth(), this.tBq.getIntrinsicHeight());
        csg();
        setOnTouchListener(new 1(this));
        addTextChangedListener(new 2(this));
        setOnFocusChangeListener(new 3(this));
        if (context instanceof Activity) {
            View currentFocus = ((Activity) context).getCurrentFocus();
            if (currentFocus == null || currentFocus != this) {
                this.tBu = false;
            } else {
                this.tBu = true;
            }
        }
        requestFocus();
    }

    private void csg() {
        this.tBs = true;
        if (this.tBt) {
            setCompoundDrawables(this.tBp, getCompoundDrawables()[1], this.tBo, getCompoundDrawables()[3]);
        } else if (getText().toString().length() > 0) {
            setCompoundDrawables(this.tBp, getCompoundDrawables()[1], this.tBq, getCompoundDrawables()[3]);
        } else {
            setCompoundDrawables(this.tBp, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        }
    }
}
