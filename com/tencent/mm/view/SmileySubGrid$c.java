package com.tencent.mm.view;

class SmileySubGrid$c implements Runnable {
    final /* synthetic */ SmileySubGrid uTE;

    private SmileySubGrid$c(SmileySubGrid smileySubGrid) {
        this.uTE = smileySubGrid;
    }

    /* synthetic */ SmileySubGrid$c(SmileySubGrid smileySubGrid, byte b) {
        this(smileySubGrid);
    }

    public final void run() {
        if (!SmileySubGrid.c(this.uTE)) {
            SmileySubGrid.f(this.uTE).addView(SmileySubGrid.d(this.uTE), SmileySubGrid.e(this.uTE));
            SmileySubGrid.g(this.uTE);
        }
    }
}
