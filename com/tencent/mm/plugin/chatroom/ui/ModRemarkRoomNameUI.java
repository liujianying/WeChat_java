package com.tencent.mm.plugin.chatroom.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aud;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class ModRemarkRoomNameUI extends MMActivity implements a {
    private p eXe = null;
    private String fsV;
    private boolean hLL = false;
    private c hLO = new 1(this);
    private String hMT = "";
    private MMEditText hMU;
    private b hMV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fsV = getIntent().getStringExtra("RoomInfo_Id");
        com.tencent.mm.sdk.b.a.sFg.b(this.hLO);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.room_card);
        this.hMU = (MMEditText) findViewById(R.h.modify_roomname_et);
        final CharSequence oV = bi.oV(getIntent().getStringExtra("room_name"));
        if (bi.oW(oV)) {
            this.hMU.setHint(j.a(this, ((com.tencent.mm.plugin.chatroom.b.b) g.l(com.tencent.mm.plugin.chatroom.b.b.class)).Ga().gT(this.fsV), this.hMU.getTextSize()));
            this.hMU.setEllipsize(TruncateAt.END);
        } else {
            this.hMU.setText(j.a(this, oV, this.hMU.getTextSize()));
        }
        this.hMU.setSelection(this.hMU.getText().length());
        this.hMU.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!oV.equals(charSequence)) {
                    ModRemarkRoomNameUI.this.enableOptionMenu(true);
                }
                if (charSequence.length() > 0) {
                    ModRemarkRoomNameUI.this.hMU.setEllipsize(null);
                } else {
                    ModRemarkRoomNameUI.this.hMU.setEllipsize(TruncateAt.END);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        com.tencent.mm.ui.tools.a.c fj = com.tencent.mm.ui.tools.a.c.d(this.hMU).fj(1, 32);
        fj.uCR = false;
        fj.a(null);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ModRemarkRoomNameUI.this.setResult(0);
                ModRemarkRoomNameUI.this.finish();
                return true;
            }
        });
        a(0, getString(R.l.app_save), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ModRemarkRoomNameUI.this.YC();
                String str = "";
                String AD = com.tencent.mm.k.b.AD();
                if (bi.oW(AD) || !str.matches(".*[" + AD + "].*")) {
                    com.tencent.mm.ui.tools.a.c.d(ModRemarkRoomNameUI.this.hMU).fj(1, 32).a(ModRemarkRoomNameUI.this);
                    return true;
                }
                h.b(ModRemarkRoomNameUI.this.mController.tml, ModRemarkRoomNameUI.this.getString(R.l.invalid_input_character_toast, new Object[]{AD}), ModRemarkRoomNameUI.this.getString(R.l.app_tip), true);
                return false;
            }
        }, s.b.tmX);
        enableOptionMenu(false);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.sFg.c(this.hLO);
    }

    protected final int getLayoutId() {
        return R.i.mod_roomname_and_describle;
    }

    public final void pO(String str) {
        this.hMT = str;
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(R.l.app_tip);
        this.eXe = h.a(actionBarActivity, getString(R.l.contact_info_change_remarkimage_save), false, null);
        aud aud = new aud();
        aud.rbR = new bhz().VO(bi.oV(this.fsV));
        aud.rXc = new bhz().VO(bi.oV(str));
        this.hMV = new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(27, aud);
        this.hLL = true;
        au.HU();
        com.tencent.mm.model.c.FQ().b(this.hMV);
    }

    public final void YX() {
        h.i(this, R.l.settings_modify_name_invalid_less, R.l.settings_modify_name_title);
    }

    public final void YY() {
        h.i(this, R.l.settings_modify_name_invalid_more, R.l.settings_modify_name_title);
    }
}
