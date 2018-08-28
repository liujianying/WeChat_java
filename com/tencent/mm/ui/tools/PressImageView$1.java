package com.tencent.mm.ui.tools;

class PressImageView$1 implements Runnable {
    final /* synthetic */ PressImageView uBj;

    PressImageView$1(PressImageView pressImageView) {
        this.uBj = pressImageView;
    }

    public final void run() {
        this.uBj.setPressed(false);
        this.uBj.invalidate();
    }
}
