package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.game.d.db;
import com.tencent.mm.plugin.game.model.h;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public class CommonLogicTask extends GWMainProcessTask {
    public static final Creator<CommonLogicTask> CREATOR = new 1();
    public Runnable jGe;
    public Bundle jfZ = new Bundle();
    public int type;

    public final void aaj() {
        if (this.jGe != null) {
            this.jGe.run();
        }
    }

    public final void aai() {
        int i = 0;
        boolean z = true;
        int oH;
        Bundle bundle;
        String str;
        switch (this.type) {
            case 1:
                if (this.jfZ != null) {
                    z = this.jfZ.getBoolean("permission_allow", false);
                    String string = this.jfZ.getString("url");
                    if (!bi.oW(string)) {
                        a.qyl.a(ad.getContext(), string, z);
                        break;
                    } else {
                        x.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
                        return;
                    }
                }
                break;
            case 2:
                if (this.jfZ != null) {
                    int[] intArray = this.jfZ.getIntArray("getConfigStgKey");
                    if (intArray != null && intArray.length != 0) {
                        ArrayList arrayList = new ArrayList();
                        int length = intArray.length;
                        while (i < length) {
                            int i2 = intArray[i];
                            au.HU();
                            arrayList.add(bi.oV((String) c.DT().get(i2, null)));
                            i++;
                        }
                        this.jfZ.putStringArrayList("getConfigStgValue", arrayList);
                        break;
                    }
                    return;
                }
                break;
            case 3:
                if (this.jfZ != null) {
                    WebViewJSSDKFileItem Qq = e.bUX().Qq(this.jfZ.getString("localId"));
                    if (Qq != null) {
                        this.jfZ.putParcelable("item", Qq);
                        break;
                    }
                }
                break;
            case 4:
                oH = oH("WebViewDownLoadFileSwitch");
                if (this.jfZ == null) {
                    this.jfZ = new Bundle();
                }
                bundle = this.jfZ;
                str = "allowDownloadFile";
                if (oH != 1) {
                    z = false;
                }
                bundle.putBoolean(str, z);
                break;
            case 5:
                oH = oH("EnableWebviewScanQRCode");
                bundle = this.jfZ;
                str = "allow_webview_scan";
                if (oH != 1) {
                    z = false;
                }
                bundle.putBoolean(str, z);
                break;
            case 6:
                this.jfZ.putBoolean("has_set_uin", au.HX());
                break;
            case 7:
                ch chVar = new ch();
                com.tencent.mm.pluginsdk.model.e.a(chVar, 1, this.jfZ.getString("image_path", ""));
                com.tencent.mm.sdk.b.a.sFg.m(chVar);
                this.jfZ.putInt("fav_simple_img_result", chVar.bJG.ret);
                break;
            case 8:
                this.jfZ.putString("file_path", aj.Qu(this.jfZ.getString("localId")));
                break;
            case 9:
                String string2 = this.jfZ.getString("game_hv_menu_appid");
                gl glVar = new gl();
                glVar.bPC.nc = 3;
                glVar.bPC.bPE = string2;
                com.tencent.mm.sdk.b.a.sFg.m(glVar);
                this.jfZ.putString("game_hv_menu_pbcache", glVar.bPD.result);
                break;
            case 10:
                db aTN = h.aTL().aTN();
                if (aTN != null) {
                    GameSettingParams gameSettingParams = new GameSettingParams();
                    gameSettingParams.bQE = aTN.dxh;
                    gameSettingParams.bQF = aTN.jOk;
                    this.jfZ.putParcelable("game_setting_params", gameSettingParams);
                    break;
                }
                break;
            case 11:
                com.tencent.mm.plugin.webview.ui.tools.game.c.aa(this.jfZ);
                break;
        }
        ahH();
    }

    private static int oH(String str) {
        int i = 1;
        try {
            return bi.getInt(g.AT().getValue(str), 1);
        } catch (Exception e) {
            x.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: " + str);
            return i;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeBundle(this.jfZ);
    }

    public final void g(Parcel parcel) {
        this.type = parcel.readInt();
        this.jfZ = parcel.readBundle(getClass().getClassLoader());
    }

    CommonLogicTask(Parcel parcel) {
        g(parcel);
    }
}
