package com.tencent.mm.plugin.facedetect.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable.Factory;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.l;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.protocal.c.bbt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;

@a(3)
public class FaceDetectConfirmUI extends MMActivity implements e {
    private String appId;
    private String fWF;
    private String grA;
    private String iMx = null;
    private String iMy = null;
    private String iMz = null;
    private TextView iPT;
    private Button iPU;
    private CheckBox iPV;
    private TextView iPW;
    private TextView iPX;
    private bbt iPY = null;
    private int iPZ;
    private p tipDialog;

    protected final int getLayoutId() {
        return g.face_confirm_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.appId = getIntent().getStringExtra("k_app_id");
        this.fWF = getIntent().getStringExtra("request_verify_pre_info");
        this.grA = getIntent().getStringExtra("key_function_name");
        this.iPZ = getIntent().getIntExtra("key_business_type", -1);
        setMMTitle(getString(h.face_confirm_ui_title));
        setBackBtn(new 1(this));
        this.iPT = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.face_confirm_header_tips);
        this.iPU = (Button) findViewById(com.tencent.mm.plugin.facedetect.a.e.start_face_detect_button);
        this.iPU.setOnClickListener(new 2(this));
        this.iPV = (CheckBox) findViewById(com.tencent.mm.plugin.facedetect.a.e.face_confirm_protocol_checkbox);
        this.iPV.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    FaceDetectConfirmUI.this.iPU.setEnabled(true);
                } else {
                    FaceDetectConfirmUI.this.iPU.setEnabled(false);
                }
            }
        });
        this.iPV.setVisibility(8);
        this.iPW = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.face_confirm_protocol_checkbox_text);
        this.iPX = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.face_complain);
        x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(h.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(h.app_waiting), false, new 4(this));
        l lVar = new l(this.appId, this.fWF);
        com.tencent.mm.kernel.g.DF().a(1147, this);
        com.tencent.mm.kernel.g.DF().a(lVar, 0);
    }

    private void aKo() {
        Intent intent = new Intent();
        intent.putExtra("err_code", k.py(90024));
        intent.putExtra("err_msg", "user cancel in confirm ui");
        FaceDetectReporter.aJU().a(this.iPZ, false, 3, 1, 90024);
        FaceDetectReporter.aJU().iOi = System.currentTimeMillis();
        FaceDetectReporter.aJU().bl(this.grA, this.iPZ);
        setResult(0, intent);
        finish();
    }

    public void finish() {
        dismissDialog();
        super.finish();
    }

    private void dismissDialog() {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }

    public void onBackPressed() {
        aKo();
        super.onBackPressed();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            this.iPY = ((l) lVar).iMw;
            this.iMx = ((l) lVar).iMx;
            this.iMy = ((l) lVar).iMy;
            this.iMz = ((l) lVar).iMz;
            if (bi.oW(this.iMx)) {
                this.iMx = getString(h.face_confirm_tips);
            }
            dismissDialog();
            this.iPU.setEnabled(true);
            this.iPT.setText(this.iMx);
            if (this.iPY != null) {
                String string;
                String string2;
                x.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s, url_wording: %s, url: %s", new Object[]{this.iPY.bSc, this.iPY.seb, this.iPY.url});
                bbt bbt = this.iPY;
                x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo protocol info: %s", new Object[]{bbt.bSc});
                if (bi.oW(bbt.bSc)) {
                    string = getString(h.face_confirm_protocol_tips);
                } else {
                    string = bbt.bSc;
                }
                if (bi.oW(bbt.seb)) {
                    string2 = getString(h.face_confirm_protocol_details);
                } else {
                    string2 = bbt.seb;
                }
                CharSequence newSpannable = Factory.getInstance().newSpannable(string + string2);
                newSpannable.setSpan(new 6(this, bbt), string.length(), string.length() + string2.length(), 33);
                this.iPV.setVisibility(0);
                this.iPW.setVisibility(0);
                this.iPW.setText(newSpannable);
                this.iPW.setMovementMethod(LinkMovementMethod.getInstance());
                if (bbt.sec == 0) {
                    this.iPV.setChecked(false);
                    this.iPU.setEnabled(false);
                } else if (bbt.sec == 1) {
                    this.iPV.setChecked(true);
                    this.iPU.setEnabled(true);
                }
                this.iPX.setText(getString(h.face_confirm_complain_tips));
                this.iPX.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        try {
                            String str = "appid=%s";
                            Object[] objArr = new Object[1];
                            objArr[0] = FaceDetectConfirmUI.this.appId != null ? FaceDetectConfirmUI.this.appId : "";
                            x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo jump realUrl: %s", new Object[]{FaceDetectConfirmUI.this.iMz + "?customInfo=" + com.tencent.mm.compatible.util.p.encode(String.format(str, objArr), "UTF-8")});
                            FaceDetectConfirmUI.a(FaceDetectConfirmUI.this, r0);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FaceDetectConfirmUI", e, "alvinluo jumpToWebView exception", new Object[0]);
                        }
                    }
                });
                this.iPX.setVisibility(0);
            }
        } else {
            if (bi.oW(str)) {
                str = getString(h.face_get_confirm_info_failed_tips);
            }
            dismissDialog();
            com.tencent.mm.ui.base.h.a(this, str, getString(h.app_tip), false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("err_code", k.py(90022));
                    intent.putExtra("err_msg", "get confirm info error");
                    FaceDetectReporter.aJU().a(FaceDetectConfirmUI.this.iPZ, false, 3, 2, 90022);
                    FaceDetectReporter.aJU().iOi = System.currentTimeMillis();
                    FaceDetectReporter.aJU().bl(FaceDetectConfirmUI.this.grA, FaceDetectConfirmUI.this.iPZ);
                    FaceDetectConfirmUI.this.setResult(-1, intent);
                    FaceDetectConfirmUI.this.finish();
                }
            });
        }
        com.tencent.mm.kernel.g.DF().b(1147, this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        FaceDetectReporter.aJU().iOi = System.currentTimeMillis();
        FaceDetectReporter.aJU().bl(this.grA, this.iPZ);
        setResult(i2, intent);
        finish();
    }
}
