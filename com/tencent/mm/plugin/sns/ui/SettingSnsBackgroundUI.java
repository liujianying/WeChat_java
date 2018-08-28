package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import java.util.LinkedList;

public class SettingSnsBackgroundUI extends MMPreference {
    private SharedPreferences duR;
    private f eOE;
    protected String filePath;

    public final int Ys() {
        return m.settings_sns_background;
    }

    public void onCreate(Bundle bundle) {
        x.d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
        super.onCreate(bundle);
        this.eOE = this.tCL;
        this.duR = getSharedPreferences(ad.chY(), 0);
        initView();
    }

    protected void onNewIntent(Intent intent) {
        x.d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        setResult(-1);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        x.d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
    }

    public void onResume() {
        super.onResume();
        if (this.eOE != null) {
            this.eOE.notifyDataSetChanged();
        }
    }

    private void e(int i, Intent intent) {
        String str;
        switch (i) {
            case 2:
                x.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
                this.filePath = l.d(getApplicationContext(), intent, af.getAccSnsTmpPath());
                if (this.filePath != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_ImgPath", this.filePath);
                    str = "CropImage_OutputPath";
                    intent2.putExtra(str, af.getAccSnsTmpPath() + g.u((this.filePath + System.currentTimeMillis()).getBytes()));
                    a.ezn.a(this, intent2, 6);
                    return;
                }
                return;
            case 5:
                x.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
                if (intent != null) {
                    this.filePath = l.d(getApplicationContext(), intent, af.getAccSnsTmpPath());
                    if (this.filePath != null) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("CropImageMode", 1);
                        intent3.putExtra("CropImage_ImgPath", this.filePath);
                        a.ezn.a(this, intent, intent3, af.getAccSnsTmpPath(), 6, new 1(this));
                        return;
                    }
                    return;
                }
                return;
            case 6:
                x.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
                new ag(Looper.getMainLooper()).post(new 2(this));
                if (intent != null) {
                    this.filePath = intent.getStringExtra("CropImage_OutputPath");
                    if (this.filePath != null) {
                        x.d("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
                        aw byk = af.byk();
                        String str2 = this.filePath;
                        new LinkedList().add(new h(str2, 2));
                        if (!(byk.bxU() == null || byk.bxU().equals(""))) {
                            str = an.s(af.getAccSnsPath(), byk.bxU());
                            FileOp.mL(str);
                            FileOp.deleteFile(str + byk.bxU() + "bg_");
                            FileOp.y(str2, str + byk.bxU() + "bg_");
                            com.tencent.mm.plugin.sns.storage.m bys = af.bys();
                            com.tencent.mm.plugin.sns.storage.l Np = bys.Np(byk.bxU());
                            Np.field_bgId = "";
                            bys.c(Np);
                        }
                        byk.byW();
                        byk.bxU();
                        ax axVar = new ax(7);
                        axVar.eD(str2, "");
                        axVar.wD(1);
                        axVar.commit();
                        setResult(-1);
                        finish();
                        return;
                    }
                    return;
                }
                return;
            default:
                x.e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
                return;
        }
    }

    protected void onActivityResult(final int i, final int i2, final Intent intent) {
        x.i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + i + " " + i2);
        if (i2 == -1) {
            StringBuilder stringBuilder = new StringBuilder("result ok ");
            com.tencent.mm.kernel.g.Ek();
            x.d("MicroMsg.SettingSnsBackgroundUI", stringBuilder.append(com.tencent.mm.kernel.g.Eg().Dx()).toString());
            if (af.bxX()) {
                new ag(Looper.myLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        SettingSnsBackgroundUI.this.e(i, intent);
                    }
                }, 2000);
                return;
            }
            x.d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
            e(i, intent);
        } else if (i == 2 || i == 5 || i == 6) {
            new ag(Looper.getMainLooper()).post(new 3(this));
        }
    }

    protected final void initView() {
        setMMTitle(j.settings_sns_bg_title);
        SnsArtistPreference snsArtistPreference = (SnsArtistPreference) this.eOE.ZZ("settings_sns_bg_select_bg");
        if (snsArtistPreference != null) {
            String string = this.duR.getString("artist_name", "");
            x.d("MicroMsg.SettingSnsBackgroundUI", "artistName" + string);
            snsArtistPreference.nTn = string;
            snsArtistPreference.bCU();
            this.eOE.notifyDataSetChanged();
        }
        setBackBtn(new 5(this));
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.mKey;
        x.i("MicroMsg.SettingSnsBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_sns_bg_select_from_album")) {
            com.tencent.mm.kernel.g.Ek();
            if (com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
                l.a(this, 5, null);
                return true;
            }
            s.gH(this);
            return false;
        } else if (str.equals("settings_sns_bg_take_photo")) {
            com.tencent.mm.kernel.g.Ek();
            if (com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
                x.i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.mController.tml, "android.permission.CAMERA", 16, "", "")), bi.cjd(), this.mController.tml});
                if (!com.tencent.mm.pluginsdk.permission.a.a(this.mController.tml, "android.permission.CAMERA", 16, "", "")) {
                    return false;
                }
                auu();
                return true;
            }
            s.gH(this);
            return false;
        } else if (!str.equals("settings_sns_bg_select_bg")) {
            return false;
        } else {
            startActivity(new Intent(this, ArtistUI.class));
            return true;
        }
    }

    private void auu() {
        if (!l.c(this, e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(j.selectcameraapp_none), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            x.i("MicroMsg.SettingSnsBackgroundUI", "summerper onRequestPermissionsResult grantResults[%s] invalid", new Object[]{iArr});
            return;
        }
        x.i("MicroMsg.SettingSnsBackgroundUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    auu();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(j.permission_camera_request_again_msg), getString(j.permission_tips_title), getString(j.jump_to_settings), getString(j.app_cancel), false, new 6(this), null);
                    return;
                }
            default:
                return;
        }
    }
}
