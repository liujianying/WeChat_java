package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView extends ProfileItemView implements com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.a {
    public String qGi;
    public String qGj;
    public String[] qGk;
    private LinearLayout qGl;
    private boolean qGm = false;
    public a qGn;

    public interface a {
        void auM();

        void cds();
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileEditPhoneNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayout() {
        return R.i.profile_edit_phone_number_layout;
    }

    public final void init() {
        this.qGl = (LinearLayout) findViewById(R.h.main_layout);
    }

    public void clearFocus() {
        for (int i = 1; i < this.qGl.getChildCount(); i++) {
            this.qGl.getChildAt(i).clearFocus();
        }
    }

    public final boolean N(ab abVar) {
        this.ipd = abVar;
        return true;
    }

    public final boolean bnH() {
        int i;
        int i2;
        if (bi.oW(this.qGi)) {
            i = 0;
            i2 = 0;
        } else {
            bn(this.qGi, true);
            i = 1;
            i2 = 1;
        }
        if (!bi.oW(this.qGj)) {
            this.qGk = this.qGj.split(",");
            while (i2 < this.qGk.length + i) {
                bn(this.qGk[i2 - i].trim(), false);
                i2++;
            }
        }
        if (i2 < 5) {
            bn(null, false);
            this.qGm = false;
        } else {
            this.qGm = true;
        }
        return false;
    }

    public ArrayList<String> getPhoneNumberList() {
        int childCount = this.qGl.getChildCount();
        if (childCount == 1) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList(childCount - 1);
        for (int i = 1; i < childCount; i++) {
            String obj = ((MMPhoneNumberEditText) this.qGl.getChildAt(i)).getText().toString();
            if (!bi.oW(obj)) {
                arrayList.add(obj);
            }
        }
        if (!bi.oW(this.qGi)) {
            arrayList.remove(0);
        }
        return arrayList;
    }

    private void cdr() {
        if (this.qGn != null) {
            this.qGn.auM();
        }
    }

    public final void f(MMPhoneNumberEditText mMPhoneNumberEditText) {
        if (mMPhoneNumberEditText.qFP) {
            h.a(getContext(), R.l.hide_md5_match_phone_number_tip, 0, R.l.hide_md5_match_phone_number_hide, R.l.hide_md5_match_phone_number_cancel, new 1(this, mMPhoneNumberEditText), null);
            return;
        }
        h(mMPhoneNumberEditText);
        if (this.qGm) {
            bn(null, false);
            this.qGm = false;
        }
        cdr();
    }

    public final void cdm() {
        cdr();
    }

    public final void cdl() {
        if (this.qGl.getChildCount() - 1 < 5) {
            bn(null, false);
        } else {
            this.qGm = true;
        }
        cdr();
    }

    public final void g(MMPhoneNumberEditText mMPhoneNumberEditText) {
        if (this.qGl.getChildCount() - 1 != 1) {
            h(mMPhoneNumberEditText);
            if (this.qGm) {
                bn(null, false);
            }
            this.qGm = false;
            cdr();
        }
    }

    private void bn(String str, boolean z) {
        MMPhoneNumberEditText mMPhoneNumberEditText = (MMPhoneNumberEditText) LayoutInflater.from(getContext()).inflate(R.i.profile_edit_phone_number_item, null);
        mMPhoneNumberEditText.setHint(ad.getResources().getString(R.l.add_phone_number));
        if (z) {
            mMPhoneNumberEditText.qFP = true;
            mMPhoneNumberEditText.qFN = mMPhoneNumberEditText.getResources().getDrawable(R.k.info_icon);
            mMPhoneNumberEditText.qFN.setBounds(0, 0, mMPhoneNumberEditText.qFN.getIntrinsicWidth(), mMPhoneNumberEditText.qFN.getIntrinsicHeight());
            mMPhoneNumberEditText.setFocusable(false);
            mMPhoneNumberEditText.cdj();
        }
        mMPhoneNumberEditText.setCallback(this);
        mMPhoneNumberEditText.setText(str);
        mMPhoneNumberEditText.setSelection(mMPhoneNumberEditText.getText().length());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, com.tencent.mm.bp.a.fromDPToPix(getContext(), 12), 0, 0);
        this.qGl.addView(mMPhoneNumberEditText, layoutParams);
    }

    private void h(MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.qGl.removeView(mMPhoneNumberEditText);
        this.qGl.getChildAt(this.qGl.getChildCount() - 1).requestFocus();
    }
}
