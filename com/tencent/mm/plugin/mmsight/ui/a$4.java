package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.c.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.m;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$4 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ a lpk;

    a$4(a aVar, Bitmap bitmap) {
        this.lpk = aVar;
        this.abc = bitmap;
    }

    public final void run() {
        int i;
        int i2;
        int i3;
        a Lo = d.Lo(this.lpk.videoPath);
        if (Lo != null) {
            i = Lo.width;
            i2 = Lo.height;
            i3 = Lo.videoBitrate;
        } else {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.lpk.videoPath);
            i = bi.getInt(mediaMetadataRetriever.extractMetadata(18), -1);
            i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), -1);
            i3 = bi.getInt(mediaMetadataRetriever.extractMetadata(20), -1);
            mediaMetadataRetriever.release();
        }
        if (i <= 0 || i2 <= 0 || i3 <= 0) {
            x.e("MicroMsg.MMSightVideoEditor", "doRemuxVideo, retrieve video metadata error, width: %s, height: %s, bitrate: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        int min;
        String str;
        if (this.lpk.lpe && this.lpk.lfT != null) {
            Point point;
            if (i3 > this.lpk.lfT.videoBitrate) {
                i3 = this.lpk.lfT.videoBitrate;
            }
            int i4 = this.lpk.lfT.width;
            int i5 = this.lpk.lfT.height;
            x.d("MicroMsg.MMSightVideoEditor", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i4 + "], specHeight = [" + i5 + "]");
            if (i > i4 || i2 > i5) {
                int max = Math.max(i, i2);
                min = Math.min(i, i2);
                int max2 = Math.max(i4, i5);
                int min2 = Math.min(i4, i5);
                if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                    x.i("MicroMsg.MMSightVideoEditor", "calc scale, same len divide by 16, no need scale");
                    point = null;
                } else if (max / 2 == max2 && min / 2 == min2) {
                    x.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio");
                    i4 = i / 2;
                    i5 = i2 / 2;
                    if (i4 % 2 != 0) {
                        i4++;
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    point = new Point(i4, i5);
                } else {
                    max /= 2;
                    min /= 2;
                    if (max % 16 != 0 || Math.abs(max - max2) >= 16 || min % 16 != 0 || Math.abs(min - min2) >= 16) {
                        Point point2 = new Point();
                        if (i < i2) {
                            i5 = Math.min(i4, i5);
                            i4 = (int) (((double) i2) / ((1.0d * ((double) i)) / ((double) i5)));
                        } else {
                            i4 = Math.min(i4, i5);
                            i5 = (int) (((double) i) / ((1.0d * ((double) i2)) / ((double) i4)));
                        }
                        if (i4 % 2 != 0) {
                            i4++;
                        }
                        if (i5 % 2 != 0) {
                            i5++;
                        }
                        x.i("MicroMsg.MMSightVideoEditor", "calc scale, outputsize: %s %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)});
                        point2.x = i5;
                        point2.y = i4;
                        point = point2;
                    } else {
                        x.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio divide by 16");
                        i4 = i / 2;
                        i5 = i2 / 2;
                        if (i4 % 2 != 0) {
                            i4++;
                        }
                        if (i5 % 2 != 0) {
                            i5++;
                        }
                        point = new Point(i4, i5);
                    }
                }
            } else {
                x.i("MicroMsg.MMSightVideoEditor", "calc scale, small or equal to spec size");
                point = null;
            }
            if (point != null) {
                i = point.x;
                i2 = point.y;
                min = i3;
                str = this.lpk.videoPath + "remuxOutput.mp4";
                if (!bi.oW(this.lpk.lph)) {
                    str = this.lpk.lph;
                }
                if (this.lpk.loV >= 0 || this.lpk.loW <= 0) {
                    if (this.lpk.lpi == -1 && (this.lpk.lpi == 1 || this.lpk.lpi == 2)) {
                        this.lpk.lpb = com.tencent.mm.plugin.mmsight.api.a.leA.a(this.lpk.lpi, this.lpk.videoPath, str, i, i2, min, this.lpk.lfT.fps);
                    } else {
                        this.lpk.lpb = com.tencent.mm.plugin.mmsight.api.a.leA.b(this.lpk.videoPath, str, i, i2, min, this.lpk.lfT.fps);
                    }
                } else if (this.lpk.lpi == -1 || !(this.lpk.lpi == 1 || this.lpk.lpi == 2)) {
                    this.lpk.lpb = com.tencent.mm.plugin.mmsight.api.a.leA.a(this.lpk.videoPath, str, i, i2, min, this.lpk.lfT.fps, (long) this.lpk.loV, (long) this.lpk.loW);
                } else {
                    this.lpk.lpb = com.tencent.mm.plugin.mmsight.api.a.leA.a(this.lpk.lpi, this.lpk.videoPath, str, i, i2, min, this.lpk.lfT.fps, (long) this.lpk.loV, (long) this.lpk.loW);
                }
                x.i("MicroMsg.MMSightVideoEditor", "created remuxer, type: %s, remuxer: %s", new Object[]{Integer.valueOf(this.lpk.lpi), this.lpk.lpb});
                if (this.lpk.lpb != null) {
                    ah.A(new 1(this));
                }
                m.sX(this.lpk.lpb.getType());
                long VG = bi.VG();
                if (this.abc != null) {
                    this.lpk.lpb.B(this.abc);
                }
                if (this.lpk.lpb.bdG() < 0) {
                    x.e("MicroMsg.MMSightVideoEditor", "remux failed, ret: %s", new Object[]{Integer.valueOf(this.lpk.lpb.bdG())});
                    ah.A(new 2(this));
                    m.sY(this.lpk.lpb.getType());
                    return;
                }
                if (bi.oW(this.lpk.lph)) {
                    FileOp.av(str, this.lpk.videoPath);
                }
                m.C(this.lpk.lpb.getType(), bi.bI(VG));
                this.lpk.bKg = g.cu(this.lpk.videoPath);
                b bVar = this.lpk.lpj;
                boolean z = this.lpk.loV >= 0 && this.lpk.loW > 0;
                bVar.lkD = z;
                this.lpk.lpj.lkA = this.lpk.loW - this.lpk.loV;
                this.lpk.lpj.lkz = Lo == null ? 0 : Lo.jdD;
                ah.A(new 3(this));
                return;
            }
        }
        min = i3;
        str = this.lpk.videoPath + "remuxOutput.mp4";
        if (bi.oW(this.lpk.lph)) {
            str = this.lpk.lph;
        }
        if (this.lpk.loV >= 0) {
        }
        if (this.lpk.lpi == -1) {
        }
        this.lpk.lpb = com.tencent.mm.plugin.mmsight.api.a.leA.b(this.lpk.videoPath, str, i, i2, min, this.lpk.lfT.fps);
        x.i("MicroMsg.MMSightVideoEditor", "created remuxer, type: %s, remuxer: %s", new Object[]{Integer.valueOf(this.lpk.lpi), this.lpk.lpb});
        if (this.lpk.lpb != null) {
            m.sX(this.lpk.lpb.getType());
            long VG2 = bi.VG();
            if (this.abc != null) {
                this.lpk.lpb.B(this.abc);
            }
            if (this.lpk.lpb.bdG() < 0) {
                x.e("MicroMsg.MMSightVideoEditor", "remux failed, ret: %s", new Object[]{Integer.valueOf(this.lpk.lpb.bdG())});
                ah.A(new 2(this));
                m.sY(this.lpk.lpb.getType());
                return;
            }
            if (bi.oW(this.lpk.lph)) {
                FileOp.av(str, this.lpk.videoPath);
            }
            m.C(this.lpk.lpb.getType(), bi.bI(VG2));
            this.lpk.bKg = g.cu(this.lpk.videoPath);
            b bVar2 = this.lpk.lpj;
            boolean z2 = this.lpk.loV >= 0 && this.lpk.loW > 0;
            bVar2.lkD = z2;
            this.lpk.lpj.lkA = this.lpk.loW - this.lpk.loV;
            this.lpk.lpj.lkz = Lo == null ? 0 : Lo.jdD;
            ah.A(new 3(this));
            return;
        }
        ah.A(new 1(this));
    }
}
