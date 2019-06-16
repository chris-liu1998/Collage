package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import com.mikeriv.ssui_2016.a2_collage_basecode.baseElement.BaseVisualElement;


public class SolidBackDrop extends BaseVisualElement {
    private Paint paint;
    private RectF rectF;

    /***
     * 覆盖整个定义区域的纯色背景
     * @param x  x轴坐标
     * @param y  y轴坐标
     * @param w  宽度
     * @param h  高度
     * @param color 填充颜色
     */
    public SolidBackDrop(float x, float y, float w, float h, int color) {
        super(x, y, w, h);
        rectF = new RectF();
        paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL); //画实心
    }

    @Override
    public void draw(Canvas onCanvas) {
        rectF.left = x;
        rectF.right = x + w;
        rectF.top = y;
        rectF.bottom = y + h;
        onCanvas.save();
        Path path = new Path();
        path.addRect(rectF, Path.Direction.CW);
        onCanvas.clipPath(path);
        onCanvas.drawRect(rectF, paint);
        super.draw(onCanvas);
        onCanvas.restore();
    }
}
