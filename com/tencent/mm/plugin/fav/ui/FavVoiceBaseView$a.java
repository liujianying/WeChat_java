package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.os.Message;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.sdk.platformtools.ag;

class FavVoiceBaseView$a extends ag {
    boolean isPaused;
    final /* synthetic */ FavVoiceBaseView jaI;
    float jaJ;
    float jaK;
    int jaL;
    int jaM;

    private FavVoiceBaseView$a(FavVoiceBaseView favVoiceBaseView) {
        this.jaI = favVoiceBaseView;
    }

    /* synthetic */ FavVoiceBaseView$a(FavVoiceBaseView favVoiceBaseView, byte b) {
        this(favVoiceBaseView);
    }

    @SuppressLint({"ResourceType"})
    public final void pO(int i) {
        this.isPaused = false;
        this.jaJ = b.bD((long) i);
        this.jaK = this.jaJ;
        this.jaM = a.fromDPToPix(this.jaI.getContext(), 3);
        FavVoiceBaseView.a(this.jaI).setText(i.v(this.jaI.getContext(), (int) this.jaJ));
        FavVoiceBaseView.b(this.jaI).setImageResource(h.voicepost_beginicon);
        FavVoiceBaseView.b(this.jaI).setContentDescription(this.jaI.getContext().getResources().getString(i.app_play));
        FavVoiceBaseView.c(this.jaI).setWidth(this.jaM);
    }

    @SuppressLint({"ResourceType"})
    public final void begin() {
        stop();
        this.isPaused = false;
        FavVoiceBaseView.b(this.jaI).setImageResource(h.voicepost_pauseicon);
        FavVoiceBaseView.b(this.jaI).setContentDescription(this.jaI.getContext().getResources().getString(i.app_pause));
        sendEmptyMessage(4096);
    }

    public final void stop() {
        this.isPaused = false;
        removeMessages(4096);
        pO(FavVoiceBaseView.d(this.jaI));
    }

    public final void aMv() {
        this.jaL = ((int) ((1.0f - (this.jaK / this.jaJ)) * ((float) (FavVoiceBaseView.e(this.jaI).getWidth() - this.jaM)))) + this.jaM;
        FavVoiceBaseView.a(this.jaI).setText(i.v(this.jaI.getContext(), Math.min((int) Math.ceil((double) this.jaK), (int) this.jaJ)));
        FavVoiceBaseView.c(this.jaI).setWidth(this.jaL);
    }

    @SuppressLint({"ResourceType"})
    public final void eT(boolean z) {
        this.jaM = a.fromDPToPix(this.jaI.getContext(), 3);
        FavVoiceBaseView.b(this.jaI).setImageResource(h.voicepost_beginicon);
        FavVoiceBaseView.b(this.jaI).setContentDescription(this.jaI.getContext().getResources().getString(i.app_play));
        aMv();
        if (z) {
            FavVoiceBaseView.b(this.jaI).setImageResource(h.voicepost_pauseicon);
            FavVoiceBaseView.b(this.jaI).setContentDescription(this.jaI.getContext().getResources().getString(i.app_pause));
            sendEmptyMessage(4096);
        }
    }

    public final void handleMessage(Message message) {
        this.jaK = Math.max(0.0f, this.jaK - 0.256f);
        aMv();
        if (this.jaK > 0.1f) {
            sendEmptyMessageDelayed(4096, 256);
        }
    }
}
