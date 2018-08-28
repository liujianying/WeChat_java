package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class MediaHistoryGalleryUI$1 extends a {
    final /* synthetic */ MediaHistoryGalleryUI tXF;

    MediaHistoryGalleryUI$1(MediaHistoryGalleryUI mediaHistoryGalleryUI) {
        this.tXF = mediaHistoryGalleryUI;
    }

    public final void a(long j, long j2, String str, int i) {
        super.a(j, j2, str, i);
        x.d("MicroMsg.MediaHistoryGalleryUI", "summerhardcoder sync fps scene:%s vs %s, droppedFrames:%s, lastFrameNanos:%d, frameNanos:%d", new Object[]{str, this.tXF.getClass().getSimpleName(), Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)});
        if (i > 0 && !bi.oW(str) && str.endsWith(this.tXF.getClass().getSimpleName())) {
            MediaHistoryGalleryUI.a(this.tXF, MediaHistoryGalleryUI.a(this.tXF) + ((long) i));
        }
    }
}
