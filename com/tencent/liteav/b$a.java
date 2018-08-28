package com.tencent.liteav;

import android.view.MotionEvent;
import android.view.View;

class b$a implements Runnable {
    final /* synthetic */ b a;
    private View b;
    private MotionEvent c;

    private b$a(b bVar) {
        this.a = bVar;
    }

    public void a(View view) {
        this.b = view;
    }

    public void a(MotionEvent motionEvent) {
        this.c = motionEvent;
    }

    public void run() {
        if (b.e(this.a) != null && b.b(this.a).D) {
            b.e(this.a).a(this.c.getX() / ((float) this.b.getWidth()), this.c.getY() / ((float) this.b.getHeight()));
        }
        if (b.g(this.a) != null && b.b(this.a).D) {
            b.g(this.a).onTouchFocus((int) this.c.getX(), (int) this.c.getY());
        }
    }
}
