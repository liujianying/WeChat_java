package com.tencent.mm.plugin.music.ui;

import android.content.ClipData;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.mm.plugin.music.b.e;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class LyricView$a extends SimpleOnGestureListener {
    final /* synthetic */ LyricView lAv;

    private LyricView$a(LyricView lyricView) {
        this.lAv = lyricView;
    }

    /* synthetic */ LyricView$a(LyricView lyricView, byte b) {
        this(lyricView);
    }

    public final void onLongPress(MotionEvent motionEvent) {
        CharSequence a = LyricView.a(this.lAv, motionEvent.getX(), motionEvent.getY());
        if (bi.oW(a)) {
            x.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
            return;
        }
        h.bif().setPrimaryClip(ClipData.newPlainText("MicroMsg.Music", a));
        Toast.makeText(this.lAv.getContext(), this.lAv.getContext().getString(e.music_clipboard_toast, new Object[]{a}), 0).show();
    }
}
