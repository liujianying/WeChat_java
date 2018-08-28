package com.tencent.mm.pluginsdk.i;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class b$a extends Handler {
    int fHo = 0;
    boolean lft = false;

    public b$a(Looper looper) {
        super(looper);
    }

    @TargetApi(8)
    public final void handleMessage(Message message) {
        Camera camera = (Camera) message.obj;
        Parameters parameters = camera.getParameters();
        int zoom = parameters.getZoom() + this.fHo;
        if (this.lft) {
            if (zoom >= parameters.getMaxZoom() / 2) {
                zoom = parameters.getMaxZoom() / 2;
            } else {
                sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
            }
        } else if (zoom <= 0) {
            zoom = 0;
        } else {
            sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
        }
        parameters.setZoom(zoom);
        camera.setParameters(parameters);
    }
}
