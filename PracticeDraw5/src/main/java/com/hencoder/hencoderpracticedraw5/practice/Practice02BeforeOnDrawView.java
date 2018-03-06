package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;

public class Practice02BeforeOnDrawView extends AppCompatTextView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF bounds = new RectF();

    public Practice02BeforeOnDrawView(Context context) {
        super(context);
    }

    public Practice02BeforeOnDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02BeforeOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setColor(Color.parseColor("#FFC107"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Layout layout = getLayout();
        bounds.left = layout.getLineLeft(1);
        bounds.right = layout.getLineRight(1);
        bounds.top = layout.getLineTop(1);
        bounds.bottom = layout.getLineBottom(1);
        canvas.drawRect(bounds, paint);
        bounds.left = layout.getLineLeft(layout.getLineCount() - 3);
        bounds.right = layout.getLineRight(layout.getLineCount() - 3);
        bounds.top = layout.getLineTop(layout.getLineCount() - 3);
        bounds.bottom = layout.getLineBottom(layout.getLineCount() - 3);
        canvas.drawRect(bounds, paint);


        super.onDraw(canvas); //放在super.onDraw之前 作为背景 注意TextView的行数
    }
}