package com.tencent.mm.plugin.setting.ui.qrcode;

import android.widget.Toast;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;
import java.io.FileOutputStream;

class ShowQRCodeStep1UI$4 implements c {
    final /* synthetic */ ShowQRCodeStep1UI mPK;

    ShowQRCodeStep1UI$4(ShowQRCodeStep1UI showQRCodeStep1UI) {
        this.mPK = showQRCodeStep1UI;
    }

    public final void ju(int i) {
        Throwable e;
        switch (i) {
            case 0:
                this.mPK.bts();
                return;
            case 1:
                ShowQRCodeStep1UI showQRCodeStep1UI = this.mPK;
                byte[] bArr = showQRCodeStep1UI.mPJ;
                if (bArr != null && bArr.length > 0) {
                    String str = l.cfw() + "mmqrcode" + System.currentTimeMillis() + ".png";
                    FileOutputStream fileOutputStream;
                    try {
                        fileOutputStream = new FileOutputStream(str);
                        try {
                            fileOutputStream.write(bArr);
                            Toast.makeText(showQRCodeStep1UI, showQRCodeStep1UI.getString(i.cropimage_saved, new Object[]{str}), 1).show();
                            l.a(str, showQRCodeStep1UI);
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Exception e2) {
                                return;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                x.printErrStackTrace("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return;
                                    } catch (Exception e4) {
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th) {
                                e = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        fileOutputStream = null;
                        x.printErrStackTrace("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Exception e42) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        e = th2;
                        fileOutputStream = null;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e52) {
                            }
                        }
                        throw e;
                    }
                }
                return;
            default:
                return;
        }
    }
}
