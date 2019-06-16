package com.mikeriv.ssui_2016.a2_collage_basecode.drawing;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;

import com.mikeriv.ssui_2016.a2_collage_basecode.baseElement.BaseVisualElement;

public class OvalClip extends BaseVisualElement {
    private RectF rectF;

    /***
     * 椭圆形裁剪，正好位于已经定义好的边界框内
     * @param x x轴坐标
     * @param y y轴坐标
     * @param w 长轴宽
     * @param h 短轴宽
     */
    public OvalClip(float x, float y, float w, float h) {
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
        path.addOval(rectF, Path.Direction.CCW);
        onCanvas.clipPath(path, Region.Op.INTERSECT);
        super.draw(onCanvas);
        onCanvas.restore();
    }
}
