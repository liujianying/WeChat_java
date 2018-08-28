package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    public static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
    public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    public static final int MINI_PROGRAM__THUMB_LENGHT = 131072;
    private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
    public static final int THUMB_LENGTH_LIMIT = 32768;
    public static final int TITLE_LENGTH_LIMIT = 512;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int sdkVer;
    public byte[] thumbData;
    public String title;

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    final boolean checkArgs() {
        if (getType() == 8 && (this.thumbData == null || this.thumbData.length == 0)) {
            Log.e(TAG, "checkArgs fail, thumbData should not be null when send emoji");
            return false;
        } else if (getType() == 36 && (this.thumbData == null || this.thumbData.length > MINI_PROGRAM__THUMB_LENGHT)) {
            Log.e(TAG, "checkArgs fail, thumbData should not be null or exceed 128kb");
            return false;
        } else if (getType() != 36 && this.thumbData != null && this.thumbData.length > THUMB_LENGTH_LIMIT) {
            Log.e(TAG, "checkArgs fail, thumbData is invalid");
            return false;
        } else if (this.title != null && this.title.length() > TITLE_LENGTH_LIMIT) {
            Log.e(TAG, "checkArgs fail, title is invalid");
            return false;
        } else if (this.description != null && this.description.length() > DESCRIPTION_LENGTH_LIMIT) {
            Log.e(TAG, "checkArgs fail, description is invalid");
            return false;
        } else if (this.mediaObject == null) {
            Log.e(TAG, "checkArgs fail, mediaObject is null");
            return false;
        } else if (this.mediaTagName != null && this.mediaTagName.length() > 64) {
            Log.e(TAG, "checkArgs fail, mediaTagName is too long");
            return false;
        } else if (this.messageAction != null && this.messageAction.length() > 2048) {
            Log.e(TAG, "checkArgs fail, messageAction is too long");
            return false;
        } else if (this.messageExt == null || this.messageExt.length() <= 2048) {
            return this.mediaObject.checkArgs();
        } else {
            Log.e(TAG, "checkArgs fail, messageExt is too long");
            return false;
        }
    }

    public final int getType() {
        return this.mediaObject == null ? 0 : this.mediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            Log.e(TAG, "setThumbImage exception:" + e.getMessage());
        }
    }
}
