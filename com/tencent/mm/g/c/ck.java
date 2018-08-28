package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.cfz;
import com.tencent.mm.protocal.c.cga;
import com.tencent.mm.protocal.c.chz;
import com.tencent.mm.protocal.c.ob;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class ck extends c {
    private static final int cFO = "appIdHash".hashCode();
    private static final int cFP = "launchAction".hashCode();
    private static final int cFY = "pkgType".hashCode();
    private static final int cFZ = "widgetType".hashCode();
    private static final int cGa = "jsApiInfo".hashCode();
    private static final int cGb = "versionInfo".hashCode();
    private static final int cGc = "widgetSetting".hashCode();
    public static final String[] ciG = new String[0];
    private static final int ciP = "rowid".hashCode();
    private static final int ckP = "appId".hashCode();
    private boolean cFJ = true;
    private boolean cFK = true;
    private boolean cFT = true;
    private boolean cFU = true;
    private boolean cFV = true;
    private boolean cFW = true;
    private boolean cFX = true;
    private boolean cky = true;
    public String field_appId;
    public int field_appIdHash;
    public ob field_jsApiInfo;
    public cfz field_launchAction;
    public int field_pkgType;
    public cga field_versionInfo;
    public chz field_widgetSetting;
    public int field_widgetType;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                byte[] blob;
                if (cFO == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                } else if (ckP == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (cFY == hashCode) {
                    this.field_pkgType = cursor.getInt(i);
                } else if (cFZ == hashCode) {
                    this.field_widgetType = cursor.getInt(i);
                } else if (cFP == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_launchAction = (cfz) new cfz().aG(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e.getMessage());
                    }
                } else if (cGa == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_jsApiInfo = (ob) new ob().aG(blob);
                        }
                    } catch (IOException e2) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
                    }
                } else if (cGb == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_versionInfo = (cga) new cga().aG(blob);
                        }
                    } catch (IOException e22) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e22.getMessage());
                    }
                } else if (cGc == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_widgetSetting = (chz) new chz().aG(blob);
                        }
                    } catch (IOException e222) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e222.getMessage());
                    }
                } else if (ciP == hashCode) {
                    this.sKx = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues wH() {
        ContentValues contentValues = new ContentValues();
        if (this.cFJ) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.cky) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.cFT) {
            contentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
        }
        if (this.cFU) {
            contentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
        }
        if (this.cFK && this.field_launchAction != null) {
            try {
                contentValues.put("launchAction", this.field_launchAction.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e.getMessage());
            }
        }
        if (this.cFV && this.field_jsApiInfo != null) {
            try {
                contentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
            } catch (IOException e2) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
            }
        }
        if (this.cFW && this.field_versionInfo != null) {
            try {
                contentValues.put("versionInfo", this.field_versionInfo.toByteArray());
            } catch (IOException e22) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e22.getMessage());
            }
        }
        if (this.cFX && this.field_widgetSetting != null) {
            try {
                contentValues.put("widgetSetting", this.field_widgetSetting.toByteArray());
            } catch (IOException e222) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e222.getMessage());
            }
        }
        if (this.sKx > 0) {
            contentValues.put("rowid", Long.valueOf(this.sKx));
        }
        return contentValues;
    }
}
