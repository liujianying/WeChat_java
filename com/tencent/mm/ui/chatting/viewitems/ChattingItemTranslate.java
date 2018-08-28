package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.widget.MMNeatTextView;

public class ChattingItemTranslate extends RelativeLayout {
    private SpannableStringBuilder qHp = new SpannableStringBuilder();
    private CharacterStyle qHs = new ForegroundColorSpan(-5066062);
    private int qHv = 3;
    private MMNeatTextView ueh;
    private LinearLayout uei;
    private ProgressBar uej;
    private TextView uek;
    private com.tencent.neattextview.textview.view.NeatTextView.b uel;
    private boolean uem;
    private GestureDetector uen = new GestureDetector(getContext(), new SimpleOnGestureListener() {
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            if (ChattingItemTranslate.this.uel == null) {
                return false;
            }
            return ChattingItemTranslate.this.uel.dK(ChattingItemTranslate.this.ueh);
        }
    });

    public static class a extends au {
        public int hER = 1;

        public a(bd bdVar, boolean z, int i) {
            super(bdVar, z, i, null, 0);
        }
    }

    public enum b {
        NoTransform,
        PreTransform,
        Transforming,
        Transformed
    }

    public ChattingItemTranslate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void init() {
        this.ueh = (MMNeatTextView) findViewById(R.h.chatting_voice_play_transform_text);
        this.uej = (ProgressBar) findViewById(R.h.chatting_voice_play_transform_textload);
        this.uei = (LinearLayout) findViewById(R.h.chatting_voice_play_transform_finish_icon_layout);
        this.uek = (TextView) findViewById(R.h.chatting_voice_play_transform_finish_icon);
        this.ueh.setOnTouchListener(new f(this.ueh, new m(this.ueh.getContext())));
    }

    public final void a(CharSequence charSequence, b bVar) {
        if (!bi.K(charSequence)) {
            this.ueh.setMinWidth(com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 80));
            this.ueh.setMaxWidth(com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 259));
            this.ueh.setVisibility(0);
            if (bVar == b.Transforming) {
                CharSequence charSequence2;
                this.qHp.clear();
                MMNeatTextView mMNeatTextView = this.ueh;
                SpannableStringBuilder spannableStringBuilder = this.qHp;
                if (spannableStringBuilder == null || charSequence == null || charSequence.length() == 0) {
                    charSequence2 = spannableStringBuilder;
                } else {
                    int length;
                    int i;
                    if (charSequence.length() < this.qHv) {
                        length = charSequence.length();
                        i = 0;
                    } else {
                        length = charSequence.length();
                        i = length - this.qHv;
                    }
                    spannableStringBuilder.append(charSequence).setSpan(this.qHs, i, length, 33);
                    Object charSequence22 = spannableStringBuilder;
                }
                mMNeatTextView.Q(charSequence22);
            } else {
                this.ueh.Q(charSequence);
            }
            this.uej.setVisibility(8);
            if (bVar == b.Transformed) {
                mf(true);
            } else {
                mf(false);
            }
        } else if (bVar != b.NoTransform) {
            this.uej.setVisibility(0);
            this.ueh.setVisibility(8);
            mf(false);
        }
        setVisibility(0);
    }

    public void setBrandWording(String str) {
        this.uek.setText(str);
    }

    public void setOnDoubleClickListener(com.tencent.neattextview.textview.view.NeatTextView.b bVar) {
        this.uel = bVar;
    }

    private void mf(boolean z) {
        Context context = ad.getContext();
        if (context != null) {
            if (z) {
                this.ueh.setPadding(com.tencent.mm.bp.a.fromDPToPix(context, 10), com.tencent.mm.bp.a.fromDPToPix(context, 8), com.tencent.mm.bp.a.fromDPToPix(context, 10), com.tencent.mm.bp.a.fromDPToPix(context, 4));
                this.uei.setVisibility(0);
                return;
            }
            this.ueh.setPadding(com.tencent.mm.bp.a.fromDPToPix(context, 10), com.tencent.mm.bp.a.fromDPToPix(context, 8), com.tencent.mm.bp.a.fromDPToPix(context, 10), com.tencent.mm.bp.a.fromDPToPix(context, 8));
            this.uei.setVisibility(8);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = action == 1 && this.uem;
        if (z) {
            x.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
            return true;
        }
        boolean z2;
        if (action == 0) {
            this.uem = false;
        }
        if (this.uel == null || this.uen == null) {
            z2 = false;
        } else {
            z2 = this.uen.onTouchEvent(motionEvent);
        }
        if (z2) {
            return z2;
        }
        return super.onTouchEvent(motionEvent);
    }
}
