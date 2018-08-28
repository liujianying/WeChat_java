package com.tencent.mm.ui.applet;

import java.util.LinkedList;

class b$c {
    private LinkedList<String> dav;
    private int maxSize;
    final /* synthetic */ b trE;

    public b$c(b bVar) {
        this.trE = bVar;
        this.dav = null;
        this.maxSize = 40;
        this.dav = new LinkedList();
    }

    final void pS(String str) {
        if (!this.dav.contains(str)) {
            this.dav.add(str);
            if (this.dav.size() >= this.maxSize) {
                this.dav.removeFirst();
            }
        }
    }

    final boolean contains(String str) {
        return this.dav.contains(str);
    }
}
