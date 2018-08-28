package com.tencent.mm.plugin.gallery.ui;

import android.media.MediaMetadataRetriever;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

class a$c implements Runnable {
    private static HashMap<TextView, a$c> jBK = new HashMap();
    private WeakReference<TextView> iQL;
    private VideoMediaItem jBI;
    private a jBJ;

    private a$c(TextView textView, VideoMediaItem videoMediaItem, a aVar) {
        this.iQL = new WeakReference(textView);
        this.jBI = videoMediaItem;
        this.jBJ = aVar;
    }

    private void e(TextView textView) {
        this.iQL = new WeakReference(textView);
    }

    static void a(TextView textView, VideoMediaItem videoMediaItem) {
        Entry entry = null;
        if (textView == null || videoMediaItem == null) {
            x.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
            return;
        }
        if (jBK.containsKey(textView)) {
            a$c a_c = (a$c) jBK.get(textView);
            if (!a_c.jBI.equals(videoMediaItem)) {
                if (textView.equals(a_c.iQL.get())) {
                    a_c.e(null);
                }
            } else {
                return;
            }
        }
        if (videoMediaItem.egD >= 0) {
            x.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[]{Integer.valueOf(videoMediaItem.egD), videoMediaItem});
            c(textView, videoMediaItem.egD);
            jBK.remove(textView);
            return;
        }
        textView.setText("");
        Runnable a_c2 = new a$c(textView, videoMediaItem, new 2());
        if (e.X(a_c2)) {
            x.i("MicroMsg.AlbumAdapter", "task has post to thread pool");
            for (Entry entry2 : jBK.entrySet()) {
                if (a_c2.equals(entry2.getValue())) {
                    entry = entry2;
                    break;
                }
            }
            if (entry == null || entry.getValue() == null) {
                x.e("MicroMsg.AlbumAdapter", "no entry found");
                return;
            }
            ((a$c) entry.getValue()).e(textView);
            jBK.remove(entry.getKey());
            jBK.put(textView, entry.getValue());
            return;
        }
        e.post(a_c2, "load_duration_for_" + videoMediaItem.egA);
        jBK.put(textView, a_c2);
    }

    private static void c(TextView textView, int i) {
        if (textView != null) {
            if (i < 0) {
                textView.setText("--:--");
                return;
            }
            int round = Math.round(((float) i) / 1000.0f);
            textView.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a$c)) {
            return false;
        }
        return this.jBI.equals(((a$c) obj).jBI);
    }

    public final int hashCode() {
        return this.jBI.hashCode();
    }

    public final void run() {
        Throwable e;
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(this.jBI.aRw());
                this.jBI.egD = bi.getInt(mediaMetadataRetriever.extractMetadata(9), -1);
                try {
                    mediaMetadataRetriever.release();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.AlbumAdapter", e2, "%s", new Object[]{e2.getMessage()});
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.AlbumAdapter", e2, "Analysis duration of mediaItem %s error %s", new Object[]{this.jBI.egA, e2.getMessage()});
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.AlbumAdapter", e22, "%s", new Object[]{e22.getMessage()});
                        }
                    }
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        ah.A(new 1(this));
                    } else if (this.jBJ != null) {
                        this.jBJ.a(this, this.jBI.egD);
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.AlbumAdapter", e4, "%s", new Object[]{e4.getMessage()});
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            mediaMetadataRetriever = null;
            x.printErrStackTrace("MicroMsg.AlbumAdapter", e22, "Analysis duration of mediaItem %s error %s", new Object[]{this.jBI.egA, e22.getMessage()});
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.AlbumAdapter", e222, "%s", new Object[]{e222.getMessage()});
                }
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ah.A(new 1(this));
            } else if (this.jBJ != null) {
                this.jBJ.a(this, this.jBI.egD);
            }
        } catch (Throwable th2) {
            e222 = th2;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Throwable e42) {
                    x.printErrStackTrace("MicroMsg.AlbumAdapter", e42, "%s", new Object[]{e42.getMessage()});
                }
            }
            throw e222;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ah.A(new 1(this));
        } else if (this.jBJ != null) {
            this.jBJ.a(this, this.jBI.egD);
        }
    }
}
