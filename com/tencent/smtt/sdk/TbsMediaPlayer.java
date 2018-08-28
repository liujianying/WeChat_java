package com.tencent.smtt.sdk;

import android.graphics.SurfaceTexture;
import android.os.Bundle;

public class TbsMediaPlayer {
    private ba a = null;

    public TbsMediaPlayer(ba baVar) {
        this.a = baVar;
    }

    public void audio(int i) {
        this.a.b(i);
    }

    public void close() {
        this.a.e();
    }

    public float getVolume() {
        return this.a.b();
    }

    public boolean isAvailable() {
        return this.a.a();
    }

    public void pause() {
        this.a.c();
    }

    public void play() {
        this.a.d();
    }

    public void seek(long j) {
        this.a.a(j);
    }

    public void setPlayerListener(TbsMediaPlayerListener tbsMediaPlayerListener) {
        this.a.a(tbsMediaPlayerListener);
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.a.a(surfaceTexture);
    }

    public void setVolume(float f) {
        this.a.a(f);
    }

    public void startPlay(String str, Bundle bundle) {
        this.a.a(str, bundle);
    }

    public void subtitle(int i) {
        this.a.a(i);
    }
}
