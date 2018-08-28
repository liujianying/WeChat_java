package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

class TalkRoomVolumeMeter$a extends SurfaceView implements Callback {
    Paint fBa;
    int max = 100;
    float oyg = 0.0f;
    float oyh = 0.0f;
    SurfaceHolder oyi = getHolder();
    Bitmap oyj;
    Bitmap oyk;
    private Bitmap oyl;
    Rect oym;
    int oyn;
    int oyo;
    al oyp;
    private boolean oyq = false;
    private float oyr = this.oyh;
    float oys = this.oyh;
    PaintFlagsDrawFilter oyt;
    boolean oyu = false;
    private float[] oyv;
    final /* synthetic */ TalkRoomVolumeMeter oyw;
    boolean started = false;
    int value = 0;

    static /* synthetic */ void a(TalkRoomVolumeMeter$a talkRoomVolumeMeter$a) {
        if (talkRoomVolumeMeter$a.oys >= talkRoomVolumeMeter$a.oyg && talkRoomVolumeMeter$a.oys <= talkRoomVolumeMeter$a.oyh && talkRoomVolumeMeter$a.oyk != null && talkRoomVolumeMeter$a.oyj != null) {
            Canvas lockCanvas = talkRoomVolumeMeter$a.oyi.lockCanvas();
            if (lockCanvas != null && talkRoomVolumeMeter$a.oym != null) {
                lockCanvas.setDrawFilter(talkRoomVolumeMeter$a.oyt);
                float f = talkRoomVolumeMeter$a.oys;
                if (talkRoomVolumeMeter$a.oyv == null) {
                    talkRoomVolumeMeter$a.oyv = new float[]{talkRoomVolumeMeter$a.oyh, talkRoomVolumeMeter$a.oyh, talkRoomVolumeMeter$a.oyh, talkRoomVolumeMeter$a.oyh, talkRoomVolumeMeter$a.oyh};
                }
                int i = 0;
                while (i < talkRoomVolumeMeter$a.oyv.length - 1) {
                    talkRoomVolumeMeter$a.oyv[i] = talkRoomVolumeMeter$a.oyv[i + 1];
                    i++;
                }
                talkRoomVolumeMeter$a.oyv[i] = f;
                talkRoomVolumeMeter$a.oyr = ((((talkRoomVolumeMeter$a.oyv[0] + (talkRoomVolumeMeter$a.oyv[1] * 4.0f)) + (talkRoomVolumeMeter$a.oyv[2] * 6.0f)) + (talkRoomVolumeMeter$a.oyv[3] * 4.0f)) + (talkRoomVolumeMeter$a.oyv[4] * 1.0f)) / 16.0f;
                talkRoomVolumeMeter$a.oym.set(0, (int) talkRoomVolumeMeter$a.oyr, talkRoomVolumeMeter$a.oyo, ((int) talkRoomVolumeMeter$a.oyr) + talkRoomVolumeMeter$a.oyn);
                lockCanvas.drawBitmap(talkRoomVolumeMeter$a.oyu ? talkRoomVolumeMeter$a.oyk : talkRoomVolumeMeter$a.oyj, null, talkRoomVolumeMeter$a.oym, talkRoomVolumeMeter$a.fBa);
                talkRoomVolumeMeter$a.oyi.unlockCanvasAndPost(lockCanvas);
            }
        }
    }

    public TalkRoomVolumeMeter$a(TalkRoomVolumeMeter talkRoomVolumeMeter, Context context) {
        this.oyw = talkRoomVolumeMeter;
        super(context);
        this.oyi.addCallback(this);
        this.fBa = new Paint();
        this.fBa.setAntiAlias(true);
        this.oyt = new PaintFlagsDrawFilter(0, 3);
        this.oyp = new al(new 1(this), true);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        x.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
        this.oyj = BitmapFactory.decodeResource(getResources(), R.g.talk_room_volume_flame);
        this.oyl = BitmapFactory.decodeResource(getResources(), R.g.talk_room_volume_err);
        this.oyk = BitmapFactory.decodeResource(getResources(), R.g.talk_room_volume_flame_red);
    }

    private int bHs() {
        return this.oyj == null ? 190 : this.oyj.getHeight();
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + i2 + " height = " + i3);
        this.oyh = 0.0f;
        this.oyg = (float) (i3 - bHs());
        this.oyr = this.oyh;
        this.oys = this.oyh;
        this.oyo = i2;
        this.oyn = bHs();
        this.oym = new Rect(0, (int) this.oyr, this.oyo, ((int) this.oyr) + this.oyn);
        this.oyq = true;
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        x.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
        this.oyq = false;
        this.oyp.SO();
        if (this.oyj != null) {
            this.oyj.recycle();
            this.oyj = null;
        }
        if (this.oyl != null) {
            this.oyl.recycle();
            this.oyl = null;
        }
        if (this.oyk != null) {
            this.oyk.recycle();
            this.oyk = null;
        }
    }
}
