package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        PathEffect pathEffect1 = new CornerPathEffect(20);
        paint.setPathEffect(pathEffect1);
        canvas.drawPath(path, paint);



        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect
        PathEffect pathEffect2 = new DiscretePathEffect(30, 5); // deviation 是偏离量
        paint.setPathEffect(pathEffect2);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        PathEffect pathEffect3 = new DashPathEffect(new float[]{10, 17, 3, 20, 7}, 0);
        paint.setPathEffect(pathEffect3);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        PathEffect pathEffect4 = new PathDashPathEffect(path, 40, 0, PathDashPathEffect.Style.TRANSLATE);
        paint.setPathEffect(pathEffect4);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        PathEffect dashEffect = new DashPathEffect(new float[]{20, 10}, 0);
        PathEffect discreteEffect = new DiscretePathEffect(20, 5);
        PathEffect pathEffect5 = new SumPathEffect(dashEffect, discreteEffect);
        paint.setPathEffect(pathEffect5);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第五处：ComposePathEffect
        PathEffect dashEffect1 = new DashPathEffect(new float[]{20, 10}, 0);
        PathEffect discreteEffect2 = new DiscretePathEffect(20, 5);
        PathEffect pathEffect6 = new ComposePathEffect(dashEffect1, discreteEffect2);
        paint.setPathEffect(pathEffect6);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
