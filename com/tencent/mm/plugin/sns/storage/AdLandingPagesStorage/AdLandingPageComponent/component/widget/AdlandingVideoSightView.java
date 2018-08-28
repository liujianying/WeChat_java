package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.2;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

public class AdlandingVideoSightView extends AdlandingSightPlayImageView implements f {
    protected int duration = 0;
    private boolean hEj = false;
    private boolean nGM;
    private boolean nGN = true;
    protected String nck;

    public AdlandingVideoSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public AdlandingVideoSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        if (bi.aG(q.deW.den, "").equals("other")) {
            x.i("MicroMsg.VideoSightView", "init::use other player");
        } else {
            hK(true);
        }
        setOnCompletionListener(new 1(this));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        x.v("MicroMsg.VideoSightView", "ashutest::on layout changed %B, %d %d %d %d %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.ndE)});
        if (this.ndE && i3 - i > 0) {
            setDrawableWidth(i3 - i);
        }
    }

    public void setEnableConfigChanged(boolean z) {
        this.nGN = z;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.nGN) {
            setDrawableWidth(getResources().getDisplayMetrics().widthPixels);
        }
    }

    public final boolean isPlaying() {
        return this.nGJ.bvH();
    }

    public void setVideoPath(String str) {
        String str2 = "MicroMsg.VideoSightView";
        String str3 = "set sight path %s, callback null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(this.ndD == null);
        x.i(str2, str3, objArr);
        this.duration = 0;
        this.nck = str;
        if (this.ndD != null) {
            this.ndD.iy();
        }
    }

    public final void stop() {
        this.nGJ.clear();
    }

    public final void pause() {
        aO(this.nck, true);
    }

    public void setLoop(boolean z) {
        setLoopImp(z);
    }

    public void setVideoCallback(a aVar) {
        this.ndD = aVar;
    }

    public int getCurrentPosition() {
        x.v("MicroMsg.VideoSightView", "get current position");
        return 0;
    }

    public int getDuration() {
        int duration = super.getDuration();
        x.v("MicroMsg.VideoSightView", "get duration " + duration);
        return duration;
    }

    public final void onDetach() {
        com.tencent.mm.sdk.b.a.sFg.c(this.nGJ.bvK());
    }

    public final boolean start() {
        return q(getContext(), false);
    }

    public final boolean q(Context context, boolean z) {
        boolean z2 = false;
        if (this.nck == null) {
            x.e("MicroMsg.VideoSightView", "start::use path is null!");
            return false;
        } else if (bi.aG(q.deW.den, "").equals("other") || !b.Lp(this.nck)) {
            x.i("MicroMsg.VideoSightView", "start::use other player, path %s, has called %B", new Object[]{this.nck, Boolean.valueOf(this.nGM)});
            if (this.nGM && !z) {
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(this.nck)), "video/*");
            try {
                context.startActivity(Intent.createChooser(intent, context.getString(j.favorite_video)));
            } catch (Exception e) {
                x.e("MicroMsg.VideoSightView", "startActivity fail, activity not found");
                h.bA(context, context.getResources().getString(j.video_file_play_faile));
            }
            this.nGM = true;
            return false;
        } else {
            aO(this.nck, false);
            if (!this.hEj) {
                z2 = true;
            }
            hK(z2);
            return true;
        }
    }

    public void setThumb(Bitmap bitmap) {
        F(bitmap);
    }

    public double getLastProgresstime() {
        if (getController() == null) {
            return 0.0d;
        }
        a controller = getController();
        return controller.ncM != -1.0d ? controller.ncM : controller.ncJ;
    }

    public final void x(double d) {
        if (this.nGJ != null) {
            a aVar = this.nGJ;
            x.v("MicroMsg.SightPlayController", "seekToFrame now %f %s", new Object[]{Double.valueOf(d), bi.cjd().toString()});
            o.d(new 2(aVar, d), 0);
        }
    }

    public void setPlayProgressCallback(boolean z) {
        if (z) {
            setOnDecodeDurationListener(new 2(this));
        } else {
            setOnDecodeDurationListener(null);
        }
    }

    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    public void setMute(boolean z) {
        this.hEj = z;
        hK(!this.hEj);
    }

    public final void d(double d, boolean z) {
        x(d);
    }

    public void setOneTimeVideoTextureUpdateCallback(e eVar) {
    }

    public void setOnSeekCompleteCallback(c cVar) {
    }

    public void setOnInfoCallback(f.b bVar) {
    }

    public void setOnSurfaceCallback(d dVar) {
    }
}
