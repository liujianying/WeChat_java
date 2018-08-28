package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.d$a;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.k;
import com.tencent.mm.ak.o;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.chatting.al;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class d extends a implements d$a, e$a {
    private static long tUT = ((long) (((double) Runtime.getRuntime().maxMemory()) * 0.05d));
    public HashMap<Long, Integer> hre = new HashMap();
    int if = 0;
    private HashMap<String, WeakReference<Bitmap>> pWn = new HashMap();
    private c tUP;
    public final e tUQ = new e(this);
    private HashMap<bd, String> tUR = new HashMap();
    private HashMap<bd, String> tUS = new HashMap();
    private long tUU = 0;

    public d(b bVar) {
        super(bVar);
        a aVar = a.sFg;
        al alVar = new al(al.a.tMN, bVar.tTy);
        this.tUP = alVar;
        aVar.b(alVar);
        this.tUQ.ay(f.a.tVr.jDs.snapshot());
        k.cxA().tXw = this;
    }

    public final void detach() {
        super.detach();
        a.sFg.c(this.tUP);
        if (this.pWn != null) {
            for (Object obj : this.pWn.keySet()) {
                Bitmap bitmap = (Bitmap) ((WeakReference) this.pWn.get(obj)).get();
                if (!(bitmap == null || bitmap.isRecycled())) {
                    x.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[]{bitmap.toString()});
                    bitmap.recycle();
                }
            }
        }
        e eVar = this.tUQ;
        eVar.tVc = null;
        eVar.jDo.clear();
        eVar.jDr.clear();
        eVar.jDq.clear();
        eVar.jDp.clear();
        eVar.tVb.clear();
        eVar.aRU();
        if (!(eVar.tVh == null || eVar.tVh.isRecycled())) {
            eVar.tVh.recycle();
            eVar.tVh = null;
        }
        o.Pg().a(this);
        k cxA = k.cxA();
        if (equals(cxA.tXw)) {
            cxA.tXw = null;
        }
    }

    public final int bu(bd bdVar) {
        if (bdVar == null || !this.hre.containsKey(Long.valueOf(bdVar.field_msgId))) {
            return 0;
        }
        return ((Integer) this.hre.get(Long.valueOf(bdVar.field_msgId))).intValue();
    }

    private void f(bd bdVar, int i) {
        this.hre.put(Long.valueOf(bdVar.field_msgId), Integer.valueOf(i));
    }

    private void j(long j, int i) {
        this.hre.put(Long.valueOf(j), Integer.valueOf(i));
    }

    public final boolean a(j jVar, bd bdVar, int i) {
        super.a(jVar, bdVar, i);
        if (jVar == null || bdVar == null || i < 0) {
            return false;
        }
        int bu = bu(bdVar);
        x.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s", new Object[]{Integer.valueOf(jVar.tXm.hashCode()), Integer.valueOf(i)});
        j.O(jVar.tXd, 8);
        e h = h(bdVar, false);
        if (h == null) {
            return false;
        }
        switch (bu) {
            case 0:
                boolean cmu;
                x.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
                x.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
                if (bdVar.field_isSend == 1) {
                    cmu = bdVar.cmu();
                } else if (bdVar.cmu()) {
                    cmu = true;
                } else {
                    String c = c(bdVar, h);
                    if (!h.OM() || (c != null && com.tencent.mm.a.e.cn(c))) {
                        Object obj = (System.currentTimeMillis() - bdVar.field_createTime <= 259200000 || (!bi.oW(c) && com.tencent.mm.a.e.cn(c))) ? null : 1;
                        cmu = obj != null;
                    } else {
                        cmu = true;
                    }
                }
                if (!cmu) {
                    if (!a(jVar, bdVar, h, i)) {
                        f(bdVar, 2);
                    } else if (h.OM()) {
                        f(bdVar, 4);
                        break;
                    } else {
                        f(bdVar, 1);
                    }
                    z.w(bdVar);
                    x.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", new Object[]{Integer.valueOf(o.Pg().a(h.dTK, bdVar.field_msgId, 0, Integer.valueOf(i), R.g.chat_img_template, this, 0))});
                    if (o.Pg().a(h.dTK, bdVar.field_msgId, 0, Integer.valueOf(i), R.g.chat_img_template, this, 0) != -2) {
                        a(jVar, bdVar, h, false, i);
                        break;
                    }
                    x.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
                    e h2 = h(bdVar, true);
                    if (h2 != null) {
                        if (!a(jVar, bdVar, h2, i)) {
                            f(bdVar, 2);
                        } else if (bdVar.field_isSend == 1 || h2.OM()) {
                            f(bdVar, 4);
                            break;
                        } else {
                            f(bdVar, 1);
                        }
                        x.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", new Object[]{Long.valueOf(h2.dTK), Boolean.valueOf(h2.OM())});
                        a(jVar, bdVar, h2, false, i);
                        break;
                    }
                    x.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
                    break;
                }
                f(bdVar, 5);
                a(bdVar, jVar, 5);
                break;
                break;
            case 1:
            case 4:
                a(jVar, bdVar, h, i);
                break;
            case 2:
                a(jVar, bdVar, h, false, i);
                break;
            case 3:
                a(jVar, bdVar, h, true, i);
                break;
            case 5:
            case 6:
                a(bdVar, jVar, bu);
                jVar.jEz.invalidate();
                break;
        }
        return true;
    }

    public static e bv(bd bdVar) {
        if (!b.bg(bdVar)) {
            return null;
        }
        if (bdVar.field_isSend == 1) {
            e br = o.Pf().br(bdVar.field_msgId);
            if (br.dTK != 0) {
                return br;
            }
        }
        return o.Pf().bq(bdVar.field_msgSvrId);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ak.e h(com.tencent.mm.storage.bd r11, boolean r12) {
        /*
        r10 = this;
        r8 = 0;
        r2 = 0;
        r4 = 1;
        r0 = com.tencent.mm.ui.chatting.gallery.b.bg(r11);
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return r2;
    L_0x000b:
        r0 = r10.tTx;
        if (r0 == 0) goto L_0x0015;
    L_0x000f:
        r0 = r10.tTx;
        r0 = r0.tTz;
        if (r0 != 0) goto L_0x001f;
    L_0x0015:
        r0 = "MicroMsg.ImageGalleryHolderImage";
        r1 = "adapter is null!!";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x000a;
    L_0x001f:
        if (r12 != 0) goto L_0x0053;
    L_0x0021:
        r0 = r11.field_isSend;
        if (r0 != r4) goto L_0x0038;
    L_0x0025:
        r0 = r10.tTx;
        r0 = r0.tTz;
        r0 = r0.tTW;
        r2 = r11.field_msgId;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.ak.e) r0;
        r2 = r0;
    L_0x0038:
        if (r2 != 0) goto L_0x0053;
    L_0x003a:
        r0 = r11.field_msgSvrId;
        r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0053;
    L_0x0040:
        r0 = r10.tTx;
        r0 = r0.tTz;
        r0 = r0.tTV;
        r2 = r11.field_msgSvrId;
        r1 = java.lang.Long.valueOf(r2);
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.ak.e) r0;
        r2 = r0;
    L_0x0053:
        if (r2 != 0) goto L_0x000a;
    L_0x0055:
        r3 = 0;
        r0 = r11.field_isSend;
        if (r0 != r4) goto L_0x006a;
    L_0x005a:
        r0 = r11.field_msgId;
        r2 = com.tencent.mm.ak.o.Pf();
        r2 = r2.br(r0);
        r6 = r2.dTK;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 != 0) goto L_0x0075;
    L_0x006a:
        r0 = r11.field_msgSvrId;
        r2 = com.tencent.mm.ak.o.Pf();
        r2 = r2.bq(r0);
        r3 = r4;
    L_0x0075:
        r4 = r10.tTx;
        r4 = r4.tTz;
        if (r3 == 0) goto L_0x0085;
    L_0x007b:
        r3 = r4.tTV;
        r0 = java.lang.Long.valueOf(r0);
        r3.put(r0, r2);
        goto L_0x000a;
    L_0x0085:
        r3 = r4.tTW;
        r0 = java.lang.Long.valueOf(r0);
        r3.put(r0, r2);
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.d.h(com.tencent.mm.storage.bd, boolean):com.tencent.mm.ak.e");
    }

    private String c(bd bdVar, e eVar) {
        String str = (String) this.tUR.get(bdVar);
        if (str != null) {
            return str;
        }
        str = a(bdVar, eVar, false);
        if (str == null || str.length() == 0) {
            return null;
        }
        this.tUR.put(bdVar, str);
        return str;
    }

    private boolean a(j jVar, bd bdVar, e eVar, int i) {
        x.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
        String c = c(bdVar, eVar);
        j.O(jVar.tXi, 8);
        String str = (String) this.tUS.get(bdVar);
        if (str == null) {
            str = o.Pf().E(bdVar.field_imgPath, true);
            this.tUS.put(bdVar, str);
        }
        boolean a = a(jVar, str, c, bdVar);
        if (i == this.tTx.tTy.getCurrentItem() && this.tTx.tTC) {
            this.tTx.bp(bdVar);
            this.tTx.tTC = false;
        }
        return a;
    }

    private void a(j jVar, bd bdVar, e eVar, boolean z, int i) {
        a(jVar, bdVar, eVar, z, true, i);
    }

    private void a(j jVar, bd bdVar, e eVar, boolean z, boolean z2, int i) {
        x.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = " + z);
        j.O(jVar.tXj, 8);
        String str = null;
        if (!z) {
            jVar.tXm.setVisibility(0);
        }
        e a = f.a(eVar);
        if (z && i == this.tTx.tTy.getCurrentItem()) {
            ImageGalleryUI imageGalleryUI = this.tTx.tTy;
            imageGalleryUI.fm(true);
            imageGalleryUI.cxh();
            imageGalleryUI.cwW().tVH.setVisibility(0);
            imageGalleryUI.cwW().tVI.setVisibility(8);
            imageGalleryUI.cwW().tVJ.setVisibility(0);
            imageGalleryUI.cwW().tVK.setVisibility(8);
            imageGalleryUI.cxj();
            imageGalleryUI.cxk();
            imageGalleryUI.cwW().tVJ.setText("0%");
        }
        if (z) {
            str = a(bdVar, eVar, true);
        }
        if (bi.oW(str)) {
            str = o.Pf().o(a.dTN, "", "");
        }
        String E = o.Pf().E(bdVar.field_imgPath, true);
        if (z2) {
            a(jVar, E, str, bdVar);
        }
        if (!z) {
            int i2 = eVar.dHI;
            if (Math.max(1, (int) (i2 != 0 ? ((((long) eVar.offset) * 100) / ((long) i2)) - 1 : 0)) > 50) {
                jVar.cxw().tXi.setVisibility(8);
            } else {
                jVar.cxw().tXi.setVisibility(0);
            }
        }
        jVar.cxw().tXg.setVisibility(8);
        jVar.cxw().tXf.setVisibility(8);
        jVar.cxw().tXe.setVisibility(8);
    }

    private static void a(bd bdVar, j jVar, int i) {
        x.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
        String E = o.Pf().E(bdVar.field_imgPath, true);
        j.O(jVar.tXi, 8);
        j.O(jVar.tXd, 8);
        j.O(jVar.tXm, 8);
        j.O(jVar.tXn, 8);
        jVar.cxx().tXj.setVisibility(0);
        jVar.cxx().tXl.setImageResource(R.k.image_download_fail_icon);
        if (E == null || !com.tencent.mm.a.e.cn(E)) {
            jVar.cxx().tXk.setText(R.l.imgdownload_fail_tips);
        } else if (i == 6) {
            jVar.cxx().tXk.setText(R.l.imgdownload_fail);
        } else if (bdVar.cmu()) {
            jVar.cxx().tXk.setText(R.l.imgdownload_cleaned);
        } else {
            jVar.cxx().tXk.setText(R.l.imgdownload_expired);
        }
    }

    private boolean a(j jVar, String str, String str2, bd bdVar) {
        j.O(jVar.tXm, 0);
        j.O(jVar.tXd, 8);
        j.O(jVar.tXi, 8);
        j.O(jVar.tXj, 8);
        return a(true, jVar.tXm, str, str2, false, jVar.mPosition, bdVar, jVar, null, -1, false);
    }

    private static Options aav(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        return options;
    }

    private boolean a(boolean z, MultiTouchImageView multiTouchImageView, String str, String str2, boolean z2, int i, bd bdVar, j jVar, e eVar, int i2, boolean z3) {
        x.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", new Object[]{Integer.valueOf(multiTouchImageView.hashCode()), str2, Integer.valueOf(i)});
        String str3 = null;
        boolean z4 = true;
        if (str2 == null || !com.tencent.mm.a.e.cn(str2)) {
            z4 = false;
        } else {
            str3 = str2;
        }
        if (str3 == null && str != null && com.tencent.mm.a.e.cn(str)) {
            if (com.tencent.mm.a.e.cn(str + "hd")) {
                str3 = str + "hd";
            } else {
                str3 = str;
            }
        }
        if (str3 == null) {
            x.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", new Object[]{str2});
            return false;
        } else if (jVar == null) {
            x.e("MicroMsg.ImageGalleryHolderImage", "alvinluo initImageView holder is null");
            return false;
        } else {
            Object obj;
            boolean Fz;
            Bitmap bitmap;
            if (!(str3.equals(str) || z3)) {
                float f;
                Object obj2;
                boolean z5 = false;
                float f2 = 1.0f;
                com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100408");
                if (fJ.isValid()) {
                    boolean z6;
                    Map ckq = fJ.ckq();
                    if (bi.getInt((String) ckq.get("MMUseBigImgOpt"), 0) == 1) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    f = bi.getFloat((String) ckq.get("heightFactor"), 1.0f);
                    f2 = bi.getFloat((String) ckq.get("heightFactor"), 1.0f);
                    z5 = z6;
                } else {
                    f = 1.0f;
                }
                x.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImgOpt abTest flag: %b, widthFactor: %f, heightFactor: %f", new Object[]{Boolean.valueOf(z5), Float.valueOf(f2), Float.valueOf(f)});
                if (z5) {
                    int hashCode;
                    Options aav = aav(str3);
                    x.d("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt width: %d, height: %d, screenWidth: %d, screenHeight: %d", new Object[]{Integer.valueOf(aav.outWidth), Integer.valueOf(aav.outHeight), Integer.valueOf(getScreenWidth(ad.getContext())), Integer.valueOf(getScreenHeight(ad.getContext()))});
                    if (((float) aav.outWidth) >= f * ((float) getScreenWidth(ad.getContext()))) {
                        obj2 = 1;
                    } else if (((float) hashCode) >= f2 * ((float) r8)) {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        String e;
                        obj = 1;
                        Fz = Fz(i2);
                        if (obj == null && !z2 && this.tUQ.jDs.bb(str3)) {
                            bitmap = (Bitmap) this.tUQ.jDs.get(str3);
                            if (!bitmap.isRecycled()) {
                                x.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[]{str3});
                                b(multiTouchImageView, bitmap);
                                return true;
                            }
                        }
                        if (z) {
                            multiTouchImageView.setImageBitmap(null);
                        }
                        if (obj != null) {
                            if (jVar.tXn == null) {
                                return false;
                            }
                            if (eVar == null) {
                                eVar = h(bdVar, true);
                            }
                            jVar.tXn.setOnImageLoadEventListener(new 1(this, str3, i, jVar, bdVar));
                        }
                        if (this.tTx.tTI) {
                            if (i >= 0) {
                                x.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", new Object[]{Integer.valueOf(i)});
                                a(jVar, false, true);
                                this.tUQ.b(multiTouchImageView, i);
                            }
                        } else if (obj != null) {
                            e = e(bdVar, eVar);
                            a(jVar, true, Fz);
                            a(jVar.tXn, str3, e != null ? com.davemorrissey.labs.subscaleview.view.a.S(e) : null);
                            return z4;
                        } else {
                            bitmap = aax(str3);
                            if (bitmap == null) {
                                bitmap = aax(str);
                            }
                            if (bitmap != null) {
                                a(jVar, false, true);
                                b((View) multiTouchImageView, bitmap);
                                if (str3.equals(str2)) {
                                    this.tUQ.u(str3, bitmap);
                                    this.tUQ.b(i, bitmap);
                                }
                                return z4;
                            }
                        }
                        if (obj == null) {
                            a(jVar, true, Fz);
                            e = e(bdVar, eVar);
                            e eVar2 = this.tUQ;
                            WxImageView wxImageView = jVar.tXn;
                            if (i < 0) {
                                i = jVar.mPosition;
                            }
                            if (!eVar2.qD.contains(str3)) {
                                int hashCode2 = wxImageView.hashCode();
                                eVar2.qF(hashCode2);
                                eVar2.a(hashCode2, wxImageView, str3);
                                if (wxImageView instanceof WxImageView) {
                                    eVar2.tVb.remove(hashCode2);
                                    eVar2.tVb.put(hashCode2, e);
                                }
                                eVar2.qD.add(str3);
                                eVar2.tVg.add(Integer.valueOf(i));
                                eVar2.ahW();
                            }
                        } else {
                            a(jVar, false, true);
                            e eVar3 = this.tUQ;
                            if (i < 0) {
                                i = jVar.mPosition;
                            }
                            if (!eVar3.qD.contains(str3)) {
                                hashCode = multiTouchImageView.hashCode();
                                eVar3.qF(hashCode);
                                eVar3.a(hashCode, multiTouchImageView, str3);
                                eVar3.qD.add(str3);
                                eVar3.tVg.add(Integer.valueOf(i));
                                eVar3.ahW();
                            }
                        }
                        return z4;
                    }
                }
                obj2 = null;
                if (obj2 != null) {
                    String e2;
                    obj = 1;
                    Fz = Fz(i2);
                    if (obj == null && !z2 && this.tUQ.jDs.bb(str3)) {
                        bitmap = (Bitmap) this.tUQ.jDs.get(str3);
                        if (!bitmap.isRecycled()) {
                            x.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[]{str3});
                            b(multiTouchImageView, bitmap);
                            return true;
                        }
                    }
                    if (z) {
                        multiTouchImageView.setImageBitmap(null);
                    }
                    if (obj != null) {
                        if (jVar.tXn == null) {
                            return false;
                        }
                        if (eVar == null) {
                            eVar = h(bdVar, true);
                        }
                        jVar.tXn.setOnImageLoadEventListener(new 1(this, str3, i, jVar, bdVar));
                    }
                    if (this.tTx.tTI) {
                        if (i >= 0) {
                            x.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", new Object[]{Integer.valueOf(i)});
                            a(jVar, false, true);
                            this.tUQ.b(multiTouchImageView, i);
                        }
                    } else if (obj != null) {
                        e2 = e(bdVar, eVar);
                        a(jVar, true, Fz);
                        a(jVar.tXn, str3, e2 != null ? com.davemorrissey.labs.subscaleview.view.a.S(e2) : null);
                        return z4;
                    } else {
                        bitmap = aax(str3);
                        if (bitmap == null) {
                            bitmap = aax(str);
                        }
                        if (bitmap != null) {
                            a(jVar, false, true);
                            b((View) multiTouchImageView, bitmap);
                            if (str3.equals(str2)) {
                                this.tUQ.u(str3, bitmap);
                                this.tUQ.b(i, bitmap);
                            }
                            return z4;
                        }
                    }
                    if (obj == null) {
                        a(jVar, true, Fz);
                        e2 = e(bdVar, eVar);
                        e eVar22 = this.tUQ;
                        WxImageView wxImageView2 = jVar.tXn;
                        if (i < 0) {
                            i = jVar.mPosition;
                        }
                        if (!eVar22.qD.contains(str3)) {
                            int hashCode22 = wxImageView2.hashCode();
                            eVar22.qF(hashCode22);
                            eVar22.a(hashCode22, wxImageView2, str3);
                            if (wxImageView2 instanceof WxImageView) {
                                eVar22.tVb.remove(hashCode22);
                                eVar22.tVb.put(hashCode22, e2);
                            }
                            eVar22.qD.add(str3);
                            eVar22.tVg.add(Integer.valueOf(i));
                            eVar22.ahW();
                        }
                    } else {
                        a(jVar, false, true);
                        e eVar32 = this.tUQ;
                        if (i < 0) {
                            i = jVar.mPosition;
                        }
                        if (!eVar32.qD.contains(str3)) {
                            hashCode = multiTouchImageView.hashCode();
                            eVar32.qF(hashCode);
                            eVar32.a(hashCode, multiTouchImageView, str3);
                            eVar32.qD.add(str3);
                            eVar32.tVg.add(Integer.valueOf(i));
                            eVar32.ahW();
                        }
                    }
                    return z4;
                }
            }
            obj = null;
            Fz = Fz(i2);
            bitmap = (Bitmap) this.tUQ.jDs.get(str3);
            if (bitmap.isRecycled()) {
                x.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[]{str3});
                b(multiTouchImageView, bitmap);
                return true;
            }
            if (z) {
                multiTouchImageView.setImageBitmap(null);
            }
            if (obj != null) {
                if (jVar.tXn == null) {
                    return false;
                }
                if (eVar == null) {
                    eVar = h(bdVar, true);
                }
                jVar.tXn.setOnImageLoadEventListener(new 1(this, str3, i, jVar, bdVar));
            }
            if (this.tTx.tTI) {
                if (obj != null) {
                    e2 = e(bdVar, eVar);
                    a(jVar, true, Fz);
                    a(jVar.tXn, str3, e2 != null ? com.davemorrissey.labs.subscaleview.view.a.S(e2) : null);
                    return z4;
                } else {
                    bitmap = aax(str3);
                    if (bitmap == null) {
                        bitmap = aax(str);
                    }
                    if (bitmap != null) {
                        a(jVar, false, true);
                        b((View) multiTouchImageView, bitmap);
                        if (str3.equals(str2)) {
                            this.tUQ.u(str3, bitmap);
                            this.tUQ.b(i, bitmap);
                        }
                        return z4;
                    }
                }
            } else if (i >= 0) {
                x.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", new Object[]{Integer.valueOf(i)});
                a(jVar, false, true);
                this.tUQ.b(multiTouchImageView, i);
            }
            if (obj == null) {
                a(jVar, false, true);
                e eVar322 = this.tUQ;
                if (i < 0) {
                    i = jVar.mPosition;
                }
                if (!eVar322.qD.contains(str3)) {
                    hashCode = multiTouchImageView.hashCode();
                    eVar322.qF(hashCode);
                    eVar322.a(hashCode, multiTouchImageView, str3);
                    eVar322.qD.add(str3);
                    eVar322.tVg.add(Integer.valueOf(i));
                    eVar322.ahW();
                }
            } else {
                a(jVar, true, Fz);
                e2 = e(bdVar, eVar);
                e eVar222 = this.tUQ;
                WxImageView wxImageView22 = jVar.tXn;
                if (i < 0) {
                    i = jVar.mPosition;
                }
                if (!eVar222.qD.contains(str3)) {
                    int hashCode222 = wxImageView22.hashCode();
                    eVar222.qF(hashCode222);
                    eVar222.a(hashCode222, wxImageView22, str3);
                    if (wxImageView22 instanceof WxImageView) {
                        eVar222.tVb.remove(hashCode222);
                        eVar222.tVb.put(hashCode222, e2);
                    }
                    eVar222.qD.add(str3);
                    eVar222.tVg.add(Integer.valueOf(i));
                    eVar222.ahW();
                }
            }
            return z4;
        }
    }

    private static void a(j jVar, boolean z, boolean z2) {
        int i = 0;
        if (jVar != null) {
            if (jVar.tXn != null) {
                jVar.tXn.setVisibility(z ? 0 : 8);
            }
            if (jVar.tXm != null) {
                MultiTouchImageView multiTouchImageView = jVar.tXm;
                if (!z2) {
                    i = 8;
                }
                multiTouchImageView.setVisibility(i);
            }
        }
    }

    public final void b(View view, Bitmap bitmap) {
        if (bitmap != null && view != null) {
            int hashCode = view.hashCode();
            int hashCode2 = bitmap.hashCode();
            int indexOfValue = this.tUQ.jDt.indexOfValue(hashCode);
            if (indexOfValue >= 0) {
                this.tUQ.jDt.removeAt(indexOfValue);
            }
            this.tUQ.jDt.put(hashCode2, hashCode);
            if (view instanceof MultiTouchImageView) {
                b((MultiTouchImageView) view, bitmap);
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageBitmap(bitmap);
            }
        }
    }

    public final Bitmap aaw(String str) {
        return aax(str);
    }

    public final void a(WxImageView wxImageView, String str, com.davemorrissey.labs.subscaleview.view.a aVar) {
        Options aav = aav(str);
        wxImageView.setOrientation(ExifHelper.VX(str));
        int i = aav.outWidth;
        int i2 = aav.outHeight;
        wxImageView.imageWidth = i;
        wxImageView.imageHeight = i2;
        wxImageView.crm();
        x.d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d", new Object[]{str, Integer.valueOf(wxImageView.imageWidth), Integer.valueOf(wxImageView.imageHeight)});
        if (wxImageView.djG != com.tencent.mm.graphics.a.c.diW) {
            return;
        }
        if (wxImageView.djD == null) {
            x.e("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView laodFile mTileIv is null");
        } else if (str == null) {
            x.i("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView loadFile path is null");
        } else {
            wxImageView.djA.setVisibility(0);
            com.davemorrissey.labs.subscaleview.view.a S = com.davemorrissey.labs.subscaleview.view.a.S(str);
            i = wxImageView.imageWidth;
            int i3 = wxImageView.imageHeight;
            if (S.bitmap == null) {
                S.YV = i;
                S.YW = i3;
            }
            if (S.YX != null) {
                S.YU = true;
                S.YV = S.YX.width();
                S.YW = S.YX.height();
            }
            wxImageView.YH = System.currentTimeMillis();
            x.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", new Object[]{str, Long.valueOf(wxImageView.YH)});
            wxImageView.djJ = new com.tencent.mm.graphics.c.a.a();
            wxImageView.djJ.djw = 22;
            wxImageView.djJ.imagePath = str;
            wxImageView.djJ.bXS = wxImageView.getActivityName();
            wxImageView.djL = true;
            if (aVar != null) {
                wxImageView.djI = new com.tencent.mm.graphics.c.a.a();
                if (aVar.uri != null) {
                    wxImageView.djI.imagePath = aVar.uri.toString();
                } else {
                    wxImageView.djI.imagePath = "";
                }
                wxImageView.djI.djw = 21;
                wxImageView.djI.bXS = wxImageView.getActivityName();
                wxImageView.djK = true;
            } else {
                wxImageView.djK = false;
            }
            if (aVar != null) {
                wxImageView.djD.a(S, aVar);
            } else {
                wxImageView.djD.setImage(S);
            }
        }
    }

    private static Bitmap ap(String str, int i, int i2) {
        Throwable th;
        String str2 = str + "_tmp.jpg";
        Bitmap decodeAsBitmap;
        try {
            if (com.tencent.mm.compatible.util.d.fS(16)) {
                return null;
            }
            if (!b.chp()) {
                int i3 = bi.getInt(g.AT().getValue("UseOptImageRecv"), 0);
                au.HU();
                x.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[]{Integer.valueOf(i3), Long.valueOf(r1.longValue()), Long.valueOf(new com.tencent.mm.a.o(com.tencent.mm.model.c.Df()).longValue() / 100), Boolean.valueOf(b.chp()), Integer.valueOf(VERSION.SDK_INT)});
                if ((((int) (new com.tencent.mm.a.o(com.tencent.mm.model.c.Df()).longValue() / 100)) % 100) + 1 > i3) {
                    return null;
                }
            }
            j.q(str, str2, false);
            boolean IsJpegFile = MMNativeJpeg.IsJpegFile(str2);
            boolean isProgressive = MMNativeJpeg.isProgressive(str2);
            boolean checkIntegrity = (bi.oW(str2) || !new File(str2).exists()) ? false : MMJpegOptim.checkIntegrity(str2);
            int cm = com.tencent.mm.a.e.cm(str2);
            if (IsJpegFile && isProgressive) {
                if (checkIntegrity) {
                    decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(str2);
                } else {
                    decodeAsBitmap = null;
                }
                try {
                    a.m(str, i2, i, decodeAsBitmap != null ? cm : 0 - cm);
                } catch (Throwable th2) {
                    th = th2;
                    x.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[]{str, bi.i(th)});
                    com.tencent.mm.a.e.deleteFile(str2);
                    return decodeAsBitmap;
                }
            }
            decodeAsBitmap = null;
            x.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", new Object[]{Boolean.valueOf(IsJpegFile), Boolean.valueOf(isProgressive), Boolean.valueOf(checkIntegrity), Integer.valueOf(cm), Integer.valueOf(i2), Integer.valueOf(i), decodeAsBitmap, str});
            com.tencent.mm.a.e.deleteFile(str2);
            return decodeAsBitmap;
        } catch (Throwable e) {
            x.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", new Object[]{bi.i(e)});
            return null;
        } catch (Throwable th3) {
            th = th3;
            decodeAsBitmap = null;
            x.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[]{str, bi.i(th)});
            com.tencent.mm.a.e.deleteFile(str2);
            return decodeAsBitmap;
        }
    }

    private static Bitmap aax(String str) {
        if (str == null) {
            return null;
        }
        Bitmap ap;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            x.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[]{decodeFile.toString()});
            decodeFile.recycle();
        }
        int VX = ExifHelper.VX(str);
        int i = options.outWidth;
        int i2 = options.outHeight;
        try {
            long max = Math.max((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()) - tUT, 0);
            long j = (long) ((options.outWidth * options.outHeight) * 4);
            x.i("MicroMsg.ImageGalleryHolderImage", "hy: current free memory: %d, previewDecodedBmLength: %d", new Object[]{Long.valueOf(max), Long.valueOf(j)});
            if (max < j) {
                double sqrt = Math.sqrt(((double) max) / ((double) j));
                x.v("MicroMsg.ImageGalleryHolderImage", "hy: sample is %f", new Object[]{Double.valueOf(sqrt)});
                i = (int) (((double) i) * sqrt);
                i2 = (int) (((double) i2) * sqrt);
            }
            ap = ap(str, i2, i);
            if (ap == null) {
                ap = com.tencent.mm.sdk.platformtools.c.a(str, i, i2, 0.0f, null, 0, new int[0]);
            }
            if (ap == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                ap = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.ImageGalleryHolderImage";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(ap == null);
                x.i(str2, str3, objArr);
            }
            decodeFile = ap;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e, "hy: out of memory! try use fallback bitmap", new Object[0]);
            decodeFile = c(str, i, i2, getScreenWidth(ad.getContext()), getScreenHeight(ad.getContext()));
        }
        if (decodeFile == null) {
            x.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = " + str);
            return null;
        }
        ap = com.tencent.mm.sdk.platformtools.c.b(decodeFile, (float) VX);
        if (ap != decodeFile || VX % 360 == 0) {
            return ap;
        }
        x.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", new Object[]{Integer.valueOf(VX)});
        return null;
    }

    private static Bitmap c(String str, int i, int i2, int i3, int i4) {
        x.e("MicroMsg.ImageGalleryHolderImage", "hy: enter fallback bitmap logic");
        x.i("MicroMsg.ImageGalleryHolderImage", "hy: oriImgPixelRate %d, displayPixelRate %d", new Object[]{Integer.valueOf(i * i2), Integer.valueOf(i3 * i4)});
        if (i * i2 > i3 * i4) {
            try {
                return com.tencent.mm.sdk.platformtools.c.a(str, i3, i4, 0.0f, null, 0, new int[0]);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", e, "hy: oom in fallback bitmap!", new Object[0]);
                return null;
            }
        }
        x.e("MicroMsg.ImageGalleryHolderImage", "hy: the picture is even smaller the screen! display nothing");
        return null;
    }

    private static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static String d(bd bdVar, e eVar) {
        return a(bdVar, eVar, false);
    }

    private static String a(bd bdVar, e eVar, boolean z) {
        String o;
        if (bdVar.field_isSend == 1) {
            o = o.Pf().o(o.Pf().d(eVar), "", "");
            if (com.tencent.mm.a.e.cn(o)) {
                return o;
            }
            o = o.Pf().o(eVar.dTL, "", "");
            if (com.tencent.mm.a.e.cn(o)) {
                return o;
            }
            return null;
        } else if (z || eVar.OM()) {
            String str = eVar.dTL;
            if (eVar.ON()) {
                o = o.Pf().d(eVar);
                if (o != null) {
                    o = o.Pf().o(o, "", "");
                    if (com.tencent.mm.a.e.cn(o)) {
                        x.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
                        if (o == null) {
                            o = o.Pf().o(str, "", "");
                        }
                        x.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[]{o});
                        return o;
                    }
                }
            }
            o = null;
            if (o == null) {
                o = o.Pf().o(str, "", "");
            }
            x.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[]{o});
            return o;
        } else {
            x.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(eVar.OM())});
            return null;
        }
    }

    private static String e(bd bdVar, e eVar) {
        if (bdVar == null || eVar == null) {
            return null;
        }
        String str;
        if (bdVar.field_isSend == 1) {
            str = o.Pf().o(eVar.dTN, "", "") + "hd";
            x.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[]{r2, str});
            if (bi.oW(str) || !com.tencent.mm.a.e.cn(str)) {
                return null;
            }
            x.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
            return str;
        } else if (eVar.OM()) {
            str = o.Pf().o(eVar.dTN, "", "") + "hd";
            x.i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[]{r2, str});
            if (bi.oW(str) || !com.tencent.mm.a.e.cn(str)) {
                return null;
            }
            x.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
            return str;
        } else {
            x.i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
            return null;
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, l lVar) {
        if (this.tTx != null && this.tTx.tTy != null && this.if == 0) {
            Integer num;
            if (k.cxA().gL(j2)) {
                int a = a(j2, obj);
                if (a != -1) {
                    num = new Integer(a);
                } else {
                    return;
                }
            }
            num = obj;
            if (num instanceof Integer) {
                int intValue = num.intValue();
                x.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j)});
                if (intValue == -1) {
                    x.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
                    return;
                } else if (this.tTx.Ep(intValue) != null) {
                    j jVar = (j) this.tTx.Ep(intValue).getTag();
                    if (jVar != null) {
                        int i5;
                        if (intValue == this.tTx.tTy.getCurrentItem() && !Fz(i)) {
                            this.tTx.tTy.fm(false);
                        }
                        if (i3 == 0) {
                            i5 = 0;
                        } else {
                            i5 = (int) (i4 != 0 ? ((((float) i3) / ((float) i4)) * 100.0f) - 1.0f : 0.0f);
                        }
                        int max = Math.max(1, i5);
                        if (intValue == this.tTx.tTy.getCurrentItem() && Fz(i)) {
                            x.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", new Object[]{Integer.valueOf(max), Long.valueOf(System.currentTimeMillis())});
                            this.tTx.tTy.FG(max);
                        }
                        k kVar = (k) lVar;
                        boolean isProgressive = MMNativeJpeg.isProgressive(kVar.dVn);
                        boolean z = kVar.dVp;
                        long bI = bi.bI(this.tUU);
                        a.dp(kVar.dVn, i4);
                        x.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isProgressive), Long.valueOf(bI), Integer.valueOf(i3), Integer.valueOf(i4), kVar.dVn});
                        if (z && isProgressive && bI > 1000) {
                            this.tUU = bi.VG();
                            bd ES = this.tTx.ES(intValue);
                            e h = h(ES, true);
                            if (a(false, jVar.tXm, o.Pf().E(ES.field_imgPath, true), a(ES, h, true), true, -1, ES, jVar, h, i, true)) {
                                j.O(jVar.tXg, 8);
                                j.O(jVar.tXj, 8);
                                if (intValue == this.tTx.tTy.getCurrentItem() && !Fz(i)) {
                                    if (max > 50) {
                                        j.O(jVar.tXi, 8);
                                        return;
                                    } else {
                                        j.O(jVar.tXi, 0);
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            x.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, l lVar) {
        if (this.tTx != null && this.tTx.tTy != null) {
            Integer num;
            if (k.cxA().gL(j2)) {
                int a = a(j2, obj);
                if (a == -1) {
                    au.HU();
                    a(com.tencent.mm.model.c.FT().dW(j2), "background", false);
                    return;
                }
                num = new Integer(a);
            } else {
                num = obj;
            }
            if (num instanceof Integer) {
                int intValue = num.intValue();
                x.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = " + intValue);
                if (intValue == -1) {
                    x.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
                    h.mEJ.a(111, 3, 1, true);
                    return;
                }
                j jVar = null;
                if (this.tTx.Ep(intValue) != null) {
                    jVar = (j) this.tTx.Ep(intValue).getTag();
                }
                boolean gL = k.cxA().gL(j2);
                if (i3 == 0 && i4 == 0) {
                    if (gL) {
                        a(this.tTx.ES(intValue), "hd_suc:" + intValue, intValue == this.tTx.tTy.getCurrentItem());
                    }
                    x.i("MicroMsg.ImageGalleryHolderImage", "pos = " + intValue + ", selectedPos = " + this.tTx.tTy.getCurrentItem(), new Object[0]);
                    j(j2, 4);
                    bd ES = this.tTx.ES(intValue);
                    e h = h(ES, true);
                    if (ES != null && h != null && jVar != null) {
                        this.tTx.tTy.fm(true);
                        if (intValue == this.tTx.tTy.getCurrentItem()) {
                            if (Fz(i)) {
                                ImageGalleryUI imageGalleryUI = this.tTx.tTy;
                                imageGalleryUI.fm(true);
                                imageGalleryUI.fm(true);
                                Animation FF = ImageGalleryUI.FF(1000);
                                FF.setAnimationListener(new ImageGalleryUI$10(imageGalleryUI));
                                imageGalleryUI.cxh();
                                imageGalleryUI.cwW().tVH.setVisibility(0);
                                imageGalleryUI.cwW().tVI.setVisibility(8);
                                imageGalleryUI.cwW().tVJ.setVisibility(8);
                                imageGalleryUI.cwW().tVK.setVisibility(0);
                                imageGalleryUI.cwW().tVK.startAnimation(FF);
                            } else {
                                jVar.tXm.post(new 2(this, intValue));
                            }
                        }
                        if (a(false, jVar.tXm, o.Pf().E(ES.field_imgPath, true), a(ES, h, true), true, -1, ES, jVar, h, i, false)) {
                            j.O(jVar.tXd, 8);
                            j.O(jVar.tXi, 8);
                            j.O(jVar.tXj, 8);
                            if (bu(ES) == 4 && this.tTx.tTC) {
                                this.tTx.bp(ES);
                                this.tTx.tTC = false;
                                return;
                            }
                            return;
                        }
                        x.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
                        h.mEJ.a(111, 2, 1, true);
                        return;
                    }
                    return;
                }
                if (gL) {
                    a(this.tTx.ES(intValue), "hd_failed:" + intValue, intValue == this.tTx.tTy.getCurrentItem());
                }
                if (intValue == this.tTx.tTy.getCurrentItem()) {
                    this.tTx.tTy.fm(true);
                }
                if (i4 == -5103059) {
                    j(j2, 5);
                    h.mEJ.a(111, 0, 1, true);
                } else {
                    j(j2, 6);
                    h.mEJ.a(111, 1, 1, true);
                }
                x.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + i3 + ", errCode = " + i4);
                this.tTx.tTD.Fm(intValue);
                return;
            }
            x.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        }
    }

    private int a(long j, Object obj) {
        int intValue;
        if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
            bd ES = this.tTx.ES(intValue);
            if (ES != null && ES.field_msgId == j) {
                return intValue;
            }
        }
        for (Integer intValue2 : this.tTx.tza.values()) {
            intValue = intValue2.intValue();
            bd ES2 = this.tTx.ES(intValue);
            if (ES2 != null && ES2.field_msgId == j) {
                return intValue;
            }
        }
        return -1;
    }

    private static void a(bd bdVar, String str, boolean z) {
        x.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", new Object[]{Long.valueOf(bdVar.field_msgId), str});
        b.b(ad.getContext(), bdVar, z);
    }

    private static boolean Fz(int i) {
        return i == 1;
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        if (obj instanceof Integer) {
            x.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos " + ((Integer) obj).intValue(), new Object[0]);
            return;
        }
        x.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
    }

    public final void ao(int i, boolean z) {
        x.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = " + i);
        bd ES = this.tTx.ES(i);
        if (ES == null || ES.field_msgId == 0) {
            x.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
        } else if (b.bg(ES)) {
            e h = h(ES, true);
            if (h == null || h.dTK == 0) {
                x.e("MicroMsg.ImageGalleryHolderImage", "viewHdImg fail, msgLocalId = " + (ES == null ? "null" : Long.valueOf(ES.field_msgId)) + ", imgLocalId = " + (h == null ? "null" : Long.valueOf(h.dTK)));
                return;
            }
            f(ES, 3);
            if (Fl(i) != null) {
                a(Fl(i), ES, h, true, false, i);
            }
            if (z) {
                k cxA = k.cxA();
                x.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", new Object[]{Long.valueOf(ES.field_msgId)});
                cxA.tXv.add(Long.valueOf(ES.field_msgId));
                o.Pg().a(h.dTK, ES.field_msgId, 1, Integer.valueOf(i), R.g.chat_img_template, cxA, 0);
                return;
            }
            o.Pg().a(h.dTK, ES.field_msgId, 1, Integer.valueOf(i), R.g.chat_img_template, this, 0);
        } else {
            x.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
        }
    }

    @TargetApi(11)
    private void b(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        if (this.tTx != null && this.tTx.tTy != null) {
            x.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", new Object[]{Integer.valueOf(multiTouchImageView.hashCode()), Integer.valueOf(bitmap.hashCode())});
            if (VERSION.SDK_INT == 20) {
                multiTouchImageView.setLayerType(1, null);
            } else {
                com.tencent.mm.sdk.platformtools.k.k((View) multiTouchImageView.getParent(), bitmap.getWidth(), bitmap.getHeight());
            }
            multiTouchImageView.setEnableHorLongBmpMode(false);
            multiTouchImageView.eT(bitmap.getWidth(), bitmap.getHeight());
            multiTouchImageView.setImageBitmap(null);
            multiTouchImageView.setImageBitmap(bitmap);
            multiTouchImageView.invalidate();
        }
    }

    public final Bitmap FA(int i) {
        if (this.tTx == null) {
            return null;
        }
        bd Fx = this.tTx.tTz.Fx(i);
        if (Fx == null) {
            return null;
        }
        String str = (String) this.tUS.get(Fx);
        if (str == null) {
            str = o.Pf().E(Fx.field_imgPath, true);
            this.tUS.put(Fx, str);
        }
        String str2 = str + "hd";
        if (com.tencent.mm.a.e.cn(str2)) {
            return aax(str2);
        }
        return aax(str);
    }
}
