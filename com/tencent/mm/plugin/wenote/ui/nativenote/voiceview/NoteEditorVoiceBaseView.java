package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.wenote.model.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

public class NoteEditorVoiceBaseView extends TextView implements a {
    public int bOS;
    private boolean bgH = false;
    private Context context;
    private int duration = -1;
    private AlphaAnimation mtq;
    private AnimationDrawable mtr;
    public String path = "";

    static /* synthetic */ void c(NoteEditorVoiceBaseView noteEditorVoiceBaseView) {
        x.d("MicroMsg.NoteEditorVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{noteEditorVoiceBaseView.path, Integer.valueOf(noteEditorVoiceBaseView.bOS)});
        if (!a.cbb().startPlay(noteEditorVoiceBaseView.path, noteEditorVoiceBaseView.bOS)) {
            Toast.makeText(noteEditorVoiceBaseView.getContext(), R.l.favorite_voice_play_error, 1).show();
        } else if (!noteEditorVoiceBaseView.bgH) {
            noteEditorVoiceBaseView.bgH = true;
            noteEditorVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(noteEditorVoiceBaseView.mtr, null, null, null);
            noteEditorVoiceBaseView.mtr.stop();
            noteEditorVoiceBaseView.mtr.start();
        }
    }

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bqM();
    }

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        bqM();
    }

    private void bqM() {
        this.mtq = new AlphaAnimation(0.1f, 1.0f);
        this.mtq.setDuration(1000);
        this.mtq.setRepeatCount(-1);
        this.mtq.setRepeatMode(2);
        this.mtr = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(R.k.chatfrom_voice_playing_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mtr.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.chatfrom_voice_playing_f2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mtr.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.k.chatfrom_voice_playing_f3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mtr.addFrame(drawable, 300);
        this.mtr.setOneShot(false);
        this.mtr.setVisible(true, true);
    }

    public final void bqN() {
        if (this.mtq != null && this.mtq.isInitialized()) {
            setAnimation(null);
        }
        this.bgH = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.k.chatfrom_voice_playing), null, null, null);
        this.mtr.stop();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String str = "MicroMsg.NoteEditorVoiceBaseView";
                String str2 = "clicked path:%s, player isPlay:%s, path:%s";
                Object[] objArr = new Object[3];
                objArr[0] = NoteEditorVoiceBaseView.this.path;
                objArr[1] = a.cbb().aLq() ? "true" : "false";
                objArr[2] = a.cbb().path;
                x.i(str, str2, objArr);
                if (!com.tencent.mm.p.a.by(NoteEditorVoiceBaseView.this.context) && !com.tencent.mm.p.a.bw(NoteEditorVoiceBaseView.this.context)) {
                    if (!f.zZ() && !bi.oW(NoteEditorVoiceBaseView.this.path)) {
                        s.gH(view.getContext());
                    } else if (!k.bZe().hnt) {
                        if (bi.aG(NoteEditorVoiceBaseView.this.path, "").equals(a.cbb().path) && a.cbb().aLq()) {
                            NoteEditorVoiceBaseView noteEditorVoiceBaseView = NoteEditorVoiceBaseView.this;
                            x.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
                            noteEditorVoiceBaseView.bqN();
                            a.cbb().stopPlay();
                            return;
                        }
                        NoteEditorVoiceBaseView.c(NoteEditorVoiceBaseView.this);
                    }
                }
            }
        });
    }

    public final void Sw(String str) {
        x.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        if (!bi.aG(str, "").equals(this.path)) {
            bqN();
        }
    }

    public final void cba() {
        bqN();
    }
}
