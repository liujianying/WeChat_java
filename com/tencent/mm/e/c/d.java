package com.tencent.mm.e.c;

import com.tencent.mm.e.b.g.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class d implements a {
    BlockingQueue<a> bFC = new ArrayBlockingQueue(1024);
    boolean bFD = false;
    String bFE;
    private com.tencent.qqpinyin.voicerecoapi.a bFO;
    private a bFP;
    private FileOutputStream mFileOutputStream;

    public final boolean df(String str) {
        x.i("MicroMsg.SpeexWriter", "initWriter, path: " + str);
        if (str == null) {
            return false;
        }
        this.bFE = str;
        try {
            this.mFileOutputStream = new FileOutputStream(new File(str));
            this.bFO = new com.tencent.qqpinyin.voicerecoapi.a();
            int cEM = this.bFO.cEM();
            if (cEM == 0) {
                return true;
            }
            x.e("MicroMsg.SpeexWriter", "speexInit failed: " + cEM);
            return false;
        } catch (Exception e) {
            if (this.mFileOutputStream != null) {
                try {
                    this.mFileOutputStream.close();
                } catch (IOException e2) {
                }
            }
            x.e("MicroMsg.SpeexWriter", "Error on init file: ", new Object[]{e});
            return false;
        }
    }

    public final int a(a aVar) {
        return a(aVar, 0, false);
    }

    public final int a(a aVar, int i, boolean z) {
        if (this.bFO == null || aVar.buf == null || aVar.bEG == 0) {
            x.e("MicroMsg.SpeexWriter", "try write invalid data to file");
            return -1;
        }
        try {
            byte[] W = this.bFO.W(aVar.buf, aVar.bEG);
            if (W == null || W.length <= 0) {
                x.e("MicroMsg.SpeexWriter", "convert failed: " + (W == null ? "outBuffer is null" : "size is zero"));
                return -1;
            }
            x.d("MicroMsg.SpeexWriter", "write to file, len: %d", new Object[]{Integer.valueOf(W.length)});
            this.mFileOutputStream.write(W);
            this.mFileOutputStream.flush();
            return W.length;
        } catch (Exception e) {
            x.e("MicroMsg.SpeexWriter", "write to file failed", new Object[]{e});
            return -1;
        }
    }

    public final void wA() {
        x.i("MicroMsg.SpeexWriter", "wait Stop");
        synchronized (this) {
            this.bFD = true;
        }
        if (this.bFP != null) {
            try {
                e.U(this.bFP);
                this.bFP = null;
            } catch (InterruptedException e) {
                x.e("MicroMsg.SpeexWriter", "thread speex interrupted");
            }
        }
        if (this.bFO != null) {
            this.bFO.cEN();
            this.bFO = null;
        }
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e2) {
                x.e("MicroMsg.SpeexWriter", "close silk file: " + this.bFE + "msg: " + e2.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    public final boolean wB() {
        if (this.bFO != null) {
            this.bFO.cEN();
            this.bFO = null;
        }
        this.bFO = new com.tencent.qqpinyin.voicerecoapi.a();
        int cEM = this.bFO.cEM();
        if (cEM == 0) {
            return true;
        }
        x.e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: " + cEM);
        return false;
    }

    public static boolean C(String str, String str2) {
        FileInputStream fileInputStream;
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            x.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + file.length());
            try {
                com.tencent.qqpinyin.voicerecoapi.a aVar = new com.tencent.qqpinyin.voicerecoapi.a();
                if (aVar.cEM() != 0) {
                    x.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
                    aVar.cEN();
                    return false;
                }
                com.tencent.mm.a.e.deleteFile(str2);
                File file2 = new File(str2);
                file2.createNewFile();
                file2.setReadable(true);
                try {
                    byte[] bArr = new byte[4096];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    while (true) {
                        try {
                            int read = fileInputStream2.read(bArr);
                            if (read > 0) {
                                byte[] W = aVar.W(bArr, read);
                                if (W == null) {
                                    fileInputStream2.close();
                                    return false;
                                }
                                x.i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + com.tencent.mm.a.e.e(str2, W) + ", readLen = " + read);
                            } else {
                                fileInputStream2.close();
                                aVar.cEN();
                                x.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - currentTimeMillis));
                                return true;
                            }
                        } catch (Exception e) {
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            aVar.cEN();
                            return false;
                        }
                    }
                } catch (Exception e2) {
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    aVar.cEN();
                    return false;
                }
            } catch (Exception e3) {
                x.e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + e3.getMessage());
                return false;
            }
        }
        x.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
        return false;
    }
}
