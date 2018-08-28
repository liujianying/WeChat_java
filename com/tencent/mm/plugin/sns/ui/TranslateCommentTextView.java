package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;

public class TranslateCommentTextView extends LinearLayout {
    public SnsTranslateResultView nVv;
    public MaskTextView oic;

    public TranslateCommentTextView(Context context) {
        super(context);
        init();
    }

    public TranslateCommentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(g.timeline_comment_translate_item_layout, this);
        this.oic = (MaskTextView) findViewById(f.comment_textview);
        this.nVv = (SnsTranslateResultView) findViewById(f.sns_translate_result_view);
        this.nVv.setVisibility(8);
    }

    public TextView getOriginCommentTextView() {
        return this.oic;
    }

    public SnsTranslateResultView getTranslateResultView() {
        return this.nVv;
    }
}
