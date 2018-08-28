package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.al.b;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ata;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.ArrayList;
import java.util.List;

public class MassSendMsgUI extends MMActivity implements e {
    private static String lbi = "";
    private String filePath;
    private TextView kxe;
    private ChatFooter laA;
    private String laC;
    private List<String> laD;
    private boolean laE = false;
    private TextView lbh;
    private c lbj;
    private b lbk;
    private a lbl = new 9(this);
    private p tipDialog = null;

    static /* synthetic */ void d(MassSendMsgUI massSendMsgUI) {
        x.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")), bi.cjd(), massSendMsgUI});
        if (com.tencent.mm.pluginsdk.permission.a.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")) {
            x.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")), bi.cjd(), massSendMsgUI});
            if (com.tencent.mm.pluginsdk.permission.a.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")) {
                h.mEJ.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                l.c(massSendMsgUI, new Intent(), massSendMsgUI.laC);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(193, this);
        this.laE = getIntent().getBooleanExtra("mass_send_again", false);
        this.laC = getIntent().getStringExtra("mass_send_contact_list");
        String str = this.laC;
        this.laD = new ArrayList();
        if (!(str == null || str.equals(""))) {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                this.laD = bi.F(split);
            }
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.laA != null) {
            this.laA.setLastText(lbi);
            this.laA.a(this.mController.tml, this);
        }
    }

    public static void Go(String str) {
        lbi = str;
    }

    protected void onDestroy() {
        au.DF().b(193, this);
        super.onDestroy();
        if (this.laA != null) {
            this.laA.destroy();
        }
    }

    protected void onPause() {
        this.laA.aMo();
        this.laA.onPause();
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.mass_send_msg;
    }

    protected final void initView() {
        CharSequence spannableString;
        boolean z = false;
        setMMTitle(R.l.mass_send_msg);
        this.lbh = (TextView) findViewById(R.h.mass_send_msg_contact_list);
        this.kxe = (TextView) findViewById(R.h.mass_send_msg_contact_count);
        TextView textView = this.lbh;
        int textSize = (int) this.lbh.getTextSize();
        if (this.laD == null) {
            spannableString = new SpannableString("");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.laD.size(); i++) {
                String gT = r.gT((String) this.laD.get(i));
                if (i == this.laD.size() - 1) {
                    stringBuilder.append(gT);
                } else {
                    stringBuilder.append(gT + ",  ");
                }
            }
            spannableString = j.a(this, stringBuilder.toString(), textSize);
        }
        textView.setText(spannableString);
        this.kxe.setText(getResources().getQuantityString(R.j.mass_send_count, this.laD.size(), new Object[]{Integer.valueOf(this.laD.size())}));
        this.laA = (ChatFooter) findViewById(R.h.nav_footer);
        ((MassSendLayout) findViewById(R.h.mass_send_root_layout)).setPanel(this.laA.getPanel());
        this.laA.setCattingRootLayoutId(R.h.mass_send_root_layout);
        this.lbk = new b(this, this.laA, this.laC, this.laD, this.laE);
        this.laA.setFooterEventListener(this.lbk);
        this.laA.setSmileyPanelCallback(new d(this));
        ChatFooter chatFooter = this.laA;
        au.HU();
        int intValue = ((Integer) com.tencent.mm.model.c.DT().get(18, Integer.valueOf(-1))).intValue();
        if (intValue == -1) {
            intValue = 1;
        }
        chatFooter.setMode(intValue);
        this.laA.setUserName("masssendapp");
        this.laA.qLk.refresh();
        au.HU();
        if (((Boolean) com.tencent.mm.model.c.DT().get(66832, Boolean.valueOf(false))).booleanValue()) {
            this.laA.ceF();
            this.laA.ceB();
        }
        this.laA.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String valueOf = String.valueOf(charSequence);
                String substring = valueOf.substring(i, i + i3);
                if ((MassSendMsgUI.this.lbj == null || !MassSendMsgUI.this.lbj.isShowing()) && o.Wd(substring)) {
                    Bitmap e = com.tencent.mm.sdk.platformtools.c.e(substring, 300, 300, false);
                    if (e == null) {
                        x.e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
                        return;
                    }
                    View imageView = new ImageView(MassSendMsgUI.this);
                    imageView.setImageBitmap(e);
                    int dimensionPixelSize = MassSendMsgUI.this.getResources().getDimensionPixelSize(R.f.LargePadding);
                    imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    MassSendMsgUI.this.lbj = com.tencent.mm.ui.base.h.a(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.chatting_send_img_confirm), imageView, MassSendMsgUI.this.getString(R.l.app_ok), MassSendMsgUI.this.getString(R.l.app_cancel), new 1(this, substring), null);
                    String str = valueOf.substring(0, i) + valueOf.substring(i + i3);
                    MassSendMsgUI.this.laA.o(str, -1, false);
                    MassSendMsgUI.lbi = str;
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.laA.ceA();
        this.laA.cet();
        this.laA.cez();
        this.laA.S(true, true);
        this.laA.cey();
        this.laA.kP(true);
        this.laA.setAppPanelListener(this.lbl);
        ChatFooter chatFooter2 = this.laA;
        d.cfH();
        if (b.Pz() || (q.GQ() & 33554432) != 0) {
            z = true;
        }
        chatFooter2.kQ(z);
        this.laA.cev();
        this.laA.ceE();
        setBackBtn(new 1(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0 || !this.laA.ceI()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.laA.setBottomPanelVisibility(8);
        return true;
    }

    private void auu() {
        if (!l.c(this, com.tencent.mm.compatible.util.e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(R.l.selectcameraapp_none), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.MassSendMsgUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    auu();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 10(this), null);
                    return;
                }
            default:
                return;
        }
    }

    private void R(Intent intent) {
        String stringExtra = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.laj = this.laC;
        aVar.lak = this.laD.size();
        aVar.filename = stringExtra;
        aVar.lal = intExtra;
        aVar.msgType = 43;
        f fVar = new f(aVar, this.laE);
        au.DF().a(fVar, 0);
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(R.l.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(R.l.sendrequest_sending), true, new 11(this, fVar));
    }

    private void S(Intent intent) {
        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
        if (stringExtra != null) {
            int i = q.a(stringExtra, null, intent.getBooleanExtra("CropImage_Compress_Img", true)) ? 1 : 0;
            com.tencent.mm.plugin.masssend.a.h.bco();
            com.tencent.mm.plugin.masssend.a.a i2 = com.tencent.mm.plugin.masssend.a.b.i(stringExtra, this.laC, this.laD.size(), i);
            if (i2 != null) {
                f fVar = new f(i2, this.laE, i);
                au.DF().a(fVar, 0);
                ActionBarActivity actionBarActivity = this.mController.tml;
                getString(R.l.app_tip);
                this.tipDialog = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(R.l.sendrequest_sending), true, new 12(this, fVar));
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("is_video", false)) {
                        String stringExtra = intent.getStringExtra("video_full_path");
                        Intent intent2 = new Intent();
                        intent2.setData(Uri.parse("file://" + stringExtra));
                        T(intent2);
                        return;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 4);
                    intent3.putExtra("CropImage_Filter", true);
                    m mVar = com.tencent.mm.plugin.masssend.a.ezn;
                    au.HU();
                    mVar.a(this, intent, intent3, com.tencent.mm.model.c.Gb(), 4, null);
                    return;
                case 2:
                    Context applicationContext = getApplicationContext();
                    au.HU();
                    this.filePath = l.d(applicationContext, intent, com.tencent.mm.model.c.Gb());
                    if (this.filePath != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("CropImageMode", 4);
                        intent4.putExtra("CropImage_Filter", true);
                        intent4.putExtra("CropImage_ImgPath", this.filePath);
                        com.tencent.mm.plugin.masssend.a.ezn.a(this.mController.tml, intent4, 4);
                        return;
                    }
                    return;
                case 4:
                    S(intent);
                    return;
                case 5:
                    R(intent);
                    return;
                case 6:
                    T(intent);
                    return;
                case 7:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("from_record", false)) {
                        R(intent);
                        return;
                    } else {
                        T(intent);
                        return;
                    }
                case 8:
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        return;
                    }
                    String str;
                    if (sightCaptureResult.lec) {
                        str = sightCaptureResult.lek;
                        if (!bi.oW(str)) {
                            try {
                                boolean z = sightCaptureResult.led;
                                x.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", new Object[]{str});
                                com.tencent.mm.plugin.masssend.a.h.bco();
                                com.tencent.mm.plugin.masssend.a.a i3 = com.tencent.mm.plugin.masssend.a.b.i(str, this.laC, this.laD.size(), 0);
                                if (i3 != null) {
                                    f fVar = new f(i3, this.laE, 0);
                                    au.DF().a(fVar, 0);
                                    ActionBarActivity actionBarActivity = this.mController.tml;
                                    getString(R.l.app_tip);
                                    this.tipDialog = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(R.l.sendrequest_sending), true, new 13(this, fVar));
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                x.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", new Object[]{e.getMessage()});
                                return;
                            }
                        }
                        return;
                    }
                    x.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", new Object[]{sightCaptureResult.lee, sightCaptureResult.lef});
                    com.tencent.mm.modelvideo.o.Ta();
                    str = s.nK(sightCaptureResult.leg);
                    if (!sightCaptureResult.lee.equals(str)) {
                        x.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", new Object[]{sightCaptureResult.lee, str});
                        FileOp.av(sightCaptureResult.lee, str);
                    }
                    str = sightCaptureResult.leg;
                    int i4 = sightCaptureResult.lei;
                    com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
                    getString(R.l.app_tip);
                    this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new 14(this, cVar));
                    com.tencent.mm.sdk.f.e.post(new 15(this, str, i4), "MassSend_Remux");
                    return;
                default:
                    x.e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
                    return;
            }
        }
    }

    private void T(Intent intent) {
        if (ab.bU(this)) {
            U(intent);
        } else {
            com.tencent.mm.ui.base.h.a(this, R.l.video_export_file_warning, R.l.app_tip, new 2(this, intent), new 3(this));
        }
    }

    private void U(Intent intent) {
        com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
        getString(R.l.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new 4(this, cVar));
        cVar.a(this, intent, new 5(this));
    }

    private boolean dE(String str, String str2) {
        double d;
        boolean is2G = ao.is2G(this);
        int i = is2G ? 10485760 : 26214400;
        if (is2G) {
            d = 60000.0d;
        } else {
            d = 300000.0d;
        }
        x.i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", new Object[]{Integer.valueOf(SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, 1000000))});
        switch (SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, 1000000)) {
            case IX5WebViewClient.ERROR_CONNECT /*-6*/:
            case IX5WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
            case IX5WebViewClient.ERROR_AUTHENTICATION /*-4*/:
            case IX5WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
            case IX5WebViewClient.ERROR_HOST_LOOKUP /*-2*/:
            case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                return false;
            case 0:
                int i2;
                int i3;
                com.tencent.mm.modelvideo.o.Ta();
                String nK = s.nK(str);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str2);
                x.i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", new Object[]{nK});
                int i4 = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i5 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                VideoTransPara videoTransPara = new VideoTransPara();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                PInt pInt3 = new PInt();
                PInt pInt4 = new PInt();
                PInt pInt5 = new PInt();
                com.tencent.mm.plugin.sight.base.d.a(str2, pInt, pInt2, pInt3, pInt4, pInt5);
                videoTransPara.duration = pInt.value / 1000;
                videoTransPara.width = pInt2.value;
                videoTransPara.height = pInt3.value;
                videoTransPara.fps = pInt4.value;
                videoTransPara.videoBitrate = pInt5.value;
                VideoTransPara b = com.tencent.mm.modelcontrol.d.NP().b(videoTransPara);
                int i6 = com.tencent.mm.plugin.sight.base.b.nbW;
                x.d("MicroMsg.MassSendMsgUI", "check remuxing old para %s, newPara: %s", new Object[]{videoTransPara, b});
                if (b == null) {
                    i2 = 0;
                    i = i5;
                    int i7 = i4;
                    while (i2 < 3) {
                        if (i7 % 2 != 0) {
                            i7--;
                        }
                        if (i % 2 != 0) {
                            i--;
                        }
                        if ((i7 < i || (i7 > 640 && i > 480)) && (i7 > i || (i7 > 480 && i > 640))) {
                            i7 /= 2;
                            i /= 2;
                            i2++;
                        } else {
                            i3 = i7;
                        }
                    }
                    i = i5;
                    i3 = i4;
                } else {
                    i3 = b.width;
                    i = b.height;
                    i6 = b.videoBitrate;
                }
                mediaMetadataRetriever.release();
                if (SightVideoJNI.remuxing(str2, nK, i3, i, i6, com.tencent.mm.plugin.sight.base.b.nbV, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.nbX, null, 0, false) < 0) {
                    x.w("MicroMsg.MassSendMsgUI", "remuxing video error");
                    return false;
                }
                Gp(nK);
                com.tencent.mm.modelvideo.o.Ta();
                String nL = s.nL(str);
                if (!FileOp.cn(nL)) {
                    x.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", new Object[]{nL});
                    try {
                        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(nK, 1);
                        if (createVideoThumbnail != null) {
                            com.tencent.mm.sdk.platformtools.c.a(createVideoThumbnail, 60, CompressFormat.JPEG, nL, true);
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.MassSendMsgUI", e, "", new Object[0]);
                        x.e("MicroMsg.MassSendMsgUI", "create thumb error: %s", new Object[]{e.getMessage()});
                    }
                }
                x.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", new Object[]{nK, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2)});
                return true;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                com.tencent.mm.modelvideo.o.Ta();
                Gp(s.nK(str));
                return true;
            default:
                return false;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.lbk != null) {
            b bVar = this.lbk;
            if (bVar.tipDialog != null) {
                bVar.tipDialog.dismiss();
                bVar.tipDialog = null;
            }
        }
        if (i == 0 && i2 == 0) {
            lbi = "";
            Intent intent = new Intent(this, MassSendHistoryUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
            finish();
        } else if (i == 4 && i2 == -24) {
            x.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
            Toast.makeText(this, R.l.mass_send_err_spam, 0).show();
        } else {
            if (i == 2 || i == 1 || i == 3) {
                this.laA.setLastText(lbi);
            }
            com.tencent.mm.plugin.masssend.a.ezo.a(this.mController.tml, i, i2, str);
            switch (i2) {
                case -71:
                    int i3 = ((ata) ((f) lVar).diG.dIE.dIL).rVz;
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.mass_send_tolist_limit, new Object[]{Integer.valueOf(i3)}), getString(R.l.app_tip), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MassSendMsgUI.this.finish();
                        }
                    });
                    return;
                case -34:
                    Toast.makeText(this, R.l.mass_send_err_freq_limit, 0).show();
                    return;
                default:
                    Toast.makeText(this, R.l.sendrequest_send_fail, 0).show();
                    return;
            }
        }
    }

    private static void Gp(String str) {
        long cm = (long) com.tencent.mm.a.e.cm(str);
        int f = bi.f((Integer) h.a((int) (cm / 1024), new int[]{512, 1024, 2048, 5120, 8192, 10240, 15360, 20480}, 247, 255));
        h.mEJ.a(106, (long) f, 1, false);
        h.mEJ.a(106, 246, 1, false);
        x.d("MicroMsg.MassSendMsgUI", "report video size res : " + f + " hadCompress : true fileLen : " + (cm / 1024) + "K");
    }
}
