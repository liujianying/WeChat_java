package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(16)
public final class m implements Runnable {
    public MediaFormat jBq;
    public MediaFormat jBr;
    public VideoMediaItem jBs;
    public a jBt;
    public String path;
    public int position;

    public interface a {
        void a(m mVar);
    }

    public m(String str, int i, VideoMediaItem videoMediaItem, a aVar) {
        this.path = str;
        this.position = i;
        this.jBs = videoMediaItem;
        this.jBt = aVar;
    }

    public final void run() {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(this.path);
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat.containsKey("mime")) {
                    String string = trackFormat.getString("mime");
                    x.d("VideoAnalysisTask", "find video mime : %s", new Object[]{string});
                    if (string != null) {
                        if (string.startsWith("video/")) {
                            if (this.jBq == null) {
                                this.jBq = trackFormat;
                            }
                        } else if (string.startsWith("audio/") && this.jBr == null) {
                            this.jBr = trackFormat;
                        }
                        if (!(this.jBr == null || this.jBq == null)) {
                            break;
                        }
                    }
                    continue;
                } else {
                    x.d("VideoAnalysisTask", "find video mime : not found.");
                }
            }
            if (this.jBs != null) {
                if (this.jBq != null) {
                    this.jBs.egD = !this.jBq.containsKey("durationUs") ? 0 : (int) (this.jBq.getLong("durationUs") / 1000);
                    this.jBs.videoHeight = !this.jBq.containsKey("height") ? 0 : this.jBq.getInteger("height");
                    this.jBs.videoWidth = !this.jBq.containsKey("width") ? 0 : this.jBq.getInteger("width");
                    this.jBs.egB = !this.jBq.containsKey("mime") ? "" : this.jBq.getString("mime");
                    this.jBs.videoBitRate = !this.jBq.containsKey("bitrate") ? 0 : this.jBq.getInteger("bitrate");
                    this.jBs.egE = !this.jBq.containsKey("i-frame-interval") ? 0 : this.jBq.getInteger("i-frame-interval");
                    this.jBs.videoFrameRate = !this.jBq.containsKey("frame-rate") ? 0 : this.jBq.getInteger("frame-rate");
                }
                if (this.jBr != null) {
                    this.jBs.egC = !this.jBr.containsKey("mime") ? "" : this.jBr.getString("mime");
                }
            }
            mediaExtractor.release();
        } catch (Exception e) {
            x.d("VideoAnalysisTask", "Video extractor init failed. video path = [%s] e = [%s]", new Object[]{this.path, e.getMessage()});
            mediaExtractor.release();
        } catch (Throwable th) {
            mediaExtractor.release();
            throw th;
        }
        if (this.jBt == null) {
            x.d("VideoAnalysisTask", "video analysis end. observer == null, position = [%d], mediaItem = [%s]", new Object[]{Integer.valueOf(this.position), this.jBs});
        } else {
            ah.A(new Runnable() {
                public final void run() {
                    if (m.this.jBt != null) {
                        m.this.jBt.a(m.this);
                    }
                }
            });
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof m) && (this == obj || this.position == ((m) obj).position || (this.path != null && this.path.equals(((m) obj).path)));
    }
}
