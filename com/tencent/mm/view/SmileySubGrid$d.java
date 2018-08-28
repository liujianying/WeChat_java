package com.tencent.mm.view;

class SmileySubGrid$d {
    private int txu;
    final /* synthetic */ SmileySubGrid uTE;

    private SmileySubGrid$d(SmileySubGrid smileySubGrid) {
        this.uTE = smileySubGrid;
    }

    /* synthetic */ SmileySubGrid$d(SmileySubGrid smileySubGrid, byte b) {
        this(smileySubGrid);
    }

    public final void czn() {
        this.txu = SmileySubGrid.a(this.uTE);
    }

    public final boolean czo() {
        return this.uTE.hasWindowFocus() && SmileySubGrid.b(this.uTE) == this.txu;
    }
}
