package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.p.h;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.plugin.record.b.m.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class RecordVoiceBaseView extends TextView implements a {
    public int bOS;
    private boolean bgH = false;
    private Context context;
    public int duration = -1;
    private AlphaAnimation mtq;
    private AnimationDrawable mtr;
    private m mts;
    public String path = "";

    static /* synthetic */ void d(RecordVoiceBaseView recordVoiceBaseView) {
        x.d("MicroMsg.RecordVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{recordVoiceBaseView.path, Integer.valueOf(recordVoiceBaseView.bOS)});
        if (!recordVoiceBaseView.mts.startPlay(recordVoiceBaseView.path, recordVoiceBaseView.bOS)) {
            Toast.makeText(recordVoiceBaseView.getContext(), R.l.favorite_voice_play_error, 1).show();
        } else if (!recordVoiceBaseView.bgH) {
            recordVoiceBaseView.bgH = true;
            recordVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(recordVoiceBaseView.mtr, null, null, null);
            recordVoiceBaseView.mtr.stop();
            recordVoiceBaseView.mtr.start();
        }
    }

    static /* synthetic */ boolean e(RecordVoiceBaseView recordVoiceBaseView) {
        x.i("MicroMsg.RecordVoiceBaseView", "resume play");
        m mVar = recordVoiceBaseView.mts;
        x.i("MicroMsg.RecordVoiceHelper", "resume play");
        af.Wp("keep_app_silent");
        if (mVar.iWF != null) {
            return mVar.iWF.vY();
        }
        x.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
        return false;
    }

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bqM();
    }

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
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
        this.mtr.addFrame(drawable, h.CTRL_INDEX);
        drawable = getResources().getDrawable(R.k.chatfrom_voice_playing_f2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mtr.addFrame(drawable, h.CTRL_INDEX);
        drawable = getResources().getDrawable(R.k.chatfrom_voice_playing_f3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mtr.addFrame(drawable, h.CTRL_INDEX);
        this.mtr.setOneShot(false);
        this.mtr.setVisible(true, true);
    }

    private void bqN() {
        if (this.mtq != null && this.mtq.isInitialized()) {
            setAnimation(null);
        }
        this.bgH = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.k.chatfrom_voice_playing), null, null, null);
        this.mtr.stop();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(new 1(this));
    }

    public void setVoiceHelper(m mVar) {
        this.mts = mVar;
        m mVar2 = this.mts;
        for (a aVar : mVar2.cWy) {
            if (this == aVar) {
                return;
            }
        }
        mVar2.cWy.add(this);
    }

    public final void stopPlay() {
        x.d("MicroMsg.RecordVoiceBaseView", "stop play");
        bqN();
        this.mts.stopPlay();
    }

    public final void Kt(String str) {
        x.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        if (!bi.aG(str, "").equals(this.path)) {
            bqN();
        }
    }

    public final void onFinish() {
        stopPlay();
    }
}
