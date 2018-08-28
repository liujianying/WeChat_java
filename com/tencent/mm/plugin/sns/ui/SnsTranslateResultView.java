package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.tools.i;

public class SnsTranslateResultView extends LinearLayout {
    private static final int ofA = Color.parseColor("#19000000");
    private Drawable dXQ;
    private TextView mLa;
    private int ofB = -1;
    private float ofC = -1.0f;
    private int ofD = -1;
    private TextView ofy;
    private View ofz;

    public SnsTranslateResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(g.translate_result_layout, this);
        this.ofy = (TextView) findViewById(f.sns_translate_brand_tv);
        this.mLa = (TextView) findViewById(f.sns_translate_result_tv);
        this.ofz = findViewById(f.translate_split);
        this.dXQ = getResources().getDrawable(e.sns_translate_loading_icon);
        this.dXQ.setBounds(0, 0, (int) (this.mLa.getTextSize() * 0.8f), (int) (this.mLa.getTextSize() * 0.8f));
        this.dXQ.setColorFilter(ofA, Mode.SRC_IN);
    }

    public final void xD(int i) {
        this.mLa.setCompoundDrawables(this.dXQ, null, null, null);
        this.mLa.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
        this.mLa.setText(j.sns_translating);
        i.a(this.mLa, null);
        this.ofy.setVisibility(4);
        this.ofB = i;
        this.mLa.setTextSize(0, this.ofy.getTextSize());
        this.mLa.setTextColor(getContext().getResources().getColor(c.sns_translate_loading_text_color));
    }

    public TextView getResultTextView() {
        return this.mLa;
    }

    public View getSplitlineView() {
        return this.ofz;
    }

    public final void setResultTextSize$255e752(float f) {
        this.mLa.setTextSize(1, f);
        this.ofC = f;
        this.ofD = 1;
    }

    public void setResultTextSize(float f) {
        this.mLa.setTextSize(0, f);
        this.ofC = f;
        this.ofD = 0;
    }

    @TargetApi(11)
    public final void a(b bVar, int i, String str, String str2, boolean z) {
        this.ofB = i;
        if (this.ofC != -1.0f || this.ofD != -1) {
            this.mLa.setTextSize(this.ofD, this.ofC);
        } else if (this.ofB == 2) {
            this.mLa.setTextSize(1, 14.0f * a.fe(getContext()));
        } else if (this.ofB == 1) {
            this.mLa.setTextSize(1, 15.0f * a.fe(getContext()));
        }
        if (this.ofB == 2) {
            this.mLa.setTextColor(getContext().getResources().getColor(c.sns_translate_comment_result_color));
        } else if (this.ofB == 1) {
            this.mLa.setTextColor(getContext().getResources().getColor(c.sns_translate_post_result_color));
        }
        if (bi.oW(str)) {
            this.mLa.setText(j.sns_translate_failed);
        } else {
            this.mLa.setText(str);
            com.tencent.mm.pluginsdk.ui.d.j.g(this.mLa, 2);
        }
        this.mLa.setCompoundDrawables(null, null, null, null);
        if (z && d.fR(11)) {
            i.a(this.mLa, new 1(this, bVar));
        }
        if (bi.oW(str2)) {
            this.ofy.setText(j.chatting_translate_status_got);
        } else {
            this.ofy.setText(str2);
        }
        this.ofy.setVisibility(0);
    }
}
