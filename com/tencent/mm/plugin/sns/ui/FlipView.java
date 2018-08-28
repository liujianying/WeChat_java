package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Gallery;
import android.widget.LinearLayout;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b$b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.widget.a.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class FlipView extends LinearLayout implements OnTouchListener, b$b {
    private int bJr;
    private int bJs;
    Context context;
    private long dDj = 0;
    protected ag handler;
    private c iYS = new 5(this);
    protected int infoType = -1;
    private double nMJ = 0.0d;
    private double nMK = 0.0d;
    protected v nML;
    protected t$a nMM;
    protected int nMN;
    protected int nMO;
    private boolean nMP = false;
    private long nMQ = 0;
    private boolean nMR = false;
    private d nMS;
    private String nMT;
    private String nMU;
    private String nMV;
    private String nMW;
    private boolean nMX = false;
    private a nMY = new a(this);
    float nMZ = 0.0f;
    float nNa = 0.0f;
    boolean nNb = false;
    float nNc = 1.0f;
    private c nNd = new 6(this);

    public abstract boolean bBX();

    public abstract Gallery getGallery();

    public abstract int getPosition();

    public abstract long getSnsId();

    static /* synthetic */ void NL(String str) {
        qr qrVar = new qr();
        qrVar.cbg.bOh = 3;
        qrVar.cbg.bNH = str;
        a.sFg.m(qrVar);
    }

    static /* synthetic */ void NM(String str) {
        qr qrVar = new qr();
        qrVar.cbg.bOh = 1;
        qrVar.cbg.cbj = 2;
        qrVar.cbg.bNH = str;
        a.sFg.m(qrVar);
    }

    static /* synthetic */ void o(boolean z, String str) {
        qr qrVar = new qr();
        qrVar.cbg.bOh = 2;
        qrVar.cbg.cbh = 14;
        qrVar.cbg.cbi = z;
        qrVar.cbg.bNH = str;
        a.sFg.m(qrVar);
    }

    public FlipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FlipView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        this.handler = new ag();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nMN = displayMetrics.widthPixels;
        this.nMO = displayMetrics.heightPixels;
        a.sFg.b(this.iYS);
        a.sFg.b(this.nNd);
    }

    public void setNeedScanImage(boolean z) {
        this.nMR = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            x.d("MicroMsg.FlipView", "onTouchEvent down");
            this.nMJ = (double) motionEvent.getX();
            this.nMK = (double) motionEvent.getY();
            this.dDj = System.currentTimeMillis();
            if (f.L(motionEvent) == 1) {
                this.nMP = false;
            }
        }
        if (f.L(motionEvent) > 1) {
            this.nMP = true;
        }
        if (motionEvent.getAction() == 1 && !this.nMP) {
            x.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.dDj));
            long VG = bi.VG();
            x.d("MicroMsg.FlipView", "deltTime: " + (VG - this.nMQ));
            if (VG - this.nMQ < 300) {
                this.handler.removeCallbacks(this.nMY);
                this.handler.post(new 1(this));
                return super.dispatchTouchEvent(motionEvent);
            }
            this.nMQ = VG;
            if (System.currentTimeMillis() - this.dDj < 500 && Math.abs(((double) motionEvent.getX()) - this.nMJ) <= 10.0d && Math.abs(((double) motionEvent.getY()) - this.nMK) <= 10.0d && motionEvent.getY() > 110.0f && motionEvent.getY() < ((float) (this.nMO - 100))) {
                a aVar = this.nMY;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                aVar.x = x;
                aVar.y = y;
                this.handler.postDelayed(this.nMY, 10);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return !f.crf() ? false : false;
    }

    public final void LR(String str) {
    }

    public void aS(String str, boolean z) {
    }

    public final void bxb() {
    }

    public void aT(String str, boolean z) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    protected final void f(String str, String str2, String str3, boolean z) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        n Nl = af.byo().Nl(str2);
        if (Nl == null) {
            x.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
            return;
        }
        if (Nl.field_type != 21) {
            arrayList.add(this.context.getString(j.sns_post_to));
            arrayList2.add(Integer.valueOf(1));
            if (com.tencent.mm.bg.d.QS("favorite")) {
                arrayList.add(this.context.getString(j.plugin_favorite_opt));
                arrayList2.add(Integer.valueOf(2));
            }
            if (Nl.field_type == 15 || Nl.field_type == 5) {
                arrayList.add(this.context.getString(j.save_video_to_local));
                arrayList2.add(Integer.valueOf(0));
            } else if (Nl.field_type == 1) {
                arrayList.add(this.context.getString(j.save_img_to_local));
                arrayList2.add(Integer.valueOf(0));
            } else {
                arrayList.add(this.context.getString(j.sns_save_to_sns));
                arrayList2.add(Integer.valueOf(0));
            }
            dj djVar = new dj();
            djVar.bLf.bKW = str2;
            a.sFg.m(djVar);
            if (djVar.bLg.bKE) {
                arrayList.add(this.context.getString(j.app_open));
                arrayList2.add(Integer.valueOf(5));
            }
            if (!v.ND(str2) && Nl.field_type == 1) {
                arrayList.add(this.context.getString(j.chatting_image_long_click_photo_edit));
                arrayList2.add(Integer.valueOf(6));
            }
            if (this.nMW != null) {
                arrayList.add(com.tencent.mm.plugin.scanner.a.aB(this.bJr, this.nMW) ? this.context.getString(j.sns_scan_wxcode_image) : this.context.getString(j.sns_scan_image));
                arrayList2.add(Integer.valueOf(4));
            }
        } else if (!Nl.field_userName.equals(q.GF())) {
            arrayList.add(this.context.getString(j.sns_expose_sns));
            arrayList2.add(Integer.valueOf(3));
        }
        if (this.nMS == null || !this.nMX) {
            this.nMS = new d(this.context, 1, false);
        } else {
            this.nMX = false;
        }
        this.nMS.ofp = new 2(this, arrayList, arrayList2);
        this.nMS.uJQ = new d.a() {
            public final void onDismiss() {
                ak akVar = new ak();
                akVar.bHM.filePath = FlipView.this.nMT;
                a.sFg.m(akVar);
                FlipView.this.nMS = null;
                FlipView.this.nMT = null;
                FlipView.this.nMU = "";
                FlipView.this.nMV = null;
                FlipView.this.nMW = null;
                FlipView.this.bJr = FlipView.this.bJs = 0;
            }
        };
        this.nMS.ofq = new 4(this, str2, str, str3);
        this.nMS.bXO();
        if (this.nMR && true == z) {
            g.Ek();
            if (g.Eh().dpP.Lg() != 0) {
                this.nMT = str;
                this.nMU = str2;
                this.nMV = str3;
                ms msVar = new ms();
                msVar.bXH.filePath = str;
                a.sFg.m(msVar);
            }
        }
    }

    public static String g(String str, Context context) {
        Throwable e;
        Throwable th;
        int i = 1;
        if (str == null || str.equals("")) {
            return null;
        }
        String str2 = e.dgl + String.format("%s%d.%s", new Object[]{"image", Integer.valueOf(str.hashCode()), "jpg"});
        String absolutePath = new File(ad.getContext().getCacheDir(), "tmp" + System.currentTimeMillis()).getAbsolutePath();
        if (FileOp.y(str, absolutePath) < 0) {
            return null;
        }
        if (MMNativeJpeg.isProgressive(absolutePath)) {
            FileOutputStream fileOutputStream;
            try {
                Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(absolutePath);
                if (decodeAsBitmap != null) {
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        decodeAsBitmap.compress(compressFormat, 80, fileOutputStream);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            x.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e3) {
                                }
                            }
                            FileOp.deleteFile(absolutePath);
                            i = 0;
                            if (i != 0) {
                            }
                            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                            return str2;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            FileOp.deleteFile(absolutePath);
                            throw th;
                        }
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        x.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        FileOp.deleteFile(absolutePath);
                        i = 0;
                        if (i != 0) {
                        }
                        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                        return str2;
                    }
                }
                fileOutputStream = null;
                i = 0;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e7) {
                    }
                }
                FileOp.deleteFile(absolutePath);
            } catch (FileNotFoundException e8) {
                e = e8;
                fileOutputStream = null;
                x.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e32) {
                    }
                }
                FileOp.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                return str2;
            } catch (OutOfMemoryError e9) {
                e = e9;
                fileOutputStream = null;
                x.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e62) {
                    }
                }
                FileOp.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                return str2;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e42) {
                    }
                }
                FileOp.deleteFile(absolutePath);
                throw th;
            }
        }
        i = 0;
        if (i != 0 && FileOp.y(str, str2) < 0) {
            return null;
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
        return str2;
    }

    protected void onPause() {
        this.nMT = null;
        this.nMU = "";
        this.nMV = null;
        if (this.nMW != null) {
            aj ajVar = new aj();
            ajVar.bHK.activity = (Activity) this.context;
            ajVar.bHK.bHL = this.nMW;
            a.sFg.m(ajVar);
            this.nMW = null;
            this.bJs = 0;
            this.bJr = 0;
        }
    }

    protected final void onDestroy() {
        a.sFg.c(this.iYS);
        a.sFg.c(this.nNd);
    }

    public ate getCntMedia() {
        return null;
    }

    public final void NK(String str) {
        if (FileOp.cn(str)) {
            Intent intent = new Intent();
            x.i("MicroMsg.FlipView", "edit image path:%s", new Object[]{str});
            intent.putExtra("before_photo_edit", str);
            intent.putExtra("from_scene", 293);
            intent.putExtra("after_photo_edit", "");
            intent.putExtra("Retr_Compress_Type", 0);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_FromMainTimeline", bBX());
            intent.setClass(this.context, MMNewPhotoEditUI.class);
            this.context.startActivity(intent);
        }
    }
}
