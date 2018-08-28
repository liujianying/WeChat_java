package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import org.xwalk.core.R$id;

public final class b {
    ImageView gaS = null;
    ImageView ndi;
    ImageView ndj;
    private ImageView ndk = null;
    float tua;
    float upl = 0.0f;
    a vAZ;
    boolean vBa = false;
    float vBb;

    public interface a {
        void aJ(float f);

        void ajO();
    }

    public b(FrameLayout frameLayout, a aVar) {
        this.vAZ = aVar;
        this.ndi = (ImageView) frameLayout.findViewById(R$id.player_progress_bar_front);
        this.gaS = (ImageView) frameLayout.findViewById(R$id.player_progress_bar_middle);
        this.ndj = (ImageView) frameLayout.findViewById(R$id.player_progress_bar_background);
        this.ndk = (ImageView) frameLayout.findViewById(R$id.player_progress_point);
        this.ndk.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float f = 0.0f;
                if (motionEvent.getAction() == 0) {
                    b.this.vBa = false;
                    b.this.upl = motionEvent.getX();
                    if (b.this.vAZ != null) {
                        b.this.vAZ.ajO();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float width = (float) b.this.ndi.getWidth();
                    float x = (float) ((int) ((motionEvent.getX() - b.this.upl) + width));
                    if (x >= 0.0f) {
                        if (x > ((float) b.this.ndj.getWidth())) {
                            f = (float) b.this.ndj.getWidth();
                        } else {
                            f = x;
                        }
                    }
                    b.this.vBb = (f * 100.0f) / ((float) b.this.ndj.getWidth());
                    b.this.c(b.this.vBb, true);
                    if (b.this.vAZ != null) {
                        b.this.vAZ.ajO();
                    }
                    b.this.vBa = true;
                } else {
                    if (b.this.vBa && b.this.vAZ != null) {
                        b.this.vAZ.aJ(b.this.vBb);
                    }
                    b.this.vBa = false;
                }
                return true;
            }
        });
    }

    public final void c(float f, boolean z) {
        if (!this.vBa || z) {
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > 100.0f) {
                f = 100.0f;
            }
            this.tua = f;
            LayoutParams layoutParams = (LayoutParams) this.ndk.getLayoutParams();
            layoutParams.leftMargin = (int) (((f / 100.0f) * ((float) this.ndj.getWidth())) - ((float) (this.ndk.getWidth() / 2)));
            this.ndk.setLayoutParams(layoutParams);
            this.ndk.requestLayout();
            layoutParams = (LayoutParams) this.ndi.getLayoutParams();
            layoutParams.width = (int) ((f / 100.0f) * ((float) this.ndj.getWidth()));
            this.ndi.setLayoutParams(layoutParams);
            this.ndi.requestLayout();
        }
    }
}
