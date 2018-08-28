package com.tencent.mm.plugin.gms;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.google.android.gms.auth.a;
import com.google.android.gms.auth.b;
import com.google.android.gms.auth.c;
import com.google.android.gms.auth.d;
import com.tencent.rtmp.TXLiveConstants;
import java.io.IOException;

class MMGoogleAuthUtil$a extends AsyncTask<Void, Void, Void> {
    private String fHW;
    private String fJI;
    final /* synthetic */ MMGoogleAuthUtil kiA;
    private boolean kix = false;
    private boolean kiy;
    private String kiz;
    private Context mContext;
    private int mErrorCode;

    protected final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Void) obj);
        if (!this.kix) {
            Intent intent;
            if (this.kiy) {
                intent = new Intent();
                intent.putExtra("error_code", 0);
                intent.putExtra("token", MMGoogleAuthUtil.a(this.kiA));
                this.kiA.setResult(-1, intent);
                this.kiA.finish();
                return;
            }
            intent = new Intent();
            intent.putExtra("error_code", -1);
            intent.putExtra("error_msg", this.fHW);
            this.kiA.setResult(-1, intent);
            this.kiA.finish();
        }
    }

    public MMGoogleAuthUtil$a(MMGoogleAuthUtil mMGoogleAuthUtil, Context context, String str, String str2) {
        this.kiA = mMGoogleAuthUtil;
        this.mContext = context;
        this.kiz = str;
        this.fJI = str2;
        this.kix = false;
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        this.kiy = false;
    }

    private Void WK() {
        try {
            MMGoogleAuthUtil.a(this.kiA, b.e(this.mContext, this.kiz, this.fJI));
            this.kiy = true;
            this.mErrorCode = 0;
        } catch (c e) {
            this.fHW = e.getMessage();
            this.mErrorCode = -2;
        } catch (d e2) {
            d dVar = e2;
            this.fHW = dVar.getMessage();
            this.mErrorCode = -3;
            if (this.kiA.kiw < 4) {
                MMGoogleAuthUtil mMGoogleAuthUtil = this.kiA;
                mMGoogleAuthUtil.kiw++;
                this.kix = true;
                this.kiA.startActivityForResult(dVar.Hq == null ? null : new Intent(dVar.Hq), TXLiveConstants.PLAY_EVT_RTMP_STREAM_BEGIN);
            }
        } catch (IOException e3) {
            this.fHW = e3.getMessage();
            this.mErrorCode = -4;
        } catch (a e4) {
            this.fHW = e4.getMessage();
            this.mErrorCode = -5;
        } catch (Exception e5) {
            this.fHW = e5.getMessage();
            this.mErrorCode = -1;
        }
        return null;
    }
}
