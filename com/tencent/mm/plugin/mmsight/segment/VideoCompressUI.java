package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.compatible.j.a.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.k.f;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;

@TargetApi(16)
public class VideoCompressUI extends MMBaseActivity {
    private String bOX;
    private d iMQ = new d(this);
    private VideoTransPara lln;
    private ProgressDialog lmV;
    private a lmW = new a(this, (byte) 0);
    private Runnable lmX = new 2(this);
    private String videoPath;

    static /* synthetic */ boolean b(VideoCompressUI videoCompressUI, VideoTransPara videoTransPara) {
        boolean z;
        if (videoTransPara != null) {
            z = videoTransPara.videoBitrate < videoCompressUI.lmW.videoBitRate;
        } else {
            x.e("VideoCompressUI", "hy: given target trans param is null");
            z = false;
        }
        return z;
    }

    static /* synthetic */ String bfb() {
        String str = CaptureMMProxy.getInstance().getAccVideoPath() + "videoCompressTmp/";
        if (FileOp.cn(str)) {
            FileOp.I(str, true);
        } else {
            FileOp.mL(str);
        }
        x.i("VideoCompressUI", "initAndGetTmpPath: %s", new Object[]{str + "video_send_preprocess_tmp_" + System.currentTimeMillis() + ".mp4"});
        return str + "video_send_preprocess_tmp_" + System.currentTimeMillis() + ".mp4";
    }

    static /* synthetic */ Point r(int i, int i2, int i3, int i4) {
        x.d("VideoCompressUI", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            if (max % 16 != 0 || Math.abs(max - max2) >= 16 || min % 16 != 0 || Math.abs(min - min2) >= 16) {
                int i5 = max / 2;
                max = min / 2;
                if (i5 % 16 != 0 || Math.abs(i5 - max2) >= 16 || max % 16 != 0 || Math.abs(max - min2) >= 16) {
                    Point point = new Point();
                    if (i < i2) {
                        i5 = Math.min(i3, i4);
                        max = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) i5)));
                    } else {
                        max = Math.min(i3, i4);
                        i5 = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) max)));
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    x.i("VideoCompressUI", "calc scale, outputsize: %s %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(max)});
                    point.x = i5;
                    point.y = max;
                    return point;
                }
                x.i("VideoCompressUI", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(i5, max);
            }
            x.i("VideoCompressUI", "calc scale, same len divide by 16, no need scale");
            return null;
        }
        x.i("VideoCompressUI", "calc scale, small or equal to spec size");
        return null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(k.d.background_transparent);
        Intent intent = getIntent();
        if (intent == null || bi.oW(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
            setResult(0);
            finish();
            return;
        }
        this.lmV = h.a(this, getString(f.app_waiting), false, null);
        this.videoPath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
        this.bOX = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.iMQ));
        this.iMQ.K(new 1(this));
    }

    private String dK(String str, String str2) {
        Throwable e;
        if (!bi.oW(str2)) {
            return str2;
        }
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse("file://" + str));
            a j = com.tencent.mm.compatible.j.a.j(this, intent);
            if (j == null || j.bitmap == null) {
                return str2;
            }
            String str3 = CaptureMMProxy.getInstance().getAccVideoPath() + "videoCompressTmpThumb/";
            if (FileOp.cn(str3)) {
                FileOp.I(str3, true);
            } else {
                FileOp.mL(str3);
            }
            str3 = str3 + "video_send_preprocess_thumb_" + System.currentTimeMillis() + ".jpg";
            x.i("VideoCompressUI", "thumbPath: %s", new Object[]{str3});
            try {
                c.a(j.bitmap, 80, CompressFormat.JPEG, str3, true);
                return str3;
            } catch (Exception e2) {
                e = e2;
                str2 = str3;
                x.printErrStackTrace("VideoCompressUI", e, "get thumb error: %s", new Object[]{e.getMessage()});
                return str2;
            }
        } catch (Throwable e3) {
            e = e3;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.iMQ != null) {
            this.iMQ.release();
        }
    }
}
