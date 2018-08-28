package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.wcdb.support.Log;

public class MMSightCaptureTouchView extends RelativeLayout {
    private long fbI = -1;
    private float fbJ = -1.0f;
    private int fbK = 0;
    private a lob;

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTouchCallback(a aVar) {
        this.lob = aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_DOWN");
                if (this.fbI <= 0 || SystemClock.elapsedRealtime() - this.fbI >= 400) {
                    if (this.lob != null) {
                        this.lob.N(motionEvent.getX(), motionEvent.getY());
                    }
                } else if (this.lob != null) {
                    this.lob.bfc();
                }
                this.fbI = SystemClock.elapsedRealtime();
                this.fbJ = -1.0f;
                this.fbK++;
                break;
            case 1:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
                this.fbJ = -1.0f;
                this.fbK = 0;
                break;
            case 2:
                if (this.fbK >= 2) {
                    float w = w(motionEvent);
                    Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", new Object[]{Float.valueOf(w)});
                    if (w > 0.0f) {
                        if (this.fbJ > 0.0f) {
                            if (Math.abs(w - this.fbJ) > 15.0f) {
                                if (w > this.fbJ) {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
                                    if (this.lob != null) {
                                        this.lob.aab();
                                    }
                                } else {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
                                    if (this.lob != null) {
                                        this.lob.aac();
                                    }
                                }
                            }
                        }
                        this.fbJ = w;
                        break;
                    }
                }
                break;
            case 5:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
                this.fbK++;
                break;
            case 6:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
                this.fbK--;
                break;
        }
        return true;
    }

    private float w(MotionEvent motionEvent) {
        try {
            if (this.fbK >= 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                return Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
            }
        } catch (Exception e) {
            Log.e("MicroMsg.MMSightCaptureTouchView", "pointerDistance error: %s", new Object[]{e.getMessage()});
        }
        return 0.0f;
    }
}
