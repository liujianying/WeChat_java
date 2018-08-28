package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.c.d.a;
import com.tencent.mm.plugin.appbrand.c.d.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask extends MainProcessTask {
    public static final Creator<JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask> CREATOR = new 5();
    public String appId;
    public String bNH;
    public String dwK;
    private ProgressDialog eHw = null;
    public Runnable fFC;
    l fFa;
    public boolean fVm;
    public int fVn = 0;
    public int fVo = 0;
    public int fVp = 0;
    MMActivity fVq;
    a fVr;
    b fVs;
    public int fhf;
    public String fileId;
    public String fileUrl;
    public String mimeType;

    public JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", new Object[]{Integer.valueOf(this.fVo), Integer.valueOf(this.fVp)});
        if (this.fVo == 1) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
            e.abl().a(this.fVr);
            e.abl().a(this.fVs);
            e.abl();
            com.tencent.mm.plugin.appbrand.c.b.rq(this.bNH);
            this.fVo = 0;
            this.fVp = 1;
            ahH();
            return;
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.appId, this.bNH);
        if (itemByLocalId == null) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
            this.fVp = 1;
            ahH();
            return;
        }
        boolean z;
        com.tencent.mm.plugin.appbrand.c.a aVar = new com.tencent.mm.plugin.appbrand.c.a();
        aVar.bNH = itemByLocalId.bNH;
        aVar.fnM = itemByLocalId.dDG;
        aVar.eyz = itemByLocalId.eyz;
        String str = this.bNH;
        aVar.mediaId = d.a("appbrandmediafile", bi.VF(), str, str);
        e.abk().a(aVar);
        this.fVr = new 1(this);
        this.fVs = new 2(this, itemByLocalId);
        com.tencent.mm.plugin.appbrand.c.b abl = e.abl();
        a aVar2 = this.fVr;
        if (!(abl.fnT == null || aVar2 == null || abl.fnT.contains(aVar2))) {
            abl.fnT.add(aVar2);
        }
        abl = e.abl();
        str = this.appId;
        String str2 = itemByLocalId.bNH;
        int i = com.tencent.mm.modelcdntran.b.dOo;
        b bVar = this.fVs;
        com.tencent.mm.plugin.appbrand.c.a rs = e.abk().rs(str2);
        if (rs == null) {
            x.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str2});
            z = false;
        } else {
            rs.appId = str;
            if (!(bVar == null || abl.fnS == null || bVar == null || abl.fnS.contains(bVar))) {
                abl.fnS.add(bVar);
            }
            rs.fnP = true;
            i iVar = new i();
            iVar.dPV = abl.dVu;
            iVar.ceW = true;
            iVar.field_mediaId = rs.mediaId;
            iVar.field_fullpath = rs.fnM;
            iVar.field_fileType = i;
            iVar.field_talker = "weixin";
            iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
            if (i == com.tencent.mm.modelcdntran.b.dOo) {
                iVar.field_needStorage = true;
            } else {
                iVar.field_needStorage = false;
            }
            iVar.field_isStreamMedia = false;
            iVar.field_appType = 0;
            iVar.field_bzScene = 0;
            iVar.field_force_aeskeycdn = true;
            iVar.field_trysafecdn = false;
            z = g.ND().c(iVar);
            x.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[]{Boolean.valueOf(z), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn), str2});
        }
        x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
            this.fVp = 1;
            e.abl().a(this.fVr);
            e.abl().a(this.fVs);
            e.abl();
            com.tencent.mm.plugin.appbrand.c.b.rq(itemByLocalId.bNH);
            ahH();
        } else if (this.fVm) {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
            this.fVp = 2;
            ahH();
        }
    }

    public final void aaj() {
        if (this.fVp == 0) {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
        } else if (this.fVp == 1) {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (this.fFC != null) {
                this.fFC.run();
            }
        } else if (this.fVp == 2) {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
            MMActivity mMActivity = this.fVq;
            this.fVq.getString(j.app_tip);
            this.eHw = h.a(mMActivity, this.fVq.getString(j.appbrand_jssdk_uploading), true, new 3(this));
            this.eHw.setOnKeyListener(new OnKeyListener() {
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 1) {
                        return false;
                    }
                    Object string;
                    if (TextUtils.isEmpty(JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask.this.mimeType) || !JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask.this.mimeType.contains("video")) {
                        String string2 = JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask.this.fVq.getString(j.appbrand_jssdk_image);
                    } else {
                        string2 = JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask.this.fVq.getString(j.appbrand_jssdk_video);
                    }
                    h.a(JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask.this.fVq, true, JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask.this.fVq.getString(j.appbrand_jssdk_media_file_uploading_tips, new Object[]{string2}), "", JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask.this.fVq.getString(j.appbrand_jssdk_upload_video_cancel), JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask.this.fVq.getString(j.appbrand_jssdk_upload_video_continue), new 1(this), new 2(this));
                    return true;
                }
            });
        } else if (this.fVp == 3) {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
            Map hashMap = new HashMap();
            hashMap.put("tempFilePath", this.bNH);
            hashMap.put("percent", Integer.valueOf(this.fVn));
            String jSONObject = new JSONObject(hashMap).toString();
            com.tencent.mm.plugin.appbrand.jsapi.h a = new JsApiUploadEncryptedFileToCDN.a((byte) 0).a(this.fFa);
            a.mData = jSONObject;
            a.ahM();
        }
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.bNH = parcel.readString();
        this.fileId = parcel.readString();
        this.dwK = parcel.readString();
        this.fileUrl = parcel.readString();
        this.fhf = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.fVm = z;
        this.fVn = parcel.readInt();
        this.fVp = parcel.readInt();
        this.fVo = parcel.readInt();
        this.mimeType = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.bNH);
        parcel.writeString(this.fileId);
        parcel.writeString(this.dwK);
        parcel.writeString(this.fileUrl);
        parcel.writeInt(this.fhf);
        parcel.writeInt(this.fVm ? 1 : 0);
        parcel.writeInt(this.fVn);
        parcel.writeInt(this.fVp);
        parcel.writeInt(this.fVo);
        parcel.writeString(this.mimeType);
    }
}
