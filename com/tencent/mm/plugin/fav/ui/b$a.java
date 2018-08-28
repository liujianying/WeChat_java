package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.d;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

class b$a implements Runnable {
    g iWQ;

    public b$a(g gVar) {
        this.iWQ = gVar;
    }

    public final void run() {
        Throwable e;
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable th;
        List list = this.iWQ.field_favProto.rBI;
        if (list.size() > 0) {
            boolean z = false;
            int size = list.size();
            x.i("MicroMsg.Fav.FavAddService", "run addfavservice copyrunable info.field_type = %d", new Object[]{Integer.valueOf(this.iWQ.field_type)});
            vx vxVar;
            if (this.iWQ.field_type == 18 && this.iWQ.field_sourceType == 6) {
                int i = 0;
                while (i < size) {
                    boolean z2;
                    vxVar = (vx) list.get(i);
                    if (vxVar.rAa && vxVar.rAc) {
                        z2 = z;
                    } else {
                        z2 = true;
                    }
                    i++;
                    z = z2;
                }
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    String cu;
                    vxVar = (vx) list.get(i2);
                    if (bi.oW(vxVar.jdM)) {
                        vxVar.UO(b.bm(vxVar.toString(), this.iWQ.field_type));
                    }
                    if (!(vxVar.rAa && vxVar.rAc)) {
                        z = true;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    String str = vxVar.rzM;
                    if (d.cn(str)) {
                        cu = com.tencent.mm.a.g.cu(str);
                        String cv = com.tencent.mm.a.g.cv(str);
                        vxVar.UM(cu);
                        vxVar.UN(cv);
                        vxVar.fO(new com.tencent.mm.vfs.b(str).length());
                        cu = b.b(vxVar);
                        if (!str.equals(cu)) {
                            d.y(str, cu);
                        }
                    } else {
                        x.i("MicroMsg.Fav.FavAddService", "copy file fail, type:%d, %s not exist!", new Object[]{Integer.valueOf(vxVar.bjS), str});
                    }
                    cu = vxVar.rzO;
                    if (bi.oW(cu) && d.cn(str) && this.iWQ.field_type == 4 && this.iWQ.field_favProto.rBG.bJt == 13) {
                        cu = b.b(vxVar) + "_tempthumb";
                        Bitmap By = c.By(str);
                        if (By != null) {
                            try {
                                x.i("MicroMsg.Fav.FavAddService", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                c.a(By, 60, CompressFormat.JPEG, cu, true);
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.Fav.FavAddService", e2, "", new Object[0]);
                            }
                        }
                        vxVar.UQ(cu);
                        try {
                            x.i("MicroMsg.Fav.FavAddService", "add fav service: get video duration");
                            mediaMetadataRetriever = new MediaMetadataRetriever();
                            try {
                                mediaMetadataRetriever.setDataSource(str);
                                vxVar.CE(bi.ge((long) bi.getInt(mediaMetadataRetriever.extractMetadata(9), 0)));
                                mediaMetadataRetriever.release();
                            } catch (Exception e3) {
                                e2 = e3;
                                try {
                                    x.printErrStackTrace("MicroMsg.Fav.FavAddService", e2, "get video duration error. path %s", new Object[]{str});
                                    if (mediaMetadataRetriever != null) {
                                        mediaMetadataRetriever.release();
                                    }
                                    if (d.cn(cu)) {
                                        InputStream inputStream = null;
                                        try {
                                            inputStream = d.openRead(cu);
                                            String oV = bi.oV(com.tencent.mm.a.g.b(inputStream, 4096));
                                            long abQ = d.abQ(cu);
                                            String h = com.tencent.mm.a.g.h(inputStream);
                                            vxVar.UR(oV);
                                            vxVar.US(h);
                                            vxVar.fP(abQ);
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e4) {
                                                }
                                            }
                                        } catch (FileNotFoundException e5) {
                                            x.e("MicroMsg.Fav.FavAddService", "FileOp thumbpath error !");
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e6) {
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e7) {
                                                }
                                            }
                                        }
                                        String c = b.c(vxVar);
                                        if (!cu.equals(c)) {
                                            d.y(cu, c);
                                        }
                                    } else {
                                        x.i("MicroMsg.Fav.FavAddService", "copy thumb fail, %s not exist!", new Object[]{cu});
                                    }
                                    x.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", new Object[]{Long.valueOf(this.iWQ.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        } catch (Exception e8) {
                            e2 = e8;
                            mediaMetadataRetriever = null;
                            x.printErrStackTrace("MicroMsg.Fav.FavAddService", e2, "get video duration error. path %s", new Object[]{str});
                            if (mediaMetadataRetriever != null) {
                                mediaMetadataRetriever.release();
                            }
                            if (d.cn(cu)) {
                                x.i("MicroMsg.Fav.FavAddService", "copy thumb fail, %s not exist!", new Object[]{cu});
                            } else {
                                InputStream inputStream2 = null;
                                try {
                                    inputStream2 = d.openRead(cu);
                                    String oV2 = bi.oV(com.tencent.mm.a.g.b(inputStream2, 4096));
                                    long abQ2 = d.abQ(cu);
                                    String h2 = com.tencent.mm.a.g.h(inputStream2);
                                    vxVar.UR(oV2);
                                    vxVar.US(h2);
                                    vxVar.fP(abQ2);
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e42) {
                                        }
                                    }
                                } catch (FileNotFoundException e52) {
                                    x.e("MicroMsg.Fav.FavAddService", "FileOp thumbpath error !");
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e62) {
                                        }
                                    }
                                } catch (Throwable th22) {
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e72) {
                                        }
                                    }
                                }
                                String c2 = b.c(vxVar);
                                if (!cu.equals(c2)) {
                                    d.y(cu, c2);
                                }
                            }
                            x.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", new Object[]{Long.valueOf(this.iWQ.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        } catch (Throwable th4) {
                            th = th4;
                            mediaMetadataRetriever = null;
                        }
                    }
                    if (d.cn(cu)) {
                        InputStream inputStream22 = null;
                        try {
                            inputStream22 = d.openRead(cu);
                            String oV22 = bi.oV(com.tencent.mm.a.g.b(inputStream22, 4096));
                            long abQ22 = d.abQ(cu);
                            String h22 = com.tencent.mm.a.g.h(inputStream22);
                            vxVar.UR(oV22);
                            vxVar.US(h22);
                            vxVar.fP(abQ22);
                            if (inputStream22 != null) {
                                try {
                                    inputStream22.close();
                                } catch (Exception e422) {
                                }
                            }
                        } catch (FileNotFoundException e522) {
                            x.e("MicroMsg.Fav.FavAddService", "FileOp thumbpath error !");
                            if (inputStream22 != null) {
                                try {
                                    inputStream22.close();
                                } catch (Exception e622) {
                                }
                            }
                        } catch (Throwable th222) {
                            if (inputStream22 != null) {
                                try {
                                    inputStream22.close();
                                } catch (Exception e722) {
                                }
                            }
                        }
                        String c22 = b.c(vxVar);
                        if (!cu.equals(c22)) {
                            d.y(cu, c22);
                        }
                    } else {
                        x.i("MicroMsg.Fav.FavAddService", "copy thumb fail, %s not exist!", new Object[]{cu});
                    }
                    x.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", new Object[]{Long.valueOf(this.iWQ.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
            }
            ah.A(new 1(this, z));
            return;
        }
        return;
        if (mediaMetadataRetriever != null) {
            mediaMetadataRetriever.release();
        }
        throw th;
    }
}
