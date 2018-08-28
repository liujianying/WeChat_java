package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.d;
import com.tencent.mm.plugin.facedetect.b.p;
import com.tencent.mm.plugin.facedetect.c.b;
import com.tencent.mm.plugin.facedetect.c.e;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.ui.b.1;
import com.tencent.mm.plugin.facedetect.ui.b.2;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import java.security.InvalidParameterException;

@a(3)
public class FaceDetectPrepareUI extends MMFragmentActivity implements android.support.v4.app.a.a, e {
    private String cYO;
    private boolean dJO = false;
    private boolean fWB = false;
    private int iLW;
    private d iLX = null;
    private String iMy = null;
    private long iNq;
    private com.tencent.mm.plugin.facedetect.c.a iQQ = null;
    private a iQR = null;
    private b iQS = null;
    private boolean iQT;
    private byte[] iQU;
    private boolean iQV = false;
    private boolean iQW = false;
    private b iQX;
    private boolean iQY = false;
    private boolean iQZ = false;
    private long iRa = -1;
    private Messenger iRb = null;
    private a iRc = null;
    private int iRd = -1;
    private boolean iRe = false;
    private String mAppId;

    static /* synthetic */ void b(FaceDetectPrepareUI faceDetectPrepareUI, Message message) {
        Bundle data = message.getData();
        if (data == null) {
            faceDetectPrepareUI.aKr();
        } else if (data.getInt("key_face_result_code", -1) != 0) {
            faceDetectPrepareUI.aKr();
        } else {
            faceDetectPrepareUI.iRd = 3;
            String string = data.getString("key_face_result_file_path");
            if (string != null) {
                com.tencent.mm.sdk.f.e.post(new 10(faceDetectPrepareUI, string), "face_upload");
            }
        }
    }

    static /* synthetic */ int pD(int i) {
        if (i == 1 || i == 2) {
            return 3;
        }
        if (i == 4) {
            return 2;
        }
        return i != 0 ? 4 : i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.face_prepare_ui);
        getWindow().addFlags(2097280);
        this.mAppId = getIntent().getStringExtra("k_app_id");
        this.cYO = getIntent().getStringExtra("k_user_name");
        this.iLW = getIntent().getIntExtra("k_server_scene", -1);
        this.iQT = getIntent().getBooleanExtra("k_need_signature", false);
        boolean z = com.tencent.mm.plugin.facedetect.model.e.aJF() || getIntent().getBooleanExtra("key_is_need_video", false);
        this.iQY = z;
        this.iMy = getIntent().getStringExtra("key_feedback_url");
        this.iRc = new a(this, (byte) 0);
        this.iRb = new Messenger(this.iRc);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("k_messenger", this.iRb);
        startService(intent);
        FaceContextData.a(new FaceContextData());
        o.r(this);
        int i = b.iMT;
        this.iQQ = b.a(this, this, this.iLW, getIntent().getExtras());
        if (this.iQQ == null) {
            aiL();
        } else {
            this.iQQ.a(new 8(this));
            this.iLX = new 9(this);
            this.iQQ.a(this.iLX);
        }
        if (this.iQX != null) {
            b bVar = this.iQX;
            bVar.errType = -1;
            bVar.errCode = -1;
            bVar.Yy = "";
            if (bVar.extras != null) {
                bVar.extras.clear();
            }
        }
        this.iQV = false;
        if (this.iLW == 2 || this.iLW == 5) {
            if (com.tencent.mm.kernel.g.Ei().DT().getBoolean(aa.a.sVK, false)) {
                z = false;
            }
            z = true;
        } else {
            if (this.iLW != 3 && this.iLW == 4) {
                z = false;
            }
            z = true;
        }
        if (z) {
            x.i("MicroMsg.FaceDetectPrepareUI", "hy: need tutorial. show tutorial first");
            this.iQS = new b();
            this.iRd = 0;
            b bVar2 = this.iQS;
            if (this == null) {
                throw new InvalidParameterException("hy: tutorial context is null");
            }
            bVar2.ido = findViewById(com.tencent.mm.plugin.facedetect.a.e.face_tutorial_root);
            bVar2.iQh = (Button) bVar2.ido.findViewById(com.tencent.mm.plugin.facedetect.a.e.left_btn);
            bVar2.vp = (ViewPager) bVar2.ido.findViewById(com.tencent.mm.plugin.facedetect.a.e.pager);
            bVar2.hF = new b.b(bVar2, getSupportFragmentManager());
            bVar2.vp.setAdapter(bVar2.hF);
            bVar2.iQh.setOnClickListener(new 1(bVar2));
            bVar2.vp.a(new 2(bVar2));
            this.iQS.iRV = new b.a() {
                public final void onCancel() {
                    x.i("MicroMsg.FaceDetectPrepareUI", "hy: user cancel in tutorial");
                    FaceDetectPrepareUI.this.ae(90002, "user cancel in tutorial");
                }

                public final void aKu() {
                    x.i("MicroMsg.FaceDetectPrepareUI", "hy: tutorial confirmed. start");
                    FaceDetectPrepareUI.this.aKq();
                }
            };
            com.tencent.mm.kernel.g.Eg();
            if (com.tencent.mm.kernel.a.Dw()) {
                com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sVK, Boolean.valueOf(true));
            }
            this.iQS.ido.setVisibility(0);
            return;
        }
        View findViewById = findViewById(com.tencent.mm.plugin.facedetect.a.e.face_tutorial_root);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        aKq();
    }

    private void aKq() {
        this.iRd = 1;
        this.iQR = new a(this);
        a aVar = this.iQR;
        synchronized (((FaceDetectPrepareUI) aVar.iQm.get())) {
            if (aVar.iQm.get() != null) {
                aVar.iQc = (RelativeLayout) ((FaceDetectPrepareUI) aVar.iQm.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.jumper_root);
                aVar.iQd = (Button) ((FaceDetectPrepareUI) aVar.iQm.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.next_btn);
                aVar.iQe = (ImageView) ((FaceDetectPrepareUI) aVar.iQm.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.tips_icon);
                aVar.iQf = (TextView) ((FaceDetectPrepareUI) aVar.iQm.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.tips_tv);
                aVar.iQk = AnimationUtils.loadAnimation((Context) aVar.iQm.get(), com.tencent.mm.plugin.facedetect.a.a.alpha_in);
                aVar.iQl = AnimationUtils.loadAnimation((Context) aVar.iQm.get(), com.tencent.mm.plugin.facedetect.a.a.alpha_out);
                aVar.iQh = (Button) ((FaceDetectPrepareUI) aVar.iQm.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.jumper_left_btn);
                aVar.iQi = (Button) ((FaceDetectPrepareUI) aVar.iQm.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.subbutton);
                aVar.iQg = (TextView) ((FaceDetectPrepareUI) aVar.iQm.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.tweeky_Tv);
                aVar.iQj = (TextView) ((FaceDetectPrepareUI) aVar.iQm.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.feedback_tv);
                aVar.iQk.setDuration(500);
                aVar.iQl.setDuration(500);
            }
        }
        if (o.q(this)) {
            x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo checkFacePermissionAnd Request true and do init ");
            aKt();
        } else {
            x.i("MicroMsg.FaceDetectPrepareUI", "hy: no camera permission. request permission");
        }
        if (this.iQY) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_need_video", this.iQY);
            l(4, bundle);
        }
        aKs();
    }

    private void l(int i, Bundle bundle) {
        String str = "MicroMsg.FaceDetectPrepareUI";
        String str2 = "hy: sending msg: cmd: %d, data: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = bundle != null ? bundle.toString() : "null";
        x.i(str, str2, objArr);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("k_cmd", i);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtras(bundle);
        startService(intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.iQZ) {
            stopService(new Intent(this, FaceDetectProcessService.class));
        }
    }

    public final void aJA() {
        this.iRe = false;
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        this.iRe = true;
    }

    public void onStop() {
        super.onStop();
        if (!this.iRe) {
            return;
        }
        if (this.fWB || !hasError()) {
            finish();
        } else {
            a(this.iQX.errType, this.iQX.errCode, this.iQX.Yy, this.iQX.extras);
        }
    }

    public void finish() {
        if (this.iQR != null && this.iQR.aKp()) {
            this.iQR.dismiss();
        }
        if (this.iQS != null) {
            this.iQS.dismiss();
        }
        x.v("MicroMsg.FaceDetectPrepareUI", "alvinluo: releaseFaceDetect");
        if (this.iQQ != null) {
            this.iQQ.aJx();
        }
        super.finish();
        this.fWB = true;
    }

    private void aKr() {
        c(4, 90011, "get image failed", getString(h.face_detect_get_face_image_failed));
    }

    private void aiL() {
        c(4, 90013, "init lib failed", getString(h.face_detect_init_err));
    }

    private void c(int i, int i2, String str, String str2) {
        x.i("MicroMsg.FaceDetectPrepareUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        d(i, i2, str, null);
        this.iQW = true;
        a(i, i2, str, str2, false, new 11(this));
    }

    public void onBackPressed() {
        if (hasError()) {
            if (this.iQQ != null) {
                this.iQQ.c(this.iQX.errType, this.iQX.errCode, this.iQX.Yy, this.iQX.extras);
            }
        } else if (this.iRd == 1) {
            ae(90003, "user cancel in init");
        } else if (this.iRd == 3) {
            ae(90005, "user cancel in uploading");
        } else if (this.iRd == 0) {
            ae(90002, "user cancel in tutorial");
        } else {
            ae(90050, "user cancel unknown");
        }
    }

    private void ae(int i, String str) {
        if (hasError()) {
            if (this.iQQ != null) {
                this.iQQ.c(this.iQX.errType, this.iQX.errCode, this.iQX.Yy, this.iQX.extras);
            }
        } else if (this.iQQ != null) {
            this.iQQ.ac(i, str);
        }
        this.dJO = true;
        finish();
    }

    private boolean hasError() {
        boolean z;
        String str = "MicroMsg.FaceDetectPrepareUI";
        String str2 = "alvinluo hasLastError: %b, lastError == null: %b, hashCode: %d";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.iQV);
        if (this.iQX == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(hashCode());
        x.i(str, str2, objArr);
        return this.iQV && this.iQX != null;
    }

    public final void d(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo saveError errType: %d, errCode: %d, errMsg: %s, hashCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(hashCode())});
        if (this.iQX == null) {
            this.iQX = new b(this, (byte) 0);
        }
        this.iQV = true;
        b bVar = this.iQX;
        bVar.errType = i;
        bVar.errCode = i2;
        bVar.Yy = str;
        bVar.extras = bundle;
    }

    private void aKs() {
        x.i("MicroMsg.FaceDetectPrepareUI", "hy: start show jumper: %b", new Object[]{Boolean.valueOf(true)});
        this.iRa = bi.VG();
        com.tencent.mm.sdk.f.e.post(new 12(this), "face_prepareInit");
    }

    private void a(final int i, final int i2, final String str, String str2, boolean z, c cVar) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo showFailJumper showErrMsg: %s", new Object[]{str2});
        a$b a = a.a(com.tencent.mm.plugin.facedetect.a.d.face_err_icon, str2, z ? getResources().getString(h.face_try_again) : getString(h.face_severe_error_main_btn), z ? getResources().getString(h.app_cancel) : null, new 14(this, z, cVar, i, i2, str), new OnClickListener() {
            public final void onClick(View view) {
                FaceDetectPrepareUI.this.a(i, i2, str, null);
            }
        });
        a.a(a, getString(h.face_detect_feedback), new 3(this, i2));
        ah.A(new 4(this, a));
    }

    private void aKt() {
        if (this.iQQ != null) {
            this.iQQ.aJv();
        }
    }

    public final void aJv() {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo startFaceDetect");
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo preparing");
        if (this.iQQ != null) {
            String string = getIntent().getExtras().getString("k_ticket");
            if (!bi.oW(string)) {
                x.i("MicroMsg.FaceDetectBaseController", "hy: has prepared ticket. force set");
                p.AR(string);
            }
        }
        aKs();
        if (this.iQQ != null) {
            this.iQQ.aJu();
        }
        this.iRe = true;
    }

    public final void aJx() {
    }

    public final void a(boolean z, boolean z2, a$b a_b) {
        if (z2) {
            x.i("MicroMsg.FaceDetectPrepareUI", "hy: need blur");
            com.tencent.mm.sdk.f.e.post(new 5(this), "face_refresh_background");
        }
        this.iQR.a(a_b);
    }

    public final void a(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectPrepareUI", "finishWithResult errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_code", k.py(i2));
        bundle2.putString("err_msg", str);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        setResult(-1, intent);
        if (this.iQY) {
            this.iQZ = true;
            l(5, this.iQQ.aJz());
        }
        finish();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 90008;
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onRequestPermissionsResult");
        if (iArr != null && iArr.length > 0) {
            switch (i) {
                case 23:
                    int i3;
                    String str = "";
                    String str2 = "";
                    if (iArr.length != 1) {
                        if (iArr.length == 2) {
                            if (iArr[0] == 0 && iArr[1] == 0) {
                                i3 = 1;
                            } else {
                                if (iArr[0] != 0) {
                                    str = "camera permission not granted";
                                    str2 = getString(h.permission_camera_request_again_msg);
                                } else {
                                    i2 = -1;
                                }
                                if (iArr[1] != 0) {
                                    str = "audio permission not granted";
                                    str2 = getString(h.permission_microphone_request_again_msg);
                                    i2 = 90009;
                                }
                                if (!(iArr[0] == 0 || iArr[1] == 0)) {
                                    i2 = 90010;
                                    str = "both camera and audio permission not granted";
                                    str2 = getString(h.permission_camera_request_again_msg);
                                }
                                c(1, i2, str, str2);
                                i3 = 0;
                            }
                        }
                        i2 = -1;
                        c(1, i2, str, str2);
                        i3 = 0;
                    } else if (iArr[0] == 0) {
                        i3 = 1;
                    } else {
                        if (strArr[0].equals("android.permission.CAMERA")) {
                            str = "camera permission not granted";
                            str2 = getString(h.permission_camera_request_again_msg);
                        } else {
                            if (strArr[0].equals("android.permission.RECORD_AUDIO")) {
                                str = "audio permission not granted";
                                str2 = getString(h.permission_microphone_request_again_msg);
                                i2 = 90009;
                            }
                            i2 = -1;
                        }
                        c(1, i2, str, str2);
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        aKt();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.iRd = 1;
        if (intent == null) {
            x.e("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult data is null");
            a(4, 90018, "system error", getString(h.face_get_confirm_info_failed_tips), false, new 6(this));
            return;
        }
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) intent.getParcelableExtra("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.aJU().a(faceDetectReporter);
        }
        int intExtra = intent.getIntExtra("err_type", -1);
        int intExtra2 = intent.getIntExtra("err_code", -1);
        String stringExtra = intent.getStringExtra("err_msg");
        if (this.iQQ != null) {
            com.tencent.mm.plugin.facedetect.c.a aVar = this.iQQ;
            intent.getExtras();
            aVar.i(intExtra, intExtra2, stringExtra);
        }
        x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intExtra), Integer.valueOf(intExtra2), stringExtra});
        if (intExtra == 0 && intExtra2 == 0) {
            String string = getString(h.face_detect_uploading);
            a$b b = a.b(com.tencent.mm.plugin.facedetect.a.d.face_confirm_icon, string, null, getString(h.app_cancel), null, new 13(this));
            b.iQw = true;
            b.iQy = string.length() - 3;
            a(false, true, b);
            l(1, null);
        } else if (intExtra != 1) {
            String stringExtra2 = intent.getStringExtra("show_err_msg");
            if (intExtra2 == 90013) {
                stringExtra2 = getString(h.face_detect_init_err);
            } else if (intExtra2 == 90008 || intExtra2 == 90010) {
                stringExtra2 = getString(h.permission_camera_request_again_msg);
            } else if (intExtra2 == 90009) {
                stringExtra2 = getString(h.permission_microphone_request_again_msg);
            } else if (bi.oW(stringExtra2)) {
                stringExtra2 = getString(h.soter_face_err_msg_retry);
            }
            d(intExtra, intExtra2, stringExtra, null);
            a(intExtra, intExtra2, stringExtra, stringExtra2, intExtra2 == 90023, new c() {
                public final void j(int i, int i2, String str) {
                    if (FaceDetectPrepareUI.this.iQQ != null) {
                        FaceDetectPrepareUI.this.iQQ.c(i, i2, str, null);
                    }
                }
            });
        } else if (intExtra2 == 90004 || intExtra2 == 90025) {
            ae(intExtra2, stringExtra);
        }
    }
}
