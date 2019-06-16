package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.mikeriv.ssui_2016.a2_collage_basecode.baseElement.BaseVisualElement;


public class SimpleFrame extends BaseVisualElement {
    private Paint paint;
    private RectF rectF;

    /**
     * 画空心矩形
     *
     * @param x x轴坐标
     * @param y y轴坐标
     * @param w 宽度
     * @param h 高度
     */
    public SimpleFrame(float x, float y, float w, float h) {
        super(x, y, w, h);
        paint = new Paint();
        rectF = new RectF();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
    }

    @Override
    public void draw(Canvas onCanvas) {
        rectF.left = x;
        rectF.right = x + w;
        rectF.top = y;
        rectF.bottom = y + h;
        onCanvas.drawRect(rectF, paint);
        super.draw(onCanvas);
    }
}
