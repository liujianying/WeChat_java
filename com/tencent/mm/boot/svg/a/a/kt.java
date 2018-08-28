package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class kt extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
                Paint i2 = c.i(looper);
                i2.setFlags(385);
                i2.setStyle(Style.FILL);
                Paint i3 = c.i(looper);
                i3.setFlags(385);
                i3.setStyle(Style.STROKE);
                i2.setColor(-16777216);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, 76, 4);
                i2 = c.a(i2, looper);
                i2.setColor(-16777216);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(21.964338f, 20.013182f);
                j.cubicTo(22.212938f, 25.142698f, 27.100338f, 24.293186f, 30.98196f, 28.36161f);
                j.cubicTo(33.576435f, 31.080942f, 33.458485f, 36.539135f, 32.543255f, 38.91053f);
                j.cubicTo(30.983482f, 42.951958f, 26.839252f, 43.55849f, 25.701117f, 43.56f);
                j.cubicTo(22.412323f, 43.56436f, 19.888964f, 42.783474f, 18.553532f, 39.851376f);
                j.cubicTo(17.218098f, 36.919273f, 18.215815f, 32.360634f, 15.758889f, 29.729475f);
                j.cubicTo(13.237251f, 27.029016f, 8.037645f, 21.490482f, 10.584166f, 13.047938f);
                j.cubicTo(11.66031f, 9.480171f, 15.53567f, 3.96f, 25.701117f, 3.96f);
                j.cubicTo(34.384438f, 3.96f, 39.990982f, 9.797077f, 38.33459f, 16.339989f);
                j.cubicTo(36.44469f, 23.802822f, 28.639595f, 22.510462f, 28.639595f, 22.510462f);
                j.lineTo(29.06654f, 19.93197f);
                j.cubicTo(29.071892f, 19.932856f, 29.132612f, 19.940847f, 29.24069f, 19.950937f);
                j.cubicTo(30.31777f, 20.051474f, 31.586508f, 19.943724f, 32.71822f, 19.48973f);
                j.cubicTo(34.239017f, 18.879654f, 35.284702f, 17.737019f, 35.800922f, 15.698569f);
                j.cubicTo(37.019463f, 10.88521f, 32.70242f, 6.5736f, 25.701117f, 6.5736f);
                j.cubicTo(18.357351f, 6.5736f, 14.33335f, 9.668696f, 13.086415f, 13.8026905f);
                j.cubicTo(11.744799f, 18.250586f, 12.775491f, 21.91427f, 15.531816f, 25.489357f);
                j.cubicTo(16.142097f, 26.280924f, 16.645678f, 26.84966f, 17.66915f, 27.945711f);
                j.cubicTo(19.303974f, 29.69647f, 19.86245f, 31.586874f, 20.228584f, 34.85312f);
                j.cubicTo(20.24756f, 35.022392f, 20.262926f, 35.16381f, 20.29538f, 35.46539f);
                j.cubicTo(20.49886f, 37.35431f, 20.640348f, 38.1276f, 20.93205f, 38.76807f);
                j.cubicTo(21.661112f, 40.368813f, 22.913269f, 40.950096f, 25.697649f, 40.946404f);
                j.cubicTo(27.312399f, 40.94426f, 29.329237f, 39.97938f, 30.10495f, 37.96948f);
                j.cubicTo(30.934326f, 35.820534f, 30.563622f, 31.709312f, 29.090963f, 30.165781f);
                j.cubicTo(28.590775f, 29.641521f, 28.041868f, 29.193403f, 27.410362f, 28.779465f);
                j.cubicTo(26.99209f, 28.505295f, 26.542843f, 28.248503f, 25.990253f, 27.961823f);
                j.cubicTo(25.672832f, 27.797148f, 24.573006f, 27.250767f, 24.447107f, 27.186813f);
                j.cubicTo(21.124224f, 25.49888f, 19.526281f, 23.698557f, 19.353756f, 20.138744f);
                j.cubicTo(19.178171f, 16.488176f, 21.279713f, 14.188888f, 24.426254f, 13.365055f);
                j.cubicTo(25.706848f, 13.029768f, 26.988028f, 12.96564f, 28.147823f, 13.047379f);
                j.cubicTo(28.317234f, 13.059318f, 28.449696f, 13.072415f, 28.54019f, 13.08362f);
                j.lineTo(28.219015f, 15.677411f);
                j.cubicTo(28.219015f, 15.677411f, 21.717073f, 14.8723135f, 21.964338f, 20.013182f);
                j.close();
                j.moveTo(21.964338f, 20.013182f);
                j.cubicTo(22.212938f, 25.142698f, 27.100338f, 24.293186f, 30.98196f, 28.36161f);
                j.cubicTo(33.576435f, 31.080942f, 33.458485f, 36.539135f, 32.543255f, 38.91053f);
                j.cubicTo(30.983482f, 42.951958f, 26.839252f, 43.55849f, 25.701117f, 43.56f);
                j.cubicTo(22.412323f, 43.56436f, 19.888964f, 42.783474f, 18.553532f, 39.851376f);
                j.cubicTo(17.218098f, 36.919273f, 18.215815f, 32.360634f, 15.758889f, 29.729475f);
                j.cubicTo(13.237251f, 27.029016f, 8.037645f, 21.490482f, 10.584166f, 13.047938f);
                j.cubicTo(11.66031f, 9.480171f, 15.53567f, 3.96f, 25.701117f, 3.96f);
                j.cubicTo(34.384438f, 3.96f, 39.990982f, 9.797077f, 38.33459f, 16.339989f);
                j.cubicTo(36.44469f, 23.802822f, 28.639595f, 22.510462f, 28.639595f, 22.510462f);
                j.lineTo(29.06654f, 19.93197f);
                j.cubicTo(29.071892f, 19.932856f, 29.132612f, 19.940847f, 29.24069f, 19.950937f);
                j.cubicTo(30.31777f, 20.051474f, 31.586508f, 19.943724f, 32.71822f, 19.48973f);
                j.cubicTo(34.239017f, 18.879654f, 35.284702f, 17.737019f, 35.800922f, 15.698569f);
                j.cubicTo(37.019463f, 10.88521f, 32.70242f, 6.5736f, 25.701117f, 6.5736f);
                j.cubicTo(18.357351f, 6.5736f, 14.33335f, 9.668696f, 13.086415f, 13.8026905f);
                j.cubicTo(11.744799f, 18.250586f, 12.775491f, 21.91427f, 15.531816f, 25.489357f);
                j.cubicTo(16.142097f, 26.280924f, 16.645678f, 26.84966f, 17.66915f, 27.945711f);
                j.cubicTo(19.303974f, 29.69647f, 19.86245f, 31.586874f, 20.228584f, 34.85312f);
                j.cubicTo(20.24756f, 35.022392f, 20.262926f, 35.16381f, 20.29538f, 35.46539f);
                j.cubicTo(20.49886f, 37.35431f, 20.640348f, 38.1276f, 20.93205f, 38.76807f);
                j.cubicTo(21.661112f, 40.368813f, 22.913269f, 40.950096f, 25.697649f, 40.946404f);
                j.cubicTo(27.312399f, 40.94426f, 29.329237f, 39.97938f, 30.10495f, 37.96948f);
                j.cubicTo(30.934326f, 35.820534f, 30.563622f, 31.709312f, 29.090963f, 30.165781f);
                j.cubicTo(28.590775f, 29.641521f, 28.041868f, 29.193403f, 27.410362f, 28.779465f);
                j.cubicTo(26.99209f, 28.505295f, 26.542843f, 28.248503f, 25.990253f, 27.961823f);
                j.cubicTo(25.672832f, 27.797148f, 24.573006f, 27.250767f, 24.447107f, 27.186813f);
                j.cubicTo(21.124224f, 25.49888f, 19.526281f, 23.698557f, 19.353756f, 20.138744f);
                j.cubicTo(19.178171f, 16.488176f, 21.279713f, 14.188888f, 24.426254f, 13.365055f);
                j.cubicTo(25.706848f, 13.029768f, 26.988028f, 12.96564f, 28.147823f, 13.047379f);
                j.cubicTo(28.317234f, 13.059318f, 28.449696f, 13.072415f, 28.54019f, 13.08362f);
                j.lineTo(28.219015f, 15.677411f);
                j.cubicTo(28.219015f, 15.677411f, 21.717073f, 14.8723135f, 21.964338f, 20.013182f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
