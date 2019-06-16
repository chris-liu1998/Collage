package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

import com.mikeriv.ssui_2016.a2_collage_basecode.baseElement.BaseVisualElement;

public abstract class LayoutDrawing extends BaseVisualElement {
    private RectF rectF;

    /***
     *
     * @param x x轴坐标
     * @param y y轴坐标
     * @param w 宽度
     * @param h 高度
     */
    public LayoutDrawing(float x, float y, float w, float h) {
        super(x, y, w, h);
        rectF = new RectF();
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
        super.draw(onCanvas);
        onCanvas.restore();
    }
}
