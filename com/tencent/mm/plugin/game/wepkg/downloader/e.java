package com.tencent.mm.plugin.game.wepkg.downloader;

import java.util.concurrent.FutureTask;

public final class e<V> extends FutureTask<V> {
    c keu;

    public e(Runnable runnable, V v, c cVar) {
        super(runnable, v);
        this.keu = cVar;
    }
}
