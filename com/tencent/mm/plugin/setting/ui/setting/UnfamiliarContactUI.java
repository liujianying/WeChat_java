package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.TextButtonPreference;
import com.tencent.mm.ui.base.preference.f;

public class UnfamiliarContactUI extends MMPreference {
    private boolean mOS;
    private boolean mOT;
    private boolean mOU;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int Ys() {
        return k.settings_unfamiliar_contact_ui;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        if (preference instanceof CheckPreference) {
            CheckPreference checkPreference = (CheckPreference) preference;
            boolean z2;
            boolean z3;
            if (preference.mKey.equals("settings_half_year_not_chat")) {
                checkPreference.qpJ = !this.mOS;
                if (this.mOS) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.mOS = z2;
            } else if (preference.mKey.equals("settings_has_not_same_chatroom")) {
                if (this.mOU) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                checkPreference.qpJ = z3;
                if (this.mOU) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.mOU = z2;
            } else if (preference.mKey.equals("settings_half_year_not_response")) {
                if (this.mOT) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                checkPreference.qpJ = z3;
                if (this.mOT) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.mOT = z2;
            }
            TextButtonPreference textButtonPreference = (TextButtonPreference) fVar.ZZ("settings_next_step");
            if (this.mOS || this.mOU || this.mOT) {
                z = true;
            }
            textButtonPreference.setEnabled(z);
        } else if (preference.mKey.equals("settings_next_step")) {
            Intent intent = new Intent(this, UnfamiliarContactDetailUI.class);
            intent.putExtra("half_year_not_chat", this.mOS);
            intent.putExtra("half_year_not_response", this.mOT);
            intent.putExtra("has_not_same_chatroom", this.mOU);
            startActivityForResult(intent, 291);
        }
        fVar.notifyDataSetChanged();
        return true;
    }

    protected final void initView() {
        super.initView();
        setMMTitle(i.settings_unfamiliar_contact);
        setBackBtn(new 1(this));
        ((CheckPreference) this.tCL.ZZ("settings_half_year_not_chat")).tBG = 0;
        ((CheckPreference) this.tCL.ZZ("settings_has_not_same_chatroom")).tBG = 0;
        ((CheckPreference) this.tCL.ZZ("settings_half_year_not_response")).tBG = 0;
        ((TextButtonPreference) this.tCL.ZZ("settings_next_step")).setEnabled(false);
        this.tCL.notifyDataSetChanged();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }
}
