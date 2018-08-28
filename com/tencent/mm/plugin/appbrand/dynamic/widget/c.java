package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.view.View;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.mm.plugin.appbrand.dynamic.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    private static volatile boolean dpg = false;
    private static volatile int fyE = 0;

    public static void initialize() {
        a.post(new 1());
    }

    public static void ki(int i) {
        fyE = i;
        dpg = true;
    }

    public static int afA() {
        return fyE;
    }

    public static View bH(Context context) {
        if (!dpg) {
            initialize();
        }
        x.d("MicroMsg.WidgetDrawableViewFactory", "inflate(mode : %d)", new Object[]{Integer.valueOf(fyE)});
        View mTextureView;
        switch (fyE) {
            case 1:
                mTextureView = new MTextureView(context);
                mTextureView.getDrawContext().fnl = b.ado();
                return mTextureView;
            case 2:
                mTextureView = new MSurfaceView(context);
                mTextureView.getDrawContext().fnl = b.ado();
                return mTextureView;
            case 3:
                mTextureView = new MCanvasView(context);
                mTextureView.getDrawContext().fnl = b.ado();
                return mTextureView;
            case 4:
                mTextureView = new MDrawableView(context);
                mTextureView.getDrawContext().fnl = b.ado();
                return mTextureView;
            default:
                mTextureView = new MHardwareAccelerateDrawableView(context);
                mTextureView.getDrawContext().fnl = b.ado();
                return mTextureView;
        }
    }

    public static String afB() {
        switch (fyE) {
            case 1:
                return "MTextureView";
            case 2:
                return "MSurfaceView";
            case 3:
                return "MCanvasView";
            case 4:
                return "MDrawableView";
            default:
                return "MHADrawableView";
        }
    }
}
