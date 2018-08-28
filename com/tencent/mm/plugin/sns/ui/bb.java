package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.aw.a;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.ui.bc.1;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class bb implements a, b {
    private static int ofZ = 0;
    private static int oga = 1;
    private static int ogb = 2;
    private String eWQ;
    protected String filePath;
    protected View gFD;
    private String gtX;
    int iGo = 0;
    protected View iZk;
    protected ListView kww;
    private int lastIndex;
    protected MMPullDownView lbd;
    private Activity mActivity;
    private boolean nNG;
    public int nig = 0;
    private boolean nld = false;
    protected SnsHeader nvg;
    private String ocI;
    private boolean ocJ;
    private int ocK;
    protected LoadingMoreView ofR;
    private int ofS = 0;
    private boolean ofT = false;
    protected boolean ofU = false;
    public int ofV = 0;
    a ofW;
    View ofX;
    private LayoutParams ofY;
    private int ogc;
    int ogd = 0;
    int oge = 0;
    int ogf = ofZ;
    int ogg = ofZ;
    int ogh = 0;
    boolean ogi = false;
    private String ogj;
    com.tencent.mm.modelsns.b ogk = null;
    int start = 0;
    protected p tipDialog = null;
    protected String title;

    static /* synthetic */ void e(bb bbVar) {
        View inflate = LayoutInflater.from(bbVar.mActivity).inflate(g.sns_op_toast, (ViewGroup) bbVar.mActivity.findViewById(f.sns_op_toast));
        s sVar = new s(bbVar.mActivity);
        sVar.setGravity(48, 0, BackwardSupportUtil.b.b(bbVar.mActivity, 200.0f));
        sVar.duration = 1000;
        sVar.setView(inflate);
        sVar.cancel();
        sVar.bAZ.SO();
        sVar.hFO = ((int) (sVar.duration / 70)) + 1;
        sVar.bAZ.J(70, 70);
    }

    public bb(Activity activity) {
        this.mActivity = activity;
    }

    public final void onCreate() {
        this.nig = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
        af.byl().start();
        if (this.ofX != null) {
            this.ofY = (LayoutParams) this.ofX.getLayoutParams();
        }
        this.kww = this.ofW.bDZ();
        this.kww.post(new 1(this));
        x.i("MicroMsg.SnsActivity", "list is null ? " + (this.kww != null));
        this.kww.setScrollingCacheEnabled(false);
        this.nvg = new SnsHeader(this.mActivity);
        this.nvg.setBackClickListener(new 7(this));
        this.iZk = this.ofW.bEa();
        this.gFD = this.ofW.bEb();
        this.nvg.setHeadBgListener(new 8(this));
        this.ofR = new LoadingMoreView(this.mActivity);
        this.kww.addHeaderView(this.nvg);
        this.kww.addFooterView(this.ofR);
        this.kww.setOnScrollListener(new 9(this));
        this.lbd = this.ofW.bEc();
        x.i("MicroMsg.SnsActivity", "pullDownView is null ? " + (this.lbd != null));
        this.lbd.setOnTopLoadDataListener(new 10(this));
        this.lbd.setTopViewVisible(false);
        this.lbd.setIsTopShowAll(false);
        this.lbd.setAtBottomCallBack(new 11(this));
        this.lbd.setAtTopCallBack(new 12(this));
        this.lbd.setIsBottomShowAll(false);
        this.lbd.setOnBottomLoadDataListener(new 13(this));
        this.lbd.setShowBackground(true);
        this.lbd.setBgColor("#f4f4f4");
        this.title = this.mActivity.getIntent().getStringExtra("sns_title");
        SnsHeader snsHeader = this.nvg;
        Object obj = bi.oW(this.gtX) ? this.ocI : this.gtX;
        String str = this.ocI;
        CharSequence charSequence = this.eWQ;
        CharSequence charSequence2 = this.ogj;
        if (obj == null || str == null) {
            x.e("MicroMsg.SnsHeader", "userName or selfName is null ");
        } else {
            snsHeader.userName = obj.trim();
            snsHeader.cXR = str.trim();
            snsHeader.bNu = str.equals(obj);
            x.d("MicroMsg.SnsHeader", "userNamelen " + obj.length() + "  " + obj);
            snsHeader.nWh.haS.setText(obj);
            if (!(snsHeader.nWh == null || snsHeader.nWh.eBM == null)) {
                com.tencent.mm.pluginsdk.ui.a.b.p(snsHeader.nWh.eBM, snsHeader.userName);
            }
            if (obj != null && obj.length() > 0) {
                snsHeader.nWh.haS.setText(j.a(snsHeader.context, i.y(charSequence)));
                snsHeader.nWh.nLj.setText(j.a(snsHeader.context, charSequence2, snsHeader.nWh.nLj.getTextSize()));
            }
            snsHeader.nWh.eBM.setContentDescription(snsHeader.context.getString(com.tencent.mm.plugin.sns.i.j.sns_avatar_desc, new Object[]{snsHeader.nWh.haS.getText()}));
        }
        this.nvg.setType(this.ofW.getType());
        this.nvg.bDn();
        if (VERSION.SDK_INT < 11) {
            x.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
        } else {
            new 6(this).run();
        }
        af.byk().dba.add(this);
        aw.nmz++;
        af.byj().a(this);
    }

    public final void it(boolean z) {
        this.ofW.it(z);
    }

    public final void a(String str, String str2, String str3, String str4, boolean z, boolean z2, int i) {
        this.ocI = str;
        this.gtX = str2;
        this.eWQ = str3;
        this.ogj = str4;
        this.ocJ = z;
        this.nNG = z2;
        this.ocK = i;
    }

    public static void onResume() {
        af.byj().N(2, false);
        com.tencent.mm.pluginsdk.wallet.i.Cx(7);
        com.tencent.mm.sdk.b.b lnVar = new ln();
        lnVar.bVQ.bVR = true;
        com.tencent.mm.sdk.b.a.sFg.a(lnVar, Looper.getMainLooper());
        x.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
    }

    public static void onPause() {
        com.tencent.mm.sdk.b.b lnVar = new ln();
        lnVar.bVQ.bVR = false;
        com.tencent.mm.sdk.b.a.sFg.a(lnVar, Looper.getMainLooper());
        x.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsActivity", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            int a;
            switch (i) {
                case 2:
                    if (intent != null) {
                        com.tencent.mm.kernel.g.Ek();
                        a = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68393, null), 0);
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().DT().set(68393, Integer.valueOf(a + 1));
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 4);
                        intent2.putExtra("CropImage_Filter", true);
                        intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                        com.tencent.mm.plugin.sns.c.a.ezn.a(this.mActivity, intent, intent2, af.getAccSnsTmpPath(), 4, new 2(this));
                        return;
                    }
                    return;
                case 4:
                    if (intent != null) {
                        this.filePath = intent.getStringExtra("CropImage_OutputPath");
                        Z(intent);
                        return;
                    }
                    return;
                case 5:
                    this.filePath = l.d(this.mActivity.getApplicationContext(), intent, af.getAccSnsTmpPath());
                    x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_TAKE_PHOTO  filePath" + this.filePath);
                    if (this.filePath != null) {
                        com.tencent.mm.kernel.g.Ek();
                        a = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68392, null), 0);
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().DT().set(68392, Integer.valueOf(a + 1));
                        this.nld = true;
                        Z(intent);
                        return;
                    }
                    return;
                case 6:
                    x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_UPLOAD_MEDIA");
                    if (intent != null) {
                        this.ofW.a(intent.getIntExtra("sns_local_id", -1), null, null);
                        af.byk().bwX();
                        return;
                    }
                    return;
                case 7:
                    x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHANGE_BG");
                    this.nvg.bDn();
                    af.byk().bwX();
                    return;
                case 8:
                    if (intent != null) {
                        x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_GALLERY_OP");
                        SnsCmdList snsCmdList = (SnsCmdList) intent.getParcelableExtra("sns_cmd_list");
                        if (snsCmdList != null) {
                            this.ofW.a(-1, snsCmdList.nkN, snsCmdList.nkO);
                            return;
                        }
                        return;
                    }
                    return;
                case 9:
                    af.byk().bwX();
                    c.a(this.kww);
                    return;
                case 10:
                    if (intent != null && i2 == -1) {
                        Cursor managedQuery = this.mActivity.managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            this.mActivity.startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                            return;
                        }
                        return;
                    }
                    return;
                case 12:
                    a = intent.getIntExtra("sns_gallery_op_id", -1);
                    if (a > 0) {
                        x.d("MicroMsg.SnsActivity", "notify cause by del item");
                        SnsCmdList snsCmdList2 = new SnsCmdList();
                        snsCmdList2.wj(a);
                        this.ofW.a(-1, snsCmdList2.nkN, snsCmdList2.nkO);
                        return;
                    }
                    return;
                case 13:
                    af.byt().axe();
                    return;
                case 14:
                    new ag(Looper.getMainLooper()).post(new 3(this));
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                    if ((stringArrayListExtra == null || stringArrayListExtra.size() <= 0) && bi.oW(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
                        Serializable stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                            x.i("MicroMsg.SnsActivity", "no image selected");
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        Iterator it = stringArrayListExtra2.iterator();
                        while (it.hasNext()) {
                            if (Exif.fromFile((String) it.next()).getLocation() != null) {
                                arrayList.add(String.format("%s\n%f\n%f", new Object[]{(String) it.next(), Double.valueOf(Exif.fromFile((String) it.next()).getLocation().latitude), Double.valueOf(Exif.fromFile((String) it.next()).getLocation().longitude)}));
                            }
                        }
                        this.nld = intent.getBooleanExtra("isTakePhoto", false);
                        Intent intent3 = new Intent(this.mActivity, SnsUploadUI.class);
                        intent3.putExtra("KSnsPostManu", true);
                        intent3.putExtra("KTouchCameraTime", bi.VE());
                        if (this.ogk != null) {
                            this.ogk.b(intent3, "intent_key_StatisticsOplog");
                            this.ogk = null;
                        }
                        if (this.nNG) {
                            intent3.putExtra("Ksnsupload_source", 11);
                        }
                        int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                        intent3.putExtra("sns_kemdia_path_list", stringArrayListExtra2);
                        intent3.putExtra("KFilterId", intExtra);
                        if (this.nld) {
                            intent3.putExtra("Kis_take_photo", true);
                        }
                        intent3.putStringArrayListExtra("sns_media_latlong_list", arrayList);
                        x.d("MicroMsg.SnsActivity", "shared type %d", Integer.valueOf(intent3.getIntExtra("Ksnsupload_type", -1)));
                        this.mActivity.startActivityForResult(intent3, 6);
                        return;
                    }
                    String stringExtra;
                    if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                        stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                    } else {
                        stringExtra = (String) stringArrayListExtra.get(0);
                    }
                    String stringExtra2 = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                    if (bi.oW(stringExtra2) || !FileOp.cn(stringExtra2)) {
                        stringExtra2 = af.getAccSnsTmpPath() + com.tencent.mm.a.g.cu(stringExtra);
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(stringExtra);
                            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
                            if (frameAtTime == null) {
                                x.e("MicroMsg.SnsActivity", "get bitmap error");
                                try {
                                    mediaMetadataRetriever.release();
                                    return;
                                } catch (Exception e) {
                                    return;
                                }
                            }
                            x.i("MicroMsg.SnsActivity", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                            com.tencent.mm.sdk.platformtools.c.a(frameAtTime, 80, CompressFormat.JPEG, stringExtra2, true);
                            Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(stringExtra2);
                            x.i("MicroMsg.SnsActivity", "getBitmap2 %d %d", Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight));
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e2) {
                            }
                        } catch (Exception e3) {
                            x.e("MicroMsg.SnsActivity", "savebitmap error %s", e3.getMessage());
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e4) {
                            }
                        } catch (Throwable th) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e5) {
                            }
                            throw th;
                        }
                    }
                    x.i("MicroMsg.SnsActivity", "video path %s thumb path %s and %s %s ", stringExtra, stringExtra2, Long.valueOf(FileOp.mI(stringExtra)), Long.valueOf(FileOp.mI(stringExtra2)));
                    Intent intent4 = new Intent();
                    intent4.putExtra("KSightPath", stringExtra);
                    intent4.putExtra("KSightThumbPath", stringExtra2);
                    intent4.putExtra("sight_md5", com.tencent.mm.a.g.cu(stringExtra));
                    intent4.putExtra("KSnsPostManu", true);
                    intent4.putExtra("KTouchCameraTime", bi.VE());
                    intent4.putExtra("Ksnsupload_type", 14);
                    intent4.putExtra("Kis_take_photo", false);
                    d.b(this.mActivity, "sns", ".ui.SnsUploadUI", intent4);
                    return;
                case 15:
                    return;
                case 17:
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        return;
                    }
                    if (sightCaptureResult.lec) {
                        this.filePath = sightCaptureResult.lek;
                        if (!bi.oW(this.filePath)) {
                            this.nld = true;
                            Z(intent);
                            return;
                        }
                        return;
                    }
                    x.i("MicroMsg.SnsActivity", "video path %s thumb path ", sightCaptureResult.lee, sightCaptureResult.lef);
                    Intent intent5 = new Intent();
                    intent5.putExtra("KSightPath", sightCaptureResult.lee);
                    intent5.putExtra("KSightThumbPath", sightCaptureResult.lef);
                    if (bi.oW(sightCaptureResult.leh)) {
                        intent5.putExtra("sight_md5", com.tencent.mm.a.g.cu(sightCaptureResult.lee));
                    } else {
                        intent5.putExtra("sight_md5", sightCaptureResult.leh);
                    }
                    intent5.putExtra("KSnsPostManu", true);
                    intent5.putExtra("KTouchCameraTime", bi.VE());
                    intent5.putExtra("Ksnsupload_type", 14);
                    intent5.putExtra("Kis_take_photo", false);
                    intent5.putExtra("KSessionID", intent.getStringExtra("KSessionID"));
                    try {
                        byte[] toByteArray = sightCaptureResult.lej.toByteArray();
                        if (toByteArray != null) {
                            intent5.putExtra("KMMSightExtInfo", toByteArray);
                        }
                    } catch (Exception e6) {
                        x.i("MicroMsg.SnsActivity", "put sight extinfo to snsuploadui error: %s", e6.getMessage());
                    }
                    d.b(this.mActivity, "sns", ".ui.SnsUploadUI", intent5);
                    return;
                default:
                    x.e("MicroMsg.SnsActivity", "onActivityResult: not found this requestCode");
                    return;
            }
        } else if (i == 5 || i == 2 || i == 4) {
            new ag(Looper.getMainLooper()).post(new 14(this));
        }
    }

    private void Z(Intent intent) {
        new ag(Looper.getMainLooper()).post(new 4(this));
        x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
        x.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
        if (this.filePath != null) {
            int intExtra;
            String str = "pre_temp_sns_pic" + com.tencent.mm.a.g.u((this.filePath + System.currentTimeMillis()).getBytes());
            com.tencent.mm.plugin.sns.storage.s.ad(af.getAccSnsTmpPath(), this.filePath, str);
            this.filePath = af.getAccSnsTmpPath() + str;
            x.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
            if (intent != null) {
                intExtra = intent.getIntExtra("CropImage_filterId", 0);
            } else {
                intExtra = 0;
            }
            Intent intent2 = new Intent(this.mActivity, SnsUploadUI.class);
            intent2.putExtra("KSnsPostManu", true);
            intent2.putExtra("KTouchCameraTime", bi.VE());
            if (this.ogk != null) {
                this.ogk.b(intent2, "intent_key_StatisticsOplog");
                this.ogk = null;
            }
            intent2.putExtra("sns_kemdia_path", this.filePath);
            intent2.putExtra("KFilterId", intExtra);
            if (this.nld) {
                intent2.putExtra("Kis_take_photo", true);
            }
            if (this.nNG) {
                intent2.putExtra("Ksnsupload_source", 11);
            }
            this.mActivity.startActivityForResult(intent2, 6);
            this.nld = false;
        }
    }

    protected final boolean xE(int i) {
        int i2 = 3;
        com.tencent.mm.kernel.g.Ek();
        if (com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
            x.d("MicroMsg.SnsActivity", "selectPhoto " + i);
            if (i == 2) {
                Intent intent = new Intent();
                intent.putExtra("username", this.ocI);
                intent.setClass(this.mActivity, SettingSnsBackgroundUI.class);
                this.mActivity.startActivityForResult(intent, 7);
                return true;
            } else if (i != 1) {
                return true;
            } else {
                com.tencent.mm.kernel.g.Ek();
                int a = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68385, null), 0);
                com.tencent.mm.kernel.g.Ek();
                int a2 = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(68386, null), 0);
                if (!this.ofT && a < 3 && a2 == 0) {
                    this.ofT = true;
                    Context context = this.mActivity;
                    5 5 = new 5(this, i);
                    com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
                    aVar.Gq(com.tencent.mm.plugin.sns.i.j.sns_welcome_tip);
                    aVar.abu(context.getString(com.tencent.mm.plugin.sns.i.j.sns_welcome_titlea) + "\n\n" + context.getString(com.tencent.mm.plugin.sns.i.j.sns_welcome_titlec));
                    aVar.Gt(com.tencent.mm.plugin.sns.i.j.welcome_i_know).a(5);
                    aVar.a(new 1());
                    aVar.anj().show();
                    return true;
                } else if (this.mActivity.getSharedPreferences(ad.chY(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
                    l.a(this.mActivity, 2, null);
                    return true;
                } else {
                    a2 = com.tencent.mm.k.g.AT().getInt("SnsCanPickVideoFromAlbum", 1);
                    x.i("MicroMsg.SnsActivity", "takeVideo %d", Integer.valueOf(a2));
                    if (com.tencent.mm.platformtools.af.eyg) {
                        a2 = 0;
                    }
                    if (a2 != 1 && a2 == 0) {
                        i2 = 1;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.d.NP().NS().duration);
                    l.a(this.mActivity, 14, 9, 4, i2, false, intent2);
                    return true;
                }
            }
        }
        s.gH(this.mActivity);
        return false;
    }

    public final void onDestroy() {
        if (this.nvg != null) {
            SnsHeader snsHeader = this.nvg;
            if (!(snsHeader.nWn == null || snsHeader.nWn.isRecycled())) {
                snsHeader.nWn.recycle();
            }
        }
        com.tencent.mm.kernel.g.Ek();
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            af.byl().H(this.mActivity);
            af.byj().b(this);
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        com.tencent.mm.kernel.g.Ek();
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            af.byk().dba.remove(this);
            aw.nmz--;
        }
        this.ofR.setVisibility(8);
        ab.bCj();
        com.tencent.mm.kernel.g.Ek();
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            af.byl().start();
        }
        this.kww.setAdapter(null);
    }

    public final void LR(String str) {
    }

    public final void aT(String str, boolean z) {
    }

    public final void bxb() {
        this.nvg.bDn();
    }

    protected final void im(boolean z) {
        x.d("MicroMsg.SnsActivity", "snsactivty onIsAll ");
        this.ofR.im(z);
    }

    protected final void xk(int i) {
        x.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
        this.ofR.xk(i);
    }

    public final void Q(int i, boolean z) {
        this.ofW.Q(i, z);
    }

    public final void byX() {
        if (this.nvg != null) {
            this.nvg.bDn();
        }
    }

    public final void aS(String str, boolean z) {
        if (this.ofW.getType() == 1 && this.kww != null && this.kww.getAdapter() != null && (this.kww.getAdapter() instanceof ax)) {
            ((ax) this.kww.getAdapter()).notifyDataSetChanged();
        }
    }

    public final ListView bDZ() {
        return this.ofW.bDZ();
    }
}
