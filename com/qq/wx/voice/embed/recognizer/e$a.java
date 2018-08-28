package com.qq.wx.voice.embed.recognizer;

class e$a implements Runnable {
    private /* synthetic */ e bgl;

    private e$a(e eVar) {
        this.bgl = eVar;
    }

    /* synthetic */ e$a(e eVar, byte b) {
        this(eVar);
    }

    public final void run() {
        if (this.bgl.bgs.begin() != 0) {
            this.bgl.bgt.a(-102);
        } else if (this.bgl.bgs.recognize(this.bgl.c, this.bgl.c.length) != 0) {
            this.bgl.bgt.a(-103);
        } else if (this.bgl.bgs.end() != 0) {
            this.bgl.bgt.a(-104);
        } else {
            a aVar = new a();
            if (this.bgl.bgs.getResult(aVar) != 0) {
                this.bgl.bgt.a(-105);
            }
            g gVar = this.bgl.bgt;
            gVar.b.sendMessage(gVar.b.obtainMessage(200, aVar));
        }
    }
}
