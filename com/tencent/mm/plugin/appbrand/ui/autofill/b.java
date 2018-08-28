package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.widget.a;
import com.tencent.mm.protocal.c.ej;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.y;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.lang.reflect.Method;

public final class b extends x {
    private MMFormVerifyCodeInputView eRn;
    private TextView fAK;
    private ej gxF;
    private TextView gxG;
    private TextView gxH;
    AppBrandIDCardUI$a gxe;
    private LinearLayout gxf;
    private View gxg;
    private Button gxj;
    private ek gxx;
    private com.tencent.mm.ui.b mActionBarHelper;
    private MyKeyboardWindow mKeyboard;

    protected final void dealContentView(View view) {
        if (this.gxe == null || this.gxe.anM() == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
        } else if (this.gxe.anM().reO == null || this.gxe.anM().reO.size() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
        } else {
            this.gxf = (LinearLayout) view.findViewById(g.app_brand_idcard_verify_sms_layout);
            this.fAK = (TextView) view.findViewById(g.app_brand_idcard_verify_sms_desc);
            this.gxG = (TextView) view.findViewById(g.app_brand_idcard_verify_sms_phone_number);
            this.gxH = (TextView) view.findViewById(g.app_brand_idcard_verify_sms_switch_phone);
            this.gxj = (Button) view.findViewById(g.app_brand_idcard_show_confirm);
            this.eRn = (MMFormVerifyCodeInputView) view.findViewById(g.app_brand_idcard_verify_sms_edit);
            this.mKeyboard = (MyKeyboardWindow) view.findViewById(g.app_brand_idcard_verify_sms_input);
            this.gxg = y.gq(getContext()).inflate(h.actionbar_custom_area, null);
            this.gxg.setBackgroundColor(getResources().getColor(d.action_bar_color));
            this.mActionBarHelper = new com.tencent.mm.ui.b(this.gxg);
            this.gxf.addView(this.gxg, 0, new LayoutParams(-1, a.cM(getActivity())));
            this.gxx = this.gxe.anM();
            this.mActionBarHelper.setTitle(this.gxx.title);
            this.mActionBarHelper.b(new OnClickListener() {
                public final void onClick(View view) {
                    if (b.this.gxe != null) {
                        b.this.gxe.back();
                    }
                }
            });
            this.fAK.setText(this.gxx.desc);
            this.gxF = (ej) this.gxx.reO.get(0);
            this.gxG.setText(((ej) this.gxx.reO.get(0)).reN);
            if (this.gxx.reO.size() > 1) {
                this.gxH.setVisibility(0);
                this.gxH.setOnClickListener(new 2(this));
            } else {
                this.gxH.setVisibility(8);
            }
            this.eRn.setVisibility(0);
            this.eRn.setSendSmsBtnClickListener(new 3(this));
            this.eRn.addTextChangedListener(new 4(this));
            View contentEditText = this.eRn.getContentEditText();
            if (contentEditText != null) {
                if (VERSION.SDK_INT >= 21) {
                    contentEditText.setShowSoftInputOnFocus(false);
                } else {
                    Class cls = EditText.class;
                    try {
                        Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                        method.setAccessible(true);
                        method.invoke(contentEditText, new Object[]{Boolean.valueOf(false)});
                        method.setAccessible(false);
                    } catch (NoSuchMethodException e) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                        try {
                            Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                            method2.setAccessible(true);
                            method2.invoke(contentEditText, new Object[]{Boolean.valueOf(false)});
                            method2.setAccessible(false);
                        } catch (Throwable e2) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[]{bi.i(e2)});
                            if (contentEditText.getContext() != null && (contentEditText.getContext() instanceof MMActivity)) {
                                ((MMActivity) contentEditText.getContext()).hideVKB(contentEditText);
                            }
                        }
                    } catch (Throwable e22) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[]{bi.i(e22)});
                    }
                }
            }
            if (this.eRn.getText() == null || this.eRn.getText().toString().length() <= 0) {
                this.gxj.setEnabled(false);
            } else {
                this.gxj.setEnabled(true);
            }
            this.gxj.setVisibility(0);
            this.gxj.setOnClickListener(new 5(this));
            this.mKeyboard.setXMode(0);
            this.mKeyboard.setInputEditText(this.eRn.getContentEditText());
            if (VERSION.SDK_INT >= 14) {
                this.mKeyboard.setAccessibilityDelegate(new c());
            }
        }
    }

    protected final int getLayoutId() {
        return h.app_brand_idcard_verify_sms_ui;
    }

    public final void onResume() {
        super.onResume();
        if (isSupportNavigationSwipeBack()) {
            getContentView().setVisibility(0);
            getSwipeBackLayout().setEnableGesture(true);
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    public final void onSwipeBack() {
        if (this.gxe != null) {
            this.gxe.onSwipeBack();
            getContentView().setVisibility(8);
            if (isSupportNavigationSwipeBack()) {
                getSwipeBackLayout().setEnableGesture(false);
            }
        }
    }
}
