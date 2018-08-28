package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class FavVoiceBaseView extends LinearLayout implements a {
    private int bOS;
    private int duration;
    private n iXl;
    private ViewGroup jaD;
    private TextView jaE;
    private ImageButton jaF;
    private TextView jaG;
    private a jaH;
    private String path = "";

    static /* synthetic */ void i(FavVoiceBaseView favVoiceBaseView) {
        x.d("MicroMsg.FavVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{favVoiceBaseView.path, Integer.valueOf(favVoiceBaseView.bOS)});
        if (favVoiceBaseView.iXl.startPlay(favVoiceBaseView.path, favVoiceBaseView.bOS)) {
            favVoiceBaseView.jaE.setKeepScreenOn(true);
            favVoiceBaseView.jaH.begin();
            return;
        }
        Toast.makeText(favVoiceBaseView.getContext(), i.favorite_voice_play_error, 1).show();
    }

    static /* synthetic */ boolean j(FavVoiceBaseView favVoiceBaseView) {
        x.i("MicroMsg.FavVoiceBaseView", "resume play");
        boolean aLr = favVoiceBaseView.iXl.aLr();
        a aVar = favVoiceBaseView.jaH;
        aVar.isPaused = false;
        aVar.sendEmptyMessage(4096);
        aVar.jaI.jaF.setImageResource(h.voicepost_pauseicon);
        aVar.jaI.jaF.setContentDescription(aVar.jaI.getContext().getResources().getString(i.app_pause));
        favVoiceBaseView.jaE.setKeepScreenOn(true);
        return aLr;
    }

    public FavVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[]{Boolean.valueOf(this.jaH.isPaused)});
        if (this.jaH.isPaused) {
            this.jaH.postDelayed(new Runnable() {
                public final void run() {
                    FavVoiceBaseView.this.jaH.aMv();
                }
            }, 128);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jaD = (ViewGroup) findViewById(e.voice_player_progress_bg);
        this.jaG = (TextView) findViewById(e.voice_player_length);
        this.jaE = (TextView) findViewById(e.voice_player_progress);
        this.jaF = (ImageButton) findViewById(e.voice_player_btn);
        this.jaH = new a(this, (byte) 0);
        this.jaF.setOnClickListener(new 2(this));
    }

    public void setVoiceHelper(n nVar) {
        this.iXl = nVar;
        this.iXl.a(this);
    }

    public final void P(String str, int i, int i2) {
        this.path = bi.aG(str, "");
        this.bOS = i;
        this.duration = i2;
        a aVar;
        if (!this.path.equals(this.iXl.path)) {
            this.jaH.pO(i2);
        } else if (this.iXl.aLq()) {
            x.i("MicroMsg.FavVoiceBaseView", "updateInfo .isPlay()");
            aVar = this.jaH;
            this.iXl.wb();
            aVar.eT(true);
        } else if (this.iXl.wc()) {
            x.i("MicroMsg.FavVoiceBaseView", "updateInfo .isPause()");
            aVar = this.jaH;
            this.iXl.wb();
            aVar.eT(false);
        } else {
            this.jaH.pO(i2);
        }
    }

    public final boolean aLs() {
        x.i("MicroMsg.FavVoiceBaseView", "pause play");
        boolean aLs = this.iXl.aLs();
        a aVar = this.jaH;
        aVar.isPaused = true;
        aVar.removeMessages(4096);
        aVar.jaI.jaF.setImageResource(h.voicepost_beginicon);
        aVar.jaI.jaF.setContentDescription(aVar.jaI.getContext().getResources().getString(i.app_play));
        this.jaE.setKeepScreenOn(false);
        return aLs;
    }

    public final void stopPlay() {
        x.d("MicroMsg.FavVoiceBaseView", "stop play");
        this.iXl.stopPlay();
        this.jaH.stop();
        this.jaE.setKeepScreenOn(false);
    }

    public final void aW(String str, int i) {
        x.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        if (bi.aG(str, "").equals(this.path)) {
            this.jaE.setKeepScreenOn(true);
            this.jaH.begin();
            return;
        }
        this.jaH.stop();
        this.jaE.setKeepScreenOn(false);
    }

    public final void onFinish() {
        stopPlay();
    }

    public final void onPause() {
        aLs();
    }
}
