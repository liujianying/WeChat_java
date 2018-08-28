package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.ar.a;
import com.tencent.mm.ar.b;
import com.tencent.mm.ar.n;
import com.tencent.mm.ar.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsChattingBackgroundUI extends MMPreference {
    private f eOE;
    private boolean mRY;
    private String username;

    static /* synthetic */ void btG() {
        b Qq = r.Qq();
        Cursor b = Qq.dCZ.b("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo  ", null, 0);
        if (b == null) {
            x.i("MicroMsg.SettingsChattingBackgroundUI", "applyToAll : cursor is null");
            return;
        }
        r.Qp();
        if (b.moveToFirst()) {
            a aVar = new a();
            while (!b.isAfterLast()) {
                aVar.d(b);
                e.deleteFile(n.G(aVar.getUsername(), true));
                e.deleteFile(n.G(aVar.getUsername(), false));
                b.moveToNext();
            }
        }
        b.close();
        if (Qq.dCZ.delete("chattingbginfo", null, null) > 0) {
            Qq.doNotify();
        }
    }

    public final int Ys() {
        return k.settings_chatting_background;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 2);
                    intent2.putExtra("CropImage_bg_vertical", hA(true));
                    intent2.putExtra("CropImage_bg_horizontal", hA(false));
                    com.tencent.mm.plugin.setting.b.ezn.a(this, intent, intent2, c.Gb(), 4, null);
                    return;
                }
                return;
            case 2:
                String d = l.d(getApplicationContext(), intent, c.Gb());
                if (d != null) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 2);
                    intent3.putExtra("CropImage_ImgPath", d);
                    intent3.putExtra("CropImage_bg_vertical", hA(true));
                    intent3.putExtra("CropImage_bg_horizontal", hA(false));
                    com.tencent.mm.plugin.setting.b.ezn.a(this, intent3, 4);
                    return;
                }
                return;
            case 3:
                if (i2 != -1) {
                    return;
                }
                break;
            case 4:
                if (i2 == -1) {
                    g.Ei().DT().set(66820, Integer.valueOf(-1));
                    h.mEJ.h(10198, new Object[]{Integer.valueOf(-1)});
                    x.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", new Object[]{Integer.valueOf(-1)});
                    if (!this.mRY) {
                        b Qq = r.Qq();
                        a mw = Qq.mw(this.username);
                        if (mw != null) {
                            mw.ecv = -1;
                            Qq.b(mw);
                            break;
                        }
                        mw = new a();
                        mw.username = this.username;
                        mw.ecv = -1;
                        Qq.a(mw);
                        break;
                    }
                    g.Ei().DT().set(12311, Integer.valueOf(-1));
                    r.Qp().ii(1);
                    break;
                }
                break;
        }
        if (!this.mRY) {
            setResult(-1);
            finish();
        }
    }

    protected final void initView() {
        setMMTitle(i.settings_chatting_bg);
        this.eOE = this.tCL;
        this.mRY = getIntent().getBooleanExtra("isApplyToAll", true);
        if (!this.mRY) {
            Preference ZZ = this.eOE.ZZ("settings_chatting_bg_apply_to_all");
            if (ZZ != null) {
                this.eOE.c(ZZ);
            }
        }
        this.username = getIntent().getStringExtra("username");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsChattingBackgroundUI.this.YC();
                SettingsChattingBackgroundUI.this.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        x.i("MicroMsg.SettingsChattingBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_chatting_bg_select_bg")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsSelectBgUI.class);
            intent.putExtra("isApplyToAll", this.mRY);
            intent.putExtra("username", this.username);
            startActivityForResult(intent, 3);
            return true;
        } else if (str.equals("settings_chatting_bg_select_from_album")) {
            l.a(this, 1, null);
            return true;
        } else if (str.equals("settings_chatting_bg_take_photo")) {
            x.i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.mController.tml, "android.permission.CAMERA", 16, "", "")), bi.cjd(), this.mController.tml});
            if (!com.tencent.mm.pluginsdk.permission.a.a(this.mController.tml, "android.permission.CAMERA", 16, "", "")) {
                return false;
            }
            auu();
            return true;
        } else if (!str.equals("settings_chatting_bg_apply_to_all")) {
            return false;
        } else {
            com.tencent.mm.ui.base.h.a(this.mController.tml, getString(i.settings_chatting_bg_apply_to_all), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsChattingBackgroundUI.btG();
                }
            }, null);
            return true;
        }
    }

    private void auu() {
        if (!l.c(this, com.tencent.mm.compatible.util.e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(i.selectcameraapp_none), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.SettingsChattingBackgroundUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    auu();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(i.permission_camera_request_again_msg), getString(i.permission_tips_title), getString(i.jump_to_settings), getString(i.app_cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SettingsChattingBackgroundUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private String hA(boolean z) {
        r.Qp();
        if (this.mRY) {
            return n.G("default", z);
        }
        return n.G(this.username, z);
    }
}
