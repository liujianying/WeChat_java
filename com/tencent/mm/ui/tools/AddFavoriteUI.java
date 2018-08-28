package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141010", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class AddFavoriteUI extends MMActivity implements e {
    private ProgressDialog eHw = null;
    String filePath = null;
    private ag handler = new 12(this);
    private Intent intent = null;
    Uri uri = null;
    private ag uvA = new 11(this);
    private ch uvx;
    ArrayList<String> uvy = null;
    private ag uvz = new ag() {
        public final void handleMessage(Message message) {
            AddFavoriteUI.this.dismissDialog();
            x.i("MicroMsg.AddFavoriteUI", "dealWithText: %b", new Object[]{Boolean.valueOf(AddFavoriteUI.this.czx())});
        }
    };

    private class a implements Runnable {
        private Uri aMJ;
        private b uvC;

        public a(Uri uri, b bVar) {
            this.aMJ = uri;
            this.uvC = bVar;
        }

        public final void run() {
            AddFavoriteUI.this.filePath = AddFavoriteUI.a(AddFavoriteUI.this, this.aMJ);
            if (bi.oW(AddFavoriteUI.this.filePath) || !new File(AddFavoriteUI.this.filePath).exists()) {
                if (AddFavoriteUI.aaZ(AddFavoriteUI.this.getContentResolver().getType(this.aMJ)) == 2) {
                    AddFavoriteUI.this.filePath = d.a(AddFavoriteUI.this.getContentResolver(), this.aMJ, 1);
                } else {
                    AddFavoriteUI.this.filePath = d.a(AddFavoriteUI.this.getContentResolver(), this.aMJ);
                }
            }
            if (this.uvC != null) {
                this.uvC.czz();
            }
        }
    }

    static /* synthetic */ void f(AddFavoriteUI addFavoriteUI) {
        x.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", new Object[]{addFavoriteUI.filePath});
        int aaZ = aaZ(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (aaZ == -1) {
            x.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            return;
        }
        x.i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithMultiItem msgType is %d", new Object[]{addFavoriteUI.filePath, Integer.valueOf(aaZ)});
        if (aaZ == 8 && !bi.oW(addFavoriteUI.filePath)) {
            addFavoriteUI.bd(aaZ, addFavoriteUI.filePath);
        } else if (s.a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !au.HW() || au.Dr()) {
            ArrayList arrayList;
            Intent intent = new Intent(addFavoriteUI, AddFavoriteUI.class);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            if (bi.cX(addFavoriteUI.uvy)) {
                arrayList = new ArrayList(0);
            } else {
                ArrayList arrayList2 = new ArrayList(addFavoriteUI.uvy.size());
                Iterator it = addFavoriteUI.uvy.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Uri.fromFile(new File((String) it.next())));
                }
                arrayList = arrayList2;
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.addFlags(268435456).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
            intent.setType(addFavoriteUI.getIntent().getType());
            MMWizardActivity.b(addFavoriteUI, new Intent(addFavoriteUI, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(268435456), intent);
            addFavoriteUI.finish();
        } else {
            ch chVar = new ch();
            List<String> list = addFavoriteUI.uvy;
            if (list == null || list.isEmpty()) {
                x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or paths is empty");
                chVar.bJF.bJL = R.l.favorite_fail_argument_error;
            } else if (list.size() > 9) {
                chVar.bJF.bJL = R.l.favorite_fail_images_count_error;
            } else {
                x.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple images), paths %s sourceType %d", new Object[]{list, Integer.valueOf(13)});
                wl wlVar = new wl();
                wr wrVar = new wr();
                for (String str : list) {
                    if (!bi.oW(str)) {
                        vx vxVar = new vx();
                        vxVar.CF(2);
                        vxVar.UP(str);
                        vxVar.kY(true);
                        wlVar.rBI.add(vxVar);
                    }
                }
                wrVar.Vw(q.GF());
                wrVar.Vx(q.GF());
                wrVar.CO(13);
                wrVar.fU(bi.VF());
                wlVar.a(wrVar);
                chVar.bJF.title = "";
                chVar.bJF.bJH = wlVar;
                chVar.bJF.type = 2;
            }
            chVar.bJF.activity = addFavoriteUI;
            chVar.bJF.bJN = new 13(addFavoriteUI);
            chVar.bJF.bJO = new 14(addFavoriteUI);
            au.DF().a(837, addFavoriteUI);
            g.DF().a(new com.tencent.mm.modelsimple.d(1, addFavoriteUI.uvy, addFavoriteUI.cqk()), 0);
            addFavoriteUI.showDialog();
            addFavoriteUI.uvx = chVar;
        }
    }

    static /* synthetic */ void h(AddFavoriteUI addFavoriteUI) {
        x.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", new Object[]{addFavoriteUI.filePath});
        int aaZ = aaZ(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (aaZ == -1) {
            x.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            return;
        }
        x.i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithSimpleItem msgType is %d", new Object[]{addFavoriteUI.filePath, Integer.valueOf(aaZ)});
        if (!bi.oW(addFavoriteUI.filePath)) {
            addFavoriteUI.bd(aaZ, addFavoriteUI.filePath);
        } else if (s.a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !au.HW() || au.Dr()) {
            addFavoriteUI.finish();
            addFavoriteUI.czw();
        } else {
            ch chVar = new ch();
            com.tencent.mm.pluginsdk.model.e.a(chVar, 13, addFavoriteUI.filePath);
            chVar.bJF.activity = addFavoriteUI;
            chVar.bJF.bJN = new 15(addFavoriteUI);
            chVar.bJF.bJO = new 2(addFavoriteUI);
            com.tencent.mm.sdk.b.a.sFg.m(chVar);
        }
    }

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.AddFavoriteUI", "on create");
        super.onCreate(bundle);
        setTitleVisibility(8);
        int a = s.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.xA();
                initView();
                return;
            case 1:
                finish();
                return;
            default:
                x.e("MicroMsg.AddFavoriteUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        x.i("MicroMsg.AddFavoriteUI", "on SaveInstanceState");
        super.onSaveInstanceState(bundle);
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.AddFavoriteUI", "on NewIntent");
        super.onNewIntent(intent);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        x.i("MicroMsg.AddFavoriteUI", "on RestoreInstanceState");
        super.onRestoreInstanceState(bundle);
    }

    protected void onDestroy() {
        x.i("MicroMsg.AddFavoriteUI", "on Destroy");
        au.DF().b(837, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void initView() {
        this.intent = getIntent();
        if (this.intent == null) {
            x.e("MicroMsg.AddFavoriteUI", "launch : fail, intent is null");
            czy();
            finish();
            return;
        }
        String action = this.intent.getAction();
        Bundle aq = s.aq(this.intent);
        if (bi.oW(action)) {
            x.e("MicroMsg.AddFavoriteUI", "launch : fail, action is null");
            czy();
            finish();
            return;
        }
        if (aq != null) {
            Parcelable parcelable = aq.getParcelable("android.intent.extra.STREAM");
            if (parcelable instanceof Uri) {
                this.uri = (Uri) parcelable;
                if (!bi.n(this.uri)) {
                    x.e("MicroMsg.AddFavoriteUI", "launch : fail, not accept, %s", new Object[]{this.uri});
                    czy();
                    finish();
                    return;
                }
            } else if (parcelable != null) {
                x.e("MicroMsg.AddFavoriteUI", "launch : fail, uri check fail, %s", new Object[]{parcelable});
                czy();
                finish();
                return;
            }
        }
        if (action.equals("android.intent.action.SEND")) {
            x.i("MicroMsg.AddFavoriteUI", "send signal: " + action);
            if (this.uri == null) {
                showDialog();
                com.tencent.mm.sdk.f.e.post(new 1(this), "AddFavoriteUI_dealWithTextHandler");
                return;
            }
            showDialog();
            com.tencent.mm.sdk.f.e.post(new a(this.uri, new 8(this)), "AddFavoriteUI_getFilePath");
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && aq != null && aq.containsKey("android.intent.extra.STREAM")) {
            x.i("MicroMsg.AddFavoriteUI", "send multi: %s, mimeType %s", new Object[]{action, getIntent().resolveType(this)});
            if (bi.aG(getIntent().resolveType(this), "").contains("image")) {
                this.uvy = aj(aq);
                if (this.uvy == null || this.uvy.size() == 0) {
                    x.e("MicroMsg.AddFavoriteUI", "launch : fail, filePathList is null");
                    Gf(1);
                    finish();
                    return;
                }
                showDialog();
                com.tencent.mm.sdk.f.e.post(new 9(this), "AddFavoriteUI_dealWithMultiItemHandler");
                return;
            }
            x.e("MicroMsg.AddFavoriteUI", "launch : fail, mimeType not contains image");
            Gf(1);
            finish();
        } else {
            x.e("MicroMsg.AddFavoriteUI", "launch : fail, uri is null");
            czy();
            finish();
        }
    }

    private void czw() {
        Intent intent = new Intent(this, AddFavoriteUI.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", bi.oW(this.filePath) ? null : Uri.fromFile(new File(this.filePath)));
        intent.addFlags(268435456).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
        intent.setType(getIntent().getType());
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(268435456), intent);
    }

    private ArrayList<String> aj(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            x.e("MicroMsg.AddFavoriteUI", "getParcelableArrayList failed");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            int i;
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable == null || !(parcelable instanceof Uri)) {
                x.e("MicroMsg.AddFavoriteUI", "getMultiSendFilePath failed, error parcelable, %s", new Object[]{parcelable});
            } else {
                Uri uri = (Uri) parcelable;
                if (!bi.n(uri) || uri.getScheme() == null) {
                    x.e("MicroMsg.AddFavoriteUI", "unaccepted uri: " + uri);
                } else {
                    String h = bi.h(this, uri);
                    if (!bi.oW(h)) {
                        if (bi.Xh(h) && aaY(h)) {
                            x.i("MicroMsg.AddFavoriteUI", "multisend file path: " + h);
                            arrayList.add(h);
                            i = 1;
                            continue;
                            if (i == 0) {
                                return null;
                            }
                        }
                        x.w("MicroMsg.AddFavoriteUI", "multisend tries to send illegal img: " + h);
                    }
                }
            }
            i = 0;
            continue;
            if (i == 0) {
                return null;
            }
        }
        return arrayList.size() > 0 ? arrayList : null;
    }

    private static boolean aaY(String str) {
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        boolean b = o.b(str, decodeResultLogger);
        if (!b && decodeResultLogger.getDecodeResult() >= 2000) {
            h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 5, decodeResultLogger));
        }
        return b;
    }

    private boolean czx() {
        this.intent = getIntent();
        if (this.intent == null) {
            x.e("MicroMsg.AddFavoriteUI", "intent is null");
            return false;
        }
        String j = s.j(this.intent, "android.intent.extra.TEXT");
        if (j == null || j.length() == 0) {
            x.i("MicroMsg.AddFavoriteUI", "text is null");
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(j));
        wXMediaMessage.description = j;
        Req req = new Req();
        req.transaction = null;
        req.message = wXMediaMessage;
        int type = req.message.getType();
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        bundle.putInt(ConstantsAPI.SDK_VERSION, 620823808);
        bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        if (!au.HW() || au.Dr()) {
            x.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
            finish();
        } else {
            ch chVar = new ch();
            String str = com.tencent.mm.a.e.cq(this.filePath) + "." + com.tencent.mm.a.e.cp(this.filePath);
            if (type == 1) {
                Boolean.valueOf(com.tencent.mm.pluginsdk.model.e.b(chVar, j, 13));
            } else {
                Boolean.valueOf(com.tencent.mm.pluginsdk.model.e.a(chVar, 13, this.filePath, str, ""));
            }
            chVar.bJF.activity = this;
            chVar.bJF.bJN = new 3(this);
            chVar.bJF.bJO = new 4(this);
            this.uvx = chVar;
            List arrayList = new ArrayList();
            arrayList.add(j);
            com.tencent.mm.modelsimple.d dVar = new com.tencent.mm.modelsimple.d(5, arrayList, cqk());
            au.DF().a(837, this);
            g.DF().a(dVar, 0);
            showDialog();
        }
        return true;
    }

    private void bd(int i, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
            return;
        }
        int cm = com.tencent.mm.a.e.cm(str);
        x.i("MicroMsg.AddFavoriteUI", "filelength: [%d]", new Object[]{Integer.valueOf(cm)});
        if (cm == 0) {
            x.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
            Toast.makeText(this, R.l.favorite_file_length_zero, 1).show();
            finish();
        } else if (cm > 26214400) {
            x.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
            Toast.makeText(this, R.l.favorite_too_large, 1).show();
            finish();
        } else if (!au.HW() || au.Dr()) {
            x.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            finish();
            czw();
        } else {
            IMediaObject wXImageObject;
            l dVar;
            List arrayList = new ArrayList();
            arrayList.add(str);
            ch chVar = new ch();
            String str2 = com.tencent.mm.a.e.cq(str) + "." + com.tencent.mm.a.e.cp(str);
            switch (i) {
                case 2:
                    wXImageObject = new WXImageObject();
                    ((WXImageObject) wXImageObject).setImagePath(str);
                    dVar = new com.tencent.mm.modelsimple.d(1, arrayList, cqk());
                    com.tencent.mm.pluginsdk.model.e.a(chVar, 13, str);
                    break;
                case 4:
                    wXImageObject = new WXVideoFileObject(str);
                    dVar = new com.tencent.mm.modelsimple.d(3, arrayList, cqk());
                    String str3 = "";
                    if (!bi.oW(str)) {
                        x.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[]{str2, str3, str, Integer.valueOf(13)});
                        if (new File(str).length() <= ((long) b.AB())) {
                            wl wlVar = new wl();
                            wr wrVar = new wr();
                            vx vxVar = new vx();
                            vxVar.UP(str);
                            vxVar.CF(4);
                            vxVar.UL(com.tencent.mm.a.e.cp(str));
                            vxVar.UQ(null);
                            vxVar.CE(0);
                            vxVar.UB(str2);
                            vxVar.UC(str3);
                            wrVar.Vw(q.GF());
                            wrVar.Vx(q.GF());
                            wrVar.CO(13);
                            wrVar.fU(bi.VF());
                            wlVar.a(wrVar);
                            wlVar.rBI.add(vxVar);
                            chVar.bJF.title = vxVar.title;
                            chVar.bJF.desc = vxVar.title;
                            chVar.bJF.bJH = wlVar;
                            chVar.bJF.type = 4;
                            break;
                        }
                        chVar.bJF.bJL = R.l.favorite_too_large;
                        break;
                    }
                    x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    chVar.bJF.bJL = R.l.favorite_fail_argument_error;
                    break;
                default:
                    wXImageObject = new WXFileObject(str);
                    dVar = new com.tencent.mm.modelsimple.d(4, arrayList, cqk());
                    com.tencent.mm.pluginsdk.model.e.a(chVar, 13, str, str2, "");
                    break;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXImageObject);
            wXMediaMessage.title = new File(str).getName();
            if (bi.oW(null)) {
                wXMediaMessage.description = bi.bF((long) cm);
            } else {
                wXMediaMessage.description = null;
            }
            if (cm < 30720) {
                wXMediaMessage.thumbData = com.tencent.mm.a.e.e(str, 0, -1);
            } else {
                x.i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
            }
            Req req = new Req();
            req.transaction = null;
            req.message = wXMediaMessage;
            Bundle bundle = new Bundle();
            req.toBundle(bundle);
            bundle.putInt(ConstantsAPI.SDK_VERSION, 620823808);
            bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
            bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
            chVar.bJF.activity = this;
            chVar.bJF.bJN = new 5(this);
            chVar.bJF.bJO = new 6(this);
            this.uvx = chVar;
            g.DF().a(837, this);
            g.DF().a(dVar, 0);
            showDialog();
        }
    }

    private String a(Uri uri, Cursor cursor) {
        FileNotFoundException e;
        IOException e2;
        Throwable e3;
        Exception e4;
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                str = cursor.getString(columnIndex);
                if (str != null) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                x.i("MicroMsg.AddFavoriteUI", "vcard file name: " + str);
            }
            cursor.close();
            AssetFileDescriptor openAssetFileDescriptor;
            FileInputStream createInputStream;
            FileOutputStream openFileOutput;
            try {
                openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(uri, "r");
                try {
                    createInputStream = openAssetFileDescriptor.createInputStream();
                    try {
                        byte[] bArr = new byte[((int) openAssetFileDescriptor.getDeclaredLength())];
                        if (createInputStream.read(bArr) > 0) {
                            au.HU();
                            if (c.isSDCardAvailable()) {
                                String str2 = com.tencent.mm.compatible.util.e.bnE + "share";
                                str = com.tencent.mm.compatible.util.e.bnE + "share/" + str;
                                File file = new File(str2);
                                if (!file.exists()) {
                                    file.mkdir();
                                }
                                File file2 = new File(str);
                                if (!file2.exists()) {
                                    file2.createNewFile();
                                }
                                if (com.tencent.mm.a.e.b(str, bArr, bArr.length) == 0) {
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (Throwable e5) {
                                            x.printErrStackTrace("MicroMsg.AddFavoriteUI", e5, e5.getMessage(), new Object[0]);
                                            return str;
                                        }
                                    }
                                    if (openAssetFileDescriptor == null) {
                                        return str;
                                    }
                                    openAssetFileDescriptor.close();
                                    return str;
                                }
                            }
                            deleteFile(str);
                            openFileOutput = openFileOutput(str, 0);
                            try {
                                openFileOutput.write(bArr);
                                openFileOutput.flush();
                                str = getFilesDir().getPath() + "/" + str;
                                if (createInputStream != null) {
                                    try {
                                        createInputStream.close();
                                    } catch (Throwable e52) {
                                        x.printErrStackTrace("MicroMsg.AddFavoriteUI", e52, e52.getMessage(), new Object[0]);
                                        return str;
                                    }
                                }
                                if (openAssetFileDescriptor != null) {
                                    openAssetFileDescriptor.close();
                                }
                                if (openFileOutput == null) {
                                    return str;
                                }
                                openFileOutput.close();
                                return str;
                            } catch (FileNotFoundException e6) {
                                e = e6;
                            } catch (IOException e7) {
                                e2 = e7;
                                x.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                                if (createInputStream != null) {
                                    try {
                                        createInputStream.close();
                                    } catch (Throwable e32) {
                                        x.printErrStackTrace("MicroMsg.AddFavoriteUI", e32, e32.getMessage(), new Object[0]);
                                    }
                                }
                                if (openAssetFileDescriptor != null) {
                                    openAssetFileDescriptor.close();
                                }
                                if (openFileOutput != null) {
                                    openFileOutput.close();
                                }
                                return null;
                            } catch (Exception e8) {
                                e4 = e8;
                                x.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                                if (createInputStream != null) {
                                    try {
                                        createInputStream.close();
                                    } catch (Throwable e322) {
                                        x.printErrStackTrace("MicroMsg.AddFavoriteUI", e322, e322.getMessage(), new Object[0]);
                                    }
                                }
                                if (openAssetFileDescriptor != null) {
                                    openAssetFileDescriptor.close();
                                }
                                if (openFileOutput != null) {
                                    openFileOutput.close();
                                }
                                return null;
                            }
                        }
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (Throwable e3222) {
                                x.printErrStackTrace("MicroMsg.AddFavoriteUI", e3222, e3222.getMessage(), new Object[0]);
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                    } catch (FileNotFoundException e9) {
                        e = e9;
                        openFileOutput = null;
                        try {
                            x.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e.getMessage());
                            if (createInputStream != null) {
                                try {
                                    createInputStream.close();
                                } catch (Throwable e32222) {
                                    x.printErrStackTrace("MicroMsg.AddFavoriteUI", e32222, e32222.getMessage(), new Object[0]);
                                }
                            }
                            if (openAssetFileDescriptor != null) {
                                openAssetFileDescriptor.close();
                            }
                            if (openFileOutput != null) {
                                openFileOutput.close();
                            }
                            return null;
                        } catch (Throwable th) {
                            e32222 = th;
                            if (createInputStream != null) {
                                try {
                                    createInputStream.close();
                                } catch (Throwable e522) {
                                    x.printErrStackTrace("MicroMsg.AddFavoriteUI", e522, e522.getMessage(), new Object[0]);
                                    throw e32222;
                                }
                            }
                            if (openAssetFileDescriptor != null) {
                                openAssetFileDescriptor.close();
                            }
                            if (openFileOutput != null) {
                                openFileOutput.close();
                            }
                            throw e32222;
                        }
                    } catch (IOException e10) {
                        e2 = e10;
                        openFileOutput = null;
                        x.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (Throwable e322222) {
                                x.printErrStackTrace("MicroMsg.AddFavoriteUI", e322222, e322222.getMessage(), new Object[0]);
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        return null;
                    } catch (Exception e11) {
                        e4 = e11;
                        openFileOutput = null;
                        x.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (Throwable e3222222) {
                                x.printErrStackTrace("MicroMsg.AddFavoriteUI", e3222222, e3222222.getMessage(), new Object[0]);
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        e3222222 = th2;
                        openFileOutput = null;
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (Throwable e5222) {
                                x.printErrStackTrace("MicroMsg.AddFavoriteUI", e5222, e5222.getMessage(), new Object[0]);
                                throw e3222222;
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        throw e3222222;
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                    openFileOutput = null;
                    createInputStream = null;
                } catch (IOException e13) {
                    e2 = e13;
                    openFileOutput = null;
                    createInputStream = null;
                    x.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                    if (createInputStream != null) {
                        try {
                            createInputStream.close();
                        } catch (Throwable e32222222) {
                            x.printErrStackTrace("MicroMsg.AddFavoriteUI", e32222222, e32222222.getMessage(), new Object[0]);
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                    return null;
                } catch (Exception e14) {
                    e4 = e14;
                    openFileOutput = null;
                    createInputStream = null;
                    x.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                    if (createInputStream != null) {
                        try {
                            createInputStream.close();
                        } catch (Throwable e322222222) {
                            x.printErrStackTrace("MicroMsg.AddFavoriteUI", e322222222, e322222222.getMessage(), new Object[0]);
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                    return null;
                } catch (Throwable th3) {
                    e322222222 = th3;
                    openFileOutput = null;
                    createInputStream = null;
                    if (createInputStream != null) {
                        try {
                            createInputStream.close();
                        } catch (Throwable e52222) {
                            x.printErrStackTrace("MicroMsg.AddFavoriteUI", e52222, e52222.getMessage(), new Object[0]);
                            throw e322222222;
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (openFileOutput != null) {
                        openFileOutput.close();
                    }
                    throw e322222222;
                }
            } catch (FileNotFoundException e15) {
                e = e15;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
            } catch (IOException e16) {
                e2 = e16;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                x.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                if (createInputStream != null) {
                    try {
                        createInputStream.close();
                    } catch (Throwable e3222222222) {
                        x.printErrStackTrace("MicroMsg.AddFavoriteUI", e3222222222, e3222222222.getMessage(), new Object[0]);
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                return null;
            } catch (Exception e17) {
                e4 = e17;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                x.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e4.getMessage());
                if (createInputStream != null) {
                    try {
                        createInputStream.close();
                    } catch (Throwable e32222222222) {
                        x.printErrStackTrace("MicroMsg.AddFavoriteUI", e32222222222, e32222222222.getMessage(), new Object[0]);
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                return null;
            } catch (Throwable th4) {
                e32222222222 = th4;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                if (createInputStream != null) {
                    try {
                        createInputStream.close();
                    } catch (Throwable e522222) {
                        x.printErrStackTrace("MicroMsg.AddFavoriteUI", e522222, e522222.getMessage(), new Object[0]);
                        throw e32222222222;
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                throw e32222222222;
            }
        }
        return null;
    }

    private static int aaZ(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AddFavoriteUI", "map : mimeType is null");
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.contains("image") || toLowerCase.equals("application/vnd.google.panorama360+jpg")) {
            return 2;
        }
        if (toLowerCase.contains("video")) {
            return 4;
        }
        x.d("MicroMsg.AddFavoriteUI", "map : unknown mimetype, send as file");
        return 8;
    }

    private void czy() {
        Gf(0);
        Toast.makeText(this, R.l.shareimg_get_res_fail, 1).show();
    }

    private void Gf(int i) {
        switch (i) {
            case 1:
                Toast.makeText(this, R.l.shareimg_err_not_support_type, 1).show();
                return;
            default:
                Toast.makeText(this, R.l.shareimg_get_res_fail, 1).show();
                return;
        }
    }

    private void showDialog() {
        getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.app_waiting), true, new 7(this));
    }

    private void dismissDialog() {
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.AddFavoriteUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        dismissDialog();
        if (!(lVar instanceof com.tencent.mm.modelsimple.d)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            if (this.uvx != null) {
                com.tencent.mm.sdk.b.a.sFg.m(this.uvx);
                this.uvx = null;
            }
        } else if (lVar.dJd != null) {
            ol olVar = (ol) ((com.tencent.mm.ab.b) lVar.dJd).dIE.dIL;
            if (olVar != null && !bi.oW(olVar.rsN)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", olVar.rsN);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                finish();
            } else if (this.uvx != null) {
                com.tencent.mm.sdk.b.a.sFg.m(this.uvx);
                this.uvx = null;
            }
        }
    }
}
