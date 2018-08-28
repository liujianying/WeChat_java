package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;

public final class n extends h {
    private final ag qoF = new 2(this);
    public LinearLayout qvT;
    public LinearLayout qvU;
    public NoteEditorVoiceBaseView qvV;
    public ImageView qvW;
    private TextView qvX;
    private TextView qvY;
    private k qvZ;

    public n(View view, com.tencent.mm.plugin.wenote.model.nativenote.manager.k kVar) {
        super(view, kVar);
        this.qvT = (LinearLayout) view.findViewById(R.h.note_voice_record_ll);
        this.qvU = (LinearLayout) view.findViewById(R.h.note_voice_play_ll);
        this.qvW = (ImageView) view.findViewById(R.h.note_voice_record_red_point);
        this.qvX = (TextView) view.findViewById(R.h.note_voice_recording_tips);
        this.qvY = (TextView) view.findViewById(R.h.note_voice_recording_tips_time);
        this.qvV = (NoteEditorVoiceBaseView) view.findViewById(R.h.note_editor_voice_player);
        a cbb = a.cbb();
        NoteEditorVoiceBaseView noteEditorVoiceBaseView = this.qvV;
        if (noteEditorVoiceBaseView != null) {
            for (a.a aVar : cbb.cWy) {
                if (noteEditorVoiceBaseView == aVar) {
                    break;
                }
            }
            cbb.cWy.add(noteEditorVoiceBaseView);
        }
        this.eRj.setVisibility(0);
        this.qvT.setVisibility(8);
        this.qvU.setVisibility(0);
        this.bOA.setVisibility(8);
        this.qvq.setVisibility(8);
        this.eRj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (n.this.qvZ != null && n.this.qvZ.qoV.booleanValue()) {
                    n.this.qvZ.qoW = Boolean.valueOf(true);
                }
            }
        });
    }

    public final void a(b bVar, int i, int i2) {
        this.qvZ = (k) bVar;
        if (this.qvZ.qpd) {
            this.qvU.setVisibility(0);
            this.qvT.setVisibility(8);
            this.eRj.setPadding(0, 0, 0, 0);
            if (bVar.qoO) {
                this.qvV.setBackgroundResource(R.g.wenote_basecard_pressed_bg);
            } else {
                this.qvV.setBackgroundResource(R.g.wenote_basecard_bg);
            }
            NoteEditorVoiceBaseView noteEditorVoiceBaseView = this.qvV;
            String str = this.qvZ.bVd;
            int i3 = this.qvZ.bOS;
            CharSequence charSequence = this.qvZ.qps;
            noteEditorVoiceBaseView.path = bi.aG(str, "");
            noteEditorVoiceBaseView.bOS = i3;
            noteEditorVoiceBaseView.setText(charSequence);
        } else {
            this.eRj.setPadding(26, 7, 0, 7);
            this.qvU.setVisibility(8);
            this.qvT.setVisibility(0);
            ImageView imageView = this.qvW;
            if (imageView.getAnimation() != null) {
                imageView.startAnimation(imageView.getAnimation());
            } else {
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setRepeatCount(-1);
                alphaAnimation.setRepeatMode(2);
                imageView.startAnimation(alphaAnimation);
            }
            if (this.qvZ.qoV.booleanValue()) {
                this.qoF.sendEmptyMessage(4096);
                this.qvX.setText(R.l.favorite_wenote_voice_recording);
                this.qvY.setText(" " + com.tencent.mm.bb.a.v(ad.getContext(), this.qvZ.qpr).toString());
            } else {
                this.qvX.setText(R.l.favorite_wenote_voice_downloading);
                this.qvY.setText(" " + com.tencent.mm.bb.a.v(ad.getContext(), (int) com.tencent.mm.bb.a.bD((long) this.qvZ.bOT)).toString());
            }
        }
        super.a(bVar, i, i2);
    }

    public final int caZ() {
        return 4;
    }
}
