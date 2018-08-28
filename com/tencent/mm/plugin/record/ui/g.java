package com.tencent.mm.plugin.record.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends f implements a {
    public final void a(a.a aVar) {
        String str = null;
        ImageView imageView = aVar.bOA;
        vx vxVar = aVar.bOz;
        long j = aVar.msT;
        int i = aVar.bOB;
        int i2 = aVar.width;
        int i3 = aVar.height;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.zZ()) {
                imageView.setImageResource(R.g.nosdcard_chatting_bg);
            } else if (vxVar == null) {
                imageView.setImageResource(i);
            } else {
                wk wkVar;
                switch (vxVar.bjS) {
                    case 4:
                    case 15:
                        super.a(imageView, vxVar, j, vxVar.bJv, i, i2, i3);
                        return;
                    case 5:
                        xa xaVar;
                        if (vxVar.rAi != null) {
                            xaVar = vxVar.rAi.rAN;
                        } else {
                            x.w("MicroMsg.RecordMsgImgService", "webpage: get data proto item null, dataid[%s]", new Object[]{vxVar.jdM});
                            xaVar = null;
                        }
                        if (xaVar != null) {
                            str = xaVar.thumbUrl;
                        }
                        super.a(imageView, vxVar, j, bi.oW(str) ? vxVar.bJv : str, i, i2, i3);
                        return;
                    case 7:
                        super.a(imageView, vxVar, j, vxVar.bJv, i, i2, i3);
                        return;
                    case 10:
                        if (vxVar.rAi == null) {
                            x.w("MicroMsg.RecordMsgImgService", "good: get data proto item null, dataid[%s]", new Object[]{vxVar.jdM});
                            return;
                        }
                        wkVar = vxVar.rAi.rAP;
                        if (wkVar != null) {
                            this.mse.a(imageView, null, wkVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        if (vxVar.rAi == null) {
                            x.w("MicroMsg.RecordMsgImgService", "product: get data proto item null, dataid[%s]", new Object[]{vxVar.jdM});
                            return;
                        }
                        wkVar = vxVar.rAi.rAP;
                        if (wkVar != null) {
                            this.mse.a(imageView, null, wkVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 14:
                        if (vxVar.rAi == null) {
                            x.w("MicroMsg.RecordMsgImgService", "tv: get data proto item null, dataid[%s]", new Object[]{vxVar.jdM});
                            return;
                        }
                        wu wuVar = vxVar.rAi.rAR;
                        if (wuVar != null) {
                            this.mse.a(imageView, null, wuVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 19:
                        vv vvVar;
                        if (vxVar.rAi != null) {
                            vvVar = vxVar.rAi.rBa;
                        } else {
                            x.w("MicroMsg.RecordMsgImgService", "appbrand: get data proto item null, dataid[%s]", new Object[]{vxVar.jdM});
                            vvVar = null;
                        }
                        if (vvVar != null) {
                            str = vvVar.iconUrl;
                        }
                        super.a(imageView, vxVar, j, bi.oW(str) ? vxVar.bJv : str, i, i2, i3);
                        return;
                    default:
                        x.w("MicroMsg.RecordMsgImgService", "attach thumb, pass data type is %d", new Object[]{Integer.valueOf(vxVar.bjS)});
                        return;
                }
            }
        }
    }

    public final Bitmap a(c cVar) {
        return super.b(cVar.bOz, cVar.msT);
    }

    public final Bitmap a(b bVar) {
        Bitmap bitmap;
        vx vxVar = bVar.bOz;
        long j = bVar.msT;
        boolean z = bVar.bOC;
        int i = bVar.maxWidth;
        if (com.tencent.mm.compatible.util.f.zZ()) {
            String c = h.c(vxVar, j);
            if (bi.oW(c) || !e.cn(c)) {
                x.d("MicroMsg.RecordMsgImgService", "getBitmap file not exist, thumb[%B] path[%s]", new Object[]{Boolean.valueOf(false), c});
                bitmap = null;
            } else {
                bitmap = (Bitmap) this.jaR.get(c);
                if (bitmap != null) {
                    x.d("MicroMsg.RecordMsgImgService", "get bm from cache %s", new Object[]{c});
                } else if (z) {
                    bitmap = null;
                } else {
                    int i2;
                    x.d("MicroMsg.RecordMsgImgService", "get from cache fail, try to decode from file, path %s", new Object[]{c});
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    bitmap = BitmapFactory.decodeFile(c, options);
                    if (bitmap != null) {
                        x.i("MicroMsg.RecordMsgImgService", "bitmap recycle %s", new Object[]{bitmap});
                        bitmap.recycle();
                    }
                    int i3 = options.outHeight;
                    int i4 = options.outWidth;
                    x.d("MicroMsg.RecordMsgImgService", "width: %s, height: %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)});
                    if (i4 > i) {
                        i3 = (options.outHeight * i) / options.outWidth;
                        i4 = i;
                    }
                    i4 = Math.max(1, i4);
                    i3 = Math.max(1, i3);
                    if (i4 > i) {
                        i3 = (options.outHeight * i) / options.outWidth;
                    } else {
                        i = i4;
                    }
                    int VX = ExifHelper.VX(c);
                    if (VX == 90 || VX == 270) {
                        i4 = i;
                        i2 = i3;
                    } else {
                        i4 = i3;
                        i2 = i;
                    }
                    bitmap = com.tencent.mm.sdk.platformtools.c.e(c, i4, i2, false);
                    if (bitmap == null) {
                        x.e("MicroMsg.RecordMsgImgService", "extractThumbNail fail, temBmp is null, filePath = " + c);
                        bitmap = null;
                    } else {
                        bitmap = com.tencent.mm.sdk.platformtools.c.b(bitmap, (float) VX);
                        this.jaR.put(c, bitmap);
                    }
                }
            }
        } else {
            bitmap = BitmapFactory.decodeResource(ad.getContext().getResources(), R.g.nosdcard_chatting_bg);
        }
        if (bitmap == null && !z) {
            x.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[]{Boolean.valueOf(super.a(vxVar, j))});
            h.b(vxVar, j, r1);
        }
        return bitmap;
    }

    public final void bqy() {
        super.destory();
    }
}
