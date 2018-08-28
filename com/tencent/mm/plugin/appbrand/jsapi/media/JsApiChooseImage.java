package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseImage extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 29;
    public static final String NAME = "chooseImage";

    private static final class a extends AppBrandProxyUIProcessTask {
        ChooseRequest fUl;
        ChooseResult fUm = new ChooseResult();
        int fUn;
        private p fUo;
        private OnCancelListener fUp;

        private a() {
        }

        static /* synthetic */ void a(a aVar, String str, String str2, Intent intent) {
            aVar.ahw().geJ = aVar;
            d.b(aVar.ahw(), str, str2, intent, 3);
        }

        protected final void a(ProcessRequest processRequest) {
            int i;
            boolean i2;
            this.fUl = (ChooseRequest) processRequest;
            this.fUl.count = Math.max(1, Math.min(9, this.fUl.count));
            this.fUn = (this.fUl.fUi & this.fUl.fUj) != 0 ? 8 : 7;
            if (bi.fQ(ahw()) > 200) {
                i2 = 1;
            } else {
                i2 = false;
            }
            if (i2 == 0) {
                s.makeText(ahw(), ad.getResources().getString(j.app_brand_choose_media_memory_check_message), 1).show();
            }
            ahw().geJ = this;
            Intent intent = new Intent();
            String str = "key_send_raw_image";
            if (this.fUl.fUi) {
                i2 = false;
            } else {
                i2 = true;
            }
            intent.putExtra(str, i2);
            intent.putExtra("query_media_type", 1);
            if (this.fUl.fUg && this.fUl.fUh) {
                l.a(ahw(), 1, this.fUl.count, this.fUn, intent);
            } else if (this.fUl.fUh) {
                intent.putExtra("show_header_view", false);
                l.a(ahw(), 1, this.fUl.count, this.fUn, intent);
            } else if (this.fUl.fUg) {
                l.c(ahw(), e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
            } else {
                x.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
                this.fUm.bjW = -2;
                b((ProcessResult) this.fUm);
            }
        }

        private void kN(int i) {
            this.fUp = new 1(this);
            MMActivity ahw = ahw();
            ad.getResources().getString(j.app_tip);
            this.fUo = h.a(ahw, ad.getResources().getString(i), true, this.fUp);
        }

        private static String tJ(String str) {
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            if (orientationInDegree == 0) {
                return str;
            }
            orientationInDegree %= 360;
            try {
                Options options = new Options();
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options, 0);
                if (decodeFile == null) {
                    x.e("MicroMsg.JsApiChooseImage", "rotate image, get null bmp");
                    return str;
                }
                Bitmap b = c.b(decodeFile, (float) orientationInDegree);
                String str2 = e.dgl + "microMsg.tmp." + System.currentTimeMillis() + (com.tencent.mm.plugin.appbrand.r.a.a(options) ? ".jpg" : ".png");
                try {
                    c.a(b, 100, com.tencent.mm.plugin.appbrand.r.a.a(options) ? CompressFormat.JPEG : CompressFormat.PNG, str2, true);
                    if (com.tencent.mm.plugin.appbrand.r.a.a(options) && com.tencent.mm.a.e.cn(str) && com.tencent.mm.a.e.cn(str2)) {
                        try {
                            android.support.b.a aVar = new android.support.b.a(str2);
                            b.a(new android.support.b.a(str), aVar);
                            aVar.setAttribute("Orientation", null);
                            aVar.setAttribute("ImageWidth", null);
                            aVar.setAttribute("ThumbnailImageWidth", null);
                            aVar.saveAttributes();
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.JsApiChooseImage", e, "duplicate exif", new Object[0]);
                        }
                    }
                    return str2;
                } catch (Exception e2) {
                    x.e("MicroMsg.JsApiChooseImage", "rotate image, exception occurred when saving | %s", new Object[]{e2});
                    com.tencent.mm.a.e.deleteFile(str2);
                    return str;
                }
            } catch (OutOfMemoryError e3) {
                return str;
            } catch (NullPointerException e4) {
                return str;
            }
        }

        private static String tK(String str) {
            Bitmap decodeFile;
            String str2 = e.dgl + "microMsg." + System.currentTimeMillis() + ".jpg";
            try {
                decodeFile = MMBitmapFactory.decodeFile(str, 0);
            } catch (OutOfMemoryError e) {
                x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom");
                try {
                    decodeFile = c.decodeFile(str, null);
                } catch (OutOfMemoryError e2) {
                    x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, oom again");
                    decodeFile = null;
                } catch (Exception e3) {
                    x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, e " + e3);
                    decodeFile = null;
                }
            } catch (NullPointerException e4) {
                try {
                    decodeFile = c.decodeFile(str, null);
                } catch (Exception e32) {
                    x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp npe retry, e " + e32);
                    decodeFile = null;
                }
            } catch (Exception e322) {
                x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp e " + e322);
                decodeFile = null;
            }
            if (decodeFile == null) {
                x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp return null");
                return null;
            }
            long VF = bi.VF();
            x.i("MicroMsg.JsApiChooseImage", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.appbrand.r.a.bP(str2, str)), Long.valueOf(bi.VF() - VF), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length())});
            return com.tencent.mm.plugin.appbrand.r.a.bP(str2, str) ? str2 : str;
        }

        protected final void ahC() {
            super.ahC();
            if (this.fUo != null) {
                this.fUo.dismiss();
                this.fUo = null;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(int r12, int r13, android.content.Intent r14) {
            /*
            r11 = this;
            r3 = -2;
            r5 = 1;
            r1 = 0;
            if (r13 != 0) goto L_0x000f;
        L_0x0005:
            r0 = r11.fUm;
            r0.bjW = r1;
            r0 = r11.fUm;
            r11.b(r0);
        L_0x000e:
            return;
        L_0x000f:
            switch(r12) {
                case 1: goto L_0x001c;
                case 2: goto L_0x00e7;
                case 3: goto L_0x001c;
                default: goto L_0x0012;
            };
        L_0x0012:
            r0 = r11.fUm;
            r0.bjW = r3;
            r0 = r11.fUm;
            r11.b(r0);
            goto L_0x000e;
        L_0x001c:
            if (r14 != 0) goto L_0x0028;
        L_0x001e:
            r0 = r11.fUm;
            r0.bjW = r1;
            r0 = r11.fUm;
            r11.b(r0);
            goto L_0x000e;
        L_0x0028:
            r0 = "CropImage_OutputPath_List";
            r2 = r14.getStringArrayListExtra(r0);
            r0 = "CropImage_Compress_Img";
            r6 = r14.getBooleanExtra(r0, r1);
            r0 = r11.fUl;
            r3 = r0.fUi;
            r0 = r11.fUl;
            r0 = r0.fUj;
            if (r0 != 0) goto L_0x00db;
        L_0x0040:
            r0 = r5;
        L_0x0041:
            r0 = r0 & r3;
            if (r0 != 0) goto L_0x0050;
        L_0x0044:
            r0 = r11.fUl;
            r0 = r0.fUi;
            r3 = r11.fUl;
            r3 = r3.fUj;
            r0 = r0 & r3;
            r0 = r0 & r6;
            if (r0 == 0) goto L_0x00de;
        L_0x0050:
            r4 = r5;
        L_0x0051:
            r0 = "isTakePhoto";
            r0 = r14.getBooleanExtra(r0, r1);
            if (r0 != 0) goto L_0x0063;
        L_0x005a:
            r0 = "isPreviewPhoto";
            r0 = r14.getBooleanExtra(r0, r1);
            if (r0 == 0) goto L_0x00e1;
        L_0x0063:
            r3 = r5;
        L_0x0064:
            r0 = "MicroMsg.JsApiChooseImage";
            r7 = "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b";
            r8 = 5;
            r8 = new java.lang.Object[r8];
            r9 = java.lang.Boolean.valueOf(r3);
            r8[r1] = r9;
            r9 = r11.fUl;
            r9 = r9.fUi;
            r9 = java.lang.Boolean.valueOf(r9);
            r8[r5] = r9;
            r9 = 2;
            r10 = r11.fUl;
            r10 = r10.fUj;
            r10 = java.lang.Boolean.valueOf(r10);
            r8[r9] = r10;
            r9 = 3;
            r6 = java.lang.Boolean.valueOf(r6);
            r8[r9] = r6;
            r6 = 4;
            r9 = java.lang.Boolean.valueOf(r4);
            r8[r6] = r9;
            com.tencent.mm.sdk.platformtools.x.d(r0, r7, r8);
            if (r4 == 0) goto L_0x00a0;
        L_0x009b:
            r0 = com.tencent.mm.plugin.appbrand.s.j.app_brand_choose_media_video_compressing;
            r11.kN(r0);
        L_0x00a0:
            if (r4 != 0) goto L_0x00e5;
        L_0x00a2:
            r0 = com.tencent.mm.sdk.platformtools.bi.cX(r2);
            if (r0 != 0) goto L_0x00e3;
        L_0x00a8:
            r6 = r2.iterator();
        L_0x00ac:
            r0 = r6.hasNext();
            if (r0 == 0) goto L_0x00e3;
        L_0x00b2:
            r0 = r6.next();
            r0 = (java.lang.String) r0;
            r0 = com.tencent.mm.compatible.util.Exif.fromFile(r0);
            r0 = r0.getOrientationInDegree();
            if (r0 == 0) goto L_0x00ac;
        L_0x00c2:
            r0 = r5;
        L_0x00c3:
            if (r0 == 0) goto L_0x00e5;
        L_0x00c5:
            if (r5 == 0) goto L_0x00cc;
        L_0x00c7:
            r0 = com.tencent.mm.plugin.appbrand.s.j.app_brand_jsapi_choose_image_processing;
            r11.kN(r0);
        L_0x00cc:
            r6 = com.tencent.mm.plugin.appbrand.r.c.Em();
            r0 = new com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage$a$2;
            r1 = r11;
            r0.<init>(r2, r3, r4, r5);
            r6.H(r0);
            goto L_0x000e;
        L_0x00db:
            r0 = r1;
            goto L_0x0041;
        L_0x00de:
            r4 = r1;
            goto L_0x0051;
        L_0x00e1:
            r3 = r1;
            goto L_0x0064;
        L_0x00e3:
            r0 = r1;
            goto L_0x00c3;
        L_0x00e5:
            r5 = r1;
            goto L_0x00c5;
        L_0x00e7:
            r0 = r11.ahw();
            r0 = r0.getApplicationContext();
            r2 = com.tencent.mm.compatible.util.e.dgl;
            r0 = com.tencent.mm.pluginsdk.ui.tools.l.d(r0, r14, r2);
            r2 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
            if (r2 == 0) goto L_0x010f;
        L_0x00fb:
            r0 = "MicroMsg.JsApiChooseImage";
            r1 = "take photo, but result is null";
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);
            r0 = r11.fUm;
            r0.bjW = r3;
            r0 = r11.fUm;
            r11.b(r0);
            goto L_0x000e;
        L_0x010f:
            r2 = "MicroMsg.JsApiChooseImage";
            r3 = "take photo, result[%s]";
            r4 = new java.lang.Object[r5];
            r4[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
            r1 = new com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage$a$3;
            r1.<init>(r11, r0);
            com.tencent.mm.sdk.platformtools.ah.A(r1);
            goto L_0x000e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.b(int, int, android.content.Intent):void");
        }
    }

    static /* synthetic */ String i(ArrayList arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.JsApiChooseImage", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        return jSONArray.toString();
    }

    static /* synthetic */ JSONArray j(ArrayList arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.JsApiChooseImage", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        return jSONArray;
    }

    public final void a(com.tencent.mm.plugin.appbrand.l lVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        if (k.qu(lVar.mAppId).fdN) {
            lVar.E(i, f("cancel", null));
            return;
        }
        MMActivity c = c(lVar);
        if (c == null) {
            lVar.E(i, f("fail", null));
            return;
        }
        ChooseRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        String optString = jSONObject.optString("sizeType");
        x.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", new Object[]{optJSONArray, optString, jSONObject.optString("count")});
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.fUg = true;
            chooseRequest.fUh = true;
        } else {
            chooseRequest.fUg = optJSONArray.toString().contains("camera");
            chooseRequest.fUh = optJSONArray.toString().contains("album");
        }
        if (chooseRequest.fUg) {
            com.tencent.mm.plugin.appbrand.a.a(lVar.mAppId, new 3(this, lVar, jSONObject, i));
            MMActivity c2 = c(lVar);
            if (c2 == null) {
                lVar.E(i, f("fail", null));
            } else {
                i2 = com.tencent.mm.pluginsdk.permission.a.a(c2, "android.permission.CAMERA", TbsListener$ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH, "", "");
                if (i2 != 0) {
                    com.tencent.mm.plugin.appbrand.a.pZ(lVar.mAppId);
                }
            }
            if (i2 == 0) {
                return;
            }
        }
        k.qv(lVar.mAppId).fdN = true;
        com.tencent.mm.plugin.appbrand.e.a(lVar.mAppId, new 1(this, lVar));
        if (bi.oW(optString)) {
            optString = "compressed";
        }
        chooseRequest.fUi = optString.contains("compressed");
        chooseRequest.fUj = optString.contains("original");
        chooseRequest.count = bi.getInt(r5, 9);
        chooseRequest.appId = lVar.mAppId;
        com.tencent.mm.plugin.appbrand.ipc.a.b(c, chooseRequest, new 2(this, lVar, i));
    }
}
