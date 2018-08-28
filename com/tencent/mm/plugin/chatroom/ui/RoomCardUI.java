package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;

public class RoomCardUI extends MMActivity implements e {
    private p fUo;
    private c hLO = new 2(this);
    private String hMQ;
    private b hMV;
    private String hNf;
    private int hNg;
    private String hNh;
    private boolean hNi;
    private String hNj;
    private String hNk;
    private long hNl;
    private TextView hNm;
    private MMEditText hNn;
    private TextView hNo;
    private TextView hNp;
    private ImageView hNq;
    private LinearLayout hNr;
    private LinearLayout hNs;
    private LinearLayout hNt;
    private LinearLayout hNu;
    private boolean hNv = false;

    static /* synthetic */ void a(RoomCardUI roomCardUI) {
        if (roomCardUI.aAL()) {
            String str = roomCardUI.hNn.getText().toString();
            String AD = com.tencent.mm.k.b.AD();
            if (bi.oW(AD) || !str.matches(".*[" + AD + "].*")) {
                int i;
                int i2;
                roomCardUI.showVKB();
                if (bi.oW(roomCardUI.hNn.getText().toString())) {
                    i = R.l.sure_clear_notice_tip;
                    i2 = R.l.sure_clear_notice_ok;
                } else {
                    i = R.l.notice_all_member_this_notice;
                    i2 = R.l.notice_sure;
                }
                h.a(roomCardUI, i, 0, i2, R.l.notice_cancel, new 9(roomCardUI), new 10(roomCardUI));
                return;
            }
            h.b(roomCardUI.mController.tml, roomCardUI.getString(R.l.invalid_input_character_toast, new Object[]{AD}), roomCardUI.getString(R.l.app_tip), true);
            return;
        }
        roomCardUI.aAN();
    }

    protected final int getLayoutId() {
        return R.i.room_card_ui;
    }

    protected final void initView() {
        setMMTitle(R.l.room_notice_title);
        a(0, getString(R.l.app_edit), new 1(this), s.b.tmX);
        enableOptionMenu(true);
        this.hNt = (LinearLayout) findViewById(R.h.header_notice);
        this.hNu = (LinearLayout) findViewById(R.h.room_notice_only_edit_by_owner_layout);
        this.hNn = (MMEditText) findViewById(R.h.notice_content);
        this.hNo = (TextView) findViewById(R.h.notice_publish_time);
        this.hNp = (TextView) findViewById(R.h.notice_editor_nickname);
        this.hNr = (LinearLayout) findViewById(R.h.room_qr_code);
        this.hNq = (ImageView) findViewById(R.h.notice_editor_avatar_iv);
        this.hNs = (LinearLayout) findViewById(R.h.room_transfer);
        this.hNn.setText(this.hNj);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.hNn.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) - 100);
        j.b(this.hNn, Integer.valueOf(31));
        this.hNm = (TextView) findViewById(R.h.left_word);
        this.hNm.setText(Integer.toString(g.be(280, this.hNj)));
        this.hNs.setVisibility(8);
        this.hNn.setCursorVisible(false);
        this.hNn.setFocusable(false);
        if (this.hNi) {
            this.hNu.setVisibility(8);
        } else {
            removeOptionMenu(0);
            this.hNu.setVisibility(0);
            this.hNn.setFocusable(false);
            this.hNn.setCursorVisible(false);
            this.hNn.setOnLongClickListener(new 3(this));
        }
        if (this.hNl != 0) {
            this.hNo.setVisibility(0);
            this.hNo.setText(com.tencent.mm.pluginsdk.f.h.h("yyyy-MM-dd HH:mm", this.hNl));
        } else {
            this.hNo.setVisibility(8);
        }
        if (bi.oW(this.hNj)) {
            this.hNn.setEnabled(true);
            this.hNn.setFocusableInTouchMode(true);
            this.hNn.setFocusable(true);
            this.hNt.setVisibility(8);
            this.hNn.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) + 100);
            this.hNn.requestFocus();
            this.hNn.setCursorVisible(true);
            updateOptionMenuText(0, this.mController.tml.getString(R.l.app_finish));
            aAM();
            this.hNn.performClick();
            showVKB();
        } else {
            this.hNt.setVisibility(0);
        }
        this.hNp.setText(j.a(this, r.gT(this.hNk), this.hNp.getTextSize()));
        ImageView imageView = this.hNq;
        String str = this.hNk;
        if (bi.oW(str)) {
            imageView.setImageResource(R.g.default_avatar);
        } else {
            a.b.a(imageView, str);
        }
        this.hNn.addTextChangedListener(new a(this, (byte) 0));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.h.mEJ.a(219, 0, 1, true);
        au.DF().a(993, this);
        this.hMQ = getIntent().getStringExtra("RoomInfo_Id");
        this.hNj = getIntent().getStringExtra("room_notice");
        this.hNk = getIntent().getStringExtra("room_notice_editor");
        this.hNl = getIntent().getLongExtra("room_notice_publish_time", 0);
        this.hNf = getIntent().getStringExtra("room_name");
        this.hNg = getIntent().getIntExtra("room_member_count", 0);
        this.hNh = getIntent().getStringExtra("room_owner_name");
        this.hNi = getIntent().getBooleanExtra("Is_RoomOwner", false);
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RoomCardUI.this.goBack();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(993, this);
        if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
        }
    }

    private void goBack() {
        if (!this.hNi) {
            setResult(0);
            finish();
        } else if (aAL()) {
            h.a(this, getString(R.l.room_card_cancel_alert), null, getString(R.l.room_card_cancel_alert_save), getString(R.l.room_card_cancel_alert_cancel), new 7(this), new 8(this));
        } else {
            setResult(0);
            finish();
        }
    }

    private boolean aAL() {
        String obj = this.hNn.getText().toString();
        if (bi.oW(obj)) {
            if (bi.oW(this.hNj)) {
                return false;
            }
            return true;
        } else if (this.hNj == null || !this.hNj.equals(obj)) {
            return true;
        } else {
            return false;
        }
    }

    private void aAM() {
        if (aAL()) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        super.onKeyDown(i, keyEvent);
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        goBack();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1) {
            this.hNi = false;
            if (!this.hNi) {
                this.hNs.setVisibility(8);
                this.hNn.setFocusableInTouchMode(false);
                this.hNn.setFocusable(false);
                this.hNs.setVisibility(8);
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
        }
        if (lVar.getType() == 993) {
            if (this.fUo != null && this.fUo.isShowing()) {
                this.fUo.dismiss();
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
                this.hNj = this.hNn.getText().toString();
                com.tencent.mm.plugin.report.service.h.mEJ.a(219, 15, 1, true);
                aAN();
                return;
            }
            x.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[]{str});
            com.tencent.mm.ui.base.s.makeText(this, R.l.room_save_notice_failed, 1).show();
            x.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        x.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", new Object[]{Integer.valueOf(lVar.getType())});
    }

    private void aAN() {
        Intent intent = new Intent();
        intent.putExtra("room_name", this.hNf);
        intent.putExtra("room_notice", this.hNj);
        setResult(-1, intent);
        finish();
    }
}
